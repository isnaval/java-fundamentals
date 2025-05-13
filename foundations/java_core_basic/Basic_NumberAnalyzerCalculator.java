package java_core_basic;

import java.util.Scanner;

public class Basic_NumberAnalyzerCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Dime un numero: ");
		double number1 = scanner.nextInt();
		System.out.print("Dime un numero: ");
		double number2 = scanner.nextInt();

		analyseNumber(number1, "primero");
		analyseNumber(number2, "primero");

	}

	private static void analyseNumber(double number, String position) {
		if (number > 0) {
			System.out.println("El " + position + " numero es positivo");
		} else if (number < 0) {
			System.out.println("El " + position + " numero es negativo");
		} else {
			System.out.println("El " + position + " numero es 0");
		}

		if (number % 1 == 0) { // para saber que es entero
			if (number % 2 == 0) {
				System.out.println("El " + position + " es par");
			} else {
				System.out.println("El " + position + " es impar");

			}
		}
	}

}
