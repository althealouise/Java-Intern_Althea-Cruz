package com.altheacruz.library;

import com.altheacruz.library.service.implementation.LibraryServiceImplementation;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Scanner scan = new Scanner(System.in);
    private static final LibraryServiceImplementation libraryService = new LibraryServiceImplementation();
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        while (true) {
            showMenu();
            handleMenuOptions(); // this is needed to handle incorrect inputs
            // loop until input is correct
        }
    }

    private static void showMenu() {
        System.out.println("====================================");
        System.out.println("   LIBRARY MANAGEMENT SYSTEM MENU   ");
        System.out.println("====================================");
        System.out.println("[a] Add a book");
        System.out.println("[b] Search books");
        System.out.println("[c] Show all books");
        System.out.println("[d] Delete a book");
        System.out.println("[e] Exit");
        System.out.println("====================================");
    }

    private static void handleMenuOptions() {
        char menuChoice;

        System.out.print("Action: "); // choice
            menuChoice = Character.toUpperCase(scan.next().charAt(0));
            scan.nextLine();

        switch (menuChoice) {
            case 'A':
                addBook();
                break;
            case 'B':
                searchBooks();
                break;
            case 'C':
                showAllBooks();
                break;
            case 'D':
                deleteBook();
                break;
            case 'E':
                exitProgram();
                return;
            default:
                System.out.println("Invalid option. Please choose again.");
                return; // prompt the menu for action again
        }

        // flush logs and output stream before showing the menu again (for easy readability of outputs)
        System.out.flush();
        logger.info("Action completed. Showing menu again.");
    }

    // method to handle inputs to add a new book
    private static void addBook() {
        System.out.println("Please enter book information");
        System.out.print("Reference Number: ");
            int refNo = scan.nextInt();
            scan.nextLine();
        System.out.print("Title: ");
            String title = scan.nextLine();
        System.out.print("Author: ");
            String author = scan.nextLine();
        System.out.print("ISBN: ");
            String ISBN = scan.nextLine();
        System.out.print("Publication Year: ");
            int pubYear = scan.nextInt();
            scan.nextLine();

        // get the book type
        System.out.println("What type of book is this?");
        System.out.println("[a] Fiction book");
        System.out.println("[b] Text book");
        System.out.println("[c] Magazine");
        System.out.print("Enter category: ");
            char bookType = Character.toUpperCase(scan.next().charAt(0));
            scan.nextLine();

        String category = "";

        if (bookType == 'A') {
            System.out.print("Genre: ");
                String genre = scan.nextLine();
            System.out.print("Age Rating: ");
                String ageRating = scan.nextLine();
            libraryService.addFictionBook(refNo, title, author, ISBN, pubYear, category, genre, ageRating);
        } else if (bookType == 'B') {
            System.out.print("Subject: ");
                String subject = scan.nextLine();
            System.out.print("Academic level: ");
                String academicLevel = scan.nextLine();
            libraryService.addTextBook(refNo, title, author, ISBN, pubYear, category, subject, academicLevel);
        } else if (bookType == 'C') {
            System.out.print("Issue No.: ");
                int issueNo = scan.nextInt();
                scan.nextLine();
            System.out.print("Monthly edition: ");
                String seasonEdition = scan.nextLine();
            libraryService.addMagazine(refNo, title, author, ISBN, pubYear, category, issueNo, seasonEdition);
        } else {
            logger.warning("Invalid book type.");
            return;
        }

    }

    // method to search books based on keywords
    private static void searchBooks() {
        System.out.print("Search by [a] Author or [b] Title [c] Category: ");
            char searchChoice = Character.toUpperCase(scan.next().charAt(0));
            scan.nextLine();

        String searchCriteria = null;
        switch (searchChoice) {
            case 'A':
                searchCriteria = "author";
                break;
            case 'B':
                searchCriteria = "title";
                break;
            case 'C':
                searchCriteria = "category";
                break;
            default:
                logger.warning("Invalid search criteria.");
                return;
        }

        System.out.print("Search the " + searchCriteria + ": ");
        String searchValue = scan.nextLine();
        libraryService.searchBooks(searchCriteria, searchValue);
    }

    // method to show all books in the bookList
    private static void showAllBooks() {
        System.out.println("All books in the library:");
        libraryService.showAllBooks();
    }

    // method to delete book using the reference number
    private static void deleteBook() {
        System.out.print("Enter the reference number of the book to delete: ");
            int deleteRefNo = scan.nextInt();
            scan.nextLine();
        libraryService.removeBook(deleteRefNo);
        logger.info("Book deleted successfully.");
    }

    // method to terminate the program with exit status 0 (successful termination)
    private static void exitProgram() {
        System.out.println("Program terminated.");
        System.exit(0);
    }
}
