package fundamentals.arrays;

public class ArrayAverageCalculator {

	private static final int ELEMENTS_COUNT = 5;
	private static final double[] NUMBERS = { 10.5, 7.2, 8.0, 5.5, 9.3 };

	public static void main(String[] args) {
		ArrayAverageCalculator calculator = new ArrayAverageCalculator();
		calculator.processArray();

	}

	private void processArray() {
		showWelcomeMessage();
		showArrayContents();

		double average = calculateAverage();
		showAverageResult(average);

		showElementsAboveAverage(average);
		showAdditionalStatistics();

	}

	private void showAdditionalStatistics() {
		double min = findMinimum();
		double max = findMaximum();
		int aboveAverageCount = countElementsAboveAverage();

		System.out.println("📊 Estadísticas adicionales:");
		System.out.printf("   🔽 Valor mínimo: %.1f%n", min);
		System.out.printf("   🔼 Valor máximo: %.1f%n", max);
		System.out.printf("   ⭐ Elementos sobre promedio: %d de %d%n", aboveAverageCount, ELEMENTS_COUNT);
		System.out.printf("   📊 Porcentaje sobre promedio: %.1f%%%n", (aboveAverageCount * 100.0) / ELEMENTS_COUNT);
		System.out.println("================================================================");
	}

	private double findMinimum() {
		double min = NUMBERS[0];
		for (int i = 1; i < ELEMENTS_COUNT; i++) {
			if (NUMBERS[i] < min) {
				min = NUMBERS[i];
			}
		}
		return min;
	}

	private double findMaximum() {
		double max = NUMBERS[0];
		for (int i = 1; i < ELEMENTS_COUNT; i++) {
			if (NUMBERS[i] > max) {
				max = NUMBERS[i];
			}
		}
		return max;
	}

	private int countElementsAboveAverage() {
		double average = calculateAverage();
		int count = 0;

		for (int i = 0; i < ELEMENTS_COUNT; i++) {
			if (NUMBERS[i] > average) {
				count++;
			}
		}

		return count;
	}

	private void showWelcomeMessage() {
		System.out.println("================================================================");
		System.out.println("           📊 Calculadora de Promedio de Array");
		System.out.println("================================================================");
	}

	private void showArrayContents() {
		System.out.print("🔢 Array original: [");
		for (int i = 0; i < ELEMENTS_COUNT; i++) {
			System.out.print(NUMBERS[i]);
			if (i < ELEMENTS_COUNT - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
		System.out.println("================================================================");
	}

	private void showElementsAboveAverage(double average) {
		System.out.println("⭐ Elementos que superan el promedio:");

		boolean foundElements = false;
		for (int i = 0; i < ELEMENTS_COUNT; i++) {
			if (NUMBERS[i] > average) {
				System.out.printf("   🔸 %.1f (posición %d)%n", NUMBERS[i], i + 1);
				foundElements = true;
			}
		}

		if (!foundElements) {
			System.out.println("   ℹ️  No hay elementos que superen el promedio.");
		}

		System.out.println("================================================================");
	}

	private double calculateAverage() {
		double sum = 0.0;

		for (int i = 0; i < ELEMENTS_COUNT; i++) {
			sum += NUMBERS[i];
		}

		return sum / ELEMENTS_COUNT;
	}

	private void showAverageResult(double average) {
		System.out.printf("📈 Promedio calculado: %.2f%n", average);
		System.out.println("================================================================");
	}
}
