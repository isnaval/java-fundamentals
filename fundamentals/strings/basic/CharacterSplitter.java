package fundamentals.strings.basic;

import java.util.Scanner;

public class CharacterSplitter {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== SEPARADOR DE CARACTERES ===\n");

		System.out.print("Ingrese una palabra o frase: ");
		String texto = scanner.nextLine();

		System.out.println("\n1. CARACTERES SEPARADOS:");
		splitCharacters(texto);

		System.out.println("\n2. CARACTERES CON ÍNDICE:");
		splitWithIndex(texto);

		System.out.println("\n3. ANÁLISIS DE CARACTERES:");
		analyzeCharacters(texto);

		System.out.println("\n4. PALABRA VERTICAL:");
		printVertical(texto);

		scanner.close();
	}

	public static void splitCharacters(String word) {
		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			System.out.print(character);
		}
	}

	public static void splitWithIndex(String word) {
		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			System.out.println("Posición " + i + ": '" + character + "'");
		}
	}

	public static void analyzeCharacters(String text) {
		int letras = 0;
		int numeros = 0;
		int espacios = 0;
		int especiales = 0;
		int mayusculas = 0;
		int minusculas = 0;

		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);

			if (Character.isLetter(c)) {
				letras++;
				if (Character.isUpperCase(c)) {
					mayusculas++;
				} else {
					minusculas++;
				}
			} else if (Character.isDigit(c)) {
				numeros++;
			} else if (Character.isWhitespace(c)) {
				espacios++;
			} else {
				especiales++;
			}
		}

		System.out.println("Total de caracteres: " + text.length());
		System.out.println("Letras: " + letras);
		System.out.println("  - Mayúsculas: " + mayusculas);
		System.out.println("  - Minúsculas: " + minusculas);
		System.out.println("Números: " + numeros);
		System.out.println("Espacios: " + espacios);
		System.out.println("Caracteres especiales: " + especiales);
	}

	public static void printVertical(String text) {
		String palabraSinEspacios = text.replaceAll(" ", "");

		for (char c : palabraSinEspacios.toCharArray()) {
			System.out.println("  " + c);
		}
	}
}
