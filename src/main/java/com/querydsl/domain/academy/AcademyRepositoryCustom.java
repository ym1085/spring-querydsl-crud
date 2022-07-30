package com.querydsl.domain.academy;

import java.util.List;

public interface AcademyRepositoryCustom {

    List<Academy> findByAcademyName(String name);

}
