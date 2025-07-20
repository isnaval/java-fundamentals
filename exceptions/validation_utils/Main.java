package exceptions.validation_utils;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== CALCULADORA CON VALIDACIÓN DE EXCEPCIONES ===\n");

		try {
			System.out.print("Ingrese numerador para división: ");
			double numerator = scanner.nextDouble();

			System.out.print("Ingrese denominador para división: ");
			double denominator = scanner.nextDouble();

			double result = Utils.divide(numerator, denominator);
			System.out.println("Resultado de la división: " + result);
		} catch (ArithmeticException e) {
			System.out.println("Error en división: " + e.getMessage());
		}

		try {
			System.out.print("\nIngrese primer número para suma: ");
			int num1 = scanner.nextInt();

			System.out.print("Ingrese segundo número para suma: ");
			int num2 = scanner.nextInt();

			int sumResult = Utils.add(num1, num2);
			System.out.println("Resultado de la suma: " + sumResult);
		} catch (ArithmeticException e) {
			System.out.println("Error en suma: " + e.getMessage());
		}

		try {
			System.out.print("\nIngrese número para calcular raíz cuadrada: ");
			double value = scanner.nextDouble();

			double sqrtResult = Utils.squareRoot(value);
			System.out.println("Raíz cuadrada: " + sqrtResult);
		} catch (ArithmeticException e) {
			System.out.println("Error en raíz cuadrada: " + e.getMessage());
		}

		scanner.nextLine();

		try {
			System.out.print("\nIngrese texto para calcular longitud (o Enter para null): ");
			String text = scanner.nextLine();

			if (text.isEmpty()) {
				text = null;
			}

			int length = Utils.calculateTextLength(text);
			System.out.println("Longitud del texto: " + length);
		} catch (NullPointerException e) {
			System.out.println("Error en cálculo de longitud: " + e.getMessage());
		}

		try {
			System.out.print("\nIngrese índice del día de la semana (0-6): ");
			int index = scanner.nextInt();

			String weekday = Utils.getWeekdayByIndex(index);
			System.out.println("Día de la semana: " + weekday);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error en índice de día: " + e.getMessage());
		}

		scanner.close();
		System.out.println("\n=== FIN DEL PROGRAMA ===");
	}

}
