package java_core.games;

import java.util.Scanner;

public class WordPointsGame {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("¡Bienvenido al Juego de Puntos de Palabras!");

		while (true) {
			System.out.println("\n=== WORD POINTS GAME ===");
			System.out.println("1. Jugar");
			System.out.println("2. Calcular puntos de una palabra");
			System.out.println("3. Comparar dos palabras");
			System.out.println("0. Salir");
			System.out.print("Opción: ");

			int opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
			case 1:
				jugar();
				break;
			case 2:
				calcularPuntos();
				break;
			case 3:
				compararPalabras();
				break;
			case 0:
				System.out.println("¡Gracias por jugar!");
				return;
			default:
				System.out.println("Opción inválida");
			}
		}
	}

	// Jugar una partida de 3 palabras
	static void jugar() {
		System.out.println("\n--- JUGAR ---");
		System.out.println("Escribe 3 palabras y suma puntos:");

		int total = 0;

		for (int i = 1; i <= 3; i++) {
			System.out.print("Palabra " + i + ": ");
			String palabra = scanner.nextLine();

			int puntos = calcular(palabra);
			total += puntos;

			System.out.println("  Puntos: " + puntos);
		}

		System.out.println("\nPuntos totales: " + total);

		if (total < 15) {
			System.out.println("Nivel: Principiante 🌱");
		} else if (total < 30) {
			System.out.println("Nivel: Intermedio 🌿");
		} else {
			System.out.println("Nivel: ¡Experto! 🏆");
		}
	}

	static void calcularPuntos() {
		System.out.println("\n--- CALCULAR PUNTOS ---");
		System.out.print("Escribe una palabra: ");
		String palabra = scanner.nextLine();

		int puntos = calcular(palabra);

		System.out.println("Palabra: " + palabra.toUpperCase());
		System.out.println("Puntos: " + puntos);

		mostrarDesglose(palabra);
	}

	static void compararPalabras() {
		System.out.println("\n--- COMPARAR PALABRAS ---");

		System.out.print("Primera palabra: ");
		String palabra1 = scanner.nextLine();

		System.out.print("Segunda palabra: ");
		String palabra2 = scanner.nextLine();

		int puntos1 = calcular(palabra1);
		int puntos2 = calcular(palabra2);

		System.out.println("\nResultados:");
		System.out.println(palabra1.toUpperCase() + ": " + puntos1 + " puntos");
		System.out.println(palabra2.toUpperCase() + ": " + puntos2 + " puntos");

		if (puntos1 > puntos2) {
			System.out.println("¡Ganadora: " + palabra1.toUpperCase() + "!");
		} else if (puntos2 > puntos1) {
			System.out.println("¡Ganadora: " + palabra2.toUpperCase() + "!");
		} else {
			System.out.println("¡Empate!");
		}
	}

	static int calcular(String palabra) {
		int total = 0;
		palabra = palabra.toLowerCase();

		for (int i = 0; i < palabra.length(); i++) {
			char letra = palabra.charAt(i);
			total += puntosLetra(letra);
		}

		return total;
	}

	static int puntosLetra(char letra) {
		switch (letra) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
		case 'l':
		case 'n':
		case 'r':
		case 's':
		case 't':
			return 1;

		case 'd':
		case 'g':
			return 2;

		case 'b':
		case 'c':
		case 'm':
		case 'p':
			return 3;

		case 'f':
		case 'h':
		case 'v':
		case 'w':
		case 'y':
			return 4;

		case 'k':
			return 5;

		case 'j':
		case 'x':
			return 8;

		case 'q':
		case 'z':
			return 10;

		default:
			return 0;
		}
	}

	static void mostrarDesglose(String palabra) {
		System.out.println("\nDesglose:");
		palabra = palabra.toLowerCase();

		for (int i = 0; i < palabra.length(); i++) {
			char letra = palabra.charAt(i);
			int puntos = puntosLetra(letra);
			System.out.println("  " + Character.toUpperCase(letra) + " = " + puntos);
		}
	}

}
