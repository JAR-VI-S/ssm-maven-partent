package com.atguigu.book.controller;

import com.atguigu.book.pojo.*;
import com.atguigu.book.service.BookService;
import com.atguigu.book.service.CartItemService;
import com.atguigu.book.service.OrderBeanService;
import com.atguigu.book.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderBeanController {

    private static final String PAGE_ORDER_LIST = "order/order";
    @Autowired
    private OrderBeanService orderBeanService;

    @RequestMapping("/checkout")
    public String checkout(HttpSession session) {
        User currUser = (User) session.getAttribute("currUser");
        orderBeanService.update(currUser);
        return "redirect:/order/index";
    }

    @RequestMapping("/index")
    public String index(HttpSession session) {
        User user = (User) session.getAttribute("currUser");
        List<OrderBean> orderBeanList = orderBeanService.getOrderBeanList(user);
        user.setOrderBeanList(orderBeanList);
        return PAGE_ORDER_LIST;
    }
}
