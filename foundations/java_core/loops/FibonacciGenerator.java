package java_core.loops;

import java.util.Scanner;

public class FibonacciGenerator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ejercicio de iniciació en la secuencia de Fibonacci: ");
		System.out.print("Dame el primer numero de la secuencia: ");
		int firstNumber = scanner.nextInt();
		System.out.print("Dame el segundo número de la secuencia: ");
		int secondNumber = scanner.nextInt();
		System.out.print("¿Cuantos numeros de la secuencia quieres generar?: ");
		int count = scanner.nextInt();
		scanner.close();

		System.out.println("==================");
		System.out.println("Secuencia de Fibonacci: ");
		generateFibonacci(firstNumber, secondNumber, count);

	}

	public static void generateFibonacci(int firstNumber, int secondNumber, int count) {

		int current = firstNumber;
		int next = secondNumber;

		if (count < 1) {
			System.out.println("Por favor, ingresa un número mayor o igual a 1.");
			return;
		}

		for (int i = 1; i <= count; i++) {
			if (i == 1) {
				System.out.print(current + " ");
			} else if (i == 2) {
				System.out.print(next + " ");
			} else {
				int fibonacci = current + next;
				System.out.print(fibonacci + " ");
				current = next;
				next = fibonacci;
			}
		}

		System.out.println();
	}

}

/**
 * public static void main(String[] args) {
 * 
 * Scanner scanner = new Scanner(System.in); System.out.println("Vamos a
 * realizar una frecuencia de Fibonacci. "); System.out.print("Ingresa un número
 * limite para sacar la frecuencia de numeros: "); int n = scanner.nextInt();
 * 
 * int firstNumber = 1; int secondNumber = 0; secondNumber += firstNumber;
 * 
 * System.out.println("Los números son los siguientes: ");
 * 
 * for (int i = 1; i <= n; i++) {
 * 
 * System.out.print(("(") + i + (")") + firstNumber + " "); int nextNumber =
 * firstNumber + secondNumber; firstNumber = secondNumber; secondNumber =
 * nextNumber; } System.out.println(" ");
 * System.out.println("================================="); scanner.close(); }
 */