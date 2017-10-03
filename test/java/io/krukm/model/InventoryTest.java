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
}
