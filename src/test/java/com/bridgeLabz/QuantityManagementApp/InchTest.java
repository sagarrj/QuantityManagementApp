package com.bridgeLabz.QuantityManagementApp;

import com.bridgeLabz.QuantityManagementApp.QuantityManagementAppApplication.Inch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InchTest {


    @Test
    void equals_sameValues_shouldReturnTrue() {
        // Given
        Inch inch1 = new Inch(5.0);
        Inch inch2 = new Inch(5.0);

        // When
        boolean result = inch1.equals(inch2);

        // Then
        assertTrue(result);
    }
    @Test
    void equals_differentValues_shouldReturnFalse() {
        // Given
        Inch inch1 = new Inch(5.0);
        Inch inch2 = new Inch(6.0);

        // When
        boolean result = inch1.equals(inch2);

        // Then
        assertFalse(result);
    }

    @Test
    void equals_nullObject_shouldReturnFalse() {
        // Given
        Inch inch1 = new Inch(5.0);
        Inch inch2 = null;

        // When
        boolean result = inch1.equals(inch2);

        // Then
        assertFalse(result);
    }
    @Test
    void equals_differentClassObject_shouldReturnFalse() {
        // Given
        Inch inch1 = new Inch(5.0);
        Object obj = new Object();

        // When
        boolean result = inch1.equals(obj);

        // Then
        assertFalse(result);
    }
    @Test
    void equals_sameObject_Reflexive_shouldReturnTrue() {
        // Given
        Inch inch1 = new Inch(5.0);

        // When
        boolean result = inch1.equals(inch1);

        // Then
        assertTrue(result);
    }
    @Test
    void equals_sameValues_Symmetric_shouldReturnTrue() {
        // Given
        Inch inch1 = new Inch(5.0);
        Inch inch2 = new Inch(5.0);

        // When
        boolean result = inch1.equals(inch2);
        boolean result2 = inch2.equals(inch1);

        // Then
        assertTrue(result);
        assertTrue(result2);
    }

    @Test
    void equals_sameValues_Consistent_shouldReturnTrue() {
        // Given
        Inch inch1 = new Inch(5.0);
        Inch inch2 = new Inch(5.0);

        // When
        boolean result = inch1.equals(inch2);
        boolean result2 = inch1.equals(inch2);

        // Then
        assertTrue(result);
        assertTrue(result2);
    }
    @Test
    void equals_precisionCheck_shouldReturnFalse() {
        // Given
        Inch inch1 = new Inch(5.0000001);
        Inch inch2 = new Inch(5.0000002);

        // When
        boolean result = inch1.equals(inch2);

        // Then
        assertFalse(result);
    }

    @Test
    void equals_negativeValues_shouldReturnTrue() {
        // Given
        Inch inch1 = new Inch(-5.0);
        Inch inch2 = new Inch(-5.0);

        // When
        boolean result = inch1.equals(inch2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_zeroValues_shouldReturnTrue() {
        // Given
        Inch inch1 = new Inch(0.0);
        Inch inch2 = new Inch(0.0);

        // When
        boolean result = inch1.equals(inch2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_largeValues_shouldReturnTrue() {
        // Given
        Inch inch1 = new Inch(1_000_000.0);
        Inch inch2 = new Inch(1_000_000.0);

        // When
        boolean result = inch1.equals(inch2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_smallValues_shouldReturnTrue() {
        // Given
        Inch inch1 = new Inch(0.000001);
        Inch inch2 = new Inch(0.000001);

        // When
        boolean result = inch1.equals(inch2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_differentSignValues_shouldReturnFalse() {
        // Given
        Inch inch1 = new Inch(5.0);
        Inch inch2 = new Inch(-5.0);

        // When
        boolean result = inch1.equals(inch2);

        // Then
        assertFalse(result);
    }

    @Test
    void equals_differentDecimalValues_shouldReturnFalse() {
        // Given
        Inch inch1 = new Inch(5.1);
        Inch inch2 = new Inch(5.2);

        // When
        boolean result = inch1.equals(inch2);

        // Then
        assertFalse(result);
    }
}
