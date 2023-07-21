package com.team1415.soobookbackend.book.infrastructure.model;

import com.team1415.soobookbackend.common.infrastructure.model.BasePersistenceEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Getter
@SuperBuilder
@Table(name = "author")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthorPersistenceEntity extends BasePersistenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String introduction;

    @ManyToMany(mappedBy = "authorPersistenceEntitySet")
    private Set<BookPersistenceEntity> bookPersistenceEntitySet;

    @SuppressWarnings(value = "java:S3252")
    public static AuthorPersistenceEntity createByBook(String name, String introduction) {
        return AuthorPersistenceEntity.builder().name(name).introduction(introduction).build();
    }
}
