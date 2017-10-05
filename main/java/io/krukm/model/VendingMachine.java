package io.krukm.model;


import java.util.Stack;

public class VendingMachine implements UpdateDisplay {

    private Display display = new Display();
    CoinReserve coinReserve = new CoinReserve();
    private Inventory inventory = new Inventory();



    VendingMachine() {
        display.setMessage(0,0);
    }

    public void insertCoin(Coin coin) {
        if (coinReserve.coinAccepted(coin)) {
            coinReserve.coinHold.add(coin);
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

    public void stockProducts() {
        inventory.stockInventory();
    }

    public int checkProductStock(Product product) {
        return inventory.getProductStock(product);
    }

    @Override
    public void updateDisplay() {

        if (coinReserve.coinHold.size() > 0) {
            display.setMessage(5, coinReserve.stackTotal(coinReserve.coinHold));
        } else if (!coinReserve.canMakeChange()) {
            display.setMessage(4, 0);
        } else {
            display.setMessage(0, 0);
        }
    }

    @Override
    public String show() {
        return display.getMessage();
    }
}
