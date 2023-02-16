package com.atguigu.mvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/8 18:41
 */
@Controller
@RequestMapping("/hello5")
public class Hello05Controller {
   @RequestMapping("/h01")
    public String index01(){
//       服务器内部转发
       System.out.println("转发到指定页面");
       return "forward:/outter.html";
   }
   @RequestMapping("/h02")
   public String index02(){
       System.out.println("客户端重定向");
       return "redirect:/outter.html";
   }
}
