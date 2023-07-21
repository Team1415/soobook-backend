package com.team1415.soobookbackend.book.infrastructure.adapter;

import com.team1415.soobookbackend.book.domain.BookInformation;
import com.team1415.soobookbackend.book.domain.port.BookApiQueryPort;
import com.team1415.soobookbackend.book.infrastructure.model.mapper.BookRestMapper;
import com.team1415.soobookbackend.common.annotation.Adapter;
import java.util.List;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class BookQueryRestAdapter implements BookApiQueryPort {

    private final KakaoBookSearchApi kakaoBookSearchApi;
    private final BookRestMapper bookRestMapper;

    @Override
    public List<BookInformation> retrieveBookInformationList(String query) {
        return bookRestMapper.toDomainList(
                Stream.of(kakaoBookSearchApi.search(query).getDocuments()).toList());
    }
}
