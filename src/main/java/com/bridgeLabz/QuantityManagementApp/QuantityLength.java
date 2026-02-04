package com.bridgeLabz.QuantityManagementApp;

public class QuantityLength
{
    private double value;
    private LengthUnit lengthUnit;

    public QuantityLength(double value, LengthUnit lengthUnit) {
        this.value = value;
        this.lengthUnit = lengthUnit;
    }





    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        QuantityLength that = (QuantityLength) obj;
        if(that.lengthUnit == this.lengthUnit)
            return Double.compare(that.value, value) == 0;
        else{
            double thisInInches = this.value * this.lengthUnit.getToInch();
            double thatInInches = that.value * that.lengthUnit.getToInch();
            return Double.compare(Math.round(thisInInches), Math.round(thatInInches)) == 0;
        }
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }
}
