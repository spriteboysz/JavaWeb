package javaweb.jdbc.library.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Deean
 * Date: 2023-09-02 10:51
 * FileName: src/main/java/javaweb/jdbc/library/Utils
 * Description:
 */

public class CommonDAO<T> {
    public boolean update(String sql, Object... args) {
        int cnt = 0;
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = DruidUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            cnt = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnt > 0;
    }

    public List<T> query(String sql, RowMapper<T> rowMapper, Object... args) {
        List<T> list = new ArrayList<>();
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            connection = DruidUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                T object = rowMapper.getRow(resultSet);
                list.add(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
