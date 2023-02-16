package com.atguigu.book.service.impl;

import com.atguigu.book.mapper.CartItemMapper;
import com.atguigu.book.pojo.Book;
import com.atguigu.book.pojo.Cart;
import com.atguigu.book.pojo.CartItem;
import com.atguigu.book.pojo.User;
import com.atguigu.book.service.BookService;
import com.atguigu.book.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    private BookService bookService ;
    @Autowired
    private CartItemMapper cartItemMapper ;

    @Override
    public List<CartItem> getCartItemList(User user) {
        List<CartItem> cartItemList = cartItemMapper.getCartItemListByUserId(user.getId());
        cartItemList.forEach(cartItem -> {
            Book book = bookService.getBook(cartItem.getBook().getId());
            cartItem.setBook(book);
        });
        return cartItemList ;
    }

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemMapper.addCartItem(cartItem);
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        cartItemMapper.updateCartItem(cartItem);
    }

    @Override
    public void delCartItem(CartItem cartItem) {
        cartItemMapper.delCartItem(cartItem);
    }

    @Override
    public void getCartInfo(User user) {
        List<CartItem> cartItemList = getCartItemList(user);
        Map<Integer,CartItem> cartItemMap = new HashMap<>();
        cartItemList.forEach(cartItem -> {
            cartItemMap.put(cartItem.getBook().getId(),cartItem);
        });
        Cart cart = new Cart(cartItemMap);
        user.setCart(cart);
    }
}
