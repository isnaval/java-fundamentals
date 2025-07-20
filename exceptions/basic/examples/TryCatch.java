package exceptions.basic.examples;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingresa tu edad: ");
		try {
			int age = scanner.nextInt();
			System.out.println("Tu edad es: " + age);

		} catch (InputMismatchException e) {
			System.out.println("ERROR: debes ingresar un numero entero");
		}
		scanner.close();
	}

}
