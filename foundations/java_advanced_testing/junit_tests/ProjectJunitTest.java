package java_advanced_testing.junit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java_advanced_testing.model.Employee;
import java_advanced_testing.model.Project;
import java_advanced_testing.resources.test_data.EmployeeTestData;
import java_advanced_testing.resources.test_data.ProjectTestData;

public class ProjectJunitTest {
	private Project project;

	@BeforeEach
	public void setUp() {
		project = ProjectTestData.createValidProject();
	}

	@Test
	public void testProjectCreation() {
		assertNotNull(project.getName());
		assertNotNull(project.getDescription());
		assertNotNull(project.getStartDate());
		assertNotNull(project.getEndDate());
		assertTrue(project.getStartDate().isBefore(project.getEndDate()));
	}

	@Test
	public void testProjectTeamManagement() {
		Employee employee1 = EmployeeTestData.createValidEmployee();
		Employee employee2 = EmployeeTestData.createHighSalaryEmployee();

		assertEquals(0, project.getTeam().size());

		project.addTeamMember(employee1);
		assertEquals(1, project.getTeam().size());
		assertTrue(project.getTeam().contains(employee1));

		project.addTeamMember(employee2);
		assertEquals(2, project.getTeam().size());
		assertTrue(project.getTeam().contains(employee2));
	}

	@Test
	public void testProjectDates() {
		Project validProject = ProjectTestData.createValidProject();
		Project expiredProject = ProjectTestData.createExpiredProject();

		assertTrue(validProject.getEndDate().isAfter(java.time.LocalDate.now()));
		assertTrue(expiredProject.getEndDate().isBefore(java.time.LocalDate.now()));
	}

}
