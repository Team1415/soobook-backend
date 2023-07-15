package com.team1415.soobookbackend.category.infrastructure.adapter;

import com.team1415.soobookbackend.category.domain.Category;
import com.team1415.soobookbackend.category.domain.port.CategoryQueryPort;
import com.team1415.soobookbackend.category.infrastructure.model.mapper.CategoryPersistenceMapper;
import com.team1415.soobookbackend.category.infrastructure.repository.CategoryPersistenceRepository;
import com.team1415.soobookbackend.common.annotation.Adapter;
import java.util.List;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class CategoryQueryPersistenceAdapter implements CategoryQueryPort {

    private final CategoryPersistenceRepository repository;
    private final CategoryPersistenceMapper mapper;

    @Override
    public List<Category> findAll() {

        return mapper.fromEntityToDomain(repository.findAll());
    }
}
