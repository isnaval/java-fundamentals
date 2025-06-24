package java_core.strings.validation;

import java.util.Scanner;

public class AnagramChecker {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingresa la primera palabra: ");
		String palabra1 = scanner.nextLine();
		System.out.print("Ingresa la segunda palabra: ");
		String palabra2 = scanner.nextLine();

		boolean sonAnagramas = verificarAnagrama(palabra1, palabra2);

		if (sonAnagramas) {
			System.out.println("✅ ¡Son anagramas!");
		} else {
			System.out.println("❌ No son anagramas.");
		}
		scanner.close();

	}

	private static boolean verificarAnagrama(String palabra1, String palabra2) {
		palabra1 = palabra1.toLowerCase().replaceAll(" ", "");
		palabra2 = palabra2.toLowerCase().replaceAll(" ", "");

		if (palabra1.length() != palabra2.length()) {
			return false;
		}

		char[] array1 = palabra1.toCharArray();
		char[] array2 = palabra2.toCharArray();

		ordenarArray(array1);
		ordenarArray(array2);

		for (int i = 0; i < array1.length; i++) {
			if (array1[i] != array2[i]) {
				return false;
			}
		}

		return true;
	}

	private static void ordenarArray(char[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					char temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}
}
