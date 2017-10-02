package io.krukm.model;

public enum Coin {

    PENNY(2.500, 0.750, 0.01),
    NICKEL(5.000, 0.835, 0.05),
    DIME(2.268, 0.705, 0.10),
    QUARTER(5.670, 0.955, 0.25);

    public double weight, diameter, value;

    Coin(double weight, double diameter, double value) {
        this.weight = weight;
        this.diameter = diameter;
        this.value = value;
    }
}
