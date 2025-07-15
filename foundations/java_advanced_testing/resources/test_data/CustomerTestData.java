package java_advanced_testing.resources.test_data;

import java_advanced_testing.model.Customer;

public class CustomerTestData {

	public static Customer createValidCustomer() {
		return new Customer(TestDataConstants.CUSTOMER_NAME, TestDataConstants.CUSTOMER_EMAIL,
				TestDataConstants.CUSTOMER_PHONE, TestDataConstants.CUSTOMER_AGE);
	}

	public static Customer createMinorCustomer() {
		return new Customer("María López", "maria.lopez@email.com", "+34 600 111 222", 16);
	}

	public static Customer createSeniorCustomer() {
		return new Customer("José Martínez", "jose.martinez@email.com", "+34 600 333 444", 65);
	}

	public static Customer createCustomerWithInvalidEmail() {
		return new Customer("Pedro Sánchez", "email-invalido", "+34 600 555 666", 25);
	}
}