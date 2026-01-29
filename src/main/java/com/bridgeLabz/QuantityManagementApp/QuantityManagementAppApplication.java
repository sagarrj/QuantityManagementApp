package com.bridgeLabz.QuantityManagementApp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class QuantityManagementAppApplication {

	public static void main(String[] args) throws IOException {

		checkFeetEquality();
		checkInchEquality();
	}

	private static void checkFeetEquality() throws IOException {
		Feet feet1, feet2;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter first ft. value:");
		String value1 = br.readLine();
		try{
			feet1 = new Feet(Double.parseDouble(value1));
		}catch (NumberFormatException e){
			System.out.println("Invalid input. Please enter numeric values.");
			return;
		}

		System.out.println("enter second ft. value:");
		String value2 = br.readLine();
		try{
			feet2 = new Feet(Double.parseDouble(value2));
		}catch (NumberFormatException e){
			System.out.println("Invalid input. Please enter numeric values.");
			return;
		}

		System.out.println(feet1.equals(feet2));
	}

	private static void checkInchEquality() throws IOException {
		Inch inch1, inch2;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter first inch value:");
		String value1 = br.readLine();
		try{
			inch1 = new Inch(Double.parseDouble(value1));
		}catch (NumberFormatException e){
			System.out.println("Invalid input. Please enter numeric values.");
			return;
		}

		System.out.println("enter second inchvalue:");
		String value2 = br.readLine();
		try{
			inch2 = new Inch(Double.parseDouble(value2));
		}catch (NumberFormatException e){
			System.out.println("Invalid input. Please enter numeric values.");
			return;
		}

		System.out.println(inch1.equals(inch2));
	}

	public static class Feet {
		private final double value;

		public Feet(double value) {
			this.value = value;
		}
		public double getValue() {
			return value;
		}

		@Override
		public boolean equals(Object o) {
			if (o == null || getClass() != o.getClass()) return false;
			Feet feet = (Feet) o;
			return Double.compare(value, feet.value) == 0;
		}

		@Override
		public int hashCode() {
			return Objects.hashCode(value);
		}


	}

	public static class Inch {
		private final double value;

		public Inch(double value) {
			this.value = value;
		}
		public double getValue() {
			return value;
		}

		@Override
		public boolean equals(Object o) {
			if (o == null || getClass() != o.getClass()) return false;
			Inch inch = (Inch) o;
			return Double.compare(value, inch.value) == 0;
		}

		@Override
		public int hashCode() {
			return Objects.hashCode(value);
		}


	}


}
