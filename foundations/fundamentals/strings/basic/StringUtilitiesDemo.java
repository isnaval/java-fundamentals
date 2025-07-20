package fundamentals.strings.basic;

import java.util.Scanner;

public class StringUtilitiesDemo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== UTILIDADES DE STRINGS ===");
		System.out.println("1. Generar username de empleado");
		System.out.println("2. Generar acrónimo");
		System.out.println("3. Buscar carácter");
		System.out.print("Elige una opción (1-3): ");

		int option = scanner.nextInt();
		scanner.nextLine();

		switch (option) {
		case 1:
			System.out.println("Nombre: ");
			String nombre = scanner.nextLine();
			System.out.println("Apellidos: ");
			String apellidos = scanner.nextLine();
			String username = EmployeeUsernameGenerator.generarUsername(nombre, apellidos);
			System.out.println("Username generado: " + username);
			break;

		case 2:
			System.out.println("Frase: ");
			String frase = scanner.nextLine();
			String acronimo = AcronymGenerator.generarAcronimo(frase);
			System.out.println("Acrónimo: " + acronimo);
			break;

		case 3:
			System.out.println("Texto: ");
			String texto = scanner.nextLine();
			System.out.println("Carácter a buscar: ");
			char caracter = scanner.nextLine().charAt(0);
			int veces = CharacterFinder.contarCaracter(texto, caracter);
			System.out.println("El carácter '" + caracter + "' aparece " + veces + " veces");
			break;

		default:
			System.out.println("Opción no valida");
		}

		scanner.close();
	}

}
