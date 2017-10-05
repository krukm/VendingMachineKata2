package io.krukm.model;

import java.util.ArrayList;
import java.util.Stack;

class CoinReserve {

    Stack<Coin> coinTwoSleeve = new Stack<>();
    Stack<Coin> coinThreeSleeve = new Stack<>();
    Stack<Coin> coinFourSleeve = new Stack<>();
    Stack<Coin> coinHold = new Stack<>();
    Stack<Coin> coinReturn = new Stack<>();

    boolean coinAccepted(Coin coin) {

        switch(coin) {
            case COIN_ONE:
                return false;
            case COIN_TWO:
                return true;
            case COIN_THREE:
                return true;
            case COIN_FOUR:
                return true;
            default:
                return false;
        }
    }

    ArrayList<Coin> reserveTotal() {

        ArrayList<Coin> total = new ArrayList<>();
        Stack<Coin> coinTwoSleeve = this.coinTwoSleeve;
        Stack<Coin> coinThreeSleeve = this.coinThreeSleeve;
        Stack<Coin> coinFourSleeve = this.coinFourSleeve;

        total.addAll(coinTwoSleeve);
        total.addAll(coinThreeSleeve);
        total.addAll(coinFourSleeve);

        return total;

    }

    void addCoin(Coin coin) {

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

    void removeCoin(Stack<Coin> coinStack) {

        if(!coinStack.empty()) {
            coinStack.pop();
        }
    }

    void makeChange(int productPrice, int coinsInserted) {

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

    void rejectCoin(Coin coin) {
        coinReturn.push(coin);
    }

    void refundCoins() {

        for (Coin coin : coinHold) {
            coinReturn.push(coin);
        }
        this.coinHold.clear();
    }

    boolean canMakeChange() {

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

    int stackTotal(Stack<Coin> coinStack) {

        int total = 0;

        for (Coin coin : coinStack) {
            total = total + coin.value;
        }
        return total;
    }


    void stockReserve() {

        coinTwoSleeve.clear();
        coinThreeSleeve.clear();
        coinFourSleeve.clear();

        for(int i = 0; i < 10; i++) {
            coinTwoSleeve.push(Coin.COIN_TWO);
            coinThreeSleeve.push(Coin.COIN_THREE);
            coinFourSleeve.push(Coin.COIN_FOUR);
        }
    }

    void depositCoins(Stack<Coin> coinHold) {

        for (Coin coin : coinHold) {
            if(coinAccepted(coin)) {
                addCoin(coin);
            }
        }
    }
}
