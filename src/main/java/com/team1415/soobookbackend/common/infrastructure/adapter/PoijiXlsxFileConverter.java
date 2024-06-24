package com.team1415.soobookbackend.common.infrastructure.adapter;

import com.poiji.bind.Poiji;
import com.poiji.exception.PoijiExcelType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class PoijiXlsxFileConverter implements MultipartFileConverter {

    private static final String MATCHING_EXTENSION_XLSX = "xlsx";

    @Override
    public <T> List<T> toPojo(final MultipartFile multipartFile, final Class<T> clazz) {
        try {
            return Poiji.fromExcel(multipartFile.getInputStream(), PoijiExcelType.XLSX, clazz);
        } catch (IOException e) {
            log.error("Error : {}", e.toString());
        }
        return new ArrayList<>();
    }

    @Override
    public boolean isSupport(final String fileExtension) {
        return MATCHING_EXTENSION_XLSX.equals(fileExtension);
    }
}
