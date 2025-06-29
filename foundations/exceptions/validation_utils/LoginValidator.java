package exceptions.validation_utils;

import java.util.Scanner;

public class LoginValidator {
	private static final String STORED_USERNAME = "admin";
	private static final String STORED_PASSWORD = "admin123";
	private static final int MAX_ATTEMPTS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int attempts = 0;
		boolean loginSuccessful = false;

		System.out.println("=== SISTEMA DE LOGIN ===\n");

		while (attempts < MAX_ATTEMPTS && !loginSuccessful) {
			try {
				System.out.print("Intento " + (attempts + 1) + " de " + MAX_ATTEMPTS);
				System.out.print("\nUsuario: ");
				String username = scanner.nextLine();
				System.out.print("Contraseña: ");
				String password = scanner.nextLine();
				loginSuccessful = validateLogin(username, password);
				attempts++;
				if (loginSuccessful) {
					System.out.println("\n✓ Login exitoso. ¡Bienvenido!");
				} else {
					if (attempts < MAX_ATTEMPTS) {
						System.out.println("\n✗ Credenciales incorrectas. Intente nuevamente.\n");
					}
				}
			} catch (IllegalArgumentException e) {
				System.out.println("\nError: " + e.getMessage());
				attempts++;
				if (attempts < MAX_ATTEMPTS) {
					System.out.println("Intente nuevamente.\n");
				}
			}
		}

		if (!loginSuccessful) {
			System.out.println("\n✗ Máximo de intentos alcanzado. Acceso bloqueado.");
		}

		scanner.close();
	}

	private static boolean validateLogin(String username, String password) {
		if (username == null || username.trim().isEmpty()) {
			throw new IllegalArgumentException("El usuario no puede estar vacío");
		}

		if (password == null || password.trim().isEmpty()) {
			throw new IllegalArgumentException("La contraseña no puede estar vacía");
		}

		if (username.length() < 3) {
			throw new IllegalArgumentException("El usuario debe tener al menos 3 caracteres");
		}

		if (password.length() < 6) {
			throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres");
		}

		return STORED_USERNAME.equals(username) && STORED_PASSWORD.equals(password);
	}

	public static boolean validateCredentials(String username, String password) {
		return STORED_USERNAME.equals(username) && STORED_PASSWORD.equals(password);
	}
}
