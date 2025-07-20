package java_advanced_testing.resources.test_data;

import java.time.LocalDate;

import java_advanced_testing.model.Project;

public class ProjectTestData {
	public static Project createValidProject() {
		return new Project(TestDataConstants.PROJECT_NAME, TestDataConstants.PROJECT_DESCRIPTION, LocalDate.now(),
				LocalDate.now().plusDays(90));
	}

	public static Project createShortProject() {
		return new Project("Proyecto Rápido", "Proyecto de corta duración", LocalDate.now(),
				LocalDate.now().plusDays(7));
	}

	public static Project createProjectWithTeam() {
		Project project = new Project("Proyecto con Equipo", "Proyecto que incluye un equipo de trabajo",
				LocalDate.now(), LocalDate.now().plusDays(60));

		// Añadir empleados al equipo
		project.addTeamMember(EmployeeTestData.createValidEmployee());
		project.addTeamMember(EmployeeTestData.createHighSalaryEmployee());

		return project;
	}

	public static Project createExpiredProject() {
		return new Project("Proyecto Vencido", "Proyecto que ya terminó", LocalDate.now().minusDays(30),
				LocalDate.now().minusDays(1));
	}

}
