package com.atguigu.book.mapper;

import com.atguigu.book.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/13 16:19
 */
public interface UserMapper {
    User getUserByUnameAndPwd(@Param("uname") String uname , @Param("pwd") String pwd ) ;
    void addUser(User user);
}
