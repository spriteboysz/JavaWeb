package com.deean.dto;

/**
 * Author: Deean
 * Date: 2023-10-27 23:29
 * FileName: src/main/java/dto
 * Description:
 */

public class Book {
    private String bookId;
    private String bookName;
    private String bookAuthor;
    private String bookCover;
    private double bookPrice;
    private String bookDesc;
    private int bookStock;
    private int bookType;

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookCover='" + bookCover + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookDesc='" + bookDesc + '\'' +
                ", bookStock=" + bookStock +
                ", bookType=" + bookType +
                '}';
    }

    public Book() {
    }

    public Book(String bookId, String bookName, String bookAuthor, String bookCover, double bookPrice, String bookDesc, int bookStock, int bookType) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookCover = bookCover;
        this.bookPrice = bookPrice;
        this.bookDesc = bookDesc;
        this.bookStock = bookStock;
        this.bookType = bookType;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
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

    public String getBookCover() {
        return bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
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

    public int getBookType() {
        return bookType;
    }

    public void setBookType(int bookType) {
        this.bookType = bookType;
    }
}
