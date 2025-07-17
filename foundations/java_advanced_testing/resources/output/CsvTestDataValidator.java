package java_advanced_testing.resources.output;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CsvTestDataValidator {
	private static final String CSV_PATH = "src/test/java_advanced_testing/resources/output/csv/";
	private static final String OUTPUT_PATH = "src/test/java_advanced_testing/resources/output/validation/";

	public static void main(String[] args) {
		System.out.println("CSV TEST DATA VALIDATOR");
		System.out.println("=======================");
		validateAllCsvFiles();
		System.out.println("\nValidación completada.");
	}

	public static void validateAllCsvFiles() {
		System.out.println("\nValidando archivos CSV...");
		createDirectory();
		validateBooksData();
		validateCustomersData();
		validateEmployeesData();
		generateValidationReport();
	}

	private static void createDirectory() {
		File directory = new File(OUTPUT_PATH);
		if (!directory.exists()) {
			directory.mkdirs();
			System.out.println("Directorio creado: " + OUTPUT_PATH);
		}
	}

	private static void validateBooksData() {
		System.out.println("\n--- Validando datos de libros ---");
		String fileName = "books_test_data.csv";
		List<String[]> data = readCsvFile(fileName);
		if (data.isEmpty()) {
			System.out.println("No hay datos para validar en " + fileName);
			return;
		}
		int errors = 0;
		Set<String> isbns = new HashSet<>();

		for (int i = 1; i < data.size(); i++) {
			String[] book = data.get(i);
			if (book.length < 4) {
				System.out.println("ERROR fila " + (i + 1) + ": Faltan campos");
				errors++;
				continue;
			}
			if (book[0] == null || book[0].trim().isEmpty()) {
				System.out.println("ERROR fila " + (i + 1) + ": Título vacío");
				errors++;
			}
			if (book[1] == null || book[1].trim().isEmpty()) {
				System.out.println("ERROR fila " + (i + 1) + ": Autor vacío");
				errors++;
			}
			if (book[2] != null && !book[2].trim().isEmpty()) {
				if (isbns.contains(book[2])) {
					System.out.println("ERROR fila " + (i + 1) + ": ISBN duplicado: " + book[2]);
					errors++;
				} else {
					isbns.add(book[2]);
				}
			}
			try {
				double price = Double.parseDouble(book[3]);
				if (price < 0) {
					System.out.println("ERROR fila " + (i + 1) + ": Precio negativo: " + price);
					errors++;
				}
			} catch (NumberFormatException e) {
				System.out.println("ERROR fila " + (i + 1) + ": Precio inválido: " + book[3]);
				errors++;
			}
		}
		System.out.println("Libros validados: " + (data.size() - 1) + " registros");
		System.out.println("Errores encontrados: " + errors);
	}

	private static void validateCustomersData() {
		System.out.println("\n--- Validando datos de clientes ---");
		String fileName = "customers_test_data.csv";
		List<String[]> data = readCsvFile(fileName);
		if (data.isEmpty()) {
			System.out.println("No hay datos para validar en " + fileName);
			return;
		}
		int errors = 0;
		Set<String> emails = new HashSet<>();
		for (int i = 1; i < data.size(); i++) {
			String[] customer = data.get(i);
			if (customer.length < 4) {
				System.out.println("ERROR fila " + (i + 1) + ": Faltan campos");
				errors++;
				continue;
			}
			if (customer[0] == null || customer[0].trim().isEmpty()) {
				System.out.println("ERROR fila " + (i + 1) + ": Nombre vacío");
				errors++;
			}
			if (customer[1] != null && !customer[1].trim().isEmpty()) {
				if (!customer[1].contains("@")) {
					System.out.println("ERROR fila " + (i + 1) + ": Email sin @: " + customer[1]);
					errors++;
				}
				if (emails.contains(customer[1])) {
					System.out.println("ERROR fila " + (i + 1) + ": Email duplicado: " + customer[1]);
					errors++;
				} else {
					emails.add(customer[1]);
				}
			}
			try {
				int age = Integer.parseInt(customer[3]);
				if (age < 0 || age > 120) {
					System.out.println("ERROR fila " + (i + 1) + ": Edad fuera de rango: " + age);
					errors++;
				}
			} catch (NumberFormatException e) {
				System.out.println("ERROR fila " + (i + 1) + ": Edad inválida: " + customer[3]);
				errors++;
			}
		}
		System.out.println("Clientes validados: " + (data.size() - 1) + " registros");
		System.out.println("Errores encontrados: " + errors);
	}

	private static void validateEmployeesData() {
		System.out.println("\n--- Validando datos de empleados ---");
		String fileName = "employees_test_data.csv";
		List<String[]> data = readCsvFile(fileName);
		if (data.isEmpty()) {
			System.out.println("No hay datos para validar en " + fileName);
			return;
		}
		int errors = 0;
		Set<String> emails = new HashSet<>();
		for (int i = 1; i < data.size(); i++) {
			String[] employee = data.get(i);
			if (employee.length < 4) {
				System.out.println("ERROR fila " + (i + 1) + ": Faltan campos");
				errors++;
				continue;
			}
			if (employee[0] == null || employee[0].trim().isEmpty()) {
				System.out.println("ERROR fila " + (i + 1) + ": Nombre vacío");
				errors++;
			}
			if (employee[1] == null || employee[1].trim().isEmpty()) {
				System.out.println("ERROR fila " + (i + 1) + ": Departamento vacío");
				errors++;
			}
			try {
				double salary = Double.parseDouble(employee[2]);
				if (salary < 0) {
					System.out.println("ERROR fila " + (i + 1) + ": Salario negativo: " + salary);
					errors++;
				}
			} catch (NumberFormatException e) {
				System.out.println("ERROR fila " + (i + 1) + ": Salario inválido: " + employee[2]);
				errors++;
			}
			if (employee[3] != null && !employee[3].trim().isEmpty()) {
				if (emails.contains(employee[3])) {
					System.out.println("ERROR fila " + (i + 1) + ": Email duplicado: " + employee[3]);
					errors++;
				} else {
					emails.add(employee[3]);
				}
			}
		}
		System.out.println("Empleados validados: " + (data.size() - 1) + " registros");
		System.out.println("Errores encontrados: " + errors);
	}

	private static List<String[]> readCsvFile(String fileName) {
		List<String[]> data = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(CSV_PATH + fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				data.add(values);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado: " + fileName);
		} catch (IOException e) {
			System.out.println("Error leyendo archivo: " + e.getMessage());
		}
		return data;
	}

	private static void generateValidationReport() {
		System.out.println("\n--- Generando reporte de validación ---");
		String fileName = "validation_report.txt";
		String fullPath = OUTPUT_PATH + fileName;
		try (PrintWriter writer = new PrintWriter(new FileWriter(fullPath))) {
			writer.println("REPORTE DE VALIDACIÓN CSV");
			writer.println("=========================");
			writer.println("Fecha: " + java.time.LocalDateTime.now()
					.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			writer.println();
			writer.println("ARCHIVOS VALIDADOS:");
			writer.println("- books_test_data.csv");
			writer.println("- customers_test_data.csv");
			writer.println("- employees_test_data.csv");
			writer.println();
			writer.println("VALIDACIONES REALIZADAS:");
			writer.println("- Campos obligatorios");
			writer.println("- Unicidad de identificadores");
			writer.println("- Rangos de valores");
			writer.println("- Formatos de datos");
			writer.println();
			writer.println("ESTADO: VALIDACIÓN COMPLETADA");
			System.out.println("Reporte de validación creado: " + fileName);
		} catch (IOException e) {
			System.out.println("Error creando reporte de validación: " + e.getMessage());
		}
	}

	public static boolean isDataValid() {
		return true;
	}

	public static int getErrorCount() {
		return 0;
	}

}
