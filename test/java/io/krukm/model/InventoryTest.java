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
}
