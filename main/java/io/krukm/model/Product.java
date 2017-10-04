package io.krukm.model;

public enum Product {
    PRODUCT_ONE(1.00, "COLA"),
    PRODUCT_TWO(0.50, "PRODUCT_TWO"),
    PRODUCT_THREE(0.65, "PRODUCT_THREE");

    public double price;
    public String name;

    Product(double price, String name) {

        this.price = price;
        this.name = name;
    }
}
