package io.krukm.model;

public enum Product {
    COLA(1.00),
    CHIPS(0.50),
    CANDY(0.65);

    public double price;

    Product(double price) {

        this.price = price;

    }
}
