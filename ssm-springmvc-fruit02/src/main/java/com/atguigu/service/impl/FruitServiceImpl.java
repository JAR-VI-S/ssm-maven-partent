package com.atguigu.service.impl;

import com.atguigu.mapper.FruitMapper;
import com.atguigu.pojo.Fruit;
import com.atguigu.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/9 14:22
 */
@Service
public class FruitServiceImpl implements FruitService {
    @Autowired
    private FruitMapper fruitMapper;
    @Override
    public Fruit selectByPrimaryKey(Integer id) {
        Fruit fruit = fruitMapper.selectByPrimaryKey(id);
        return fruit;
    }

    @Override
    public void addFruit(Fruit fruit) {
        fruitMapper.insert(fruit);
    }

    @Override
    public List<Fruit> getFruitList() {
        return fruitMapper.getFruitList();
    }

    @Override
    public void deleteByPrimaryKey(Integer id) {
        fruitMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateByPrimaryKeySelective(Fruit fruit) {
        fruitMapper.updateByPrimaryKeySelective(fruit);
    }

    @Override
    public List<Fruit> getFruitListByKey(String keyword) {
        return fruitMapper.getFruitListByKey(keyword);
    }

    @Override
    public Integer getCountByKey(String string) {

        return fruitMapper.getCountByKey(string);
    }

    @Override
    public List<Fruit> getFruitListByKeyAndPage(String keyword, Integer pageNo) {
        return fruitMapper.getFruitListByKeyAndPage(keyword,pageNo);
    }

}
