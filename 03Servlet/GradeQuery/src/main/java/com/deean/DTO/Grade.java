package com.deean.DTO;

/**
 * Author: Deean
 * Date: 2023-10-21 15:30
 * FileName: src/main/java/com/deean/DTO
 * Description:
 */

public class Grade {
    private String sNum;
    private String sName;
    private String cid;
    private String cName;
    private int score;

    @Override
    public String toString() {
        return "Grade{" +
                "sNum='" + sNum + '\'' +
                ", sName='" + sName + '\'' +
                ", cid=" + cid +
                ", cName='" + cName + '\'' +
                ", score=" + score +
                '}';
    }

    public Grade() {
    }

    public Grade(String sNum, String sName, String cid, String cName, int score) {
        this.sNum = sNum;
        this.sName = sName;
        this.cid = cid;
        this.cName = cName;
        this.score = score;
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

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
