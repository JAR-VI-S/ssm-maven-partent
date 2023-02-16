package com.atguigu.book.mapper;

import com.atguigu.book.pojo.Book;
import com.atguigu.book.pojo.OrderBean;
import com.atguigu.book.pojo.User;

import java.util.List;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/13 16:19
 */
public interface OrderBeanMapper {
    void addOrderBean(OrderBean orderBean);
    List<OrderBean> getOrderBeanList(User user);
}
