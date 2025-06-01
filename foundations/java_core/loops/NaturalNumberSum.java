package java_core.loops;

import java.util.Scanner;

public class NaturalNumberSum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		presentApplication();
		int option = showMenuAndGetOption(scanner);

		switch (option) {
		case 1:
			calculateBasicSum(scanner);
			break;
		case 2:
			calculateSumWithSteps(scanner);
			break;
		case 3:
			System.out.println("Thanks for using the sum calculator");
			break;
		default:
			System.out.println("Invalid option");
		}

		scanner.close();

	}

	private static void presentApplication() {
		System.out.println("=======================================");
		System.out.println("     NATURAL NUMBER SUM CALCULATOR");
		System.out.println("=======================================");
		System.out.println("Program that calculates sum of natural numbers");
		System.out.println();
	}

	private static int showMenuAndGetOption(Scanner scanner) {
		System.out.println("Select an option:");
		System.out.println("1. Calculate sum (direct result)");
		System.out.println("2. Calculate sum (show steps)");
		System.out.println("3. Exit");
		System.out.print("\nEnter your option (1-3): ");

		return scanner.nextInt();
	}

	private static int requestData(Scanner scanner) {
		System.out.println("\n--- Data Input ---");
		System.out.print("Enter a positive number: ");
		return scanner.nextInt();
	}

	private static long performCalculation(int number) {
		if (number <= 0) {
			System.out.println("ERROR: Please enter a positive number.");
			return -1;
		}

		long sum = 0;
		for (int i = 1; i <= number; i++) {
			sum += i;
		}

		return sum;
	}

	private static void calculateBasicSum(Scanner scanner) {
		int number = requestData(scanner);
		long result = performCalculation(number);
		if (result != -1) {
			System.out.println("\nResult: Sum of first " + number + " natural numbers = " + result);

		}
	}

	private static void calculateSumWithSteps(Scanner scanner) {
		int number = requestData(scanner);
		long result = performCalculation(number);

		if (result != -1) {
			System.out.println("\nResult: Sum of first " + number + " natural numbers = " + result);
			showSteps(number);
		}
	}

	private static void showSteps(int number) {
		System.out.println("\n--- Step by Step Calculation ---");

		// Show the formula
		System.out.print("Sum = ");
		for (int i = 1; i <= number; i++) {
			System.out.print(i);
			if (i < number)
				System.out.print(" + ");
		}
		System.out.println();

		// Show each step
		long sum = 0;
		for (int i = 1; i <= number; i++) {
			sum += i;
			System.out.println("Step " + i + ": " + sum);
		}
	}

}
