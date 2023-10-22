package javaweb.jdbc.library.Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Author: Deean
 * Date: 2023-09-02 00:00
 * FileName: src/main/java/javaweb/jdbc/library/Utils
 * Description:
 */

public class DruidUtils {

    private static DataSource dataSource;
    public static final ThreadLocal<Connection> local = new ThreadLocal<>();

    static {
        Properties properties = new Properties();
        try {
            InputStream inputStream = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = local.get();
        try {
            if (connection == null) {
                connection = dataSource.getConnection();
                local.set(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}


