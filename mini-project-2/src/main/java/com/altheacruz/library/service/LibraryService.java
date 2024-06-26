package com.altheacruz.library.service;

import com.altheacruz.library.model.Book;

import java.util.List;

public interface LibraryService {
    public void addBook(Book book);
    public void addFictionBook(int refNo, String title, String author, String ISBN, int pubYear, String genre);
    public void addNonFictionBook(int refNo, String title, String author, String ISBN, int pubYear, String subject);
    public void removeBook(int refNo);
    public void showAllBooks();
    public List<Book> searchBooks(String criteria, String value);
    public List<Book> getBooks();

}
