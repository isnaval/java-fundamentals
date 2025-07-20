package java_advanced_testing.resources.output;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CsvDataProcessor {

	private static final String CSV_PATH = "src/test/java_advanced_testing/resources/output/csv/";

	public static void main(String[] args) {
		System.out.println("CSV DATA PROCESSOR");
		System.out.println("==================");

		processAllCsvFiles();
	}

	public static void processAllCsvFiles() {
		System.out.println("\nProcesando todos los archivos CSV...\n");
		processBooksData();
		processCustomersData();
		processEmployeesData();
		System.out.println("Procesamiento de CSVs completado.");
	}

	public static void processBooksData() {
		System.out.println("--- PROCESANDO BOOKS DATA ---");
		String fileName = "books_test_data.csv";
		List<String[]> bookData = readCsvFile(fileName);
		if (bookData.isEmpty()) {
			System.out.println("No se encontraron datos en " + fileName);
			return;
		}
		System.out.println("Total de libros: " + (bookData.size() - 1)); // -1 por header
		if (bookData.size() > 1) {
			analyzeBookData(bookData);
		}
		System.out.println();
	}

	public static void processCustomersData() {
		System.out.println("--- PROCESANDO CUSTOMERS DATA ---");
		String fileName = "customers_test_data.csv";
		List<String[]> customerData = readCsvFile(fileName);
		if (customerData.isEmpty()) {
			System.out.println("No se encontraron datos en " + fileName);
			return;
		}
		System.out.println("Total de clientes: " + (customerData.size() - 1)); // -1 por header
		if (customerData.size() > 1) {
			analyzeCustomerData(customerData);
		}
		System.out.println();
	}

	public static void processEmployeesData() {
		System.out.println("--- PROCESANDO EMPLOYEES DATA ---");
		String fileName = "employees_test_data.csv";
		List<String[]> employeeData = readCsvFile(fileName);
		if (employeeData.isEmpty()) {
			System.out.println("No se encontraron datos en " + fileName);
			return;
		}
		System.out.println("Total de empleados: " + (employeeData.size() - 1)); // -1 por header
		if (employeeData.size() > 1) {
			analyzeEmployeeData(employeeData);
		}
		System.out.println();
	}

	private static List<String[]> readCsvFile(String fileName) {
		List<String[]> data = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(CSV_PATH + fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				data.add(values);
			}
			System.out.println("Archivo leído exitosamente: " + fileName);
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado: " + fileName);
			System.out.println("Creando datos de ejemplo...");
			createSampleCsvFile(fileName);
			return readCsvFile(fileName);
		} catch (IOException e) {
			System.out.println("Error leyendo archivo: " + e.getMessage());
		}
		return data;
	}

	private static void createSampleCsvFile(String fileName) {
		File directory = new File(CSV_PATH);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_PATH + fileName))) {
			switch (fileName) {
			case "books_test_data.csv":
				writer.println("title,author,isbn,price");
				writer.println("El Quijote,Miguel de Cervantes,978-84-376-0494-7,15.99");
				writer.println("Cien años de soledad,Gabriel García Márquez,978-84-376-0495-8,22.50");
				writer.println("1984,George Orwell,978-84-376-0496-9,18.75");
				break;
			case "customers_test_data.csv":
				writer.println("name,email,phone,age");
				writer.println("Juan Pérez,juan.perez@email.com,+34 600 123 456,30");
				writer.println("María García,maria.garcia@email.com,+34 600 234 567,25");
				writer.println("Carlos López,carlos.lopez@email.com,+34 600 345 678,45");
				break;
			case "employees_test_data.csv":
				writer.println("name,department,salary,email");
				writer.println("Ana García,IT,35000.0,ana.garcia@company.com");
				writer.println("Pedro Martín,Sales,40000.0,pedro.martin@company.com");
				writer.println("Laura Sánchez,HR,38000.0,laura.sanchez@company.com");
				break;
			}
			System.out.println("Archivo de ejemplo creado: " + fileName);
		} catch (IOException e) {
			System.out.println("Error creando archivo de ejemplo: " + e.getMessage());
		}
	}

	private static void analyzeBookData(List<String[]> data) {
		double totalPrice = 0.0;
		double minPrice = Double.MAX_VALUE;
		double maxPrice = Double.MIN_VALUE;
		int validBooks = 0;
		for (int i = 1; i < data.size(); i++) {
			String[] book = data.get(i);

			if (book.length >= 4) {
				try {
					double price = Double.parseDouble(book[3]);
					totalPrice += price;
					minPrice = Math.min(minPrice, price);
					maxPrice = Math.max(maxPrice, price);
					validBooks++;
				} catch (NumberFormatException e) {
					System.out.println("Precio inválido en fila " + i + ": " + book[3]);
				}
			}
		}
		if (validBooks > 0) {
			System.out.println("Libros válidos: " + validBooks);
			System.out.println("Precio promedio: " + (totalPrice / validBooks));
			System.out.println("Precio mínimo: " + minPrice);
			System.out.println("Precio máximo: " + maxPrice);
		}
	}

	private static void analyzeCustomerData(List<String[]> data) {
		int totalAge = 0;
		int minAge = Integer.MAX_VALUE;
		int maxAge = Integer.MIN_VALUE;
		int validCustomers = 0;
		int minors = 0;
		int seniors = 0;
		for (int i = 1; i < data.size(); i++) {
			String[] customer = data.get(i);

			if (customer.length >= 4) {
				try {
					int age = Integer.parseInt(customer[3]);
					totalAge += age;
					minAge = Math.min(minAge, age);
					maxAge = Math.max(maxAge, age);
					validCustomers++;

					if (age < 18)
						minors++;
					if (age >= 65)
						seniors++;
				} catch (NumberFormatException e) {
					System.out.println("Edad inválida en fila " + i + ": " + customer[3]);
				}
			}
		}

		if (validCustomers > 0) {
			System.out.println("Clientes válidos: " + validCustomers);
			System.out.println("Edad promedio: " + (totalAge / validCustomers));
			System.out.println("Edad mínima: " + minAge);
			System.out.println("Edad máxima: " + maxAge);
			System.out.println("Menores de edad: " + minors);
			System.out.println("Seniors (65+): " + seniors);
		}
	}

	private static void analyzeEmployeeData(List<String[]> data) {
		double totalSalary = 0.0;
		double minSalary = Double.MAX_VALUE;
		double maxSalary = Double.MIN_VALUE;
		int validEmployees = 0;
		int itEmployees = 0;
		int salesEmployees = 0;
		int hrEmployees = 0;
		for (int i = 1; i < data.size(); i++) {
			String[] employee = data.get(i);

			if (employee.length >= 4) {
				try {
					double salary = Double.parseDouble(employee[2]);
					totalSalary += salary;
					minSalary = Math.min(minSalary, salary);
					maxSalary = Math.max(maxSalary, salary);
					validEmployees++;
					String department = employee[1].toLowerCase();
					switch (department) {
					case "it":
						itEmployees++;
						break;
					case "sales":
						salesEmployees++;
						break;
					case "hr":
						hrEmployees++;
						break;
					}
				} catch (NumberFormatException e) {
					System.out.println("Salario inválido en fila " + i + ": " + employee[2]);
				}
			}
		}

		if (validEmployees > 0) {
			System.out.println("Empleados válidos: " + validEmployees);
			System.out.println("Salario promedio: " + (totalSalary / validEmployees));
			System.out.println("Salario mínimo: " + minSalary);
			System.out.println("Salario máximo: " + maxSalary);
			System.out.println("Departamento IT: " + itEmployees);
			System.out.println("Departamento Sales: " + salesEmployees);
			System.out.println("Departamento HR: " + hrEmployees);
		}
	}

	public static int getBookCount() {
		List<String[]> data = readCsvFile("books_test_data.csv");
		return Math.max(0, data.size() - 1); // -1 por header
	}

	public static int getCustomerCount() {
		List<String[]> data = readCsvFile("customers_test_data.csv");
		return Math.max(0, data.size() - 1); // -1 por header
	}

	public static int getEmployeeCount() {
		List<String[]> data = readCsvFile("employees_test_data.csv");
		return Math.max(0, data.size() - 1); // -1 por header

	}

}
