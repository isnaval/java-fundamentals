package fundamentals.conditionals.intermediate;

import java.util.Scanner;

public class ThreeNumberSorter {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		presentApplication();
		int option = showMenuAndGetOption(scanner);
		switch (option) {
		case 1:
			sortAscending(scanner);
			break;
		case 2:
			sortDescending(scanner);
			break;
		case 3:
			sortWithSteps(scanner);
			break;
		case 4:
			System.out.println("Thanks for using the number sorter");
			break;
		default:
			System.out.println("Invalid option");
		}

		scanner.close();
	}

	private static void presentApplication() {
		System.out.println("=======================================");
		System.out.println("      THREE NUMBER SORTER");
		System.out.println("=======================================");
		System.out.println("Program that sorts three numbers");
		System.out.println("using conditional logic");
		System.out.println();
	}

	private static int showMenuAndGetOption(Scanner scanner) {
		System.out.println("Select an option:");
		System.out.println("1. Sort ascending (smallest to largest)");
		System.out.println("2. Sort descending (largest to smallest)");
		System.out.println("3. Sort ascending (show steps)");
		System.out.println("4. Exit");
		System.out.print("\nEnter your option (1-4): ");

		return scanner.nextInt();
	}

	private static int[] requestData(Scanner scanner) {
		System.out.println("\n--- Data Input ---");
		System.out.print("Enter first number: ");
		int num1 = scanner.nextInt();
		System.out.print("Enter second number: ");
		int num2 = scanner.nextInt();
		System.out.print("Enter third number: ");
		int num3 = scanner.nextInt();

		return new int[] { num1, num2, num3 };
	}

	private static void sortAscending(Scanner scanner) {
		int[] numbers = requestData(scanner);
		int[] sorted = performAscendingSort(numbers[0], numbers[1], numbers[2]);
		System.out.println("\nOriginal numbers: " + numbers[0] + ", " + numbers[1] + ", " + numbers[2]);
		System.out.println("Sorted ascending: " + sorted[0] + ", " + sorted[1] + ", " + sorted[2]);

	}

	private static void sortDescending(Scanner scanner) {
		int[] numbers = requestData(scanner);
		int[] sorted = performDescendingSort(numbers[0], numbers[1], numbers[2]);

		System.out.println("\nOriginal numbers: " + numbers[0] + ", " + numbers[1] + ", " + numbers[2]);
		System.out.println("Sorted descending: " + sorted[0] + ", " + sorted[1] + ", " + sorted[2]);
	}

	private static int[] performAscendingSort(int a, int b, int c) {
		int first, second, third;

		if (a <= b && a <= c) {
			first = a;
			if (b <= c) {
				second = b;
				third = c;
			} else {
				second = c;
				third = b;
			}
		} else if (b <= a && b <= c) {
			first = b;
			if (a <= c) {
				second = a;
				third = c;
			} else {
				second = c;
				third = a;
			}
		} else {
			first = c;
			if (a <= b) {
				second = a;
				third = b;
			} else {
				second = b;
				third = a;
			}
		}

		return new int[] { first, second, third };
	}

	private static int[] performDescendingSort(int a, int b, int c) {
		int first, second, third;

		if (a >= b && a >= c) {
			first = a;
			if (b >= c) {
				second = b;
				third = c;
			} else {
				second = c;
				third = b;
			}
		} else if (b >= a && b >= c) {
			first = b;
			if (a >= c) {
				second = a;
				third = c;
			} else {
				second = c;
				third = a;
			}
		} else {
			first = c;
			if (a >= b) {
				second = a;
				third = b;
			} else {
				second = b;
				third = a;
			}
		}

		return new int[] { first, second, third };
	}

	private static int[] performAscendingSortWithSteps(int a, int b, int c) {
		System.out.println("\n--- Step by Step Sorting ---");
		System.out.println("Numbers to sort: " + a + ", " + b + ", " + c);

		int first, second, third;

		System.out.println("\nStep 1: Find the smallest number");
		if (a <= b && a <= c) {
			first = a;
			System.out.println("Smallest is: " + first + " (first number)");

			System.out.println("\nStep 2: Sort remaining numbers " + b + " and " + c);
			if (b <= c) {
				second = b;
				third = c;
				System.out.println("Between " + b + " and " + c + ", smaller is " + second);
			} else {
				second = c;
				third = b;
				System.out.println("Between " + b + " and " + c + ", smaller is " + second);
			}
		} else if (b <= a && b <= c) {
			first = b;
			System.out.println("Smallest is: " + first + " (second number)");

			System.out.println("\nStep 2: Sort remaining numbers " + a + " and " + c);
			if (a <= c) {
				second = a;
				third = c;
				System.out.println("Between " + a + " and " + c + ", smaller is " + second);
			} else {
				second = c;
				third = a;
				System.out.println("Between " + a + " and " + c + ", smaller is " + second);
			}
		} else {
			first = c;
			System.out.println("Smallest is: " + first + " (third number)");

			System.out.println("\nStep 2: Sort remaining numbers " + a + " and " + b);
			if (a <= b) {
				second = a;
				third = b;
				System.out.println("Between " + a + " and " + b + ", smaller is " + second);
			} else {
				second = b;
				third = a;
				System.out.println("Between " + a + " and " + b + ", smaller is " + second);
			}
		}

		System.out.println("\nStep 3: Final arrangement");
		System.out.println("First (smallest): " + first);
		System.out.println("Second (middle): " + second);
		System.out.println("Third (largest): " + third);

		return new int[] { first, second, third };
	}

	private static void sortWithSteps(Scanner scanner) {
		int[] numbers = requestData(scanner);
		performAscendingSortWithSteps(numbers[0], numbers[1], numbers[2]);
	}
}
