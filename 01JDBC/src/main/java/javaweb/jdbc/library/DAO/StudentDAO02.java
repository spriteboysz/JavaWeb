package javaweb.jdbc.library.DAO;

import javaweb.jdbc.library.DTO.Student;
import javaweb.jdbc.library.Utils.CommonDAO;
import javaweb.jdbc.library.Utils.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Author: Deean
 * Date: 2023-09-02 13:53
 * FileName: src/main/java/javaweb/jdbc/library/DAO
 * Description:
 */

public class StudentDAO02 {
    final CommonDAO<Student> commonDAO = new CommonDAO<>();

    public boolean insertStudent(Student student) {
        String sql = "insert into students(stu_num, stu_name, stu_gender, stu_age, stu_class, stu_desc) values (?,?,?,?,?,?)";
        return commonDAO.update(sql, student.getStuNum(), student.getStuName(), student.getStuGender(), student.getStuAge(), student.getStuClass(), student.getStuDesc());
    }

    public boolean deleteStudent(int sid) {
        String sql = "delete from students where sid = ?";
        return commonDAO.update(sql, sid);
    }

    public Student queryStudent(int sid) {
        String sql = "select * from students where sid = ?";
        RowMapper<Student> rowMapper = (ResultSet resultSet) -> {
            Student student = new Student();
            try {
                student.setsId(sid);
                student.setStuNum(resultSet.getString("stu_num"));
                student.setStuName(resultSet.getString("stu_name"));
                student.setStuGender(resultSet.getString("stu_gender"));
                student.setStuAge(resultSet.getInt("stu_age"));
                student.setStuClass(resultSet.getInt("stu_class"));
                student.setStuDesc(resultSet.getString("stu_desc"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return student;
        };
        return commonDAO.query(sql, rowMapper, sid).get(0);
    }

    public List<Student> queryStudent() {
        String sql = "select * from students";
        RowMapper<Student> rowMapper = (ResultSet resultSet) -> {
            Student student = new Student();
            try {
                student.setsId(resultSet.getInt("sid"));
                student.setStuNum(resultSet.getString("stu_num"));
                student.setStuName(resultSet.getString("stu_name"));
                student.setStuGender(resultSet.getString("stu_gender"));
                student.setStuAge(resultSet.getInt("stu_age"));
                student.setStuClass(resultSet.getInt("stu_class"));
                student.setStuDesc(resultSet.getString("stu_desc"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return student;
        };
        return commonDAO.query(sql, rowMapper);
    }
}
