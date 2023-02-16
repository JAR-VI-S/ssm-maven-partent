package com.atguigu.book.service;

import com.atguigu.book.pojo.Book;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BookService {
    List<Book> getBookList();
    Book getBook(Integer id);
    void updateBook(Book book);
    PageInfo<Book> getPageInfo(Integer pageNo);
}
