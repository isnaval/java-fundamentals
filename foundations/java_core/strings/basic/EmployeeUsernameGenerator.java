package java_core.strings.basic;

import java.util.Scanner;

public class EmployeeUsernameGenerator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Ingrese el nombre del empleado: ");
		String nombre = scanner.nextLine();
		System.out.print("Ingrese el apellido del empleado: ");
		String apellido = scanner.nextLine();

		String username = generarUsername(nombre, apellido);
		System.out.println("Username generado: " + username);

		scanner.close();
	}

	public static String generarUsername(String nombre, String apellido) {
		String nombreMin = nombre.toLowerCase();
		String apellidoMin = apellido.toLowerCase();
		char inicialNombre = nombreMin.charAt(0);
		char inicialApellido = apellidoMin.charAt(0);
		int numeroAleatorio = (int) (Math.random() * 1000);
		return "" + inicialNombre + inicialApellido + numeroAleatorio;
	}
}
