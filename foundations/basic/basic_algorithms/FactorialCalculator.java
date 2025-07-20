package basic.basic_algorithms;

import java.math.BigInteger;
import java.util.Scanner;

public class FactorialCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		presentApplication();
		int option = showMenuAndGetOption(scanner);
		switch (option) {
		case 1:
			calculateBasicFactorial(scanner);
			break;
		case 2:
			calculateFactorialWithSteps(scanner);
			break;
		case 3:
			System.out.println("Thanks for using the factorial calculator");
			break;
		default:
			System.out.println("Invalid option");
		}
		scanner.close();
	}

	private static void presentApplication() {
		System.out.println("=======================================");
		System.out.println("       FACTORIAL CALCULATOR");
		System.out.println("=======================================");
		System.out.println("Program that calculates n! (factorial)");
		System.out.println();
	}

	private static int showMenuAndGetOption(Scanner scanner) {
		System.out.println("Select an option:");
		System.out.println("1. Calculate factorial (direct result)");
		System.out.println("2. Calculate factorial (show steps)");
		System.out.println("3. Exit");
		System.out.print("\nEnter your option (1-3): ");

		return scanner.nextInt();
	}

	private static void calculateBasicFactorial(Scanner scanner) {
		int number = requestData(scanner);
		BigInteger result = performCalculation(number);
		if (!result.equals(BigInteger.valueOf(-1))) {
			System.out.println("\nResult: " + number + "! = " + result);
		}

	}

	private static void calculateFactorialWithSteps(Scanner scanner) {
		int number = requestData(scanner);
		BigInteger result = performCalculation(number);
		if (!result.equals(BigInteger.valueOf(-1))) {
			System.out.println("\nResult: " + number + "! = " + result);
			showSteps(number);
		}
	}

	private static int requestData(Scanner scanner) {
		System.out.println("\n--- Data Input ---");
		System.out.print("Enter a number: ");
		return scanner.nextInt();

	}

	private static BigInteger performCalculation(int number) {
		if (number < 0) {
			System.out.println("ERROR: Factorial not defined for negative numbers.");
			return BigInteger.valueOf(-1);
		}

		BigInteger result = BigInteger.ONE;

		for (int i = 1; i <= number; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}

		return result;
	}

	private static void showSteps(int number) {
		System.out.println("\n--- Step by Step Calculation ---");

		if (number == 0) {
			System.out.println("0! = 1");
			return;
		}

		System.out.print(number + "! = ");
		for (int i = number; i >= 1; i--) {
			System.out.print(i);
			if (i > 1)
				System.out.print(" × ");
		}
		System.out.println();

		BigInteger result = BigInteger.ONE;
		for (int i = 1; i <= number; i++) {
			result = result.multiply(BigInteger.valueOf(i));
			System.out.println("Step " + i + ": " + result);
		}
	}

}
