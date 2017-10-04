package io.krukm.model;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CoinTest {
    @Test
    public void whenAPennyIsCalledReturnPennyWeight() {
        assertEquals(2.500, Coin.COIN_ONE.weight);
    }

    @Test
    public void whenANickelIsCalledReturnNickelWeight() {
        assertEquals(5.000, Coin.COIN_TWO.weight);
    }

    @Test
    public void whenADimeIsCalledReturnDimeWeight() {
        assertEquals(2.268, Coin.COIN_THREE.weight);
    }

    @Test
    public void whenAQuarterIsCalledReturnQuarterWeight() {
        assertEquals(5.670, Coin.COIN_FOUR.weight);
    }

    @Test
    public void whenAPennyIsCalledReturnPennyDiameter() {
        assertEquals(0.750, Coin.COIN_ONE.diameter);
    }

    @Test
    public void whenANickelIsCalledReturnNickelDiameter() {
        assertEquals(0.835, Coin.COIN_TWO.diameter);
    }

    @Test
    public void whenADimeIsCalledReturnDimeDiameter() {
        assertEquals(0.705, Coin.COIN_THREE.diameter);
    }

    @Test
    public void whenAQuarterIsCalledReturnQuarterDiameter() {
        assertEquals(0.955, Coin.COIN_FOUR.diameter);
    }

    @Test
    public void whenAPennyIsCalledReturnPennyValue() {
        assertEquals(1, Coin.COIN_ONE.value);
    }

    @Test
    public void whenANickelIsCalledReturnNickelValue() {
        assertEquals(5, Coin.COIN_TWO.value);
    }

    @Test
    public void whenADimeIsCalledReturnDimeValue() {
        assertEquals(10, Coin.COIN_THREE.value);
    }

    @Test
    public void whenAQuarterIsCalledReturnQuarterValue() {
        assertEquals(25, Coin.COIN_FOUR.value);
    }
}
