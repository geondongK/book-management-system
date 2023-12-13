package com.bookManagementSystem.domain.book.mapper;

import com.bookManagementSystem.domain.book.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BookMapper {
    /* 등록 */
    void saveBook(Book dto);

    /* 수정 */
    void updateBook(@Param("id") int id, @Param("title") String title, @Param("author") String author,
                    @Param("published_date") String published_date);

    /* 삭제 */
    void deleteBook(int id);

    /* 도서 유무 체크 */
    boolean existsByBook(int id);

    /* 도서 대출 */
    void updateCheckBook(@Param("id") int book_id, @Param("exist") Boolean exist);

}
