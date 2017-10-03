package io.krukm.model;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class InventoryTest {

    private Inventory inventory = new Inventory();

    @Test
    public void whenInventoryIsStockedTenColasAreAdded() {
        inventory.stockInventory();
        assertEquals(10, inventory.colaStack.size());
    }

    @Test
    public void whenInventoryIsStockedTenChipsAreAdded() {
        inventory.stockInventory();
        assertEquals(10, inventory.chipsStack.size());
    }

    @Test
    public void whenInventoryIsStockedTenCandiesAreAdded() {
        inventory.stockInventory();
        assertEquals(10, inventory.candyStack.size());
    }

    @Test
    public void whenColaIsCalledPullColaFromColaStack() {
        inventory.stockInventory();
        inventory.removeProduct(Product.COLA);
        assertEquals(9, inventory.colaStack.size());
    }

    @Test
    public void whenChipsIsCalledPullChipsFromChipStack() {
        inventory.stockInventory();
        inventory.removeProduct(Product.CHIPS);
        assertEquals(9, inventory.chipsStack.size());
    }

    @Test
    public void whenCandyIsCalledPullCandyFromCandyStack() {
        inventory.stockInventory();
        inventory.removeProduct(Product.CANDY);
        assertEquals(9, inventory.candyStack.size());
    }

    @Test
    public void getCurrentColaStockWithGetProductStock() {
        for (int i = 0; i < 5; i++) {
            inventory.colaStack.push(Product.COLA);
        }
        assertEquals(5, inventory.getProductStock(Product.COLA));
    }

    @Test
    public void getCurrentChipStockWithGetProductStock() {
        for (int i = 0; i < 7; i++) {
            inventory.chipsStack.push(Product.CHIPS);
        }
        assertEquals(7, inventory.getProductStock(Product.CHIPS));
    }

    @Test
    public void getCurrentCandyStockWithGetProductStock() {
        for (int i = 0; i < 5; i++) {
            inventory.candyStack.push(Product.CANDY);
        }
        assertEquals(5, inventory.getProductStock(Product.CANDY));
    }
}
