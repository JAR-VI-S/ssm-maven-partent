package com.atguigu.mvc.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/8 18:41
 */
@Controller
@RequestMapping("/hello08")
public class Hello08Controller {
    @RequestMapping("/h01")
    public String index01(String userName, String password){
        System.out.println(userName);
        System.out.println(password);
        return "succ02";
    }
    @RequestMapping("/h02")
    @ResponseBody
    public String index02(@RequestBody UserBase userBase){
        System.out.println(userBase);
        return "succ02";
    }

    @RequestMapping("/h03")
    @ResponseBody
    public String index03(UserBase userBase){
        System.out.println(userBase);
        return "succ02";
    }
    @RequestMapping("/h04")
    @ResponseBody
    public UserBase index04(){
        UserBase userBase = new UserBase("翔宇","12334");
        return userBase;
    }
}
