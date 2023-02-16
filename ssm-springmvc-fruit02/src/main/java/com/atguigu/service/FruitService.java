package com.atguigu.service;

import com.atguigu.mapper.FruitMapper;
import com.atguigu.pojo.Fruit;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/9 14:17
 */
public interface FruitService {
    Fruit selectByPrimaryKey(Integer id);
    void addFruit(Fruit fruit);
    List<Fruit> getFruitList();
    void deleteByPrimaryKey(Integer id);
    void updateByPrimaryKeySelective(Fruit fruit);
    List<Fruit> getFruitListByKey(String keyword);
    Integer getCountByKey(String string);
    List<Fruit> getFruitListByKeyAndPage(String keyword, Integer pageNo);
}
