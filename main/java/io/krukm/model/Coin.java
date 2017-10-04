package io.krukm.model;


public enum Coin {

    COIN_ONE(2.500, 0.750, 1),
    COIN_TWO(5.000, 0.835, 5),
    COIN_THREE(2.268, 0.705, 10),
    COIN_FOUR(5.670, 0.955, 25);

    public double weight;
    public double diameter;
    public int value;


    Coin(double weight, double diameter, int value) {
        this.weight = weight;
        this.diameter = diameter;
        this.value = value;
    }
}
