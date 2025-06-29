package java_core.strings.advanced;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReservedWordsChecker {
	private static final String[] RESERVED_WORDS = { "abstract", "assert", "boolean", "break", "byte", "case", "catch",
			"char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "false",
			"final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface",
			"long", "native", "new", "null", "package", "private", "protected", "public", "return", "short", "static",
			"strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "true", "try", "var",
			"void", "volatile", "while" };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean continuar = true;
		while (continuar) {
			showMenu();

			try {
				int opcion = scanner.nextInt();
				scanner.nextLine();
				switch (opcion) {
				case 1:
					verificarPalabra(scanner);
					break;
				case 2:
					mostrarTodasLasPalabras();
					break;
				case 3:
					buscarPorLetra(scanner);
					break;
				case 4:
					System.out.println("Hasta Luego!");
					continuar = false;
					break;
				default:
					System.out.println("Opción no válida.");

				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Debe ingresar un número del 1 al 4.");
				scanner.nextLine();
			}

		}
		scanner.close();
	}

	private static void showMenu() {
		System.out.println("=== VERIFICADOR DE PALABRAS RESERVADAS EN JAVA ===\n");
		System.out.println("1. Verificar una palabra");
		System.out.println("2. Ver todas las palabras reservadas");
		System.out.println("3. Buscar palabras por letra inicial");
		System.out.println("4. Salir del programa");
		System.out.print("Seleccione una opción: ");

	}

	public static void verificarPalabra(Scanner scanner) {
		System.out.print("\nIngrese una palabra para verificar: ");
		String palabra = scanner.nextLine();

		if (esReservada(palabra)) {
			System.out.println("\n'" + palabra + "' ES una palabra reservada en Java.");
			System.out.println("No puedes usarla como nombre de variable, método o clase.");

			int posicion = Arrays.asList(RESERVED_WORDS).indexOf(palabra);
			System.out.println("Es la palabra reservada #" + (posicion + 1) + " de " + RESERVED_WORDS.length);
		} else {
			System.out.println("\n'" + palabra + "' NO es una palabra reservada.");
		}
	}

	public static void mostrarTodasLasPalabras() {
		System.out.println("\n=== TODAS LAS PALABRAS RESERVADAS DE JAVA ===");
		System.out.println("Total: " + RESERVED_WORDS.length + " palabras\n");

		for (int i = 0; i < RESERVED_WORDS.length; i++) {
			System.out.printf("%-15s", RESERVED_WORDS[i]);
			if ((i + 1) % 5 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	public static void buscarPorLetra(Scanner scanner) {
		System.out.print("\nIngrese una letra: ");
		String input = scanner.nextLine();

		if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
			System.out.println("Por favor ingrese solo una letra.");
			return;
		}

		char letra = Character.toLowerCase(input.charAt(0));
		System.out.println("\nPalabras reservadas que comienzan con '" + letra + "':");

		int contador = 0;
		for (String palabra : RESERVED_WORDS) {
			if (palabra.charAt(0) == letra) {
				System.out.println("- " + palabra);
				contador++;
			}
		}

		if (contador == 0) {
			System.out.println("No hay palabras reservadas que comiencen con '" + letra + "'");
		} else {
			System.out.println("\nTotal: " + contador + " palabras");
		}
	}

	public static boolean esReservada(String palabra) {
		for (String reservada : RESERVED_WORDS) {
			if (palabra.equals(reservada)) {
				return true;
			}
		}
		return false;
	}

}
