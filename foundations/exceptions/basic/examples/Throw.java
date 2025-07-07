package exceptions.basic.examples;

import java.util.Scanner;

public class Throw {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduce la edad: ");
		int edad = scanner.nextInt();

		try {
			validateAge(edad);
			System.out.println("Edad válida");
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	public static void validateAge(int age) {
		if (age < 0) {
			throw new IllegalArgumentException("La edad no puede ser negativa");
		}
		if (age < 18) {
			throw new IllegalArgumentException("Debes ser mayor de edad");
		}
		if (age > 120) {
			throw new IllegalArgumentException("La edad no es realista");
		}
	}

}
