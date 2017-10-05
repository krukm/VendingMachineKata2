package io.krukm.model;


import java.util.Stack;

public class VendingMachine {

    Display display = new Display();
    CoinReserve coinReserve = new CoinReserve();
    Inventory inventory = new Inventory();



    VendingMachine() {
        display.setMessage(0,0);
    }

    public void insertCoin(Coin coin) {
        if (coinReserve.coinAccepted(coin)) {
            coinReserve.coinHold.add(coin);
            display.setMessage(5, coinReserve.stackTotal(coinReserve.coinHold));
        }
    }

    public Stack<Coin> activateCoinReturn() {
        return coinReserve.getCoinReturn();
    }

    public boolean enoughCoinsEntered(Product product, Stack<Coin> coinHold) {

        if (coinReserve.stackTotal(coinHold) > product.price) {
            return true;
        }

        display.setMessage(2, product.price);
        return false;
    }

    public boolean makePurchase(Product product, Stack<Coin> coinHold) {
        if (enoughCoinsEntered(product, coinHold)) {
            if (inventory.productInStock(product)) {
                inventory.dispenseProduct(product);
                display.setMessage(1, product.price);
                if (coinReserve.stackTotal(coinHold) > product.price) {
                    if (coinReserve.canMakeChange()) {
                        coinReserve.makeChange(product.price, coinReserve.stackTotal(coinHold));
                        activateCoinReturn();
                    }
                }
                coinReserve.depositCoins(coinHold);
                return true;
            } else if (!inventory.productInStock(product)){
                display.setMessage(3, product.price);
                return false;
            }
        }
        return false;
    }
}
