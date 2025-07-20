package fundamentals.strings.basic;

import java.util.Scanner;

public class StringProcessor {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println(" === PROCESADOR DE TEXTO ===");
		System.out.println("Escribir un texto: ");
		String text = scanner.nextLine();

		System.out.println("\n --- Texto original ---");
		printTexto(text);

		System.out.println("\n --- Texto en mayusculas ---");
		String textoMayusculas = getToUpper(text);
		printTexto(textoMayusculas);

		scanner.close();
	}

	public static void printTexto(String text) {
		System.out.print(text);
	}

	public static String getToUpper(String text) {
		return text.toUpperCase();
	}

}
