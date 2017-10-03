package io.krukm.model;

import org.junit.Test;

import java.util.Stack;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class CoinReserveTest {

    private CoinReserve coinReserve = new CoinReserve();
    private Stack<Coin> change = new Stack<>();

    @Test
    public void rejectOneWhenAdded() {
        assertFalse(coinReserve.coinAccepted(Coin.ONE));
    }

    @Test
    public void acceptFiveWhenAdded() {
        assertTrue(coinReserve.coinAccepted(Coin.FIVE));
    }

    @Test
    public void acceptTenWhenAdded() {
        assertTrue(coinReserve.coinAccepted(Coin.TEN));
    }

    @Test
    public void acceptTwentyFiveWhenAdded() {
        assertTrue(coinReserve.coinAccepted(Coin.TWENTYFIVE));
    }

    @Test
    public void addFiveToFiveStackWhenAccepted() {
        coinReserve.addCoin(Coin.FIVE);
        assertFalse(coinReserve.fiveStack.empty());
    }

    @Test
    public void addTenToTenStackWhenAccepted() {
        coinReserve.addCoin(Coin.TEN);
        assertFalse(coinReserve.tenStack.empty());
    }

    @Test
    public void addTwentyFiveToTwentyFiveStackWhenAccepted() {
        coinReserve.addCoin(Coin.TWENTYFIVE);
        assertFalse(coinReserve.twentyFiveStack.empty());
    }

    @Test
    public void addTenFivesWhenReserveIsStocked() {
        coinReserve.stockReserve();
        assertEquals(10, coinReserve.fiveStack.size());
    }

    @Test
    public void addTenTensWhenReserveIsStocked() {
        coinReserve.stockReserve();
        assertEquals(10, coinReserve.tenStack.size());
    }

    @Test
    public void addTenTwentyFivesWhenReserveIsStocked() {
        coinReserve.stockReserve();
        assertEquals(10, coinReserve.twentyFiveStack.size());
    }

    @Test
    public void getTheTotalOfCoinReserveWhenCalled() {
        coinReserve.stockReserve();
        assertEquals((Coin.FIVE.value * 10) + (Coin.TEN.value * 10) + (Coin.TWENTYFIVE.value * 10), coinReserve.reserveTotal());
    }

    @Test
    public void removeFiveWithRemoveCoin() {
        coinReserve.stockReserve();
        coinReserve.removeCoin(coinReserve.fiveStack);
        assertEquals(9, coinReserve.fiveStack.size());
    }

    @Test
    public void removeTenWithRemoveCoin() {
        coinReserve.stockReserve();
        coinReserve.removeCoin(coinReserve.tenStack);
        assertEquals(9, coinReserve.tenStack.size());
    }

    @Test
    public void removeTwentyFiveWithRemoveCoin() {
        coinReserve.stockReserve();
        coinReserve.removeCoin(coinReserve.twentyFiveStack);
        assertEquals(9, coinReserve.twentyFiveStack.size());
    }

    @Test
    public void getCoinTotalWhenUsingStackTotalMethod() {
        change.push(Coin.FIVE);
        change.push(Coin.TEN);
        change.push(Coin.TWENTYFIVE);
        assertEquals(40, coinReserve.stackTotal(change));
    }

    @Test
    public void whenOverpaidForProductAddChangeToCoinReturn() {
        coinReserve.stockReserve();
        assertEquals(25, coinReserve.makeChange(100, 125));
    }

    @Test
    public void whenOverPaidAndReserveIsOutOfTwentyFivesMakeChangeWithTensAndFives() {
        change.push(Coin.TEN);
        change.push(Coin.TEN);
        change.push(Coin.FIVE);
        coinReserve.stockReserve();
        coinReserve.twentyFiveStack.removeAllElements();
        coinReserve.makeChange(100, 125);
        assertEquals(change, coinReserve.coinReturn);
    }

    @Test
    public void whenOverPaidAndReserveIsOutOfTwentyFivesAndTensMakeChangeWithFives() {
        for (int i = 0; i < 5; i++) {
            change.push(Coin.FIVE);
        }
        coinReserve.stockReserve();
        coinReserve.twentyFiveStack.removeAllElements();
        coinReserve.tenStack.removeAllElements();
        coinReserve.makeChange(100, 125);
        assertEquals(change, coinReserve.coinReturn);
    }

    @Test
    public void whenOverPaidAndReserveIsOutOfTensMakeChangeWithTwentyFivesAndFives() {
        change.push(Coin.TWENTYFIVE);
        for (int i = 0; i < 3; i++) {
            change.push(Coin.FIVE);
        }
        coinReserve.stockReserve();
        coinReserve.tenStack.removeAllElements();
        coinReserve.makeChange(100, 140);
        assertEquals(change, coinReserve.coinReturn);
    }

    @Test
    public void whenCoinReturnRequestedReturnCoins() {
        change.push(Coin.TWENTYFIVE);
        change.push(Coin.TWENTYFIVE);
        change.push(Coin.TWENTYFIVE);
        change.push(Coin.TEN);
        change.push(Coin.FIVE);
        coinReserve.coinReturn.push(Coin.TWENTYFIVE);
        coinReserve.coinReturn.push(Coin.TWENTYFIVE);
        coinReserve.coinReturn.push(Coin.TWENTYFIVE);
        coinReserve.coinReturn.push(Coin.TEN);
        coinReserve.coinReturn.push(Coin.FIVE);
        assertEquals(change, coinReserve.getCoinReturn());
    }

    @Test
    public void whenCoinReturnRequestedClearCoinReturn() {
        coinReserve.coinReturn.push(Coin.TWENTYFIVE);
        coinReserve.coinReturn.push(Coin.TWENTYFIVE);
        coinReserve.coinReturn.push(Coin.TWENTYFIVE);
        coinReserve.coinReturn.push(Coin.TEN);
        coinReserve.coinReturn.push(Coin.FIVE);
        coinReserve.getCoinReturn();
        assertTrue(coinReserve.coinReturn.empty());
    }
}
