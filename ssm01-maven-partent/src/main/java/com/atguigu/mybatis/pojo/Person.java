package com.atguigu.mybatis.pojo;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/2 13:45
 */
public class Person {
private Integer id;
private String pname;
private String address;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person(String pname, String address) {
        this.pname = pname;
        this.address = address;
    }

    public Person() {
    }
}
