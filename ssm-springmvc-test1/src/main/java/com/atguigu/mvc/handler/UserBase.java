package com.atguigu.mvc.handler;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/10 18:48
 */
public class UserBase {
    private String userName;
    private String password;

    @Override
    public String toString() {
        return "UserBase{" +
                "userName='" + userName + '\'' +
                ", passWord='" + password + '\'' +
                '}';
    }

    public UserBase(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passWord) {
        this.password = passWord;
    }

    public UserBase() {
    }
}
