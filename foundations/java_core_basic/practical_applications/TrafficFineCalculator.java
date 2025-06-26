package java_core_basic.practical_applications;

import java.util.Scanner;

public class TrafficFineCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=== CALCULADORA DE MULTAS DE TRÁFICO ===");
		System.out.print("Ingrese la velocidad a la que circulaba (en km/h): ");
		int speed = scanner.nextInt();
		int fine = calculatorFine(speed);
		if (fine == 0) {
			System.out.println("OK: conducia correctamente -- sin multa");
		} else {
			System.out.println("MULTA: " + fine + " €");
		}
		scanner.close();

	}

	private static int calculatorFine(int speed) {
		if (speed <= 120) {
			return 0;
		} else if (speed >= 121 && speed <= 150) {
			return 100;
		} else if (speed >= 151 && speed <= 170) {
			return 300;
		} else if (speed >= 171 && speed <= 180) {
			return 400;
		} else if (speed >= 181 && speed <= 190) {
			return 500;
		} else {
			return 600;
		}
	}

}
