package io.krukm.model;

import java.util.LinkedList;
import java.util.Queue;

class Inventory {

    Queue<Product> productOneRow = new LinkedList<>();
    Queue<Product> productTwoRow = new LinkedList<>();
    Queue<Product> productThreeRow = new LinkedList<>();


    boolean productInStock(Product product) {

        return getProductStock(product) > 0;

    }

    int getProductStock(Product product) {
        int productInventory = 0;

        switch (product) {
            case PRODUCT_ONE:
                productInventory = this.productOneRow.size();
                break;
            case PRODUCT_TWO:
                productInventory = this.productTwoRow.size();
                break;
            case PRODUCT_THREE:
                productInventory = this.productThreeRow.size();
                break;
        }
        return productInventory;
    }

    Product dispenseProduct(Product product) {
        switch (product) {
            case PRODUCT_ONE:
                this.productOneRow.remove();
            case PRODUCT_TWO:
                this.productTwoRow.remove();
            case PRODUCT_THREE:
                this.productThreeRow.remove();
        }
        return product;
    }

    void stockInventory() {

        productOneRow.clear();
        productTwoRow.clear();
        productThreeRow.clear();

        for(int i = 0; i < 10; i++) {
            productOneRow.add(Product.PRODUCT_ONE);
            productTwoRow.add(Product.PRODUCT_TWO);
            productThreeRow.add(Product.PRODUCT_THREE);
        }
    }
}
