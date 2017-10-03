package io.krukm.model;

import java.util.Stack;

public class CoinReserve {

    Stack<Coin> fiveStack = new Stack<>();
    Stack<Coin> tenStack = new Stack<>();
    Stack<Coin> twentyFiveStack = new Stack<>();
    Stack<Coin> coinReturn = new Stack<>();

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

    public int reserveTotal() {

        Stack<Coin> fiveStack = this.fiveStack;
        Stack<Coin> tenStack = this.tenStack;
        Stack<Coin> twentyFiveStack = this.twentyFiveStack;

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

    public void removeCoin(Stack<Coin> coinStack) {

        if(!coinStack.empty()) {
            coinStack.pop();
        }
    }

    public int makeChange(int productPrice, int coinsInserted) {

        int change = coinsInserted - productPrice;
        int twentyFives = 0;
        int tens = 0;
        int fives = 0;

        Stack<Coin> fiveStack = this.fiveStack;
        Stack<Coin> tenStack = this.tenStack;
        Stack<Coin> twentyFiveStack = this.twentyFiveStack;
        Stack<Coin> coinReturn = this.coinReturn;


        if(twentyFiveStack.size() > 0 && tenStack.size() > 0 && fiveStack.size() > 0) {
            twentyFives = change / 25;
            tens = (change % 25) / 10;
            fives = ((change % 25) % 10) / 5;
        } else if (twentyFiveStack.size() > 0 && tenStack.size() > 0) {
            twentyFives = change / 25;
            tens = (change % 25) / 10;
        } else if (twentyFiveStack.size() > 0 && fiveStack.size() > 0) {
            twentyFives = change / 25;
            fives = (change % 25) / 5;
        } else if (tenStack.size() > 0 && fiveStack.size() > 0) {
            tens = change / 10;
            fives = (change % 10) / 5;
        } else {
            fives = change / 5;
        }

        while (twentyFives > 0) {
            coinReturn.push(Coin.TWENTYFIVE);
            removeCoin(twentyFiveStack);
            twentyFives --;
        }

        while (tens > 0) {
            coinReturn.push(Coin.TEN);
            removeCoin(tenStack);
            tens --;
        }

        while (fives > 0) {
            coinReturn.push(Coin.FIVE);
            removeCoin(fiveStack);
            fives --;
        }

        return stackTotal(coinReturn);
    }

    public Stack<Coin> getCoinReturn() {
        Stack<Coin> tempReturn = new Stack<>();

        for (Coin coin : coinReturn) {
            tempReturn.push(coin);
        }

        this.coinReturn.removeAllElements();
        return tempReturn;
    }

    public int stackTotal(Stack<Coin> coinStack) {

        int total = 0;

        for (Coin coin : coinStack) {
            total = total + coin.value;
        }
        return total;
    }


    public void stockReserve() {

        for(int i = 0; i < 10; i++) {

            fiveStack.push(Coin.FIVE);
            tenStack.push(Coin.TEN);
            twentyFiveStack.push(Coin.TWENTYFIVE);
        }
    }
}
