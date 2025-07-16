package java_advanced_testing.unit_tests.basic;

import java.time.LocalDate;

import java_advanced_testing.model.Employee;
import java_advanced_testing.model.Project;
import java_advanced_testing.resources.test_data.EmployeeTestData;
import java_advanced_testing.resources.test_data.ProjectTestData;
import java_advanced_testing.resources.test_data.TestDataConstants;

public class ProjectTest {

	// Test del constructor
	public static void testProjectConstructor() {
		System.out.println("=== Test: Project Constructor ===");

		LocalDate start = LocalDate.now();
		LocalDate end = LocalDate.now().plusDays(30);
		Project project = new Project("Web App", "E-commerce website", start, end);

		assert project.getName().equals("Web App") : "Name should be 'Web App'";
		assert project.getDescription().equals("E-commerce website") : "Description should match";
		assert project.getStartDate().equals(start) : "Start date should match";
		assert project.getEndDate().equals(end) : "End date should match";
		assert project.getTeam().isEmpty() : "Team should be empty initially";

		System.out.println("✅ Constructor test passed");
	}

	// Test de getters
	public static void testProjectGetters() {
		System.out.println("=== Test: Project Getters ===");

		Project project = ProjectTestData.createValidProject();

		assert project.getName().equals(TestDataConstants.PROJECT_NAME) : "Name getter failed";
		assert project.getDescription().equals(TestDataConstants.PROJECT_DESCRIPTION) : "Description getter failed";
		assert project.getStartDate() != null : "Start date should not be null";
		assert project.getEndDate() != null : "End date should not be null";
		assert project.getTeam() != null : "Team should not be null";

		System.out.println("✅ Getters test passed");
	}

	// Test de setters
	public static void testProjectSetters() {
		System.out.println("=== Test: Project Setters ===");

		Project project = ProjectTestData.createValidProject();
		LocalDate newStart = LocalDate.now().plusDays(10);
		LocalDate newEnd = LocalDate.now().plusDays(50);

		project.setName("Mobile App");
		project.setDescription("iOS and Android app");
		project.setStartDate(newStart);
		project.setEndDate(newEnd);

		assert project.getName().equals("Mobile App") : "Name setter failed";
		assert project.getDescription().equals("iOS and Android app") : "Description setter failed";
		assert project.getStartDate().equals(newStart) : "Start date setter failed";
		assert project.getEndDate().equals(newEnd) : "End date setter failed";

		System.out.println("✅ Setters test passed");
	}

	// Test de toString
	public static void testProjectToString() {
		System.out.println("=== Test: Project toString ===");

		Project project = ProjectTestData.createValidProject();
		String result = project.toString();

		assert result.contains("Project{") : "toString should contain 'Project{'";
		assert result.contains(project.getName()) : "toString should contain name";
		assert result.contains(project.getDescription()) : "toString should contain description";
		assert result.contains("team size") : "toString should contain team size";

		System.out.println("✅ toString test passed");
	}

	// Test de gestión de equipo
	public static void testProjectTeamManagement() {
		System.out.println("=== Test: Project Team Management ===");

		Project project = ProjectTestData.createValidProject();
		Employee employee1 = EmployeeTestData.createValidEmployee();
		Employee employee2 = EmployeeTestData.createHighSalaryEmployee();

		assert project.getTeam().size() == 0 : "Initial team should be empty";

		project.addTeamMember(employee1);
		assert project.getTeam().size() == 1 : "Team should have 1 member";
		assert project.getTeam().contains(employee1) : "Team should contain employee1";

		project.addTeamMember(employee2);
		assert project.getTeam().size() == 2 : "Team should have 2 members";
		assert project.getTeam().contains(employee2) : "Team should contain employee2";

		System.out.println("✅ Team management test passed");
	}

	// Test con proyecto que tiene equipo
	public static void testProjectWithTeam() {
		System.out.println("=== Test: Project With Team ===");

		Project project = ProjectTestData.createProjectWithTeam();

		assert project.getTeam().size() > 0 : "Project should have team members";
		assert project.getTeam().size() >= 3 : "Project should have at least 3 team members";

		System.out.println("✅ Project with team test passed");
	}

	// Test con fechas
	public static void testProjectDates() {
		System.out.println("=== Test: Project Dates ===");

		Project validProject = ProjectTestData.createValidProject();
		Project expiredProject = ProjectTestData.createExpiredProject();

		assert validProject.getStartDate().isBefore(validProject.getEndDate()) : "Start should be before end";
		assert validProject.getEndDate().isAfter(LocalDate.now()) : "Valid project should end in future";
		assert expiredProject.getEndDate().isBefore(LocalDate.now()) : "Expired project should end in past";

		System.out.println("✅ Project dates test passed");
	}

	// Método para ejecutar todos los tests
	public static void runAllTests() {
		System.out.println("🚀 Running all Project tests...\n");

		try {
			testProjectConstructor();
			testProjectGetters();
			testProjectSetters();
			testProjectToString();
			testProjectTeamManagement();
			testProjectWithTeam();
			testProjectDates();

			System.out.println("\n🎉 All Project tests passed!");
		} catch (AssertionError e) {
			System.out.println("\n❌ Test failed: " + e.getMessage());
		}
	}
}