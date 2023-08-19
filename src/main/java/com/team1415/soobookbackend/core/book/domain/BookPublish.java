package com.team1415.soobookbackend.core.book.domain;

import java.time.LocalDateTime;

public record BookPublish(
        String publisher,
        Long price,
        Long salePrice,
        String status,
        LocalDateTime publishDatetime,
        String thumbnail) {}
