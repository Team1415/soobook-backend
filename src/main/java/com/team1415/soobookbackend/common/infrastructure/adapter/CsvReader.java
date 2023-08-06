package com.team1415.soobookbackend.common.infrastructure.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team1415.soobookbackend.book.infrastructure.model.BookCsvConverter;
import com.team1415.soobookbackend.common.infrastructure.model.CsvConverter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class CsvReader {

    private final CsvConverter csvConverter;

    public CsvReader(CsvConverter csvConverter) {
        this.csvConverter = csvConverter;
    }

    public boolean hasCSVFormat(MultipartFile file) {
        return csvConverter.getType().equals(file.getContentType())
                || Objects.equals(file.getContentType(), "application/vnd.ms-excel");
    }

    public List<? extends CsvConverter> readCSVtoList(MultipartFile file) {

        log.info("CSV Reader helper... saving file");
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(true).setIgnoreHeaderCase(true)
                             .setTrim(true).build())) {

            return csvParser.getRecords().stream().map(csvRecord -> {
                Map<String, Object> csvMap = this.convertCsvRowToMap(csvRecord, csvConverter.getHeaders());
                return new ObjectMapper().convertValue(csvMap, BookCsvConverter.class);
            }).toList();

        } catch (IOException e) {
            log.error("Exception with message :: {}", e.getMessage());
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    private Map<String, Object> convertCsvRowToMap(CSVRecord csvRecord, String[] headers) {

        Map<String, Object> csvMap = new HashMap<>();

        for (String header : headers) {
           csvMap.put(header, csvRecord.get(header));
        }

        return csvMap;
    }

}
