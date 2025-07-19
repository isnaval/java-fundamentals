package java_advanced_testing.integration_tests.component_integration;

import java_advanced_testing.model.Employee;
import java_advanced_testing.model.Project;
import java_advanced_testing.resources.test_data.EmployeeTestData;
import java_advanced_testing.resources.test_data.ProjectTestData;

public class EmployeeProjectIntegrationTest {
	public static void main(String[] args) {
		System.out.println("EMPLOYEE PROJECT INTEGRATION TEST");
		System.out.println("==================================");

		testEmployeeAssignedToProject();
		testProjectTeamFormation();
		testEmployeeSalaryBudget();

		System.out.println("\nEmployee Project integration tests completados");
	}

	public static void testEmployeeAssignedToProject() {
		System.out.println("\n--- Test: Employee Assigned to Project ---");

		Employee employee = EmployeeTestData.createValidEmployee();
		Project project = ProjectTestData.createValidProject();

		System.out.println("Empleado: " + employee.getName() + " (" + employee.getDepartment() + ")");
		System.out.println("Proyecto: " + project.getName());
		System.out.println("Equipo inicial: " + project.getTeam().size() + " miembros");

		project.addTeamMember(employee);

		System.out.println("Equipo después: " + project.getTeam().size() + " miembros");

		boolean employeeInProject = project.getTeam().contains(employee);
		boolean projectHasMembers = project.getTeam().size() > 0;

		System.out.println("Empleado en proyecto: " + (employeeInProject ? "SI" : "NO"));
		System.out.println("Proyecto tiene miembros: " + (projectHasMembers ? "SI" : "NO"));

		if (employeeInProject && projectHasMembers) {
			System.out.println("INTEGRATION TEST: PASS");
		} else {
			System.out.println("INTEGRATION TEST: FAIL");
		}
	}

	public static void testProjectTeamFormation() {
		System.out.println("\n--- Test: Project Team Formation ---");

		Project project = ProjectTestData.createValidProject();
		Employee developer = EmployeeTestData.createValidEmployee();
		Employee manager = EmployeeTestData.createHighSalaryEmployee();
		Employee intern = EmployeeTestData.createInternEmployee();

		System.out.println("Proyecto: " + project.getName());
		System.out.println("Formando equipo...");

		project.addTeamMember(developer);
		project.addTeamMember(manager);
		project.addTeamMember(intern);

		System.out.println("Developer: " + developer.getName() + " ($" + developer.getSalary() + ")");
		System.out.println("Manager: " + manager.getName() + " ($" + manager.getSalary() + ")");
		System.out.println("Intern: " + intern.getName() + " ($" + intern.getSalary() + ")");
		System.out.println("Tamaño final del equipo: " + project.getTeam().size());

		boolean hasEnoughMembers = project.getTeam().size() >= 3;
		boolean hasDifferentRoles = hasDifferentSalaryLevels(project);

		System.out.println("Suficientes miembros: " + (hasEnoughMembers ? "SI" : "NO"));
		System.out.println("Diferentes roles: " + (hasDifferentRoles ? "SI" : "NO"));

		if (hasEnoughMembers && hasDifferentRoles) {
			System.out.println("INTEGRATION TEST: PASS");
		} else {
			System.out.println("INTEGRATION TEST: FAIL");
		}
	}

	public static void testEmployeeSalaryBudget() {
		System.out.println("\n--- Test: Employee Salary Budget ---");

		Project project = ProjectTestData.createValidProject();
		Employee emp1 = EmployeeTestData.createValidEmployee();
		Employee emp2 = EmployeeTestData.createHighSalaryEmployee();

		project.addTeamMember(emp1);
		project.addTeamMember(emp2);

		double totalSalary = 0;
		for (Employee emp : project.getTeam()) {
			totalSalary += emp.getSalary();
		}

		System.out.println("Proyecto: " + project.getName());
		System.out.println("Empleado 1: $" + emp1.getSalary());
		System.out.println("Empleado 2: $" + emp2.getSalary());
		System.out.println("Presupuesto total: $" + totalSalary);

		boolean budgetReasonable = totalSalary > 0 && totalSalary < 200000;

		System.out.println("Presupuesto razonable: " + (budgetReasonable ? "SI" : "NO"));

		if (budgetReasonable) {
			System.out.println("INTEGRATION TEST: PASS");
		} else {
			System.out.println("INTEGRATION TEST: FAIL");
		}
	}

	private static boolean hasDifferentSalaryLevels(Project project) {
		if (project.getTeam().size() < 2)
			return false;

		double firstSalary = project.getTeam().get(0).getSalary();
		for (Employee emp : project.getTeam()) {
			if (emp.getSalary() != firstSalary) {
				return true;
			}
		}
		return false;
	}

}
