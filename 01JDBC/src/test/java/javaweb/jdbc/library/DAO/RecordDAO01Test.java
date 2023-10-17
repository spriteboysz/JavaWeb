package javaweb.jdbc.library.DAO;

import javaweb.jdbc.library.DTO.Record;
import org.junit.jupiter.api.Test;

import java.util.List;

class RecordDAO01Test {

    RecordDAO01 recordDAO = new RecordDAO01();

    @Test
    void insertRecord() {
        Record record = new Record(2, "20220101", "20120101", 2, "2023-08-31");
        boolean flag = recordDAO.insertRecord(record);
        assert (flag);
    }

    @Test
    void deleteRecord() {
        boolean flag = recordDAO.deleteRecord(2);
        assert (flag);
    }

    @Test
    void queryRecord() {
        Record record = recordDAO.queryRecord(1);
        System.out.println(record);
        List<Record> records = recordDAO.queryRecord();
        for (Record r : records) {
            System.out.println(r);
        }
    }
}