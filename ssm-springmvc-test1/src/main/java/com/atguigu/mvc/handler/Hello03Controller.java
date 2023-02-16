package com.atguigu.mvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sun.java2d.pipe.SpanIterator;

import java.util.List;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/8 18:41
 */
@Controller
@RequestMapping("/hello03")
public class Hello03Controller {
    @RequestMapping(value = "/h01",method = {RequestMethod.GET})
    public String index01(){
        System.out.println("这是一个get请求");
        return "hand";
    }
    @RequestMapping(value = "/h02",method = {RequestMethod.POST})
    public String index02(){
        System.out.println("这是一个post 请求");
        return "hand";
    }
    @RequestMapping(value = "/h03",method = {RequestMethod.GET,RequestMethod.POST})
    public String index03(){
        System.out.println("这个是一个get或post请求");
        return "hand";
    }
    @RequestMapping(value = "/h04")
    public String index04(String name){
        System.out.println("获取到的请求参数为  name:="+name);
        return "hand";
    }
    @RequestMapping(value = "/h05")
    public String index05(@RequestParam("naame") String name){
        System.out.println("获取到的请求参数为name:="+name);
        return "hand";
    }
    @RequestMapping("/h06")
    public String index06(@RequestParam("car")List carList){
        carList.forEach(System.out::println);
        return "hand";
    }
    @RequestMapping("/h07")
    public String index07(Person person){
        System.out.println(person);
        return "hand";
    }
}
