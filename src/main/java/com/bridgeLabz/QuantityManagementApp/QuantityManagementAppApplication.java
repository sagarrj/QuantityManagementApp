package com.bridgeLabz.QuantityManagementApp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class QuantityManagementAppApplication {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter first value:");
		String value1 = br.readLine();

		System.out.println("enter second value:");
		String value2 = br.readLine();

		Feet feet1 = new Feet(Double.parseDouble(value1));
		Feet feet2 = new Feet(Double.parseDouble(value2));

		System.out.println(feet1.equals(feet2));
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

}
