package io.krukm.model;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class CoinReserveTest {
    private CoinReserve coinReserve = new CoinReserve();

    @Test
    public void rejectPennyWhenAdded() {
        assertFalse(coinReserve.coinAccepted(Coin.ONE));
    }

    @Test
    public void acceptNickelWhenAdded() {
        assertTrue(coinReserve.coinAccepted(Coin.FIVE));
    }

    @Test
    public void acceptDimeWhenAdded() {
        assertTrue(coinReserve.coinAccepted(Coin.TEN));
    }

    @Test
    public void acceptQuarterWhenAdded() {
        assertTrue(coinReserve.coinAccepted(Coin.TWENTYFIVE));
    }

    @Test
    public void addNickelToNickelStackWhenAccepted() {
        coinReserve.addCoin(Coin.FIVE);
        assertFalse(coinReserve.fiveStack.empty());
    }

    @Test
    public void addDimeToDimeStackWhenAccepted() {
        coinReserve.addCoin(Coin.TEN);
        assertFalse(coinReserve.tenStack.empty());
    }

    @Test
    public void addQuarterToQuarterStackWhenAccepted() {
        coinReserve.addCoin(Coin.TWENTYFIVE);
        assertFalse(coinReserve.twentyFiveStack.empty());
    }

    @Test
    public void addTenNickelsWhenReserveIsStocked() {
        coinReserve.stockReserve();
        assertEquals(10, coinReserve.fiveStack.size());
    }

    @Test
    public void addTenDimesWhenReserveIsStocked() {
        coinReserve.stockReserve();
        assertEquals(10, coinReserve.tenStack.size());
    }

    @Test
    public void addTenQuartersWhenReserveIsStocked() {
        coinReserve.stockReserve();
        assertEquals(10, coinReserve.twentyFiveStack.size());
    }

    @Test
    public void getTheTotalOfCoinReserveWhenCalled() {
        coinReserve.stockReserve();
        assertEquals((Coin.FIVE.value * 10) + (Coin.TEN.value * 10) + (Coin.TWENTYFIVE.value * 10), coinReserve.reserveTotal(coinReserve.fiveStack, coinReserve.tenStack, coinReserve.twentyFiveStack));
    }

    @Test
    public void removeNickelWithRemoveCoin() {
        coinReserve.stockReserve();
        coinReserve.removeCoin(coinReserve.fiveStack);
        assertEquals(9, coinReserve.fiveStack.size());
    }

    @Test
    public void removeDimeWithRemoveCoin() {
        coinReserve.stockReserve();
        coinReserve.removeCoin(coinReserve.tenStack);
        assertEquals(9, coinReserve.tenStack.size());
    }

    @Test
    public void removeQuarterWithRemoveCoin() {
        coinReserve.stockReserve();
        coinReserve.removeCoin(coinReserve.twentyFiveStack);
        assertEquals(9, coinReserve.twentyFiveStack.size());
    }
}
