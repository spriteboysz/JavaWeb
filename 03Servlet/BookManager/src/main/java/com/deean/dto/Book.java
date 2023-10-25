package com.deean.dto;

/**
 * Author: Deean
 * Date: 2023-10-25 22:32
 * FileName: src/main/java/com/deean/dto
 * Description:
 */

public class Book {
    private String bookNum;
    private String bookName;
    private String bookCover;

    @Override
    public String toString() {
        return "Book{" +
                "bookNum='" + bookNum + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookCover='" + bookCover + '\'' +
                '}';
    }

    public Book(String bookNum, String bookName, String bookCover) {
        this.bookNum = bookNum;
        this.bookName = bookName;
        this.bookCover = bookCover;
    }

    public Book() {
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

    public String getBookCover() {
        return bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }
}
