package com.bridgeLabz.QuantityManagementApp;

public class Measurement
{
    private double value;
    private Unit unit;

    public Measurement(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Measurement that = (Measurement) obj;
        return Double.compare(that.value, value) == 0 && unit == that.unit;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }
}
