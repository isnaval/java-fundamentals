package java_core_basic.string;

import java.util.Scanner;

public class String_Manipulation_Applications {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// file extension checker - PDF
		System.out.println("=== File Extension Checker ===");
		System.out.println("Dime un nombre de un fichero y su extensión: ");
		String fileName = scanner.nextLine();

		String[] filePart = fileName.split("\\.");
		if (filePart.length == 2) {
			System.out.println("Extension " + filePart[1]);
			if (filePart[1].equals("pdf")) {
				System.out.println("El archivo es un pdf");
			} else {
				System.out.println("El archivo NO es un pdf");
			}
		} else {
			System.out.println("El nombre del fichero no tiene una extensión válida.");
		}

		// Phone prefix checker
		System.out.println("\n=== Phone Prefix Checker ===");
		System.out.println("Dime un numero de telefono con su prefijo separado del numero con un punto: ");
		String telephoneNumber = scanner.nextLine();

		String[] parts = telephoneNumber.split("\\.");
		if (parts.length >= 1) {
			System.out.println("Prefijo: " + parts[0]);
			if (parts[0].startsWith("+34") || parts[0].startsWith("34")) {
				System.out.println("El prefijo es Español");
			} else {
				System.out.println("El prefijo NO es Español");
			}
		} else {
			System.out.println("Formato de teléfono inválido");
		}
		scanner.close();
	}

}
