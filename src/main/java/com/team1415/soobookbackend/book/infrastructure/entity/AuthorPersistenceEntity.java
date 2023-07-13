package com.team1415.soobookbackend.book.infrastructure.entity;

import com.team1415.soobookbackend.common.infrastructure.model.BasePersistenceEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Getter
@Table(name = "author")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthorPersistenceEntity extends BasePersistenceEntity {

    @Id
    private Long id;
    private String name;
    private String introduction;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "book_author_mapping",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "author_id") })
    private Set<BookPersistenceEntity> bookPersistenceEntitySet;
}
