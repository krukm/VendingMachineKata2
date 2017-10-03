package io.krukm.model;

import java.util.Stack;

public class Inventory {

    Stack<Product> colaStack = new Stack<>();
    Stack<Product> chipsStack = new Stack<>();
    Stack<Product> candyStack = new Stack<>();


    public boolean productInStock(Product product) {

        if(getProductStock(product) > 0) {
            return true;
        }

        return false;
    }

    public int getProductStock(Product product) {
        int productInventory = 0;

        switch (product) {
            case COLA:
                productInventory = this.colaStack.size();
                break;
            case CHIPS:
                productInventory = this.chipsStack.size();
                break;
            case CANDY:
                productInventory = this.candyStack.size();
                break;
        }
        return productInventory;
    }

    public Product dispenseProduct(Product product) {
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
