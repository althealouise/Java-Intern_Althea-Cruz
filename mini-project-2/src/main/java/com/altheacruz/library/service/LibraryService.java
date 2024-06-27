package com.altheacruz.library.service;

import com.altheacruz.library.model.Book;

import java.util.List;

public interface LibraryService {
    public void addBook(Book book);
    public void addFictionBook(int refNo, String title, String author, String ISBN, int pubYear, String category, String genre, String ageRating);
    public void addTextBook(int refNo, String title, String author, String ISBN, int pubYear, String category, String subject, String academicLevel);
    public void addMagazine(int refNo, String title, String author, String ISBN, int pubYear,String category, int issueNo, String monthlyEdition);
    public void removeBook(int refNo);
    public void showAllBooks();
    public List<Book> searchBooks(String criteria, String value);
    public List<Book> getBooks();
}
