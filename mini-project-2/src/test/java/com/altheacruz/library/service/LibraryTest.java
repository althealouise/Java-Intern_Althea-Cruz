package com.altheacruz.library.service;

import com.altheacruz.library.model.Book;
import com.altheacruz.library.model.FictionBook;
import com.altheacruz.library.model.NonFictionBook;
import com.altheacruz.library.service.implementation.LibraryServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class LibraryTest {

    private LibraryServiceImplementation libraryService;

    @BeforeEach
    void setUp() {
        libraryService = new LibraryServiceImplementation();
    }

    @Test
    void testAddBook() {
        // add a new book with 12 as the reference number
        Book book = new FictionBook(12, "Test Add Book", "Althea Cruz", "1234567890123", 2020, "Inspiring");
        libraryService.addBook(book);

        // the newly-added book should be shown in the bookList
        List<Book> books = libraryService.getBooks();
        assertTrue(books.contains(book), "The book should be added to the library"); // message to be displayed if the test fails
    }

    @Test
    void testAddDuplicateBook() {
        // attempt to create 2 books with the same reference number
        Book book = new FictionBook(13, "Test Duplicate Book", "Althea Cruz", "1234567890123", 2020, "Fantasy");
        libraryService.addBook(book);

        Book duplicateBook = new FictionBook(13, "Test Duplicate Book2", "Althea Cruz", "1234567890124", 2021, "Fantasy");
        libraryService.addBook(duplicateBook);

        // the program should not accept duplicate entries based on the reference number
        List<Book> books = libraryService.getBooks();
        assertEquals(6, books.size(), "Duplicate books (equal refNo) should not be added.");
    }

    @Test
    void testRemoveBook() {
        // create an extra book with 55 as the reference number
        Book book = new NonFictionBook(55, "Test Remove Book", "Althea Cruz", "9876543210987", 2019, "Mathematics");
        libraryService.addBook(book);

        // pass 55 to the remove book function of the Library service
        libraryService.removeBook(55);

        // the updated bookList should
        List<Book> books = libraryService.getBooks();
        assertFalse(books.contains(book), "The book should be removed from the library.");
    }

    @Test
    void testShowAllBooks() {
        // populate the bookList content with the 5 books in the initializeBooks() method
        List<Book> initialBooks = libraryService.getBooks();
        assertEquals(5, initialBooks.size(), "There should be 5 initial books in the library"); // these are from the initializeBooks() method

        // add a new book for testing
        Book newBook = new FictionBook(8, "Another Book", "Althea Cruz", "1122334455667", 2021, "Adventure");
        libraryService.addBook(newBook);

        // the bookList shown should be a total of 6 books
        List<Book> allBooks = libraryService.getBooks();
        assertEquals(6, allBooks.size(), "There should be 6 books in the library after adding one");
    }

    @Test
    void testSearchBooksByTitle() {
        // add 2 books with "the" in the title
        Book book1 = new FictionBook(9, "The beginning", "Althea Cruz", "9988776655443", 2022, "Adventure");
        Book book2 = new FictionBook(10, "The End", "Althea Cruz", "2233445566778", 2023, "Thriller");
        libraryService.addBook(book1);
        libraryService.addBook(book2);

        // select search by title as the criteria, and "The" as the keyword/value
        List<Book> searchResults;
        searchResults = libraryService.searchBooks("title", "The");

        // the search results should contain all the books with "The" in the title
        assertTrue(searchResults.contains(book1), "Book1 should appear in the search results");
        assertTrue(searchResults.contains(book2), "Book2 should appear in the search results.");
    }
}
