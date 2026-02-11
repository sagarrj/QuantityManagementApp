package com.bridgeLabz.QuantityManagementApp.weight;

public enum WeightUnit {
    KILOGRAM(1.0),
    GRAM(1000.0),
    POUND(0.453592);

    private final double toKg;

    WeightUnit(double toKg) {
        this.toKg = toKg;
    }

    public double getToKg() {
        return toKg;
    }

    public double convertToKg(double value){
        return value * this.toKg;
    }

    public double convertFromKg(double value){
        return value /  this.toKg;
    }
}
