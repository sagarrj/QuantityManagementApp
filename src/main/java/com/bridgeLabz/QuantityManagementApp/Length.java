package com.bridgeLabz.QuantityManagementApp;

public class Length
{
    private final double EPSILON = 0.0001;

    private double value;
    private LengthUnit unit;

    public Length(double value, LengthUnit lengthUnit) {
        if(!Double.isFinite(value)){
            throw new NumberFormatException("Number Out of Range");
        }
        this.value = value;
        this.unit = lengthUnit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }


    public Length convertTo(LengthUnit targetUnit){
        double sourceInInch = this.unit.convertToInch(this.value);
        double targetValue = targetUnit.convertFromInch(sourceInInch);
        return new Length(targetValue,targetUnit);
    }

    public Length add(Length q2){
        Length totalLength = addInInch(q2);
        return totalLength.convertTo(this.getUnit());
    }

    public Length add(Length q2, LengthUnit targetUnit){
        Length totalLength = addInInch(q2);
        return totalLength.convertTo(targetUnit);
    }

    private Length addInInch(Length q2) {
        Length lengthToAdd_InInch = q2.convertTo(LengthUnit.INCH);
        Length sourceLength_InInch = this.convertTo(LengthUnit.INCH);
        double sum = Math.round(sourceLength_InInch.getValue() + lengthToAdd_InInch.getValue());
        Length totalLength = new Length(sum, LengthUnit.INCH);
        return totalLength;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Length that = (Length) obj;
        if(that.unit == this.unit)
            return Double.compare(that.value, value) == 0;
        else{
            Length thisInInch = this.convertTo(LengthUnit.INCH);
            Length thatInInch = that.convertTo(LengthUnit.INCH);
            return Double.compare(Math.round(thisInInch.getValue()), Math.round(thatInInch.getValue())) <= EPSILON;
        }
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }
}
