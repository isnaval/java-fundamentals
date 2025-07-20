package fundamentals.conditionals.intermediate;

import java.util.Scanner;

public class OddEvenClassifier {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=== CLASIFICADOR PAR/IMPAR ===\n");
		System.out.println("1. Clasificar números del 1 al 100");
		System.out.println("2. Verificar un número específico");
		System.out.println("3. Clasificar un rango personalizado");
		System.out.println("4. Estadísticas de pares e impares");
		System.out.print("Seleccione una opción: ");
		int opcion = scanner.nextInt();
		switch (opcion) {
		case 1:
			clasificarCienPrimeros();
			break;
		case 2:
			verificarNumero(scanner);
			break;
		case 3:
			clasificarRango(scanner);
			break;
		case 4:
			estadisticasParesImpares(scanner);
			break;
		default:
			System.out.println("Opción no válida");
		}
		scanner.close();

	}

	public static void clasificarCienPrimeros() {
		System.out.println("\nClasificación del 1 al 100:\n");

		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				System.out.println("El número " + i + " es PAR");
			} else {
				System.out.println("El número " + i + " es IMPAR");
			}
		}
	}

	public static void verificarNumero(Scanner scanner) {
		System.out.print("\nIngrese un número: ");
		int numero = scanner.nextInt();

		if (numero % 2 == 0) {
			System.out.println("\n" + numero + " es un número PAR");
			System.out.println("Mitad: " + (numero / 2));
			System.out.println("Siguiente par: " + (numero + 2));
			System.out.println("Anterior par: " + (numero - 2));
		} else {
			System.out.println("\n" + numero + " es un número IMPAR");
			System.out.println("Siguiente impar: " + (numero + 2));
			System.out.println("Anterior impar: " + (numero - 2));
			System.out.println("Par más cercano: " + (numero + 1));
		}
	}

	public static void clasificarRango(Scanner scanner) {
		System.out.print("\nIngrese el número inicial: ");
		int inicio = scanner.nextInt();
		System.out.print("Ingrese el número final: ");
		int fin = scanner.nextInt();

		System.out.println("\nPARES:");
		for (int i = inicio; i <= fin; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}

		System.out.println("\n\nIMPARES:");
		for (int i = inicio; i <= fin; i++) {
			if (i % 2 != 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	public static void estadisticasParesImpares(Scanner scanner) {
		System.out.print("\nIngrese la cantidad de números a analizar: ");
		int cantidad = scanner.nextInt();

		int pares = 0;
		int impares = 0;
		int sumaPares = 0;
		int sumaImpares = 0;

		for (int i = 1; i <= cantidad; i++) {
			System.out.print("Número " + i + ": ");
			int numero = scanner.nextInt();

			if (numero % 2 == 0) {
				pares++;
				sumaPares += numero;
			} else {
				impares++;
				sumaImpares += numero;
			}
		}
		System.out.println("\n=== ESTADÍSTICAS ===");
		System.out.println("Total de números: " + cantidad);
		System.out.println("Pares: " + pares);
		System.out.println("Impares: " + impares);
		System.out.println("Suma de pares: " + sumaPares);
		System.out.println("Suma de impares: " + sumaImpares);

		if (pares > 0) {
			System.out.println("Promedio de pares: " + (double) sumaPares / pares);
		}
		if (impares > 0) {
			System.out.println("Promedio de impares: " + (double) sumaImpares / impares);
		}
	}

}
