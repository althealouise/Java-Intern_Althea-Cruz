package com.altheacruz.ecommerce.service.implementation;

import com.altheacruz.ecommerce.model.ClothingProduct;
import com.altheacruz.ecommerce.model.DeviceProduct;
import com.altheacruz.ecommerce.model.MakeupProduct;
import com.altheacruz.ecommerce.model.Product;
import com.altheacruz.ecommerce.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ProductServiceImplementation implements ProductService {
    private List<Product> productList;
    private static final Logger logger = Logger.getLogger(CartServiceImplementation.class.getName());

    public ProductServiceImplementation() {
        this.productList = new ArrayList<>();
        allProducts();
    }

    // populate the productList
    private void allProducts() {
        addClothingProduct(101, "Slim Fit T-shirt", 19.99, "Nike", "M", "Cotton");
        addClothingProduct(102, "Skinny Jeans", 49.99, "Levi's", "32", "Denim");
        addClothingProduct(103, "Leather Jacket", 199.99, "Zara", "L", "Leather");
        addClothingProduct(104, "Summer Dress", 59.99, "H&M", "S", "Silk");
        addClothingProduct(105, "Wool Sweater", 79.99, "Uniqlo", "XL", "Wool");
        addDeviceProduct(106, "iPhone 13", 999.99, "Apple", "Smartphone", "1 year");
        addDeviceProduct(107, "MacBook Pro", 1999.99, "Apple", "Laptop", "2 years");
        addDeviceProduct(108, "Galaxy Tab S7", 649.99, "Samsung", "Tablet", "1 year");
        addDeviceProduct(109, "Noise Cancelling Headphones", 299.99, "Sony", "Headphones", "1 year");
        addDeviceProduct(110, "Apple Watch Series 6", 399.99, "Apple", "Smartwatch", "1 year");
        addMakeupProduct(111, "Fit Me Foundation", 14.99, "Maybelline", "30ml", "2025-12-31");
        addMakeupProduct(112, "Matte Lipstick", 9.99, "MAC", "3.5g", "2024-06-30");
        addMakeupProduct(113, "Volume Express Mascara", 12.99, "Maybelline", "10ml", "2025-01-31");
        addMakeupProduct(114, "Waterproof Eyeliner", 7.99, "L'Oreal", "1.2g", "2024-09-30");
        addMakeupProduct(115, "Baked Blush", 11.99, "Essence", "3.5g", "2025-03-31");
        addClothingProduct(116, "Pencil Skirt", 39.99, "Mango", "M", "Polyester");
        addDeviceProduct(117, "UltraSharp Monitor", 499.99, "Dell", "Monitor", "3 years");
        addMakeupProduct(118, "Instant Age Rewind Concealer", 8.99, "Maybelline", "6ml", "2025-11-30");
        addDeviceProduct(119, "All-in-One Printer", 129.99, "HP", "Printer", "1 year");
        addClothingProduct(120, "Running Shoes", 89.99, "Adidas", "42", "Synthetic");
    }

    // add product
    public void addProduct(Product product) {
        productList.add(product);
    }

    public void addClothingProduct(int id, String name, double price, String brand, String size, String material) {
        Product product = new ClothingProduct(id, name, price, brand, size, material);
        addProduct(product);
    }

    public void addDeviceProduct(int id, String name, double price, String brand, String type, String warrantyPeriod) {
        Product product = new ClothingProduct(id, name, price, brand, type, warrantyPeriod);
        addProduct(product);
    }

    public void addMakeupProduct(int id, String name, double price, String brand, String netWt, String expiry) {
        Product product = new ClothingProduct(id, name, price, brand, netWt, expiry);
        addProduct(product);
    }

    // show all the products in stock
    public void showProducts() {
        System.out.println("Displaying " + productList.size() + " of " + productList.size() + " results:");
        printAllProducts(productList);
    }

    // search products based on a criteria of choice: name/brand
    public List<Product> searchProducts(String criteria, String value) {
        List<Product> foundProducts = new ArrayList<>();
        value = value.toLowerCase();
        for (Product product : productList) {
            switch (criteria.toLowerCase()) {
                case "name":
                    if (product.getName().toLowerCase().contains(value)) {
                        foundProducts.add(product); // display all products with name that contains the author value input
                    }
                    break;
                case "brand":
                    if (product.getBrand().toLowerCase().contains(value)) {
                        foundProducts.add(product); // display all products with brand that contains the title value input
                    }
                    break;
                default:
                    logger.warning("Invalid search criteria.");
                    return foundProducts;
            }
        }

        // no results based on the given value and criteria
        if (foundProducts.isEmpty()) {
            logger.info("No products found with the given criteria.");
        } else {
            System.out.println("Displaying " + foundProducts.size() + " of " + foundProducts.size() + " results:");
            printAllProducts(foundProducts);
        }
        return foundProducts;
    }

    private void printAllProducts(List<Product> productList) {
        logger.info("Displaying " + productList.size() + " of " + productList.size() + " results:");
        System.out.println("+-------+-----------------------------------------+-----------------------------+---------------+-------------------------------------------------------------+");
        System.out.println("| ID    | Product Name                            | Brand                       | Price         | Specifications                                              |");
        System.out.println("+-------+-----------------------------------------+-----------------------------+---------------+-------------------------------------------------------------+");

        // child classes, specs will be based on this
        for (Product product : productList) {
            String specs = "";
            if (product instanceof ClothingProduct) {
                ClothingProduct clothingProduct = (ClothingProduct) product;
                specs = "Size: " + clothingProduct.getSize() + ", Material: " + clothingProduct.getMaterial();
            } else if (product instanceof DeviceProduct) {
                DeviceProduct deviceProduct = (DeviceProduct) product;
                specs = "Device Type: " + deviceProduct.getType() + ", Warranty Period: " + deviceProduct.getWarrantyPeriod();
            } else if (product instanceof MakeupProduct) {
                MakeupProduct makeupProduct = (MakeupProduct) product;
                specs = "Net Wt.: " + makeupProduct.getNetWt() + ", Expiry: " + makeupProduct.getExpiry();
            }

            System.out.format("| %-5d | %-39s | %-27s | %-13.2f | %-59s |\n",
                    product.getId(), product.getName(), product.getBrand(), product.getPrice(), specs);
        }

        System.out.println("+-------+-----------------------------------------+-----------------------------+---------------+-------------------------------------------------------------+");
    }

    public List<Product> getAllProducts() {
        return productList;
    }
}
