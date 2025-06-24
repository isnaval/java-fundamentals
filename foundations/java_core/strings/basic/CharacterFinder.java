package java_core.strings.basic;

import java.util.Scanner;

public class CharacterFinder {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Ingresa una frase: ");
		String sentence = scanner.nextLine();
		System.out.print("Ingresa un caracter: ");
		char caracter = scanner.next().charAt(0);
		System.out.println("=======================");

		boolean found = false;
		int contador = 0;

		for (int i = 0; i < sentence.length(); i++) {
			if (caracter == sentence.charAt(i)) {
				found = true;
				contador++;
				System.out.println("El caracter '" + caracter + "' esta en la posición " + (i + 1));
			}
		}

		if (!found) {
			System.out.println("El caracter '" + caracter + "' no esta en la frase.");
		} else {
			System.out.println("Total de apariciones: " + contador);
		}

		scanner.close();
	}

	public static int contarCaracter(String texto, char caracter) {
		int contador = 0;
		for (int i = 0; i < texto.length(); i++) {
			if (texto.charAt(i) == caracter) {
				contador++;
			}
		}
		return contador;
	}
}