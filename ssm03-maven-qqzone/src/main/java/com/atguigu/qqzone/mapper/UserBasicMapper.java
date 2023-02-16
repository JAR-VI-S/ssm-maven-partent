package com.atguigu.qqzone.mapper;

import com.atguigu.qqzone.pojo.UserBasic;
import org.apache.ibatis.annotations.Param;

public interface UserBasicMapper {
    //UserBasic getUserBasic(UserBasic userBasic);
    UserBasic getUserBasic(@Param("loginId") String loginId ,@Param("pwd") String pwd);
    //加载用户信息，包含日志列表
    //UserBasic getUserBasicWithTopicList(Integer userBasicId);
    //加载用户信息，包含他的好友信息
    //UserBasic getUserBasicWithFriendList(Integer userBasicId);
    //加载用户信息，包含他的日志列表和好友信息
    UserBasic getUserBasicWithTopicListAndFriendList(Integer userBasicId);
}
