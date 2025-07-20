package fundamentals.strings.advanced;

import java.util.Scanner;

public class TextProcessor {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingresa un texto: ");
		String texto = scanner.nextLine();

		System.out.println("\n=== PROCESADOR DE TEXTO ===");
		System.out.println("1. Contar palabras");
		System.out.println("2. Contar caracteres");
		System.out.println("3. Convertir a mayúsculas");
		System.out.println("4. Convertir a minúsculas");
		System.out.println("5. Reemplazar palabra");
		System.out.print("Elige una opción: ");

		int opcion = scanner.nextInt();
		scanner.nextLine();

		switch (opcion) {

		case 1:
			int palabras = contarPalabras(texto);
			System.out.println("Número de palabras: " + palabras);
			break;

		case 2:
			int caracteres = texto.length();
			System.out.println("Número de caracteres: " + caracteres);
			break;

		case 3:
			String mayusculas = texto.toUpperCase();
			System.out.println("En mayúsculas: " + mayusculas);
			break;

		case 4:
			String minusculas = texto.toLowerCase();
			System.out.println("En minúsculas: " + minusculas);
			break;

		case 5:
			System.out.print("Palabra a buscar: ");
			String buscar = scanner.nextLine();
			System.out.print("Reemplazar por: ");
			String reemplazar = scanner.nextLine();

			String resultado = texto.replace(buscar, reemplazar);
			System.out.println("Resultado: " + resultado);
			break;

		default:
			System.out.println("Opción no válida");

		}

	}

	private static int contarPalabras(String texto) {
		String[] palabras = texto.trim().split(" ");
		return palabras.length;
	}

}
