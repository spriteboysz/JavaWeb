package javaweb.jdbc.library.DTO;

/**
 * Author: Deean
 * Date: 2023-09-01 22:22
 * FileName: src/main/java/javaweb/jdbc/library/DTO
 * Description:
 */

public class Record {
    int rid;
    String stuNum;
    String bookNum;
    int recordStock;
    String recordDate;

    @Override
    public String toString() {
        return rid + "\t" + stuNum + "\t" + bookNum + "\t" + recordStock + "\t" + recordDate;
    }

    public Record() {
    }

    public Record(int rid, String stuNum, String bookNum, int recordStock, String recordDate) {
        this.rid = rid;
        this.stuNum = stuNum;
        this.bookNum = bookNum;
        this.recordStock = recordStock;
        this.recordDate = recordDate;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getBookNum() {
        return bookNum;
    }

    public void setBookNum(String bookNum) {
        this.bookNum = bookNum;
    }

    public int getRecordStock() {
        return recordStock;
    }

    public void setRecordStock(int recordStock) {
        this.recordStock = recordStock;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }
}
