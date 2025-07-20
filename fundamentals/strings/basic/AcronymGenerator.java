package fundamentals.strings.basic;

import java.util.Scanner;

public class AcronymGenerator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Dame una frase para generar un acrónimo: ");
		String frase = scanner.nextLine();
		String acronimo = generarAcronimo(frase);
		System.out.println("Acrónimo: " + acronimo);
		scanner.close();
	}

	public static String generarAcronimo(String frase) {
		String[] palabras = frase.split(" ");
		String acronimo = "";
		for (int i = 0; i < palabras.length; i++) {
			acronimo += palabras[i].substring(0, 1).toUpperCase();
		}
		return acronimo;
	}
}
