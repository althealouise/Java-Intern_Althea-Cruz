package com.altheacruz.ecommerce.model;

public class DeviceProduct extends Product {
    String type;
    String warrantyPeriod;

    public DeviceProduct(int id, String name, double price, String brand, String type, String warrantyPeriod) {
        super(id, name, price, brand);
        this.type = type;
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public String toString() {
        return "DeviceProduct{" +
                "type='" + type + '\'' +
                ", warrantyPeriod='" + warrantyPeriod + '\'' +
                '}';
    }
}
