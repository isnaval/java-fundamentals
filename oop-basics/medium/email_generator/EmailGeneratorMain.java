package java_oop.medium.email_generator;

import java.util.Scanner;

import java_oop.medium.email_generator.generators.AcronymGenerator;
import java_oop.medium.email_generator.generators.FullNameWithDotsGenerator;
import java_oop.medium.email_generator.generators.InitialWithSurnamesGenerator;
import java_oop.medium.email_generator.generators.NameWithSurnameInitialsGenerator;
import java_oop.medium.email_generator.generators.SurnamesFirstGenerator;

public class EmailGeneratorMain {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("====================================");
		System.out.println("   GENERADOR DE EMAILS CORPORATIVOS ");
		System.out.println("====================================\n");

		boolean continuar = true;

		while (continuar) {
			mostrarMenu();
			int opcion = leerOpcion();

			switch (opcion) {
			case 1:
				generarEmailInteractivo();
				break;
			case 2:
				mostrarEjemplos();
				break;
			case 3:
				continuar = false;
				break;
			default:
				System.out.println("Opción no válida.\n");
			}
		}

		System.out.println("\n¡Gracias por usar el generador de emails!");
		scanner.close();
	}

	private static void mostrarMenu() {
		System.out.println("MENU PRINCIPAL:");
		System.out.println("1. Generar email para nuevo usuario");
		System.out.println("2. Ver ejemplos de formatos");
		System.out.println("3. Salir");
		System.out.print("\nSeleccione una opción: ");
	}

	private static int leerOpcion() {
		try {
			return Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	private static void generarEmailInteractivo() {
		System.out.println("\n--- DATOS DEL USUARIO ---");

		System.out.print("Nombre: ");
		String nombre = scanner.nextLine().trim();

		System.out.print("Primer apellido: ");
		String apellido1 = scanner.nextLine().trim();

		System.out.print("Segundo apellido (opcional): ");
		String apellido2 = scanner.nextLine().trim();
		if (apellido2.isEmpty()) {
			apellido2 = null;
		}

		try {
			User user = new User(nombre, apellido1, apellido2);

			System.out.println("\n--- FORMATOS DISPONIBLES ---");
			System.out.println("1. Nombre completo con puntos");
			System.out.println("2. Inicial + apellidos con puntos");
			System.out.println("3. Solo iniciales");
			System.out.println("4. Apellidos + nombre");
			System.out.println("5. Nombre + iniciales apellidos");
			System.out.println("6. Ver todos los formatos");
			System.out.print("\nSeleccione formato: ");

			int formato = leerOpcion();

			if (formato == 6) {
				mostrarTodosLosFormatos(user);
			} else {
				EmailGeneratorInterface generator = seleccionarGenerador(formato);
				if (generator != null) {
					UserEmailGenerator emailGen = new UserEmailGenerator(generator);
					String email = emailGen.generateUserEmail(user);
					System.out.println("\nEmail generado: " + email);
				}
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		System.out.println("\nPresione ENTER para continuar...");
		scanner.nextLine();
	}

	private static EmailGeneratorInterface seleccionarGenerador(int opcion) {
		switch (opcion) {
		case 1:
			return new FullNameWithDotsGenerator();
		case 2:
			return new InitialWithSurnamesGenerator();
		case 3:
			return new AcronymGenerator();
		case 4:
			return new SurnamesFirstGenerator();
		case 5:
			return new NameWithSurnameInitialsGenerator();
		default:
			return null;
		}
	}

	private static void mostrarTodosLosFormatos(User user) {
		System.out.println("\n--- TODOS LOS FORMATOS ---");

		EmailGeneratorInterface[] generators = { new FullNameWithDotsGenerator(), new InitialWithSurnamesGenerator(),
				new AcronymGenerator(), new SurnamesFirstGenerator(), new NameWithSurnameInitialsGenerator() };

		String[] nombres = { "Nombre completo con puntos", "Inicial + apellidos", "Solo iniciales",
				"Apellidos + nombre", "Nombre + iniciales apellidos" };

		for (int i = 0; i < generators.length; i++) {
			try {
				UserEmailGenerator emailGen = new UserEmailGenerator(generators[i]);
				String email = emailGen.generateUserEmail(user);
				System.out.printf("%-30s: %s%n", nombres[i], email);
			} catch (Exception e) {
				System.out.printf("%-30s: Error%n", nombres[i]);
			}
		}
	}

	private static void mostrarEjemplos() {
		System.out.println("\n--- EJEMPLOS DE FORMATOS ---");
		System.out.println("Usuario: Juan García López\n");

		System.out.println("1. Nombre completo con puntos   : juan.garcia.lopez@dominio.com");
		System.out.println("2. Inicial + apellidos          : j.garcia.lopez@dominio.com");
		System.out.println("3. Solo iniciales               : jgl@dominio.com");
		System.out.println("4. Apellidos + nombre           : garcialopezjuan@dominio.com");
		System.out.println("5. Nombre + iniciales apellidos : juangalo@dominio.com");

		System.out.println("\nPresione ENTER para continuar...");
		scanner.nextLine();
	}
}