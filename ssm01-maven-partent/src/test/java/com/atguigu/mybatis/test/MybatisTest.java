package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.PersonMapper;
import com.atguigu.mybatis.pojo.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/2 15:27
 */
public class MybatisTest {
    private PersonMapper personMapper;
    private SqlSession sqlSession;
    @Before
public void setup() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        personMapper = sqlSession.getMapper(PersonMapper.class);
    }
    @After
    public void teardown(){
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test1(){
        personMapper.addPerson();
    }
    @Test
    public void test2(){
        Person person = new Person("小虎","浙江杭州");
        personMapper.addPerson2(person);
    }
    @Test
    public void test3(){
        System.out.println(personMapper.getPerson("小虎"));

    }
    @Test
    public void test4(){
        System.out.println(personMapper.getPerson2(2));
    }
    @Test
    public void test5(){
       personMapper.delPerson(2);
    }
    @Test
    public void test6(){
        List<Person> personList = personMapper.getPersonList();
        System.out.println(personList);
       personList.forEach(System.out::println);
    }
    @Test
    public void test7(){
        Person person = personMapper.getPerson2(1);
        person.setPname("翔宇");
        personMapper.updatePerson(person);
    }
    @Test
    public void test8(){
        Person person = personMapper.getPerson("翔宇");
        person.setAddress("中国上海");
        personMapper.updatePerson2(person);
    }
    @Test
    public void test9(){
       personMapper.addPerson3("阿胜","上海普陀");
    }
    @Test
    public void test10(){
       personMapper.addPerson4("心远","杭州上城区");
    }
    @Test
    public void test11(){
        System.out.println(personMapper.getPersonCount());
    }
    @Test
    public void test12(){
       Person person = new Person("后来","带着笑或是很沉默");
        System.out.println(person);
       personMapper.addPerson5(person);
        System.out.println(person);
    }
}
