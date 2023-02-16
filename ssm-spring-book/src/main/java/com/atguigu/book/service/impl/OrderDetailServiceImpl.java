package com.atguigu.book.service.impl;

import com.atguigu.book.mapper.OrderDetailMapper;
import com.atguigu.book.pojo.OrderDetail;
import com.atguigu.book.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetailMapper.addOrderDetail(orderDetail);
    }
}
