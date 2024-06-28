package com.altheacruz.ecommerce;

import com.altheacruz.ecommerce.service.implementation.CartServiceImplementation;
import com.altheacruz.ecommerce.service.implementation.ProductServiceImplementation;
import com.altheacruz.ecommerce.model.Product;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Scanner scan = new Scanner(System.in);
    private static final ProductServiceImplementation productService = new ProductServiceImplementation();
    private static final CartServiceImplementation cartService = new CartServiceImplementation();
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
        System.out.println("     ALC E-COMMERCE SYSTEM MENU     ");
        System.out.println("====================================");
        System.out.println("[a] Show all products");
        System.out.println("[b] Search products");
        System.out.println("[c] Add products to cart");
        System.out.println("[d] View cart");
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
                showAllProducts();
                break;
            case 'B':
                searchProducts();
                break;
            case 'C':
                addToCart();
                break;
            case 'D':
                viewCart();
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

    // method to show all products in the productList
    private static void showAllProducts() {
        logger.info("All products listed in our stocks:");
        productService.showProducts();
    }

    // method to search products based on keywords
    private static void searchProducts() {
        System.out.print("Search by [a] Name or [b] Brand: ");
        char searchChoice = Character.toUpperCase(scan.next().charAt(0));
        scan.nextLine();

        String searchCriteria = null;
        switch (searchChoice) {
            case 'A':
                searchCriteria = "name";
                break;
            case 'B':
                searchCriteria = "brand";
                break;
            default:
                logger.warning("Invalid search criteria.");
                return;
        }

        System.out.print("Search the " + searchCriteria + ": ");
        String searchValue = scan.nextLine();
        productService.searchProducts(searchCriteria, searchValue);
    }

    // method to add products to cart
    private static void addToCart() {
        while (true) {
            System.out.print("Enter Product ID (0 to complete transaction): ");
            int itemCode = scan.nextInt();
            scan.nextLine(); // consume newline

            Product product = productService.getAllProducts().stream()
                    .filter(p -> p.getId() == itemCode)
                    .findFirst()
                    .orElse(null);

            if (product == null) {
                System.out.println("Product ID not found. Please try again.");
            } else {
                cartService.addToCart(product);
            }

            if (itemCode == 0) {
                break; // exit the loop if 0 is entered
            }
        }
        viewCart();
    }


    // method to view cart contents and total price
    private static void viewCart() {
        cartService.showCart();
        double total = cartService.calculateTotal();
        System.out.println("|TOTAL PRICE                                      | " + total + "         |");
        System.out.println("+-------------------------------------------------+---------------+");
    }

    // method to terminate the program with exit status 0 (successful termination)
    private static void exitProgram() {
        System.out.println("Program terminated.");
        System.exit(0);
    }
}
