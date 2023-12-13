package com.bookManagementSystem.domain.book.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {
    private Integer id; // 키본키
    private String title; // 도서명
    private String author; // 저자
    private Boolean exist = Boolean.TRUE; // 도서 존재 여부
    private String published_date; // 발행일
    private final LocalDateTime warehousing_date = LocalDateTime.now(); // 입고일

    @Builder
    public Book(String title, String author, String published_date) {
        this.title = title;
        this.author = author;
        this.published_date = published_date;
    }
}
