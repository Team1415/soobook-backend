package com.team1415.soobookbackend.common.infrastructure.adapter;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Component
public class CsvFileConverter implements MultipartFileConverter {

    private static final String MATCHING_EXTENSION = "csv";

    @Override
    public <T> List<T> toPojo(final MultipartFile file, final Class<T> clazz) {
        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));

            return new CsvToBeanBuilder<T>(reader)
                    .withType(clazz)
                    .build()
                    .parse();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isSupport(final String fileExtension) {
        return MATCHING_EXTENSION.equals(fileExtension);
    }

}
