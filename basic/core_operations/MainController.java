package basic.core_operations;

import java.util.Scanner;

public class MainController {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("=== SISTEMA DE OPERACIONES UNIFICADAS ===");
		System.out.println("Bienvenido al sistema consolidado de ejercicios básicos");

		while (true) {
			showMainMenu();
			int option = getValidOption(0, 6);

			switch (option) {
			case 1:
				MathOperations.showMathMenu();
				break;
			case 2:
				ComparisonOperations.showComparisonMenu();
				break;
			case 3:
				SequenceOperations.showSequenceMenu();
				break;
			case 4:
				DateTimeOperations.showDateTimeMenu();
				break;
			case 5:
				TextConversionOperations.showTextMenu();
				break;
			case 6:
				InteractiveGames.showGamesMenu();
				break;
			case 0:
				System.out.println("¡Gracias por usar el sistema! ¡Hasta luego!");
				System.exit(0);
				break;
			}
		}
	}

	private static void showMainMenu() {
		System.out.println("\n" + "=".repeat(50));
		System.out.println("           MENÚ PRINCIPAL");
		System.out.println("=".repeat(50));
		System.out.println("1. 🧮 Operaciones Matemáticas");
		System.out.println("2. ⚖️  Comparaciones y Validaciones");
		System.out.println("3. 🔢 Secuencias y Patrones");
		System.out.println("4. 📅 Fechas y Tiempo");
		System.out.println("5. 📝 Conversiones de Texto");
		System.out.println("6. 🎮 Juegos Interactivos");
		System.out.println("0. ❌ Salir");
		System.out.println("=".repeat(50));
		System.out.print("Selecciona una opción: ");
	}

	public static int getValidOption(int min, int max) {
		int option;
		while (true) {
			try {
				option = scanner.nextInt();
				if (option >= min && option <= max) {
					return option;
				} else {
					System.out.print("Opción inválida. Ingresa un número entre " + min + " y " + max + ": ");
				}
			} catch (Exception e) {
				System.out.print("Entrada inválida. Ingresa un número: ");
				scanner.nextLine(); // Limpiar buffer
			}
		}
	}

	public static void pauseAndContinue() {
		System.out.println("\nPresiona Enter para continuar...");
		scanner.nextLine();
		try {
			System.in.read();
		} catch (Exception e) {

		}
	}

	public static Scanner getScanner() {
		return scanner;
	}
}