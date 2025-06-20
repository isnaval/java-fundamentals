package java_core.intermediate.exercise_Business_Applications;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class main {

	private static final double PRICE_PRODUCT_1 = 0.6;
	private static final double PRICE_PRODUCT_2 = 3.0;
	private static final double PRICE_PRODUCT_3 = 1.25;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== Sistema de Gestión de Empleados ===");
		employeeManagement(scanner);

		System.out.println("\n=== Análisis de Notas Estudiantiles ===");
		studentGradesAnalysis(scanner);

		System.out.println("\n=== Sistema de Facturación ===");
		invoiceSystem(scanner);

		scanner.close();
	}

	public static int getValidInt(Scanner scanner, String message, int min, int max) {
		int number;
		boolean validInput = false;

		do {
			System.out.print(message);
			if (scanner.hasNextInt()) {
				number = scanner.nextInt();
				scanner.nextLine(); // Limpiar buffer
				if (number >= min && number <= max) {
					validInput = true;
				} else {
					System.out.println("❌ Error: El número debe estar entre " + min + " y " + max);
					validInput = false;
				}
			} else {
				System.out.println("❌ Error: Debes introducir un número entero válido");
				scanner.next(); // Limpiar entrada inválida
				number = 0;
				validInput = false;
			}
		} while (!validInput);

		return number;
	}

	public static double getValidDouble(Scanner scanner, String message, double min, double max) {
		double number;
		boolean validInput = false;

		do {
			System.out.print(message);
			if (scanner.hasNextDouble()) {
				number = scanner.nextDouble();
				scanner.nextLine(); // Limpiar buffer
				if (number >= min && number <= max) {
					validInput = true;
				} else {
					System.out.println("❌ Error: El número debe estar entre " + min + " y " + max);
					validInput = false;
				}
			} else {
				System.out.println("❌ Error: Debes introducir un número decimal válido");
				scanner.next(); // Limpiar entrada inválida
				number = 0.0;
				validInput = false;
			}
		} while (!validInput);

		return number;
	}

	public static String getValidString(Scanner scanner, String message) {
		String input;
		boolean validInput = false;

		do {
			System.out.print(message);
			input = scanner.nextLine().trim();
			if (!input.isEmpty() && input.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
				validInput = true;
			} else {
				System.out.println("❌ Error: Debes introducir un nombre válido (solo letras)");
				validInput = false;
			}
		} while (!validInput);

		return input;
	}

	public static void employeeManagement(Scanner scanner) {
		HashMap<String, Double> salaries = new HashMap<>();
		HashMap<String, int[]> studentData = new HashMap<>();

		System.out.println("\n--- Datos de Empleados ---");
		scanner.nextLine(); // Limpiar buffer
		for (int i = 0; i < 3; i++) {
			System.out.println("Empleado " + (i + 1) + ":");

			String name = getValidString(scanner, "Nombre del empleado: ");

			double salary = getValidDouble(scanner, "Sueldo mensual (€): ", 600.0, 50000.0);

			salaries.put(name, salary);
			System.out.println("✅ Empleado registrado correctamente\n");
		}

		double totalSalary = 0;
		for (double salary : salaries.values()) {
			totalSalary += salary;
		}
		System.out.println("💰 Salario promedio: " + String.format("%.2f", (totalSalary / salaries.size())) + " €");

		System.out.println("\n--- Datos de Estudiantes ---");
		for (int i = 0; i < 3; i++) {
			System.out.println("Estudiante " + (i + 1) + ":");

			String name = getValidString(scanner, "Nombre del estudiante: ");

			int age = getValidInt(scanner, "Edad: ", 16, 99);

			int height = getValidInt(scanner, "Altura (cm): ", 120, 250);

			studentData.put(name, new int[] { age, height });
			System.out.println("✅ Estudiante registrado correctamente\n");
		}

		double totalAge = 0, totalHeight = 0;
		for (int[] data : studentData.values()) {
			totalAge += data[0];
			totalHeight += data[1];
		}

		System.out.println("📊 Edad promedio: " + String.format("%.1f", (totalAge / studentData.size())) + " años");
		System.out.println("📏 Altura promedio: " + String.format("%.1f", (totalHeight / studentData.size())) + " cm");
	}

	public static void studentGradesAnalysis(Scanner scanner) {
		List<Double> grades = new ArrayList<>();

		System.out.println("\n--- Introducir Notas ---");
		for (int i = 0; i < 6; i++) {
			double grade = getValidDouble(scanner, "Nota del alumno " + (i + 1) + " (0-10): ", 0.0, 10.0);
			grades.add(grade);
			System.out.println("✅ Nota registrada: " + grade);
		}

		int passed = 0, conditional = 0, failed = 0;

		for (double grade : grades) {
			if (grade >= 5.0) {
				passed++;
			} else if (grade >= 4.0) {
				conditional++;
			} else {
				failed++;
			}
		}

		System.out.println("\n📈 --- Análisis de Resultados ---");
		System.out.println("🟢 Aprobados: " + passed);
		System.out.println("🟡 Condicionados: " + conditional);
		System.out.println("🔴 Suspensos: " + failed);
	}

	public static void invoiceSystem(Scanner scanner) {
		double totalBilling = 0;
		int totalLiters = 0;
		int expensiveInvoices = 0;

		System.out.println("\n--- Procesamiento de Facturas ---");
		for (int i = 0; i < 5; i++) {
			System.out.println("\n🧾 --- Factura " + (i + 1) + " ---");

			int productCode = getValidInt(scanner, "Código del artículo (1/2/3): ", 1, 3);

			int liters = getValidInt(scanner, "Cantidad en litros: ", 1, 10000);

			double unitPrice = 0;
			String productName = "";

			switch (productCode) {
			case 1:
				unitPrice = PRICE_PRODUCT_1;
				productName = "Producto Básico";
				break;
			case 2:
				unitPrice = PRICE_PRODUCT_2;
				productName = "Producto Premium";
				break;
			case 3:
				unitPrice = PRICE_PRODUCT_3;
				productName = "Producto Estándar";
				break;
			}

			double invoiceTotal = liters * unitPrice;
			totalBilling += invoiceTotal;
			totalLiters += liters;

			if (invoiceTotal > 600) {
				expensiveInvoices++;
			}

			System.out.println("📦 Producto: " + productName + " (€" + unitPrice + "/l)");
			System.out.println("💶 Total factura: " + String.format("%.2f", invoiceTotal) + " €");

			if (invoiceTotal > 600) {
				System.out.println("💎 ¡Factura de alto valor!");
			}
		}

		System.out.println("\n💼 --- Resumen de Facturación ---");
		System.out.println("💰 Facturación total: " + String.format("%.2f", totalBilling) + " €");
		System.out.println("🛢️ Litros totales: " + totalLiters + " l");
		System.out
				.println("📊 Precio medio por litro: " + String.format("%.2f", (totalBilling / totalLiters)) + " €/l");
		System.out.println("💎 Facturas > 600€: " + expensiveInvoices);
	}
}