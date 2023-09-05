package com.team1415.soobookbackend.query.infrastructure.repository;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.team1415.soobookbackend.query.dto.BookClassificationResponseDto;
import com.team1415.soobookbackend.query.dto.CategoryInfomationResponseDto;
import com.team1415.soobookbackend.query.dto.HashtagInformationResponseDto;
import com.team1415.soobookbackend.query.dto.RetrieveBookClassificationRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.team1415.soobookbackend.core.book.infrastructure.model.QBookCategoryPersistenceEntity.bookCategoryPersistenceEntity;
import static com.team1415.soobookbackend.core.book.infrastructure.model.QBookHashtagPersistenceEntity.bookHashtagPersistenceEntity;
import static com.team1415.soobookbackend.core.category.infrastructure.model.QCategoryPersistenceEntity.categoryPersistenceEntity;
import static com.team1415.soobookbackend.core.hashtag.infrastructure.model.QHashtagPersistenceEntity.hashtagPersistenceEntity;

@Repository
@RequiredArgsConstructor
public class BookClassificationQueryDslRepository {

    private final JPAQueryFactory queryFactory;

    public List<BookClassificationResponseDto> retrieveBookClassificationInformationListByBookId(Long bookId) {
        return this.retrieveBookClassificationInformationSelectFromQuery()
                .where(bookHashtagPersistenceEntity.bookId.eq(bookId))
                .fetch();
    }

    public List<BookClassificationResponseDto> retrieveBookClassificationInformationListByBookIdList(List<Long> bookIdList) {

        return this.retrieveBookClassificationInformationSelectFromQuery()
                .where(bookHashtagPersistenceEntity.bookId.in(bookIdList))
                .fetch();
    }

    public List<HashtagInformationResponseDto> retrieveHashtagInformationList(
            RetrieveBookClassificationRequestDto bookClassificationRequestDto) {

        return queryFactory.select(Projections.fields(HashtagInformationResponseDto.class,
                        hashtagPersistenceEntity.id,
                        hashtagPersistenceEntity.name))
                .from(hashtagPersistenceEntity)
                .innerJoin(categoryPersistenceEntity)
                    .on(hashtagPersistenceEntity.categoryId.eq(categoryPersistenceEntity.id))
                .where(hashtagCategoryIdEq(bookClassificationRequestDto.getCategoryId()))
                .orderBy(dynamicOrderBySortOrder(bookClassificationRequestDto.getSort()))
                .fetch();
    }

    public List<CategoryInfomationResponseDto> retrieveCategoryInformationListByCategoryId(Long categoryId) {

        return queryFactory.select(Projections.fields(CategoryInfomationResponseDto.class,
                        categoryPersistenceEntity.id,
                        categoryPersistenceEntity.name,
                        Projections.list(bookCategoryPersistenceEntity.bookId),
                        Projections.list(Projections.fields(HashtagInformationResponseDto.class,
                                hashtagPersistenceEntity.id,
                                hashtagPersistenceEntity.name))))
                .from(categoryPersistenceEntity)
                .leftJoin(bookCategoryPersistenceEntity)
                    .on(bookCategoryPersistenceEntity.categoryId.eq(categoryPersistenceEntity.id))
                .leftJoin(hashtagPersistenceEntity)
                    .on(hashtagPersistenceEntity.categoryId.eq(categoryPersistenceEntity.id))
                .where(categoryPersistenceEntity.id.eq(categoryId))
                .fetch();
    }

    private JPAQuery<BookClassificationResponseDto> retrieveBookClassificationInformationSelectFromQuery() {

        return queryFactory.select(Projections.constructor(BookClassificationResponseDto.class,
                        bookHashtagPersistenceEntity.bookId,
                        Projections.constructor(HashtagInformationResponseDto.class,
                                bookHashtagPersistenceEntity.bookId,
                                hashtagPersistenceEntity.name)))
                .from(bookHashtagPersistenceEntity)
                .innerJoin(hashtagPersistenceEntity)
                .on(hashtagPersistenceEntity.id.eq(bookHashtagPersistenceEntity.hashtagId));
    }

    private OrderSpecifier[] dynamicOrderBySortOrder(String sort) {
        // TODO 인기 분류 관련 로직 추가
        return new OrderSpecifier[] {};
    }

    private BooleanExpression hashtagCategoryIdEq(Long categoryId) {
        if (categoryId == null) {
            return null;
        }
        return hashtagPersistenceEntity.categoryId.eq(categoryId);
    }
}
