package java_advanced_testing.resources.test_data;

import java_advanced_testing.model.Employee;

public class EmployeeTestData {

	public static Employee createValidEmployee() {
		return new Employee(TestDataConstants.EMPLOYEE_NAME, TestDataConstants.EMPLOYEE_DEPARTMENT,
				TestDataConstants.EMPLOYEE_SALARY, TestDataConstants.EMPLOYEE_EMAIL);
	}

	public static Employee createHighSalaryEmployee() {
		return new Employee("Carlos Rodríguez", "Management", 85000.0, "carlos.rodriguez@company.com");
	}

	public static Employee createInternEmployee() {
		return new Employee("Laura Fernández", "IT", 18000.0, "laura.fernandez@company.com");
	}

	public static Employee createEmployeeWithoutEmail() {
		return new Employee("Miguel Torres", "Operations", 30000.0, null);
	}
}