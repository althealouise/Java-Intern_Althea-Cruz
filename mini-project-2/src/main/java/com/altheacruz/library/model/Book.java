package com.altheacruz.library.model;

public class Book {
    private int refNo;
    private String title;
    private String author;
    private String ISBN;
    private int pubYear;

    public Book(int refNo, String title, String author, String ISBN, int pubYear) {
        this.refNo = refNo;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.pubYear = pubYear;
    }

    public int getRefNo() {
        return refNo;
    }

    public void setRefNo(int refNo) {
        this.refNo = refNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPubYear() {
        return pubYear;
    }

    public void setPubYear(int pubYear) {
        this.pubYear = pubYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "refNo=" + refNo +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", pubYear=" + pubYear +
                '}';
    }
}
