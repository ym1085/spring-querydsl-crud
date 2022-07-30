package com.querydsl.domain.academy;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.querydsl.domain.academy.QAcademy.academy;

@RequiredArgsConstructor
public class AcademyRepositoryImpl implements AcademyRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Academy> findByAcademyName(String name) {
        return queryFactory
                .selectFrom(academy)
                .where(academy.academyName.eq(name))
                .fetch();
    }
}
