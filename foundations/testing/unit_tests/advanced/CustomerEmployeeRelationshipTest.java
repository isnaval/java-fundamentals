package java_advanced_testing.unit_tests.advanced;

import java_advanced_testing.model.Customer;
import java_advanced_testing.model.Employee;
import java_advanced_testing.resources.test_data.CustomerTestData;
import java_advanced_testing.resources.test_data.EmployeeTestData;

public class CustomerEmployeeRelationshipTest {
	public static void main(String[] args) {
		System.out.println("CUSTOMER EMPLOYEE RELATIONSHIP ADVANCED TESTS");
		System.out.println("===============================================");

		testCustomerServiceAssignment();
		testEmployeeCustomerLoad();
		testCustomerSatisfactionMetrics();
		testServiceQualityAnalysis();
		testRelationshipComplexity();

		System.out.println("\nCustomer employee relationship tests completados");
	}

	public static void testCustomerServiceAssignment() {
		System.out.println("\n--- Test: Customer Service Assignment ---");

		// Crear clientes y empleados
		Customer[] customers = { CustomerTestData.createValidCustomer(), CustomerTestData.createMinorCustomer(),
				CustomerTestData.createSeniorCustomer(),
				new Customer("Cliente VIP", "vip@email.com", "+34 600 999 999", 45) };

		Employee[] serviceEmployees = { EmployeeTestData.createValidEmployee(),
				new Employee("Especialista Senior", "Customer Service", 45000.0, "specialist@company.com"),
				new Employee("Gerente de Cuentas", "Sales", 65000.0, "manager@company.com") };

		// Asignación inteligente basada en criterios
		for (Customer customer : customers) {
			Employee assignedEmployee = assignEmployeeToCustomer(customer, serviceEmployees);
			String reason = getAssignmentReason(customer, assignedEmployee);

			System.out.println("Cliente: " + customer.getName() + " (" + customer.getAge() + " años)");
			System.out.println(
					"   Asignado a: " + assignedEmployee.getName() + " (" + assignedEmployee.getDepartment() + ")");
			System.out.println("   Razón: " + reason);

			boolean appropriateAssignment = validateAssignment(customer, assignedEmployee);
			System.out.println("   Asignación apropiada: " + (appropriateAssignment ? "PASS" : "FAIL"));
		}
	}

	private static Employee assignEmployeeToCustomer(Customer customer, Employee[] employees) {
		// Lógica de asignación inteligente
		if (customer.getAge() < 18) {
			// Menores necesitan especialista en customer service
			for (Employee emp : employees) {
				if (emp.getDepartment().equals("Customer Service"))
					return emp;
			}
		} else if (customer.getAge() >= 65) {
			// Seniors necesitan empleado con más experiencia (mayor salario)
			Employee bestEmployee = employees[0];
			for (Employee emp : employees) {
				if (emp.getSalary() > bestEmployee.getSalary()) {
					bestEmployee = emp;
				}
			}
			return bestEmployee;
		} else if (customer.getName().contains("VIP")) {
			// Clientes VIP necesitan gerente
			for (Employee emp : employees) {
				if (emp.getName().contains("Gerente") || emp.getDepartment().equals("Sales")) {
					return emp;
				}
			}
		}

		// Asignación por defecto
		return employees[0];
	}

	private static String getAssignmentReason(Customer customer, Employee employee) {
		if (customer.getAge() < 18)
			return "Cliente menor requiere especialista";
		else if (customer.getAge() >= 65)
			return "Cliente senior requiere empleado experimentado";
		else if (customer.getName().contains("VIP"))
			return "Cliente VIP requiere gerente";
		else
			return "Asignación estándar";
	}

	private static boolean validateAssignment(Customer customer, Employee employee) {
		if (customer.getAge() < 18 && !employee.getDepartment().equals("Customer Service"))
			return false;
		if (customer.getAge() >= 65 && employee.getSalary() < 40000.0)
			return false;
		if (customer.getName().contains("VIP") && !employee.getDepartment().equals("Sales"))
			return false;
		return true;
	}

	public static void testEmployeeCustomerLoad() {
		System.out.println("\n--- Test: Employee Customer Load ---");

		Employee[] employees = { EmployeeTestData.createValidEmployee(), EmployeeTestData.createHighSalaryEmployee(),
				new Employee("Employee Sobrecargado", "Customer Service", 35000.0, "overloaded@company.com") };

		// Simular carga de clientes por empleado
		int[] customerLoads = { 5, 3, 12 }; // Número de clientes asignados

		for (int i = 0; i < employees.length; i++) {
			Employee emp = employees[i];
			int load = customerLoads[i];

			String loadLevel = categorizeLoad(load);
			boolean isOverloaded = load > 10;
			boolean needsHelp = isOverloaded && emp.getSalary() < 50000.0;

			System.out.println("Empleado: " + emp.getName());
			System.out.println("   Clientes asignados: " + load);
			System.out.println("   Nivel de carga: " + loadLevel);
			System.out.println("   Necesita ayuda: " + (needsHelp ? "SÍ" : "NO"));
			System.out.println("   Test carga manejable: " + (!isOverloaded ? "PASS" : "FAIL"));
		}
	}

	private static String categorizeLoad(int customerCount) {
		if (customerCount <= 3)
			return "BAJA";
		else if (customerCount <= 7)
			return "MEDIA";
		else if (customerCount <= 10)
			return "ALTA";
		else
			return "CRÍTICA";
	}

	public static void testCustomerSatisfactionMetrics() {
		System.out.println("\n--- Test: Customer Satisfaction Metrics ---");

		// Simular métricas de satisfacción
		Customer[] customers = { CustomerTestData.createValidCustomer(), CustomerTestData.createSeniorCustomer(),
				new Customer("Cliente Insatisfecho", "unhappy@email.com", "+34 600 000 001", 35) };

		double[] satisfactionScores = { 8.5, 9.2, 4.1 }; // Puntuaciones de 1-10

		double totalSatisfaction = 0.0;
		int satisfiedCustomers = 0;

		for (int i = 0; i < customers.length; i++) {
			Customer customer = customers[i];
			double score = satisfactionScores[i];

			totalSatisfaction += score;
			if (score >= 7.0)
				satisfiedCustomers++;

			String satisfactionLevel = getSatisfactionLevel(score);
			System.out.println("Cliente: " + customer.getName());
			System.out.println("   Puntuación: " + score + "/10 (" + satisfactionLevel + ")");
		}

		double averageSatisfaction = totalSatisfaction / customers.length;
		double satisfactionRate = (double) satisfiedCustomers / customers.length * 100;

		System.out.println("Métricas generales:");
		System.out.println("   Satisfacción promedio: " + averageSatisfaction + "/10");
		System.out.println("   Tasa de satisfacción: " + satisfactionRate + "%");
		System.out.println("   Test satisfacción aceptable: " + (averageSatisfaction >= 7.0 ? "PASS" : "FAIL"));
		System.out.println("   Test tasa objetivo: " + (satisfactionRate >= 70.0 ? "PASS" : "FAIL"));
	}

	private static String getSatisfactionLevel(double score) {
		if (score >= 9.0)
			return "EXCELENTE";
		else if (score >= 7.0)
			return "BUENO";
		else if (score >= 5.0)
			return "REGULAR";
		else
			return "MALO";
	}

	public static void testServiceQualityAnalysis() {
		System.out.println("\n--- Test: Service Quality Analysis ---");

		// Análisis de calidad del servicio por departamento
		String[] departments = { "Customer Service", "Sales", "IT" };
		double[] qualityScores = { 8.7, 7.9, 6.5 }; // Puntuaciones de calidad
		int[] responseTimeHours = { 2, 4, 8 }; // Tiempo de respuesta en horas

		for (int i = 0; i < departments.length; i++) {
			String dept = departments[i];
			double quality = qualityScores[i];
			int responseTime = responseTimeHours[i];

			boolean meetQualityStandard = quality >= 7.0;
			boolean meetTimeStandard = responseTime <= 4;

			System.out.println("Departamento: " + dept);
			System.out.println("   Calidad: " + quality + "/10");
			System.out.println("   Tiempo respuesta: " + responseTime + " horas");
			System.out.println("   Cumple estándar calidad: " + (meetQualityStandard ? "PASS" : "FAIL"));
			System.out.println("   Cumple estándar tiempo: " + (meetTimeStandard ? "PASS" : "FAIL"));
		}
	}

	public static void testRelationshipComplexity() {
		System.out.println("\n--- Test: Relationship Complexity ---");

		// Test de relaciones complejas entre múltiples entidades
		Customer customer = CustomerTestData.createValidCustomer();
		Employee primaryEmployee = EmployeeTestData.createValidEmployee();
		Employee backupEmployee = EmployeeTestData.createHighSalaryEmployee();

		// Simular historial de interacciones
		String[] interactions = { "Consulta inicial - " + primaryEmployee.getName(),
				"Seguimiento - " + primaryEmployee.getName(), "Escalación - " + backupEmployee.getName(),
				"Resolución - " + backupEmployee.getName() };

		System.out.println("Cliente: " + customer.getName());
		System.out.println("Historial de interacciones:");

		int primaryInteractions = 0;
		int backupInteractions = 0;

		for (String interaction : interactions) {
			System.out.println("   " + interaction);
			if (interaction.contains(primaryEmployee.getName()))
				primaryInteractions++;
			if (interaction.contains(backupEmployee.getName()))
				backupInteractions++;
		}

		boolean escalationOccurred = backupInteractions > 0;
		boolean complexCase = interactions.length > 2;

		System.out.println("Análisis de complejidad:");
		System.out.println("   Interacciones primarias: " + primaryInteractions);
		System.out.println("   Interacciones de escalación: " + backupInteractions);
		System.out.println("   Hubo escalación: " + (escalationOccurred ? "SÍ" : "NO"));
		System.out.println("   Caso complejo: " + (complexCase ? "SÍ" : "NO"));
		System.out.println("   Test gestión adecuada: " + (escalationOccurred && complexCase ? "PASS" : "FAIL"));
	}

}
