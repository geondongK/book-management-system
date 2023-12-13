package com.bookManagementSystem.domain.book.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookRentalHistory {
    private Boolean return_book;
    private LocalDateTime rental_date; // 대여일
    private String return_date; // 반납일

}
