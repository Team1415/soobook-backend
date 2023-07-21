package com.team1415.soobookbackend.book.infrastructure.model;

import com.team1415.soobookbackend.common.infrastructure.model.BasePersistenceEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    private Long bookId;
    private Long hashtagId;
}
