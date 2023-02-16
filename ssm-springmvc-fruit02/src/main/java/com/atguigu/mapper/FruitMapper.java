package com.atguigu.mapper;

import com.atguigu.pojo.Fruit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FruitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Fruit record);

    int insertSelective(Fruit record);

    Fruit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Fruit record);

    int updateByPrimaryKey(Fruit record);
    List<Fruit> getFruitList();
    List<Fruit> getFruitListByKey(String keyword);
    Integer getCountByKey(String keyword);
    List<Fruit> getFruitListByKeyAndPage(@Param("keyword") String keyword, @Param("pageNo") Integer pageNo);
}
