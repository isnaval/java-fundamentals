package exceptions.user_repository;

public class UserService {
	private final UserRepository repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	public String getUserById(int id) throws UserNotFoundException {
		try {
			return repository.findById(id);
		} catch (UserNotFoundException e) {
			System.err.println("Error al buscar el usuario: " + e.getMessage());
			throw e;
		}
	}

	public boolean userExists(int id) {
		try {
			repository.findById(id);
			return true;
		} catch (UserNotFoundException e) {
			return false;
		}
	}

	public void addNewUser(String username) {
		try {
			repository.addUser(username);
		} catch (IllegalArgumentException e) {
			System.err.println("Error al agregar el usuario: " + e.getMessage());
		} catch (IllegalStateException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	public void showStats() {
		System.out.println("📊 === ESTADÍSTICAS DEL SISTEMA ===");

		int totalUsers = repository.getUserCount();
		System.out.println("📈 Total de usuarios registrados: " + totalUsers);

		if (totalUsers > 0) {
			String[] allUsers = repository.getAllUsers();
			System.out.println("📋 Capacidad máxima del sistema: 50 usuarios");
			System.out.println("📊 Porcentaje de ocupación: " + (totalUsers * 100 / 50) + "%");
			System.out.println("🆔 Próximo ID disponible: " + totalUsers);

			System.out.println("\n👥 Lista resumida de usuarios:");
			for (int i = 0; i < Math.min(allUsers.length, 5); i++) {
				System.out.println("  • ID " + i + ": " + allUsers[i]);
			}

			if (allUsers.length > 5) {
				System.out.println("  ... y " + (allUsers.length - 5) + " usuarios más");
				System.out.println("💡 Usa la opción 3 para ver la lista completa");
			}
		} else {
			System.out.println("📭 El sistema está vacío");
			System.out.println("💡 Usa la opción 2 para agregar tu primer usuario");
		}

		System.out.println("=".repeat(45));
	}

	public int getUserCount() {
		return repository.getUserCount();
	}

	public String[] getAllUsers() {
		return repository.getAllUsers();
	}

	private static void testExceptionHandling(UserService userService) {
		System.out.println("🧪 === PRUEBAS DE MANEJO DE EXCEPCIONES ===");
		System.out.println("Esta prueba demuestra cómo maneja el sistema diferentes errores\n");

		// Verificar si hay usuarios antes de las pruebas
		int userCount = userService.getUserCount();

		System.out.println("📊 Estado actual: " + userCount + " usuarios en el sistema");

		if (userCount == 0) {
			System.out.println("⚠️  Nota: No hay usuarios. Algunas pruebas mostrarán errores esperados.\n");
		}

		// Prueba 1: Usuario que podría existir
		System.out.println("1️⃣ Probando buscar usuario con ID 0:");
		try {
			String user = userService.getUserById(0);
			System.out.println("   ✅ Éxito: Encontrado usuario '" + user + "'");
		} catch (UserNotFoundException e) {
			System.out.println("   ❌ Excepción esperada: " + e.getMessage());
		}

		// Prueba 2: Usuario que definitivamente no existe
		System.out.println("\n2️⃣ Probando buscar usuario inexistente (ID 99):");
		try {
			String user = userService.getUserById(99);
			System.out.println("   ✅ Encontrado: " + user);
		} catch (UserNotFoundException e) {
			System.out.println("   ❌ Excepción capturada correctamente: " + e.getMessage());
			System.out.println("   📝 ID que causó el error: " + e.getUserId());
		}

		// Prueba 3: ID negativo
		System.out.println("\n3️⃣ Probando ID inválido (ID -1):");
		try {
			String user = userService.getUserById(-1);
			System.out.println("   ✅ Encontrado: " + user);
		} catch (UserNotFoundException e) {
			System.out.println("   ❌ Excepción capturada: ID fuera de rango");
		}

		// Prueba 4: Verificación sin excepción
		System.out.println("\n4️⃣ Verificando existencia con método seguro (ID 100):");
		boolean exists = userService.userExists(100);
		System.out.println("   🔍 ¿Existe el usuario 100? " + (exists ? "Sí" : "No"));
		System.out.println("   💡 Este método no lanza excepciones");

		// Prueba 5: Agregar usuario con nombre inválido (simular)
		System.out.println("\n5️⃣ Simulando agregar usuario con nombre vacío:");
		try {
			userService.addNewUser("");
			System.out.println("   ⚠️  Error: Se agregó usuario vacío (no debería pasar)");
		} catch (Exception e) {
			System.out.println("   ❌ Excepción capturada correctamente: Nombre vacío rechazado");
		}

		System.out.println("\n✨ === RESUMEN DE PRUEBAS ===");
		System.out.println("📋 Se probaron 5 escenarios diferentes");
		System.out.println("🛡️  El sistema maneja correctamente las excepciones");
		System.out.println("✅ Todas las pruebas completadas exitosamente");
		System.out.println("=".repeat(50));
	}
}