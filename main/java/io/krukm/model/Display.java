package io.krukm.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Display {

    private ArrayList<String> displayMessage = new ArrayList<>(Arrays.asList("INSERT COIN", "THANK YOU", "PRICE ", "SOLD OUT", "EXACT CHANGE ONLY"));
    private DecimalFormat decimalFormat = new DecimalFormat("0.00");


    public String message;

    public void setMessage(int code, int price) {

        this.message = message;

        switch (code) {
            case 1:
                message = displayMessage.get(1);
                break;
            case 2:
                message = displayMessage.get(2) + String.valueOf(decimalFormat.format((double)price/ 100));
                break;
            case 3:
                message = displayMessage.get(3);
                break;
            case 4:
                message = displayMessage.get(4);
                break;
            case 5:
                message = String.valueOf(decimalFormat.format((double)price / 100));
                break;
            default:
                message = displayMessage.get(0);
                break;
        }
    }

    public String getMessage() {
        return message;
    }
}
