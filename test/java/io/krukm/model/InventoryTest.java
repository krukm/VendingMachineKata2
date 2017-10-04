package io.krukm.model;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class InventoryTest {

    private Inventory inventory = new Inventory();

    @Test
    public void whenInventoryIsStockedTenProductOneAreAdded() {
        inventory.stockInventory();
        assertEquals(10, inventory.productOneRow.size());
    }

    @Test
    public void whenInventoryIsStockedTenProductTwoAreAdded() {
        inventory.stockInventory();
        assertEquals(10, inventory.productTwoRow.size());
    }

    @Test
    public void whenInventoryIsStockedTenProductThreeAreAdded() {
        inventory.stockInventory();
        assertEquals(10, inventory.productThreeRow.size());
    }

    @Test
    public void whenProductOneIsCalledPullProductOneFromProductOneStack() {
        inventory.stockInventory();
        inventory.dispenseProduct(Product.PRODUCT_ONE);
        assertEquals(9, inventory.productOneRow.size());
    }

    @Test
    public void whenProductTwoIsCalledPullProductTwoFromProductStack() {
        inventory.stockInventory();
        inventory.dispenseProduct(Product.PRODUCT_TWO);
        assertEquals(9, inventory.productTwoRow.size());
    }

    @Test
    public void whenProductThreeIsCalledPullProductThreeFromProductThreeStack() {
        inventory.stockInventory();
        inventory.dispenseProduct(Product.PRODUCT_THREE);
        assertEquals(9, inventory.productThreeRow.size());
    }

    @Test
    public void getCurrentProductOneStockWithGetProductStock() {
        for (int i = 0; i < 5; i++) {
            inventory.productOneRow.add(Product.PRODUCT_ONE);
        }
        assertEquals(5, inventory.getProductStock(Product.PRODUCT_ONE));
    }

    @Test
    public void getCurrentProductTwoStockWithGetProductStock() {
        for (int i = 0; i < 7; i++) {
            inventory.productTwoRow.add(Product.PRODUCT_TWO);
        }
        assertEquals(7, inventory.getProductStock(Product.PRODUCT_TWO));
    }

    @Test
    public void getCurrentProductThreeStockWithGetProductStock() {
        for (int i = 0; i < 5; i++) {
            inventory.productThreeRow.add(Product.PRODUCT_THREE);
        }
        assertEquals(5, inventory.getProductStock(Product.PRODUCT_THREE));
    }

    @Test
    public void whenProductIsInStockReturnTrue() {
        inventory.productThreeRow.add(Product.PRODUCT_THREE);
        assertTrue(inventory.productInStock(Product.PRODUCT_THREE));
    }

    @Test
    public void whenProductIsNotInStockReturnFalse() {
        assertFalse(inventory.productInStock(Product.PRODUCT_ONE));
    }
}
