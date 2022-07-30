package com.querydsl.domain.academy;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Academy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String academyName;
    private String academyAddress;

    @Builder
    public Academy(String academyName, String academyAddress) {
        this.academyName = academyName;
        this.academyAddress = academyAddress;
    }
}
