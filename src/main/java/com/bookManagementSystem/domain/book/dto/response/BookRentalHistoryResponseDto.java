package com.bookManagementSystem.domain.book.dto.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BookRentalHistoryResponseDto {
    private Integer book_id; // 대출 도서 키본키
    private Integer user_id; // 대출 도서 유저 키본키
    private String name; // 유저 이름
    private String email; // 유저 이메일
    private String address; // 유저 주소
    private String address_detail; // 유저 상세주소
    private String phone_number; // 전화번호
    private String title; // 도서 제목
    private String author; // 도서 저자
    private Boolean return_book; // 반납 여부
    private LocalDateTime rental_date; // 대여일
    private String return_date; // 반납일

    public BookRentalHistoryResponseDto(Integer book_id, Integer user_id, String name, String email, String address, String address_detail,
                                        String phone_number, String title, String author, Boolean return_book, LocalDateTime rental_date, String return_date
    ) {
        this.book_id = book_id;
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.address_detail = address_detail;
        this.phone_number = phone_number;
        this.title = title;
        this.author = author;
        this.return_book = return_book;
        this.rental_date = rental_date;
        this.return_date = return_date;
    }
}
