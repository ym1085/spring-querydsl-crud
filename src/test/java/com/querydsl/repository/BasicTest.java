package com.querydsl.repository;

import com.querydsl.domain.academy.Academy;
import com.querydsl.domain.academy.AcademyQueryRepository;
import com.querydsl.domain.academy.AcademyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("아카데미 기본 테스트")
@Transactional
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BasicTest {

    @Autowired
    private AcademyRepository academyRepository;

    @Autowired
    private AcademyQueryRepository academyQueryRepository;

    @BeforeEach
    public void before() {
        Academy academyA = new Academy("Ezen", "ezen@gmail.com");
        Academy academyB = new Academy("BootCamp", "bootcamp@gmail.com");
        Academy academyC = new Academy("Sparta", "sparta@gmail.com");
        Academy academyD = new Academy("Saffy", "saffy@gmail.com");
        Academy academyE = new Academy("Hello", "hello@gmail.com");

        academyRepository.save(academyA);
        academyRepository.save(academyB);
        academyRepository.save(academyC);
        academyRepository.save(academyD);
        academyRepository.save(academyE);
    }

    @Test
    @DisplayName("전체 회원 조회")
    public void test() throws Exception {
        //when
        List<Academy> result = academyQueryRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("회원 이름 기반 조회")
    public void findByUserName() throws Exception {
        //given
        String academyName = "BootCamp";
        String academyAddress = "bootcamp@gmail.com";

        //when
        List<Academy> result = academyQueryRepository.findByAcademyName(academyName);

        //then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getAcademyAddress()).isEqualTo(academyAddress);
    }
}
