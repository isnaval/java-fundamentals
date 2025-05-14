package java_core.strings;

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

		for (int i = 0; i < sentence.length(); i++) {
			if (caracter == sentence.charAt(i)) {
				found = true;
				System.out.println("El caracter " + caracter + " esta en la posición " + (i + 1));
			}
			;

		}
		if (!found) {
			System.out.println("El caracter " + caracter + " no esta en la frase señalada.");

		}

		scanner.close();
	}
}