package fundamentals.strings.basic;

import java.util.Scanner;

public class CharacterValidator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== VALIDADOR DE VOCALES ===\n");
		System.out.print("Ingrese una letra: ");
		String input = scanner.next();

		if (input.length() != 1) {
			System.out.println("Por favor ingrese solo un carácter.");
		} else {
			char letra = input.charAt(0);
			if (!Character.isLetter(letra)) {
				System.out.println("'" + letra + "' no es una letra.");
			} else if (isVocal(letra)) {
				System.out.println("La letra '" + letra + "' ES una vocal.");
			} else {
				System.out.println("La letra '" + letra + "' NO es una vocal.");
			}
		}

		scanner.close();
	}

	public static boolean isVocal(char letra) {
		char letraMinuscula = Character.toLowerCase(letra);
		return letraMinuscula == 'a' || letraMinuscula == 'e' || letraMinuscula == 'i' || letraMinuscula == 'o'
				|| letraMinuscula == 'u';
	}

}
