package com.atguigu.mvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/8 18:33
 */
@Controller
@RequestMapping("/hello")
public class Hello02Controller {
    @RequestMapping("/h01")
    public String index(){
        return "hand";
    }
}
