package com.altheacruz.library;

import com.altheacruz.library.service.Library;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Scanner scan = new Scanner(System.in);
    private static final Library libraryService = new Library();
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        while (true) {
            showMenu();
            handleMenuOptions();
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

        System.out.print("Action: ");
        menuChoice = Character.toUpperCase(scan.next().charAt(0));
        scan.nextLine(); // Consume newline

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
                return; // Return to prompt for action again
        }

        // Flush logs and output stream before showing the menu again
        System.out.flush();
        logger.info("Action completed. Showing menu again.");
    }

    private static void addBook() {
        System.out.println("Please enter book information");
        System.out.print("Reference Number: ");
        int refNo = scan.nextInt();
        scan.nextLine(); // Consume newline
        System.out.print("Title: ");
        String title = scan.nextLine();
        System.out.print("Author: ");
        String author = scan.nextLine();
        System.out.print("ISBN: ");
        String ISBN = scan.nextLine();
        System.out.print("Publication Year: ");
        int pubYear = scan.nextInt();
        scan.nextLine(); // Consume newline

        // Determine book type
        System.out.print("Is this a [a] fiction or [b] non-fiction book? ");
        char bookType = Character.toUpperCase(scan.next().charAt(0));
        scan.nextLine(); // Consume newline

        if (bookType == 'A') {
            System.out.print("Genre: ");
            String genre = scan.nextLine();
            libraryService.addFictionBook(refNo, title, author, ISBN, pubYear, genre);
        } else if (bookType == 'B') {
            System.out.print("Subject: ");
            String subject = scan.nextLine();
            libraryService.addNonFictionBook(refNo, title, author, ISBN, pubYear, subject);
        } else {
            logger.warning("Invalid book type.");
            return;
        }

    }

    private static void searchBooks() {
        System.out.print("Search by [a] Author or [b] Title: ");
        char searchChoice = Character.toUpperCase(scan.next().charAt(0));
        scan.nextLine(); // Consume newline

        String searchCriteria = null;
        switch (searchChoice) {
            case 'A':
                searchCriteria = "author";
                break;
            case 'B':
                searchCriteria = "title";
                break;
            default:
                logger.warning("Invalid search criteria.");
                return;
        }

        System.out.print("Search " + searchCriteria + ": ");
        String searchValue = scan.nextLine();
        libraryService.searchBooks(searchCriteria, searchValue);
    }

    private static void showAllBooks() {
        System.out.println("All books in the library:");
        libraryService.showAllBooks();
    }

    private static void deleteBook() {
        System.out.print("Enter the reference number of the book to delete: ");
        int deleteRefNo = scan.nextInt();
        scan.nextLine(); // Consume newline
        libraryService.removeBook(deleteRefNo);
        logger.info("Book deleted successfully.");
    }

    private static void exitProgram() {
        System.out.println("Exiting the program. Goodbye!");
        System.exit(0); // Terminate the program with exit status 0 (successful termination)
    }
}
