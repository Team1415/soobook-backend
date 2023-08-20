package com.team1415.soobookbackend.core.hashtag.infrastructure.adapter;

import com.team1415.soobookbackend.common.annotation.Adapter;
import com.team1415.soobookbackend.core.hashtag.infrastructure.model.mapper.HashtagPersistenceMapper;
import com.team1415.soobookbackend.core.hashtag.infrastructure.repository.HashtagPersistenceRepository;
import com.team1415.soobookbackend.core.hashtag.domain.Hashtag;
import com.team1415.soobookbackend.core.hashtag.domain.port.HashtagQueryPort;

import java.util.List;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class HashtagQueryPersistenceAdapter implements HashtagQueryPort {

    private final HashtagPersistenceRepository repository;
    private final HashtagPersistenceMapper mapper;

    @Override
    public List<Hashtag> findAll() {

        return mapper.fromEntityToDomain(repository.findAll());
    }

    @Override
    public List<Hashtag> retrieveHashtagListByCategoryId(Long categoryId) {

        return mapper.fromEntityToDomain(repository.findByCategoryId(categoryId));
    }
}
