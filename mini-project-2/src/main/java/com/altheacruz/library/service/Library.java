package com.altheacruz.library.service;

import com.altheacruz.library.model.Book;
import com.altheacruz.library.model.FictionBook;
import com.altheacruz.library.model.NonFictionBook;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Library {
    private List<Book> bookList;
    private static final Logger logger = Logger.getLogger(Library.class.getName());

    public Library() {
        this.bookList = new ArrayList<>();
        initializeBooks(); // Initialize books when LibraryService is instantiated
    }

    private void initializeBooks() {
        // Hardcoded initial books
        Book book1 = new FictionBook(1, "Harry Potter and the Philosopher's Stone", "J.K. Rowling", "9780590353403", 1997, "Fantasy");
        Book book2 = new FictionBook(2, "To Kill a Mockingbird", "Harper Lee", "9780061120084", 1960, "Classic");
        Book book3 = new NonFictionBook(3, "Sapiens: A Brief History of Humankind", "Yuval Noah Harari", "9780062316097", 2011, "History");
        Book book4 = new NonFictionBook(4, "The Elements of Style", "William Strunk Jr. and E.B. White", "9780205309023", 1918, "Language");
        Book book5 = new FictionBook(5, "The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", 1925, "Classic");

        // Add books to the library
        addBook(book1);
        addBook(book2);
        addBook(book3);
        addBook(book4);
        addBook(book5);
    }

    public void addBook(Book book) {
        if (isDuplicateRefNo(book.getRefNo())) {
            logger.warning("Book with reference number " + book.getRefNo() + " already exists.");
            System.out.println("Error: Book with reference number " + book.getRefNo() + " already exists.");
        } else {
            bookList.add(book);
            logger.info("Book added: " + book);
            System.out.println("Book added successfully:");
            printBookTable(List.of(book)); // Display the added book
        }
    }

    private boolean isDuplicateRefNo(int refNo) {
        for (Book book : bookList) {
            if (book.getRefNo() == refNo) {
                return true;
            }
        }
        return false;
    }


    public void addFictionBook(int refNo, String title, String author, String ISBN, int pubYear, String genre) {
        Book newBook = new FictionBook(refNo, title, author, ISBN, pubYear, genre);
        addBook(newBook);
    }

    public void addNonFictionBook(int refNo, String title, String author, String ISBN, int pubYear, String subject) {
        Book newBook = new NonFictionBook(refNo, title, author, ISBN, pubYear, subject);
        addBook(newBook);
    }

    public void removeBook(int refNo) {
        Book bookToRemove = null;
        for (Book book : bookList) {
            if (book.getRefNo() == refNo) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null) {
            bookList.remove(bookToRemove);
            logger.info("Book removed: " + bookToRemove);
        } else {
            logger.warning("Book not found.");
        }
    }

    public void showAllBooks() {
        if (bookList.isEmpty()) {
            logger.info("No books available.");
        } else {
            System.out.println("Displaying " + bookList.size() + " of " + bookList.size() + " results:");
            printBookTable(bookList);
        }
    }

    public void searchBooks(String criteria, String value) {
        List<Book> foundBooks = new ArrayList<>();
        value = value.toLowerCase();
        for (Book book : bookList) {
            switch (criteria.toLowerCase()) {
                case "author":
                    if (book.getAuthor().toLowerCase().contains(value)) {
                        foundBooks.add(book);
                    }
                    break;
                case "title":
                    if (book.getTitle().toLowerCase().contains(value)) {
                        foundBooks.add(book);
                    }
                    break;
                default:
                    logger.warning("Invalid search criteria.");
                    return;
            }
        }

        if (foundBooks.isEmpty()) {
            logger.info("No books found with the given criteria.");
        } else {
            System.out.println("Displaying " + foundBooks.size() + " of " + foundBooks.size() + " results:");
            printBookTable(foundBooks);
        }
    }

    private void printBookTable(List<Book> books) {
        System.out.println("+-------+------------------------------------------------------------+-------------------------------------+---------------+-------+----------+");
        System.out.println("| RefNo | Title                                                      | Author                              | ISBN          | Year  | Category |");
        System.out.println("+-------+------------------------------------------------------------+-------------------------------------+---------------+-------+----------+");
        for (Book book : books) {
            System.out.format("| %-5d | %-58s | %-35s | %-13s | %-5d | %-8s |\n",
                    book.getRefNo(), book.getTitle(), book.getAuthor(), book.getISBN(), book.getPubYear(), book instanceof FictionBook ? ((FictionBook) book).getGenre() : ((NonFictionBook) book).getSubject());
        }
        System.out.println("+-------+------------------------------------------------------------+-------------------------------------+---------------+-------+----------+");
    }
}
