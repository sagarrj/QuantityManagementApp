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
        QuantityLength q1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //first quantity
        System.out.println("enter first value:");
        String strValue1 = br.readLine();

        System.out.println("enter source unit:" + Arrays.toString(LengthUnit.values()));
        String unit1 = br.readLine();
        LengthUnit lengthUnit1;
        double value1;
        try {
            lengthUnit1 = LengthUnit.valueOf(unit1.toUpperCase());
            value1 = Double.parseDouble(strValue1);
            q1 = new QuantityLength(value1, lengthUnit1);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter finite numeric values. " + e.getMessage());
            return;
        }


        System.out.println("enter target unit:" + Arrays.toString(LengthUnit.values()));
        String unit2 = br.readLine();
        LengthUnit lengthUnit2;
        try {
            lengthUnit2 = LengthUnit.valueOf(unit2.toUpperCase());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values.");
            return;
        }

		QuantityLength targetLength = QuantityLength.convert(q1, lengthUnit2);
		System.out.println("Converted value: "  + targetLength.getValue() + " " + targetLength.getLengthUnit().name() );

        QuantityLength targetLengthAgain = QuantityLength.convert(value1, lengthUnit1,  lengthUnit2);
        System.out.println("Converted value: "  + targetLengthAgain.getValue() + " " + targetLengthAgain.getLengthUnit().name() );


    }



}
