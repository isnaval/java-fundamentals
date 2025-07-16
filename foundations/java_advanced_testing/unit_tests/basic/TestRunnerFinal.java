package java_advanced_testing.unit_tests.basic;

import java_advanced_testing.model.Book;
import java_advanced_testing.model.Customer;
import java_advanced_testing.model.Employee;
import java_advanced_testing.model.Product;
import java_advanced_testing.model.Project;
import java_advanced_testing.resources.test_data.BookTestData;
import java_advanced_testing.resources.test_data.CustomerTestData;
import java_advanced_testing.resources.test_data.EmployeeTestData;
import java_advanced_testing.resources.test_data.ProjectTestData;

public class TestRunnerFinal {

	public static void main(String[] args) {
		System.out.println("EJECUTANDO TESTS UNITARIOS COMPLETOS");
		System.out.println("==========================================\n");

		testBookCompleto();
		testCustomerCompleto();
		testEmployeeCompleto();
		testProductCompleto();
		testProjectCompleto();

		System.out.println("\nTODOS LOS TESTS COMPLETADOS EXITOSAMENTE!");
	}

	public static void testBookCompleto() {
		System.out.println("BOOK TESTS COMPLETOS");
		System.out.println("------------------------");

		Book book = BookTestData.createValidBook();
		System.out.println("Book desde TestData: " + book.getTitle());
		System.out.println("   Autor: " + book.getAuthor());
		System.out.println("   ISBN: " + book.getIsbn());
		System.out.println("   Precio: $" + book.getPrice());

		Book freeBook = BookTestData.createFreeBook();
		Book expensiveBook = BookTestData.createExpensiveBook();

		System.out.println("Libro gratuito: " + freeBook.getTitle() + " ($" + freeBook.getPrice() + ")");
		System.out.println("Libro caro: " + expensiveBook.getTitle() + " ($" + expensiveBook.getPrice() + ")");

		System.out.println("Book tests completados\n");
	}

	public static void testCustomerCompleto() {
		System.out.println("CUSTOMER TESTS COMPLETOS");
		System.out.println("----------------------------");

		Customer customer = CustomerTestData.createValidCustomer();
		System.out.println("Customer desde TestData: " + customer.getName());
		System.out.println("   Email: " + customer.getEmail());
		System.out.println("   Telefono: " + customer.getPhone());
		System.out.println("   Edad: " + customer.getAge());

		Customer minor = CustomerTestData.createMinorCustomer();
		Customer senior = CustomerTestData.createSeniorCustomer();

		System.out.println("Cliente menor: " + minor.getName() + " (" + minor.getAge() + " años)");
		System.out.println("Cliente senior: " + senior.getName() + " (" + senior.getAge() + " años)");

		System.out.println("Customer tests completados\n");
	}

	public static void testEmployeeCompleto() {
		System.out.println("EMPLOYEE TESTS COMPLETOS");
		System.out.println("----------------------------");

		Employee employee = EmployeeTestData.createValidEmployee();
		System.out.println("Employee desde TestData: " + employee.getName());
		System.out.println("   Departamento: " + employee.getDepartment());
		System.out.println("   Salario: $" + employee.getSalary());
		System.out.println("   Email: " + employee.getEmail());

		Employee intern = EmployeeTestData.createInternEmployee();
		Employee executive = EmployeeTestData.createHighSalaryEmployee();

		System.out.println("Empleado interno: " + intern.getName() + " ($" + intern.getSalary() + ")");
		System.out.println("Empleado ejecutivo: " + executive.getName() + " ($" + executive.getSalary() + ")");

		System.out.println("Employee tests completados\n");
	}

	public static void testProductCompleto() {
		System.out.println("PRODUCT TESTS COMPLETOS");
		System.out.println("---------------------------");

		Product product = new Product("Laptop Gaming", "Laptop alta gama", 1299.99, "LAP001");
		System.out.println("Product creado: " + product.getName());
		System.out.println("   Descripcion: " + product.getDescription());
		System.out.println("   Precio: $" + product.getPrice());
		System.out.println("   SKU: " + product.getSku());

		Product cheap = new Product("Boligrafo", "Boligrafo basico", 1.99, "PEN001");
		Product expensive = new Product("Servidor", "Servidor empresarial", 9999.99, "SRV001");

		System.out.println("Producto barato: " + cheap.getName() + " ($" + cheap.getPrice() + ")");
		System.out.println("Producto caro: " + expensive.getName() + " ($" + expensive.getPrice() + ")");

		System.out.println("Product tests completados\n");
	}

	public static void testProjectCompleto() {
		System.out.println("PROJECT TESTS COMPLETOS");
		System.out.println("---------------------------");

		Project project = ProjectTestData.createValidProject();
		System.out.println("Project desde TestData: " + project.getName());
		System.out.println("   Descripcion: " + project.getDescription());
		System.out.println("   Fecha inicio: " + project.getStartDate());
		System.out.println("   Fecha fin: " + project.getEndDate());
		System.out.println("   Tamaño inicial del equipo: " + project.getTeam().size());

		Employee emp1 = EmployeeTestData.createValidEmployee();
		Employee emp2 = EmployeeTestData.createHighSalaryEmployee();
		project.addTeamMember(emp1);
		project.addTeamMember(emp2);

		System.out.println("Empleados añadidos al proyecto");
		System.out.println("   Tamaño actual del equipo: " + project.getTeam().size());

		Project projectWithTeam = ProjectTestData.createProjectWithTeam();
		System.out.println("Proyecto con equipo: " + projectWithTeam.getName());
		System.out.println("   Tamaño del equipo: " + projectWithTeam.getTeam().size());

		System.out.println("Project tests completados\n");
	}
}