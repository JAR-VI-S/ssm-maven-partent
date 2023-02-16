package com.atguigu.book.mapper;

import com.atguigu.book.pojo.CartItem;

import java.util.List;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/13 16:19
 */
public interface CartItemMapper {
    List<CartItem> getCartItemListByUserId(Integer userId);
    void addCartItem(CartItem cartItem);
    void updateCartItem(CartItem cartItem);
    void delCartItem(CartItem cartItem);
}
