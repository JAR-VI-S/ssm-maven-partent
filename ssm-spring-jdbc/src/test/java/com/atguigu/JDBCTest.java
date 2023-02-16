package com.atguigu;

import com.alibaba.druid.pool.DruidDataSource;
import com.atguigu.pojo.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/7 12:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class JDBCTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DruidDataSource druidDataSource;

    @Test
    public void testJdbcTemplateUpdate() {
        System.out.println(jdbcTemplate);
        System.out.println(druidDataSource);
    }

    @Test
    public void test2() {
        String sql = "select pname from t_person where id = ?";
        String name = jdbcTemplate.queryForObject(sql, String.class, 1);
        System.out.println(name);
    }
    @Test
    public void test3(){
        String sql = "select * from t_person where id = ?";
        Person person = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Person.class), 1);
        System.out.println(person);
    }

}
