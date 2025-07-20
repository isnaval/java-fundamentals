package exceptions.geometric_area_calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

	static Scanner scanner = new Scanner(System.in);

	@SuppressWarnings("unused")
	public static void showWelcome() {
		System.out.println("🔢 =============================================== 🔢");
		System.out.println("   📐 GEOMETRIC AREA CALCULATOR 📐");
		System.out.println("🔢 =============================================== 🔢");
	}

	@SuppressWarnings("unused")
	public static void showMenu() {
		System.out.println("\n📋 ----- GEOMETRIC SHAPES MENU -----");
		System.out.println("1️⃣  Calculate circle area");
		System.out.println("2️⃣  Calculate square area");
		System.out.println("3️⃣  Calculate rectangle area");
		System.out.println("4️⃣  Calculate triangle area");
		System.out.println("5️⃣  Exit program");
		System.out.print("\n🎯 Choose an option (1-5): ");
	}

	@SuppressWarnings("unused")
	public static int getOption() throws InputMismatchException, UnknownShapeException {
		int option = scanner.nextInt();

		if (option < 1 || option > 5) {
			throw new UnknownShapeException("Invalid option. Please select between 1 and 5.");
		}

		return option;
	}

	public static void showGoodbye() {
		System.out.println("\n👋 Thank you for using the Geometric Area Calculator!");
	}

	public static double getDoubleInput(String prompt) throws InputMismatchException {
		System.out.print(prompt);
		return scanner.nextDouble();
	}

	public static void showResult(String shape, double area) {
		System.out.printf("📏 The %s area is: %.2f square units%n", shape, area);
	}

	public static void showError(String message) {
		System.out.println("\n❌ Error: " + message);
	}

	public static void closeScanner() {
		scanner.close();
	}

}
