package java_advanced_testing.resources.mock_responses;

import java_advanced_testing.model.Customer;

public class MockCustomerResponses {
	public static String getValidCustomerResponse() {
		Customer customer = new Customer(TestDataConstants.CUSTOMER_NAME, TestDataConstants.CUSTOMER_EMAIL,
				TestDataConstants.CUSTOMER_PHONE, TestDataConstants.CUSTOMER_AGE);
		return String.format("{\"id\": 1, \"name\": \"%s\", \"email\": \"%s\", \"phone\": \"%s\"}", customer.getName(),
				customer.getEmail(), customer.getPhone());
	}

	public static String getInvalidEmailCustomerResponse() {
		return "{\"error\": \"Invalid email format\", \"code\": 400}";
	}

	public static String getMinorCustomerResponse() {
		Customer customer = new Customer("María López", "maria.lopez@email.com", "+34 600 111 222", 25);
		return String.format(
				"{\"id\": 2, \"name\": \"%s\", \"email\": \"%s\", \"phone\": \"%s\", \"message\": \"Customer is a minor\"}",
				customer.getName(), customer.getEmail(), customer.getPhone());
	}
}
