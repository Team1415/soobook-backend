package com.team1415.soobookbackend.hashtag.infrastructure.adapter;

import com.team1415.soobookbackend.common.annotation.Adapter;
import com.team1415.soobookbackend.hashtag.domain.Hashtag;
import com.team1415.soobookbackend.hashtag.domain.port.HashtagQueryPort;
import com.team1415.soobookbackend.hashtag.infrastructure.model.mapper.HashtagPersistenceMapper;
import com.team1415.soobookbackend.hashtag.infrastructure.repository.HashtagPersistenceRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Adapter
@RequiredArgsConstructor
public class HashtagQueryPersistenceAdapter implements HashtagQueryPort {

    private final HashtagPersistenceRepository repository;
    private final HashtagPersistenceMapper mapper;

    @Override
    public List<Hashtag> retrieveHashtagListByCategoryId(Long categoryId) {

        return mapper.fromEntityToDomain(repository.findAllByCategoryId(categoryId));
    }
}
