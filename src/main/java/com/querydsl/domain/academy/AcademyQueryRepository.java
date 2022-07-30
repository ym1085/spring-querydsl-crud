package com.querydsl.domain.academy;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.querydsl.domain.academy.QAcademy.academy;

/**
 * 상속/구현 없는 Repository
 */
@RequiredArgsConstructor
@Repository
public class AcademyQueryRepository {

    private final JPAQueryFactory queryFactory;

    public List<Academy> findAll() {
        return queryFactory
                .selectFrom(academy)
                .orderBy(academy.id.asc())
                .fetch();
    }

    public List<Academy> findByAcademyName(String name) {
        return queryFactory
                .selectFrom(academy)
                .where(academy.academyName.eq(name))
                .fetch();
    }
}
