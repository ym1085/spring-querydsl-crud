package com.querydsl.domain.academy;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.querydsl.domain.academy.QAcademy.academy;

@Repository
public class AcademyRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public AcademyRepositorySupport(JPAQueryFactory queryFactory) {
        super(Academy.class);
        this.queryFactory = queryFactory;
    }

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
