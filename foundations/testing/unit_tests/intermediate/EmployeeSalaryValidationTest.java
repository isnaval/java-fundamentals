package java_advanced_testing.unit_tests.intermediate;

import java_advanced_testing.model.Employee;
import java_advanced_testing.resources.test_data.EmployeeTestData;

public class EmployeeSalaryValidationTest {
	public static void main(String[] args) {
		System.out.println("EMPLOYEE SALARY VALIDATION TESTS");
		System.out.println("==================================");

		testSalaryRanges();
		testSalaryByDepartment();
		testSalaryValidation();
		testSalaryBusinessRules();

		System.out.println("\nEmployee salary validation tests completados");
	}

	public static void testSalaryRanges() {
		System.out.println("\n--- Test: Salary Ranges ---");

		// Test salario interno
		Employee intern = EmployeeTestData.createInternEmployee();
		System.out.println("Empleado interno: " + intern.getName() + " - $" + intern.getSalary());
		System.out.println("   Es salario interno: " + (intern.getSalary() < 25000 ? "PASS" : "FAIL"));

		// Test salario junior
		Employee junior = new Employee("Junior Dev", "IT", 35000.0, "junior@company.com");
		System.out.println("Empleado junior: " + junior.getName() + " - $" + junior.getSalary());
		System.out.println("   Es salario junior: "
				+ (junior.getSalary() >= 25000 && junior.getSalary() < 50000 ? "PASS" : "FAIL"));

		// Test salario senior
		Employee senior = new Employee("Senior Dev", "IT", 65000.0, "senior@company.com");
		System.out.println("Empleado senior: " + senior.getName() + " - $" + senior.getSalary());
		System.out.println("   Es salario senior: "
				+ (senior.getSalary() >= 50000 && senior.getSalary() < 80000 ? "PASS" : "FAIL"));

		// Test salario ejecutivo
		Employee executive = EmployeeTestData.createHighSalaryEmployee();
		System.out.println("Empleado ejecutivo: " + executive.getName() + " - $" + executive.getSalary());
		System.out.println("   Es salario ejecutivo: " + (executive.getSalary() >= 80000 ? "PASS" : "FAIL"));
	}

	public static void testSalaryByDepartment() {
		System.out.println("\n--- Test: Salary by Department ---");

		// Test salarios por departamento
		Employee[] employees = { new Employee("IT Employee", "IT", 50000.0, "it@company.com"),
				new Employee("Sales Employee", "Sales", 45000.0, "sales@company.com"),
				new Employee("HR Employee", "HR", 40000.0, "hr@company.com"),
				new Employee("Marketing Employee", "Marketing", 42000.0, "marketing@company.com"),
				new Employee("Management Employee", "Management", 80000.0, "management@company.com") };

		for (Employee emp : employees) {
			double expectedSalary = getExpectedSalaryByDepartment(emp.getDepartment());
			boolean isCorrectRange = emp.getSalary() >= expectedSalary * 0.8 && emp.getSalary() <= expectedSalary * 1.2;
			System.out.println(emp.getDepartment() + ": $" + emp.getSalary() + " - Rango correcto: "
					+ (isCorrectRange ? "PASS" : "FAIL"));
		}
	}

	private static double getExpectedSalaryByDepartment(String department) {
		switch (department) {
		case "IT":
			return 50000.0;
		case "Sales":
			return 45000.0;
		case "HR":
			return 40000.0;
		case "Marketing":
			return 42000.0;
		case "Management":
			return 80000.0;
		default:
			return 35000.0;
		}
	}

	public static void testSalaryValidation() {
		System.out.println("\n--- Test: Salary Validation ---");

		// Test salario negativo
		Employee negativeSalary = new Employee("Test", "IT", -1000.0, "test@company.com");
		System.out.println("Empleado con salario negativo: $" + negativeSalary.getSalary());
		System.out.println("   Salario negativo: " + (negativeSalary.getSalary() < 0 ? "PASS" : "FAIL"));

		// Test salario cero
		Employee zeroSalary = new Employee("Test", "IT", 0.0, "test@company.com");
		System.out.println("Empleado con salario cero: $" + zeroSalary.getSalary());
		System.out.println("   Salario cero: " + (zeroSalary.getSalary() == 0.0 ? "PASS" : "FAIL"));

		// Test salario muy alto
		Employee highSalary = new Employee("Test", "IT", 1000000.0, "test@company.com");
		System.out.println("Empleado con salario muy alto: $" + highSalary.getSalary());
		System.out.println("   Salario muy alto: " + (highSalary.getSalary() > 500000.0 ? "PASS" : "FAIL"));
	}

	public static void testSalaryBusinessRules() {
		System.out.println("\n--- Test: Salary Business Rules ---");

		// Test: Empleados sin email ganan menos
		Employee withoutEmail = EmployeeTestData.createEmployeeWithoutEmail();
		boolean lowSalaryWithoutEmail = withoutEmail.getEmail() == null && withoutEmail.getSalary() < 50000;
		System.out.println("Empleado sin email gana menos: " + (lowSalaryWithoutEmail ? "PASS" : "FAIL"));

		// Test: Management gana mas que otros departamentos
		Employee management = EmployeeTestData.createHighSalaryEmployee();
		Employee regular = EmployeeTestData.createValidEmployee();
		boolean managementEarnsMore = management.getSalary() > regular.getSalary()
				&& management.getDepartment().equals("Management");
		System.out.println("Management gana mas: " + (managementEarnsMore ? "PASS" : "FAIL"));

		// Test: Diferencia salarial maxima
		double salaryDifference = Math.abs(management.getSalary() - regular.getSalary());
		boolean reasonableDifference = salaryDifference <= 100000.0;
		System.out.println("Diferencia salarial razonable: " + (reasonableDifference ? "PASS" : "FAIL"));
	}

}
