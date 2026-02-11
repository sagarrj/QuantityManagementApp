package com.bridgeLabz.QuantityManagementApp;

public enum LengthUnit {
    //Base Unit
    INCH(1.0),

    FEET(12.0),
    YARD(36),
    CENTIMETER(0.393701);

    private final double toInch;

    LengthUnit(double toInch){
    this.toInch =toInch;
    }

    public double getToInch() {
        return toInch;
    }

    public double convertToInch(double value){
        return value * this.getToInch();

    }
    public double convertFromInch(double value){
        return value / this.getToInch();
    }
}
