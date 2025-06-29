package java_core.arrays;

import java.util.Scanner;

public class DynamicArrayInput {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=== CREADOR DE ARRAYS DINAMICOS ===");
		System.out.print("¿Cuantos números tiene el array? ");
		int length = scanner.nextInt();
		if (length <= 0) {
			System.out.println("El array de números está vacio");
			scanner.close();
			return;
		}
		int[] numbers = new int[length];

		for (int i = 0; i < length; i++) {
			System.out.print("Introduce el valor para la posición " + (i + 1) + ": ");
			numbers[i] = scanner.nextInt();
		}
		System.out.println("\n=== ARRAYS CREADO ===");
		for (int i = 0; i < length; i++) {
			System.out.println("Número: " + numbers[i]);
		}
		scanner.close();
	}

}
