package com.atguigu.book.controller;

import com.atguigu.book.pojo.Book;
import com.atguigu.book.service.BookService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private static final String PAGE_INDEX = "index";

    @Autowired
    private BookService bookService;
/*
* 注：这里当第一次页面发过来请求时 默认pageNo为null
* 这里设置requestMapping多个value值，对应pageNo有值和无值的情况都会被index方法接收
* 再设置index方法形参里的pageNo属性  @ @PathVariable(value = "pageNo",required = false)  即可应对解决首次pageNo为null的情况
* 或者直接在请求地址上做修改 /book/index/1;
 * */
    @RequestMapping(value = {"/list/{pageNo}","/list"})
    public String index(HttpSession session, @PathVariable(value = "pageNo",required = false) Integer pageNo) {
        if (pageNo == null){
            pageNo = 1;
        }
        PageInfo<Book> pageInfo = bookService.getPageInfo(pageNo);
        session.setAttribute("pageInfo", pageInfo);
        return PAGE_INDEX;
    }
}
