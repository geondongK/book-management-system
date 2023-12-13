package com.bookManagementSystem.domain.book.controller;

import com.bookManagementSystem.domain.book.dto.request.BookRentalHistoryRequestDto;
import com.bookManagementSystem.domain.book.dto.request.BookRequestDto;
import com.bookManagementSystem.domain.book.dto.response.BookRentalHistoryResponseDto;
import com.bookManagementSystem.domain.book.service.BookService;
import com.bookManagementSystem.global.common.response.CommonResponse;
import com.bookManagementSystem.global.common.response.ListResponse;
import com.bookManagementSystem.global.common.response.ResponseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookService bookService;
    private final ResponseService responseService; // 응답 Response

    /* 등록 */
    @PostMapping("/book")
    public CommonResponse saveBook(@RequestBody @Valid BookRequestDto dto) {
        // log.info("saveBooktitle = {}", dto.getTitle());
        bookService.saveBook(dto);
        return responseService.getSuccessResponse();
    }

    /* 수정 */
    @PutMapping("/book/{id}")
    public CommonResponse updateBook(@PathVariable(name = "id") int id, @RequestBody @Valid BookRequestDto dto) {
        bookService.updateBook(id, dto);
        return responseService.getSuccessResponse();
    }

    /* 삭제 */
    @DeleteMapping("/book/{id}")
    public CommonResponse deleteBook(@PathVariable(name = "id") int id) {
        bookService.deleteBook(id);
        return responseService.getSuccessResponse();
    }

    /* 책 대출 */
    @PostMapping("/book/check-out/{id}")
    public CommonResponse checkOut(@PathVariable(name = "id") int book_id, Authentication authentication, @RequestBody @Valid BookRentalHistoryRequestDto dto) {
        bookService.checkOut(book_id, Integer.parseInt(authentication.getName()), dto);
        return responseService.getSuccessResponse();
    }

    /* 대출이력 */
    @GetMapping("/book/rental-history")
    public ListResponse<BookRentalHistoryResponseDto> findBookRental(@RequestBody BookRentalHistoryRequestDto dto) {
        List<BookRentalHistoryResponseDto> response = bookService.findBookRental(dto);
        return responseService.getListResponse(response);
    }

    /* 책 반납 */
    @PostMapping("/book/return-book/{id}")
    public CommonResponse returnBook(@PathVariable(name = "id") int book_id, Authentication authentication) {
        bookService.returnBook(book_id, Integer.parseInt(authentication.getName()));
        return responseService.getSuccessResponse();
    }
}
