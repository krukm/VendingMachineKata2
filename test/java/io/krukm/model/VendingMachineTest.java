package io.krukm.model;

import org.junit.Test;

import java.util.Stack;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class VendingMachineTest {

    private VendingMachine vendingMachine = new VendingMachine();
    private Stack<Coin> coins = new Stack<>();

    @Test
    public void whenEncounteringIdleFullyStockedVendingMachineDisplayShouldGiveInstructionToInsertCoin() {
        vendingMachine.stockProducts();
        vendingMachine.stockCoins();
        assertEquals("INSERT COIN", vendingMachine.show());
    }

    @Test
    public void whenInsertingCoinsDisplayShouldShowTotalAmountInsertedSoFar() {
        vendingMachine.insertCoin(Coin.COIN_FOUR);
        vendingMachine.updateDisplay();
        assertEquals("0.25", vendingMachine.show());
    }

    @Test
    public void whenInsertedCoinsShouldBeAddedToTemporaryHoldUntilProductSelected() {
        coins.add(Coin.COIN_FOUR);
        coins.add(Coin.COIN_THREE);
        vendingMachine.insertCoin(Coin.COIN_FOUR);
        vendingMachine.insertCoin(Coin.COIN_THREE);
        assertEquals(coins, vendingMachine.getInsertedCoins());
    }

    @Test
    public void whenPurchaseIsAbortedReturnInsertedCoins() {
        coins.add(Coin.COIN_THREE);
        coins.add(Coin.COIN_TWO);
        vendingMachine.insertCoin(Coin.COIN_THREE);
        vendingMachine.insertCoin(Coin.COIN_TWO);
        assertEquals(coins, vendingMachine.activateCoinReturn());
    }

    @Test
    public void whenProductSelectedCheckIfEnoughCoinsInsertedToPurchase() {
        while (coins.size() < 5) {
            coins.add(Coin.COIN_FOUR);
        }
        assertTrue(vendingMachine.enoughCoinsEntered(Product.PRODUCT_THREE, coins));
    }

    @Test
    public void whenCheckingForEnoughCoinsUpdateDisplayIfNotEnoughCoinsEntered () {
        coins.add(Coin.COIN_FOUR);
        vendingMachine.enoughCoinsEntered(Product.PRODUCT_TWO, coins);
        assertEquals("PRICE 0.50", vendingMachine.show());
    }

    @Test
    public void whenEnoughCoinsAndProductSelectedDispenseProduct() {
        while (coins.size() < 5) {
            coins.add(Coin.COIN_FOUR);
        }
        vendingMachine.stockProducts();
        assertTrue(vendingMachine.makePurchase(Product.PRODUCT_ONE, coins));
    }

    @Test
    public void whenEnoughCoinsButSelectedProductIsOutOfStockDisplaySoldOut() {
        while (coins.size() < 5) {
            coins.add(Coin.COIN_FOUR);
        }
        vendingMachine.makePurchase(Product.PRODUCT_ONE, coins);
        assertEquals("SOLD OUT", vendingMachine.show());
    }

    @Test
    public void whenPurchaseCompletedButOverPaidRemoveChange() {
        while (coins.size() < 5) {
            coins.add(Coin.COIN_FOUR);
        }
        vendingMachine.makePurchase(Product.PRODUCT_ONE, coins);
        assertEquals(0, vendingMachine.insertedCoinTotal());
    }

    @Test
    public void whenNoCoinsInsertedAndCanNotMakeChangeDisplayExactChangeOnly() {
        vendingMachine.updateDisplay();
        assertEquals("EXACT CHANGE ONLY", vendingMachine.show());
    }

    @Test
    public void whenNoCoinsInsertedAndCanMakeChangeDisplayInsertCoin() {
        vendingMachine.stockCoins();
        vendingMachine.updateDisplay();
        assertEquals("INSERT COIN", vendingMachine.show());
    }

    @Test
    public void whenPurchaseCompleteDisplayReadsThankYou() {
        while (coins.size() < 5) {
            coins.add(Coin.COIN_FOUR);
        }
        vendingMachine.stockProducts();
        vendingMachine.makePurchase(Product.PRODUCT_ONE, coins);
        assertEquals("THANK YOU", vendingMachine.show());
    }

    @Test
    public void whenVendingMachineProductsAreStockedInventoryHasTenOfEachProduct() {
        vendingMachine.stockProducts();
        assertTrue(vendingMachine.checkProductStock(Product.PRODUCT_ONE) == 10 &&
                vendingMachine.checkProductStock(Product.PRODUCT_TWO) == 10 &&
                vendingMachine.checkProductStock(Product.PRODUCT_THREE) == 10);
    }

    @Test
    public void whenVendingMachineCoinsAreStockedCoinSleevesHaveTenOfEachCoin() {
        vendingMachine.stockCoins();
        assertTrue(vendingMachine.checkCoinStock(Coin.COIN_TWO) == 10 &&
                vendingMachine.checkCoinStock(Coin.COIN_THREE) == 10 &&
                vendingMachine.checkCoinStock(Coin.COIN_FOUR) == 10);
    }

    @Test
    public void whenCoinIsNotAcceptedAddItToTheCoinReturn() {
        coins.push(Coin.COIN_ONE);
        vendingMachine.insertCoin(Coin.COIN_ONE);
        assertEquals(coins, vendingMachine.getCoinReturn());
    }
}