package com.team1415.soobookbackend.common.infrastructure.adapter;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MultipartFileConverter {

    <T> List<T> toPojo(MultipartFile file, Class<T> pojoType);

    boolean isSupport(String fileExtension);
}
