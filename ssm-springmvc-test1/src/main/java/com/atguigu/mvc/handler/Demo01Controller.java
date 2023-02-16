package com.atguigu.mvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/8 11:01
 */
@Controller
public class Demo01Controller {
    @RequestMapping("/abc")
    public String handView(){
        System.out.println("我是 SpringMVC 的 Hello world。");
        return "hand";
    }
}
