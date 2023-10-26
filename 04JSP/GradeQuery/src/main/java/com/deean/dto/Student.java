package com.deean.dto;

/**
 * Author: Deean
 * Date: 2023-10-26 23:33
 * FileName: src/main/java/com/deean/dto
 * Description:
 */

public class Student {
    private String sNum;
    private String sName;
    private String sPassword;

    @Override
    public String toString() {
        return "Student{" +
                "sNum='" + sNum + '\'' +
                ", sName='" + sName + '\'' +
                ", sPassword='" + sPassword + '\'' +
                '}';
    }

    public Student() {
    }

    public Student(String sNum, String sName, String sPassword) {
        this.sNum = sNum;
        this.sName = sName;
        this.sPassword = sPassword;
    }

    public String getsNum() {
        return sNum;
    }

    public void setsNum(String sNum) {
        this.sNum = sNum;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }
}
