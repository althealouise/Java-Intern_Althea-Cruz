package com.altheacruz;

public class Book {
    public int refNo;
    public String title;
    public String author;
    public String ISBN;
    public int pubYear;
    public String category;

    public Book(int refNo, String title, String author, String ISBN, int pubYear, String category) {
        this.refNo = refNo;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.pubYear = pubYear;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
