package com.atguigu.mvc.handler;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/8 19:53
 */
public class Person {
    private String name;
    private Integer pwd;

    public Person(String name, Integer pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", pwd=" + pwd +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPwd() {
        return pwd;
    }

    public void setPwd(Integer pwd) {
        this.pwd = pwd;
    }
}
