package javaweb.jdbc.library.DAO;

import javaweb.jdbc.library.DTO.Student;
import javaweb.jdbc.library.Utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Deean
 * Date: 2023-09-02 20:05
 * FileName: src/main/java/javaweb/jdbc/library/DAO
 * Description:
 */

public class StudentDAO03 {
    public boolean insertStudent(Student student) {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        int cnt = 0;
        String sql = "insert into students(stu_num, stu_name, stu_gender, stu_age, stu_class, stu_desc) values (?,?,?,?,?,?)";
        try {
            cnt = queryRunner.update(sql, student.getStuNum(), student.getStuName(), student.getStuGender(), student.getStuAge(), student.getStuClass(), student.getStuDesc());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnt > 0;
    }

    public boolean deleteStudent(int sid) {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        int cnt = 0;
        String sql = "delete from students where sid = ?";
        try {
            cnt = queryRunner.update(sql, sid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnt > 0;
    }

    public Student queryStudent(int sid) {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        Student student = null;
        String sql = "select sid, stu_num stuNum, stu_name stuName, stu_gender stuGender, stu_age stuAge, stu_class stuClass, stu_desc stuDesc from students where sid = ?";
        try {
            student = queryRunner.query(sql, new BeanHandler<>(Student.class), sid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public List<Student> queryStudent() {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        List<Student> students = new ArrayList<>();
        String sql = "select sid, stu_num stuNum, stu_name stuName, stu_gender stuGender, stu_age stuAge, stu_class stuClass, stu_desc stuDesc from students";
        try {
            students = queryRunner.query(sql, new BeanListHandler<>(Student.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void main(String[] args) {
        System.out.println(new StudentDAO03().queryStudent(1));
        List<Student> students = new StudentDAO03().queryStudent();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
