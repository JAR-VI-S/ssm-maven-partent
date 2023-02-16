create database mybatis_example char set utf8;
use mybatis_example;
create table t_person
(
    id      int PRIMARY KEY AUTO_INCREMENT,
    pname   varchar(40)  not null,
    address varchar(100) not null
);
create table t_people
(
    id      int PRIMARY KEY AUTO_INCREMENT,
    peolpe_pname   varchar(40)  not null,
    peolpe_address varchar(100) not null
)

