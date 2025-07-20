package exceptions.basic_exception_handling;

import java.util.Scanner;

public class AuxiliarMethods {

	private static Scanner scanner = new Scanner(System.in);

	public static void showWelcome() {
		System.out.println("🔧 ================ BASIC EXCEPTION HANDLING DEMO ==================");
		System.out.println("Welcome to the interactive exception handling demonstration!");
		System.out.println("You can test different utility methods and see how exceptions work.");
		System.out.println("===================================================================\n");
	}

	public static void showMenu() {
		System.out.println("\n📋 Choose a method to test:");
		System.out.println("1. Division");
		System.out.println("2. Square Root");
		System.out.println("3. Weekday by Index");
		System.out.println("4. Addition (with overflow check)");
		System.out.println("5. Factorial");
		System.out.println("6. Parse Integer");
		System.out.println("0. Exit");
		System.out.print("Enter your choice: ");
	}

	public static void showGoodbye() {
		System.out.println("\n🎉 Thank you for using the Exception Handling Demo!");
		System.out.println("You've learned how to handle different types of exceptions:");
		System.out.println("• ArithmeticException");
		System.out.println("• NullPointerException");
		System.out.println("• ArrayIndexOutOfBoundsException");
		System.out.println("• NumberFormatException");
		System.out.println("\n👋 Goodbye and happy coding!");
	}

	public static void executeChoice(int choice) {
		System.out.println();

		switch (choice) {
		case 1:
			division();
			break;
		case 2:
			squareRoot();
			break;
		case 3:
			weekdayByIndex();
			break;
		case 4:
			addition();
			break;
		case 5:
			factorial();
			break;
		case 6:
			parseInteger();
			break;
		case 0:
			// Exit - handled in main
			break;
		default:
			System.out.println("❌ Invalid choice. Please try again.");
		}
	}

	private static void division() {
		System.out.println("📊 Division Exercise");
		System.out.print("Enter numerator: ");
		double numerator = scanner.nextDouble();
		System.out.print("Enter denominator: ");
		double denominator = scanner.nextDouble();

		try {
			double result = Utils.divide(numerator, denominator);
			System.out.println("✅ Result: " + numerator + " / " + denominator + " = " + result);
		} catch (ArithmeticException e) {
			System.out.println("❌ Error: " + e.getMessage());
		}
	}

	private static void squareRoot() {
		System.out.println("√ Square Root Exercise");
		System.out.print("Enter a number: ");
		double number = scanner.nextDouble();

		try {
			double result = Utils.squareRoot(number);
			System.out.println("✅ Result: √" + number + " = " + result);
		} catch (ArithmeticException e) {
			System.out.println("❌ Error: " + e.getMessage());
		}
	}

	private static void weekdayByIndex() {
		System.out.println("📅 Weekday Exercise");
		System.out.print("Enter day index (0-6): ");
		int index = scanner.nextInt();

		try {
			String day = Utils.getWeekdayByIndex(index);
			System.out.println("✅ Result: Day " + index + " = " + day);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("❌ Error: " + e.getMessage());
		}
	}

	private static void addition() {
		System.out.println("➕ Addition Exercise");
		System.out.print("Enter first number: ");
		int num1 = scanner.nextInt();
		System.out.print("Enter second number: ");
		int num2 = scanner.nextInt();

		try {
			int result = Utils.add(num1, num2);
			System.out.println("✅ Result: " + num1 + " + " + num2 + " = " + result);
		} catch (ArithmeticException e) {
			System.out.println("❌ Error: " + e.getMessage());
		}
	}

	private static void factorial() {
		System.out.println("🔢 Factorial Exercise");
		System.out.print("Enter a number: ");
		int number = scanner.nextInt();

		try {
			long result = Utils.factorial(number);
			System.out.println("✅ Result: " + number + "! = " + result);
		} catch (ArithmeticException e) {
			System.out.println("❌ Error: " + e.getMessage());
		}
	}

	private static void parseInteger() {
		System.out.println("🔤 Parse Integer Exercise");
		System.out.print("Enter text to parse (or 'null' to test null): ");
		String text = scanner.next();

		if ("null".equals(text)) {
			text = null;
		}

		try {
			int result = Utils.parseInteger(text);
			System.out.println("✅ Result: Parsed '" + text + "' = " + result);
		} catch (NumberFormatException | NullPointerException e) {
			System.out.println("❌ Error: " + e.getMessage());
		}
	}

}
