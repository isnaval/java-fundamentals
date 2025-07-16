package java_advanced_testing.unit_tests.intermediate;

import java.time.LocalDate;

import java_advanced_testing.model.Employee;
import java_advanced_testing.model.Project;
import java_advanced_testing.resources.test_data.EmployeeTestData;
import java_advanced_testing.resources.test_data.ProjectTestData;

public class ProjectTeamValidationTest {

	public static void main(String[] args) {
		System.out.println("PROJECT TEAM VALIDATION TESTS");
		System.out.println("===============================");

		testTeamManagement();
		testTeamValidation();
		testProjectDates();
		testProjectBusinessRules();

		System.out.println("\nProject team validation tests completados");
	}

	public static void testTeamManagement() {
		System.out.println("\n--- Test: Team Management ---");

		// Test proyecto vacio
		Project emptyProject = ProjectTestData.createValidProject();
		System.out.println("Proyecto vacio - Tamaño equipo: " + emptyProject.getTeam().size());
		System.out.println("   Equipo vacio: " + (emptyProject.getTeam().isEmpty() ? "PASS" : "FAIL"));

		// Test añadir empleados
		Employee emp1 = EmployeeTestData.createValidEmployee();
		Employee emp2 = EmployeeTestData.createHighSalaryEmployee();
		Employee emp3 = EmployeeTestData.createInternEmployee();

		emptyProject.addTeamMember(emp1);
		emptyProject.addTeamMember(emp2);
		emptyProject.addTeamMember(emp3);

		System.out.println("Despues de añadir empleados - Tamaño equipo: " + emptyProject.getTeam().size());
		System.out.println("   Equipo correcto: " + (emptyProject.getTeam().size() == 3 ? "PASS" : "FAIL"));

		// Test proyecto con equipo predefinido
		Project projectWithTeam = ProjectTestData.createProjectWithTeam();
		System.out.println("Proyecto con equipo predefinido - Tamaño: " + projectWithTeam.getTeam().size());
		System.out.println("   Tiene equipo: " + (projectWithTeam.getTeam().size() > 0 ? "PASS" : "FAIL"));
	}

	public static void testTeamValidation() {
		System.out.println("\n--- Test: Team Validation ---");

		Project project = ProjectTestData.createValidProject();

		// Test empleados duplicados
		Employee emp1 = EmployeeTestData.createValidEmployee();
		project.addTeamMember(emp1);
		project.addTeamMember(emp1); // Mismo empleado

		System.out.println("Empleados duplicados - Tamaño equipo: " + project.getTeam().size());
		System.out.println("   Permite duplicados: " + (project.getTeam().size() == 2 ? "PASS" : "FAIL"));

		// Test empleados nulos
		try {
			project.addTeamMember(null);
			System.out.println("Empleado nulo añadido - Tamaño equipo: " + project.getTeam().size());
			System.out.println("   Permite nulos: PASS");
		} catch (Exception e) {
			System.out.println("Empleado nulo rechazado: PASS");
		}

		// Test equipo mixto por departamentos
		Project mixedProject = ProjectTestData.createValidProject();
		Employee itEmployee = new Employee("IT Guy", "IT", 50000.0, "it@company.com");
		Employee salesEmployee = new Employee("Sales Guy", "Sales", 45000.0, "sales@company.com");
		Employee hrEmployee = new Employee("HR Guy", "HR", 40000.0, "hr@company.com");

		mixedProject.addTeamMember(itEmployee);
		mixedProject.addTeamMember(salesEmployee);
		mixedProject.addTeamMember(hrEmployee);

		System.out.println("Equipo mixto por departamentos - Tamaño: " + mixedProject.getTeam().size());
		System.out.println("   Equipo diverso: " + (mixedProject.getTeam().size() == 3 ? "PASS" : "FAIL"));
	}

	public static void testProjectDates() {
		System.out.println("\n--- Test: Project Dates ---");

		// Test fechas validas
		Project validProject = ProjectTestData.createValidProject();
		boolean validDates = validProject.getStartDate().isBefore(validProject.getEndDate());
		System.out.println("Proyecto con fechas validas: " + (validDates ? "PASS" : "FAIL"));

		// Test proyecto vencido
		Project expiredProject = ProjectTestData.createExpiredProject();
		boolean isExpired = expiredProject.getEndDate().isBefore(LocalDate.now());
		System.out.println("Proyecto vencido: " + (isExpired ? "PASS" : "FAIL"));

		// Test proyecto de corta duracion
		Project shortProject = ProjectTestData.createShortProject();
		long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(shortProject.getStartDate(),
				shortProject.getEndDate());
		System.out.println("Proyecto corto - Dias de duracion: " + daysBetween);
		System.out.println("   Es corto: " + (daysBetween <= 10 ? "PASS" : "FAIL"));

		// Test proyecto largo
		Project longProject = new Project("Proyecto Largo", "Proyecto de larga duracion", LocalDate.now(),
				LocalDate.now().plusYears(2));
		long longDaysBetween = java.time.temporal.ChronoUnit.DAYS.between(longProject.getStartDate(),
				longProject.getEndDate());
		System.out.println("Proyecto largo - Dias de duracion: " + longDaysBetween);
		System.out.println("   Es largo: " + (longDaysBetween > 365 ? "PASS" : "FAIL"));
	}

	public static void testProjectBusinessRules() {
		System.out.println("\n--- Test: Project Business Rules ---");

		// Test: Proyectos largos necesitan mas empleados
		Project longProject = new Project("Proyecto Largo", "Proyecto complejo", LocalDate.now(),
				LocalDate.now().plusMonths(12));
		for (int i = 0; i < 5; i++) {
			Employee emp = new Employee("Employee " + i, "IT", 50000.0, "emp" + i + "@company.com");
			longProject.addTeamMember(emp);
		}

		long projectDuration = java.time.temporal.ChronoUnit.DAYS.between(longProject.getStartDate(),
				longProject.getEndDate());
		boolean adequateTeamSize = projectDuration > 300 && longProject.getTeam().size() >= 5;
		System.out.println("Proyecto largo tiene equipo adecuado: " + (adequateTeamSize ? "PASS" : "FAIL"));

		// Test: Proyectos con equipo diverso
		Project diverseProject = ProjectTestData.createValidProject();
		Employee[] diverseTeam = { new Employee("Developer", "IT", 60000.0, "dev@company.com"),
				new Employee("Designer", "Design", 55000.0, "design@company.com"),
				new Employee("Manager", "Management", 80000.0, "mgr@company.com") };

		for (Employee emp : diverseTeam) {
			diverseProject.addTeamMember(emp);
		}

		boolean hasDiverseTeam = hasDiverseDepartments(diverseProject);
		System.out.println("Proyecto tiene equipo diverso: " + (hasDiverseTeam ? "PASS" : "FAIL"));

		// Test: Proyectos activos vs vencidos
		Project activeProject = ProjectTestData.createValidProject();
		Project expiredProject = ProjectTestData.createExpiredProject();

		boolean activeIsActive = activeProject.getEndDate().isAfter(LocalDate.now());
		boolean expiredIsExpired = expiredProject.getEndDate().isBefore(LocalDate.now());

		System.out.println("Proyecto activo esta activo: " + (activeIsActive ? "PASS" : "FAIL"));
		System.out.println("Proyecto vencido esta vencido: " + (expiredIsExpired ? "PASS" : "FAIL"));
	}

	private static boolean hasDiverseDepartments(Project project) {
		if (project.getTeam().size() < 2)
			return false;

		String firstDepartment = project.getTeam().get(0).getDepartment();
		for (Employee emp : project.getTeam()) {
			if (!emp.getDepartment().equals(firstDepartment)) {
				return true;
			}
		}
		return false;
	}
}