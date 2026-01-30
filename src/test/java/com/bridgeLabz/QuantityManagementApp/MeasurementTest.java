package com.bridgeLabz.QuantityManagementApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MeasurementTest {


    @Test
    void equals_sameValues_shouldReturnTrue() {
        // Given
        Measurement feet1 = new Measurement(5.0, Unit.FEET);
        Measurement feet2 = new Measurement(5.0, Unit.FEET);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertTrue(result);
    }
    @Test
    void equals_differentValues_shouldReturnFalse() {
        // Given
        Measurement feet1 = new Measurement(5.0,Unit.FEET);
        Measurement feet2 = new Measurement(6.0,Unit.FEET);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertFalse(result);
    }

    @Test
    void equals_nullObject_shouldReturnFalse() {
        // Given
        Measurement feet1 = new Measurement(5.0,Unit.FEET);
        Measurement feet2 = null;

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertFalse(result);
    }
    @Test
    void equals_differentClassObject_shouldReturnFalse() {
        // Given
        Measurement feet1 = new Measurement(5.0,Unit.FEET);
        Object obj = new Object();

        // When
        boolean result = feet1.equals(obj);

        // Then
        assertFalse(result);
    }
    @Test
    void equals_sameObject_Reflexive_shouldReturnTrue() {
        // Given
        Measurement feet1 = new Measurement(5.0,Unit.FEET);

        // When
        boolean result = feet1.equals(feet1);

        // Then
        assertTrue(result);
    }
    @Test
    void equals_sameValues_Symmetric_shouldReturnTrue() {
        // Given
        Measurement feet1 = new Measurement(5.0,Unit.FEET);
        Measurement feet2 = new Measurement(5.0,Unit.FEET);

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
        Measurement feet1 = new Measurement(5.0,Unit.FEET);
        Measurement feet2 = new Measurement(5.0,Unit.FEET);

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
        Measurement feet1 = new Measurement(5.0000001,Unit.FEET);
        Measurement feet2 = new Measurement(5.0000002,Unit.FEET);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertFalse(result);
    }

    @Test
    void equals_negativeValues_shouldReturnTrue() {
        // Given
        Measurement feet1 = new Measurement(-5.0,Unit.FEET);
        Measurement feet2 = new Measurement(-5.0,Unit.FEET);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_zeroValues_shouldReturnTrue() {
        // Given
        Measurement feet1 = new Measurement(0.0,Unit.FEET);
        Measurement feet2 = new Measurement(0.0,Unit.FEET);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_largeValues_shouldReturnTrue() {
        // Given
        Measurement feet1 = new Measurement(1_000_000.0,Unit.FEET);
        Measurement feet2 = new Measurement(1_000_000.0,Unit.FEET);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_smallValues_shouldReturnTrue() {
        // Given
        Measurement feet1 = new Measurement(0.000001,Unit.FEET);
        Measurement feet2 = new Measurement(0.000001,Unit.FEET);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_differentSignValues_shouldReturnFalse() {
        // Given
        Measurement feet1 = new Measurement(5.0,Unit.FEET);
        Measurement feet2 = new Measurement(-5.0,Unit.FEET);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertFalse(result);
    }

    @Test
    void equals_differentDecimalValues_shouldReturnFalse() {
        // Given
        Measurement feet1 = new Measurement(5.1,Unit.FEET);
        Measurement feet2 = new Measurement(5.2,Unit.FEET);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertFalse(result);
    }


    @Test
    void equals_differentUnitsSameValue_shouldReturnFalse() {
        // Given
        Measurement feet = new Measurement(12.0,Unit.FEET);
        Measurement inch = new Measurement(12.0,Unit.INCH);

        // When
        boolean result = feet.equals(inch);

        // Then
        assertFalse(result);
    }
}
