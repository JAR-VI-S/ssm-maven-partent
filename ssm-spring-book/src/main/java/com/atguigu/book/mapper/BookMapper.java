package com.atguigu.book.mapper;

import com.atguigu.book.pojo.Book;

import java.util.List;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/13 16:19
 */
public interface BookMapper {
    List<Book> getBookList();
    Book getBook(Integer id);
    void updateBook(Book book);
}
