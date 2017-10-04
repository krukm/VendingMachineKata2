package io.krukm.model;


import java.util.Stack;

public class VendingMachine {

    Display display = new Display();
    CoinReserve coinReserve = new CoinReserve();



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

}
