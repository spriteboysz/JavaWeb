package com.deean.dto;

/**
 * Author: Deean
 * Date: 2023-10-26 22:46
 * FileName: src/main/java/com/deean/dto
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
        return "Book{" +
                "bid=" + bid +
                ", bookNum='" + bookNum + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookDesc='" + bookDesc + '\'' +
                ", bookStock=" + bookStock +
                '}';
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
