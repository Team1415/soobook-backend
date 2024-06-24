package com.team1415.soobookbackend.query.infrastructure.repository;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.team1415.soobookbackend.common.constant.QueryIdentifier;
import com.team1415.soobookbackend.core.book.infrastructure.model.BookPersistenceEntity;
import com.team1415.soobookbackend.query.dto.RetrieveBookRequestDto;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static com.team1415.soobookbackend.core.book.infrastructure.model.QAuthorPersistenceEntity.authorPersistenceEntity;
import static com.team1415.soobookbackend.core.book.infrastructure.model.QBookCategoryPersistenceEntity.bookCategoryPersistenceEntity;
import static com.team1415.soobookbackend.core.book.infrastructure.model.QBookHashtagPersistenceEntity.bookHashtagPersistenceEntity;
import static com.team1415.soobookbackend.core.book.infrastructure.model.QBookPersistenceEntity.bookPersistenceEntity;
import static com.team1415.soobookbackend.core.book.infrastructure.model.QTranslatorPersistenceEntity.translatorPersistenceEntity;


@Repository
@RequiredArgsConstructor
public class BookInformationQueryDslRepository {

    private final JPAQueryFactory queryFactory;

    public List<BookPersistenceEntity> retrieveBookPersistenceEntityList(RetrieveBookRequestDto retrieveBookRequestDto) {

        return queryFactory.selectFrom(bookPersistenceEntity)
                .innerJoin(bookPersistenceEntity.authorPersistenceEntitySet, authorPersistenceEntity).fetchJoin()
                .innerJoin(bookPersistenceEntity.translatorPersistenceEntitySet, translatorPersistenceEntity).fetchJoin()
                .innerJoin(bookCategoryPersistenceEntity)
                    .on(bookCategoryPersistenceEntity.bookId.eq(bookPersistenceEntity.id))
                .innerJoin(bookHashtagPersistenceEntity)
                    .on(bookHashtagPersistenceEntity.bookId.eq(bookPersistenceEntity.id))
                .where(dynamicConditionByRequestType(retrieveBookRequestDto.getType()),
                        bookIdEq(retrieveBookRequestDto.getBookId()),
                        categoryIdEq(retrieveBookRequestDto.getCategoryId()),
                        hashtagIdIn(retrieveBookRequestDto.getHashtagIds()))
                .orderBy(dynamicOrderBySortOrder(retrieveBookRequestDto.getSort()))
                .fetch();
    }

    private BooleanExpression dynamicConditionByRequestType(String type) {
        if (QueryIdentifier.BookType.NEW.getType().equals(type)) {
            return bookPersistenceEntity.bookPublishPersistenceEntity.publishDatetime.after(LocalDateTime.now().minusMonths(3));
        } else if (QueryIdentifier.BookType.POPULAR.getType().equals(type)) {
            return bookPersistenceEntity.bookPublishPersistenceEntity.publishDatetime.after(LocalDateTime.now().minusMonths(3));
        }
        return null;
    }

    private OrderSpecifier[] dynamicOrderBySortOrder(String sort) {
        if (QueryIdentifier.SortOrder.NEW.getOrder().equals(sort)) {
            return new OrderSpecifier[] { new OrderSpecifier<>(Order.DESC,
                    bookPersistenceEntity.bookPublishPersistenceEntity.publishDatetime) };
        }
        return new OrderSpecifier[] {};
    }

    private BooleanExpression bookIdEq(Long bookId) {
        if (ObjectUtils.isEmpty(bookId)) {
            return null;
        }
        return bookPersistenceEntity.id.eq(bookId);
    }

    private BooleanExpression categoryIdEq(Long categoryId) {
        if (categoryId == null) {
            return null;
        }
        return bookCategoryPersistenceEntity.categoryId.eq(categoryId);
    }

    private BooleanExpression hashtagIdIn(Long[] hashtagIdList) {
        if (ArrayUtils.isEmpty(hashtagIdList)) {
            return null;
        }
        return bookHashtagPersistenceEntity.hashtagId.in(hashtagIdList);
    }

}
