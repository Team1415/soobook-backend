package com.team1415.soobookbackend.book.infrastructure.entity;

import com.team1415.soobookbackend.common.infrastructure.model.BasePersistenceEntity;
import jakarta.persistence.*;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "translator")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TranslatorPersistenceEntity extends BasePersistenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String introduction;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "book_translator_mapping",
            joinColumns = {@JoinColumn(name = "translator_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")})
    private Set<BookPersistenceEntity> bookPersistenceEntitySet;
}
