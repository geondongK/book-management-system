package com.bookManagementSystem.domain.book.service;

import com.bookManagementSystem.domain.book.dto.request.BookRentalHistoryRequestDto;
import com.bookManagementSystem.domain.book.dto.request.BookRequestDto;
import com.bookManagementSystem.domain.book.dto.response.BookRentalHistoryResponseDto;
import com.bookManagementSystem.domain.book.mapper.BookMapper;
import com.bookManagementSystem.domain.book.mapper.BookRentalHistoryMapper;
import com.bookManagementSystem.global.exception.GlobalException;
import com.bookManagementSystem.global.exception.GlobalExceptionResponseCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;
    private final BookRentalHistoryMapper bookRentalHistoryMapper;

    /* 등록 */
    @Override
    public void saveBook(BookRequestDto dto) {
        bookMapper.saveBook(dto.toEntity());
    }

    /* 수정 */
    @Override
    public void updateBook(int id, BookRequestDto dto) {
        boolean entity = bookMapper.existsByBook(id);
        if (!entity) throw new GlobalException(GlobalExceptionResponseCode.BOOK_NOT_FOUND);

        bookMapper.updateBook(id, dto.getTitle(), dto.getAuthor(), dto.getPublished_date());
    }

    /* 삭제 */
    @Override
    public void deleteBook(int id) {
        bookMapper.deleteBook(id);
    }

    /* 책 대출 */
    @Override
    public void checkOut(int book_id, int user_id, BookRentalHistoryRequestDto dto) {
        // 독서 존재 유무 true / false
        bookMapper.updateCheckBook(book_id, false);
        // 대출 이력
        bookRentalHistoryMapper.checkOut(book_id, user_id, false, LocalDateTime.now(), dto.getReturn_date());
    }

    /* 대출이력 */
    @Override
    public List<BookRentalHistoryResponseDto> findBookRental(BookRentalHistoryRequestDto dto) {
        List<BookRentalHistoryResponseDto> response = bookRentalHistoryMapper.findBookRental(dto.getName(), dto.getTitle());
        return response;
    }

    /* 책 반납 */
    @Override
    public void returnBook(int book_id, int user_id) {
        // 독서 존재 유무 true / false
        bookMapper.updateCheckBook(book_id, true);
        // 대출 이력
        bookRentalHistoryMapper.returnBook(book_id, user_id);
    }
}
