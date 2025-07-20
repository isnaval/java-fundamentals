package basic.core_operations;

import java.util.Scanner;

public class MathOperations {
	private static Scanner scanner = MainController.getScanner();

	public static void showMathMenu() {
		while (true) {
			System.out.println("\n" + "=".repeat(40));
			System.out.println("    🧮 OPERACIONES MATEMÁTICAS");
			System.out.println("=".repeat(40));
			System.out.println("1. Calcular área de figuras");
			System.out.println("2. Calcular cuadrado de un número");
			System.out.println("3. Suma de números (diferentes tipos)");
			System.out.println("4. Calcular promedio/media");
			System.out.println("5. Calcular producto (pares/impares)");
			System.out.println("6. Calcular factorial");
			System.out.println("7. Análisis completo de números");
			System.out.println("8. Contar números positivos");
			System.out.println("0. Volver al menú principal");
			System.out.println("=".repeat(40));
			System.out.print("Selecciona una opción: ");

			int option = MainController.getValidOption(0, 8);

			switch (option) {
			case 1:
				calculateArea();
				break;
			case 2:
				calculateSquare();
				break;
			case 3:
				calculateSum();
				break;
			case 4:
				calculateAverage();
				break;
			case 5:
				calculateProduct();
				break;
			case 6:
				calculateFactorial();
				break;
			case 7:
				analyzeNumbers();
				break;
			case 8:
				countPositiveNumbers();
				break;
			case 0:
				return;
			}
			MainController.pauseAndContinue();
		}
	}

	private static void calculateArea() {
		System.out.println("\n--- CÁLCULO DE ÁREAS ---");
		System.out.println("1. Círculo");
		System.out.println("2. Rectángulo");
		System.out.println("3. Triángulo");
		System.out.print("Selecciona la figura: ");

		int figure = MainController.getValidOption(1, 3);
		double area = 0;

		switch (figure) {
		case 1:
			System.out.print("Ingresa el radio del círculo: ");
			double radius = scanner.nextDouble();
			area = Math.PI * Math.pow(radius, 2);
			System.out.printf("El área del círculo es: %.2f\n", area);
			break;

		case 2:
			System.out.print("Ingresa la base: ");
			double base = scanner.nextDouble();
			System.out.print("Ingresa la altura: ");
			double height = scanner.nextDouble();
			area = base * height;
			System.out.printf("El área del rectángulo es: %.2f\n", area);
			break;

		case 3:
			System.out.print("Ingresa la base: ");
			base = scanner.nextDouble();
			System.out.print("Ingresa la altura: ");
			height = scanner.nextDouble();
			area = (base * height) / 2;
			System.out.printf("El área del triángulo es: %.2f\n", area);
			break;
		}
	}

	private static void calculateSquare() {
		System.out.println("\n--- CUADRADO DE UN NÚMERO ---");
		System.out.print("Ingresa un número: ");
		double number = scanner.nextDouble();
		double square = Math.pow(number, 2);
		System.out.printf("El cuadrado de %.2f es: %.2f\n", number, square);
	}

	private static void calculateSum() {
		System.out.println("\n--- SUMA DE NÚMEROS ---");
		System.out.println("1. Suma números hasta encontrar 0");
		System.out.println("2. Suma de exactamente 15 números");
		System.out.println("3. Suma solo números positivos (hasta 0)");
		System.out.print("Selecciona el tipo de suma: ");

		int type = MainController.getValidOption(1, 3);
		double sum = 0;
		int count = 0;

		switch (type) {
		case 1:
			System.out.println("Ingresa números (0 para terminar):");
			double number;
			do {
				System.out.print("Número " + (count + 1) + ": ");
				number = scanner.nextDouble();
				if (number != 0) {
					sum += number;
					count++;
				}
			} while (number != 0);
			System.out.printf("Suma total: %.2f (se sumaron %d números)\n", sum, count);
			break;

		case 2:
			System.out.println("Ingresa exactamente 15 números:");
			for (int i = 1; i <= 15; i++) {
				System.out.print("Número " + i + ": ");
				sum += scanner.nextDouble();
			}
			System.out.printf("Suma de los 15 números: %.2f\n", sum);
			break;

		case 3:
			System.out.println("Ingresa números (0 para terminar, solo se suman los positivos):");
			do {
				System.out.print("Número " + (count + 1) + ": ");
				number = scanner.nextDouble();
				if (number > 0) {
					sum += number;
					count++;
				}
			} while (number != 0);
			System.out.printf("Suma de números positivos: %.2f (se sumaron %d números positivos)\n", sum, count);
			break;
		}
	}

	private static void calculateAverage() {
		System.out.println("\n--- CÁLCULO DE PROMEDIOS ---");
		System.out.println("1. Promedio de números hasta 0");
		System.out.println("2. Promedio de positivos y negativos por separado");
		System.out.print("Selecciona el tipo: ");

		int type = MainController.getValidOption(1, 2);

		switch (type) {
		case 1:
			double sum = 0;
			int count = 0;
			double number;
			System.out.println("Ingresa números (0 para terminar):");
			do {
				System.out.print("Número " + (count + 1) + ": ");
				number = scanner.nextDouble();
				if (number != 0) {
					sum += number;
					count++;
				}
			} while (number != 0);

			if (count > 0) {
				System.out.printf("Promedio: %.2f\n", sum / count);
			} else {
				System.out.println("No se ingresaron números para promediar.");
			}
			break;

		case 2:
			double sumPos = 0, sumNeg = 0;
			int countPos = 0, countNeg = 0, countZero = 0;

			System.out.println("Ingresa números (0 para terminar el análisis):");
			do {
				System.out.print("Número: ");
				number = scanner.nextDouble();
				if (number > 0) {
					sumPos += number;
					countPos++;
				} else if (number < 0) {
					sumNeg += number;
					countNeg++;
				} else if (number == 0) {
					countZero++;
				}
			} while (number != 0 || countPos + countNeg == 0);

			System.out.println("\n--- RESULTADOS ---");
			if (countPos > 0) {
				System.out.printf("Promedio de positivos: %.2f (%d números)\n", sumPos / countPos, countPos);
			}
			if (countNeg > 0) {
				System.out.printf("Promedio de negativos: %.2f (%d números)\n", sumNeg / countNeg, countNeg);
			}
			System.out.printf("Cantidad de ceros: %d\n", countZero);
			break;
		}
	}

	private static void calculateProduct() {
		System.out.println("\n--- PRODUCTO DE NÚMEROS ---");
		System.out.println("1. Producto de números pares");
		System.out.println("2. Producto de números impares");
		System.out.print("Selecciona el tipo: ");

		int type = MainController.getValidOption(1, 2);
		boolean isEven = (type == 1);

		double product = 1;
		int count = 0;
		double number;

		System.out.println("Ingresa números (0 para terminar):");
		do {
			System.out.print("Número: ");
			number = scanner.nextDouble();
			if (number != 0) {
				if ((isEven && number % 2 == 0) || (!isEven && number % 2 != 0)) {
					product *= number;
					count++;
				}
			}
		} while (number != 0);

		if (count > 0) {
			System.out.printf("Producto de números %s: %.2f (%d números)\n", isEven ? "pares" : "impares", product,
					count);
		} else {
			System.out.printf("No se encontraron números %s.\n", isEven ? "pares" : "impares");
		}
	}

	private static void calculateFactorial() {
		System.out.println("\n--- CÁLCULO DE FACTORIAL ---");
		System.out.print("Ingresa un número entero positivo: ");
		int number = scanner.nextInt();

		if (number < 0) {
			System.out.println("El factorial no está definido para números negativos.");
			return;
		}

		System.out.println("1. Método iterativo");
		System.out.println("2. Método recursivo");
		System.out.print("Selecciona el método: ");
		int method = MainController.getValidOption(1, 2);

		long result = (method == 1) ? factorialIterative(number) : factorialRecursive(number);
		System.out.printf("El factorial de %d es: %d\n", number, result);
	}

	private static long factorialIterative(int n) {
		long result = 1;
		for (int i = 2; i <= n; i++) {
			result *= i;
		}
		return result;
	}

	private static long factorialRecursive(int n) {
		if (n <= 1)
			return 1;
		return n * factorialRecursive(n - 1);
	}

	private static void analyzeNumbers() {
		System.out.println("\n--- ANÁLISIS COMPLETO DE NÚMEROS ---");
		System.out.println("Ingresa números (0 para terminar el análisis):");

		double sum = 0, sumPos = 0, sumNeg = 0;
		int count = 0, countPos = 0, countNeg = 0, countZero = 0;
		double max = Double.MIN_VALUE, min = Double.MAX_VALUE;
		double number;

		do {
			System.out.print("Número: ");
			number = scanner.nextDouble();
			if (number != 0) {
				sum += number;
				count++;

				if (number > max)
					max = number;
				if (number < min)
					min = number;

				if (number > 0) {
					sumPos += number;
					countPos++;
				} else {
					sumNeg += number;
					countNeg++;
				}
			} else {
				countZero++;
			}
		} while (number != 0 || count == 0);

		System.out.println("\n" + "=".repeat(40));
		System.out.println("         ANÁLISIS COMPLETO");
		System.out.println("=".repeat(40));
		System.out.printf("Total de números analizados: %d\n", count);
		System.out.printf("Suma total: %.2f\n", sum);
		System.out.printf("Promedio general: %.2f\n", sum / count);
		System.out.printf("Número mayor: %.2f\n", max);
		System.out.printf("Número menor: %.2f\n", min);
		System.out.printf("Números positivos: %d (suma: %.2f, promedio: %.2f)\n", countPos, sumPos,
				countPos > 0 ? sumPos / countPos : 0);
		System.out.printf("Números negativos: %d (suma: %.2f, promedio: %.2f)\n", countNeg, sumNeg,
				countNeg > 0 ? sumNeg / countNeg : 0);
		System.out.printf("Cantidad de ceros: %d\n", countZero);
	}

	private static void countPositiveNumbers() {
		System.out.println("\n--- CONTADOR DE NÚMEROS POSITIVOS ---");
		System.out.println("Ingresa números (se detendrá al encontrar un número no positivo):");

		int count = 0;
		double number;

		do {
			System.out.print("Número " + (count + 1) + ": ");
			number = scanner.nextDouble();
			if (number > 0) {
				count++;
			}
		} while (number > 0);

		System.out.printf("Se ingresaron %d números positivos antes del número no positivo (%.2f)\n", count, number);
	}
}