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
@RequestMapping("/hello4")
public class Hello04Controller {
    @RequestMapping(value = "/h01")
    public String index01(@RequestHeader(name = "accept") String accept,  HttpServletRequest request){
        System.out.println("accept = " + accept);
        System.out.println("============================================");
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headName = headerNames.nextElement();
            String headValue = request.getHeader(headName);
            System.out.println(headName +":" + headValue);
        }
        return "hand";
    }
    @RequestMapping("/h02")
    public String index02(@CookieValue(value="JSESSIONID",defaultValue = "missing") String sessionId,HttpServletRequest  request,HttpSession session){
        System.out.println("sessionId = " + sessionId);
        System.out.println("============================================");
        Cookie[] cookies = request.getCookies();
        if(cookies!=null && cookies.length>0) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookieTemp = cookies[i];
                System.out.println(cookieTemp.getName() + ":" + cookieTemp.getValue());
            }
        }

        return "hand";
    }
}
