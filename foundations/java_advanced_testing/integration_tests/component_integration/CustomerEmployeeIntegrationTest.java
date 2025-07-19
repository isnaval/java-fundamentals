package java_advanced_testing.integration_tests.component_integration;

import java_advanced_testing.model.Customer;
import java_advanced_testing.model.Employee;
import java_advanced_testing.resources.test_data.CustomerTestData;
import java_advanced_testing.resources.test_data.EmployeeTestData;

public class CustomerEmployeeIntegrationTest {
	public static void main(String[] args) {
		System.out.println("CUSTOMER EMPLOYEE INTEGRATION TEST");
		System.out.println("===================================");

		testCustomerServiceAssignment();
		testCustomerEmployeeInteraction();
		testSpecialCustomerHandling();

		System.out.println("\nCustomer Employee integration tests completados");
	}

	public static void testCustomerServiceAssignment() {
		System.out.println("\n--- Test: Customer Service Assignment ---");

		Customer customer = CustomerTestData.createValidCustomer();
		Employee employee = EmployeeTestData.createValidEmployee();

		System.out.println("Cliente: " + customer.getName() + " (" + customer.getAge() + " años)");
		System.out.println("Empleado: " + employee.getName() + " (" + employee.getDepartment() + ")");

		boolean isGoodMatch = isEmployeeCustomerMatch(employee, customer);
		String serviceLevel = determineServiceLevel(customer);

		System.out.println("Es buena asignación: " + (isGoodMatch ? "SI" : "NO"));
		System.out.println("Nivel de servicio: " + serviceLevel);

		if (isGoodMatch) {
			System.out.println("INTEGRATION TEST: PASS");
		} else {
			System.out.println("INTEGRATION TEST: FAIL");
		}
	}

	public static void testCustomerEmployeeInteraction() {
		System.out.println("\n--- Test: Customer Employee Interaction ---");

		Customer customer = CustomerTestData.createValidCustomer();
		Employee salesEmployee = new Employee("Vendedor", "Sales", 40000.0, "sales@company.com");

		System.out.println("Cliente: " + customer.getName());
		System.out.println("Empleado de ventas: " + salesEmployee.getName());

		boolean canInteract = canEmployeeServeCustomer(salesEmployee, customer);
		String interactionResult = simulateInteraction(salesEmployee, customer);

		System.out.println("Puede atender: " + (canInteract ? "SI" : "NO"));
		System.out.println("Resultado interacción: " + interactionResult);

		if (canInteract) {
			System.out.println("INTEGRATION TEST: PASS");
		} else {
			System.out.println("INTEGRATION TEST: FAIL");
		}
	}

	public static void testSpecialCustomerHandling() {
		System.out.println("\n--- Test: Special Customer Handling ---");

		Customer minor = CustomerTestData.createMinorCustomer();
		Customer senior = CustomerTestData.createSeniorCustomer();
		Employee specialist = EmployeeTestData.createHighSalaryEmployee();

		System.out.println("Cliente menor: " + minor.getName() + " (" + minor.getAge() + " años)");
		System.out.println("Cliente senior: " + senior.getName() + " (" + senior.getAge() + " años)");
		System.out.println("Especialista: " + specialist.getName());

		String minorHandling = getSpecialHandling(minor);
		String seniorHandling = getSpecialHandling(senior);

		System.out.println("Manejo menor: " + minorHandling);
		System.out.println("Manejo senior: " + seniorHandling);

		boolean correctHandling = !minorHandling.equals(seniorHandling);

		System.out.println("Manejo diferenciado: " + (correctHandling ? "SI" : "NO"));

		if (correctHandling) {
			System.out.println("INTEGRATION TEST: PASS");
		} else {
			System.out.println("INTEGRATION TEST: FAIL");
		}
	}

	private static boolean isEmployeeCustomerMatch(Employee employee, Customer customer) {
		return employee.getDepartment().equals("IT") && customer.getAge() < 40;
	}

	private static String determineServiceLevel(Customer customer) {
		if (customer.getAge() >= 65)
			return "PREMIUM";
		else if (customer.getAge() < 18)
			return "ESPECIAL";
		else
			return "ESTÁNDAR";
	}

	private static boolean canEmployeeServeCustomer(Employee employee, Customer customer) {
		return employee.getEmail() != null && customer.getEmail() != null;
	}

	private static String simulateInteraction(Employee employee, Customer customer) {
		return "Empleado " + employee.getName() + " atendió a " + customer.getName() + " exitosamente";
	}

	private static String getSpecialHandling(Customer customer) {
		if (customer.getAge() < 18)
			return "REQUIERE_AUTORIZACIÓN_PADRES";
		else if (customer.getAge() >= 65)
			return "DESCUENTO_SENIOR";
		else
			return "SERVICIO_ESTÁNDAR";
	}
}
