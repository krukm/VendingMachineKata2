package io.krukm.model;

public enum Coin {

    ONE(2.500, 0.750, 1),
    FIVE(5.000, 0.835, 5),
    TEN(2.268, 0.705, 10),
    TWENTYFIVE(5.670, 0.955, 25);

    public double weight, diameter;
    public int value;

    Coin(double weight, double diameter, int value) {
        this.weight = weight;
        this.diameter = diameter;
        this.value = value;
    }
}
