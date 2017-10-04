package io.krukm.model;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DisplayTest {

    private Display display = new Display();

    @Test
    public void displayInsertCoinWhenNoCodeSent() {
        assertEquals("INSERT COIN", display.getMessage(9, 0));
    }

    @Test
    public void displayTotalChangeEnteredWhenCodeFiveSent() {
        assertEquals("0.35", display.getMessage(5, 35));
    }

    @Test
    public void displayThankYouWhenCodeOneSent() {
        assertEquals("THANK YOU", display.getMessage(1, 0));
    }

    @Test
    public void displayPricePlusCurrentPriceWhenCodeTwoSent() {
        assertEquals("PRICE 1.00", display.getMessage(2, 100));
    }

    @Test
    public void displaySoldOutWhenCodeThreeSent() {
        assertEquals("SOLD OUT", display.getMessage(3, 65));
    }

    @Test
    public void displayExactChangeOnlyWhenCodeFourSent() {
        assertEquals("EXACT CHANGE ONLY", display.getMessage(4, 0));
    }
}
