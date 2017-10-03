package io.krukm.model;

import java.util.Stack;

public class CoinReserve {

    Stack<Coin> nickelStack = new Stack<>();
    Stack<Coin> dimeStack = new Stack<>();
    Stack<Coin> quarterStack = new Stack<>();

    public boolean coinAccepted(Coin coin) {

        switch(coin) {
            case PENNY:
                return false;
            case NICKEL:
                nickelStack.push(Coin.NICKEL);
                return true;
            case DIME:
                dimeStack.push(Coin.DIME);
                return true;
            case QUARTER:
                quarterStack.push(Coin.QUARTER);
                return true;
        }
        if (coinAccepted(coin)) return true;
        else return false;
    }
}
