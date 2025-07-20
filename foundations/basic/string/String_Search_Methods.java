package basic.string;

import java.util.Scanner;

public class String_Search_Methods {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== Character Search ===");
		System.out.println("Ingresa una cadena de texto: ");
		String text = scanner.nextLine();

		boolean haveÑ = text.toLowerCase().contains("ñ");
		System.out.println("¿Contiene la letra ñ? " + haveÑ);

		System.out.println("\n=== URL Detection ===");
		boolean hasLink = text.contains("http") || text.contains("https");
		System.out.println("¿Contiene enlaces? " + hasLink);

		System.out.println("\n=== Case Verification ===");
		boolean isUpperCase = text.equals(text.toUpperCase());
		System.out.println("¿Está en mayúsculas? " + isUpperCase);

		scanner.close();
	}

}
