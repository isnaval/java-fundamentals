package java_advanced_testing.junit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java_advanced_testing.model.Customer;
import java_advanced_testing.resources.test_data.CustomerTestData;

public class CustomerJunitTest {
	private Customer customer;

	@BeforeEach
	public void setUp() {
		customer = new Customer("John Doe", "john@example.com", "+1234567890", 30);
	}

	@Test
	public void testCustomerConstructor() {
		assertEquals("John Doe", customer.getName());
		assertEquals("john@example.com", customer.getEmail());
		assertEquals("+1234567890", customer.getPhone());
		assertEquals(30, customer.getAge());
	}

	@Test
	public void testCustomerAgeCategories() {
		Customer minor = CustomerTestData.createMinorCustomer();
		Customer senior = CustomerTestData.createSeniorCustomer();

		assertTrue(minor.getAge() < 18);
		assertTrue(senior.getAge() >= 65);
	}

	@Test
	public void testCustomerEmailValidation() {
		assertTrue(customer.getEmail().contains("@"));
		assertTrue(customer.getEmail().contains(".com"));
	}

	@Test
	public void testCustomerSetters() {
		customer.setName("Jane Smith");
		customer.setAge(25);

		assertEquals("Jane Smith", customer.getName());
		assertEquals(25, customer.getAge());
	}

}
