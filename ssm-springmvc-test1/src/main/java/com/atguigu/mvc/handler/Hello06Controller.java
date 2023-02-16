package com.atguigu.mvc.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/8 18:41
 */
@Controller
@RequestMapping("/hello6")
public class Hello06Controller {
    @Autowired
    private ServletContext servletContext;
    //1.演示获取原生的ServletAPI：HttpServletRequest , HttpServletResponse , HttpSession
   @RequestMapping("/h01")
    public String index01(HttpServletRequest request, HttpServletResponse response, HttpSession session){
       System.out.println(request);
       System.out.println(response);
       System.out.println(session);


       return "hand";
   }
//   获取servletContext
   @RequestMapping("/h02")
   public String index02(HttpServletRequest request,  HttpSession session){
       System.out.println(request.getServletContext());
       System.out.println(session.getServletContext());
       System.out.println(servletContext);
       return "redirect:/outter.html";
   }
}
