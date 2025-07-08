package java_core.conditionals.advanced;

import java.util.Scanner;

public class SpeedTicketCalculator {

	private static final int ZONE_SCHOOL = 30;
	private static final int ZONE_RESIDENTIAL = 50;
	private static final int ZONE_URBAN = 60;
	private static final int ZONE_HIGHWAY = 120;

	private static final double FACTOR_RAIN = 1.25;
	private static final double FACTOR_NIGHT = 1.15;
	private static final double FACTOR_CONSTRUCTION = 2.0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== CALCULADORA DE MULTAS DE TRÁFICO ===");
		System.out.println("Sistema automatizado de cálculo de sanciones\n");

		System.out.println("Tipo de zona:");
		System.out.println("1. Zona escolar (30 km/h)");
		System.out.println("2. Zona residencial (50 km/h)");
		System.out.println("3. Zona urbana (60 km/h)");
		System.out.println("4. Autopista (120 km/h)");
		System.out.print("Seleccione zona (1-4): ");
		int zoneType = scanner.nextInt();

		System.out.print("\nVelocidad registrada (km/h): ");
		int recordedSpeed = scanner.nextInt();
		scanner.nextLine();

		System.out.print("\n¿Estaba lloviendo? (s/n): ");
		boolean raining = scanner.nextLine().equalsIgnoreCase("s");
		System.out.print("¿Era de noche? (s/n): ");
		boolean night = scanner.nextLine().equalsIgnoreCase("s");
		System.out.print("¿Zona en construcción? (s/n): ");
		boolean construction = scanner.nextLine().equalsIgnoreCase("s");
		System.out.print("¿Es reincidente? (s/n): ");
		boolean repeat = scanner.nextLine().equalsIgnoreCase("s");

		int speedLimit = 0;
		String zoneName = "";

		switch (zoneType) {
		case 1:
			speedLimit = ZONE_SCHOOL;
			zoneName = "Zona Escolar";
			break;
		case 2:
			speedLimit = ZONE_RESIDENTIAL;
			zoneName = "Zona Residencial";
			break;
		case 3:
			speedLimit = ZONE_URBAN;
			zoneName = "Zona Urbana";
			break;
		case 4:
			speedLimit = ZONE_HIGHWAY;
			zoneName = "Autopista";
			break;
		default:
			System.out.println("Zona no válida");
			scanner.close();
			return;
		}

		int speedExcess = recordedSpeed - speedLimit;

		System.out.println("\n=== INFORME DE INFRACCIÓN ===");
		System.out.println("Zona: " + zoneName);
		System.out.println("Límite: " + speedLimit + " km/h");
		System.out.println("Velocidad registrada: " + recordedSpeed + " km/h");

		if (speedExcess <= 0) {
			System.out.println("\n✓ No hay infracción");
			System.out.println("Velocidad dentro del límite permitido");
		} else {
			System.out.println("Exceso: " + speedExcess + " km/h");

			double fine = calculateBaseFine(speedExcess, speedLimit);

			System.out.println("\n--- Factores aplicados ---");

			if (raining) {
				fine *= FACTOR_RAIN;
				System.out.println("• Lluvia: +25%");
			}

			if (night) {
				fine *= FACTOR_NIGHT;
				System.out.println("• Nocturnidad: +15%");
			}

			if (construction) {
				fine *= FACTOR_CONSTRUCTION;
				System.out.println("• Zona en construcción: x2");
			}

			if (repeat) {
				fine *= 1.5;
				System.out.println("• Reincidencia: +50%");
			}

			String severity = "";
			int points = 0;
			boolean suspension = false;

			double percentExcess = (speedExcess * 100.0) / speedLimit;

			if (percentExcess <= 20) {
				severity = "LEVE";
				points = 0;
			} else if (percentExcess <= 40) {
				severity = "GRAVE";
				points = 4;
			} else if (percentExcess <= 60) {
				severity = "MUY GRAVE";
				points = 6;
				suspension = true;
			} else {
				severity = "DELITO";
				points = 6;
				suspension = true;
			}

			System.out.println("\n=== RESOLUCIÓN ===");
			System.out.println("Clasificación: " + severity);
			System.out.println("Multa económica: " + String.format("%.2f", fine) + " €");
			System.out.println("Puntos a deducir: " + points);

			if (suspension) {
				System.out.println("\n⚠️  SUSPENSIÓN DE LICENCIA");
				if (percentExcess > 60) {
					System.out.println("Duración: 6 meses");
					System.out.println("Posible proceso penal");
				} else {
					System.out.println("Duración: 3 meses");
				}
			}

			System.out.println("\n--- Opciones de pago ---");
			System.out.println("Pronto pago (50% descuento): " + String.format("%.2f", fine * 0.5) + " €");
			System.out.println("Pago normal (30 días): " + String.format("%.2f", fine) + " €");
			System.out.println("Pago tardío (+20% recargo): " + String.format("%.2f", fine * 1.2) + " €");
		}

		scanner.close();
	}

	private static double calculateBaseFine(int excess, int limit) {
		double fine = 0;

		if (excess <= 10) {
			fine = 100;
		} else if (excess <= 20) {
			fine = 200;
		} else if (excess <= 30) {
			fine = 300;
		} else if (excess <= 40) {
			fine = 400;
		} else if (excess <= 50) {
			fine = 500;
		} else {
			fine = 500 + (excess - 50) * 10;
		}

		if (limit == ZONE_SCHOOL) {
			fine *= 2.0;
		} else if (limit == ZONE_RESIDENTIAL) {
			fine *= 1.5;
		}

		return fine;
	}
}