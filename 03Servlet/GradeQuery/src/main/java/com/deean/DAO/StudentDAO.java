package com.deean.DAO;

import com.deean.DTO.Student;
import com.deean.Utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Author: Deean
 * Date: 2023-10-21 15:11
 * FileName: src/main/java/com/deean/DAO
 * Description:
 */

public class StudentDAO {
    public Student queryStudent(String sNum, String sPassword) {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        Student student = null;
        String sql = "select stu_num sNum, stu_name sName, stu_password sPassword from students where stu_num = ? and stu_password = ?";
        try {
            student = queryRunner.query(sql, new BeanHandler<>(Student.class), sNum, sPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}
