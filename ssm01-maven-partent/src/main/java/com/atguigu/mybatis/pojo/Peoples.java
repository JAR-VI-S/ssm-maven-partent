package com.atguigu.mybatis.pojo;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/2 19:59
 */
public class Peoples {
    private Integer id;
    private String pname;
    private String address;

    @Override
    public String toString() {
        return "Peoples{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Peoples(String pname, String address) {
        this.pname = pname;
        this.address = address;
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

    public Peoples(Integer id, String pname, String address) {
        this.id = id;
        this.pname = pname;
        this.address = address;
    }

    public Peoples() {
    }
}
