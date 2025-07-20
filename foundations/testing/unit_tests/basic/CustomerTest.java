package java_advanced_testing.unit_tests.basic;

import java_advanced_testing.model.Customer;
import java_advanced_testing.resources.test_data.CustomerTestData;
import java_advanced_testing.resources.test_data.TestDataConstants;

public class CustomerTest {

	// Test del constructor
	public static void testCustomerConstructor() {
		System.out.println("=== Test: Customer Constructor ===");

		Customer customer = new Customer("John Doe", "john@example.com", "+1234567890", 30);

		assert customer.getName().equals("John Doe") : "Name should be 'John Doe'";
		assert customer.getEmail().equals("john@example.com") : "Email should be 'john@example.com'";
		assert customer.getPhone().equals("+1234567890") : "Phone should be '+1234567890'";
		assert customer.getAge() == 30 : "Age should be 30";

		System.out.println("✅ Constructor test passed");
	}

	// Test de getters
	public static void testCustomerGetters() {
		System.out.println("=== Test: Customer Getters ===");

		Customer customer = CustomerTestData.createValidCustomer();

		assert customer.getName().equals(TestDataConstants.CUSTOMER_NAME) : "Name getter failed";
		assert customer.getEmail().equals(TestDataConstants.CUSTOMER_EMAIL) : "Email getter failed";
		assert customer.getPhone().equals(TestDataConstants.CUSTOMER_PHONE) : "Phone getter failed";
		assert customer.getAge() == TestDataConstants.CUSTOMER_AGE : "Age getter failed";

		System.out.println("✅ Getters test passed");
	}

	// Test de setters
	public static void testCustomerSetters() {
		System.out.println("=== Test: Customer Setters ===");

		Customer customer = CustomerTestData.createValidCustomer();

		customer.setName("Jane Smith");
		customer.setEmail("jane@example.com");
		customer.setPhone("+9876543210");
		customer.setAge(25);

		assert customer.getName().equals("Jane Smith") : "Name setter failed";
		assert customer.getEmail().equals("jane@example.com") : "Email setter failed";
		assert customer.getPhone().equals("+9876543210") : "Phone setter failed";
		assert customer.getAge() == 25 : "Age setter failed";

		System.out.println("✅ Setters test passed");
	}

	// Test de toString
	public static void testCustomerToString() {
		System.out.println("=== Test: Customer toString ===");

		Customer customer = CustomerTestData.createValidCustomer();
		String result = customer.toString();

		assert result.contains("Customer{") : "toString should contain 'Customer{'";
		assert result.contains(customer.getName()) : "toString should contain name";
		assert result.contains(customer.getEmail()) : "toString should contain email";
		assert result.contains(String.valueOf(customer.getAge())) : "toString should contain age";

		System.out.println("✅ toString test passed");
	}

	// Test con diferentes edades
	public static void testCustomerAgeCategories() {
		System.out.println("=== Test: Customer Age Categories ===");

		Customer minor = CustomerTestData.createMinorCustomer();
		Customer senior = CustomerTestData.createSeniorCustomer();
		Customer adult = CustomerTestData.createValidCustomer();

		assert minor.getAge() < 18 : "Minor customer should be under 18";
		assert senior.getAge() >= 65 : "Senior customer should be 65 or older";
		assert adult.getAge() >= 18 && adult.getAge() < 65 : "Adult customer should be between 18-64";

		System.out.println("✅ Age categories test passed");
	}

	// Test con email inválido
	public static void testCustomerInvalidEmail() {
		System.out.println("=== Test: Customer Invalid Email ===");

		Customer customer = CustomerTestData.createCustomerWithInvalidEmail();

		assert !customer.getEmail().contains("@") : "Invalid email should not contain @";
		assert customer.getName() != null : "Customer should still have a name";

		System.out.println("✅ Invalid email test passed");
	}

	// Método para ejecutar todos los tests
	public static void runAllTests() {
		System.out.println("🚀 Running all Customer tests...\n");

		try {
			testCustomerConstructor();
			testCustomerGetters();
			testCustomerSetters();
			testCustomerToString();
			testCustomerAgeCategories();
			testCustomerInvalidEmail();

			System.out.println("\n🎉 All Customer tests passed!");
		} catch (AssertionError e) {
			System.out.println("\n❌ Test failed: " + e.getMessage());
		}
	}

}
