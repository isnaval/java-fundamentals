package java_core.conditionals.advanced;

import java.util.Scanner;

public class PasswordValidator {

	private static final int MIN_LENGTH = 8;
	private static final int STRONG_LENGTH = 12;
	private static final int MAX_LENGTH = 30;

	private static final String[] COMMON_PASSWORDS = { "password", "123456", "12345678", "qwerty", "abc123",
			"password123", "admin", "letmein", "welcome", "monkey" };

	private static final String[] COMMON_PATTERNS = { "1234", "abcd", "qwer", "asdf", "zxcv" };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== VALIDADOR DE CONTRASEÑAS SEGURAS ===");
		System.out.println("Cree una contraseña que cumpla con los criterios de seguridad\n");

		System.out.println("Criterios requeridos:");
		System.out.println("✓ Mínimo 8 caracteres");
		System.out.println("✓ Al menos una letra mayúscula");
		System.out.println("✓ Al menos una letra minúscula");
		System.out.println("✓ Al menos un número");
		System.out.println("✓ Al menos un carácter especial (!@#$%^&*()_+-=[]{}|;:,.<>?)");
		System.out.println("✓ No debe contener espacios");
		System.out.println("✓ No debe ser una contraseña común\n");

		boolean validPassword = false;
		String password = "";

		while (!validPassword) {
			System.out.print("Ingrese su contraseña: ");
			password = scanner.nextLine();

			System.out.println("\n--- ANÁLISIS DE SEGURIDAD ---");

			boolean lengthOk = checkLength(password);
			boolean hasUppercase = checkUppercase(password);
			boolean hasLowercase = checkLowercase(password);
			boolean hasNumber = checkNumber(password);
			boolean hasSpecial = checkSpecialChar(password);
			boolean noSpaces = checkNoSpaces(password);
			boolean notCommon = checkNotCommon(password);
			boolean noSequences = checkNoSequences(password);
			boolean noRepeats = checkNoRepeats(password);

			validPassword = lengthOk && hasUppercase && hasLowercase && hasNumber && hasSpecial && noSpaces
					&& notCommon;

			if (validPassword) {
				int strength = calculateStrength(password, noSequences, noRepeats);

				System.out.println("\n✅ CONTRASEÑA VÁLIDA");
				System.out.println("\nFortaleza: " + getStrengthLabel(strength));
				displayStrengthBar(strength);

				if (strength < 70) {
					System.out.println("\nSugerencias para mejorar:");
					if (password.length() < STRONG_LENGTH) {
						System.out.println("• Aumentar la longitud a 12+ caracteres");
					}
					if (!noSequences) {
						System.out.println("• Evitar secuencias predecibles");
					}
					if (!noRepeats) {
						System.out.println("• Evitar caracteres repetidos");
					}
					System.out.println("• Usar una combinación más variada de caracteres");
				}

				System.out.println("\nInformación adicional:");
				System.out.println("• Longitud: " + password.length() + " caracteres");
				System.out.println("• Tiempo estimado para descifrar: " + getTimeTocrack(strength));
				System.out.println("• Entropía aproximada: " + calculateEntropy(password) + " bits");

			} else {
				System.out.println("\n❌ CONTRASEÑA NO VÁLIDA");
				System.out.println("\nDebe corregir los siguientes problemas:");

				if (!lengthOk) {
					System.out.println("• La contraseña es muy corta o muy larga");
				}
				if (!hasUppercase) {
					System.out.println("• Falta al menos una letra mayúscula");
				}
				if (!hasLowercase) {
					System.out.println("• Falta al menos una letra minúscula");
				}
				if (!hasNumber) {
					System.out.println("• Falta al menos un número");
				}
				if (!hasSpecial) {
					System.out.println("• Falta al menos un carácter especial");
				}
				if (!noSpaces) {
					System.out.println("• No debe contener espacios");
				}
				if (!notCommon) {
					System.out.println("• Es una contraseña muy común o contiene patrones comunes");
				}

				System.out.println("\nIntente nuevamente...\n");
			}
		}

		System.out.println("\n¿Desea generar una contraseña aleatoria segura? (s/n): ");
		if (scanner.nextLine().equalsIgnoreCase("s")) {
			String generated = generateSecurePassword();
			System.out.println("\nContraseña generada: " + generated);
			System.out.println("(Guárdela en un lugar seguro)");
		}

		scanner.close();
	}

	private static boolean checkLength(String password) {
		boolean valid = password.length() >= MIN_LENGTH && password.length() <= MAX_LENGTH;
		System.out.print("Longitud (" + MIN_LENGTH + "-" + MAX_LENGTH + " caracteres): ");
		System.out.println(valid ? "✓" : "✗ (" + password.length() + " caracteres)");
		return valid;
	}

	private static boolean checkUppercase(String password) {
		boolean valid = password.matches(".*[A-Z].*");
		System.out.println("Contiene mayúsculas: " + (valid ? "✓" : "✗"));
		return valid;
	}

	private static boolean checkLowercase(String password) {
		boolean valid = password.matches(".*[a-z].*");
		System.out.println("Contiene minúsculas: " + (valid ? "✓" : "✗"));
		return valid;
	}

	private static boolean checkNumber(String password) {
		boolean valid = password.matches(".*[0-9].*");
		System.out.println("Contiene números: " + (valid ? "✓" : "✗"));
		return valid;
	}

	private static boolean checkSpecialChar(String password) {
		boolean valid = password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{}|;:,.<>?].*");
		System.out.println("Contiene caracteres especiales: " + (valid ? "✓" : "✗"));
		return valid;
	}

	private static boolean checkNoSpaces(String password) {
		boolean valid = !password.contains(" ");
		System.out.println("Sin espacios: " + (valid ? "✓" : "✗"));
		return valid;
	}

	private static boolean checkNotCommon(String password) {
		String lowerPass = password.toLowerCase();

		for (String common : COMMON_PASSWORDS) {
			if (lowerPass.equals(common) || lowerPass.contains(common)) {
				System.out.println("No es contraseña común: ✗");
				return false;
			}
		}

		for (String pattern : COMMON_PATTERNS) {
			if (lowerPass.contains(pattern)) {
				System.out.println("No es contraseña común: ✗ (contiene patrón común)");
				return false;
			}
		}

		System.out.println("No es contraseña común: ✓");
		return true;
	}

	private static boolean checkNoSequences(String password) {
		for (int i = 0; i < password.length() - 2; i++) {
			if (Character.isDigit(password.charAt(i))) {
				if (password.charAt(i + 1) == password.charAt(i) + 1
						&& password.charAt(i + 2) == password.charAt(i) + 2) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean checkNoRepeats(String password) {
		for (int i = 0; i < password.length() - 2; i++) {
			if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i) == password.charAt(i + 2)) {
				return false;
			}
		}
		return true;
	}

	private static int calculateStrength(String password, boolean noSeq, boolean noRep) {
		int strength = 0;

		strength += Math.min(password.length() * 4, 40);

		if (password.matches(".*[A-Z].*"))
			strength += 10;
		if (password.matches(".*[a-z].*"))
			strength += 10;
		if (password.matches(".*[0-9].*"))
			strength += 10;
		if (password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{}|;:,.<>?].*"))
			strength += 20;

		if (password.length() >= STRONG_LENGTH)
			strength += 10;
		if (noSeq)
			strength += 5;
		if (noRep)
			strength += 5;

		return Math.min(strength, 100);
	}

	private static String getStrengthLabel(int strength) {
		if (strength >= 80)
			return "MUY FUERTE";
		if (strength >= 60)
			return "FUERTE";
		if (strength >= 40)
			return "MEDIA";
		return "DÉBIL";
	}

	private static void displayStrengthBar(int strength) {
		System.out.print("Nivel: [");
		int bars = strength / 5;
		for (int i = 0; i < 20; i++) {
			if (i < bars) {
				System.out.print("█");
			} else {
				System.out.print("░");
			}
		}
		System.out.println("] " + strength + "%");
	}

	private static String getTimeTocrack(int strength) {
		if (strength >= 80)
			return "Siglos";
		if (strength >= 70)
			return "Décadas";
		if (strength >= 60)
			return "Años";
		if (strength >= 50)
			return "Meses";
		if (strength >= 40)
			return "Semanas";
		return "Días o menos";
	}

	private static int calculateEntropy(String password) {
		int charSpace = 0;
		if (password.matches(".*[a-z].*"))
			charSpace += 26;
		if (password.matches(".*[A-Z].*"))
			charSpace += 26;
		if (password.matches(".*[0-9].*"))
			charSpace += 10;
		if (password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{}|;:,.<>?].*"))
			charSpace += 32;

		return (int) (password.length() * (Math.log(charSpace) / Math.log(2)));
	}

	private static String generateSecurePassword() {
		String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lower = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String special = "!@#$%^&*()_+-=[]{}|;:,.<>?";
		String all = upper + lower + numbers + special;

		StringBuilder password = new StringBuilder();

		password.append(upper.charAt((int) (Math.random() * upper.length())));
		password.append(lower.charAt((int) (Math.random() * lower.length())));
		password.append(numbers.charAt((int) (Math.random() * numbers.length())));
		password.append(special.charAt((int) (Math.random() * special.length())));

		for (int i = 4; i < 16; i++) {
			password.append(all.charAt((int) (Math.random() * all.length())));
		}

		String mixed = password.toString();
		char[] chars = mixed.toCharArray();
		for (int i = chars.length - 1; i > 0; i--) {
			int j = (int) (Math.random() * (i + 1));
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
		}

		return new String(chars);
	}
}