package com.deean.dto;

/**
 * Author: Deean
 * Date: 2023-10-27 23:25
 * FileName: src/main/java/dto
 * Description:
 */

public class User {
    private int userId;
    private String userName;
    private String userPassword;
    private String userRealName;
    private String userGender;
    private String userTel;
    private String userDesc;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userRealname='" + userRealName + '\'' +
                ", userGender='" + userGender + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userDesc='" + userDesc + '\'' +
                '}';
    }

    public User() {
    }

    public User(int userId, String userName, String userPassword, String userRealName, String userGender, String userTel, String userDesc) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRealName = userRealName;
        this.userGender = userGender;
        this.userTel = userTel;
        this.userDesc = userDesc;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }
}
