use mybatis_example;
create table customer
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
