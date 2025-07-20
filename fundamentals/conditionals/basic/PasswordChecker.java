package fundamentals.conditionals.basic;

import java.util.Scanner;

public class PasswordChecker {

	private static final String MASTER_PASSWORD = "Java2024";
	private static final int MAX_ATTEMPTS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== SISTEMA DE SEGURIDAD ===");
		System.out.println("Ingrese la contraseña para continuar");
		System.out.println("(Tiene " + MAX_ATTEMPTS + " intentos)\n");

		boolean accessGranted = false;
		int attempts = 0;

		while (attempts < MAX_ATTEMPTS && !accessGranted) {
			System.out.print("Contraseña: ");
			String userPassword = scanner.nextLine();
			attempts++;

			if (userPassword.equals(MASTER_PASSWORD)) {
				accessGranted = true;
				System.out.println("\n✓ Contraseña correcta");
				System.out.println("Bienvenido al sistema");
			} else {
				int remainingAttempts = MAX_ATTEMPTS - attempts;

				if (remainingAttempts > 0) {
					System.out.println("✗ Contraseña incorrecta");
					System.out.println("Intentos restantes: " + remainingAttempts + "\n");
				} else {
					System.out.println("\n✗ Contraseña incorrecta");
					System.out.println("ACCESO DENEGADO - Sistema bloqueado");
				}
			}
		}

		if (accessGranted) {
			System.out.println("\n--- ACCESO CONCEDIDO ---");
			System.out.println("Puede proceder con sus operaciones");
		} else {
			System.out.println("\n--- SISTEMA BLOQUEADO ---");
			System.out.println("Contacte al administrador");
		}

		scanner.close();
	}
}