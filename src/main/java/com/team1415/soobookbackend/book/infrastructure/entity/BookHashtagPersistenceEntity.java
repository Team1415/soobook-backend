package com.team1415.soobookbackend.book.infrastructure.entity;

import com.team1415.soobookbackend.common.infrastructure.model.BasePersistenceEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "book_hashtag_mapping")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookHashtagPersistenceEntity extends BasePersistenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long book_id;
    private Long hashtag_id;
}
