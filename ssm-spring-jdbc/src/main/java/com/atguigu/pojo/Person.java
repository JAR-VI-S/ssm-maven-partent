package com.atguigu.pojo;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/7 13:01
 */
public class Person {
    private Integer id;
    private String pname;
    private String address;
    private Integer salary;

    public Person(String pname, String address, Integer salary) {
        this.pname = pname;
        this.address = address;
        this.salary = salary;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
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
}
