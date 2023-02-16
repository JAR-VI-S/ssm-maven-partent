package com.atguigu.controller;

import com.atguigu.pojo.Fruit;
import com.atguigu.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/9 14:50
 */
@Controller
public class FruitController {
    @Autowired
    private FruitService fruitService;

    @RequestMapping("/index")
    public String homePage( HttpSession session, String keyword, String operate ,Integer pageNo) {

        if (keyword == null || "".equals(keyword)){
            keyword = "";
        }
        if (operate!=null ){
                session.setAttribute("keyword",keyword);
        }else{
            Object keywordObj = session.getAttribute("keyword");
            if (keywordObj!=null){
                keyword=(String)keywordObj;
                System.out.println(keyword);
            }
        }
//        获取查询总记录数
        Integer countByKey = fruitService.getCountByKey(keyword);
//        计算出总的页面数
        Integer pageCount = (countByKey+5-1)/5;
        session.setAttribute("pageCount",pageCount);

        if (pageNo ==null || pageNo < 1){
            pageNo=1;
        }
        if(pageNo>pageCount){
            pageNo = pageCount;
        }
        session.setAttribute("pageNo",pageNo);

        /*List<Fruit> fruitList = fruitService.getFruitListByKey(keyword);
        System.out.println(fruitList);
        System.out.println(pageCount);*/
        List<Fruit> fruitListByKeyAndPage = fruitService.getFruitListByKeyAndPage(keyword, (pageNo-1)*5);
        System.out.println(fruitListByKeyAndPage);
        session.setAttribute("fruitList", fruitListByKeyAndPage);
        return "index";
    }

    /*  @RequestMapping("/page")
        public String addPage2(String page){
            return page;
        }*/
    @RequestMapping("/add2")
    public String addPage(Fruit fruit) {
        if (fruit.getFname() != null && fruit.getFcount() != null && fruit.getPrice() != null && fruit.getRemark() != null) {
            fruitService.addFruit(fruit);
            return "redirect:index";
        }
        return "index";
    }

    @RequestMapping("/delete")
    public String delFruit(Integer id) {
        fruitService.deleteByPrimaryKey(id);
        return "redirect:index";
    }

    @RequestMapping("/edit")
    public String editFruit(Integer id, Model model) {
        Fruit fruit = fruitService.selectByPrimaryKey(id);
        model.addAttribute("fruit", fruit);
        return "edit";
    }

    @RequestMapping("/edit2")
    public String updateFruit(Fruit fruit) {
        fruitService.updateByPrimaryKeySelective(fruit);
        return "redirect:index";
    }
}
