package com.bookManagementSystem.domain.book.dto.request;

import com.bookManagementSystem.domain.book.domain.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDto {
    @NotBlank(message = "도서명을 입력해 주세요")
    @Size(message = "도서명은 최대 255자리까지 입력 가능합니다", max = 255)
    private String title; // 도서명
    @NotBlank(message = "해당 도서에 저자를 입력해 주세요")
    @Size(message = "저자 이름은 최대 50자리까지 입력 가능합니다", max = 50)
    private String author; // 저자
    @NotBlank(message = "발행일을 입력해 주세요")
    private String published_date; // 발행일

    public Book toEntity() {
        return Book.builder()
                .title(title)
                .author(author)
                .published_date(published_date)
                .build();
    }
}
