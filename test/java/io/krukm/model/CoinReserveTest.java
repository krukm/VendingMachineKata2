package io.krukm.model;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class CoinReserveTest {
    private CoinReserve coinReserve = new CoinReserve();

    @Test
    public void rejectPennyWhenAdded() {
        assertFalse(coinReserve.coinAccepted(Coin.PENNY));
    }

    @Test
    public void acceptNickelWhenAdded() {
        assertTrue(coinReserve.coinAccepted(Coin.NICKEL));
    }

    @Test
    public void acceptDimeWhenAdded() {
        assertTrue(coinReserve.coinAccepted(Coin.DIME));
    }

    @Test
    public void acceptQuarterWhenAdded() {
        assertTrue(coinReserve.coinAccepted(Coin.QUARTER));
    }

    @Test
    public void addNickelToNickelStackWhenAccepted() {
        coinReserve.coinAccepted(Coin.NICKEL);
        assertFalse(coinReserve.nickelStack.empty());
    }

    @Test
    public void addDimeToDimeStackWhenAccepted() {
        coinReserve.coinAccepted(Coin.DIME);
        assertFalse(coinReserve.dimeStack.empty());
    }

    @Test
    public void addQuarterToQuarterStackWhenAccepted() {
        coinReserve.coinAccepted(Coin.QUARTER);
        assertFalse(coinReserve.quarterStack.empty());
    }

    @Test
    public void addTenNickelsWhenReserveIsStocked() {
        coinReserve.stockReserve();
        assertEquals(10, coinReserve.nickelStack.size());
    }

    @Test
    public void addTenDimesWhenReserveIsStocked() {
        coinReserve.stockReserve();
        assertEquals(10, coinReserve.dimeStack.size());
    }

    @Test
    public void addTenQuartersWhenReserveIsStocked() {
        coinReserve.stockReserve();
        assertEquals(10, coinReserve.quarterStack.size());
    }
}
