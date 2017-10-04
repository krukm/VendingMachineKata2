package io.krukm.model;

public enum Product {
    PRODUCT_ONE(100, "COLA"),
    PRODUCT_TWO(50, "PRODUCT_TWO"),
    PRODUCT_THREE(65, "PRODUCT_THREE");

    public int price;
    public String name;

    Product(int price, String name) {

        this.price = price;
        this.name = name;
    }
}
