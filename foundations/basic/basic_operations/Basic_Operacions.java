package basic.basic_operations;

import java.util.Scanner;

public class Basic_Operacions {
	public static void main(String[] args) {
		// Concatenación
		String name = "nombre ";
		System.out.println("Mi " + name + "es ...");

		// calculo de edad
		int birthYear = 1976;
		int currentYear = 2025;
		System.out.println("Tienes " + (currentYear - birthYear) + "años");

		// tamaño string
		System.out.println("La palabra " + name + " tiene " + name.length() + " caracteres");

		// Scanner Input
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingresa una contraseña ");
		String password = scanner.nextLine();
		int passwordLentht = password.length();
		System.out.println("La contraseña tiene " + passwordLentht + " caracteres");
		scanner.close();
	}

}
