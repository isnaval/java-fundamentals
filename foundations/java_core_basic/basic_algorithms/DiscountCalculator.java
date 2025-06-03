package java_core_basic.basic_algorithms;

import java.util.Scanner;

public class DiscountCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		presentApplication();
		int option = showMenuAndGetOption(scanner);

		switch (option) {
		case 1:
			calculateBasicDiscount(scanner);
			break;
		case 2:
			calculateMultipleDiscounts(scanner);
			break;
		case 3:
			calculateBulkDiscount(scanner);
			break;
		case 4:
			calculateWithTax(scanner);
			break;
		case 5:
			calculateWithBreakdown(scanner);
			break;
		case 6:
			calculateSavingsComparison(scanner);
			break;
		case 7:
			System.out.println("Thanks for using the Discount Calculator");
			break;
		default:
			System.out.println("Invalid option");
		}

		scanner.close();
	}

	private static void presentApplication() {
		System.out.println("=======================================");
		System.out.println("      DISCOUNT CALCULATOR");
		System.out.println("=======================================");
		System.out.println("Program that calculates discounts,");
		System.out.println("final prices, and savings");
		System.out.println();
	}

	private static int showMenuAndGetOption(Scanner scanner) {
		System.out.println("Select an option:");
		System.out.println("1. Calculate basic discount");
		System.out.println("2. Calculate multiple discounts (stacked)");
		System.out.println("3. Calculate bulk discount");
		System.out.println("4. Calculate discount with tax");
		System.out.println("5. Calculate with detailed breakdown");
		System.out.println("6. Compare savings between discounts");
		System.out.println("7. Exit");
		System.out.print("\nEnter your option (1-7): ");

		return scanner.nextInt();
	}

	private static void calculateBasicDiscount(Scanner scanner) {
		System.out.println("\n--- Basic Discount Calculation ---");
		System.out.print("Enter original price (€): ");
		double originalPrice = scanner.nextDouble();
		System.out.print("Enter discount percentage (%): ");
		double discountPercentage = scanner.nextDouble();

		double[] results = performBasicDiscount(originalPrice, discountPercentage);

		displayBasicResults(originalPrice, discountPercentage, results[0], results[1]);
	}

	private static void calculateMultipleDiscounts(Scanner scanner) {
		System.out.println("\n--- Multiple Stacked Discounts ---");
		System.out.print("Enter original price (€): ");
		double currentPrice = scanner.nextDouble();
		double originalPrice = currentPrice;

		System.out.print("How many discounts to apply? ");
		int discountCount = scanner.nextInt();

		double totalSavings = 0;

		System.out.println("\nApplying discounts sequentially:");
		for (int i = 1; i <= discountCount; i++) {
			System.out.print("Enter discount " + i + " percentage (%): ");
			double discount = scanner.nextDouble();

			double discountAmount = currentPrice * (discount / 100);
			double newPrice = currentPrice - discountAmount;
			totalSavings += discountAmount;

			System.out.println("After discount " + i + " (" + discount + "%): €" + String.format("%.2f", newPrice)
					+ " (saved €" + String.format("%.2f", discountAmount) + ")");

			currentPrice = newPrice;
		}

		double totalDiscountPercentage = ((originalPrice - currentPrice) / originalPrice) * 100;

		System.out.println("\n--- Final Results ---");
		System.out.println("Original price: €" + String.format("%.2f", originalPrice));
		System.out.println("Final price: €" + String.format("%.2f", currentPrice));
		System.out.println("Total savings: €" + String.format("%.2f", totalSavings));
		System.out.println("Effective discount: " + String.format("%.2f", totalDiscountPercentage) + "%");
	}

	private static void calculateBulkDiscount(Scanner scanner) {
		System.out.println("\n--- Bulk Discount Calculation ---");
		System.out.print("Enter unit price (€): ");
		double unitPrice = scanner.nextDouble();
		System.out.print("Enter quantity: ");
		int quantity = scanner.nextInt();

		double totalBeforeDiscount = unitPrice * quantity;

		// Define bulk discount tiers
		double discountPercentage = 0;
		if (quantity >= 100) {
			discountPercentage = 20;
		} else if (quantity >= 50) {
			discountPercentage = 15;
		} else if (quantity >= 20) {
			discountPercentage = 10;
		} else if (quantity >= 10) {
			discountPercentage = 5;
		}

		double[] results = performBasicDiscount(totalBeforeDiscount, discountPercentage);

		System.out.println("\n--- Bulk Discount Results ---");
		System.out.println("Unit price: €" + String.format("%.2f", unitPrice));
		System.out.println("Quantity: " + quantity + " units");
		System.out.println("Subtotal: €" + String.format("%.2f", totalBeforeDiscount));

		if (discountPercentage > 0) {
			System.out.println("Bulk discount applied: " + discountPercentage + "%");
			System.out.println("Discount amount: €" + String.format("%.2f", results[0]));
			System.out.println("Final total: €" + String.format("%.2f", results[1]));
			System.out.println("Price per unit after discount: €" + String.format("%.2f", results[1] / quantity));
		} else {
			System.out.println("No bulk discount applied (minimum 10 units required)");
			System.out.println("Final total: €" + String.format("%.2f", totalBeforeDiscount));
		}
	}

	private static void calculateWithTax(Scanner scanner) {
		System.out.println("\n--- Discount with Tax Calculation ---");
		System.out.print("Enter original price (€): ");
		double originalPrice = scanner.nextDouble();
		System.out.print("Enter discount percentage (%): ");
		double discountPercentage = scanner.nextDouble();
		System.out.print("Enter tax rate (%) [21% VAT default]: ");
		double taxRate = scanner.nextDouble();

		// Calculate discount first, then apply tax
		double[] discountResults = performBasicDiscount(originalPrice, discountPercentage);
		double priceAfterDiscount = discountResults[1];
		double taxAmount = priceAfterDiscount * (taxRate / 100);
		double finalPriceWithTax = priceAfterDiscount + taxAmount;

		System.out.println("\n--- Tax Calculation Results ---");
		System.out.println("Original price: €" + String.format("%.2f", originalPrice));
		System.out.println("Discount (" + discountPercentage + "%): -€" + String.format("%.2f", discountResults[0]));
		System.out.println("Price after discount: €" + String.format("%.2f", priceAfterDiscount));
		System.out.println("Tax (" + taxRate + "%): +€" + String.format("%.2f", taxAmount));
		System.out.println("Final price with tax: €" + String.format("%.2f", finalPriceWithTax));

		// Compare with tax applied before discount
		double taxOnOriginal = originalPrice * (taxRate / 100);
		double priceWithTaxFirst = originalPrice + taxOnOriginal;
		double[] discountOnTaxedPrice = performBasicDiscount(priceWithTaxFirst, discountPercentage);

		System.out.println("\nComparison (if tax applied before discount):");
		System.out.println("Price with tax first: €" + String.format("%.2f", discountOnTaxedPrice[1]));
		System.out.println(
				"Difference: €" + String.format("%.2f", Math.abs(finalPriceWithTax - discountOnTaxedPrice[1])));
	}

	private static void calculateWithBreakdown(Scanner scanner) {
		System.out.println("\n--- Detailed Breakdown Calculation ---");
		System.out.print("Enter original price (€): ");
		double originalPrice = scanner.nextDouble();
		System.out.print("Enter discount percentage (%): ");
		double discountPercentage = scanner.nextDouble();

		System.out.println("\n--- Calculation Breakdown ---");
		System.out.println("Given information:");
		System.out.println("- Original price: €" + String.format("%.2f", originalPrice));
		System.out.println("- Discount percentage: " + discountPercentage + "%");

		System.out.println("\nStep 1: Convert percentage to decimal");
		double discountDecimal = discountPercentage / 100;
		System.out.println("Discount decimal = " + discountPercentage + "% ÷ 100 = " + discountDecimal);

		System.out.println("\nStep 2: Calculate discount amount");
		double discountAmount = originalPrice * discountDecimal;
		System.out.println("Discount amount = €" + String.format("%.2f", originalPrice) + " × " + discountDecimal
				+ " = €" + String.format("%.2f", discountAmount));

		System.out.println("\nStep 3: Calculate final price");
		double finalPrice = originalPrice - discountAmount;
		System.out.println("Final price = €" + String.format("%.2f", originalPrice) + " - €"
				+ String.format("%.2f", discountAmount) + " = €" + String.format("%.2f", finalPrice));

		System.out.println("\nStep 4: Verify calculation (alternative method)");
		double payPercentage = 100 - discountPercentage;
		double alternativeFinalPrice = originalPrice * (payPercentage / 100);
		System.out.println("You pay " + payPercentage + "% of original price");
		System.out.println("Alternative calculation = €" + String.format("%.2f", originalPrice) + " × "
				+ (payPercentage / 100) + " = €" + String.format("%.2f", alternativeFinalPrice));

		System.out.println("\nFinal Summary:");
		System.out.println("✓ You save: €" + String.format("%.2f", discountAmount) + " (" + discountPercentage + "%)");
		System.out
				.println("✓ You pay: €" + String.format("%.2f", finalPrice) + " (" + payPercentage + "% of original)");
	}

	private static void calculateSavingsComparison(Scanner scanner) {
		System.out.println("\n--- Savings Comparison ---");
		System.out.print("Enter original price (€): ");
		double originalPrice = scanner.nextDouble();

		System.out.print("Enter first discount option (%): ");
		double discount1 = scanner.nextDouble();
		System.out.print("Enter second discount option (%): ");
		double discount2 = scanner.nextDouble();

		double[] results1 = performBasicDiscount(originalPrice, discount1);
		double[] results2 = performBasicDiscount(originalPrice, discount2);

		System.out.println("\n--- Comparison Results ---");
		System.out.println("Original price: €" + String.format("%.2f", originalPrice));

		System.out.println("\nOption 1 (" + discount1 + "% discount):");
		System.out.println("- Discount amount: €" + String.format("%.2f", results1[0]));
		System.out.println("- Final price: €" + String.format("%.2f", results1[1]));

		System.out.println("\nOption 2 (" + discount2 + "% discount):");
		System.out.println("- Discount amount: €" + String.format("%.2f", results2[0]));
		System.out.println("- Final price: €" + String.format("%.2f", results2[1]));

		double savingsDifference = Math.abs(results1[0] - results2[0]);
		if (results1[1] < results2[1]) {
			System.out.println("\n✓ Option 1 is better!");
			System.out.println("Additional savings: €" + String.format("%.2f", savingsDifference));
		} else if (results2[1] < results1[1]) {
			System.out.println("\n✓ Option 2 is better!");
			System.out.println("Additional savings: €" + String.format("%.2f", savingsDifference));
		} else {
			System.out.println("\n= Both options are equivalent!");
		}
	}

	private static double[] performBasicDiscount(double originalPrice, double discountPercentage) {
		double discountAmount = originalPrice * (discountPercentage / 100);
		double finalPrice = originalPrice - discountAmount;
		return new double[] { discountAmount, finalPrice };
	}

	private static void displayBasicResults(double originalPrice, double discountPercentage, double discountAmount,
			double finalPrice) {
		System.out.println("\n--- Discount Results ---");
		System.out.println("Original price: €" + String.format("%.2f", originalPrice));
		System.out.println("Discount (" + discountPercentage + "%): €" + String.format("%.2f", discountAmount));
		System.out.println("Final price: €" + String.format("%.2f", finalPrice));
		System.out.println("You save: €" + String.format("%.2f", discountAmount));
	}
}