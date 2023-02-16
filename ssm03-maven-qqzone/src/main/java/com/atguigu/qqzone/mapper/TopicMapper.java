package com.atguigu.qqzone.mapper;

import com.atguigu.qqzone.pojo.Topic;

public interface TopicMapper {
    //查询topic基本信息
    Topic getTopic(Integer id);
    //查询topic信息包含回复列表信息
    //Topic getTopicWithReplyList(Integer id);
    //查询topic信息包含回复列表信息，列表中包含主人回复信息
    Topic getTopicWithReplyListAndHostReply(Integer id);
}
