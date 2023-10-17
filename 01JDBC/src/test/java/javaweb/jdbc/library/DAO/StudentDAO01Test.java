package javaweb.jdbc.library.DAO;

import javaweb.jdbc.library.DTO.Student;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAO01Test {
    StudentDAO01 studentDAO = new StudentDAO01();

    @Test
    void QueryStudent() {
        Student student = studentDAO.queryStudent(1);
        assertEquals(1, student.getsId());
        List<Student> students = studentDAO.queryStudent();
        assert (students.size() == 8);
    }

    @Test
    void insertStudent() {
        Student student = new Student(9, "20240101", "冯G", "M", 18, 2, "星星");
        assert (studentDAO.insertStudent(student));
    }

    @Test
    void deleteStudent() {
        assert (studentDAO.deleteStudent(9));
    }
}