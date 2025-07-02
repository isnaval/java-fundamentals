package java_core_basic.core_operations;

import java.util.Scanner;

public class SequenceOperations {
	private static Scanner scanner = MainController.getScanner();

	public static void showSequenceMenu() {
		while (true) {
			System.out.println("\n" + "=".repeat(40));
			System.out.println("    🔢 SECUENCIAS Y PATRONES");
			System.out.println("=".repeat(40));
			System.out.println("1. Secuencia de 1 a N");
			System.out.println("2. Secuencia de N a 1");
			System.out.println("3. Secuencias predefinidas (100-0, 1000-0, etc.)");
			System.out.println("4. Secuencias filtradas (pares/impares)");
			System.out.println("5. Patrones personalizados");
			System.out.println("6. Serie de Fibonacci");
			System.out.println("7. Secuencias con saltos");
			System.out.println("0. Volver al menú principal");
			System.out.println("=".repeat(40));
			System.out.print("Selecciona una opción: ");

			int option = MainController.getValidOption(0, 7);

			switch (option) {
			case 1:
				sequenceOneToN();
				break;
			case 2:
				sequenceNToOne();
				break;
			case 3:
				predefinedSequences();
				break;
			case 4:
				filteredSequences();
				break;
			case 5:
				customPatterns();
				break;
			case 6:
				fibonacciSequence();
				break;
			case 7:
				jumpSequences();
				break;
			case 0:
				return;
			}
			MainController.pauseAndContinue();
		}
	}

	private static void sequenceOneToN() {
		System.out.println("\n--- SECUENCIA DE 1 A N ---");
		System.out.print("Ingresa el valor de N: ");
		int n = scanner.nextInt();

		if (n <= 0) {
			System.out.println("N debe ser un número positivo.");
			return;
		}

		System.out.println("\n--- MÉTODOS DISPONIBLES ---");
		System.out.println("1. Iterativo");
		System.out.println("2. Recursivo");
		System.out.print("Selecciona el método: ");
		int method = MainController.getValidOption(1, 2);

		System.out.printf("\nSecuencia de 1 a %d:\n", n);

		if (method == 1) {
			for (int i = 1; i <= n; i++) {
				System.out.print(i);
				if (i < n)
					System.out.print(", ");
			}
		} else {
			printOneToNRecursive(1, n);
		}
		System.out.println();
	}

	private static void printOneToNRecursive(int current, int n) {
		if (current <= n) {
			System.out.print(current);
			if (current < n)
				System.out.print(", ");
			printOneToNRecursive(current + 1, n);
		}
	}

	private static void sequenceNToOne() {
		System.out.println("\n--- SECUENCIA DE N A 1 ---");
		System.out.print("Ingresa el valor de N: ");
		int n = scanner.nextInt();

		if (n <= 0) {
			System.out.println("N debe ser un número positivo.");
			return;
		}

		System.out.println("\n--- MÉTODOS DISPONIBLES ---");
		System.out.println("1. Iterativo");
		System.out.println("2. Recursivo");
		System.out.print("Selecciona el método: ");
		int method = MainController.getValidOption(1, 2);

		System.out.printf("\nSecuencia de %d a 1:\n", n);

		if (method == 1) {
			for (int i = n; i >= 1; i--) {
				System.out.print(i);
				if (i > 1)
					System.out.print(", ");
			}
		} else {
			printNToOneRecursive(n);
		}
		System.out.println();
	}

	private static void printNToOneRecursive(int n) {
		if (n >= 1) {
			System.out.print(n);
			if (n > 1)
				System.out.print(", ");
			printNToOneRecursive(n - 1);
		}
	}

	private static void predefinedSequences() {
		System.out.println("\n--- SECUENCIAS PREDEFINIDAS ---");
		System.out.println("1. 100 a 0 (descendente)");
		System.out.println("2. 1000 a 0 (descendente)");
		System.out.println("3. 0 a 100 (ascendente)");
		System.out.println("4. 0 a 1000 (ascendente)");
		System.out.println("5. Múltiplos de 5 hasta 100");
		System.out.println("6. Múltiplos de 10 hasta 1000");
		System.out.print("Selecciona una secuencia: ");

		int option = MainController.getValidOption(1, 6);

		System.out.println("\nSecuencia generada:");

		switch (option) {
		case 1:
			for (int i = 100; i >= 0; i--) {
				System.out.print(i);
				if (i > 0)
					System.out.print(", ");
				if ((100 - i + 1) % 20 == 0)
					System.out.println();
			}
			break;

		case 2:
			for (int i = 1000; i >= 0; i--) {
				System.out.print(i);
				if (i > 0)
					System.out.print(", ");
				if ((1000 - i + 1) % 25 == 0)
					System.out.println();
			}
			break;

		case 3:
			for (int i = 0; i <= 100; i++) {
				System.out.print(i);
				if (i < 100)
					System.out.print(", ");
				if ((i + 1) % 20 == 0)
					System.out.println();
			}
			break;

		case 4:
			for (int i = 0; i <= 1000; i++) {
				System.out.print(i);
				if (i < 1000)
					System.out.print(", ");
				if ((i + 1) % 25 == 0)
					System.out.println();
			}
			break;

		case 5:
			for (int i = 5; i <= 100; i += 5) {
				System.out.print(i);
				if (i < 100)
					System.out.print(", ");
				if (i % 50 == 0)
					System.out.println();
			}
			break;

		case 6:
			for (int i = 10; i <= 1000; i += 10) {
				System.out.print(i);
				if (i < 1000)
					System.out.print(", ");
				if (i % 200 == 0)
					System.out.println();
			}
			break;
		}
		System.out.println();
	}

	private static void filteredSequences() {
		System.out.println("\n--- SECUENCIAS FILTRADAS ---");
		System.out.print("Ingresa el número inicial: ");
		int start = scanner.nextInt();
		System.out.print("Ingresa el número final: ");
		int end = scanner.nextInt();

		if (start > end) {
			System.out.println("El número inicial debe ser menor o igual al final.");
			return;
		}

		System.out.println("\n--- TIPO DE FILTRO ---");
		System.out.println("1. Solo números pares");
		System.out.println("2. Solo números impares");
		System.out.println("3. Ambos (pares e impares separados)");
		System.out.print("Selecciona el filtro: ");

		int filter = MainController.getValidOption(1, 3);

		switch (filter) {
		case 1:
			System.out.printf("\nNúmeros PARES entre %d y %d:\n", start, end);
			printFilteredNumbers(start, end, true, false);
			break;

		case 2:
			System.out.printf("\nNúmeros IMPARES entre %d y %d:\n", start, end);
			printFilteredNumbers(start, end, false, true);
			break;

		case 3:
			System.out.printf("\nNúmeros PARES entre %d y %d:\n", start, end);
			printFilteredNumbers(start, end, true, false);
			System.out.printf("\nNúmeros IMPARES entre %d y %d:\n", start, end);
			printFilteredNumbers(start, end, false, true);
			break;
		}
	}

	private static void printFilteredNumbers(int start, int end, boolean showEven, boolean showOdd) {
		int count = 0;
		for (int i = start; i <= end; i++) {
			boolean isEven = (i % 2 == 0);
			if ((isEven && showEven) || (!isEven && showOdd)) {
				System.out.print(i);
				count++;
				if (i < end) {
					boolean hasNext = false;
					for (int j = i + 1; j <= end; j++) {
						boolean nextIsEven = (j % 2 == 0);
						if ((nextIsEven && showEven) || (!nextIsEven && showOdd)) {
							hasNext = true;
							break;
						}
					}
					if (hasNext)
						System.out.print(", ");
				}
				if (count % 15 == 0)
					System.out.println();
			}
		}
		System.out.printf("\nTotal de números mostrados: %d\n", count);
	}

	private static void customPatterns() {
		System.out.println("\n--- PATRONES PERSONALIZADOS ---");
		System.out.println("1. Patrón aritmético (suma constante)");
		System.out.println("2. Patrón geométrico (multiplicación constante)");
		System.out.println("3. Patrón de cuadrados (1², 2², 3²...)");
		System.out.println("4. Patrón de cubos (1³, 2³, 3³...)");
		System.out.print("Selecciona un patrón: ");

		int pattern = MainController.getValidOption(1, 4);

		System.out.print("¿Cuántos términos quieres generar? ");
		int terms = scanner.nextInt();

		if (terms <= 0) {
			System.out.println("El número de términos debe ser positivo.");
			return;
		}

		System.out.println("\nPatrón generado:");

		switch (pattern) {
		case 1:
			System.out.print("Ingresa el primer término: ");
			int first = scanner.nextInt();
			System.out.print("Ingresa la diferencia común: ");
			int diff = scanner.nextInt();

			for (int i = 0; i < terms; i++) {
				int term = first + (i * diff);
				System.out.print(term);
				if (i < terms - 1)
					System.out.print(", ");
				if ((i + 1) % 10 == 0)
					System.out.println(); // Salto cada 10
			}
			break;

		case 2:
			System.out.print("Ingresa el primer término: ");
			int firstGeo = scanner.nextInt();
			System.out.print("Ingresa la razón común: ");
			int ratio = scanner.nextInt();

			long term = firstGeo;
			for (int i = 0; i < terms; i++) {
				System.out.print(term);
				if (i < terms - 1)
					System.out.print(", ");
				if ((i + 1) % 8 == 0)
					System.out.println(); // Salto cada 8
				term *= ratio;
			}
			break;

		case 3:
			for (int i = 1; i <= terms; i++) {
				int square = i * i;
				System.out.print(square);
				if (i < terms)
					System.out.print(", ");
				if (i % 10 == 0)
					System.out.println();
			}
			break;

		case 4:
			for (int i = 1; i <= terms; i++) {
				int cube = i * i * i;
				System.out.print(cube);
				if (i < terms)
					System.out.print(", ");
				if (i % 8 == 0)
					System.out.println();
			}
			break;
		}
		System.out.println();
	}

	private static void fibonacciSequence() {
		System.out.println("\n--- SERIE DE FIBONACCI ---");
		System.out.print("¿Cuántos números de Fibonacci quieres generar? ");
		int count = scanner.nextInt();

		if (count <= 0) {
			System.out.println("El número debe ser positivo.");
			return;
		}

		System.out.println("\n--- MÉTODOS DISPONIBLES ---");
		System.out.println("1. Iterativo (más eficiente)");
		System.out.println("2. Recursivo (más lento para números grandes)");
		System.out.print("Selecciona el método: ");
		int method = MainController.getValidOption(1, 2);

		System.out.printf("\nPrimeros %d números de Fibonacci:\n", count);

		if (method == 1) {
			fibonacciIterative(count);
		} else {
			for (int i = 0; i < count; i++) {
				System.out.print(fibonacciRecursive(i));
				if (i < count - 1)
					System.out.print(", ");
				if ((i + 1) % 10 == 0)
					System.out.println(); // Salto cada 10
			}
		}
		System.out.println();
	}

	private static void fibonacciIterative(int count) {
		if (count >= 1) {
			System.out.print("0");
			if (count > 1)
				System.out.print(", ");
		}
		if (count >= 2) {
			System.out.print("1");
			if (count > 2)
				System.out.print(", ");
		}

		if (count > 2) {
			long prev1 = 0, prev2 = 1;
			for (int i = 2; i < count; i++) {
				long current = prev1 + prev2;
				System.out.print(current);
				if (i < count - 1)
					System.out.print(", ");
				if ((i + 1) % 10 == 0)
					System.out.println(); // Salto cada 10

				prev1 = prev2;
				prev2 = current;
			}
		}
	}

	private static long fibonacciRecursive(int n) {
		if (n <= 1)
			return n;
		return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	}

	private static void jumpSequences() {
		System.out.println("\n--- SECUENCIAS CON SALTOS ---");
		System.out.print("Número inicial: ");
		int start = scanner.nextInt();
		System.out.print("Número final: ");
		int end = scanner.nextInt();
		System.out.print("Tamaño del salto: ");
		int jump = scanner.nextInt();

		if (jump == 0) {
			System.out.println("El salto no puede ser cero.");
			return;
		}

		if ((start < end && jump < 0) || (start > end && jump > 0)) {
			System.out.println("El signo del salto no es compatible con el rango.");
			return;
		}

		System.out.printf("\nSecuencia de %d a %d con saltos de %d:\n", start, end, jump);

		int count = 0;
		if (jump > 0) {
			for (int i = start; i <= end; i += jump) {
				System.out.print(i);
				count++;
				if (i + jump <= end)
					System.out.print(", ");
				if (count % 15 == 0)
					System.out.println();
			}
		} else {
			for (int i = start; i >= end; i += jump) {
				System.out.print(i);
				count++;
				if (i + jump >= end)
					System.out.print(", ");
				if (count % 15 == 0)
					System.out.println();
			}
		}

		System.out.printf("\nTotal de números en la secuencia: %d\n", count);
	}
}