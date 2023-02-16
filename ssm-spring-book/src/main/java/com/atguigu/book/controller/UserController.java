package com.atguigu.book.controller;

import com.atguigu.book.pojo.User;
import com.atguigu.book.service.CartItemService;
import com.atguigu.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final String LOGIN_FAIL_PAGE = "/login";
    private static final String TO_INDEX_PAGE = "redirect:/book/list";
    @Autowired
    private UserService userService;
    @Autowired
    private CartItemService cartItemService;

    @RequestMapping("/login")
    public String login(String uname, String pwd, HttpSession session) {
        User currUser = userService.getUserByUnameAndPwd(uname, pwd);
        if (currUser == null) {
            return LOGIN_FAIL_PAGE;
        } else {
            cartItemService.getCartInfo(currUser);
            session.setAttribute("currUser", currUser);
            return TO_INDEX_PAGE;
        }
    }
@RequestMapping("/logout")
    public String logout(HttpSession session, HttpServletResponse response) throws IOException {
        //session默认的有效时长是30分钟
        //session.setMaxInactiveInterval(60*5);//设置session的有效时长是5分钟
        session.invalidate();       //强制让当前session失效

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('注销成功！');window.location.href='/book/list';</script>");
        out.flush();
        return null;
    }

    @RequestMapping("/regist")
    public String regist(String uname, String pwd, String email, String yourCode, HttpSession session, HttpServletResponse response) throws IOException {
        String code = (String) session.getAttribute("KAPTCHA_SESSION_KEY");
        if (code.equals(yourCode)) {
            User user = new User(uname, pwd, email);
            userService.addUser(user);
            return TO_INDEX_PAGE;
        } else {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            //out.println("<script>alert('验证码不对！');window.location.href='page?page=user/regist';</script>");
            out.println("<script>alert('验证码不对！');window.history.back();</script>");
            out.flush();
            return null;
        }
    }

}
