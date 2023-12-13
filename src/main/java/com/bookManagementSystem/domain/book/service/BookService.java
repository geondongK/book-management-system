package com.bookManagementSystem.domain.book.service;

import com.bookManagementSystem.domain.book.dto.request.BookRentalHistoryRequestDto;
import com.bookManagementSystem.domain.book.dto.request.BookRequestDto;
import com.bookManagementSystem.domain.book.dto.response.BookRentalHistoryResponseDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    /* 책 등록 */
    void saveBook(BookRequestDto dto);

    /* 책 수정 */
    void updateBook(@Param("id") int id, BookRequestDto dto);

    /* 책 삭제 */
    void deleteBook(@Param("id") int id);

    /* 책 대출 */
    void checkOut(@Param("id") int book_id, int user_id, BookRentalHistoryRequestDto dto);

    /* 대출이력 */
    List<BookRentalHistoryResponseDto> findBookRental(BookRentalHistoryRequestDto dto);

    /* 책 반납 */
    void returnBook(@Param("id") int book_id, int user_id);


}
