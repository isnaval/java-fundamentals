package fundamentals.loops;

import java.util.Scanner;

public class PatternPrinter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=== IMPRESORA DE PATRONES ===\n");
		System.out.println("1. Triángulo ascendente");
		System.out.println("2. Triángulo descendente");
		System.out.println("3. Pirámide");
		System.out.println("4. Diamante");
		System.out.println("5. Triángulo numérico");
		System.out.print("Seleccione un patrón: ");
		int opcion = scanner.nextInt();

		switch (opcion) {
		case 1:
			trianguloAscendente();
			break;
		case 2:
			trianguloDescendente();
			break;
		case 3:
			piramide();
			break;
		case 4:
			diamante();
			break;
		case 5:
			trianguloNumerico();
			break;
		default:
			System.out.println("Opción no válida");
		}

		scanner.close();

	}

	public static void trianguloAscendente() {
		System.out.println("\nTriángulo Ascendente: ");
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("x");
			}
			System.out.println();
		}

	}

	public static void trianguloDescendente() {
		System.out.println("\nTriángulo Descendente: ");
		for (int i = 5; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("x");
			}
			System.out.println();
		}

	}

	public static void piramide() {
		System.out.println("\nPirámide: ");
		for (int i = 0; i < 5; i++) {
			// para los espacios
			for (int j = 0; j < 5 - i - 1; j++) {
				System.out.print(" ");
			}
			// para los asteriscos
			for (int k = 0; k < 2 * i + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	public static void diamante() {
		System.out.println("\nDiamante:");
		// la parte superior
		for (int i = 1; i <= 5; i++) {
			for (int space = 0; space < (5 - i); space++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 2 * i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		// la parte inferior
		for (int i = 4; i >= 1; i--) {
			for (int space = 0; space < (5 - i); space++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 2 * i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void trianguloNumerico() {
		System.out.println("\nTriángulo Numérico:");
		for (int i = 1; i <= 5; i++) {
			for (int j = 0; j < (5 - i); j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print(k + " ");
			}
			System.out.println();

		}
	}

}
