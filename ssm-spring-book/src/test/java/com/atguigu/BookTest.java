package com.atguigu;

import com.atguigu.book.pojo.Book;
import com.atguigu.book.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/13 16:30
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class BookTest {
    @Autowired
    private BookService bookService;
    @Test
    public void test(){
        List<Book> bookList = bookService.getBookList();
        System.out.println(bookList);
    }
}
