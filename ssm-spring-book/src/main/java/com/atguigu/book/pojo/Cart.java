package com.atguigu.book.pojo;

import java.util.HashMap;
import java.util.Map;

//购物车
public class Cart {
    //每一个CartItem相当于一个购物袋
    //我们在图中写的是书名，仅仅是帮助大家理解，实际上袋子上贴的标签应该是图书的id（主键）
//    cartItemMap  k = book.id   v = cartItem
    private Map<Integer,CartItem> cartItemMap = new HashMap<>();
    private Integer totalCount = 0 ;//总商品数量
    private Double totalMoney = 0.0;//总商品金额

    public Cart(){}

    public Cart(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Integer getTotalCount() {
        totalCount = 0 ;
        if(cartItemMap!=null && cartItemMap.size()>0){
            cartItemMap.forEach((k,v)->{
                totalCount += v.getBuyCount();
            });
        }else{
            totalCount = 0 ;
        }
        return totalCount;
    }

    public Double getTotalMoney() {
        totalMoney = 0.0 ;
        if(cartItemMap!=null && cartItemMap.size()>0){
            cartItemMap.forEach((k,v)->{
                totalMoney += (v.getPrice()*v.getBuyCount());
            });
        }else{
            totalMoney = 0.0 ;
        }
        return totalMoney;
    }
}
