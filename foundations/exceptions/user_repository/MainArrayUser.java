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
				userService.showStats();
				break;
			case 4:
				checkUserExists(scanner, userService);
				break;
			case 5:
				testExceptionHandling(userService);
				break;
			case 6:
				System.out.println("👋 ¡Hasta luego!");
				scanner.close();
				return;
			default:
				System.out.println("❌ Opción no válida. Por favor, selecciona una opción del 1 al 6.");
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
		System.out.println("3. 📊 Mostrar estadísticas");
		System.out.println("4. ✅ Verificar si existe usuario");
		System.out.println("5. 🧪 Probar manejo de excepciones");
		System.out.println("6. 🚪 Salir");
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
		try {
			int id = Integer.parseInt(scanner.nextLine());
			String user = userService.getUserById(id);
			System.out.println("✅ Usuario encontrado: " + user);
		} catch (NumberFormatException e) {
			System.out.println("❌ Error: Debes ingresar un número válido");
		} catch (UserNotFoundException e) {
			System.out.println("❌ " + e.getMessage());
			System.out.println("💡 Intenta con un ID entre 0 y 5 (usuarios predefinidos)");
		}
	}

	private static void addNewUser(Scanner scanner, UserService userService) {
		System.out.print("👤 Ingresa el nombre del nuevo usuario: ");
		String username = scanner.nextLine();
		userService.addNewUser(username);
	}

	private static void checkUserExists(Scanner scanner, UserService userService) {
		System.out.print("🔍 Ingresa el ID a verificar: ");
		try {
			int id = Integer.parseInt(scanner.nextLine());
			boolean exists = userService.userExists(id);

			if (exists) {
				System.out.println("✅ El usuario con ID " + id + " SÍ existe");
			} else {
				System.out.println("❌ El usuario con ID " + id + " NO existe");
			}
		} catch (NumberFormatException e) {
			System.out.println("❌ Error: Debes ingresar un número válido");
		}
	}

	private static void testExceptionHandling(UserService userService) {
		System.out.println("🧪 === PRUEBAS DE MANEJO DE EXCEPCIONES ===");

		System.out.println("\n1️⃣ Buscando usuario existente (ID: 1):");
		try {
			String user = userService.getUserById(1);
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
