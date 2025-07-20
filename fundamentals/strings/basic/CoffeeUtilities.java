package fundamentals.strings.basic;

import java.util.Scanner;

public class CoffeeUtilities {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(" === INFORMACIÓN DE CAFÉ ===");
		System.out.println("Tipos disponibles: ");
		System.out.println(" - Café con leche");
		System.out.println(" - Café solo");
		System.out.println(" - Cortado");
		System.out.println("\nEscibe el tipo de café que quieres");
		String tipoCafe = scanner.nextLine();
		String ingredientes = getIngredientes(tipoCafe);

		if (ingredientes.equals("Tipo de cafe no reconocido")) {
			System.out.println(" ERROR: " + ingredientes + " intentalo de nuevo.");
			main(args);
			scanner.close();

		} else {
			System.out.println("Ingredientes: " + ingredientes);
			scanner.close();
		}

	}

	public static String getIngredientes(String tipoCafe) {
		if (tipoCafe.equalsIgnoreCase("Café con leche")) {
			return "Café y leche";
		} else if (tipoCafe.equalsIgnoreCase("Café solo")) {
			return "Café";
		} else if (tipoCafe.equalsIgnoreCase("Cortado")) {
			return "Café y poca leche";
		} else {
			return "Tipo de cafe no reconocido";
		}
	}
}
