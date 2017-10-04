package io.krukm.model;

import org.junit.Test;

import java.util.Stack;

import static junit.framework.TestCase.assertEquals;

public class VendingMachineTest {

    private VendingMachine vendingMachine = new VendingMachine();

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
        Stack<Coin> coins = new Stack<>();
        coins.add(Coin.COIN_FOUR);
        coins.add(Coin.COIN_THREE);
        vendingMachine.insertCoin(Coin.COIN_FOUR);
        vendingMachine.insertCoin(Coin.COIN_THREE);
        assertEquals(coins, vendingMachine.coinReserve.coinHold);
    }

    @Test
    public void whenPurchaseIsAbortedReturnInsertedCoins() {

    }
}