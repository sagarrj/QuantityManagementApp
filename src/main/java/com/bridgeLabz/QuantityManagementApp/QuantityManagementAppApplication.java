package com.bridgeLabz.QuantityManagementApp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuantityManagementAppApplication {

	public static void main(String[] args) throws IOException {

		checkFeetEquality();
		checkInchEquality();
	}

	private static void checkFeetEquality() throws IOException {
		Measurement feet1, feet2;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter first ft. value:");
		String value1 = br.readLine();
		try{
			feet1 = new Measurement(Double.parseDouble(value1), Unit.FEET);
		}catch (NumberFormatException e){
			System.out.println("Invalid input. Please enter numeric values.");
			return;
		}

		System.out.println("enter second ft. value:");
		String value2 = br.readLine();
		try{
			feet2 = new Measurement(Double.parseDouble(value2), Unit.FEET);
		}catch (NumberFormatException e){
			System.out.println("Invalid input. Please enter numeric values.");
			return;
		}

		System.out.println(feet1.equals(feet2));
	}

	private static void checkInchEquality() throws IOException {
		Measurement inch1, inch2;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter first inch value:");
		String value1 = br.readLine();
		try{
			inch1 = new Measurement(Double.parseDouble(value1), Unit.INCH);
		}catch (NumberFormatException e){
			System.out.println("Invalid input. Please enter numeric values.");
			return;
		}

		System.out.println("enter second inch value:");
		String value2 = br.readLine();
		try{
			inch2 = new Measurement(Double.parseDouble(value2),Unit.INCH);
		}catch (NumberFormatException e){
			System.out.println("Invalid input. Please enter numeric values.");
			return;
		}

		System.out.println(inch1.equals(inch2));
	}


}
