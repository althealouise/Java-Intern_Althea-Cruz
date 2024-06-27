package com.altheacruz.library.model;

public class FictionBook extends Book {
    private String genre;
    private String ageRating;

    public FictionBook(int refNo, String title, String author, String ISBN, int pubYear, String category, String genre, String ageRating) {
        super(refNo, title, author, ISBN, pubYear, "Fiction");
        this.genre = genre;
        this.ageRating = ageRating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    @Override
    public String toString() {
        return super.toString() + ", genre='" + genre + '\'' + ", ageRating='" + ageRating + '\'' + '}';
    }
}
