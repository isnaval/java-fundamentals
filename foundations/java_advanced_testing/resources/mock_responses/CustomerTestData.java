package java_advanced_testing.resources.mock_responses;

import java_advanced_testing.model.Customer;

public class CustomerTestData {
	public static String createValidCustomerResponse() {
		Customer customer = new Customer(TestDataConstants.CUSTOMER_NAME, TestDataConstants.CUSTOMER_EMAIL,
				TestDataConstants.CUSTOMER_PHONE, TestDataConstants.CUSTOMER_AGE);
		return String.format("{\"id\": 1, \"name\": \"%s\", \"email\": \"%s\", \"phone\": \"%s\"}", customer.getName(),
				customer.getEmail(), customer.getPhone());
	}

	public static String createMinorCustomerResponse() {
		Customer customer = new Customer("María López", "maria.lopez@email.com", "+34 600 111 222", 20);
		return String.format("{\"id\": 2, \"name\": \"%s\", \"email\": \"%s\", \"phone\": \"%s\"}", customer.getName(),
				customer.getEmail(), customer.getPhone());
	}

	public static String createCustomerWithInvalidEmailResponse() {
		Customer customer = new Customer("Pedro Sánchez", "email-invalido", "+34 600 555 666", 12);
		return String.format("{\"error\": \"Invalid email: %s\", \"code\": 400}", customer.getEmail());
	}
}
