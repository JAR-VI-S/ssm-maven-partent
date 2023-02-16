package com.atguigu.book.controller;

import com.atguigu.book.pojo.Book;
import com.atguigu.book.pojo.CartItem;
import com.atguigu.book.pojo.User;
import com.atguigu.book.service.BookService;
import com.atguigu.book.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private BookService bookService;

    /*
    点击添加到购物车的思路：
    1. 检查是否已登录，如果没有登录，则重定向到登录页面
    2. 查询当前用户的购物车信息 -> Cart , Cart和CartItem之间的关系通过一个Map集合来维护
    3. 将用户点击的这本书加入到购物车中，如果车中已经存在这本书，则update，反之insert
    */
    @RequestMapping("/addToCart/{id}")
    public String addToCart(@PathVariable("id") Integer id, HttpSession session) {
        User user = (User) session.getAttribute("currUser");
        cartItemService.getCartInfo(user);

        Map<Integer, CartItem> cartItemMap = user.getCart().getCartItemMap();

        if (cartItemMap.containsKey(id)) {
            //update
            CartItem cartItem = cartItemMap.get(id);
            cartItem.setBuyCount(cartItem.getBuyCount() + 1);
            cartItemService.updateCartItem(cartItem);
        } else {
            //add
            Book book = bookService.getBook(id);
            CartItem cartItem = new CartItem(book, book.getBookName(), book.getPrice(), 1, user);
            cartItemService.addCartItem(cartItem);
        }
        return "redirect:/cart/index";
    }
@RequestMapping("/index")
    public String index(HttpSession session) throws IOException {
        User currUser = (User) session.getAttribute("currUser");
        cartItemService.getCartInfo(currUser);
        return "cart/cart";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, HttpSession session) {
        User user = (User) session.getAttribute("currUser");
        cartItemService.getCartInfo(user);
        cartItemService.delCartItem(user.getCart().getCartItemMap().get(id));
        return "redirect:/cart/index";
    }
    @RequestMapping("/deleteAll")
    public String deleteAll(HttpSession session) {
        User currUser = (User) session.getAttribute("currUser");
        List<CartItem> cartItemList = cartItemService.getCartItemList(currUser);
        cartItemList.forEach(cartItem -> cartItemService.delCartItem(cartItem));
        return "redirect:/cart/index";
    }
}
