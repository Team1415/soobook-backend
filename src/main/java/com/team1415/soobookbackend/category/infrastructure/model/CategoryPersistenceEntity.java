package com.team1415.soobookbackend.category.infrastructure.model;

import com.team1415.soobookbackend.common.infrastructure.model.BasePersistenceEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "category")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryPersistenceEntity extends BasePersistenceEntity {

    @Id
    private Long id;
    private String name;
}
