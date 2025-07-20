package java_advanced_testing.unit_tests.intermediate;

import java_advanced_testing.model.Customer;
import java_advanced_testing.resources.test_data.CustomerTestData;

public class CustomerAgeValidationTest {

	public static void main(String[] args) {
		System.out.println("CUSTOMER AGE VALIDATION TESTS");
		System.out.println("==============================");

		testAgeCategories();
		testAgeValidation();
		testAgeBusinessRules();
		testCustomerPermissions();

		System.out.println("\nCustomer age validation tests completados");
	}

	public static void testAgeCategories() {
		System.out.println("\n--- Test: Age Categories ---");

		// Test menor de edad
		Customer minor = CustomerTestData.createMinorCustomer();
		System.out.println("Cliente menor: " + minor.getName() + " (" + minor.getAge() + " años)");
		System.out.println("   Es menor de edad: " + (minor.getAge() < 18 ? "PASS" : "FAIL"));

		// Test adulto joven
		Customer youngAdult = new Customer("Joven Adulto", "joven@email.com", "123456", 25);
		System.out.println("Cliente joven adulto: " + youngAdult.getName() + " (" + youngAdult.getAge() + " años)");
		System.out.println(
				"   Es adulto joven: " + (youngAdult.getAge() >= 18 && youngAdult.getAge() < 30 ? "PASS" : "FAIL"));

		// Test adulto
		Customer adult = CustomerTestData.createValidCustomer();
		System.out.println("Cliente adulto: " + adult.getName() + " (" + adult.getAge() + " años)");
		System.out.println("   Es adulto: " + (adult.getAge() >= 30 && adult.getAge() < 65 ? "PASS" : "FAIL"));

		// Test senior
		Customer senior = CustomerTestData.createSeniorCustomer();
		System.out.println("Cliente senior: " + senior.getName() + " (" + senior.getAge() + " años)");
		System.out.println("   Es senior: " + (senior.getAge() >= 65 ? "PASS" : "FAIL"));
	}

	public static void testAgeValidation() {
		System.out.println("\n--- Test: Age Validation ---");

		// Test edad negativa
		Customer negativeAge = new Customer("Nombre", "email@test.com", "123456", -5);
		System.out.println("Cliente con edad negativa: " + negativeAge.getAge());
		System.out.println("   Edad negativa: " + (negativeAge.getAge() < 0 ? "PASS" : "FAIL"));

		// Test edad cero
		Customer zeroAge = new Customer("Nombre", "email@test.com", "123456", 0);
		System.out.println("Cliente con edad cero: " + zeroAge.getAge());
		System.out.println("   Edad cero: " + (zeroAge.getAge() == 0 ? "PASS" : "FAIL"));

		// Test edad muy alta
		Customer veryOld = new Customer("Nombre", "email@test.com", "123456", 150);
		System.out.println("Cliente muy mayor: " + veryOld.getAge());
		System.out.println("   Edad muy alta: " + (veryOld.getAge() > 120 ? "PASS" : "FAIL"));

		// Test edad limite
		Customer limitAge = new Customer("Nombre", "email@test.com", "123456", 18);
		System.out.println("Cliente edad limite: " + limitAge.getAge());
		System.out.println("   Edad limite: " + (limitAge.getAge() == 18 ? "PASS" : "FAIL"));
	}

	public static void testAgeBusinessRules() {
		System.out.println("\n--- Test: Age Business Rules ---");

		// Test: Menores no pueden tener ciertos servicios
		Customer minor = CustomerTestData.createMinorCustomer();
		boolean canHaveCreditCard = minor.getAge() >= 18;
		System.out.println("Menor puede tener tarjeta credito: " + (canHaveCreditCard ? "FAIL" : "PASS"));

		// Test: Seniors tienen descuentos
		Customer senior = CustomerTestData.createSeniorCustomer();
		boolean hasDiscount = senior.getAge() >= 65;
		System.out.println("Senior tiene descuento: " + (hasDiscount ? "PASS" : "FAIL"));

		// Test: Adultos tienen acceso completo
		Customer adult = CustomerTestData.createValidCustomer();
		boolean hasFullAccess = adult.getAge() >= 18 && adult.getAge() < 65;
		System.out.println("Adulto tiene acceso completo: " + (hasFullAccess ? "PASS" : "FAIL"));
	}

	public static void testCustomerPermissions() {
		System.out.println("\n--- Test: Customer Permissions ---");

		// Test permisos por edad
		Customer[] customers = { CustomerTestData.createMinorCustomer(), CustomerTestData.createValidCustomer(),
				CustomerTestData.createSeniorCustomer() };

		for (Customer customer : customers) {
			String permissions = getPermissionsByAge(customer.getAge());
			System.out.println(customer.getName() + " (" + customer.getAge() + " años) - Permisos: " + permissions);
		}
	}

	private static String getPermissionsByAge(int age) {
		if (age < 18)
			return "LIMITADO";
		else if (age >= 18 && age < 65)
			return "COMPLETO";
		else
			return "COMPLETO + DESCUENTOS";
	}
}