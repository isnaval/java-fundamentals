package java_advanced_testing.mock_test;

import java_advanced_testing.resources.mock_responses.ProjectTestData;

public class ProjectApiTest {
	public static void main(String[] args) {
		System.out.println("PROJECT API MOCK TESTS");
		System.out.println("======================");

		testValidProject();
		testExpiredProject();

		System.out.println("\nProject API tests completados");
	}

	public static void testValidProject() {
		System.out.println("\n--- Test: Valid Project ---");

		String response = ProjectTestData.createValidProjectResponse();
		System.out.println("Response: " + response);

		boolean hasId = response.contains("\"id\": 1");
		boolean hasName = response.contains("Sistema de Gestión");
		boolean hasStartDate = response.contains("startDate");
		boolean hasEndDate = response.contains("endDate");

		System.out.println("Has ID: " + (hasId ? "PASS" : "FAIL"));
		System.out.println("Has name: " + (hasName ? "PASS" : "FAIL"));
		System.out.println("Has start date: " + (hasStartDate ? "PASS" : "FAIL"));
		System.out.println("Has end date: " + (hasEndDate ? "PASS" : "FAIL"));

		boolean isActive = !response.contains("Expired");
		System.out.println("Is active: " + (isActive ? "YES" : "NO"));
	}

	public static void testExpiredProject() {
		System.out.println("\n--- Test: Expired Project ---");

		String response = ProjectTestData.createExpiredProjectResponse();
		System.out.println("Response: " + response);

		boolean hasId2 = response.contains("\"id\": 2");
		boolean isExpired = response.contains("Expired");
		boolean hasVencidoName = response.contains("Vencido");
		boolean hasStatus = response.contains("status");

		System.out.println("Has ID 2: " + (hasId2 ? "PASS" : "FAIL"));
		System.out.println("Is expired: " + (isExpired ? "PASS" : "FAIL"));
		System.out.println("Has vencido name: " + (hasVencidoName ? "PASS" : "FAIL"));
		System.out.println("Has status field: " + (hasStatus ? "PASS" : "FAIL"));

		boolean canModify = !isExpired;
		boolean needsArchiving = isExpired;

		System.out.println("Can modify: " + (canModify ? "YES" : "NO"));
		System.out.println("Needs archiving: " + (needsArchiving ? "YES" : "NO"));
	}

}
