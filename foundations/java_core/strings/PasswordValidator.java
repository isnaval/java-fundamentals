package java_core.strings;

import java.util.Scanner;

public class PasswordValidator {

	public static void main(String[] args) {
		final String PASSWORD = "Password";

		Scanner scanner = new Scanner(System.in);
		System.out.println("Escribe una contraseña: ");
		String password = scanner.nextLine();

		int count = 1;
		boolean passWordCorrect = false;

		do {
			if (password.equals(PASSWORD)) {
				passWordCorrect = true;
				System.out.println("La contraseña es correcta. Intento " + count);
			} else {
				System.out.println("La contraseña es incorrecta, vuelve a intentarlo. LLevas " + count + " intentos");
				password = scanner.nextLine();
				count++;
			}

		} while (!passWordCorrect);

		scanner.close();
	}

}
