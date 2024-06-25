package com.altheacruz.library.model;

public class FictionBook extends Book {
    private String genre;

    public FictionBook(int refNo, String title, String author, String ISBN, int pubYear, String genre) {
        super(refNo, title, author, ISBN, pubYear);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return super.toString() + ", Genre='" + genre + '\'' + '}';
    }
}
