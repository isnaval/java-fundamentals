package java_core_basic;

import java.util.Scanner;

public class Exercise_Loop_Fundamentals {
	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== Mathematical Operations ===");
		while (true) {

			// 0
			System.out.println("Ingresa un número (0 o negativo para salir): ");
			int number = scanner.nextInt();
			if (number <= 0) {
				System.out.println("Programa terminado");
				break;
			}

			// 1
			System.out.println("Cuadrado: " + (number * number));

			if (number % 2 == 0) {
				System.out.println("Es par");
			} else {
				System.out.println("Es impar");
			}
			long factorial = 1;
			for (int i = 1; i <= number; i++) {
				factorial *= i;
			}
			System.out.println("Factorial: " + factorial);

			Thread.sleep(1000);
			System.out.println("==================");

			// 2
			System.out.println("\n=== Number Sequences ===");
			System.out.println("Ingresa un número para generar secuencias: ");
			int limit = scanner.nextInt();

			System.out.print("Secuencia ascendente: ");
			for (int i = 1; i <= limit; i++) {
				System.out.print(i + " ");
			}

			System.out.print("\nSecuencia descendente: ");
			for (int i = limit; i >= 1; i--) {
				System.out.print(i + " ");
			}

			System.out.print("\nNúmeros pares: ");
			for (int i = 0; i <= limit; i += 2) {
				System.out.print(i + " ");
			}

			System.out.print("\nNúmeros impares: ");
			for (int i = 1; i <= limit; i += 2) {
				System.out.print(i + " ");
			}

			// 3
			System.out.println("\n\n=== Sum Calculator ===");
			int sum = 0;
			int count = 0;

			do {
				System.out.println("Ingresa números para sumar (0 para terminar): ");
				int num = scanner.nextInt();

				if (num == 0)
					break;

				sum += num;
				count++;

			} while (true);

			if (count > 0) {
				double average = (double) sum / count;
				System.out.println("Suma total: " + sum);
				System.out.println("Cantidad de números: " + count);
				System.out.println("Media: " + average);
			}
		}
		scanner.close();
	}

}
