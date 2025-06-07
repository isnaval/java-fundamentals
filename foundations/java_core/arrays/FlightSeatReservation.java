package java_core.arrays;

import java.util.Scanner;

public class FlightSeatReservation {
	public static final int ROWS = 6;
	public static final int COLUMNS = 4;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean[][] seats = new boolean[ROWS][COLUMNS];

		System.out.println("=== SISTEMA DE RESERVAS DE VUELO ===");
		System.out.println("Avión configurado: " + ROWS + " filas x " + COLUMNS + " asientos por fila");

		while (true) {
			showMenu();
			int option = scanner.nextInt();

			switch (option) {
			case 1:
				showSeatAvailability(seats);
				break;
			case 2:
				reserveSeat(seats, scanner);
				break;
			case 3:
				showReservationSummary(seats);
				break;
			case 4:
				System.out.println("\n¡Gracias por usar el sistema de reservas!");
				scanner.close();
				return;
			default:
				System.out.println("\n❌ Opción inválida. Seleccione del 1 al 4.\n");
			}
		}
	}

	private static void showReservationSummary(boolean[][] seats) {
		int totalSeats = ROWS * COLUMNS;
		int occupiedSeats = countOccupiedSeats(seats);
		int availableSeats = totalSeats - occupiedSeats;

		System.out.println("\n========== RESUMEN DE RESERVAS ==========");
		System.out.println("Total de asientos: " + totalSeats);
		System.out.println("Asientos ocupados: " + occupiedSeats);
		System.out.println("Asientos disponibles: " + availableSeats);
		System.out.println(
				"Porcentaje de ocupación: " + String.format("%.1f", (occupiedSeats * 100.0 / totalSeats)) + "%");
		System.out.println("=========================================");
	}

	private static int countOccupiedSeats(boolean[][] seats) {
		int count = 0;
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				if (seats[i][j]) {
					count++;
				}
			}
		}
		return count;
	}

	private static void reserveSeat(boolean[][] seats, Scanner scanner) {
		System.out.println("\n========== RESERVAR ASIENTO ==========");
		System.out.print("Ingrese la fila (1-" + ROWS + "): ");
		int row = scanner.nextInt();

		System.out.print("Ingrese la columna (1-" + COLUMNS + "): ");
		int column = scanner.nextInt();

		if (!isValidSeat(row, column)) {
			System.out.println("❌ Ubicación inválida. Coordenadas fuera de rango.");
			return;
		}

		int rowIndex = row - 1;
		int columnIndex = column - 1;

		if (seats[rowIndex][columnIndex]) {
			System.out.println("❌ El asiento " + row + "-" + column + " ya está ocupado.");
		} else {
			seats[rowIndex][columnIndex] = true;
			System.out.println("✅ ¡Asiento " + row + "-" + column + " reservado con éxito!");
		}

	}

	private static boolean isValidSeat(int row, int column) {
		return row >= 1 && row <= ROWS && column >= 1 && column <= COLUMNS;
	}

	private static void showSeatAvailability(boolean[][] seats) {
		System.out.println("\n============ DISPONIBILIDAD ============");
		System.out.println("[ ] = Libre    [X] = Ocupado");
		System.out.println();
		System.out.print("   ");
		for (int j = 1; j <= COLUMNS; j++) {
			System.out.print("  " + j + " ");
		}
		System.out.println();
		for (int i = 0; i < ROWS; i++) {
			System.out.print((i + 1) + "  ");
			for (int j = 0; j < COLUMNS; j++) {
				if (seats[i][j]) {
					System.out.print("[X] ");
				} else {
					System.out.print("[ ] ");
				}
			}
			System.out.println();
		}
		System.out.println("======================================");

	}

	private static void showMenu() {
		System.out.println("\n=============== MENÚ ===============");
		System.out.println("1. Ver disponibilidad de asientos");
		System.out.println("2. Reservar un asiento");
		System.out.println("3. Ver resumen de reservas");
		System.out.println("4. Salir del sistema");
		System.out.println("====================================");
		System.out.print("Seleccione una opción: ");
	}

}
