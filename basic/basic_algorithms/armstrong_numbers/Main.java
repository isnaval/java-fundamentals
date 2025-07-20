package basic.basic_algorithms.armstrong_numbers;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== VERIFICADOR DE NÚMEROS ARMSTRONG ===");
		System.out.println("Un número Armstrong es igual a la suma de sus dígitos elevados");
		System.out.println("a la potencia del número total de dígitos.\n");

		while (true) {
			System.out.println("1. Verificar un número");
			System.out.println("2. Mostrar Armstrong en rango");
			System.out.println("3. Ejemplos conocidos");
			System.out.println("4. Salir");
			System.out.print("\nElige una opción: ");

			int option = getValidInput(scanner);

			switch (option) {
			case 1:
				checkNumber(scanner);
				break;
			case 2:
				showRange(scanner);
				break;
			case 3:
				showExamples();
				break;
			case 4:
				System.out.println("¡Hasta luego!");
				scanner.close();
				return;
			default:
				System.out.println("Opción no válida. Intenta de nuevo.\n");
			}
		}
	}

	private static void checkNumber(Scanner scanner) {
		System.out.print("Ingresa un número: ");
		int number = getValidInput(scanner);

		if (Armstrong.check(number)) {
			System.out.println(number + " ES un número de Armstrong\n");
		} else {
			System.out.println(number + " NO es un número de Armstrong\n");
		}
	}

	private static void showRange(Scanner scanner) {
		System.out.print("Número inicial: ");
		int start = getValidInput(scanner);
		System.out.print("Número final: ");
		int end = getValidInput(scanner);

		if (start > end) {
			System.out.println("Error: El número inicial debe ser menor al final\n");
			return;
		}

		Armstrong.showRange(start, end);
		System.out.println();
	}

	private static void showExamples() {
		System.out.println("Ejemplos de números Armstrong:");
		System.out.println("153 = 1³ + 5³ + 3³ = 1 + 125 + 27 = 153");
		System.out.println("371 = 3³ + 7³ + 1³ = 27 + 343 + 1 = 371");
		System.out.println("9474 = 9⁴ + 4⁴ + 7⁴ + 4⁴ = 6561 + 256 + 2401 + 256 = 9474");
		System.out.println();
	}

	private static int getValidInput(Scanner scanner) {
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.print("Ingresa un número válido: ");
			}
		}
	}
}