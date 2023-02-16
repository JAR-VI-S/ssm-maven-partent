package com.atguigu.dao;

import com.atguigu.pojo.Person;

import java.util.List;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/7 14:06
 */
public interface PersonDao {
    void addPerson(Person person);
    String getPersonById(Integer id);
    void updatePersonNameById(Integer id,String name);
    void updatePersonSalaryById(Integer id, Integer salary);
}
