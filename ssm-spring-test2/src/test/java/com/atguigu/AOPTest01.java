package com.atguigu;

import com.atguigu.ioc.ISale;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/6 19:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AOPTest01 {
@Autowired
    private ISale iSale;
@Test
public void test1(){
   iSale.saleJianBing();
    System.out.println("....................");
}
@Test
public void test2(){
    iSale.saleManTou();
    System.out.println("....................");
}
@Test
public void test3(){
    iSale.saleJianBing();
    System.out.println("....................");
}
@Test
public void test4(){
   iSale.saleJianBing();
}
@Test
public void test5(){
   iSale.saleYueBing();
}
@Test
public void test6(){
   iSale.saleJianBing();
    System.out.println("..............");
    iSale.saleYueBing();
}
@Test
public void test7(){
    iSale.saleJianBing();
}
}
