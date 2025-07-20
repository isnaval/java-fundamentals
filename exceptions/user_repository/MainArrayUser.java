package exceptions.user_repository;

import java.util.Scanner;

public class MainArrayUser {

	public static void main(String[] args) {
		UserRepository repository = new ArrayUserRepository();
		UserService userService = new UserService(repository);
		Scanner scanner = new Scanner(System.in);

		System.out.println("🎯 === Sistema de Gestión de Usuarios ===");
		System.out.println("Este programa demuestra el manejo de excepciones personalizadas\n");

		while (true) {
			showMenu();
			int option = getValidOption(scanner);

			switch (option) {
			case 1:
				findUserById(scanner, userService);
				break;
			case 2:
				addNewUser(scanner, userService);
				break;
			case 3:
				showAllUsers(userService);
				break;
			case 4:
				userService.showStats();
				break;
			case 5:
				checkUserExists(scanner, userService);
				break;
			case 6:
				testExceptionHandling(userService);
				break;
			case 7:
				System.out.println("👋 ¡Hasta luego!");
				scanner.close();
				return;
			default:
				System.out.println("❌ Opción no válida. Por favor, selecciona una opción del 1 al 7.");
			}

			System.out.println("\n⏸️  Presiona Enter para continuar...");
			scanner.nextLine();
		}
	}

	private static void showMenu() {
		System.out.println("\n" + "=".repeat(40));
		System.out.println("📋 MENÚ DE OPCIONES");
		System.out.println("=".repeat(40));
		System.out.println("1. 🔍 Buscar usuario por ID");
		System.out.println("2. ➕ Agregar nuevo usuario");
		System.out.println("3. 📋 Mostrar todos los usuarios");
		System.out.println("4. 📊 Mostrar estadísticas");
		System.out.println("5. ✅ Verificar si existe usuario");
		System.out.println("6. 🧪 Probar manejo de excepciones");
		System.out.println("7. 🚪 Salir");
		System.out.println("=".repeat(40));
		System.out.print("➡️  Selecciona una opción: ");
	}

	private static int getValidOption(Scanner scanner) {
		try {
			return Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	private static void findUserById(Scanner scanner, UserService userService) {
		System.out.print("🆔 Ingresa el ID del usuario: ");
		String input = scanner.nextLine().trim();

		if (input.isEmpty()) {
			System.out.println("❌ Error: No ingresaste ningún valor");
			return;
		}

		try {
			int id = Integer.parseInt(input);
			String user = userService.getUserById(id);
			System.out.println("✅ Usuario encontrado: " + user);
		} catch (NumberFormatException e) {
			System.out.println("❌ Error: '" + input + "' no es un número válido");
		} catch (UserNotFoundException e) {
			System.out.println("❌ " + e.getMessage());
			System.out.println("💡 Primero agrega algunos usuarios con la opción 2");
		}
	}

	private static void addNewUser(Scanner scanner, UserService userService) {
		System.out.print("👤 Ingresa el nombre del nuevo usuario: ");
		String username = scanner.nextLine().trim();

		if (username.isEmpty()) {
			System.out.println("❌ Error: No ingresaste ningún nombre");
			return;
		}

		int assignedId = userService.getUserCount();

		try {
			userService.addNewUser(username);
			System.out.println("✅ Usuario '" + username + "' agregado correctamente con ID: " + assignedId);
		} catch (Exception e) {
			System.out.println("❌ No se pudo agregar el usuario");
		}
	}

	private static void showAllUsers(UserService userService) {
		System.out.println("👥 === LISTA DE TODOS LOS USUARIOS ===");

		int totalUsers = userService.getUserCount();
		if (totalUsers == 0) {
			System.out.println("📭 No hay usuarios registrados en el sistema");
			System.out.println("💡 Usa la opción 2 para agregar usuarios");
			return;
		}

		String[] allUsers = userService.getAllUsers();
		System.out.println("📊 Total de usuarios: " + totalUsers + "\n");

		for (int i = 0; i < allUsers.length; i++) {
			System.out.println("  🆔 ID: " + i + " | 👤 Nombre: " + allUsers[i]);
		}

		System.out.println("\n" + "=".repeat(40));
	}

	private static void checkUserExists(Scanner scanner, UserService userService) {
		System.out.print("🔍 Ingresa el ID a verificar: ");
		String input = scanner.nextLine().trim();

		if (input.isEmpty()) {
			System.out.println("❌ Error: No ingresaste ningún valor");
			return;
		}

		try {
			int id = Integer.parseInt(input);
			boolean exists = userService.userExists(id);

			if (exists) {
				System.out.println("✅ El usuario con ID " + id + " SÍ existe");
			} else {
				System.out.println("❌ El usuario con ID " + id + " NO existe");
			}
		} catch (NumberFormatException e) {
			System.out.println("❌ Error: '" + input + "' no es un número válido");
		}
	}

	private static void testExceptionHandling(UserService userService) {
		System.out.println("🧪 === PRUEBAS DE MANEJO DE EXCEPCIONES ===");

		System.out.println("\n1️⃣ Buscando usuario existente (ID: 0):");
		try {
			String user = userService.getUserById(0);
			System.out.println("   ✅ Encontrado: " + user);
		} catch (UserNotFoundException e) {
			System.out.println("   ❌ " + e.getMessage());
		}

		System.out.println("\n2️⃣ Buscando usuario inexistente (ID: 99):");
		try {
			String user = userService.getUserById(99);
			System.out.println("   ✅ Encontrado: " + user);
		} catch (UserNotFoundException e) {
			System.out.println("   ❌ Excepción capturada: " + e.getMessage());
			System.out.println("   📝 ID que causó el error: " + e.getUserId());
		}

		System.out.println("\n3️⃣ Buscando con ID fuera de rango (ID: -1):");
		try {
			String user = userService.getUserById(-1);
			System.out.println("   ✅ Encontrado: " + user);
		} catch (UserNotFoundException e) {
			System.out.println("   ❌ Excepción capturada: " + e.getMessage());
		}

		System.out.println("\n4️⃣ Verificando existencia sin excepción (ID: 100):");
		boolean exists = userService.userExists(100);
		System.out.println("   🔍 ¿Existe el usuario 100? " + (exists ? "Sí" : "No"));

		System.out.println("\n✨ Todas las pruebas completadas");
	}
}