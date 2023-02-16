package com.atguigu.qqzone;

import com.atguigu.qqzone.mapper.UserBasicMapper;
import com.atguigu.qqzone.pojo.UserBasic;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/3 13:04
 */
public class TestQQzone {
    private SqlSession sqlSession;
    private UserBasicMapper userBasicMapper;
    @Before
    public  void setup() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        userBasicMapper = sqlSession.getMapper(UserBasicMapper.class);
    }
    @After
    public void teardown(){
        sqlSession.commit();
        sqlSession.close();
    }
   @Test
   public void test1(){
       System.out.println(userBasicMapper.getUserBasic("u001", "ok"));
   }
   @Test
   public void test2(){
       UserBasic userBasic = userBasicMapper.getUserBasicWithTopicListAndFriendList(2);
       System.out.println(userBasic);
   }
}
