package java_core_basic.basic_algorithms;

import java.math.BigInteger;
import java.util.Scanner;

public class PowerCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		presentApplication();
		int option = showMenuAndGetOption(scanner);

		switch (option) {
		case 1:
			calculateBasicPower(scanner);
			break;
		case 2:
			calculatePoweWithSteps(scanner);
			break;
		case 3:
			System.out.println("Thanks for using the power calculator");
			break;
		default:
			System.out.println("Invalid option");
		}
		scanner.close();

	}

	private static void presentApplication() {
		System.out.println("=======================================");
		System.out.println("         POWER CALCULATOR");
		System.out.println("=======================================");
		System.out.println("Program that calculates base^exponent");
		System.out.println("without using Java built-in methods");
		System.out.println();
	}

	private static int showMenuAndGetOption(Scanner scanner) {
		System.out.println("Select an option: ");
		System.out.println("1. Calculate power (direct result): ");
		System.out.println("2. Calculate power (show steps): ");
		System.out.println("3. Exit");
		System.out.print("\nEnter your option (1-3): ");

		return scanner.nextInt();
	}

	private static void calculateBasicPower(Scanner scanner) {
		int[] data = requestData(scanner);
		int base = data[0];
		int exponent = data[1];
		BigInteger result = performCalculation(base, exponent);
		if (!result.equals(BigInteger.valueOf(-1))) {
			System.out.println("\nResult: " + base + "^" + exponent + " = " + result);
		}

	}

	private static int[] requestData(Scanner scanner) {
		System.out.println("\n --- Data input ---");
		System.out.println("Enter the base: ");
		int base = scanner.nextInt();
		System.out.println("Enter the exponent: ");
		int exponent = scanner.nextInt();
		return new int[] { base, exponent };
	}

	private static void calculatePoweWithSteps(Scanner scanner) {

		int[] data = requestData(scanner);
		int base = data[0];
		int exponent = data[1];
		BigInteger result = performCalculation(base, exponent);
		if (!result.equals(BigInteger.valueOf(-1))) {
			System.out.println("\nResult: " + base + "^" + exponent + " = " + result);
			showSteps(base, exponent);
		}
	}

	private static BigInteger performCalculation(int base, int exponent) {
		if (exponent < 0) {
			System.out.println("ERROR: This program only handles non-negatives exponents.");
			return BigInteger.valueOf(-1);
		}

		if (exponent == 0) {
			return BigInteger.ONE;
		}

		if (base == 0) {
			return BigInteger.ZERO;
		}

		BigInteger result = BigInteger.ONE;
		BigInteger baseBig = BigInteger.valueOf(base);

		for (int i = 0; i < exponent; i++) {
			result = result.multiply(baseBig);
		}

		return result;
	}

	private static void showSteps(int base, int exponent) {

		System.out.println("\n--- Step by Step Calculation ---");

		if (exponent == 0) {
			System.out.println("\n--- Step by Step Calculation ---");
			return;
		}

		System.out.print(base + "^" + exponent + " = ");
		for (int i = 0; i < exponent; i++) {
			System.out.print(base);
			if (i < exponent - 1) {
				System.out.print(" × ");
			}
		}
		System.out.println();

		BigInteger result = BigInteger.ONE;
		BigInteger baseBig = BigInteger.valueOf(base);

		for (int i = 1; i < exponent; i++) {
			result = result.multiply(baseBig);
			System.out.println("Step " + i + ": " + result);

		}

	}
}
