package com.atguigu.book.service.impl;

import com.atguigu.book.mapper.UserMapper;
import com.atguigu.book.pojo.User;
import com.atguigu.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class UserServiceImpl implements UserService {
@Autowired
    private UserMapper userMapper ;

    @Override
    public User getUserByUnameAndPwd(String uname, String pwd) {
        return userMapper.getUserByUnameAndPwd(uname,pwd);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }
}
