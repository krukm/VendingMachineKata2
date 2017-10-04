package io.krukm.model;

import java.util.Stack;

public class VendingMachine {

    Display display = new Display();
    CoinReserve coinReserve = new CoinReserve();
    Stack<Coin> insertedCoinHold = new Stack<>();




    VendingMachine() {
        display.setMessage(0, 0);
    }

    public void insertCoin(Coin coin) {
        if (coinReserve.coinAccepted(coin)) {
            insertedCoinHold.add(coin);
            display.setMessage(5, coinReserve.stackTotal(insertedCoinHold));
        }
    }

}
