package com.team1415.soobookbackend.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QueryIdentifier {

    @Getter
    @AllArgsConstructor
    public enum BookType {
        NEW("new", "신간"),
        POPULAR("popular", "인기");

        private final String type;
        private final String typeName;
    }

    @Getter
    @AllArgsConstructor
    public enum SortOrder {
        NEW("new", "신간"),
        POPULAR("popular", "인기");

        private final String order;
        private final String orderName;
    }
}
