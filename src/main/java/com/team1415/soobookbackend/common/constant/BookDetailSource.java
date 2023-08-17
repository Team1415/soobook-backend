package com.team1415.soobookbackend.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;

import java.util.List;

@Getter
@AllArgsConstructor
public enum BookDetailSource {

    YES24("yes24", "www.yes24.com"),
    INTERPARK("interpark", "book.interpark.com");

    String source;
    String domain;

    public static String getMatchedSourceByUrl(String url) {

        for (BookDetailSource bookDetailSource : BookDetailSource.values()) {
            if (StringUtils.contains(url, bookDetailSource.getDomain())) {
                return bookDetailSource.getSource();
            }
        }
        return Strings.EMPTY;
    }

}
