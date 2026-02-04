package com.bridgeLabz.QuantityManagementApp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuantityManagementAppApplication {

	public static void main(String[] args) throws IOException {

//		checkFeetEquality();
//		checkInchEquality();
		checkGenericEquality();
	}

	private static void checkGenericEquality() throws IOException {
		QuantityLength q1, q2;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//first quantity
		System.out.println("enter first value:");
		String value1 = br.readLine();

		System.out.println("enter unit:");
		String unit1 = br.readLine();
		try{
			LengthUnit lengthUnit1 = LengthUnit.valueOf(unit1.toUpperCase());
			q1 = new QuantityLength(Double.parseDouble(value1),lengthUnit1);
		}catch (NumberFormatException e){
			System.out.println("Invalid input. Please enter numeric values.");
			return;
		}


		//second quantity
		System.out.println("enter second value:");
		String value2 = br.readLine();

		System.out.println("enter unit:");
		String unit2 = br.readLine();
		try{
			LengthUnit lengthUnit2 = LengthUnit.valueOf(unit2.toUpperCase());
			q2 = new QuantityLength(Double.parseDouble(value2),lengthUnit2);
		}catch (NumberFormatException e){
			System.out.println("Invalid input. Please enter numeric values.");
			return;
		}

		//check equality
		System.out.println(q1.equals(q2));

	}

	private static void checkFeetEquality() throws IOException {
		QuantityLength feet1, feet2;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter first ft. value:");
		String value1 = br.readLine();
		try{
			feet1 = new QuantityLength(Double.parseDouble(value1), LengthUnit.FEET);
		}catch (NumberFormatException e){
			System.out.println("Invalid input. Please enter numeric values.");
			return;
		}

		System.out.println("enter second ft. value:");
		String value2 = br.readLine();
		try{
			feet2 = new QuantityLength(Double.parseDouble(value2), LengthUnit.FEET);
		}catch (NumberFormatException e){
			System.out.println("Invalid input. Please enter numeric values.");
			return;
		}

		System.out.println(feet1.equals(feet2));
	}

	private static void checkInchEquality() throws IOException {
		QuantityLength inch1, inch2;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter first inch value:");
		String value1 = br.readLine();
		try{
			inch1 = new QuantityLength(Double.parseDouble(value1), LengthUnit.INCH);
		}catch (NumberFormatException e){
			System.out.println("Invalid input. Please enter numeric values.");
			return;
		}

		System.out.println("enter second inch value:");
		String value2 = br.readLine();
		try{
			inch2 = new QuantityLength(Double.parseDouble(value2), LengthUnit.INCH);
		}catch (NumberFormatException e){
			System.out.println("Invalid input. Please enter numeric values.");
			return;
		}

		System.out.println(inch1.equals(inch2));
	}


}
