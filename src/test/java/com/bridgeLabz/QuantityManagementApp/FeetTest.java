package com.bridgeLabz.QuantityManagementApp;

import com.bridgeLabz.QuantityManagementApp.QuantityManagementAppApplication.Feet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FeetTest {


    @Test
    void equals_sameValues_shouldReturnTrue() {
        // Given
        Feet feet1 = new Feet(5.0);
        Feet feet2 = new Feet(5.0);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertTrue(result);
    }
    @Test
    void equals_differentValues_shouldReturnFalse() {
        // Given
        Feet feet1 = new Feet(5.0);
        Feet feet2 = new Feet(6.0);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertFalse(result);
    }

    @Test
    void equals_nullObject_shouldReturnFalse() {
        // Given
        Feet feet1 = new Feet(5.0);
        Feet feet2 = null;

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertFalse(result);
    }
    @Test
    void equals_differentClassObject_shouldReturnFalse() {
        // Given
        Feet feet1 = new Feet(5.0);
        Object obj = new Object();

        // When
        boolean result = feet1.equals(obj);

        // Then
        assertFalse(result);
    }
    @Test
    void equals_sameObject_Reflexive_shouldReturnTrue() {
        // Given
        Feet feet1 = new Feet(5.0);

        // When
        boolean result = feet1.equals(feet1);

        // Then
        assertTrue(result);
    }
    @Test
    void equals_sameValues_Symmetric_shouldReturnTrue() {
        // Given
        Feet feet1 = new Feet(5.0);
        Feet feet2 = new Feet(5.0);

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
        Feet feet1 = new Feet(5.0);
        Feet feet2 = new Feet(5.0);

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
        Feet feet1 = new Feet(5.0000001);
        Feet feet2 = new Feet(5.0000002);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertFalse(result);
    }

    @Test
    void equals_negativeValues_shouldReturnTrue() {
        // Given
        Feet feet1 = new Feet(-5.0);
        Feet feet2 = new Feet(-5.0);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_zeroValues_shouldReturnTrue() {
        // Given
        Feet feet1 = new Feet(0.0);
        Feet feet2 = new Feet(0.0);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_largeValues_shouldReturnTrue() {
        // Given
        Feet feet1 = new Feet(1_000_000.0);
        Feet feet2 = new Feet(1_000_000.0);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_smallValues_shouldReturnTrue() {
        // Given
        Feet feet1 = new Feet(0.000001);
        Feet feet2 = new Feet(0.000001);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_differentSignValues_shouldReturnFalse() {
        // Given
        Feet feet1 = new Feet(5.0);
        Feet feet2 = new Feet(-5.0);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertFalse(result);
    }

    @Test
    void equals_differentDecimalValues_shouldReturnFalse() {
        // Given
        Feet feet1 = new Feet(5.1);
        Feet feet2 = new Feet(5.2);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertFalse(result);
    }
}
