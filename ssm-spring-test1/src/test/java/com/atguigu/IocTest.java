package com.atguigu;

import com.atguigu.ioc.Demo;
import com.sun.corba.se.impl.orb.ParserTable;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/5 13:59
 */
public class IocTest {
    @Test
    public void test1(){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
        Demo demo = beanFactory.getBean(Demo.class);
        demo.Print();
        Demo s01 = (Demo) beanFactory.getBean("s01");
        s01.Print();

    }
    @Test
    public void test(){

    }

}
