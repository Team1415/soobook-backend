package com.team1415.soobookbackend.book.infrastructure.adapter;

import com.team1415.soobookbackend.book.infrastructure.model.KakaoBookSearchApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Component
public class KakaoBookSearchApi {

    @Value("${KAKAO-API-KEY}")
    String apiKey;

    private static final String URL = "https://dapi.kakao.com/v3/search/book";

    public KakaoBookSearchApiResponse search(String query) {

        // 검색어 인코딩
        String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", StringUtils.join("KakaoAK ", apiKey));

        UriComponentsBuilder builder =
                UriComponentsBuilder.fromHttpUrl(URL).queryParam("query", encodedQuery);
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate
                .exchange(
                        builder.toUriString(),
                        HttpMethod.GET,
                        entity,
                        KakaoBookSearchApiResponse.class)
                .getBody();
    }
}
