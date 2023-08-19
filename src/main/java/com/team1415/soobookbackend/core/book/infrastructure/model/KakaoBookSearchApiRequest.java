package com.team1415.soobookbackend.core.book.infrastructure.model;

import lombok.Data;

@Data
public class KakaoBookSearchApiRequest {

    private String query;
    private String sort;
    private Integer page;
    private Integer size;
    private String target;
}
