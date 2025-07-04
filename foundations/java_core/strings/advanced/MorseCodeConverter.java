package java_core.strings.advanced;

import java.util.Scanner;

public class MorseCodeConverter {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		showMorseMenu();
	}

	public static void showMorseMenu() {
		while (true) {
			System.out.println("\n=== CONVERTIDOR MORSE ===");
			System.out.println("1. Texto a Morse");
			System.out.println("2. Morse a Texto");
			System.out.println("3. Conversion automatica");
			System.out.println("0. Salir");
			System.out.print("Opcion: ");

			int option = getValidOption(0, 3);

			switch (option) {
			case 1:
				textToMorse();
				break;
			case 2:
				morseToText();
				break;
			case 3:
				autoConvert();
				break;
			case 0:
				return;
			}
		}
	}

	private static int getValidOption(int min, int max) {
		while (true) {
			try {
				int option = scanner.nextInt();
				scanner.nextLine();
				if (option >= min && option <= max) {
					return option;
				}
				System.out.print("Opcion invalida (" + min + "-" + max + "): ");
			} catch (Exception e) {
				scanner.nextLine();
				System.out.print("Entrada invalida: ");
			}
		}
	}

	private static void textToMorse() {
		System.out.print("Ingresa texto: ");
		String texto = scanner.nextLine().toUpperCase();
		String morse = convertToMorse(texto);
		System.out.println("Morse: " + morse);
	}

	private static void morseToText() {
		System.out.print("Ingresa morse (separa letras con espacio): ");
		String morse = scanner.nextLine();
		String texto = convertToText(morse);
		System.out.println("Texto: " + texto);
	}

	private static void autoConvert() {
		System.out.print("Ingresa texto o morse: ");
		String input = scanner.nextLine();

		if (isMorse(input)) {
			System.out.println("Detectado: Morse");
			System.out.println("Texto: " + convertToText(input));
		} else {
			System.out.println("Detectado: Texto");
			System.out.println("Morse: " + convertToMorse(input.toUpperCase()));
		}
	}

	private static boolean isMorse(String input) {
		return input.contains(".") || input.contains("-");
	}

	public static String convertToMorse(String texto) {
		StringBuilder morse = new StringBuilder();

		for (char c : texto.toCharArray()) {
			if (c == ' ') {
				morse.append("  ");
			} else {
				String morseChar = MorseDictionary.TEXT_TO_MORSE.get(String.valueOf(c));
				if (morseChar != null) {
					morse.append(morseChar).append(" ");
				}
			}
		}

		return morse.toString().trim();
	}

	public static String convertToText(String morse) {
		StringBuilder texto = new StringBuilder();
		String[] palabras = morse.split("  ");

		for (int i = 0; i < palabras.length; i++) {
			if (i > 0)
				texto.append(" ");

			String[] letras = palabras[i].split(" ");
			for (String letra : letras) {
				String caracter = MorseDictionary.MORSE_TO_TEXT.get(letra.trim());
				if (caracter != null) {
					texto.append(caracter);
				}
			}
		}

		return texto.toString();
	}
}
