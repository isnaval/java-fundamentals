package fundamentals.strings.advanced;

import java.util.Scanner;

public class PalindromeChecker {
	public static void Main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingresa una frase: ");
		String frase = scanner.nextLine();
		boolean esPalindromo = verificarPalindromo(frase);
		if (esPalindromo) {
			System.out.println("✅ ¡Es un palíndromo!");
		} else {
			System.out.println("❌ No es un palíndromo.");
		}
		scanner.close();
	}

	private static boolean verificarPalindromo(String frase) {
		String limpia = frase.toLowerCase().replace(" ", "");
		String reverso = "";
		for (int i = limpia.length() - 1; i >= 0; i--) {
			reverso += limpia.charAt(i);
		}
		return limpia.equals(reverso);
	}

}
