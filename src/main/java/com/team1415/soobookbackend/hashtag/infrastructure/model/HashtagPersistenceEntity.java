package com.team1415.soobookbackend.hashtag.infrastructure.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "hashtag")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HashtagPersistenceEntity {

    @Id
    private Long id;
    private Long category_id;
    private String name;
}
