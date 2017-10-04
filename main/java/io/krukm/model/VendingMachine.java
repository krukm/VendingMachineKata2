package io.krukm.model;


import java.util.Stack;

public class VendingMachine {

    Display display = new Display();
    CoinReserve coinReserve = new CoinReserve();
    Inventory inventory = new Inventory();



    VendingMachine() {
        display.setMessage(0, 0);
    }

    public void insertCoin(Coin coin) {
        if (coinReserve.coinAccepted(coin)) {
            coinReserve.coinHold.add(coin);
            display.setMessage(5, coinReserve.stackTotal(coinReserve.coinHold));
        }
    }

    public Stack<Coin> activateCoinReturn() {
        return coinReserve.activateCoinReturn();
    }

    public boolean enoughCoinsEntered(Product product, Stack<Coin> coinHold) {

        if (coinReserve.stackTotal(coinHold) > product.price) {
            return true;
        }

        display.setMessage(2, product.price);
        return false;
    }

    public Product makePurchase(Product product, Stack<Coin> coinHold) {
        if (enoughCoinsEntered(product, coinHold)) {
            if (inventory.productInStock(product)) {
                return inventory.dispenseProduct(product);
            }
        }
        return null;
    }


}
