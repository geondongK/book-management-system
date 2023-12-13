package com.bookManagementSystem.domain.book.mapper;

import com.bookManagementSystem.domain.book.dto.response.BookRentalHistoryResponseDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface BookRentalHistoryMapper {
    /* 책 대출 */
    void checkOut(@Param("book_id") int book_id, @Param("user_id") int user_id, @Param("return_book") Boolean return_book,
                  @Param("rental_date") LocalDateTime rental_date, @Param("return_date") String return_date);

    /* 대출이력 */
    List<BookRentalHistoryResponseDto> findBookRental(@Param("name") String name, @Param("title") String title);

    /* 책 반납 */
    void returnBook(@Param("book_id") int book_id, @Param("user_id") int user_id);


}
