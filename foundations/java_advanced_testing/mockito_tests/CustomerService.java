package java_advanced_testing.mockito_tests;

import java_advanced_testing.model.Customer;

public class CustomerService {
	public Customer findCustomerById(Long id) {
		// En la vida real, esto buscaría en base de datos
		return null;
	}

	public boolean saveCustomer(Customer customer) {
		// En la vida real, esto guardaría en base de datos
		return false;
	}

}
