package exceptions.basic.basic_exception_handling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionCalculatorMain {

	public static void main(String[] args) {
		DivisionService service = new DivisionService();
		Scanner scanner = null;

		try {
			scanner = new Scanner(System.in);
			System.out.println("🧮 Calculadora de División\n");

			while (true) {
				showMenu();

				try {
					int option = scanner.nextInt();

					switch (option) {
					case 1:
						performCalculation(scanner, service);
						break;

					case 2:
						service.displayHistory();
						break;

					case 3:
						service.clearHistory();
						break;

					case 4:
						System.out.println("\n👋 ¡Hasta luego!");
						return;

					default:
						System.out.println("❌ Opción no válida");
					}

				} catch (InputMismatchException e) {
					System.out.println("\n❌ Error: Debe ingresar un número");
					scanner.nextLine(); // Limpiar buffer
				}

				System.out.print("\nPresione Enter para continuar...");
				scanner.nextLine();
				scanner.nextLine();
			}

		} finally {
			if (scanner != null) {
				scanner.close();
				System.out.println("✅ Recursos liberados");
			}
		}
	}

	// Realiza un cálculo
	private static void performCalculation(Scanner scanner, DivisionService service) {
		try {
			System.out.print("\nIngrese el numerador: ");
			int numerator = scanner.nextInt();

			System.out.print("Ingrese el denominador: ");
			int denominator = scanner.nextInt();

			Division result = service.performDivision(numerator, denominator);
			service.displayResult(result);

		} catch (InputMismatchException e) {
			System.out.println("\n❌ Error: Debe ingresar números enteros válidos");
			scanner.nextLine();

		} catch (ArithmeticException e) {
			System.out.println("\n❌ Error matemático: " + e.getMessage());

		} catch (IllegalArgumentException e) {
			System.out.println("\n❌ Error de validación: " + e.getMessage());

		} catch (Exception e) {
			System.out.println("\n❌ Error inesperado: " + e.getMessage());
		}
	}

	// Muestra el menú
	private static void showMenu() {
		System.out.println("\n╔═══════════════════════════╗");
		System.out.println("║  CALCULADORA DE DIVISIÓN  ║");
		System.out.println("╠═══════════════════════════╣");
		System.out.println("║ 1. Realizar división      ║");
		System.out.println("║ 2. Ver historial          ║");
		System.out.println("║ 3. Limpiar historial      ║");
		System.out.println("║ 4. Salir                  ║");
		System.out.println("╚═══════════════════════════╝");
		System.out.print("Seleccione opción: ");
	}
}