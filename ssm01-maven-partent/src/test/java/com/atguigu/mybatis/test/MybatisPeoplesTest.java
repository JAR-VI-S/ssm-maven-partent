package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.PeopleMapper;
import com.atguigu.mybatis.pojo.Peoples;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/2 20:12
 */
public class MybatisPeoplesTest {
    private SqlSession sqlSession;
    private PeopleMapper peopleMapper;

    @Before
    public void setup() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        peopleMapper = sqlSession.getMapper(PeopleMapper.class);
    }

    @After
    public void teardown() {
        sqlSession.commit();
        sqlSession.close();
    }

    //    当往数据库传参时
    @Test
    public void test1() {
        peopleMapper.addPeople(new Peoples("心远", "杭州上城"));
        peopleMapper.addPeople(new Peoples("小虎", "杭州下沙"));
        peopleMapper.addPeople(new Peoples("阿胜", "上海普陀"));
    }

    @Test
    public void test2() {
        System.out.println(peopleMapper.getPeopleById(1));
    }

    @Test
    public void test3() {
        System.out.println(peopleMapper.getPeopleById2(1));

    }

    @Test
    public void test4() {
        List<Peoples> peopleList = peopleMapper.getPeopleList();
        peopleList.forEach(System.out::println);
    }
}
