package com.atguigu.book.service;

import com.atguigu.book.pojo.User;

public interface UserService {
    User getUserByUnameAndPwd(String uname , String pwd );

    void addUser(User user);
}
