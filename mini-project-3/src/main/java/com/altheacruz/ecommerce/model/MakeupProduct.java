package com.altheacruz.ecommerce.model;

public class MakeupProduct extends Product {
    String netWt;
    String expiry;

    public MakeupProduct(int id, String name, double price, String brand, String netWt, String expiry) {
        super(id, name, price, brand);
        this.netWt = netWt;
        this.expiry = expiry;
    }

    public String getNetWt() {
        return netWt;
    }

    public void setNetWt(String netWt) {
        this.netWt = netWt;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    @Override
    public String toString() {
        return "MakeupProduct{" +
                "netWt='" + netWt + '\'' +
                ", expiry='" + expiry + '\'' +
                '}';
    }
}
