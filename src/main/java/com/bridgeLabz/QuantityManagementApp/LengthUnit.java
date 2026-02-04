package com.bridgeLabz.QuantityManagementApp;

public enum LengthUnit {
    FEET(12.0),
    INCH(1.0),
    YARD(36),
    CENTIMETER(0.393701);

    private final double toInch;

    LengthUnit(double toInch){
    this.toInch =toInch;
    }

    public double getToInch() {
        return toInch;
    }
}
