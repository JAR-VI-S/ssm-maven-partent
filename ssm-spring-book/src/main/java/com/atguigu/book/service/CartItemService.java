package com.atguigu.book.service;

import com.atguigu.book.pojo.CartItem;
import com.atguigu.book.pojo.User;

import java.util.List;

public interface CartItemService {
    //查询指定用户的所有的购物车项
    List<CartItem> getCartItemList(User user);
    //添加购物车项
    void addCartItem(CartItem cartItem);
    //更新购物车项
    void updateCartItem(CartItem cartItem);
    //删除特定的购物车项
    void delCartItem(CartItem cartItem);

    //获取指定用户的购物车信息
    void getCartInfo(User user);
}
