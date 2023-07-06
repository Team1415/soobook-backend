package com.team1415.soobookbackend.hashtag.infrastructure.repository;

import com.team1415.soobookbackend.hashtag.infrastructure.model.HashtagPersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HashtagPersistenceRepository extends JpaRepository<HashtagPersistenceEntity, Long> {

    List<HashtagPersistenceEntity> findAllByCategoryId(Long categoryId);
}
