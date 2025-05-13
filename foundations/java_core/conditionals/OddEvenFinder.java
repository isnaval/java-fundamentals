package java_core.conditionals;

import java.util.Scanner;

public class OddEvenFinder {

	/**
	 * Escribe un programa que solicite al usuario 4 números enteros, verifique cual
	 * es par o impar y calcule el número mayor de los pares y el mayor de los
	 * impares mostrando el resultado de las operaciones por consola.
	 * 
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Dime cuatro numeros enteros: ");
		int numero1 = scanner.nextInt();
		int numero2 = scanner.nextInt();
		int numero3 = scanner.nextInt();
		int numero4 = scanner.nextInt();

		scanner.close();

		int maxParNumber = Integer.MIN_VALUE;
		int maxOddNumber = Integer.MIN_VALUE;
		boolean hasEven = false;
		boolean hasOdd = false;

		int numeros[] = { numero1, numero2, numero3, numero4 };

		for (int i = 0; i < numeros.length; i++) {
			boolean isEven = isEven(numeros[i]);
			System.out.println("El numero " + numeros[i] + " es" + (isEven ? " par" : " impar"));

			if (isEven) {
				if (!hasEven || numeros[i] > maxParNumber) {
					maxParNumber = numeros[i];
					hasEven = true;
				}
			} else {
				if (!hasOdd || numeros[i] > maxOddNumber) {
					maxOddNumber = numeros[i];
					hasOdd = true;
				}
			}
		}

		if (hasEven) {
			System.out.println("El mayor número par es: " + maxParNumber);
		} else {
			System.out.println("No se ingresaron números pares");
		}

		if (hasOdd) {
			System.out.println("El mayor número impar es: " + maxOddNumber);
		} else {
			System.out.println("No se ingresaron números impares");
		}

	}

	public static boolean isEven(int number) {
		return (number % 2 == 0);
	}

	public static void OrderNumber(int numbers[]) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length - i - 1; j++) {
				if (numbers[j] > numbers[j + 1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
		}
	}

}
