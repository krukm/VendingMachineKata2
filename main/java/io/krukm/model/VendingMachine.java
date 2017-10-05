package io.krukm.model;


import java.util.Stack;

public class VendingMachine implements UpdateDisplay {

    private Display display = new Display();
    private CoinReserve coinReserve = new CoinReserve();
    private Inventory inventory = new Inventory();



    VendingMachine() {
        display.setMessage(0,0);
    }

    void insertCoin(Coin coin) {
        if (coinReserve.coinAccepted(coin)) {
            coinReserve.coinHold.add(coin);
        }
    }

    int insertedCoinTotal() {
        return coinReserve.stackTotal(coinReserve.coinHold);
    }

    Stack<Coin> getInsertedCoins() {
        return coinReserve.coinHold;
    }

    Stack<Coin> activateCoinReturn() {
        return coinReserve.getCoinReturn();
    }

    boolean enoughCoinsEntered(Product product, Stack<Coin> coinHold) {

        if (coinReserve.stackTotal(coinHold) > product.price) {
            return true;
        }

        display.setMessage(2, product.price);
        return false;
    }

    boolean makePurchase(Product product, Stack<Coin> coinHold) {
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

    void stockProducts() {
        inventory.stockInventory();
    }

    int checkProductStock(Product product) {
        return inventory.getProductStock(product);
    }

    void stockCoins() {
        coinReserve.stockReserve();
    }

    int checkCoinStock(Coin coin) {
        int tempTotal = 0;

        switch (coin) {
            case COIN_TWO:
                tempTotal = coinReserve.coinTwoSleeve.size();
                break;
            case COIN_THREE:
                tempTotal = coinReserve.coinThreeSleeve.size();
                break;
            case COIN_FOUR:
                tempTotal = coinReserve.coinFourSleeve.size();
                break;
        }
        return tempTotal;
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
