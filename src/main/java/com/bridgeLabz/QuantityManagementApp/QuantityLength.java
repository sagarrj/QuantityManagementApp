package com.bridgeLabz.QuantityManagementApp;

public class QuantityLength
{
    private double value;
    private LengthUnit lengthUnit;

    public QuantityLength(double value, LengthUnit lengthUnit) {
        if(!Double.isFinite(value)){
            throw new NumberFormatException("Number Out of Range");
        }
        this.value = value;
        this.lengthUnit = lengthUnit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getLengthUnit() {
        return lengthUnit;
    }

    public static QuantityLength convert(double value, LengthUnit sourceUnit, LengthUnit targetUnit){
        double sourceInInch = value * sourceUnit.getToInch();
        double targetValue = sourceInInch / targetUnit.getToInch();
        return new QuantityLength( targetValue, targetUnit);
    }

    public static QuantityLength convert(QuantityLength length,LengthUnit targetUnit){
        double sourceInInch = length.value * length.lengthUnit.getToInch();
        return new QuantityLength( sourceInInch/ targetUnit.getToInch(), targetUnit);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        QuantityLength that = (QuantityLength) obj;
        if(that.lengthUnit == this.lengthUnit)
            return Double.compare(that.value, value) == 0;
        else{
            QuantityLength thisInInch = convert(this.value, this.lengthUnit, LengthUnit.INCH);
            QuantityLength thatInInch = convert(that.value, that.lengthUnit, LengthUnit.INCH);
            return Double.compare(Math.round(thisInInch.getValue()), Math.round(thatInInch.getValue())) == 0;
        }
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }
}
