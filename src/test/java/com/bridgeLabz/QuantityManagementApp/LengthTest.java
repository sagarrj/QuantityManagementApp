package com.bridgeLabz.QuantityManagementApp;

import com.bridgeLabz.QuantityManagementApp.length.Length;
import com.bridgeLabz.QuantityManagementApp.length.LengthUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LengthTest {


    @Test
    void equals_sameValues_shouldReturnTrue() {
        // Given
        Length feet1 = new Length(5.0, LengthUnit.FEET);
        Length feet2 = new Length(5.0, LengthUnit.FEET);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertTrue(result);
    }
    @Test
    void equals_differentValues_shouldReturnFalse() {
        // Given
        Length feet1 = new Length(5.0, LengthUnit.FEET);
        Length feet2 = new Length(6.0, LengthUnit.FEET);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertFalse(result);
    }

    @Test
    void equals_nullObject_shouldReturnFalse() {
        // Given
        Length feet1 = new Length(5.0, LengthUnit.FEET);
        Length feet2 = null;

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertFalse(result);
    }
    @Test
    void equals_differentClassObject_shouldReturnFalse() {
        // Given
        Length feet1 = new Length(5.0, LengthUnit.FEET);
        Object obj = new Object();

        // When
        boolean result = feet1.equals(obj);

        // Then
        assertFalse(result);
    }
    @Test
    void equals_sameObject_Reflexive_shouldReturnTrue() {
        // Given
        Length feet1 = new Length(5.0, LengthUnit.FEET);

        // When
        boolean result = feet1.equals(feet1);

        // Then
        assertTrue(result);
    }
    @Test
    void equals_sameValues_Symmetric_shouldReturnTrue() {
        // Given
        Length feet1 = new Length(5.0, LengthUnit.FEET);
        Length feet2 = new Length(5.0, LengthUnit.FEET);

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
        Length feet1 = new Length(5.0, LengthUnit.FEET);
        Length feet2 = new Length(5.0, LengthUnit.FEET);

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
        Length feet1 = new Length(5.0000001, LengthUnit.FEET);
        Length feet2 = new Length(5.0000002, LengthUnit.FEET);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertFalse(result);
    }

    @Test
    void equals_negativeValues_shouldReturnTrue() {
        // Given
        Length feet1 = new Length(-5.0, LengthUnit.FEET);
        Length feet2 = new Length(-5.0, LengthUnit.FEET);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_zeroValues_shouldReturnTrue() {
        // Given
        Length feet1 = new Length(0.0, LengthUnit.FEET);
        Length feet2 = new Length(0.0, LengthUnit.FEET);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_largeValues_shouldReturnTrue() {
        // Given
        Length feet1 = new Length(1_000_000.0, LengthUnit.FEET);
        Length feet2 = new Length(1_000_000.0, LengthUnit.FEET);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_smallValues_shouldReturnTrue() {
        // Given
        Length feet1 = new Length(0.000001, LengthUnit.FEET);
        Length feet2 = new Length(0.000001, LengthUnit.FEET);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_differentSignValues_shouldReturnFalse() {
        // Given
        Length feet1 = new Length(5.0, LengthUnit.FEET);
        Length feet2 = new Length(-5.0, LengthUnit.FEET);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertFalse(result);
    }

    @Test
    void equals_differentDecimalValues_shouldReturnFalse() {
        // Given
        Length feet1 = new Length(5.1, LengthUnit.FEET);
        Length feet2 = new Length(5.2, LengthUnit.FEET);

        // When
        boolean result = feet1.equals(feet2);

        // Then
        assertFalse(result);
    }


    @Test
    void equals_differentUnitsSameValue_shouldReturnFalse() {
        // Given
        Length feet = new Length(12.0, LengthUnit.FEET);
        Length inch = new Length(12.0, LengthUnit.INCH);

        // When
        boolean result = feet.equals(inch);

        // Then
        assertFalse(result);
    }

    @Test
    void equals_yardComparisonToYardForSameLength_shouldReturnTrue() {
        // Given
        Length yard = new Length(1.0, LengthUnit.YARD);
        Length yard2 = new Length(1.0, LengthUnit.YARD);

        // When
        boolean result = yard.equals(yard2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_yardComparisonToFeetForSameLength_shouldReturnTrue() {
        // Given
        Length yard = new Length(1.0, LengthUnit.YARD);
        Length feet = new Length(3.0, LengthUnit.FEET);

        // When
        boolean result = yard.equals(feet);

        // Then
        assertTrue(result);
    }
    @Test
    void equals_yardComparisonToInchForSameLength_shouldReturnTrue() {
        // Given
        Length yard = new Length(1.0, LengthUnit.YARD);
        Length inch = new Length(36.0, LengthUnit.INCH);

        // When
        boolean result = yard.equals(inch);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_yardComparisonToCentimeterForSameLength_shouldReturnTrue() {
        // Given
        Length yard = new Length(1.0, LengthUnit.YARD);
        Length cm = new Length(91.44, LengthUnit.CENTIMETER);

        // When
        boolean result = yard.equals(cm);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_FeetComparisonToFeetForSameLength_shouldReturnTrue() {
        // Given
        Length q1 = new Length(1.0, LengthUnit.FEET);
        Length q2 = new Length(1.0, LengthUnit.FEET);

        // When
        boolean result = q1.equals(q2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_FeetComparisonToInchForSameLength_shouldReturnTrue() {
        // Given
        Length q1 = new Length(1.0, LengthUnit.FEET);
        Length q2 = new Length(12.0, LengthUnit.INCH);

        // When
        boolean result = q1.equals(q2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_FeetComparisonToCmForSameLength_shouldReturnTrue() {
        // Given
        Length q1 = new Length(1.0, LengthUnit.FEET);
        Length q2 = new Length(30.48, LengthUnit.CENTIMETER);

        // When
        boolean result = q1.equals(q2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_InchComparisonToInchForSameLength_shouldReturnTrue() {
        // Given
        Length q1 = new Length(1.0, LengthUnit.INCH);
        Length q2 = new Length(1.0, LengthUnit.INCH);

        // When
        boolean result = q1.equals(q2);

        // Then
        assertTrue(result);
    }

    @Test
    void equals_InchComparisonToCmForSameLength_shouldReturnTrue() {
        // Given
        Length q1 = new Length(1.0, LengthUnit.INCH);
        Length q2 = new Length(2.54, LengthUnit.CENTIMETER);

        // When
        boolean result = q1.equals(q2);

        // Then
        assertTrue(result);
    }

    @Test
    void convert_valueFromFeetToYard(){
        Length feet = new Length(3, LengthUnit.FEET);
        Length converted = feet.convertTo(LengthUnit.YARD);
        assertEquals(1,converted.getValue());
    }

    @Test
    void convert_valueYardToFeet(){
        Length yard = new Length(1, LengthUnit.YARD);
        Length converted = yard.convertTo( LengthUnit.FEET);
        assertEquals(3,converted.getValue());
    }


    @Test
    void double_isFinite_LargeNumber_ShouldThrowNumberFormatException (){
        String expected = "Number Out of Range";

        NumberFormatException exception = assertThrows(NumberFormatException.class, () -> {
            new Length(Double.MAX_VALUE * 100000000 , LengthUnit.INCH);
        });

        assertTrue(exception.getMessage().contains(expected));
    }

    @Test
    void double_isFinite_smallNumber_ShouldNotThrowException (){
        assertDoesNotThrow( () -> {
            new Length( 100000000 , LengthUnit.INCH);
        });

    }


    @Test
    void addValues_DiffUnit_shouldReturnAddInReturnUnit(){
        Length q1 = new Length(2, LengthUnit.YARD);
        Length q2 = new Length(12, LengthUnit.INCH);
        Length added = q1.add( q2, LengthUnit.CENTIMETER);

        assertEquals(213.0,Math.round(added.getValue()));
    }
}
