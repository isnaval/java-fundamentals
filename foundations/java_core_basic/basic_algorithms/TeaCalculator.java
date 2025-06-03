package java_core_basic.basic_algorithms;

import java.util.Scanner;

public class TeaCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		presentApplication();
		int option = showMenuAndGetOption(scanner);

		switch (option) {
		case 1:
			calculateFromPacketWeight(scanner);
			break;
		case 2:
			calculateFromNumberOfCups(scanner);
			break;
		case 3:
			calculateWithCustomValues(scanner);
			break;
		case 4:
			calculateWithBreakdown(scanner);
			break;
		case 5:
			System.out.println("Thanks for using the Tea Calculator");
			break;
		default:
			System.out.println("Invalid option");
		}

		scanner.close();
	}

	private static void presentApplication() {
		System.out.println("=======================================");
		System.out.println("        TEA CALCULATOR");
		System.out.println("=======================================");
		System.out.println("Program that calculates tea servings");
		System.out.println("and water requirements");
		System.out.println();
	}

	private static int showMenuAndGetOption(Scanner scanner) {
		System.out.println("Select an option:");
		System.out.println("1. Calculate from tea packet weight");
		System.out.println("2. Calculate from desired number of cups");
		System.out.println("3. Calculate with custom tea/water ratios");
		System.out.println("4. Calculate with detailed breakdown");
		System.out.println("5. Exit");
		System.out.print("\nEnter your option (1-5): ");

		return scanner.nextInt();
	}

	private static void calculateFromPacketWeight(Scanner scanner) {
		final int GRAMS_OF_TEA_PER_CUP = 12;
		final int ML_OF_WATER_PER_CUP = 150;

		System.out.println("\n--- Calculate from Tea Packet Weight ---");
		System.out.print("Enter tea packet weight in grams: ");
		int packetWeight = scanner.nextInt();

		int numberOfCups = packetWeight / GRAMS_OF_TEA_PER_CUP;
		int totalWaterNeeded = numberOfCups * ML_OF_WATER_PER_CUP;
		int remainingTea = packetWeight % GRAMS_OF_TEA_PER_CUP;

		System.out.println("\nResults:");
		System.out.println("Tea packet weight: " + packetWeight + " grams");
		System.out.println("Number of cups possible: " + numberOfCups + " cups");
		System.out.println("Total water needed: " + totalWaterNeeded + " ml");
		System.out.println("Remaining tea: " + remainingTea + " grams");

		if (remainingTea > 0) {
			System.out.println("Note: " + remainingTea + " grams of tea will be left over");
		}
	}

	private static void calculateFromNumberOfCups(Scanner scanner) {
		final int GRAMS_OF_TEA_PER_CUP = 12;
		final int ML_OF_WATER_PER_CUP = 150;

		System.out.println("\n--- Calculate from Number of Cups ---");
		System.out.print("Enter desired number of cups: ");
		int desiredCups = scanner.nextInt();

		int teaNeeded = desiredCups * GRAMS_OF_TEA_PER_CUP;
		int waterNeeded = desiredCups * ML_OF_WATER_PER_CUP;

		System.out.println("\nResults:");
		System.out.println("Desired cups: " + desiredCups + " cups");
		System.out.println("Tea needed: " + teaNeeded + " grams");
		System.out.println("Water needed: " + waterNeeded + " ml");

		// Convert to larger units if needed
		if (waterNeeded >= 1000) {
			double liters = waterNeeded / 1000.0;
			System.out.println("Water needed: " + String.format("%.2f", liters) + " liters");
		}
	}

	private static void calculateWithCustomValues(Scanner scanner) {
		System.out.println("\n--- Calculate with Custom Ratios ---");
		System.out.print("Enter tea per cup (grams): ");
		int teaPerCup = scanner.nextInt();
		System.out.print("Enter water per cup (ml): ");
		int waterPerCup = scanner.nextInt();
		System.out.print("Enter tea packet weight (grams): ");
		int packetWeight = scanner.nextInt();

		int numberOfCups = packetWeight / teaPerCup;
		int totalWaterNeeded = numberOfCups * waterPerCup;
		int remainingTea = packetWeight % teaPerCup;

		System.out.println("\nResults with custom ratios:");
		System.out.println("Tea per cup: " + teaPerCup + " grams");
		System.out.println("Water per cup: " + waterPerCup + " ml");
		System.out.println("Tea packet weight: " + packetWeight + " grams");
		System.out.println("Number of cups possible: " + numberOfCups + " cups");
		System.out.println("Total water needed: " + totalWaterNeeded + " ml");
		System.out.println("Remaining tea: " + remainingTea + " grams");
	}

	private static void calculateWithBreakdown(Scanner scanner) {
		final int GRAMS_OF_TEA_PER_CUP = 12;
		final int ML_OF_WATER_PER_CUP = 150;

		System.out.println("\n--- Calculate with Detailed Breakdown ---");
		System.out.print("Enter tea packet weight in grams: ");
		int packetWeight = scanner.nextInt();

		System.out.println("\n--- Calculation Breakdown ---");
		System.out.println("Given information:");
		System.out.println("- Tea packet weight: " + packetWeight + " grams");
		System.out.println("- Tea required per cup: " + GRAMS_OF_TEA_PER_CUP + " grams");
		System.out.println("- Water required per cup: " + ML_OF_WATER_PER_CUP + " ml");

		System.out.println("\nStep 1: Calculate number of possible cups");
		int numberOfCups = packetWeight / GRAMS_OF_TEA_PER_CUP;
		System.out.println(
				"Number of cups = " + packetWeight + " ÷ " + GRAMS_OF_TEA_PER_CUP + " = " + numberOfCups + " cups");

		System.out.println("\nStep 2: Calculate total water needed");
		int totalWaterNeeded = numberOfCups * ML_OF_WATER_PER_CUP;
		System.out.println(
				"Total water = " + numberOfCups + " × " + ML_OF_WATER_PER_CUP + " = " + totalWaterNeeded + " ml");

		System.out.println("\nStep 3: Calculate remaining tea");
		int remainingTea = packetWeight % GRAMS_OF_TEA_PER_CUP;
		System.out.println(
				"Remaining tea = " + packetWeight + " % " + GRAMS_OF_TEA_PER_CUP + " = " + remainingTea + " grams");

		System.out.println("\nFinal Summary:");
		System.out.println("✓ You can make " + numberOfCups + " complete cups of tea");
		System.out.println("✓ You will need " + totalWaterNeeded + " ml of water total");

		if (remainingTea > 0) {
			System.out.println("✓ You will have " + remainingTea + " grams of tea left over");
			double efficiency = ((double) (packetWeight - remainingTea) / packetWeight) * 100;
			System.out.println("✓ Tea usage efficiency: " + String.format("%.1f", efficiency) + "%");
		} else {
			System.out.println("✓ You will use all the tea with no waste");
			System.out.println("✓ Tea usage efficiency: 100.0%");
		}
	}
}