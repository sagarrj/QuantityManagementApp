package com.bridgeLabz.QuantityManagementApp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QuantityManagementAppApplication {

	public static void main(String[] args) throws IOException {
		convertLength();
	}

	private static void convertLength() throws IOException {
        Length q1,q2;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //first quantity
        System.out.println("enter first value:");
        String strValue1 = br.readLine();

        System.out.println("enter first unit:" + Arrays.toString(LengthUnit.values()));
        String unit1 = br.readLine();
        LengthUnit lengthUnit1;
        double value1;
        try {
            lengthUnit1 = LengthUnit.valueOf(unit1.toUpperCase());
            value1 = Double.parseDouble(strValue1);
            q1 = new Length(value1, lengthUnit1);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter finite numeric values. " + e.getMessage());
            return;
        }

        //second quantity
        System.out.println("enter second value:");
        String strValue2 = br.readLine();

        System.out.println("enter second unit:" + Arrays.toString(LengthUnit.values()));
        String unit2 = br.readLine();
        LengthUnit lengthUnit2;
        double value2;
        try {
            lengthUnit2 = LengthUnit.valueOf(unit2.toUpperCase());
            value2 = Double.parseDouble(strValue2);
            q2 = new Length(value2, lengthUnit2);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter finite numeric values. " + e.getMessage());
            return;
        }

        Length addedInSource = q1.add(q2);
        System.out.println("Total of sum In Source:  " + addedInSource.getValue() + " " + addedInSource.getUnit().name());


        System.out.println("enter target unit:" + Arrays.toString(LengthUnit.values()));
        String unit3 = br.readLine();
        LengthUnit lengthUnit3;
        try {
            lengthUnit3 = LengthUnit.valueOf(unit3.toUpperCase());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values.");
            return;
        }

        Length totalInTarget = q1.add(q2, lengthUnit3);
        System.out.println("Sum ( in  " +   lengthUnit3.name()  + ") :" + totalInTarget.getValue());


    }



}
