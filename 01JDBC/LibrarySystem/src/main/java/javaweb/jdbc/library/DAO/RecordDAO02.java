package javaweb.jdbc.library.DAO;

import javaweb.jdbc.library.DTO.Record;
import javaweb.jdbc.library.Utils.CommonDAO;
import javaweb.jdbc.library.Utils.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Author: Deean
 * Date: 2023-09-02 13:27
 * FileName: src/main/java/javaweb/jdbc/library/DAO
 * Description:
 */

public class RecordDAO02 {
    final CommonDAO<Record> commonDAO = new CommonDAO<>();

    public boolean insertRecord(Record record) {
        String sql = "insert into records(stu_num, book_num, record_stock,record_date) values(?,?,?,?)";
        return commonDAO.update(sql, record.getStuNum(), record.getBookNum(), record.getRecordStock(), record.getRecordDate());
    }

    public boolean deleteRecord(int rid) {
        String sql = "delete from records where rid = ?";
        return commonDAO.update(sql, rid);
    }

    public Record queryRecord(int rid) {
        String sql = "select * from records where rid = ?";
        RowMapper<Record> rowMapper = (ResultSet resultSet) -> {
            Record record = null;
            try {
                String stuNum = resultSet.getString("stu_num");
                String bookNum = resultSet.getString("book_num");
                int recordStock = resultSet.getInt("record_stock");
                String recordDate = resultSet.getString("record_date");
                record = new Record(rid, stuNum, bookNum, recordStock, recordDate);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return record;
        };
        return commonDAO.query(sql, rowMapper, rid).get(0);
    }

    public List<Record> queryRecord() {
        String sql = "select * from records";
        RowMapper<Record> rowMapper = (ResultSet resultSet) -> {
            Record record = null;
            try {
                int rid = resultSet.getInt("rid");
                String stuNum = resultSet.getString("stu_num");
                String bookNum = resultSet.getString("book_num");
                int recordStock = resultSet.getInt("record_stock");
                String recordDate = resultSet.getString("record_date");
                record = new Record(rid, stuNum, bookNum, recordStock, recordDate);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return record;
        };
        return commonDAO.query(sql, rowMapper);
    }

}
