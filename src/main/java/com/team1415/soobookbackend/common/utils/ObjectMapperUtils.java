package com.team1415.soobookbackend.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class ObjectMapperUtils {
    public static final ObjectMapper GLOBAL_OBJECT_MAPPER = JsonMapper.builder()
        .configure(DeserializationFeature.USE_LONG_FOR_INTS, true)
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true)
        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
        .build();

    public static <T>String toJson(T object) throws JsonProcessingException {
        return GLOBAL_OBJECT_MAPPER.writeValueAsString(object);
    }
}
