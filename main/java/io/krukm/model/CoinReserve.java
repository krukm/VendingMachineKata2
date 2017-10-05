package io.krukm.model;

import java.util.ArrayList;
import java.util.Stack;

public class CoinReserve {

    Stack<Coin> coinTwoSleeve = new Stack<>();
    Stack<Coin> coinThreeSleeve = new Stack<>();
    Stack<Coin> coinFourSleeve = new Stack<>();
    Stack<Coin> coinHold = new Stack<>();

    public boolean coinAccepted(Coin coin) {

        switch(coin) {
            case COIN_ONE:
                return false;
            case COIN_TWO:
                return true;
            case COIN_THREE:
                return true;
            case COIN_FOUR:
                return true;
        }
        if (coinAccepted(coin)) return true;
        else return false;
    }

    public ArrayList<Coin> reserveTotal() {

        ArrayList<Coin> total = new ArrayList<>();
        Stack<Coin> coinTwoSleeve = this.coinTwoSleeve;
        Stack<Coin> coinThreeSleeve = this.coinThreeSleeve;
        Stack<Coin> coinFourSleeve = this.coinFourSleeve;

        total.addAll(coinTwoSleeve);
        total.addAll(coinThreeSleeve);
        total.addAll(coinFourSleeve);

        return total;

    }

    public void addCoin(Coin coin) {

        switch (coin) {
            case COIN_TWO:
                coinTwoSleeve.push(Coin.COIN_TWO);
                break;
            case COIN_THREE:
                coinThreeSleeve.push(Coin.COIN_THREE);
                break;
            case COIN_FOUR:
                coinFourSleeve.push(Coin.COIN_FOUR);
                break;
        }
    }

    public void removeCoin(Stack<Coin> coinStack) {

        if(!coinStack.empty()) {
            coinStack.pop();
        }
    }

    public void makeChange(int productPrice, int coinsInserted) {

        int change = coinsInserted - productPrice;
        int tempCoinFour = 0;
        int tempCoinThree = 0;
        int tempCoinTwo = 0;

        Stack<Coin> coinTwoSleeve = this.coinTwoSleeve;
        Stack<Coin> coinThreeSleeve = this.coinThreeSleeve;
        Stack<Coin> coinFourSleeve = this.coinFourSleeve;
        Stack<Coin> coinHold = this.coinHold;


        if(coinFourSleeve.size() > 0 && coinThreeSleeve.size() > 0 && coinTwoSleeve.size() > 0) {
            tempCoinFour = change / Coin.COIN_FOUR.value;
            tempCoinThree = (change % Coin.COIN_FOUR.value) / Coin.COIN_THREE.value;
            tempCoinTwo = ((change % Coin.COIN_FOUR.value) % Coin.COIN_THREE.value) / Coin.COIN_TWO.value;
        } else if (coinFourSleeve.size() > 0 && coinThreeSleeve.size() > 0) {
            tempCoinFour = change / Coin.COIN_FOUR.value;
            tempCoinThree = (change % Coin.COIN_FOUR.value) / Coin.COIN_THREE.value;
        } else if (coinFourSleeve.size() > 0 && coinTwoSleeve.size() > 0) {
            tempCoinFour = change / Coin.COIN_FOUR.value;
            tempCoinTwo = (change % Coin.COIN_FOUR.value) / Coin.COIN_TWO.value;
        } else if (coinThreeSleeve.size() > 0 && coinTwoSleeve.size() > 0) {
            tempCoinThree = change / Coin.COIN_THREE.value;
            tempCoinTwo = (change % Coin.COIN_THREE.value) / Coin.COIN_TWO.value;
        } else {
            tempCoinTwo = change / Coin.COIN_TWO.value;
        }

        while (tempCoinFour > 0) {
            coinHold.push(Coin.COIN_FOUR);
            removeCoin(coinFourSleeve);
            tempCoinFour --;
        }

        while (tempCoinThree > 0) {
            coinHold.push(Coin.COIN_THREE);
            removeCoin(coinThreeSleeve);
            tempCoinThree --;
        }

        while (tempCoinTwo > 0) {
            coinHold.push(Coin.COIN_TWO);
            removeCoin(coinTwoSleeve);
            tempCoinTwo --;
        }
    }

    public Stack<Coin> getCoinReturn() {
        Stack<Coin> tempReturn = new Stack<>();

        for (Coin coin : coinHold) {
            tempReturn.push(coin);
        }

        this.coinHold.removeAllElements();
        return tempReturn;
    }

    public boolean canMakeChange() {

        if (stackTotal(coinFourSleeve) == 0) {
            if ((stackTotal(coinThreeSleeve) + stackTotal(coinTwoSleeve) < Coin.COIN_FOUR.value)) {
                return false;
            }
        } else if (stackTotal(coinThreeSleeve) < (Coin.COIN_THREE.value + Coin.COIN_THREE.value)) {
            if(stackTotal(coinTwoSleeve) < ((Coin.COIN_THREE.value) + (Coin.COIN_THREE.value))) {
                return false;
            }
        }

        return true;
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

            coinTwoSleeve.push(Coin.COIN_TWO);
            coinThreeSleeve.push(Coin.COIN_THREE);
            coinFourSleeve.push(Coin.COIN_FOUR);
        }
    }

    public void depositCoins(Stack<Coin> coinHold) {

        for (Coin coin : coinHold) {
            addCoin(coin);
        }
    }
}
