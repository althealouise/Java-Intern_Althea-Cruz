package com.altheacruz.ecommerce.service;

import com.altheacruz.ecommerce.model.Product;

import java.util.List;

public interface CartService {
    public void addToCart(Product product);
    public void showCart();
    public List<Product> getCartContents();
    public double calculateTotal();
}
