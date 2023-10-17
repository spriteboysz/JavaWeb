package javaweb.jdbc.library.DAO;

import javaweb.jdbc.library.DTO.Student;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentDAO03Test {
    StudentDAO03 studentDAO = new StudentDAO03();

    @Test
    void insertStudent() {
        Student student = new Student(9, "20240101", "冯G", "M", 18, 2, "星星");
        assertTrue(studentDAO.insertStudent(student));
    }

    @Test
    void deleteStudent() {
        assertTrue(studentDAO.deleteStudent(11));
    }

    @Test
    void queryStudent() {
        Student student = studentDAO.queryStudent(2);
        System.out.println(student);
    }

    @Test
    void queryStudentAll() {
        List<Student> students = studentDAO.queryStudent();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}