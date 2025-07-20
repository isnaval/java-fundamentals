// ===== EmployeeJunitTest.java =====
package java_advanced_testing.junit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java_advanced_testing.model.Employee;
import java_advanced_testing.resources.test_data.EmployeeTestData;

public class EmployeeJunitTest {

	private Employee employee;

	@BeforeEach
	public void setUp() {
		employee = new Employee("Alice Johnson", "Engineering", 65000.0, "alice@company.com");
	}

	@Test
	public void testEmployeeConstructor() {
		assertEquals("Alice Johnson", employee.getName());
		assertEquals("Engineering", employee.getDepartment());
		assertEquals(65000.0, employee.getSalary());
		assertEquals("alice@company.com", employee.getEmail());
	}

	@Test
	public void testEmployeeGetters() {
		Employee testEmployee = EmployeeTestData.createValidEmployee();

		assertNotNull(testEmployee.getName());
		assertNotNull(testEmployee.getDepartment());
		assertNotNull(testEmployee.getEmail());
		assertTrue(testEmployee.getSalary() > 0);
	}

	@Test
	public void testEmployeeSetters() {
		employee.setName("Jane Smith");
		employee.setDepartment("Marketing");
		employee.setSalary(70000.0);
		employee.setEmail("jane@company.com");

		assertEquals("Jane Smith", employee.getName());
		assertEquals("Marketing", employee.getDepartment());
		assertEquals(70000.0, employee.getSalary());
		assertEquals("jane@company.com", employee.getEmail());
	}

	@Test
	public void testEmployeeSalaryRanges() {
		Employee intern = EmployeeTestData.createInternEmployee();
		Employee executive = EmployeeTestData.createHighSalaryEmployee();

		assertTrue(intern.getSalary() < 25000.0, "Intern salary should be less than 25000");
		assertTrue(executive.getSalary() > 60000.0, "Executive salary should be more than 60000");
		assertTrue(employee.getSalary() >= 25000.0 && employee.getSalary() <= 100000.0,
				"Regular employee salary should be in reasonable range");
	}

	@Test
	public void testEmployeeDepartmentValidation() {
		assertNotNull(employee.getDepartment(), "Department should not be null");
		assertFalse(employee.getDepartment().isEmpty(), "Department should not be empty");
		assertTrue(employee.getDepartment().length() > 2, "Department should have meaningful name");
	}

	@Test
	public void testEmployeeEmailFormat() {
		assertTrue(employee.getEmail().contains("@"), "Email should contain @");
		assertTrue(employee.getEmail().contains("company.com"), "Email should be from company domain");
		assertFalse(employee.getEmail().startsWith("@"), "Email should not start with @");
		assertFalse(employee.getEmail().endsWith("@"), "Email should not end with @");
	}

	@Test
	public void testEmployeeWithTestData() {
		Employee validEmployee = EmployeeTestData.createValidEmployee();
		Employee highSalaryEmployee = EmployeeTestData.createHighSalaryEmployee();
		Employee internEmployee = EmployeeTestData.createInternEmployee();

		assertNotNull(validEmployee);
		assertNotNull(highSalaryEmployee);
		assertNotNull(internEmployee);

		assertTrue(highSalaryEmployee.getSalary() > validEmployee.getSalary(),
				"High salary employee should earn more than regular employee");
		assertTrue(validEmployee.getSalary() > internEmployee.getSalary(),
				"Regular employee should earn more than intern");
	}

	@Test
	public void testEmployeeSalaryValidation() {
		assertTrue(employee.getSalary() >= 0, "Salary should not be negative");

		Employee employeeWithoutEmail = EmployeeTestData.createEmployeeWithoutEmail();
		if (employeeWithoutEmail.getEmail() == null) {
			assertTrue(employeeWithoutEmail.getSalary() < 50000, "Employee without email should have lower salary");
		}
	}

	@Test
	public void testEmployeeToString() {
		String result = employee.toString();

		assertNotNull(result, "toString should not return null");
		assertTrue(result.contains("Employee") || result.contains(employee.getName()),
				"toString should contain class name or employee name");
		assertFalse(result.isEmpty(), "toString should not be empty");
	}

	@Test
	public void testEmployeeEquality() {
		Employee sameEmployee = new Employee("Alice Johnson", "Engineering", 65000.0, "alice@company.com");
		Employee differentEmployee = new Employee("Bob Smith", "Sales", 50000.0, "bob@company.com");

		assertEquals(employee.getName(), sameEmployee.getName());
		assertEquals(employee.getDepartment(), sameEmployee.getDepartment());
		assertEquals(employee.getSalary(), sameEmployee.getSalary());
		assertEquals(employee.getEmail(), sameEmployee.getEmail());

		assertNotEquals(employee.getName(), differentEmployee.getName());
		assertNotEquals(employee.getDepartment(), differentEmployee.getDepartment());
	}
}