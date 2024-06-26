package com.altheacruz.library.service.implementation;

import com.altheacruz.library.model.Book;
import com.altheacruz.library.model.FictionBook;
import com.altheacruz.library.model.NonFictionBook;
import com.altheacruz.library.service.LibraryService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class LibraryServiceImplementation implements LibraryService {
    private List<Book> bookList; // store all books in a List
    private static final Logger logger = Logger.getLogger(LibraryServiceImplementation.class.getName());

    public LibraryServiceImplementation() {
        this.bookList = new ArrayList<>();
        initializeBooks();
    }

    // method to initialize the bookList when Library service is instantiated
    private void initializeBooks() {
        // hardcoded initial books (sample only)
        Book book1 = new FictionBook(1, "Harry Potter and the Philosopher's Stone", "J.K. Rowling", "9780590353403", 1997, "Fantasy");
        Book book2 = new FictionBook(2, "To Kill a Mockingbird", "Harper Lee", "9780061120084", 1960, "Classic");
        Book book3 = new NonFictionBook(3, "Sapiens: A Brief History of Humankind", "Yuval Noah Harari", "9780062316097", 2011, "History");
        Book book4 = new NonFictionBook(4, "The Elements of Style", "William Strunk Jr. and E.B. White", "9780205309023", 1918, "Language");
        Book book5 = new FictionBook(5, "The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", 1925, "Classic");

        // Add book entries to the library
        addBook(book1);
        addBook(book2);
        addBook(book3);
        addBook(book4);
        addBook(book5);
    }

    // handle the add function using the user inputs
    public void addBook(Book book) {
        // log warning of duplicate book
        if (isDuplicateRefNo(book.getRefNo())) {
            logger.warning("Book with reference number " + book.getRefNo() + " already exists.");
        } else {
            bookList.add(book);
            logger.info("Book added: " + book);
            System.out.println("Book added successfully:");
            printBookTable(List.of(book)); // display the added book
        }
    }

    // check if the book with the reference number input is already existing in the bookList
    private boolean isDuplicateRefNo(int refNo) {
        for (Book book : bookList) {
            if (book.getRefNo() == refNo) {
                return true;
            }
        }
        return false;
    }

    // handle adding a new fiction book
    public void addFictionBook(int refNo, String title, String author, String ISBN, int pubYear, String genre) {
        Book newBook = new FictionBook(refNo, title, author, ISBN, pubYear, genre);
        addBook(newBook);
    }

    // handle adding a new non-fiction book
    public void addNonFictionBook(int refNo, String title, String author, String ISBN, int pubYear, String subject) {
        Book newBook = new NonFictionBook(refNo, title, author, ISBN, pubYear, subject);
        addBook(newBook);
    }

    // handle removing a book using the reference number
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
            logger.warning("Book not found."); // reference number input does not exist
        }
    }

    // show all the books stored in the bookList
    public void showAllBooks() {
        if (bookList.isEmpty()) {
            logger.info("No books available.");
        } else {
            System.out.println("Displaying " + bookList.size() + " of " + bookList.size() + " results:");
            printBookTable(bookList);
        }
    }

    // search books based on a criteria of choice: author/title
    public List<Book> searchBooks(String criteria, String value) {
        List<Book> foundBooks = new ArrayList<>();
        value = value.toLowerCase();
        for (Book book : bookList) {
            switch (criteria.toLowerCase()) {
                case "author":
                    if (book.getAuthor().toLowerCase().contains(value)) {
                        foundBooks.add(book); // display all books with author that contains the value input
                    }
                    break;
                case "title":
                    if (book.getTitle().toLowerCase().contains(value)) {
                        foundBooks.add(book); // display all books with title that contains the value input
                    }
                    break;
                default:
                    logger.warning("Invalid search criteria.");
                    return foundBooks;
            }
        }

        // no results based on the given value and criteria
        if (foundBooks.isEmpty()) {
            logger.info("No books found with the given criteria.");
        } else {
            System.out.println("Displaying " + foundBooks.size() + " of " + foundBooks.size() + " results:");
            printBookTable(foundBooks);
        }
        return foundBooks;
    }

    // print the bookList in a tabular form
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

    // getter method for bookList
    public List<Book> getBooks() {
        return bookList;
    }
}
