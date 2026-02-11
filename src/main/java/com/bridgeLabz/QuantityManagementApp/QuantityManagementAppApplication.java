package com.bridgeLabz.QuantityManagementApp;


import com.bridgeLabz.QuantityManagementApp.weight.Weight;
import com.bridgeLabz.QuantityManagementApp.weight.WeightUnit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QuantityManagementAppApplication {

	public static void main(String[] args) throws IOException {
        weightConversions();
	}


    private static void weightConversions() throws IOException {
        Weight w1,w2;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //first quantity
        System.out.println("enter first value:");
        String strValue1 = br.readLine();

        System.out.println("enter first unit:" + Arrays.toString(WeightUnit.values()));
        String unit1 = br.readLine();
        WeightUnit weightUnit1;
        double value1;
        try {
            weightUnit1 = WeightUnit.valueOf(unit1.toUpperCase());
            value1 = Double.parseDouble(strValue1);
            w1 = new Weight(value1, weightUnit1);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter finite numeric values. " + e.getMessage());
            return;
        }

        //second quantity
        System.out.println("enter second value:");
        String strValue2 = br.readLine();

        System.out.println("enter second unit:" + Arrays.toString(WeightUnit.values()));
        String unit2 = br.readLine();
        WeightUnit weightUnit2;
        double value2;
        try {
            weightUnit2 = WeightUnit.valueOf(unit2.toUpperCase());
            value2 = Double.parseDouble(strValue2);
            w2 = new Weight(value2, weightUnit2);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter finite numeric values. " + e.getMessage());
            return;
        }

        Weight addedInSource = w1.add(w2);
        System.out.println("Total of sum In Source:  " + addedInSource.getValue() + " " + addedInSource.getUnit().name());


        System.out.println("enter target unit:" + Arrays.toString(WeightUnit.values()));
        String unit3 = br.readLine();
        WeightUnit weightUnit3;
        try {
            weightUnit3 = WeightUnit.valueOf(unit3.toUpperCase());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values.");
            return;
        }

        Weight totalInTarget = w1.add(w2, weightUnit3);
        System.out.println("Sum ( in  " +   weightUnit3.name()  + ") :" + totalInTarget.getValue());


    }



}
