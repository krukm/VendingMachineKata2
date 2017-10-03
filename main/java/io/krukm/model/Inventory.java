package io.krukm.model;

import java.util.Stack;

public class Inventory {

    Stack<Product> colaStack = new Stack<>();
    Stack<Product> chipsStack = new Stack<>();
    Stack<Product> candyStack = new Stack<>();


    public int getProductStock(Product product) {
        int inventory = 0;

        switch (product) {
            case COLA:
                inventory = this.colaStack.size();
                break;
            case CHIPS:
                inventory = this.chipsStack.size();
                break;
            case CANDY:
                inventory = this.candyStack.size();
                break;
        }
        return inventory;
    }

    public Product removeProduct(Product product) {
        switch (product) {
            case COLA:
                this.colaStack.pop();
            case CHIPS:
                this.chipsStack.pop();
            case CANDY:
                this.candyStack.pop();
        }
        return product;
    }

    public void stockInventory() {
        for(int i = 0; i < 10; i++) {
            colaStack.push(Product.COLA);
            chipsStack.push(Product.CHIPS);
            candyStack.push(Product.CANDY);
        }
    }
}
