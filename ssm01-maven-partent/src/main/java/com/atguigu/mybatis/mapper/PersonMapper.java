package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Person;
import org.apache.ibatis.annotations.Param;

import javax.print.attribute.standard.PrinterName;
import java.util.List;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/2 13:56
 */
public interface PersonMapper {
//     传入单个参数的情况
     void addPerson();
     void addPerson2(Person person);
     void delPerson(Integer id);
     void updatePerson(Person person);
     void updatePerson2(Person person);
     //     返回参数情况
     List<Person> getPersonList();
     Person getPerson(String pname);
     Person getPerson2(Integer id);
     Integer getPersonCount();
     //     传入多个简单参数的情况
     void addPerson3(String pname,String address);
     void addPerson4(@Param("pname") String pname, @Param("address") String pwd);
//<!-- 演示返回自增列的值 -->
     void addPerson5(Person person);
}
