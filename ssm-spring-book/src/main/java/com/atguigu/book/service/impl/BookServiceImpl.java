package com.atguigu.book.service.impl;

import com.atguigu.book.mapper.BookMapper;
import com.atguigu.book.pojo.Book;
import com.atguigu.book.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getBookList() {
        return bookMapper.getBookList();
    }

    @Override
    public Book getBook(Integer id) {
        return bookMapper.getBook(id);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }

    @Override
    public PageInfo<Book> getPageInfo(Integer pageNo) {
        // 1、确定每页显示数据的条数
        int pageSize = 10;
        // 2、设定分页数据：开启分页功能。开启后，后面执行的 SELECT 语句会自动被附加 LIMIT 子句，
        // 而且会自动查询总记录数
        PageHelper.startPage(pageNo, pageSize);
        // 3、正常执行查询
        List<Book> bookList = this.getBookList();
        // 4、封装为 PageInfo 对象返回
        return new PageInfo<>(bookList);
    }

}
