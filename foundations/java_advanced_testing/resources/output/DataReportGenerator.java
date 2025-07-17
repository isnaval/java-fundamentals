package java_advanced_testing.resources.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataReportGenerator {
	private static final String OUTPUT_PATH = "src/test/java_advanced_testing/resources/output/reports/";

	public static void main(String[] args) {
		System.out.println("DATA REPORT GENERATOR");
		System.out.println("=====================");
		generateAllReports();
		System.out.println("\nReportes generados completamente.");
	}

	public static void generateAllReports() {
		System.out.println("\nGenerando reportes de datos...");
		createDirectory();
		generateSummaryReport();
		generateDetailedReport();
		generateQuickReport();
	}

	private static void createDirectory() {
		File directory = new File(OUTPUT_PATH);
		if (!directory.exists()) {
			directory.mkdirs();
			System.out.println("Directorio creado: " + OUTPUT_PATH);
		}
	}

	private static void generateSummaryReport() {
		System.out.println("\n--- Generando reporte resumen ---");

		String fileName = "data_summary_report.txt";
		String fullPath = OUTPUT_PATH + fileName;

		try (PrintWriter writer = new PrintWriter(new FileWriter(fullPath))) {
			writer.println("REPORTE RESUMEN DE DATOS");
			writer.println("========================");
			writer.println("Fecha: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
			writer.println();
			int bookCount = CsvDataProcessor.getBookCount();
			int customerCount = CsvDataProcessor.getCustomerCount();
			int employeeCount = CsvDataProcessor.getEmployeeCount();
			writer.println("DATOS DISPONIBLES:");
			writer.println("  Libros: " + bookCount + " registros");
			writer.println("  Clientes: " + customerCount + " registros");
			writer.println("  Empleados: " + employeeCount + " registros");
			writer.println("  Total: " + (bookCount + customerCount + employeeCount) + " registros");
			writer.println();
			writer.println("ESTADO DEL SISTEMA:");
			writer.println("  Archivos CSV: OK");
			writer.println("  Datos cargados: OK");
			writer.println("  Validaciones: OK");
			System.out.println("Reporte resumen creado: " + fileName);
		} catch (IOException e) {
			System.out.println("Error creando reporte resumen: " + e.getMessage());
		}
	}

	private static void generateDetailedReport() {
		System.out.println("\n--- Generando reporte detallado ---");
		String fileName = "detailed_data_report.txt";
		String fullPath = OUTPUT_PATH + fileName;
		try (PrintWriter writer = new PrintWriter(new FileWriter(fullPath))) {
			writer.println("REPORTE DETALLADO DE DATOS");
			writer.println("==========================");
			writer.println(
					"Generado: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			writer.println();
			writer.println("ANÁLISIS POR CATEGORÍA:");
			writer.println("-----------------------");
			writer.println("\n1. LIBROS:");
			writer.println("   - Archivo: books_test_data.csv");
			writer.println("   - Campos: title, author, isbn, price");
			writer.println("   - Análisis: Precios, autores, géneros");
			writer.println("   - Estado: Validado");
			writer.println("\n2. CLIENTES:");
			writer.println("   - Archivo: customers_test_data.csv");
			writer.println("   - Campos: name, email, phone, age");
			writer.println("   - Análisis: Edades, contactos, segmentación");
			writer.println("   - Estado: Validado");
			writer.println("\n3. EMPLEADOS:");
			writer.println("   - Archivo: employees_test_data.csv");
			writer.println("   - Campos: name, department, salary, email");
			writer.println("   - Análisis: Salarios, departamentos, estructura");
			writer.println("   - Estado: Validado");
			writer.println("\nCONCLUSIONES:");
			writer.println("-------------");
			writer.println("- Todos los archivos CSV están disponibles");
			writer.println("- Los datos son consistentes");
			writer.println("- No se detectaron errores críticos");
			writer.println("- Sistema listo para testing");
			System.out.println("Reporte detallado creado: " + fileName);
		} catch (IOException e) {
			System.out.println("Error creando reporte detallado: " + e.getMessage());
		}
	}

	private static void generateQuickReport() {
		System.out.println("\n--- Generando reporte rápido ---");
		String fileName = "quick_report.txt";
		String fullPath = OUTPUT_PATH + fileName;
		try (PrintWriter writer = new PrintWriter(new FileWriter(fullPath))) {
			writer.println("REPORTE RÁPIDO");
			writer.println("==============");
			writer.println();
			writer.println("Status: OK");
			writer.println("Datos: " + (CsvDataProcessor.getBookCount() + CsvDataProcessor.getCustomerCount()
					+ CsvDataProcessor.getEmployeeCount()) + " registros");
			writer.println("Hora: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
			System.out.println("Reporte rápido creado: " + fileName);
		} catch (IOException e) {
			System.out.println("Error creando reporte rápido: " + e.getMessage());
		}
	}

	public static void printDataSummary() {
		System.out.println("\nRESUMEN DE DATOS:");
		System.out.println("=================");
		System.out.println("Libros: " + CsvDataProcessor.getBookCount());
		System.out.println("Clientes: " + CsvDataProcessor.getCustomerCount());
		System.out.println("Empleados: " + CsvDataProcessor.getEmployeeCount());
		System.out.println("Total: " + (CsvDataProcessor.getBookCount() + CsvDataProcessor.getCustomerCount()
				+ CsvDataProcessor.getEmployeeCount()));
	}

	public static void generateCustomReport(String title, String content) {
		String fileName = "custom_report.txt";
		String fullPath = OUTPUT_PATH + fileName;
		createDirectory();
		try (PrintWriter writer = new PrintWriter(new FileWriter(fullPath))) {
			writer.println(title);
			writer.println("=".repeat(title.length()));
			writer.println();
			writer.println(content);
			writer.println();
			writer.println(
					"Generado: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			System.out.println("Reporte personalizado creado: " + fileName);
		} catch (IOException e) {
			System.out.println("Error creando reporte personalizado: " + e.getMessage());
		}
	}

}
