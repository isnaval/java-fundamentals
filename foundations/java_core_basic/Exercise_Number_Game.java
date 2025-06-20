package java_core_basic;

import java.util.Random;
import java.util.Scanner;

public class Exercise_Number_Game {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== Juego de Adivinanza ===");
		Random random = new Random();
		int secretNumber = random.nextInt(999) + 1;
		int attempts = 0;

		System.out.println("Adivina el número entre 1 y 999:");

		while (true) {
			System.out.print("Tu número: ");
			int guess = scanner.nextInt();
			attempts++;

			if (guess == secretNumber) {
				System.out.println("¡Acertaste en " + attempts + " intentos!");
				break;
			} else if (guess > secretNumber) {
				System.out.println("El número es menor");
			} else {
				System.out.println("El número es mayor");
			}
		}

		System.out.println("\n=== Análisis de Números ===");
		System.out.println("Ingresa 10 números para análisis:");

		int positiveCount = 0, negativeCount = 0, zeroCount = 0;
		int positiveSum = 0, negativeSum = 0;

		for (int i = 1; i <= 10; i++) {
			System.out.print("Número " + i + ": ");
			int number = scanner.nextInt();

			if (number > 0) {
				positiveCount++;
				positiveSum += number;
			} else if (number < 0) {
				negativeCount++;
				negativeSum += number;
			} else {
				zeroCount++;
			}
		}

		System.out.println("\n--- Resultados del Análisis ---");
		System.out.println("Números positivos: " + positiveCount);
		System.out.println("Números negativos: " + negativeCount);
		System.out.println("Números cero: " + zeroCount);

		if (positiveCount > 0) {
			System.out.println("Media de positivos: " + (double) positiveSum / positiveCount);
		}

		if (negativeCount > 0) {
			System.out.println("Media de negativos: " + (double) negativeSum / negativeCount);
		}

		System.out.println("\n=== Tabla de Multiplicar ===");
		System.out.print("Ingresa un número (0-10): ");
		int tableNumber = scanner.nextInt();

		if (tableNumber >= 0 && tableNumber <= 10) {
			System.out.println("Tabla del " + tableNumber + ":");
			for (int i = 0; i <= 10; i++) {
				System.out.println(tableNumber + " x " + i + " = " + (tableNumber * i));
			}
		} else {
			System.out.println("Número fuera de rango");
		}

		scanner.close();
	}

}
