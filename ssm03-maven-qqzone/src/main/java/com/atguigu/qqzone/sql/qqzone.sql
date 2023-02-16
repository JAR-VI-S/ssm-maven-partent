use  qqzonedb2;
select * from t_user_basic;
select * from t_friend;
select * from t_user_basic  t1 left join t_friend t2 on t1.id = t2.fid;
select * from t_user_basic t1 left join t_friend t2 on t1.id = t2.uid;
select * from t_user_basic t1 inner join t_friend t2 on t1.id = t2.uid;
select * from t_user_basic t1 left join t_friend t2 on t1.id = t2.uid left join t_user_basic t3 on t2.fid = t3.id;
select * from t_user_basic t1 left join t_friend t2 on t1.id = t2.uid inner join t_user_basic t3 on t2.fid = t3.id;
select * from t_user_basic t1 left join t_friend t2 on t1.id = t2.uid inner join t_user_basic t3 on t2.fid = t3.id where t1.id = 1;
select *from t_user_basic t1 left join t_friend t2 on t1.id = t2.uid inner join t_user_basic t3 on t2.fid = t3.id where t1.id = 1;
SELECT t1.*,
       t2.id AS fid,t2.nickName AS f_nickName,t2.headImg AS f_headImg,
       t4.id AS topicId , title , content , topicDate
FROM t_user_basic t1 LEFT JOIN t_friend t3 ON t1.id = t3.uid
                     INNER JOIN t_user_basic t2 ON t3.fid = t2.id
                     LEFT JOIN t_topic t4 ON t1.id = t4.author
WHERE t1.id =2;

SELECT t1.*,t5.headImg t_a_headImg , t5.nickName t_a_nickName ,
       t2.id r_id , t2.content r_content , replyDate , t4.id r_a_id , t4.headImg r_a_headImg , t4.nickName r_a_nickName,
       t3.id h_id , t3.content h_content , hostReplyDate
FROM t_topic t1 INNER JOIN t_user_basic t5 ON t1.author = t5.id
                LEFT JOIN t_reply t2 ON t1.id=t2.topic
                INNER JOIN t_user_basic t4 ON t2.author = t4.id
                LEFT JOIN t_host_reply t3 ON t2.id = t3.reply
WHERE t1.id = 3
