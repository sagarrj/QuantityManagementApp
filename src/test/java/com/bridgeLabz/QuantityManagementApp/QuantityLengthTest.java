package com.bridgeLabz.QuantityManagementApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuantityLengthTest {


    @Test
    void equals_sameValues_shouldReturnTrue() {
        // Given
        QuantityLength feet1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength feet2 = new QuantityLength(5.0, LengthUnit.FEET);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertTrue(result);
    }
    @Test
    void equals_differentValues_shouldReturnFalse() {
        // Given
        QuantityLength feet1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength feet2 = new QuantityLength(6.0, LengthUnit.FEET);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertFalse(result);
    }

    @Test
    void equals_nullObject_shouldReturnFalse() {
        // Given
        QuantityLength feet1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength feet2 = null;

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertFalse(result);
    }
    @Test
    void equals_differentClassObject_shouldReturnFalse() {
        // Given
        QuantityLength feet1 = new QuantityLength(5.0, LengthUnit.FEET);
        Object obj = new Object();

        // When
        boolean result = feet1.equals(obj);

        // Then
        assertFalse(result);
    }
    @Test
    void equals_sameObject_Reflexive_shouldReturnTrue() {
        // Given
        QuantityLength feet1 = new QuantityLength(5.0, LengthUnit.FEET);

        // When
        boolean result = feet1.equals(feet1);

        // Then
        assertTrue(result);
    }
    @Test
    void equals_sameValues_Symmetric_shouldReturnTrue() {
        // Given
        QuantityLength feet1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength feet2 = new QuantityLength(5.0, LengthUnit.FEET);

        // When
        boolean result = feet1.equals(feet2);
        boolean result2 = feet2.equals(feet1);

        // Then
        assertTrue(result);
        assertTrue(result2);
    }

    @Test
    void equals_sameValues_Consistent_shouldReturnTrue() {
        // Given
        QuantityLength feet1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength feet2 = new QuantityLength(5.0, LengthUnit.FEET);

        // When
        boolean result = feet1.equals(feet2);
        boolean result2 = feet1.equals(feet2);

        // Then
        assertTrue(result);
        assertTrue(result2);
    }
    @Test
    void equals_precisionCheck_shouldReturnFalse() {
        // Given
        QuantityLength feet1 = new QuantityLength(5.0000001, LengthUnit.FEET);
        QuantityLength feet2 = new QuantityLength(5.0000002, LengthUnit.FEET);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertFalse(result);
    }

    @Test
    void equals_negativeValues_shouldReturnTrue() {
        // Given
        QuantityLength feet1 = new QuantityLength(-5.0, LengthUnit.FEET);
        QuantityLength feet2 = new QuantityLength(-5.0, LengthUnit.FEET);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_zeroValues_shouldReturnTrue() {
        // Given
        QuantityLength feet1 = new QuantityLength(0.0, LengthUnit.FEET);
        QuantityLength feet2 = new QuantityLength(0.0, LengthUnit.FEET);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_largeValues_shouldReturnTrue() {
        // Given
        QuantityLength feet1 = new QuantityLength(1_000_000.0, LengthUnit.FEET);
        QuantityLength feet2 = new QuantityLength(1_000_000.0, LengthUnit.FEET);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_smallValues_shouldReturnTrue() {
        // Given
        QuantityLength feet1 = new QuantityLength(0.000001, LengthUnit.FEET);
        QuantityLength feet2 = new QuantityLength(0.000001, LengthUnit.FEET);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_differentSignValues_shouldReturnFalse() {
        // Given
        QuantityLength feet1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength feet2 = new QuantityLength(-5.0, LengthUnit.FEET);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertFalse(result);
    }

    @Test
    void equals_differentDecimalValues_shouldReturnFalse() {
        // Given
        QuantityLength feet1 = new QuantityLength(5.1, LengthUnit.FEET);
        QuantityLength feet2 = new QuantityLength(5.2, LengthUnit.FEET);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertFalse(result);
    }


    @Test
    void equals_differentUnitsSameValue_shouldReturnFalse() {
        // Given
        QuantityLength feet = new QuantityLength(12.0, LengthUnit.FEET);
        QuantityLength inch = new QuantityLength(12.0, LengthUnit.INCH);

        // When
        boolean result = feet.equals(inch);

        // Then
        assertFalse(result);
    }

    @Test
    void equals_yardComparisonToYardForSameLength_shouldReturnTrue() {
        // Given
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength yard2 = new QuantityLength(1.0, LengthUnit.YARD);

        // When
        boolean result = yard.equals(yard2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_yardComparisonToFeetForSameLength_shouldReturnTrue() {
        // Given
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);

        // When
        boolean result = yard.equals(feet);

        // Then
        assertTrue(result);
    }
    @Test
    void equals_yardComparisonToInchForSameLength_shouldReturnTrue() {
        // Given
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength inch = new QuantityLength(36.0, LengthUnit.INCH);

        // When
        boolean result = yard.equals(inch);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_yardComparisonToCentimeterForSameLength_shouldReturnTrue() {
        // Given
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength cm = new QuantityLength(91.44, LengthUnit.CENTIMETER);

        // When
        boolean result = yard.equals(cm);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_FeetComparisonToFeetForSameLength_shouldReturnTrue() {
        // Given
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);

        // When
        boolean result = q1.equals(q2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_FeetComparisonToInchForSameLength_shouldReturnTrue() {
        // Given
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);

        // When
        boolean result = q1.equals(q2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_FeetComparisonToCmForSameLength_shouldReturnTrue() {
        // Given
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(30.48, LengthUnit.CENTIMETER);

        // When
        boolean result = q1.equals(q2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_InchComparisonToInchForSameLength_shouldReturnTrue() {
        // Given
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCH);

        // When
        boolean result = q1.equals(q2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_InchComparisonToCmForSameLength_shouldReturnTrue() {
        // Given
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(2.54, LengthUnit.CENTIMETER);

        // When
        boolean result = q1.equals(q2);

        // Then
        assertTrue(result);
    }
}
