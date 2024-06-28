package com.altheacruz.ecommerce.service;

import com.altheacruz.ecommerce.model.Product;

import java.util.List;

public interface ProductService {
    public void addProduct (Product product);
    public void addClothingProduct(int id, String name, double price, String brand, String size, String material);
    public void addDeviceProduct(int id, String name, double price, String brand, String type, String warrantyPeriod);
    public void addMakeupProduct(int id, String name, double price, String brand, String netWt, String expiry);
    public List<Product> searchProducts(String criteria, String value);
    public void showProducts();
    public List<Product> getAllProducts();
}
