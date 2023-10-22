package javaweb.jdbc.library.DAO;

import javaweb.jdbc.library.DTO.Student;
import org.junit.jupiter.api.Test;

import java.util.List;

class StudentDAO02Test {
    StudentDAO02 studentDAO = new StudentDAO02();

    @Test
    void insertStudent() {
        Student student = new Student(9, "20240101", "冯G", "M", 18, 2, "星星");
        assert (studentDAO.insertStudent(student));
    }

    @Test
    void deleteStudent() {
        assert (studentDAO.deleteStudent(10));
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