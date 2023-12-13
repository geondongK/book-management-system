package com.bookManagementSystem.domain.book.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookRentalHistoryRequestDto {
    private Boolean exist; // 도서 존재 여부
    private Boolean return_book; // 반납 여부
    private String name; // 유저 이름
    private String title; // 독서 제목
    @NotBlank(message = "반납일을 입력해 주세요")
    private String return_date; // 반납일
}
