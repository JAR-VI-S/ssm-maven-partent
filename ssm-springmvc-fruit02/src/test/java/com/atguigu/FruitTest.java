package com.atguigu;

import com.atguigu.pojo.Fruit;
import com.atguigu.service.FruitService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;


/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/9 11:26
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(value = "classpath:spring.xml")
public class FruitTest {
    @Autowired
    private FruitService fruitService;

    @Test
    public void test1() {
        Fruit fruit = fruitService.selectByPrimaryKey(28);
        System.out.println(fruit);
    }

    @Test
    public void test2() {
        fruitService.addFruit(new Fruit("娃哈哈", 180, 300, "榴莲闻起来臭,吃起来香"));
    }

    @Test
    public void test3() {
        List<Fruit> fruitList = fruitService.getFruitList();
        fruitList.forEach(System.out::println);

    }
}
