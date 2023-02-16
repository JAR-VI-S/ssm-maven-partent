package com.atguigu.mvc.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/8 18:41
 */
@Controller
@RequestMapping("/hello7")
public class Hello07Controller {
    @Autowired
    private ServletContext servletContext;

    //1.演示获取原生的ServletAPI：HttpServletRequest , HttpServletResponse , HttpSession
    @RequestMapping("/h01")
    public String index01(HttpServletRequest request) {
        request.setAttribute("uname", "大象");
        return "hand2";
    }

    @RequestMapping("/h02")
    public String index02(Model model) {
        model.addAttribute("uname", "老鼠");
        return "hand2";
    }

    @RequestMapping("/h03")
    public String index03(Map map) {
        map.put("uname", "猫咪");
        return "hand2";
    }
    @RequestMapping("/h04")
    public String index04(ModelMap modelMap){
        modelMap.addAttribute("uname","秀狗");
        return"hand2";
    }
    @RequestMapping("/h05")
    public ModelAndView index05(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("uname","狮子");
        mav.setViewName("hand2");
        return mav;
    }
}
