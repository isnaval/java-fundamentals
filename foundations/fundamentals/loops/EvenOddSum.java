package fundamentals.loops;

import java.util.Scanner;

public class EvenOddSum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese dos números para calcular la suma de pares e impares en ese rango:");
		System.out.print("Primer número: ");
		int number1 = scanner.nextInt();
		System.out.print("Segundo número: ");
		int number2 = scanner.nextInt();

		scanner.close();

		int sumOdd = 0;
		int sumEven = 0;

		if (number2 < number1) {
			System.out.println("El rango debe tener el segun numero superior al primero. ");
			return;
		} else {

			for (int i = number1; i <= number2; i++) {
				if (i % 2 == 0) {
					sumEven += i;
				} else {
					sumOdd += i;
				}
			}

		}

		System.out.println("\nAnálisis del rango " + number1 + " a " + number2 + ":");
		System.out.println("=======================================================");
		System.out.print("Números en el rango: ");
		for (int i = number1; i <= number2; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("La suma de los números pares es: " + sumEven);
		System.out.println("La suma de los números impares es: " + sumOdd);

	}

}
