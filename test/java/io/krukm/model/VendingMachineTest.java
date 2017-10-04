package io.krukm.model;

import org.junit.Test;

import java.util.Stack;

import static junit.framework.TestCase.assertEquals;

public class VendingMachineTest {

    private VendingMachine vendingMachine = new VendingMachine();
    private Stack<Coin> coins = new Stack<>();

    @Test
    public void whenEncounteringIdleVendingMachineDisplayShouldGiveInstructionToInsertCoin() {
        assertEquals("INSERT COIN", vendingMachine.display.getMessage());
    }

    @Test
    public void whenInsertingCoinsDisplayShouldShowTotalAmountInsertedSoFar() {
        vendingMachine.insertCoin(Coin.COIN_FOUR);
        assertEquals("0.25", vendingMachine.display.getMessage());
    }

    @Test
    public void whenInsertedCoinsShouldBeAddedToTemporaryHoldUntilProductSelected() {
        coins.add(Coin.COIN_FOUR);
        coins.add(Coin.COIN_THREE);
        vendingMachine.insertCoin(Coin.COIN_FOUR);
        vendingMachine.insertCoin(Coin.COIN_THREE);
        assertEquals(coins, vendingMachine.coinReserve.coinHold);
    }

    @Test
    public void whenPurchaseIsAbortedReturnInsertedCoins() {
        coins.add(Coin.COIN_THREE);
        coins.add(Coin.COIN_TWO);
        vendingMachine.insertCoin(Coin.COIN_THREE);
        vendingMachine.insertCoin(Coin.COIN_TWO);
        assertEquals(coins, vendingMachine.activateCoinReturn());
    }
}