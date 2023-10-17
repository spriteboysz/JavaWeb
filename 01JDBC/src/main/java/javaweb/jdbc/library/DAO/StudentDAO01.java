package javaweb.jdbc.library.DAO;

import javaweb.jdbc.library.DTO.Student;
import javaweb.jdbc.library.Utils.MyDBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static javaweb.jdbc.library.Utils.MyDBUtils.close;
import static javaweb.jdbc.library.Utils.MyDBUtils.getConnection;

/**
 * Author: Deean
 * Date: 2023-08-30 23:47
 * FileName: src/main/java/javaweb/jdbc/library/DAO
 * Description:
 */

public class StudentDAO01 {

    public boolean insertStudent(Student student) {
        int cnt = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            String sql = "insert into students(sid, stu_num, stu_name, stu_gender, stu_age, stu_class, stu_desc) values(?,?,?,?,?,?,?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, student.getsId());
            preparedStatement.setString(2, student.getStuNum());
            preparedStatement.setString(3, student.getStuName());
            preparedStatement.setString(4, student.getStuGender());
            preparedStatement.setInt(5, student.getStuAge());
            preparedStatement.setInt(6, student.getStuClass());
            preparedStatement.setString(7, student.getStuDesc());
            cnt = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement, connection);
        }
        return cnt > 0;
    }

    public boolean deleteStudent(int sid) {
        int cnt = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            String sql = "delete from students where sid = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, sid);
            cnt = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement, connection);
        }
        return cnt > 0;
    }

    public Student queryStudent(int sid) {
        Student student = null;
        Connection connection;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            System.out.println("查询学生记录conn: " + connection);
            String sql = "select * from students where sid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, sid);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String stuNum = resultSet.getString("stu_num");
                String stuName = resultSet.getString("stu_name");
                String stuGender = resultSet.getString("stu_gender");
                int stuAge = resultSet.getInt("stu_age");
                int stuClass = resultSet.getInt("stu_class");
                String stuDesc = resultSet.getString("stu_desc");
                student = new Student(sid, stuNum, stuName, stuGender, stuAge, stuClass, stuDesc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyDBUtils.close(resultSet, preparedStatement);
            // MyDBUtils.close(connection);
        }
        return student;
    }

    public List<Student> queryStudent() {
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            String sql = "select * from students";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int sid = resultSet.getInt("sid");
                String stuNum = resultSet.getString("stu_num");
                String stuName = resultSet.getString("stu_name");
                String stuGender = resultSet.getString("stu_gender");
                int stuAge = resultSet.getInt("stu_age");
                int stuClass = resultSet.getInt("stu_class");
                String stuDesc = resultSet.getString("stu_desc");
                Student student = new Student(sid, stuNum, stuName, stuGender, stuAge, stuClass, stuDesc);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet, statement, connection);
        }
        return students;
    }
}
