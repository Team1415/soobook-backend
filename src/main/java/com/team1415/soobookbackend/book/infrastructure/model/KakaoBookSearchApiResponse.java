package com.team1415.soobookbackend.book.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class KakaoBookSearchApiResponse {

    private Meta meta;

    @JsonProperty("documents")
    private Document[] documents;

    @Data
    public static class Meta {
        @JsonProperty("is_end")
        boolean isEnd;

        @JsonProperty("pageable_count")
        int pageableCount;

        @JsonProperty("total_count")
        int totalCount;
    }

    @Data
    public static class Document {
        private String title;
        private String contents;

        @JsonProperty("url")
        private String bookDetailurl;

        private String isbn;

        @JsonProperty("datetime")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
        private LocalDateTime publishDatetime;

        private String[] authors;
        private String publisher;
        private String[] translators;
        private Integer price;

        @JsonProperty("sale_price")
        private Integer salePrice;

        private String thumbnail;
        private String status;
    }
}
