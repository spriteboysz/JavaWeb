package javaweb.jdbc.library.DTO;

/**
 * Author: Deean
 * Date: 2023-08-31 23:52
 * FileName: src/main/java/javaweb/jdbc/library/DTO
 * Description:
 */

public class Book {
    int bid;
    String bookNum;
    String bookName;
    String bookAuthor;
    float bookPrice;
    String bookDesc;
    int bookStock;

    @Override
    public String toString() {
        return bid + "\t" + bookNum + "\t" + bookName + "\t" + bookAuthor + "\t" + bookPrice + "\t" + bookDesc + "\t" + bookStock;
    }

    public Book() {
    }

    public Book(int bid, String bookNum, String bookName, String bookAuthor, float bookPrice, String bookDesc, int bookStock) {
        this.bid = bid;
        this.bookNum = bookNum;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        this.bookDesc = bookDesc;
        this.bookStock = bookStock;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBookNum() {
        return bookNum;
    }

    public void setBookNum(String bookNum) {
        this.bookNum = bookNum;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public int getBookStock() {
        return bookStock;
    }

    public void setBookStock(int bookStock) {
        this.bookStock = bookStock;
    }
}
