package io.krukm.model;

import org.junit.Test;

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
}