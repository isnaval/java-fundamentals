package fundamentals.loops;

import java.util.Scanner;

public class LoopControlFlow {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== CONTROL DE FLUJO EN BUCLES ===\n");

		System.out.println("1. Bucle con condición booleana");
		System.out.println("2. Bucle con break");
		System.out.println("3. Bucle con continue");
		System.out.println("4. Bucle infinito controlado");
		System.out.print("Seleccione una opción: ");

		int opcion = scanner.nextInt();

		switch (opcion) {
		case 1:
			bucleConBooleano();
			break;
		case 2:
			bucleConBreak(scanner);
			break;
		case 3:
			bucleConContinue();
			break;
		case 4:
			bucleInfinitoControlado(scanner);
			break;
		default:
			System.out.println("Opción no válida");
		}

		scanner.close();
	}

	public static void bucleConBooleano() {
		System.out.println("\nBucle controlado por variable booleana:");
		boolean continuar = true;
		int i = 1;
		while (continuar) {
			System.out.println("El valor de i es: " + i);
			i++;
			if (i > 5) {
				continuar = false;
			}
		}
		System.out.println("Bucle terminado en i = " + i);
	}

	public static void bucleConBreak(Scanner scanner) {
		System.out.println("\nIngrese un número entre 50 y 100 para detener el bucle:");
		int numeroParada = scanner.nextInt();

		if (numeroParada < 50 || numeroParada > 100) {
			System.out.println("Número fuera de rango. Usando 75 por defecto.");
			numeroParada = 75;
		}

		for (int i = 50; i <= 100; i++) {
			System.out.print(i);

			if (i == numeroParada) {
				System.out.println(" → ¡Fin del bucle!");
				break;
			}

			if (i < 100) {
				System.out.print(" - ");
			}
		}
	}

	public static void bucleConContinue() {
		System.out.println("\nNúmeros del 1 al 20 (saltando múltiplos de 3):");

		for (int i = 1; i <= 20; i++) {
			if (i % 3 == 0) {
				continue;
			}
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void bucleInfinitoControlado(Scanner scanner) {
		System.out.println("\nBucle infinito (escriba 'salir' para terminar):");
		scanner.nextLine();

		int contador = 0;
		while (true) {
			System.out.print("Iteración " + contador + " - Ingrese texto: ");
			String entrada = scanner.nextLine();

			if (entrada.equalsIgnoreCase("salir")) {
				System.out.println("Saliendo del bucle...");
				break;
			}

			System.out.println("Usted escribió: " + entrada);
			contador++;
		}

		System.out.println("Total de iteraciones: " + contador);
	}
}