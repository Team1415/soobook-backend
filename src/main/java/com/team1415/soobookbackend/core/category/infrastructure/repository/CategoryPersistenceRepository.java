package com.team1415.soobookbackend.core.category.infrastructure.repository;

import com.team1415.soobookbackend.core.category.infrastructure.model.CategoryPersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryPersistenceRepository
        extends JpaRepository<CategoryPersistenceEntity, Long> {}
