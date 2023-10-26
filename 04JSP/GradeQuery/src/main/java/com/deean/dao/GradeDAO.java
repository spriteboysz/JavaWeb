package com.deean.dao;

import com.deean.dto.Grade;
import com.deean.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Author: Deean
 * Date: 2023-10-26 23:36
 * FileName: src/main/java/dao
 * Description:
 */

public class GradeDAO {
    public Grade queryGrade(String sNum, String cid) {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        Grade grade = null;
        String sql = """
                select s.stu_num sNum, stu_name sName, c.cid, c.cname cName, score
                from students s join grade.grades g join grade.courses c
                on s.stu_num = g.stu_num and c.cid = g.cid
                where s.stu_num = ? and c.cid = ?;\s""";
        try {
            grade = queryRunner.query(sql, new BeanHandler<>(Grade.class), sNum, cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grade;
    }
}
