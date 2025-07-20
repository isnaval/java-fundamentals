package java_advanced_testing.unit_tests.basic;

import java_advanced_testing.model.Employee;
import java_advanced_testing.resources.test_data.EmployeeTestData;
import java_advanced_testing.resources.test_data.TestDataConstants;

public class EmployeeTest {

	// Test del constructor
	public static void testEmployeeConstructor() {
		System.out.println("=== Test: Employee Constructor ===");

		Employee employee = new Employee("Alice Johnson", "Engineering", 65000.0, "alice@company.com");

		assert employee.getName().equals("Alice Johnson") : "Name should be 'Alice Johnson'";
		assert employee.getDepartment().equals("Engineering") : "Department should be 'Engineering'";
		assert employee.getSalary() == 65000.0 : "Salary should be 65000.0";
		assert employee.getEmail().equals("alice@company.com") : "Email should be 'alice@company.com'";

		System.out.println("✅ Constructor test passed");
	}

	// Test de getters
	public static void testEmployeeGetters() {
		System.out.println("=== Test: Employee Getters ===");

		Employee employee = EmployeeTestData.createValidEmployee();

		assert employee.getName().equals(TestDataConstants.EMPLOYEE_NAME) : "Name getter failed";
		assert employee.getDepartment().equals(TestDataConstants.EMPLOYEE_DEPARTMENT) : "Department getter failed";
		assert employee.getSalary() == TestDataConstants.EMPLOYEE_SALARY : "Salary getter failed";
		assert employee.getEmail().equals(TestDataConstants.EMPLOYEE_EMAIL) : "Email getter failed";

		System.out.println("✅ Getters test passed");
	}

	// Test de setters
	public static void testEmployeeSetters() {
		System.out.println("=== Test: Employee Setters ===");

		Employee employee = EmployeeTestData.createValidEmployee();

		employee.setName("Bob Wilson");
		employee.setDepartment("Marketing");
		employee.setSalary(55000.0);
		employee.setEmail("bob@company.com");

		assert employee.getName().equals("Bob Wilson") : "Name setter failed";
		assert employee.getDepartment().equals("Marketing") : "Department setter failed";
		assert employee.getSalary() == 55000.0 : "Salary setter failed";
		assert employee.getEmail().equals("bob@company.com") : "Email setter failed";

		System.out.println("✅ Setters test passed");
	}

	// Test de toString
	public static void testEmployeeToString() {
		System.out.println("=== Test: Employee toString ===");

		Employee employee = EmployeeTestData.createValidEmployee();
		String result = employee.toString();

		assert result.contains("Employee{") : "toString should contain 'Employee{'";
		assert result.contains(employee.getName()) : "toString should contain name";
		assert result.contains(employee.getDepartment()) : "toString should contain department";
		assert result.contains(String.valueOf(employee.getSalary())) : "toString should contain salary";

		System.out.println("✅ toString test passed");
	}

	// Test con diferentes rangos de salario
	public static void testEmployeeSalaryRanges() {
		System.out.println("=== Test: Employee Salary Ranges ===");

		Employee intern = EmployeeTestData.createInternEmployee();
		Employee standard = EmployeeTestData.createValidEmployee();
		Employee executive = EmployeeTestData.createHighSalaryEmployee();

		assert intern.getSalary() < 25000.0 : "Intern salary should be under 25000";
		assert standard.getSalary() >= 25000.0 && standard.getSalary() < 60000.0
				: "Standard salary should be 25000-60000";
		assert executive.getSalary() >= 60000.0 : "Executive salary should be 60000 or more";

		System.out.println("✅ Salary ranges test passed");
	}

	// Test con email nulo
	public static void testEmployeeWithoutEmail() {
		System.out.println("=== Test: Employee Without Email ===");

		Employee employee = EmployeeTestData.createEmployeeWithoutEmail();

		assert employee.getEmail() == null : "Email should be null";
		assert employee.getName() != null : "Name should not be null";
		assert employee.getDepartment() != null : "Department should not be null";
		assert employee.getSalary() > 0 : "Salary should be positive";

		System.out.println("✅ Without email test passed");
	}

	// Método para ejecutar todos los tests
	public static void runAllTests() {
		System.out.println("🚀 Running all Employee tests...\n");

		try {
			testEmployeeConstructor();
			testEmployeeGetters();
			testEmployeeSetters();
			testEmployeeToString();
			testEmployeeSalaryRanges();
			testEmployeeWithoutEmail();

			System.out.println("\n🎉 All Employee tests passed!");
		} catch (AssertionError e) {
			System.out.println("\n❌ Test failed: " + e.getMessage());
		}
	}
}