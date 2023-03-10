package com.atguigu.book.pojo;

import com.atguigu.book.util.OrderBeanUtil;

import java.util.Date;
import java.util.List;

public class OrderBean {
    private Integer id ;
    private String orderNo ;
    private Date orderDate ;
    private Double orderMoney ;
    private Integer orderCount ;
    private Integer orderStatus ;
    private User user ;

    private List<OrderDetail> orderDetailList ;

    public OrderBean(){}

    public OrderBean(Integer id) {
        this.id = id;
    }

    public OrderBean(Date orderDate, Double orderMoney, Integer orderCount, Integer orderStatus, User user) {

        this.orderNo = OrderBeanUtil.generateOrderNoStr(orderDate);
        this.orderDate = orderDate;
        this.orderMoney = orderMoney;
        this.orderCount = orderCount;
        this.orderStatus = orderStatus;
        this.user = user;
    }

    public OrderBean(String orderNo, Date orderDate, Double orderMoney, Integer orderCount, Integer orderStatus, User user) {
        this.orderNo = orderNo;
        this.orderDate = orderDate;
        this.orderMoney = orderMoney;
        this.orderCount = orderCount;
        this.orderStatus = orderStatus;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
