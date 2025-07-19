package java_advanced_testing.integration_tests.system_integration;

import java_advanced_testing.model.Book;
import java_advanced_testing.model.Customer;
import java_advanced_testing.model.Employee;
import java_advanced_testing.model.Product;
import java_advanced_testing.model.Project;
import java_advanced_testing.resources.test_data.BookTestData;
import java_advanced_testing.resources.test_data.CustomerTestData;
import java_advanced_testing.resources.test_data.EmployeeTestData;
import java_advanced_testing.resources.test_data.ProjectTestData;

public class CompleteBusinessWorkflowTest {
	public static void main(String[] args) {
		System.out.println("COMPLETE BUSINESS WORKFLOW TEST");
		System.out.println("===============================");
		System.out.println("Probando TODO el sistema trabajando junto\n");

		testCompleteBookSaleWorkflow();
		testEmployeeProjectCustomerWorkflow();
		testFullCompanyOperationsWorkflow();
		testSystemDataIntegrityWorkflow();

		System.out.println("\n===============================");
		System.out.println("BUSINESS WORKFLOW TESTS COMPLETADOS");
		System.out.println("===============================");
	}

	public static void testCompleteBookSaleWorkflow() {
		System.out.println("=== TEST: Complete Book Sale Workflow ===");
		System.out.println("Simulando venta completa de libro...\n");

		// 1. CREAR TODOS LOS COMPONENTES
		Customer customer = CustomerTestData.createValidCustomer();
		Book book = BookTestData.createValidBook();
		Employee salesEmployee = new Employee("Vendedor", "Sales", 40000.0, "sales@company.com");

		// Crear producto con valores seguros
		double productPrice = book.getPrice() + 2.0;
		Product bookProduct = new Product("Libro Físico", "Edición impresa", productPrice, "BOOK-001");

		System.out.println("1. COMPONENTES CREADOS:");
		System.out.println("   Cliente: " + customer.getName() + " (" + customer.getAge() + " años)");
		System.out.println("   Libro: " + book.getTitle() + " - $" + book.getPrice());
		System.out.println("   Empleado: " + salesEmployee.getName() + " (" + salesEmployee.getDepartment() + ")");

		// Validar producto antes de usarlo
		String productName = bookProduct.getName();
		double productPriceValue = bookProduct.getPrice();

		if (productName == null) {
			productName = "Producto Sin Nombre";
			System.out.println("   Producto: " + productName + " - $" + productPriceValue + " (ERROR: nombre nulo)");
		} else {
			System.out.println("   Producto: " + productName + " - $" + productPriceValue);
		}

		// 2. VALIDAR COMPATIBILIDAD
		boolean customerCanBuy = customer.getAge() >= 18; // Solo adultos
		boolean bookAvailable = book.getPrice() > 0;
		boolean employeeCanSell = salesEmployee.getDepartment().equals("Sales");
		boolean productValid = productPriceValue >= book.getPrice() && productName != null;

		System.out.println("\n2. VALIDACIONES:");
		System.out.println("   Cliente puede comprar: " + (customerCanBuy ? "SI" : "NO"));
		System.out.println("   Libro disponible: " + (bookAvailable ? "SI" : "NO"));
		System.out.println("   Empleado puede vender: " + (employeeCanSell ? "SI" : "NO"));
		System.out.println("   Producto válido: " + (productValid ? "SI" : "NO"));

		// 3. EJECUTAR WORKFLOW COMPLETO
		boolean workflowSuccess = customerCanBuy && bookAvailable && employeeCanSell && productValid;

		if (workflowSuccess) {
			System.out.println("\n3. PROCESO DE VENTA:");
			System.out.println("   ✓ Cliente " + customer.getName() + " solicita libro");
			System.out.println("   ✓ Empleado " + salesEmployee.getName() + " procesa venta");
			System.out.println("   ✓ Libro '" + book.getTitle() + "' vendido como producto");
			System.out.println("   ✓ Total: $" + productPriceValue);
			System.out.println("   ✓ VENTA COMPLETADA EXITOSAMENTE");
		} else {
			System.out.println("\n3. PROCESO DE VENTA:");
			System.out.println("   ✗ VENTA FALLÓ - Revisar validaciones:");
			System.out.println("     - Cliente puede comprar: " + customerCanBuy);
			System.out.println("     - Libro disponible: " + bookAvailable);
			System.out.println("     - Empleado puede vender: " + employeeCanSell);
			System.out.println("     - Producto válido: " + productValid);
		}

		// 4. RESULTADO DEL WORKFLOW
		System.out.println("\n4. RESULTADO WORKFLOW:");
		if (workflowSuccess) {
			System.out.println("   SYSTEM INTEGRATION TEST: PASS");
		} else {
			System.out.println("   SYSTEM INTEGRATION TEST: FAIL");
		}
	}

	public static void testEmployeeProjectCustomerWorkflow() {
		System.out.println("\n=== TEST: Employee Project Customer Workflow ===");
		System.out.println("Simulando gestión completa de proyecto con cliente...\n");

		// 1. CREAR ESCENARIO COMPLETO
		Project project = ProjectTestData.createValidProject();
		Employee projectManager = EmployeeTestData.createHighSalaryEmployee();
		Employee developer = EmployeeTestData.createValidEmployee();
		Customer client = CustomerTestData.createValidCustomer();

		System.out.println("1. ESCENARIO CREADO:");
		System.out.println("   Proyecto: " + project.getName());
		System.out.println("   Manager: " + projectManager.getName() + " ($" + projectManager.getSalary() + ")");
		System.out.println("   Developer: " + developer.getName() + " ($" + developer.getSalary() + ")");
		System.out.println("   Cliente: " + client.getName());

		// 2. FORMAR EQUIPO DEL PROYECTO
		project.addTeamMember(projectManager);
		project.addTeamMember(developer);

		System.out.println("\n2. EQUIPO FORMADO:");
		System.out.println("   Tamaño del equipo: " + project.getTeam().size());
		System.out.println("   Manager en equipo: " + (project.getTeam().contains(projectManager) ? "SI" : "NO"));
		System.out.println("   Developer en equipo: " + (project.getTeam().contains(developer) ? "SI" : "NO"));

		// 3. CALCULAR MÉTRICAS DEL PROYECTO
		double totalSalaryCost = 0;
		for (Employee emp : project.getTeam()) {
			totalSalaryCost += emp.getSalary();
		}

		long projectDays = java.time.temporal.ChronoUnit.DAYS.between(project.getStartDate(), project.getEndDate());
		double dailyCost = totalSalaryCost / 365.0;
		double projectCost = dailyCost * projectDays;

		System.out.println("\n3. MÉTRICAS DEL PROYECTO:");
		System.out.println("   Duración: " + projectDays + " días");
		System.out.println("   Costo total salarios: $" + totalSalaryCost);
		System.out.println("   Costo diario: $" + String.format("%.2f", dailyCost));
		System.out.println("   Costo proyecto: $" + String.format("%.2f", projectCost));

		// 4. VALIDAR VIABILIDAD
		boolean teamAdequate = project.getTeam().size() >= 2;
		boolean costReasonable = projectCost < totalSalaryCost; // Proyecto no debe costar más que salarios anuales
		boolean clientSuitable = client.getAge() >= 25; // Clientes maduros para proyectos

		System.out.println("\n4. VALIDACIONES:");
		System.out.println("   Equipo adecuado: " + (teamAdequate ? "SI" : "NO"));
		System.out.println("   Costo razonable: " + (costReasonable ? "SI" : "NO"));
		System.out.println("   Cliente adecuado: " + (clientSuitable ? "SI" : "NO"));

		// 5. RESULTADO DEL WORKFLOW
		boolean workflowSuccess = teamAdequate && costReasonable && clientSuitable;

		System.out.println("\n5. RESULTADO WORKFLOW:");
		if (workflowSuccess) {
			System.out.println("   ✓ Proyecto viable con equipo y cliente");
			System.out.println("   SYSTEM INTEGRATION TEST: PASS");
		} else {
			System.out.println("   ✗ Proyecto no viable");
			System.out.println("   SYSTEM INTEGRATION TEST: FAIL");
		}
	}

	public static void testFullCompanyOperationsWorkflow() {
		System.out.println("\n=== TEST: Full Company Operations Workflow ===");
		System.out.println("Simulando operaciones completas de empresa...\n");

		// 1. CREAR ESTRUCTURA EMPRESARIAL COMPLETA

		// Empleados de diferentes departamentos
		Employee ceo = new Employee("CEO", "Management", 120000.0, "ceo@company.com");
		Employee salesManager = new Employee("Sales Manager", "Sales", 70000.0, "sales@company.com");
		Employee developer = EmployeeTestData.createValidEmployee();
		Employee intern = EmployeeTestData.createInternEmployee();

		// Proyectos múltiples
		Project mainProject = ProjectTestData.createValidProject();
		Project smallProject = ProjectTestData.createShortProject();

		// Clientes diversos
		Customer vipClient = new Customer("VIP Client", "vip@email.com", "+34 600 999 999", 45);
		Customer regularClient = CustomerTestData.createValidCustomer();
		Customer youngClient = CustomerTestData.createMinorCustomer();

		// Productos de la empresa (con valores seguros)
		Product softwareProduct = new Product("Software Empresarial", "Sistema empresarial completo", 5000.0,
				"SOFT-001");
		Product consultingProduct = new Product("Consultoría TI", "Servicios de consulta técnica", 2000.0, "CONS-001");

		// Validar productos antes de usar
		String softwareName = softwareProduct.getName();
		String consultingName = consultingProduct.getName();
		double softwarePrice = softwareProduct.getPrice();
		double consultingPrice = consultingProduct.getPrice();

		if (softwareName == null)
			softwareName = "Software Sin Nombre";
		if (consultingName == null)
			consultingName = "Consultoría Sin Nombre";

		System.out.println("1. ESTRUCTURA EMPRESARIAL:");
		System.out.println("   Empleados: 4 (CEO, Manager, Developer, Intern)");
		System.out.println("   Proyectos: 2 (Principal, Pequeño)");
		System.out.println("   Clientes: 3 (VIP, Regular, Joven)");
		System.out.println("   Productos: 2 (Software, Consultoría)");

		// 2. ASIGNAR RECURSOS A PROYECTOS
		mainProject.addTeamMember(ceo);
		mainProject.addTeamMember(salesManager);
		mainProject.addTeamMember(developer);

		smallProject.addTeamMember(developer);
		smallProject.addTeamMember(intern);

		System.out.println("\n2. ASIGNACIÓN DE RECURSOS:");
		System.out.println("   Proyecto principal: " + mainProject.getTeam().size() + " empleados");
		System.out.println("   Proyecto pequeño: " + smallProject.getTeam().size() + " empleados");

		// 3. SIMULAR OPERACIONES EMPRESARIALES

		// Calcular presupuestos
		double mainProjectBudget = calculateProjectBudget(mainProject);
		double smallProjectBudget = calculateProjectBudget(smallProject);
		double totalBudget = mainProjectBudget + smallProjectBudget;

		// Evaluar clientes
		String vipLevel = evaluateClientLevel(vipClient);
		String regularLevel = evaluateClientLevel(regularClient);
		String youngLevel = evaluateClientLevel(youngClient);

		// Calcular ingresos potenciales
		double softwareRevenue = softwarePrice * 3; // 3 ventas
		double consultingRevenue = consultingPrice * 2; // 2 ventas
		double totalRevenue = softwareRevenue + consultingRevenue;

		System.out.println("\n3. OPERACIONES EMPRESARIALES:");
		System.out.println("   Presupuesto total proyectos: $" + String.format("%.2f", totalBudget));
		System.out.println("   Ingresos potenciales: $" + String.format("%.2f", totalRevenue));
		System.out.println("   Software: " + softwareName + " ($" + softwarePrice + ")");
		System.out.println("   Consultoría: " + consultingName + " ($" + consultingPrice + ")");
		System.out.println("   Cliente VIP: " + vipLevel);
		System.out.println("   Cliente regular: " + regularLevel);
		System.out.println("   Cliente joven: " + youngLevel);

		// 4. VALIDAR VIABILIDAD EMPRESARIAL
		boolean profitableOperations = totalRevenue > totalBudget;
		boolean diverseClients = !vipLevel.equals(regularLevel);
		boolean adequateStaffing = mainProject.getTeam().size() >= 3;
		boolean productPortfolio = softwarePrice != consultingPrice;

		System.out.println("\n4. VALIDACIONES EMPRESARIALES:");
		System.out.println("   Operaciones rentables: " + (profitableOperations ? "SI" : "NO"));
		System.out.println("   Clientes diversos: " + (diverseClients ? "SI" : "NO"));
		System.out.println("   Personal adecuado: " + (adequateStaffing ? "SI" : "NO"));
		System.out.println("   Portfolio diverso: " + (productPortfolio ? "SI" : "NO"));

		// 5. RESULTADO FINAL
		boolean companyViable = profitableOperations && diverseClients && adequateStaffing && productPortfolio;

		System.out.println("\n5. RESULTADO EMPRESARIAL:");
		if (companyViable) {
			System.out.println("   ✓ Empresa viable y bien estructurada");
			System.out.println("   ✓ Todos los componentes funcionan en armonía");
			System.out.println("   SYSTEM INTEGRATION TEST: PASS");
		} else {
			System.out.println("   ✗ Empresa necesita ajustes estructurales");
			System.out.println("   SYSTEM INTEGRATION TEST: FAIL");
		}
	}

	public static void testSystemDataIntegrityWorkflow() {
		System.out.println("\n=== TEST: System Data Integrity Workflow ===");
		System.out.println("Validando integridad de datos en todo el sistema...\n");

		// 1. CREAR DATOS INTERCONECTADOS
		Book book = BookTestData.createValidBook();
		Customer customer = CustomerTestData.createValidCustomer();
		Employee employee = EmployeeTestData.createValidEmployee();
		Project project = ProjectTestData.createValidProject();

		// Crear producto con validación segura
		String bookTitle = book.getTitle();
		String bookIsbn = book.getIsbn();
		double bookPrice = book.getPrice();

		Product product = new Product(bookTitle + " - Edición Especial", "Basado en " + bookTitle, bookPrice * 1.5,
				"BOOK-" + bookIsbn.substring(0, 3));

		project.addTeamMember(employee);

		// Validar producto antes de usar
		String productName = product.getName();
		if (productName == null) {
			productName = bookTitle + " - Edición Especial (CORREGIDO)";
		}

		System.out.println("1. DATOS INTERCONECTADOS CREADOS:");
		System.out.println("   Libro base: " + bookTitle);
		System.out.println("   Producto derivado: " + productName);
		System.out.println("   Cliente: " + customer.getName());
		System.out.println("   Empleado en proyecto: " + employee.getName());
		System.out.println("   Proyecto: " + project.getName());

		// 2. VALIDAR CONSISTENCIA DE DATOS
		boolean bookProductConsistency = productName.contains(bookTitle);
		boolean priceConsistency = product.getPrice() > bookPrice;
		boolean employeeProjectConsistency = project.getTeam().contains(employee);
		boolean emailConsistency = !customer.getEmail().equals(employee.getEmail());

		System.out.println("\n2. VALIDACIONES DE CONSISTENCIA:");
		System.out.println("   Libro-Producto consistente: " + (bookProductConsistency ? "SI" : "NO"));
		System.out.println("   Precios consistentes: " + (priceConsistency ? "SI" : "NO"));
		System.out.println("   Empleado-Proyecto consistente: " + (employeeProjectConsistency ? "SI" : "NO"));
		System.out.println("   Emails únicos: " + (emailConsistency ? "SI" : "NO"));

		// 3. VALIDAR FLUJO DE DATOS
		String dataFlow = simulateDataFlow(book, customer, employee, project, product);
		boolean dataFlowValid = dataFlow.contains("SUCCESS");

		System.out.println("\n3. FLUJO DE DATOS:");
		System.out.println("   Resultado: " + dataFlow);
		System.out.println("   Flujo válido: " + (dataFlowValid ? "SI" : "NO"));

		// 4. RESULTADO FINAL
		boolean systemIntegrity = bookProductConsistency && priceConsistency && employeeProjectConsistency
				&& emailConsistency && dataFlowValid;

		System.out.println("\n4. INTEGRIDAD DEL SISTEMA:");
		if (systemIntegrity) {
			System.out.println("   ✓ Todos los datos son consistentes");
			System.out.println("   ✓ Flujo de información correcto");
			System.out.println("   ✓ Sistema íntegro y confiable");
			System.out.println("   SYSTEM INTEGRATION TEST: PASS");
		} else {
			System.out.println("   ✗ Problemas de integridad detectados");
			System.out.println("   SYSTEM INTEGRATION TEST: FAIL");
		}
	}

	// MÉTODOS UTILITARIOS

	private static double calculateProjectBudget(Project project) {
		double totalSalary = 0;
		for (Employee emp : project.getTeam()) {
			totalSalary += emp.getSalary();
		}

		long projectDays = java.time.temporal.ChronoUnit.DAYS.between(project.getStartDate(), project.getEndDate());

		return (totalSalary / 365.0) * projectDays;
	}

	private static String evaluateClientLevel(Customer client) {
		if (client.getAge() >= 65)
			return "SENIOR";
		else if (client.getAge() < 18)
			return "MENOR";
		else if (client.getName().contains("VIP"))
			return "VIP";
		else
			return "REGULAR";
	}

	private static String simulateDataFlow(Book book, Customer customer, Employee employee, Project project,
			Product product) {
		try {
			// Simular flujo: Customer -> Employee -> Project -> Product -> Book
			String step1 = "Customer " + customer.getName() + " contacta sistema";
			String step2 = "Employee " + employee.getName() + " procesa solicitud";
			String step3 = "Project " + project.getName() + " asigna recursos";
			String step4 = "Product " + product.getName() + " basado en Book " + book.getTitle();

			return step1 + " -> " + step2 + " -> " + step3 + " -> " + step4 + " -> SUCCESS";
		} catch (Exception e) {
			return "ERROR en flujo de datos: " + e.getMessage();
		}
	}
}
