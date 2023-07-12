package com.team1415.soobookbackend.hashtag.infrastructure.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "hashtag")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HashtagPersistenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long categoryId;
    private String name;
}
