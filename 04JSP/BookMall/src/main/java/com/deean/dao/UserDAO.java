package com.deean.dao;

import com.deean.dto.User;
import com.deean.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Author: Deean
 * Date: 2023-10-27 23:53
 * FileName: src/main/java/com/deean/dao
 * Description:
 */

public class UserDAO {
    public User queryUser(String userName) {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        User user = null;
        String sql = """
                select user_id       userId,
                       user_name     userName,
                       user_password userPassword,
                       user_realname userRealName,
                       user_gender   userGender,
                       user_tel      userTel,
                       user_desc     userDesc
                from users
                where user_name = ?""";
        try {
            user = queryRunner.query(sql, new BeanHandler<>(User.class), userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
