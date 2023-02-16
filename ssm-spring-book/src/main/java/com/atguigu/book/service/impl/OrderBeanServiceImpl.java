package com.atguigu.book.service.impl;

import com.atguigu.book.mapper.OrderBeanMapper;
import com.atguigu.book.mapper.OrderDetailMapper;
import com.atguigu.book.pojo.*;
import com.atguigu.book.service.BookService;
import com.atguigu.book.service.CartItemService;
import com.atguigu.book.service.OrderBeanService;
import com.atguigu.book.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackForClassName = "Exception.class")
public class OrderBeanServiceImpl implements OrderBeanService {
    @Autowired
    private OrderBeanMapper orderBeanMapper;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private BookService bookService;
    @Autowired
    private CartItemService cartItemService;

    @Override
    public void addOrderBean(OrderBean orderBean) {
        orderBeanMapper.addOrderBean(orderBean);
    }

    @Override
    public List<OrderBean> getOrderBeanList(User user) {
        return orderBeanMapper.getOrderBeanList(user);
    }
    @Override
    public void update(User user){
        Cart cart = user.getCart();
        //1.向订单表添加一条记录
        OrderBean orderBean = new OrderBean(new Date(), cart.getTotalMoney(), cart.getTotalCount(), 0, user);
        this.addOrderBean(orderBean);

        Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
        cartItemMap.forEach((bookId, cartItem) -> {
            //2.向订单详情表添加n条记录
            OrderDetail orderDetail = new OrderDetail(cartItem.getBook(), cartItem.getBookName(), cartItem.getPrice(), cartItem.getBuyCount(), orderBean);
            orderDetailService.addOrderDetail(orderDetail);
            //3.更新图书信息（销量和库存量）
            Book book = bookService.getBook(bookId);
            book.setSaleCount(book.getSaleCount() + cartItem.getBuyCount());
            book.setBookCount(book.getBookCount() - cartItem.getBuyCount());
            bookService.updateBook(book);
            //4.删除购物车相关信息
            cartItemService.delCartItem(cartItem);
        });
        //5.清除内存中的数据信息
        user.getCart().getCartItemMap().clear();
        //结账
    }
}
