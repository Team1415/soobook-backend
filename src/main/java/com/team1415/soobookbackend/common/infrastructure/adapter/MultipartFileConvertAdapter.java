package com.team1415.soobookbackend.common.infrastructure.adapter;

import com.team1415.soobookbackend.common.annotation.Adapter;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Adapter
public record MultipartFileConvertAdapter(List<MultipartFileConverter> multipartFileConverters) {
    public <T> List<T> toPojo(final MultipartFile file, final Class<T> clazz) {
        final var converter = findConvertByExtension(file);

        return converter.toPojo(file, clazz);
    }

    private MultipartFileConverter findConvertByExtension(final MultipartFile file) {
        final String extension = FilenameUtils.getExtension(file.getOriginalFilename());

        return multipartFileConverters.stream()
                .filter(converter -> converter.isSupport(extension))
                .findAny()
                .orElseThrow(IllegalStateException::new);
    }
}
