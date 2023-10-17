package javaweb.jdbc.library.DAO;

import javaweb.jdbc.library.DTO.Record;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RecordDAO02Test {
    RecordDAO02 recordDAO = new RecordDAO02();
    @Test
    void insertRecord() {
        Record record = new Record(0, "20220102", "20120101", 2, "2023-9-2");
        assertTrue(recordDAO.insertRecord(record));
    }

    @Test
    void deleteRecord() {
        assertTrue(recordDAO.deleteRecord(6));
    }

    @Test
    void queryRecord() {
        Record record = recordDAO.queryRecord(1);
        System.out.println(record);
    }

    @Test
    void queryRecordAll() {
        List<Record> records = recordDAO.queryRecord();
        for (Record record : records) {
            System.out.println(record);
        }
    }
}