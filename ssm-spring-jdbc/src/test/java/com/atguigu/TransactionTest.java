package com.atguigu;

import com.atguigu.pojo.Person;
import com.atguigu.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/7 18:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class TransactionTest {
    @Autowired
    private PersonService personService;
    @Test
    public void test1(){
       personService.addPerson(new Person("阿呆","北京郊区",3500));
    }
    @Test
    public void test2(){
        personService.updatePersonSalaryById(1,8000);
    }
    @Test
    public void test3(){
       personService.updateTwice(7,"阿呆",6,10000);
    }
    @Test
    public void test4(){
        System.out.println(personService.getPersonById(3));
    }
}
