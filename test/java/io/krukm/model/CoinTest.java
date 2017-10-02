package io.krukm.model;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CoinTest {
    @Test
    public void whenAPennyIsCalledReturnPennyWeight() {
        assertEquals(2.500, Coin.PENNY.weight);
    }

    @Test
    public void whenANickelIsCalledReturnNickelWeight() {
        assertEquals(5.000, Coin.NICKEL.weight);
    }

    @Test
    public void whenADimeIsCalledReturnDimeWeight() {
        assertEquals(2.268, Coin.DIME.weight);
    }

    @Test
    public void whenAQuarterIsCalledReturnQuarterWeight() {
        assertEquals(5.670, Coin.QUARTER.weight);
    }

    @Test
    public void whenAPennyIsCalledReturnPennyDiameter() {
        assertEquals(0.750, Coin.PENNY.diameter);
    }

    @Test
    public void whenANickelIsCalledReturnNickelDiameter() {
        assertEquals(0.835, Coin.NICKEL.diameter);
    }

    @Test
    public void whenADimeIsCalledReturnDimeDiameter() {
        assertEquals(0.705, Coin.DIME.diameter);
    }

    @Test
    public void whenAQuarterIsCalledReturnQuarterDiameter() {
        assertEquals(0.955, Coin.QUARTER.diameter);
    }

    @Test
    public void whenAPennyIsCalledReturnPennyValue() {
        assertEquals(0.01, Coin.PENNY.value);
    }

    @Test
    public void whenANickelIsCalledReturnNickelValue() {
        assertEquals(0.05, Coin.NICKEL.value);
    }

    @Test
    public void whenADimeIsCalledReturnDimeValue() {
        assertEquals(0.10, Coin.DIME.value);
    }

    @Test
    public void whenAQuarterIsCalledReturnQuarterValue() {
        assertEquals(0.25, Coin.QUARTER.value);
    }
}
