package java_advanced_testing.resources.mock_responses;

import java.time.LocalDate;

import java_advanced_testing.model.Project;

public class ProjectTestData {
	public static String createValidProjectResponse() {
		Project project = new Project(TestDataConstants.PROJECT_NAME, TestDataConstants.PROJECT_DESCRIPTION,
				LocalDate.now(), LocalDate.now().plusDays(TestDataConstants.PROJECT_DURATION_DAYS));
		return String.format(
				"{\"id\": 1, \"name\": \"%s\", \"description\": \"%s\", \"startDate\": \"%s\", \"endDate\": \"%s\"}",
				project.getName(), project.getDescription(), project.getStartDate(), project.getEndDate());
	}

	public static String createExpiredProjectResponse() {
		Project project = new Project("Proyecto Vencido", "Proyecto que ya terminó", LocalDate.now().minusDays(30),
				LocalDate.now().minusDays(1));
		return String.format(
				"{\"id\": 2, \"name\": \"%s\", \"description\": \"%s\", \"startDate\": \"%s\", \"endDate\": \"%s\", \"status\": \"Expired\"}",
				project.getName(), project.getDescription(), project.getStartDate(), project.getEndDate());
	}
}
