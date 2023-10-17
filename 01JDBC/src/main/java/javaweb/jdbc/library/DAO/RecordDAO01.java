package javaweb.jdbc.library.DAO;

import javaweb.jdbc.library.DTO.Record;
import javaweb.jdbc.library.Utils.MyDBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Deean
 * Date: 2023-09-01 22:25
 * FileName: src/main/java/javaweb/jdbc/library/DAO
 * Description:
 */

public class RecordDAO01 {

    public boolean insertRecord(Record record) {
        int cnt = 0;
        Connection connection;
        PreparedStatement preparedStatement = null;
        try {
            connection = MyDBUtils.getConnection();
            System.out.println("增加借书记录conn:" + connection);
            String sql = "insert into records(stu_num, book_num, record_stock, record_date) values(?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, record.getStuNum());
            preparedStatement.setString(2, record.getBookNum());
            preparedStatement.setInt(3, record.getRecordStock());
            preparedStatement.setString(4, record.getRecordDate());
            cnt = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyDBUtils.close(preparedStatement);
            // MyDBUtils.close(connection);
        }
        return cnt > 0;
    }

    public boolean deleteRecord(int rid) {
        int cnt = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = MyDBUtils.getConnection();
            String sql = "delete from records where rid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, rid);
            cnt = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyDBUtils.close(preparedStatement, connection);
        }
        return cnt > 0;
    }

    public Record queryRecord(int rid) {
        Record record = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = MyDBUtils.getConnection();
            String sql = "select * from records where rid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, rid);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                record = new Record();
                record.setRid(rid);
                record.setStuNum(resultSet.getString("stu_num"));
                record.setBookNum(resultSet.getString("book_num"));
                record.setRecordStock(resultSet.getInt("record_stock"));
                record.setRecordDate(resultSet.getString("record_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyDBUtils.close(resultSet, preparedStatement, connection);
        }
        return record;
    }

    public List<Record> queryRecord() {
        List<Record> records = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = MyDBUtils.getConnection();
            String sql = "select * from records";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Record record = new Record();
                record.setRid(resultSet.getInt("rid"));
                record.setStuNum(resultSet.getString("stu_num"));
                record.setBookNum(resultSet.getString("book_num"));
                record.setRecordStock(resultSet.getInt("record_stock"));
                record.setRecordDate(resultSet.getString("record_date"));
                records.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyDBUtils.close(resultSet, preparedStatement, connection);
        }
        return records;
    }
}
