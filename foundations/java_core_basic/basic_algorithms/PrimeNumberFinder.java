package java_core_basic.basic_algorithms;

import java.util.Scanner;

public class PrimeNumberFinder {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese un número: ");
		int number = scanner.nextInt();
		scanner.close();

		if (number < 1) {
			System.out.println("Ingrese un número superior a 0. ");
			return;
		} else {
			System.out.println("\nAnálisis numeral del 1 al " + number + ": ");
			System.out.println("============================================");
			int primos = 0;
			int compuestos = 0;

			System.out.println("\nPrimos: ");
			for (int i = 2; i <= number; i++) {
				if (isPrimo(i)) {
					System.out.print(i + " ");
					primos++;
				}
			}

			System.out.println("\nCompuestos: ");
			for (int i = 2; i <= number; i++) {
				if (!isPrimo(i)) {
					System.out.print(i + " ");
					compuestos++;
				}
			}
		}

	}

	private static boolean isPrimo(int number) {
		if (number <= 1) {
			return false;
		}

		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0)
				return false;
		}

		return true;
	}

}
