package com.bridgeLabz.QuantityManagementApp.weight;

import com.bridgeLabz.QuantityManagementApp.length.Length;
import com.bridgeLabz.QuantityManagementApp.length.LengthUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeightTest {

    private static final double EPSILON = 0.0001;
    @Test
    void convertTo_sameUnit_ShouldReturnSameResult() {
        Weight weight = new Weight(1, WeightUnit.KILOGRAM);
        Weight converted = weight.convertTo(WeightUnit.KILOGRAM);
        assertEquals(WeightUnit.KILOGRAM,converted.getUnit());
        assertEquals(1,converted.getValue());
    }

    @Test
    void convertTo_1000gramToKg_ShouldReturn1Kg() {
        Weight weight = new Weight(1000, WeightUnit.GRAM);
        Weight converted = weight.convertTo(WeightUnit.KILOGRAM);
        assertEquals(WeightUnit.KILOGRAM,converted.getUnit());
        assertEquals(1,converted.getValue());
    }

    @Test
    void convertTo_1KgToKg_ShouldReturn1Kg() {
        Weight weight = new Weight(1, WeightUnit.KILOGRAM);
        Weight converted = weight.convertTo(WeightUnit.KILOGRAM);
        assertEquals(WeightUnit.KILOGRAM,converted.getUnit());
        assertEquals(1,converted.getValue());
    }

    @Test
    void convertTo_2_20462PoundToKg_ShouldReturn1Kg() {
        Weight weight = new Weight(2.20462, WeightUnit.POUND);
        Weight converted = weight.convertTo(WeightUnit.KILOGRAM);
        assertEquals(WeightUnit.KILOGRAM,converted.getUnit());
        assertEquals(1,converted.getValue());
    }

    @Test
    void add_KgToKg() {
        Weight weight = new Weight(1, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(1, WeightUnit.KILOGRAM);
        Weight add = weight.add(weight2);
        assertEquals(2,add.getValue());
        assertEquals(WeightUnit.KILOGRAM,add.getUnit());
    }


    @Test
    void add_GmToGm() {
        Weight weight = new Weight(1, WeightUnit.GRAM);
        Weight weight2 = new Weight(1, WeightUnit.GRAM);
        Weight add = weight.add(weight2);
        assertEquals(2,add.getValue());
        assertEquals(WeightUnit.GRAM,add.getUnit());
    }

    @Test
    void addPoundToPound() {
        Weight weight = new Weight(1, WeightUnit.POUND);
        Weight weight2 = new Weight(1, WeightUnit.POUND);
        Weight add = weight.add(weight2);
        assertEquals(2,add.getValue());
        assertEquals(WeightUnit.POUND,add.getUnit());
    }


    @Test
    void add_GmToKg() {
        Weight kg = new Weight(1, WeightUnit.KILOGRAM);
        Weight gram = new Weight(1000, WeightUnit.GRAM);
        Weight add = kg.add(gram);

        assertEquals(2,add.getValue(),EPSILON);
        assertEquals(WeightUnit.KILOGRAM,add.getUnit());
    }

    @Test
    void add_PoundToKg() {
        Weight kg = new Weight(1, WeightUnit.KILOGRAM);
        Weight pound = new Weight(2.20462, WeightUnit.POUND);
        Weight add = kg.add(pound);

        assertEquals(2,add.getValue(),EPSILON);
        assertEquals(WeightUnit.KILOGRAM,add.getUnit());
    }

    @Test
    void add_KgToGm() {
        Weight gram = new Weight(1000, WeightUnit.GRAM);
        Weight kg = new Weight(1, WeightUnit.KILOGRAM);
        Weight add = gram.add(kg);

        assertEquals(2000,add.getValue(),EPSILON);
        assertEquals(WeightUnit.GRAM,add.getUnit());
    }

    @Test
    void add_PoundToGm() {
        Weight gram = new Weight(1000, WeightUnit.GRAM);
        Weight pound = new Weight(2.20462, WeightUnit.POUND);
        Weight add = gram.add(pound);

        assertEquals(2000,add.getValue(),EPSILON);
        assertEquals(WeightUnit.GRAM,add.getUnit());
    }

    @Test
    void add_KgToPound() {
        Weight pound = new Weight(2.20462, WeightUnit.POUND);
        Weight kg = new Weight(1, WeightUnit.KILOGRAM);
        Weight add = pound.add(kg);

        assertEquals(4.40924,add.getValue(),EPSILON);
        assertEquals(WeightUnit.POUND,add.getUnit());
    }

    @Test
    void add_GmToPound() {
        Weight pound = new Weight(2.20462, WeightUnit.POUND);
        Weight gram = new Weight(1000, WeightUnit.GRAM);
        Weight add = pound.add(gram);

        assertEquals(4.40924,add.getValue(),EPSILON);
        assertEquals(WeightUnit.POUND,add.getUnit());
    }
/// /
    @Test
    void add_KgToKg_ResultInGram() {
        Weight weight = new Weight(1, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(1, WeightUnit.KILOGRAM);
        Weight add = weight.add(weight2,WeightUnit.GRAM);
        assertEquals(2000,add.getValue());
        assertEquals(WeightUnit.GRAM,add.getUnit());
    }


    @Test
    void add_GmToGm_ResultInPound() {
        Weight weight = new Weight(1000, WeightUnit.GRAM);
        Weight weight2 = new Weight(1000, WeightUnit.GRAM);
        Weight add = weight.add(weight2,WeightUnit.POUND);
        assertEquals(4.40924,add.getValue());
        assertEquals(WeightUnit.POUND,add.getUnit());
    }

    @Test
    void addPoundToPound_ResultInGram() {
        Weight weight = new Weight(2.20462, WeightUnit.POUND);
        Weight weight2 = new Weight(2.20462, WeightUnit.POUND);
        Weight add = weight.add(weight2,WeightUnit.GRAM);
        assertEquals(2000,add.getValue());
        assertEquals(WeightUnit.GRAM,add.getUnit());
    }


    @Test
    void add_GmToKg_ResultInPound() {
        Weight kg = new Weight(1, WeightUnit.KILOGRAM);
        Weight gram = new Weight(1000, WeightUnit.GRAM);
        Weight add = kg.add(gram,WeightUnit.POUND);

        assertEquals(4.40924,add.getValue(),EPSILON);
        assertEquals(WeightUnit.POUND,add.getUnit());
    }

    @Test
    void add_PoundToKg_ResultInGram() {
        Weight kg = new Weight(1, WeightUnit.KILOGRAM);
        Weight pound = new Weight(2.20462, WeightUnit.POUND);
        Weight add = kg.add(pound,WeightUnit.GRAM);

        assertEquals(2000,add.getValue(),EPSILON);
        assertEquals(WeightUnit.GRAM,add.getUnit());
    }

    @Test
    void add_KgToGm_ResultInPound() {
        Weight gram = new Weight(1000, WeightUnit.GRAM);
        Weight kg = new Weight(1, WeightUnit.KILOGRAM);
        Weight add = gram.add(kg, WeightUnit.POUND);

        assertEquals(4.40924,add.getValue(),EPSILON);
        assertEquals(WeightUnit.POUND,add.getUnit());
    }

    @Test
    void add_PoundToGm_ResultInKg() {
        Weight gram = new Weight(1000, WeightUnit.GRAM);
        Weight pound = new Weight(2.20462, WeightUnit.POUND);
        Weight add = gram.add(pound,WeightUnit.KILOGRAM);

        assertEquals(2,add.getValue(),EPSILON);
        assertEquals(WeightUnit.KILOGRAM,add.getUnit());
    }

    @Test
    void add_KgToPound_ResultInGm() {
        Weight pound = new Weight(2.20462, WeightUnit.POUND);
        Weight kg = new Weight(1, WeightUnit.KILOGRAM);
        Weight add = pound.add(kg,WeightUnit.GRAM);

        assertEquals(2000,add.getValue(),EPSILON);
        assertEquals(WeightUnit.GRAM,add.getUnit());
    }

    @Test
    void add_GmToPound_ResultInKg() {
        Weight pound = new Weight(2.20462, WeightUnit.POUND);
        Weight gram = new Weight(1000, WeightUnit.GRAM);
        Weight add = pound.add(gram,WeightUnit.KILOGRAM);

        assertEquals(2,add.getValue(),EPSILON);
        assertEquals(WeightUnit.KILOGRAM,add.getUnit());
    }


    @Test
    void testEquals() {
    }


    @Test
    void equals_sameValuesSameUnit_shouldReturnTrue() {
        // Given
        Weight w1 = new Weight(5.1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(5.1, WeightUnit.KILOGRAM);

        // When
        boolean result = w1.equals(w2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_sameValuesDiffUnit_shouldReturnFalse() {
        // Given
        Weight w1 = new Weight(5.1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(5.1, WeightUnit.GRAM);

        // When
        boolean result = w1.equals(w2);

        // Then
        assertFalse(result);
    }

    @Test
    void equals_KgToGramForSameWeight_shouldReturnTrue() {
        // Given
        Weight w1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000, WeightUnit.GRAM);

        // When
        boolean result = w1.equals(w2);

        // Then
        assertTrue(result);
    }





}