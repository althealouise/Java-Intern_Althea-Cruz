package com.altheacruz.ecommerce.model;

public class ClothingProduct extends Product {
    private String size;
    private String material;

    public ClothingProduct(int id, String name, double price, String brand, String size, String material) {
        super(id, name, price, brand);
        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "ClothingProduct{" +
                "size='" + size + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
