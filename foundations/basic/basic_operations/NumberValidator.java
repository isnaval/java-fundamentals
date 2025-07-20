package basic.basic_operations;

import java.util.Scanner;

public class NumberValidator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(" === VALIDADOR DE NUMEROS ===");
		System.out.print("Dime un número para saber si es divisible entre 10: ");
		int numero1 = scanner.nextInt();

		if (checkIfDivisibleByTen(numero1)) {
			System.out.println("OK: " + numero1 + " es divisible por 10");
		} else {
			System.out.println("NO: " + numero1 + " no es divisible por 10");
		}

		System.out.print("\nDime un número: ");
		int numero2 = scanner.nextInt();
		System.out.print("Dime otro número: ");
		int numero3 = scanner.nextInt();

		if (checkIfSameNumber(numero2, numero3)) {
			System.out.println("OK: son dos numeros iguales");
		} else {
			System.out.println("NO: no son dos numeros iguales");
		}
		scanner.close();

	}

	private static boolean checkIfDivisibleByTen(int numero) {
		return (numero % 10 == 0);
	}

	private static boolean checkIfSameNumber(int numero2, int numero1) {
		return (numero1 == numero2);
	}

}
