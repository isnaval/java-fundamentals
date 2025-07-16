package java_advanced_testing.unit_tests.intermediate;

public class IntermediateTestRunner {

	public static void main(String[] args) {
		System.out.println("EJECUTANDO TESTS UNITARIOS INTERMEDIOS");
		System.out.println("=======================================");
		System.out.println("Tests mas avanzados con validaciones complejas\n");

		// Ejecutar todos los tests intermedios
		runBookValidationTests();
		runCustomerAgeValidationTests();
		runEmployeeSalaryValidationTests();
		runProductPriceValidationTests();
		runProjectTeamValidationTests();

		System.out.println("\n=======================================");
		System.out.println("TODOS LOS TESTS INTERMEDIOS COMPLETADOS");
		System.out.println("=======================================");
	}

	public static void runBookValidationTests() {
		System.out.println("=== EJECUTANDO BOOK VALIDATION TESTS ===");
		BookValidationTest.main(new String[] {});
		System.out.println();
	}

	public static void runCustomerAgeValidationTests() {
		System.out.println("=== EJECUTANDO CUSTOMER AGE VALIDATION TESTS ===");
		CustomerAgeValidationTest.main(new String[] {});
		System.out.println();
	}

	public static void runEmployeeSalaryValidationTests() {
		System.out.println("=== EJECUTANDO EMPLOYEE SALARY VALIDATION TESTS ===");
		EmployeeSalaryValidationTest.main(new String[] {});
		System.out.println();
	}

	public static void runProductPriceValidationTests() {
		System.out.println("=== EJECUTANDO PRODUCT PRICE VALIDATION TESTS ===");
		ProductPriceValidationTest.main(new String[] {});
		System.out.println();
	}

	public static void runProjectTeamValidationTests() {
		System.out.println("=== EJECUTANDO PROJECT TEAM VALIDATION TESTS ===");
		ProjectTeamValidationTest.main(new String[] {});
		System.out.println();
	}

	// Metodos para ejecutar tests individuales
	public static void runIndividualTest(String testName) {
		System.out.println("Ejecutando test individual: " + testName);

		switch (testName.toLowerCase()) {
		case "book":
			BookValidationTest.main(new String[] {});
			break;
		case "customer":
			CustomerAgeValidationTest.main(new String[] {});
			break;
		case "employee":
			EmployeeSalaryValidationTest.main(new String[] {});
			break;
		case "product":
			ProductPriceValidationTest.main(new String[] {});
			break;
		case "project":
			ProjectTeamValidationTest.main(new String[] {});
			break;
		default:
			System.out.println("Test no encontrado: " + testName);
			System.out.println("Tests disponibles: book, customer, employee, product, project");
		}
	}
}
