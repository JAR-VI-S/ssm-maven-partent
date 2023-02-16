package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Peoples;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description:
 * 该类演示  类中属性名对应的数据库列名均不一致
 * @author 程翔宇
 * @date 2023/2/2 20:00
 */
public interface PeopleMapper {
    void addPeople(Peoples peoples);
    Peoples getPeopleById(Integer id);
    Peoples getPeopleById2(@Param("id") Integer id);
    List<Peoples> getPeopleList();
}
