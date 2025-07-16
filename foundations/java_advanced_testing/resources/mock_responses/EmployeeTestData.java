package java_advanced_testing.resources.mock_responses;

import java_advanced_testing.model.Employee;
import java_advanced_testing.resources.test_data.TestDataConstants;

public class EmployeeTestData {
	public static String createValidEmployeeResponse() {
		Employee employee = new Employee(TestDataConstants.EMPLOYEE_NAME, TestDataConstants.EMPLOYEE_DEPARTMENT,
				TestDataConstants.EMPLOYEE_SALARY, TestDataConstants.EMPLOYEE_EMAIL);
		return String.format("{\"id\": 1, \"name\": \"%s\", \"department\": \"%s\", \"salary\": %.2f}",
				employee.getName(), employee.getDepartment(), employee.getSalary());
	}

	public static String createHighSalaryEmployeeResponse() {
		Employee employee = new Employee("Carlos Rodríguez", "Management", 85000.0, "carlos.rodriguez@email.com");
		return String.format("{\"id\": 2, \"name\": \"%s\", \"department\": \"%s\", \"salary\": %.2f}",
				employee.getName(), employee.getDepartment(), employee.getSalary());
	}
}
