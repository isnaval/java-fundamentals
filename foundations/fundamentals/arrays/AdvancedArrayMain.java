package fundamentals.arrays;

import java.util.Scanner;

public class AdvancedArrayMain {
	static Scanner scanner = new Scanner(System.in);
	static AdvancedArrayOperations operations = new AdvancedArrayOperations();

	public static void main(String[] args) {
		showMenu();
	}

	public static void showMenu() {
		while (true) {
			System.out.println("=".repeat(40));
			System.out.println("\n   OPERACIONES CON ARRAYS    ");
			System.out.println("=".repeat(40));
			System.out.println("1. Mezclar arrays");
			System.out.println("2. Fusionar tipos diferentes");
			System.out.println("3. Insertar en posiciones");
			System.out.println("4. Inserción ordenada");
			System.out.println("5. Análisis de arrays");
			System.out.println("0. Salir");
			System.out.print("Opción: ");
			int option = getOption(0, 5);

			if (option == 0) {
				System.out.println("Hasta luego!");
				break;
			}

			executeOption(option);
			pausar();

		}
	}

	private static int getOption(int min, int max) {
		while (true) {
			try {
				int option = scanner.nextInt();
				if (option >= min && option <= max) {
					return option;
				}
			} catch (Exception e) {
				scanner.nextLine();
				System.out.println("Entrada invalida: ");
			}
		}

	}

	private static void executeOption(int option) {
		switch (option) {
		case 1:
			operations.mezclarArrays();
			break;
		case 2:
			operations.fusionarTipos();
			break;
		case 3:
			operations.insertarPosiciones();
			break;
		case 4:
			operations.insercionOrdenada();
			break;
		case 5:
			operations.analizarArray();
			break;
		}
	}

	private static void pausar() {
		System.out.print("\nPresiona ENTER para continuar...");
		scanner.nextLine();
		try {
			scanner.nextLine();
		} catch (Exception e) {
		}
	}
}
