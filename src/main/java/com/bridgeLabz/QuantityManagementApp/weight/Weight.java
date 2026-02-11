package com.bridgeLabz.QuantityManagementApp.weight;

import java.util.Objects;

public class Weight {
    private static final double EPSILON = 0.0001;

    private final double value;
    private final WeightUnit unit;


    public Weight(double value, WeightUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    public Weight convertTo(WeightUnit targetUnit){
        double valueInKg = this.unit.convertToKg(this.value);
        double valueInTargetUnit = targetUnit.convertFromKg(valueInKg);
        return new Weight(valueInTargetUnit, targetUnit);
    }

    public Weight add(Weight w){
        Weight weightInKg = addInKg(w);
        return weightInKg.convertTo(this.getUnit());
    }

    public Weight add(Weight w, WeightUnit targetUnit){
        Weight weightInKg = addInKg(w);
        return weightInKg.convertTo(targetUnit);
    }

    private Weight addInKg(Weight w) {
        Weight thisInKg = this.convertTo(WeightUnit.KILOGRAM);
        Weight toAddInKg = w.convertTo(WeightUnit.KILOGRAM);
        double sumInKg = Double.sum(thisInKg.getValue(), toAddInKg.getValue());
        Weight weightInKg = new Weight(sumInKg, WeightUnit.KILOGRAM);
        return weightInKg;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Weight that = (Weight) o;
        if(unit == that.unit){
            return Double.compare(value, that.value) == 0 ;
        }else{
            Weight thisInKg = this.convertTo(WeightUnit.KILOGRAM);
            Weight thatInKg = that.convertTo(WeightUnit.KILOGRAM);
            return Double.compare(thisInKg.value, thatInKg.getValue()) <= EPSILON;
        }
    }

    @Override
    public int hashCode() {
        int result = Double.hashCode(value);
        result = 31 * result + Objects.hashCode(unit);
        return result;
    }
}
