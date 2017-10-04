package io.krukm.model;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ProductTest {
    @Test
    public void whenColaIsCalledReturnColaPrice() {
        assertEquals(1.00, Product.PRODUCT_ONE.price);
    }

    @Test
    public void whenChipsIsCalledReturnChipsPrice() {
        assertEquals(0.50, Product.PRODUCT_TWO.price);
    }

    @Test
    public void whenCandyIsCalledReturnCandyPrice() {
        assertEquals(0.65, Product.PRODUCT_THREE.price);
    }
}
