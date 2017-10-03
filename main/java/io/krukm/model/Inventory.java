package io.krukm.model;

import java.util.Stack;

public class Inventory {

    Stack<Product> colaStack = new Stack<>();
    Stack<Product> chipsStack = new Stack<>();
    Stack<Product> candyStack = new Stack<>();

    public void stockInventory() {
        for(int i = 0; i < 10; i++) {
            colaStack.push(Product.COLA);
            chipsStack.push(Product.CHIPS);
            candyStack.push(Product.CANDY);
        }
    }
}
