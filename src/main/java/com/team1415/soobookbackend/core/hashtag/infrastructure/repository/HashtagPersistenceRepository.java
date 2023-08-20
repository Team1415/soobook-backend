package com.team1415.soobookbackend.core.hashtag.infrastructure.repository;

import com.team1415.soobookbackend.core.hashtag.infrastructure.model.HashtagPersistenceEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashtagPersistenceRepository
        extends JpaRepository<HashtagPersistenceEntity, Long> {

    List<HashtagPersistenceEntity> findByCategoryId(Long categoryId);
}
