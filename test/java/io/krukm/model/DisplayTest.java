package io.krukm.model;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DisplayTest {

    private Display display = new Display();

    @Test
    public void displayInsertCoinWhenNoCodeSent() {
        display.setMessage(9, 0);
        assertEquals("INSERT COIN", display.getMessage());
    }

    @Test
    public void displayTotalChangeEnteredWhenCodeFiveSent() {
        display.setMessage(5, 35);
        assertEquals("0.35", display.getMessage());
    }

    @Test
    public void displayThankYouWhenCodeOneSent() {
        display.setMessage(1, 0);
        assertEquals("THANK YOU", display.getMessage());
    }

    @Test
    public void displayPricePlusCurrentPriceWhenCodeTwoSent() {
        display.setMessage(2, 100);
        assertEquals("PRICE 1.00", display.getMessage());
    }

    @Test
    public void displaySoldOutWhenCodeThreeSent() {
        display.setMessage(3, 65);
        assertEquals("SOLD OUT", display.getMessage());
    }

    @Test
    public void displayExactChangeOnlyWhenCodeFourSent() {
        display.setMessage(4, 0);
        assertEquals("EXACT CHANGE ONLY", display.getMessage());
    }
}
