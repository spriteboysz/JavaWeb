package javaweb.jdbc.library.DTO;

/**
 * Author: Deean
 * Date: 2023-08-30 22:51
 * FileName: src/main/java/javaweb/jdbc/library/DTO
 * Description:
 */

public class Student {
    int sId;
    String stuNum;
    String stuName;
    String stuGender;
    int stuAge;
    int stuClass;
    String stuDesc;

    @Override
    public String toString() {
        return sId + "\t" + stuNum + "\t" + stuName + "\t" + stuGender + "\t" + stuAge + "\t" + stuClass + "\t" + stuDesc;
    }

    public Student() {
    }

    public Student(int sId, String stuNum, String stuName, String stuGender, int stuAge, int stuClass, String stuDesc) {
        this.sId = sId;
        this.stuNum = stuNum;
        this.stuName = stuName;
        this.stuGender = stuGender;
        this.stuAge = stuAge;
        this.stuClass = stuClass;
        this.stuDesc = stuDesc;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public int getStuClass() {
        return stuClass;
    }

    public void setStuClass(int stuClass) {
        this.stuClass = stuClass;
    }

    public String getStuDesc() {
        return stuDesc;
    }

    public void setStuDesc(String stuDesc) {
        this.stuDesc = stuDesc;
    }

    public static void main(String[] args) {
        System.out.println(new Student());
    }
}
