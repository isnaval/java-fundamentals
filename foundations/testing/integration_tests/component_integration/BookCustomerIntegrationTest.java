package java_advanced_testing.integration_tests.component_integration;

import java_advanced_testing.model.Book;
import java_advanced_testing.model.Customer;
import java_advanced_testing.resources.test_data.BookTestData;
import java_advanced_testing.resources.test_data.CustomerTestData;

public class BookCustomerIntegrationTest {
	public static void main(String[] args) {
		System.out.println("BOOK CUSTOMER INTEGRATION TEST");
		System.out.println("===============================");

		testCustomerBuysBook();
		testCustomerAgeRestriction();
		testCustomerBookPreferences();

		System.out.println("\nBook Customer integration tests completados");
	}

	public static void testCustomerBuysBook() {
		System.out.println("\n--- Test: Customer Buys Book ---");

		Book book = BookTestData.createValidBook();
		Customer customer = CustomerTestData.createValidCustomer();

		System.out.println("Libro: " + book.getTitle() + " - $" + book.getPrice());
		System.out.println("Cliente: " + customer.getName() + " (" + customer.getAge() + " años)");

		boolean customerCanAfford = simulateCanAfford(customer, book);
		boolean bookAvailable = book.getPrice() > 0;
		boolean purchaseSuccessful = customerCanAfford && bookAvailable;

		System.out.println("Puede permitirse el libro: " + (customerCanAfford ? "SI" : "NO"));
		System.out.println("Libro disponible: " + (bookAvailable ? "SI" : "NO"));
		System.out.println("Compra exitosa: " + (purchaseSuccessful ? "SI" : "NO"));

		if (purchaseSuccessful) {
			System.out.println("INTEGRATION TEST: PASS");
		} else {
			System.out.println("INTEGRATION TEST: FAIL");
		}
	}

	public static void testCustomerAgeRestriction() {
		System.out.println("\n--- Test: Customer Age Restriction ---");

		Customer minor = CustomerTestData.createMinorCustomer();
		Book adultBook = new Book("Libro para Adultos", "Autor Adulto", "978-84-111", 25.99);

		System.out.println("Cliente menor: " + minor.getName() + " (" + minor.getAge() + " años)");
		System.out.println("Libro para adultos: " + adultBook.getTitle());

		boolean isMinor = minor.getAge() < 18;
		boolean isAdultContent = adultBook.getTitle().contains("Adultos");
		boolean canPurchase = !isMinor || !isAdultContent;

		System.out.println("Es menor: " + (isMinor ? "SI" : "NO"));
		System.out.println("Contenido adulto: " + (isAdultContent ? "SI" : "NO"));
		System.out.println("Puede comprar: " + (canPurchase ? "SI" : "NO"));

		if (!canPurchase) {
			System.out.println("INTEGRATION TEST: PASS (restricción funcionó)");
		} else {
			System.out.println("INTEGRATION TEST: FAIL");
		}
	}

	public static void testCustomerBookPreferences() {
		System.out.println("\n--- Test: Customer Book Preferences ---");

		Customer customer = CustomerTestData.createValidCustomer();
		Book cheapBook = new Book("Libro Barato", "Autor Barato", "978-84-222", 9.99);
		Book expensiveBook = BookTestData.createExpensiveBook();

		System.out.println("Cliente: " + customer.getName());
		System.out.println("Libro barato: " + cheapBook.getTitle() + " - $" + cheapBook.getPrice());
		System.out.println("Libro caro: " + expensiveBook.getTitle() + " - $" + expensiveBook.getPrice());

		String preference = getCustomerPreference(customer, cheapBook, expensiveBook);

		System.out.println("Preferencia del cliente: " + preference);
		System.out.println("INTEGRATION TEST: PASS");
	}

	private static boolean simulateCanAfford(Customer customer, Book book) {
		return customer.getAge() >= 18 && book.getPrice() < 50.0;
	}

	private static String getCustomerPreference(Customer customer, Book cheapBook, Book expensiveBook) {
		if (customer.getAge() < 30) {
			return cheapBook.getTitle() + " (prefiere barato)";
		} else {
			return expensiveBook.getTitle() + " (prefiere calidad)";
		}
	}
}
