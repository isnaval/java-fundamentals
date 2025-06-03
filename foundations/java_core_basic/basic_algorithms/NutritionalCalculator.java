package java_core_basic.basic_algorithms;

import java.util.Scanner;

public class NutritionalCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		presentApplication();
		int option = showMenuAndGetOption(scanner);

		switch (option) {
		case 1:
			calculateBasicNutrition(scanner);
			break;
		case 2:
			calculateCustomPortion(scanner);
			break;
		case 3:
			calculateWithBreakdown(scanner);
			break;
		case 4:
			calculateMultipleFoods(scanner);
			break;
		case 5:
			calculateDailyIntake(scanner);
			break;
		case 6:
			System.out.println("Thanks for using the Nutritional Calculator");
			break;
		default:
			System.out.println("Invalid option");
		}

		scanner.close();
	}

	private static void presentApplication() {
		System.out.println("=======================================");
		System.out.println("    NUTRITIONAL CALCULATOR");
		System.out.println("=======================================");
		System.out.println("Program that calculates calories from");
		System.out.println("proteins, carbohydrates, and fats");
		System.out.println();
	}

	private static int showMenuAndGetOption(Scanner scanner) {
		System.out.println("Select an option:");
		System.out.println("1. Calculate nutrition for 100g portion");
		System.out.println("2. Calculate nutrition for custom portion");
		System.out.println("3. Calculate with detailed breakdown");
		System.out.println("4. Calculate multiple foods");
		System.out.println("5. Calculate daily intake analysis");
		System.out.println("6. Exit");
		System.out.print("\nEnter your option (1-6): ");

		return scanner.nextInt();
	}

	private static void calculateBasicNutrition(Scanner scanner) {
		final int CALORIES_PER_GRAM_PROTEIN = 4;
		final int CALORIES_PER_GRAM_CARBS = 4;
		final int CALORIES_PER_GRAM_FAT = 9;
		final double PORTION_SIZE = 100.0;

		System.out.println("\n--- Basic Nutrition Calculation (100g portion) ---");
		double[] macros = requestMacronutrients(scanner);

		double[] calories = calculateCalories(macros, CALORIES_PER_GRAM_PROTEIN, CALORIES_PER_GRAM_CARBS,
				CALORIES_PER_GRAM_FAT);
		double totalCalories = calories[0] + calories[1] + calories[2];

		displayNutritionResults(macros, calories, totalCalories, PORTION_SIZE);
	}

	private static void calculateCustomPortion(Scanner scanner) {
		final int CALORIES_PER_GRAM_PROTEIN = 4;
		final int CALORIES_PER_GRAM_CARBS = 4;
		final int CALORIES_PER_GRAM_FAT = 9;

		System.out.println("\n--- Custom Portion Calculation ---");
		System.out.print("Enter portion size in grams: ");
		double portionSize = scanner.nextDouble();

		System.out.println("Enter macronutrients per 100g:");
		double[] macrosPer100g = requestMacronutrients(scanner);

		// Scale macronutrients to actual portion size
		double[] actualMacros = scaleMacronutrients(macrosPer100g, portionSize);
		double[] calories = calculateCalories(actualMacros, CALORIES_PER_GRAM_PROTEIN, CALORIES_PER_GRAM_CARBS,
				CALORIES_PER_GRAM_FAT);
		double totalCalories = calories[0] + calories[1] + calories[2];

		System.out.println("\nFor " + portionSize + "g portion:");
		displayNutritionResults(actualMacros, calories, totalCalories, portionSize);
	}

	private static void calculateWithBreakdown(Scanner scanner) {
		final int CALORIES_PER_GRAM_PROTEIN = 4;
		final int CALORIES_PER_GRAM_CARBS = 4;
		final int CALORIES_PER_GRAM_FAT = 9;
		final double PORTION_SIZE = 100.0;

		System.out.println("\n--- Detailed Breakdown Calculation ---");
		double[] macros = requestMacronutrients(scanner);

		System.out.println("\n--- Calculation Breakdown ---");
		System.out.println("Given macronutrients per 100g:");
		System.out.println("- Proteins: " + macros[0] + "g");
		System.out.println("- Carbohydrates: " + macros[1] + "g");
		System.out.println("- Fats: " + macros[2] + "g");

		System.out.println("\nCalorie conversion rates:");
		System.out.println("- Proteins: " + CALORIES_PER_GRAM_PROTEIN + " cal/g");
		System.out.println("- Carbohydrates: " + CALORIES_PER_GRAM_CARBS + " cal/g");
		System.out.println("- Fats: " + CALORIES_PER_GRAM_FAT + " cal/g");

		System.out.println("\nStep-by-step calculation:");
		double proteinCalories = macros[0] * CALORIES_PER_GRAM_PROTEIN;
		System.out.println("Protein calories = " + macros[0] + " × " + CALORIES_PER_GRAM_PROTEIN + " = "
				+ proteinCalories + " cal");

		double carbCalories = macros[1] * CALORIES_PER_GRAM_CARBS;
		System.out.println("Carbohydrate calories = " + macros[1] + " × " + CALORIES_PER_GRAM_CARBS + " = "
				+ carbCalories + " cal");

		double fatCalories = macros[2] * CALORIES_PER_GRAM_FAT;
		System.out
				.println("Fat calories = " + macros[2] + " × " + CALORIES_PER_GRAM_FAT + " = " + fatCalories + " cal");

		double totalCalories = proteinCalories + carbCalories + fatCalories;
		System.out.println("Total calories = " + proteinCalories + " + " + carbCalories + " + " + fatCalories + " = "
				+ totalCalories + " cal");

		// Calculate percentages
		System.out.println("\nCalorie distribution:");
		System.out.println("- Proteins: " + String.format("%.1f", (proteinCalories / totalCalories) * 100) + "%");
		System.out.println("- Carbohydrates: " + String.format("%.1f", (carbCalories / totalCalories) * 100) + "%");
		System.out.println("- Fats: " + String.format("%.1f", (fatCalories / totalCalories) * 100) + "%");
	}

	private static void calculateMultipleFoods(Scanner scanner) {
		final int CALORIES_PER_GRAM_PROTEIN = 4;
		final int CALORIES_PER_GRAM_CARBS = 4;
		final int CALORIES_PER_GRAM_FAT = 9;

		System.out.println("\n--- Multiple Foods Calculation ---");
		System.out.print("How many foods do you want to analyze? ");
		int foodCount = scanner.nextInt();

		double totalProtein = 0, totalCarbs = 0, totalFats = 0;
		double totalCalories = 0;

		for (int i = 1; i <= foodCount; i++) {
			System.out.println("\n--- Food " + i + " ---");
			System.out.print("Enter portion size in grams: ");
			double portionSize = scanner.nextDouble();

			System.out.println("Enter macronutrients per 100g:");
			double[] macrosPer100g = requestMacronutrients(scanner);

			double[] actualMacros = scaleMacronutrients(macrosPer100g, portionSize);
			double[] calories = calculateCalories(actualMacros, CALORIES_PER_GRAM_PROTEIN, CALORIES_PER_GRAM_CARBS,
					CALORIES_PER_GRAM_FAT);

			totalProtein += actualMacros[0];
			totalCarbs += actualMacros[1];
			totalFats += actualMacros[2];
			totalCalories += (calories[0] + calories[1] + calories[2]);

			System.out.println("Food " + i + " (" + portionSize + "g): "
					+ String.format("%.1f", calories[0] + calories[1] + calories[2]) + " calories");
		}

		System.out.println("\n--- Total Intake Summary ---");
		System.out.println("Total proteins: " + String.format("%.2f", totalProtein) + "g");
		System.out.println("Total carbohydrates: " + String.format("%.2f", totalCarbs) + "g");
		System.out.println("Total fats: " + String.format("%.2f", totalFats) + "g");
		System.out.println("Total calories: " + String.format("%.1f", totalCalories) + " cal");
	}

	private static void calculateDailyIntake(Scanner scanner) {
		System.out.println("\n--- Daily Intake Analysis ---");
		System.out.print("Enter your daily calorie goal: ");
		double calorieGoal = scanner.nextDouble();

		calculateMultipleFoods(scanner);

		// This would typically use the results from calculateMultipleFoods
		// For now, we'll ask for total calories consumed
		System.out.print("\nEnter total calories consumed today: ");
		double caloriesConsumed = scanner.nextDouble();

		double difference = caloriesConsumed - calorieGoal;
		double percentageOfGoal = (caloriesConsumed / calorieGoal) * 100;

		System.out.println("\n--- Daily Analysis ---");
		System.out.println("Calorie goal: " + String.format("%.0f", calorieGoal) + " cal");
		System.out.println("Calories consumed: " + String.format("%.0f", caloriesConsumed) + " cal");
		System.out.println("Difference: " + String.format("%.0f", difference) + " cal");
		System.out.println("Percentage of goal: " + String.format("%.1f", percentageOfGoal) + "%");

		if (difference > 0) {
			System.out.println("Status: Over your daily goal by " + String.format("%.0f", difference) + " calories");
		} else if (difference < 0) {
			System.out.println(
					"Status: Under your daily goal by " + String.format("%.0f", Math.abs(difference)) + " calories");
		} else {
			System.out.println("Status: Perfect! You've met your daily calorie goal");
		}
	}

	private static double[] requestMacronutrients(Scanner scanner) {
		System.out.print("Enter proteins (g): ");
		double proteins = scanner.nextDouble();
		System.out.print("Enter carbohydrates (g): ");
		double carbohydrates = scanner.nextDouble();
		System.out.print("Enter fats (g): ");
		double fats = scanner.nextDouble();

		return new double[] { proteins, carbohydrates, fats };
	}

	private static double[] calculateCalories(double[] macros, int proteinCal, int carbCal, int fatCal) {
		double proteinCalories = macros[0] * proteinCal;
		double carbCalories = macros[1] * carbCal;
		double fatCalories = macros[2] * fatCal;

		return new double[] { proteinCalories, carbCalories, fatCalories };
	}

	private static double[] scaleMacronutrients(double[] macrosPer100g, double portionSize) {
		double scaleFactor = portionSize / 100.0;
		return new double[] { macrosPer100g[0] * scaleFactor, macrosPer100g[1] * scaleFactor,
				macrosPer100g[2] * scaleFactor };
	}

	private static void displayNutritionResults(double[] macros, double[] calories, double totalCalories,
			double portionSize) {
		System.out.println("\n--- Nutrition Results ---");
		System.out.println("Portion size: " + portionSize + "g");
		System.out.println(
				"Proteins: " + String.format("%.2f", macros[0]) + "g (" + String.format("%.1f", calories[0]) + " cal)");
		System.out.println("Carbohydrates: " + String.format("%.2f", macros[1]) + "g ("
				+ String.format("%.1f", calories[1]) + " cal)");
		System.out.println(
				"Fats: " + String.format("%.2f", macros[2]) + "g (" + String.format("%.1f", calories[2]) + " cal)");
		System.out.println("Total calories: " + String.format("%.1f", totalCalories) + " cal");
	}
}