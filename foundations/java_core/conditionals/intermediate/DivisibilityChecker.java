package java_core.conditionals.intermediate;

import java.util.Scanner;

public class DivisibilityChecker {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== VERIFICADOR DE DIVISIBILIDAD ===\n");

		System.out.println("1. Múltiplos de 3");
		System.out.println("2. Múltiplos de 5");
		System.out.println("3. Múltiplos de 3 Y 5");
		System.out.println("4. Múltiplos de un número personalizado");
		System.out.println("5. Análisis completo de divisibilidad");
		System.out.print("Seleccione una opción: ");

		int opcion = scanner.nextInt();

		switch (opcion) {
		case 1:
			multiplosDeTres();
			break;
		case 2:
			multiplosDeCinco();
			break;
		case 3:
			multiplosDeTresYCinco();
			break;
		case 4:
			multiplosPersonalizados(scanner);
			break;
		case 5:
			analisisCompleto(scanner);
			break;
		default:
			System.out.println("Opción no válida");
		}

		scanner.close();
	}

	public static void multiplosDeTres() {
		System.out.println("\nMúltiplos de 3 entre 1 y 99:");
		for (int i = 1; i < 100; i++) {
			if (i % 3 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	public static void multiplosDeCinco() {
		System.out.println("\nMúltiplos de 5 entre 1 y 100:");
		for (int i = 1; i <= 100; i++) {
			if (i % 5 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	public static void multiplosDeTresYCinco() {
		System.out.println("\nMúltiplos de 3 Y 5 (divisibles entre 15) entre 1 y 100:");
		int contador = 0;

		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.print(i + " ");
				contador++;
			}
		}
		System.out.println("\nTotal encontrados: " + contador);
	}

	public static void multiplosPersonalizados(Scanner scanner) {
		System.out.print("\nIngrese el divisor: ");
		int divisor = scanner.nextInt();

		System.out.print("Ingrese el límite superior: ");
		int limite = scanner.nextInt();

		System.out.println("\nNúmeros divisibles entre " + divisor + " hasta " + limite + ":");
		int contador = 0;

		for (int i = 1; i <= limite; i++) {
			if (i % divisor == 0) {
				System.out.print(i + " ");
				contador++;
				if (contador % 10 == 0) {
					System.out.println();
				}
			}
		}
		System.out.println("\nTotal: " + contador + " números");
	}

	public static void analisisCompleto(Scanner scanner) {
		System.out.print("\nIngrese un número para analizar: ");
		int numero = scanner.nextInt();

		System.out.println("\nAnálisis de divisibilidad para " + numero + ":");
		System.out.println("─".repeat(40));

		int[] divisores = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

		System.out.println("Numeros para analizar: ");
		for (int i = 0; i < divisores.length; i++) {
			System.out.print(divisores[i] + " ");
		}
		System.out.println();

		for (int divisor : divisores) {
			if (numero % divisor == 0) {
				System.out.println("✓ Es divisible entre " + divisor);
			} else {
				System.out.println("✗ NO es divisible entre " + divisor);
			}
		}

		System.out.println("\nPropiedades especiales:");
		if (numero % 2 == 0) {
			System.out.println("- Es un número PAR");
		} else {
			System.out.println("- Es un número IMPAR");
		}

		if (esPrimo(numero)) {
			System.out.println("- Es un número PRIMO");
		}
	}

	public static boolean esPrimo(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}