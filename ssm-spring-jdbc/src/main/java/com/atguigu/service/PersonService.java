package com.atguigu.service;

import com.atguigu.pojo.Person;

import java.util.List;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/7 14:05
 */
public interface PersonService {
    void addPerson(Person person);
    String getPersonById(Integer id);
    void updatePersonNameById(Integer id,String name);
    void updatePersonSalaryById(Integer id, Integer salary);
    void updateTwice(Integer ida,String name,Integer idb,Integer salary);
}
