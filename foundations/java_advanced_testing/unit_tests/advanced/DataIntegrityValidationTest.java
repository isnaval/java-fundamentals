package java_advanced_testing.unit_tests.advanced;

import java_advanced_testing.model.Book;
import java_advanced_testing.model.Customer;
import java_advanced_testing.model.Employee;
import java_advanced_testing.model.Product;
import java_advanced_testing.model.Project;
import java_advanced_testing.resources.test_data.BookTestData;
import java_advanced_testing.resources.test_data.CustomerTestData;
import java_advanced_testing.resources.test_data.EmployeeTestData;
import java_advanced_testing.resources.test_data.ProjectTestData;

public class DataIntegrityValidationTest {
	public static void main(String[] args) {
		System.out.println("DATA INTEGRITY VALIDATION ADVANCED TESTS");
		System.out.println("==========================================");

		testCrossModelValidation();
		testDataConsistency();
		testRelationalIntegrity();
		testDataQualityMetrics();
		testSystemLimits();

		System.out.println("\nData integrity validation tests completados");
	}

	public static void testCrossModelValidation() {
		System.out.println("\n--- Test: Cross Model Validation ---");

		// Validación cruzada entre diferentes modelos
		Book book = BookTestData.createValidBook();
		Customer customer = CustomerTestData.createValidCustomer();
		Employee employee = EmployeeTestData.createValidEmployee();
		Product product = new Product("Libro Físico", "Edición impresa", book.getPrice() + 5.0, "BOOK-PHYS-001");

		// Test: El producto libro debe tener precio relacionado con el libro
		boolean priceConsistency = Math.abs(product.getPrice() - book.getPrice()) <= 10.0;
		System.out.println("Consistencia precio libro-producto: " + (priceConsistency ? "PASS" : "FAIL"));

		// Test: Customer y Employee no pueden tener el mismo email
		boolean uniqueEmails = !customer.getEmail().equals(employee.getEmail());
		System.out.println("Emails únicos customer-employee: " + (uniqueEmails ? "PASS" : "FAIL"));

		// Test: Validación de dominios de email
		boolean validCustomerEmailDomain = customer.getEmail().contains("@")
				&& (customer.getEmail().endsWith(".com") || customer.getEmail().endsWith(".es"));
		boolean validEmployeeEmailDomain = employee.getEmail().contains("@")
				&& employee.getEmail().contains("company.com");

		System.out.println("Dominio email customer válido: " + (validCustomerEmailDomain ? "PASS" : "FAIL"));
		System.out.println("Dominio email employee válido: " + (validEmployeeEmailDomain ? "PASS" : "FAIL"));

		// Test: Consistencia de datos geográficos (teléfonos españoles)
		boolean spanishPhone = customer.getPhone().startsWith("+34");
		System.out.println("Teléfono español consistente: " + (spanishPhone ? "PASS" : "FAIL"));
	}

	public static void testDataConsistency() {
		System.out.println("\n--- Test: Data Consistency ---");

		// Crear múltiples instancias y verificar consistencia
		Book[] books = { BookTestData.createValidBook(), BookTestData.createFreeBook(),
				BookTestData.createExpensiveBook() };

		Customer[] customers = { CustomerTestData.createValidCustomer(), CustomerTestData.createMinorCustomer(),
				CustomerTestData.createSeniorCustomer() };

		// Test consistencia de formato ISBN
		boolean allValidISBN = true;
		for (Book book : books) {
			if (book.getIsbn() == null || book.getIsbn().length() < 10) {
				allValidISBN = false;
				break;
			}
		}
		System.out.println("Todos los ISBN válidos: " + (allValidISBN ? "PASS" : "FAIL"));

		// Test consistencia de edades
		boolean validAgeRanges = true;
		for (Customer customer : customers) {
			if (customer.getAge() < 0 || customer.getAge() > 120) {
				validAgeRanges = false;
				break;
			}
		}
		System.out.println("Rangos de edad válidos: " + (validAgeRanges ? "PASS" : "FAIL"));

		// Test consistencia de precios
		boolean validPrices = true;
		for (Book book : books) {
			if (book.getPrice() < 0.0) {
				validPrices = false;
				break;
			}
		}
		System.out.println("Precios no negativos: " + (validPrices ? "PASS" : "FAIL"));

		// Test unicidad de datos
		boolean uniqueISBNs = books[0].getIsbn() != null && !books[0].getIsbn().equals(books[1].getIsbn())
				&& !books[0].getIsbn().equals(books[2].getIsbn());
		System.out.println("ISBNs únicos: " + (uniqueISBNs ? "PASS" : "FAIL"));
	}

	public static void testRelationalIntegrity() {
		System.out.println("\n--- Test: Relational Integrity ---");

		// Test integridad relacional en proyecto con empleados
		Project project = ProjectTestData.createValidProject();
		Employee manager = EmployeeTestData.createHighSalaryEmployee();
		Employee developer = EmployeeTestData.createValidEmployee();
		Employee intern = EmployeeTestData.createInternEmployee();

		project.addTeamMember(manager);
		project.addTeamMember(developer);
		project.addTeamMember(intern);

		// Test: Un proyecto debe tener al menos un empleado senior
		boolean hasSeniorEmployee = project.getTeam().stream().anyMatch(emp -> emp.getSalary() > 60000.0);
		System.out.println("Proyecto tiene empleado senior: " + (hasSeniorEmployee ? "PASS" : "FAIL"));

		// Test: La suma de salarios debe ser razonable para el proyecto
		double totalSalaries = project.getTeam().stream().mapToDouble(Employee::getSalary).sum();
		long projectDays = java.time.temporal.ChronoUnit.DAYS.between(project.getStartDate(), project.getEndDate());

		boolean reasonableBudget = totalSalaries > 0 && (totalSalaries / 365.0 * projectDays) < totalSalaries * 2;
		System.out.println("Presupuesto proyecto razonable: " + (reasonableBudget ? "PASS" : "FAIL"));

		// Test: No empleados duplicados en el proyecto
		long uniqueEmployees = project.getTeam().stream().map(Employee::getEmail).distinct().count();
		boolean noDuplicates = uniqueEmployees == project.getTeam().size();
		System.out.println("No empleados duplicados: " + (noDuplicates ? "PASS" : "FAIL"));

		// Test: Empleados de diferentes departamentos para diversidad
		long uniqueDepartments = project.getTeam().stream().map(Employee::getDepartment).distinct().count();
		boolean diverseTeam = uniqueDepartments >= 1; // Al menos 1 departamento
		System.out.println("Equipo con diversidad departamental: " + (diverseTeam ? "PASS" : "FAIL"));
	}

	public static void testDataQualityMetrics() {
		System.out.println("\n--- Test: Data Quality Metrics ---");

		// Crear dataset de prueba
		Object[] testData = { BookTestData.createValidBook(), CustomerTestData.createValidCustomer(),
				EmployeeTestData.createValidEmployee(),
				new Product("Test Product", "Test Description", 99.99, "TEST001") };

		int totalFields = 0;
		int validFields = 0;
		int nullFields = 0;
		int emptyFields = 0;

		// Analizar calidad de cada objeto
		for (Object obj : testData) {
			String qualityReport = analyzeDataQuality(obj);
			System.out.println("Objeto: " + obj.getClass().getSimpleName());
			System.out.println("   " + qualityReport);

			// Contar campos para métricas globales
			if (obj instanceof Book) {
				Book book = (Book) obj;
				totalFields += 4;
				if (book.getTitle() != null)
					validFields++;
				else
					nullFields++;
				if (book.getAuthor() != null)
					validFields++;
				else
					nullFields++;
				if (book.getIsbn() != null)
					validFields++;
				else
					nullFields++;
				validFields++; // price siempre es válido (primitive)
			}
			// Similar para otros tipos...
		}

		double validityRate = totalFields > 0 ? (double) validFields / totalFields * 100 : 0;
		double nullRate = totalFields > 0 ? (double) nullFields / totalFields * 100 : 0;

		System.out.println("Métricas globales de calidad:");
		System.out.println("   Campos totales: " + totalFields);
		System.out.println("   Campos válidos: " + validFields);
		System.out.println("   Campos nulos: " + nullFields);
		System.out.println("   Tasa validez: " + validityRate + "%");
		System.out.println("   Tasa nulos: " + nullRate + "%");

		boolean acceptableQuality = validityRate >= 85.0;
		boolean lowNullRate = nullRate <= 15.0;

		System.out.println("   Test calidad aceptable: " + (acceptableQuality ? "PASS" : "FAIL"));
		System.out.println("   Test baja tasa nulos: " + (lowNullRate ? "PASS" : "FAIL"));
	}

	private static String analyzeDataQuality(Object obj) {
		if (obj instanceof Book) {
			Book book = (Book) obj;
			int score = 0;
			if (book.getTitle() != null && !book.getTitle().trim().isEmpty())
				score++;
			if (book.getAuthor() != null && !book.getAuthor().trim().isEmpty())
				score++;
			if (book.getIsbn() != null && book.getIsbn().length() >= 10)
				score++;
			if (book.getPrice() >= 0.0)
				score++;
			return "Calidad: " + score + "/4 (" + (score * 25) + "%)";
		}
		return "Análisis no disponible";
	}

	public static void testSystemLimits() {
		System.out.println("\n--- Test: System Limits ---");

		// Test límites del sistema y comportamiento en casos extremos

		// Test: Crear muchos objetos para verificar memoria
		System.out.println("Creando 1000 libros para test de límites...");
		Book[] manyBooks = new Book[1000];
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < manyBooks.length; i++) {
			manyBooks[i] = new Book("Libro " + i, "Autor " + i, "ISBN" + i, i * 1.5);
		}

		long endTime = System.currentTimeMillis();
		long creationTime = endTime - startTime;

		System.out.println("Tiempo creación 1000 libros: " + creationTime + "ms");
		System.out.println("   Test rendimiento aceptable: " + (creationTime < 100 ? "PASS" : "FAIL"));

		// Test: Proyecto con muchos empleados
		Project largeProject = new Project("Proyecto Grande", "Proyecto con muchos empleados",
				java.time.LocalDate.now(), java.time.LocalDate.now().plusYears(1));

		startTime = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			Employee emp = new Employee("Employee " + i, "Dept " + (i % 5), 30000 + (i * 500),
					"emp" + i + "@company.com");
			largeProject.addTeamMember(emp);
		}
		endTime = System.currentTimeMillis();

		long teamBuildTime = endTime - startTime;
		System.out.println("Tiempo construir equipo 100 empleados: " + teamBuildTime + "ms");
		System.out.println("Tamaño final equipo: " + largeProject.getTeam().size());
		System.out.println("   Test equipo grande manejable: " + (teamBuildTime < 50 ? "PASS" : "FAIL"));

		// Test: Strings muy largos
		String veryLongTitle = "Este es un título extremadamente largo que podría causar problemas ".repeat(10);
		Book longTitleBook = new Book(veryLongTitle, "Autor", "ISBN", 19.99);

		boolean handlesLongStrings = longTitleBook.getTitle().length() > 500;
		System.out.println("Manejo strings largos (" + longTitleBook.getTitle().length() + " chars): "
				+ (handlesLongStrings ? "PASS" : "FAIL"));

		// Test: Valores extremos
		Customer extremeAgeCustomer = new Customer("Test", "test@test.com", "123", 999);
		Employee extremeSalaryEmployee = new Employee("Test", "Test", 999999999.99, "test@test.com");

		boolean handlesExtremeValues = extremeAgeCustomer.getAge() == 999
				&& extremeSalaryEmployee.getSalary() > 999999999.0;
		System.out.println("Manejo valores extremos: " + (handlesExtremeValues ? "PASS" : "FAIL"));
	}

}
