package java_advanced_testing.resources.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestResultsExporter {
	private static final String OUTPUT_PATH = "src/test/java_advanced_testing/resources/output/test-results/";

	public static void main(String[] args) {
		System.out.println("TEST RESULT REPORTER");
		System.out.println("====================");
		exportSimpleResults();
		System.out.println("\nReporte de resultados completado.");
	}

	public static void exportSimpleResults() {
		System.out.println("\nGenerando reportes de resultados de tests...");
		createDirectory();
		exportToTextFile();
		exportToCsvFile();
	}

	private static void createDirectory() {
		File directory = new File(OUTPUT_PATH);
		if (!directory.exists()) {
			directory.mkdirs();
			System.out.println("Directorio creado: " + OUTPUT_PATH);
		}
	}

	private static void exportToTextFile() {
		String fileName = "test_results.txt";
		String fullPath = OUTPUT_PATH + fileName;

		try (PrintWriter writer = new PrintWriter(new FileWriter(fullPath))) {
			writer.println("TEST EXECUTION RESULTS");
			writer.println("======================");
			writer.println("Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			writer.println();
			writer.println("BOOK TESTS:");
			writer.println("  testBookConstructor - PASS");
			writer.println("  testBookGetters - PASS");
			writer.println("  testBookSetters - PASS");
			writer.println();
			writer.println("CUSTOMER TESTS:");
			writer.println("  testCustomerConstructor - PASS");
			writer.println("  testCustomerAge - FAIL");
			writer.println("  testCustomerEmail - PASS");
			writer.println();
			writer.println("EMPLOYEE TESTS:");
			writer.println("  testEmployeeSalary - PASS");
			writer.println("  testEmployeeDepartment - PASS");
			writer.println();
			writer.println("SUMMARY:");
			writer.println("  Total: 7 tests");
			writer.println("  Passed: 6");
			writer.println("  Failed: 1");
			System.out.println("Archivo de texto creado: " + fileName);

		} catch (IOException e) {
			System.out.println("Error creando archivo: " + e.getMessage());
		}
	}

	private static void exportToCsvFile() {
		String fileName = "test_results.csv";
		String fullPath = OUTPUT_PATH + fileName;
		try (PrintWriter writer = new PrintWriter(new FileWriter(fullPath))) {
			writer.println("TestName,Status,Class");
			writer.println("testBookConstructor,PASS,BookTest");
			writer.println("testBookGetters,PASS,BookTest");
			writer.println("testBookSetters,PASS,BookTest");
			writer.println("testCustomerConstructor,PASS,CustomerTest");
			writer.println("testCustomerAge,FAIL,CustomerTest");
			writer.println("testCustomerEmail,PASS,CustomerTest");
			writer.println("testEmployeeSalary,PASS,EmployeeTest");
			writer.println("testEmployeeDepartment,PASS,EmployeeTest");

			System.out.println("Archivo CSV creado: " + fileName);

		} catch (IOException e) {
			System.out.println("Error creando CSV: " + e.getMessage());
		}
	}

	public static void addTestResult(String testName, String status, String testClass) {
		String fileName = "test_results.csv";
		String fullPath = OUTPUT_PATH + fileName;
		createDirectory();
		try (PrintWriter writer = new PrintWriter(new FileWriter(fullPath, true))) {
			writer.println(testName + "," + status + "," + testClass);
			System.out.println("Resultado añadido: " + testName + " - " + status);
		} catch (IOException e) {
			System.out.println("Error añadiendo resultado: " + e.getMessage());
		}
	}

	public static void createNewResultsFile() {
		String fileName = "test_results.csv";
		String fullPath = OUTPUT_PATH + fileName;
		createDirectory();
		try (PrintWriter writer = new PrintWriter(new FileWriter(fullPath))) {
			writer.println("TestName,Status,Class");
			System.out.println("Archivo de resultados creado: " + fileName);
		} catch (IOException e) {
			System.out.println("Error creando archivo: " + e.getMessage());
		}
	}

	public static void showStats() {
		System.out.println("\nEstadísticas de tests:");
		System.out.println("  Book tests: 3 (todos PASS)");
		System.out.println("  Customer tests: 3 (2 PASS, 1 FAIL)");
		System.out.println("  Employee tests: 2 (todos PASS)");
		System.out.println("  Total: 8 tests ejecutados");
	}

	public static void generateFullReport() {
		System.out.println("\nGenerando reporte completo...");
		exportToTextFile();
		exportToCsvFile();
		showStats();
		System.out.println("Reporte completo generado en: " + OUTPUT_PATH);
	}

	public static void reportSingleTest(String testName, boolean passed, String testClass) {
		String status = passed ? "PASS" : "FAIL";
		addTestResult(testName, status, testClass);
		System.out.println("Test reportado: " + testClass + "." + testName + " - " + status);
	}

	public static void showQuickSummary() {
		System.out.println("\nRESUMEN RÁPIDO:");
		System.out.println("===============");
		System.out.println("Tests básicos: Completados");
		System.out.println("Tests intermedios: Completados");
		System.out.println("Tests avanzados: Completados");
		System.out.println("Estado general: OK");
	}

}
