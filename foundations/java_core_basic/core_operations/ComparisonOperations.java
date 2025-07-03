package java_core_basic.core_operations;

import java.util.Arrays;
import java.util.Scanner;

public class ComparisonOperations {
	private static Scanner scanner = MainController.getScanner();

	public static void showComparisonMenu() {
		while (true) {
			System.out.println("\n" + "=".repeat(40));
			System.out.println("  ⚖️  COMPARACIONES Y VALIDACIONES");
			System.out.println("=".repeat(40));
			System.out.println("1. Comparar dos números (igualdad)");
			System.out.println("2. Verificar si es múltiplo");
			System.out.println("3. Encontrar mayor/menor de varios números");
			System.out.println("4. Ordenar números");
			System.out.println("5. Contar dígitos de un número");
			System.out.println("6. Invertir un número");
			System.out.println("7. Verificar si es capicúa/palíndromo");
			System.out.println("8. Clasificar número (positivo/negativo/par/impar)");
			System.out.println("0. Volver al menú principal");
			System.out.println("=".repeat(40));
			System.out.print("Selecciona una opción: ");

			int option = MainController.getValidOption(0, 8);

			switch (option) {
			case 1:
				compareNumbers();
				break;
			case 2:
				checkMultiple();
				break;
			case 3:
				findMaxMin();
				break;
			case 4:
				sortNumbers();
				break;
			case 5:
				countDigits();
				break;
			case 6:
				reverseNumber();
				break;
			case 7:
				checkPalindrome();
				break;
			case 8:
				classifyNumber();
				break;
			case 0:
				return;
			}
			MainController.pauseAndContinue();
		}
	}

	private static void compareNumbers() {
		System.out.println("\n--- COMPARACIÓN DE IGUALDAD ---");
		System.out.print("Ingresa el primer número: ");
		double num1 = scanner.nextDouble();
		System.out.print("Ingresa el segundo número: ");
		double num2 = scanner.nextDouble();

		if (num1 == num2) {
			System.out.printf("Los números %.2f y %.2f son IGUALES\n", num1, num2);
		} else {
			System.out.printf("Los números %.2f y %.2f son DIFERENTES\n", num1, num2);
			if (num1 > num2) {
				System.out.printf("%.2f es MAYOR que %.2f\n", num1, num2);
			} else {
				System.out.printf("%.2f es MENOR que %.2f\n", num1, num2);
			}
		}
	}

	private static void checkMultiple() {
		System.out.println("\n--- VERIFICAR MÚLTIPLO ---");
		System.out.print("Ingresa el primer número: ");
		int num1 = scanner.nextInt();
		System.out.print("Ingresa el segundo número (divisor): ");
		int num2 = scanner.nextInt();

		if (num2 == 0) {
			System.out.println("Error: No se puede dividir entre cero.");
			return;
		}

		if (num1 % num2 == 0) {
			System.out.printf("%d SÍ es múltiplo de %d\n", num1, num2);
			System.out.printf("%d ÷ %d = %d\n", num1, num2, num1 / num2);
		} else {
			System.out.printf("%d NO es múltiplo de %d\n", num1, num2);
			System.out.printf("Residuo de la división: %d\n", num1 % num2);
		}
	}

	private static void findMaxMin() {
		System.out.println("\n--- ENCONTRAR MAYOR Y MENOR ---");
		System.out.println("1. Comparar exactamente 2 números");
		System.out.println("2. Comparar exactamente 3 números");
		System.out.println("3. Comparar cantidad variable de números");
		System.out.print("Selecciona una opción: ");

		int option = MainController.getValidOption(1, 3);

		switch (option) {
		case 1:
			System.out.print("Primer número: ");
			double a = scanner.nextDouble();
			System.out.print("Segundo número: ");
			double b = scanner.nextDouble();

			System.out.printf("Mayor: %.2f\n", Math.max(a, b));
			System.out.printf("Menor: %.2f\n", Math.min(a, b));
			break;

		case 2:
			System.out.print("Primer número: ");
			a = scanner.nextDouble();
			System.out.print("Segundo número: ");
			b = scanner.nextDouble();
			System.out.print("Tercer número: ");
			double c = scanner.nextDouble();

			double max3 = Math.max(Math.max(a, b), c);
			double min3 = Math.min(Math.min(a, b), c);

			System.out.printf("Mayor de los tres: %.2f\n", max3);
			System.out.printf("Menor de los tres: %.2f\n", min3);
			break;

		case 3:
			System.out.print("¿Cuántos números quieres comparar? ");
			int count = scanner.nextInt();

			if (count <= 0) {
				System.out.println("Debe ser un número positivo.");
				return;
			}

			double[] numbers = new double[count];
			for (int i = 0; i < count; i++) {
				System.out.print("Número " + (i + 1) + ": ");
				numbers[i] = scanner.nextDouble();
			}

			double max = Arrays.stream(numbers).max().orElse(0);
			double min = Arrays.stream(numbers).min().orElse(0);

			System.out.printf("Mayor de todos: %.2f\n", max);
			System.out.printf("Menor de todos: %.2f\n", min);
			break;
		}
	}

	private static void sortNumbers() {
		System.out.println("\n--- ORDENAR NÚMEROS ---");
		System.out.println("1. Ordenar 2 números");
		System.out.println("2. Ordenar 3 números");
		System.out.println("3. Ordenar cantidad variable");
		System.out.print("Selecciona una opción: ");

		int option = MainController.getValidOption(1, 3);

		switch (option) {
		case 1:
			System.out.print("Primer número: ");
			double a = scanner.nextDouble();
			System.out.print("Segundo número: ");
			double b = scanner.nextDouble();

			if (a <= b) {
				System.out.printf("Orden: %.2f, %.2f\n", a, b);
			} else {
				System.out.printf("Orden: %.2f, %.2f\n", b, a);
			}
			break;

		case 2:
			System.out.print("Primer número: ");
			a = scanner.nextDouble();
			System.out.print("Segundo número: ");
			b = scanner.nextDouble();
			System.out.print("Tercer número: ");
			double c = scanner.nextDouble();

			double[] three = { a, b, c };
			Arrays.sort(three);
			System.out.printf("Orden: %.2f, %.2f, %.2f\n", three[0], three[1], three[2]);
			break;

		case 3:
			System.out.print("¿Cuántos números quieres ordenar? ");
			int count = scanner.nextInt();

			double[] numbers = new double[count];
			for (int i = 0; i < count; i++) {
				System.out.print("Número " + (i + 1) + ": ");
				numbers[i] = scanner.nextDouble();
			}

			Arrays.sort(numbers);
			System.out.print("Números ordenados: ");
			for (int i = 0; i < numbers.length; i++) {
				System.out.printf("%.2f", numbers[i]);
				if (i < numbers.length - 1)
					System.out.print(", ");
			}
			System.out.println();
			break;
		}
	}

	private static void countDigits() {
		System.out.println("\n--- CONTAR DÍGITOS ---");
		System.out.print("Ingresa un número entero: ");
		int number = scanner.nextInt();

		int originalNumber = number;
		number = Math.abs(number);

		if (number == 0) {
			System.out.println("El número 0 tiene 1 dígito.");
			return;
		}

		int count = 0;
		int temp = number;

		while (temp > 0) {
			temp /= 10;
			count++;
		}

		int countString = String.valueOf(number).length();

		System.out.printf("El número %d tiene %d dígitos.\n", originalNumber, count);
		System.out.printf("Verificación (método string): %d dígitos.\n", countString);
	}

	private static void reverseNumber() {
		System.out.println("\n--- INVERTIR NÚMERO ---");
		System.out.print("Ingresa un número entero: ");
		int number = scanner.nextInt();

		int originalNumber = number;
		boolean isNegative = number < 0;
		number = Math.abs(number);

		int reversed = 0;
		int temp = number;

		while (temp > 0) {
			reversed = reversed * 10 + temp % 10;
			temp /= 10;
		}

		if (isNegative)
			reversed = -reversed;

		System.out.printf("Número original: %d\n", originalNumber);
		System.out.printf("Número invertido: %d\n", reversed);
	}

	private static void checkPalindrome() {
		System.out.println("\n--- VERIFICAR CAPICÚA/PALÍNDROMO ---");
		System.out.print("Ingresa un número entero: ");
		int number = scanner.nextInt();

		int originalNumber = number;
		number = Math.abs(number);

		int reversed = 0;
		int temp = number;

		while (temp > 0) {
			reversed = reversed * 10 + temp % 10;
			temp /= 10;
		}

		String numberStr = String.valueOf(number);
		String reversedStr = new StringBuilder(numberStr).reverse().toString();
		boolean isPalindromeString = numberStr.equals(reversedStr);

		boolean isPalindrome = (number == reversed);

		System.out.printf("Número original: %d\n", originalNumber);
		System.out.printf("Número invertido: %d\n", reversed);

		if (isPalindrome) {
			System.out.printf("✅ El número %d SÍ es capicúa/palíndromo\n", Math.abs(originalNumber));
		} else {
			System.out.printf("❌ El número %d NO es capicúa/palíndromo\n", Math.abs(originalNumber));
		}

		System.out.printf("Verificación (método string): %s\n",
				isPalindromeString ? "SÍ es palíndromo" : "NO es palíndromo");
	}

	private static void classifyNumber() {
		System.out.println("\n--- CLASIFICAR NÚMERO ---");
		System.out.print("Ingresa un número: ");
		double number = scanner.nextDouble();

		System.out.printf("\n--- CLASIFICACIÓN DEL NÚMERO %.2f ---\n", number);

		if (number > 0) {
			System.out.println("✅ Es POSITIVO");
		} else if (number < 0) {
			System.out.println("❌ Es NEGATIVO");
		} else {
			System.out.println("⚪ Es CERO (neutro)");
		}

		if (number == (int) number) {
			int intNumber = (int) number;
			if (intNumber % 2 == 0) {
				System.out.println("🔢 Es PAR");
			} else {
				System.out.println("🔢 Es IMPAR");
			}
		} else {
			System.out.println("🔢 Es DECIMAL (no aplica par/impar)");
		}

		double absNumber = Math.abs(number);
		if (absNumber >= 1000) {
			System.out.println("📏 Es un número GRANDE (≥1000)");
		} else if (absNumber >= 100) {
			System.out.println("📏 Es un número MEDIANO (100-999)");
		} else if (absNumber >= 10) {
			System.out.println("📏 Es un número PEQUEÑO (10-99)");
		} else if (absNumber > 0) {
			System.out.println("📏 Es un número MUY PEQUEÑO (0-9)");
		}

		System.out.printf("📊 Valor absoluto: %.2f\n", absNumber);
		System.out.printf("📊 Cuadrado: %.2f\n", number * number);
		System.out.printf("📊 Raíz cuadrada: %.2f\n", Math.sqrt(absNumber));
	}
}