package io.krukm.model;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CoinTest {
    @Test
    public void whenAPennyIsCalledReturnPennyWeight() {
        assertEquals(2.500, Coin.ONE.weight);
    }

    @Test
    public void whenANickelIsCalledReturnNickelWeight() {
        assertEquals(5.000, Coin.FIVE.weight);
    }

    @Test
    public void whenADimeIsCalledReturnDimeWeight() {
        assertEquals(2.268, Coin.TEN.weight);
    }

    @Test
    public void whenAQuarterIsCalledReturnQuarterWeight() {
        assertEquals(5.670, Coin.TWENTYFIVE.weight);
    }

    @Test
    public void whenAPennyIsCalledReturnPennyDiameter() {
        assertEquals(0.750, Coin.ONE.diameter);
    }

    @Test
    public void whenANickelIsCalledReturnNickelDiameter() {
        assertEquals(0.835, Coin.FIVE.diameter);
    }

    @Test
    public void whenADimeIsCalledReturnDimeDiameter() {
        assertEquals(0.705, Coin.TEN.diameter);
    }

    @Test
    public void whenAQuarterIsCalledReturnQuarterDiameter() {
        assertEquals(0.955, Coin.TWENTYFIVE.diameter);
    }

    @Test
    public void whenAPennyIsCalledReturnPennyValue() {
        assertEquals(1, Coin.ONE.value);
    }

    @Test
    public void whenANickelIsCalledReturnNickelValue() {
        assertEquals(5, Coin.FIVE.value);
    }

    @Test
    public void whenADimeIsCalledReturnDimeValue() {
        assertEquals(10, Coin.TEN.value);
    }

    @Test
    public void whenAQuarterIsCalledReturnQuarterValue() {
        assertEquals(25, Coin.TWENTYFIVE.value);
    }
}
