package io.krukm.model;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ProductTest {
    @Test
    public void whenColaIsCalledReturnColaPrice() {
        assertEquals(1.00, Product.COLA.price);
    }

    @Test
    public void whenChipsIsCalledReturnChipsPrice() {
        assertEquals(0.50, Product.CHIPS.price);
    }

    @Test
    public void whenCandyIsCalledReturnCandyPrice() {
        assertEquals(0.65, Product.CANDY.price);
    }
}
