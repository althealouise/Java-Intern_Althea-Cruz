package com.altheacruz.ecommerce.service.implementation;

import com.altheacruz.ecommerce.model.Product;
import com.altheacruz.ecommerce.service.CartService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CartServiceImplementation implements CartService {
    private List<Product> cartContents;
    private static final Logger logger = Logger.getLogger(CartServiceImplementation.class.getName());

    public CartServiceImplementation() {
        this.cartContents = new ArrayList<>();
    }

    // add product to cart
    public void addToCart(Product item) {
        cartContents.add(item);
        logger.info(item.getName() + " is added to your cart");
    }

    // show all cart contents
    public void showCart() {
        if (cartContents.isEmpty()) {
            logger.info("There are no products in your cart.");
        } else {
            logger.info("Displaying " + cartContents.size() + " of " + cartContents.size() + " results:");
            printCartContents(cartContents);
        }
    }

    // calculate the total of current cart contents
    public double calculateTotal() {
        double total = 0;
        for (Product item : cartContents) {
            total += item.getPrice();
        }
        return total;
    }

    // print only product id, name, and price
    private void printCartContents(List<Product> cartContents) {
        logger.info("Your Cart:");
        System.out.println("+-------+-----------------------------------------+---------------+");
        System.out.println("| ID    | Product Name                            | Price         |");
        System.out.println("+-------+-----------------------------------------+---------------+");

        for (Product item : cartContents) {
            System.out.format("| %-5d | %-39s | %-13.2f |\n",
                    item.getId(), item.getName(), item.getPrice());
        }

        System.out.println("+-------+-----------------------------------------+---------------+");
    }

    public List<Product> getCartContents() {
        return cartContents;
    }
}
