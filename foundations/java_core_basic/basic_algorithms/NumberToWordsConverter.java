package java_core_basic.basic_algorithms;

import java.util.Scanner;

public class NumberToWordsConverter {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		presentApplication();
		int option = showMenuAndGetOption(scanner);

		switch (option) {
		case 1:
			convertBasicNumber(scanner);
			break;
		case 2:
			convertWithBreakdown(scanner);
			break;
		case 3:
			convertMultipleNumbers(scanner);
			break;
		case 4:
			System.out.println("Thanks for using the number converter");
			break;
		default:
			System.out.println("Invalid option");
		}

		scanner.close();
	}

	private static void presentApplication() {
		System.out.println("=======================================");
		System.out.println("    NUMBER TO WORDS CONVERTER");
		System.out.println("=======================================");
		System.out.println("Program that converts numbers (0-99)");
		System.out.println("to their written form in Spanish");
		System.out.println();
	}

	private static int showMenuAndGetOption(Scanner scanner) {
		System.out.println("Select an option:");
		System.out.println("1. Convert number (direct result)");
		System.out.println("2. Convert number (show breakdown)");
		System.out.println("3. Convert multiple numbers");
		System.out.println("4. Exit");
		System.out.print("\nEnter your option (1-4): ");

		return scanner.nextInt();
	}

	private static void convertBasicNumber(Scanner scanner) {
		int number = requestData(scanner);
		String result = performConversion(number);

		if (result != null) {
			System.out.println("\nResult: " + number + " = " + result);
		}
	}

	private static void convertWithBreakdown(Scanner scanner) {
		int number = requestData(scanner);
		String result = performConversionWithBreakdown(number);

		if (result != null) {
			System.out.println("\nResult: " + number + " = " + result);
		}
	}

	private static void convertMultipleNumbers(Scanner scanner) {
		System.out.println("\n--- Multiple Number Conversion ---");
		System.out.print("How many numbers do you want to convert? ");
		int count = scanner.nextInt();

		for (int i = 1; i <= count; i++) {
			System.out.print("Enter number " + i + ": ");
			int number = scanner.nextInt();
			String result = performConversion(number);

			if (result != null) {
				System.out.println(number + " = " + result);
			}
		}
	}

	private static int requestData(Scanner scanner) {
		System.out.println("\n--- Data Input ---");
		System.out.print("Enter a number (0-99): ");
		return scanner.nextInt();
	}

	private static String performConversion(int number) {
		if (number < 0 || number > 99) {
			System.out.println("ERROR: Number must be between 0 and 99.");
			return null;
		}

		return numberToWords(number);
	}

	private static String performConversionWithBreakdown(int number) {
		if (number < 0 || number > 99) {
			System.out.println("ERROR: Number must be between 0 and 99.");
			return null;
		}

		System.out.println("\n--- Conversion Breakdown ---");
		System.out.println("Original number: " + number);

		if (number == 0) {
			System.out.println("Special case: zero");
			return numberToWords(number);
		}

		if (number < 20) {
			System.out.println("Number is less than 20: using direct conversion");
			return numberToWords(number);
		}

		int tens = number / 10;
		int units = number % 10;

		System.out.println("Breaking down number:");
		System.out.println("  Tens: " + tens + " -> " + tensToWords(tens));

		if (units > 0) {
			System.out.println("  Units: " + units + " -> " + unitsToWords(units));
			System.out.println("  Combining: " + tensToWords(tens) + " y " + unitsToWords(units));
		} else {
			System.out.println("  No units to add");
		}

		return numberToWords(number);
	}

	private static String numberToWords(int number) {
		if (number == 0) {
			return "cero";
		}

		if (number < 20) {
			return unitsToWords(number);
		} else {
			int tens = number / 10;
			int units = number % 10;

			String result = tensToWords(tens);

			if (units > 0) {
				result += " y " + unitsToWords(units);
			}

			return result;
		}
	}

	private static String tensToWords(int tens) {
		switch (tens) {
		case 2:
			return "veinte";
		case 3:
			return "treinta";
		case 4:
			return "cuarenta";
		case 5:
			return "cincuenta";
		case 6:
			return "sesenta";
		case 7:
			return "setenta";
		case 8:
			return "ochenta";
		case 9:
			return "noventa";
		default:
			return "";
		}
	}

	private static String unitsToWords(int units) {
		switch (units) {
		case 1:
			return "uno";
		case 2:
			return "dos";
		case 3:
			return "tres";
		case 4:
			return "cuatro";
		case 5:
			return "cinco";
		case 6:
			return "seis";
		case 7:
			return "siete";
		case 8:
			return "ocho";
		case 9:
			return "nueve";
		case 10:
			return "diez";
		case 11:
			return "once";
		case 12:
			return "doce";
		case 13:
			return "trece";
		case 14:
			return "catorce";
		case 15:
			return "quince";
		case 16:
			return "dieciséis";
		case 17:
			return "diecisiete";
		case 18:
			return "dieciocho";
		case 19:
			return "diecinueve";
		default:
			return "";
		}
	}
}