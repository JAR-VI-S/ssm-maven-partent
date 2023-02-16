package com.atguigu.dao.impl;

import com.atguigu.dao.PersonDao;
import com.atguigu.pojo.Person;
import com.mysql.cj.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/7 14:07
 */
@Repository
public class PersonDaoImpl implements PersonDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void addPerson(Person person) {
        String sql = "insert into t_person values(0,?,?,?)";
        jdbcTemplate.update(sql,person.getPname(),person.getAddress(),person.getSalary());
    }

    @Override
    public String getPersonById(Integer id) {
        String sql = "select pname from t_person where id =?";
        String pname = jdbcTemplate.queryForObject(sql, String.class, id);
        return pname;
    }

    @Override
    public void updatePersonNameById(Integer id, String name) {
        String sql = "update t_person set pname = ? where id =?";
        jdbcTemplate.update(sql,name,id);
    }

    @Override
    public void updatePersonSalaryById(Integer id, Integer salary) {
        String sql = "update t_person set salary = ? where id =?";
        jdbcTemplate.update(sql,salary,id);
    }


}
