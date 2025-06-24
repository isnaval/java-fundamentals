package java_core.strings.validation;

import java.util.Scanner;

public class CreditCardMasker {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=== ENMASCARADOR DE TARJETAS ===");
		System.out.print("Ingresa el número de tarjeta (16 dígitos): ");
		String numeroTarjeta = scanner.nextLine();
		if (validarNumeroTarjeta(numeroTarjeta)) {
			String tarjetaEnmascarada = enmascararTarjeta(numeroTarjeta);
			System.out.println("Número enmascarado: " + tarjetaEnmascarada);
		} else {
			System.out.println("❌ Número de tarjeta inválido.");
			System.out.println("Debe tener exactamente 16 dígitos.");
		}

		scanner.close();

	}

	private static String enmascararTarjeta(String numeroTarjeta) {
		String numero = numeroTarjeta.replaceAll("[ -]", "");
		StringBuilder resultado = new StringBuilder();
		for (int i = 0; i < numero.length(); i++) {
			if (i < numero.length() - 4) {
				resultado.append("*");
			} else {
				resultado.append(numero.charAt(i));
			}
			if ((i + 1) % 4 == 0 && i < numero.length() - 1) {
				resultado.append("-");
			}
		}
		return resultado.toString();
	}

	private static boolean validarNumeroTarjeta(String numeroTarjeta) {
		String numero = numeroTarjeta.replaceAll("[ -]", "");
		if (numero.length() != 16) {
			return false;
		}
		for (int i = 0; i < numero.length(); i++) {
			if (!Character.isDigit(numero.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
