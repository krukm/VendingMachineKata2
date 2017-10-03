package io.krukm.model;

import java.util.Stack;

public class CoinReserve {

    Stack<Coin> fiveStack = new Stack<>();
    Stack<Coin> tenStack = new Stack<>();
    Stack<Coin> twentyFiveStack = new Stack<>();

    public boolean coinAccepted(Coin coin) {

        switch(coin) {
            case ONE:
                return false;
            case FIVE:
                return true;
            case TEN:
                return true;
            case TWENTYFIVE:
                return true;
        }
        if (coinAccepted(coin)) return true;
        else return false;
    }

    public int reserveTotal(Stack<Coin> fiveStack, Stack<Coin> tenStack, Stack<Coin> twentyFiveStack) {

        fiveStack = this.fiveStack;
        tenStack = this.tenStack;
        twentyFiveStack = this.twentyFiveStack;

        return (fiveStack.size() * 5) + (tenStack.size() * 10) + (twentyFiveStack.size() * 25);

    }

    public void addCoin(Coin coin) {

        if(coinAccepted(coin)) {

            switch(coin) {
                case FIVE:
                    fiveStack.push(Coin.FIVE);
                case TEN:
                    tenStack.push(Coin.TEN);
                case TWENTYFIVE:
                    twentyFiveStack.push(Coin.TWENTYFIVE);
            }
        }
    }



    public void stockReserve() {

        for(int i = 0; i < 10; i++) {

            fiveStack.push(Coin.FIVE);
            tenStack.push(Coin.TEN);
            twentyFiveStack.push(Coin.TWENTYFIVE);
        }
    }
}
