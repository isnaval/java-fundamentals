package java_advanced_testing.unit_tests.intermediate;

import java_advanced_testing.model.Book;
import java_advanced_testing.resources.test_data.BookTestData;
import java_advanced_testing.resources.test_data.TestDataConstants;

public class BookValidationTest {
	public static void main(String[] args) {
		System.out.println("BOOK VALIDATION TESTS");
		System.out.println("======================");

		testBookTitleValidation();
		testBookAuthorValidation();
		testBookPriceValidation();
		testBookIsbnValidation();
		testBookBusinessRules();

		System.out.println("\nBook validation tests completados");
	}

	public static void testBookTitleValidation() {
		System.out.println("\n--- Test: Book Title Validation ---");

		// Test titulo nulo
		Book bookNullTitle = BookTestData.createBookWithoutTitle();
		System.out.println("Book con titulo nulo: " + bookNullTitle.getTitle());
		System.out.println("   Resultado: " + (bookNullTitle.getTitle() == null ? "PASS" : "FAIL"));

		// Test titulo vacio
		Book bookEmptyTitle = new Book("", "Author", "ISBN", 19.99);
		System.out.println("Book con titulo vacio: '" + bookEmptyTitle.getTitle() + "'");
		System.out.println("   Resultado: " + (bookEmptyTitle.getTitle().isEmpty() ? "PASS" : "FAIL"));

		// Test titulo muy largo
		String longTitle = "Este es un titulo extremadamente largo que podria causar problemas en el sistema";
		Book bookLongTitle = new Book(longTitle, "Author", "ISBN", 19.99);
		System.out.println("Book con titulo largo: " + bookLongTitle.getTitle().length() + " caracteres");
		System.out.println("   Resultado: " + (bookLongTitle.getTitle().length() > 50 ? "PASS" : "FAIL"));

		// Test titulo normal
		Book bookNormalTitle = BookTestData.createValidBook();
		System.out.println("Book con titulo normal: " + bookNormalTitle.getTitle());
		System.out.println(
				"   Resultado: " + (bookNormalTitle.getTitle().equals(TestDataConstants.BOOK_TITLE) ? "PASS" : "FAIL"));
	}

	public static void testBookAuthorValidation() {
		System.out.println("\n--- Test: Book Author Validation ---");

		// Test autor nulo
		Book bookNullAuthor = BookTestData.createBookWithoutAuthor();
		System.out.println("Book con autor nulo: " + bookNullAuthor.getAuthor());
		System.out.println("   Resultado: " + (bookNullAuthor.getAuthor() == null ? "PASS" : "FAIL"));

		// Test autor con numeros
		Book bookAuthorWithNumbers = new Book("Title", "Author123", "ISBN", 19.99);
		System.out.println("Book con autor con numeros: " + bookAuthorWithNumbers.getAuthor());
		System.out.println("   Resultado: " + (bookAuthorWithNumbers.getAuthor().contains("123") ? "PASS" : "FAIL"));

		// Test autor con caracteres especiales
		Book bookAuthorSpecial = new Book("Title", "Author@#$", "ISBN", 19.99);
		System.out.println("Book con autor con caracteres especiales: " + bookAuthorSpecial.getAuthor());
		System.out.println("   Resultado: " + (bookAuthorSpecial.getAuthor().contains("@") ? "PASS" : "FAIL"));
	}

	public static void testBookPriceValidation() {
		System.out.println("\n--- Test: Book Price Validation ---");

		// Test precio negativo
		Book bookNegativePrice = BookTestData.createBookWithNegativePrice();
		System.out.println("Book con precio negativo: $" + bookNegativePrice.getPrice());
		System.out.println("   Resultado: " + (bookNegativePrice.getPrice() < 0 ? "PASS" : "FAIL"));

		// Test precio cero
		Book bookZeroPrice = BookTestData.createFreeBook();
		System.out.println("Book con precio cero: $" + bookZeroPrice.getPrice());
		System.out.println("   Resultado: " + (bookZeroPrice.getPrice() == 0.0 ? "PASS" : "FAIL"));

		// Test precio muy alto
		Book bookHighPrice = BookTestData.createExpensiveBook();
		System.out.println("Book con precio alto: $" + bookHighPrice.getPrice());
		System.out.println("   Resultado: " + (bookHighPrice.getPrice() > 500.0 ? "PASS" : "FAIL"));

		// Test precio con decimales
		Book bookDecimalPrice = new Book("Title", "Author", "ISBN", 19.99);
		System.out.println("Book con precio decimal: $" + bookDecimalPrice.getPrice());
		System.out.println("   Resultado: " + (bookDecimalPrice.getPrice() == 19.99 ? "PASS" : "FAIL"));
	}

	public static void testBookIsbnValidation() {
		System.out.println("\n--- Test: Book ISBN Validation ---");

		// Test ISBN formato correcto
		Book bookValidISBN = BookTestData.createValidBook();
		System.out.println("Book con ISBN valido: " + bookValidISBN.getIsbn());
		System.out.println("   Resultado: " + (bookValidISBN.getIsbn().contains("978-84") ? "PASS" : "FAIL"));

		// Test ISBN corto
		Book bookShortISBN = new Book("Title", "Author", "123", 19.99);
		System.out.println("Book con ISBN corto: " + bookShortISBN.getIsbn());
		System.out.println("   Resultado: " + (bookShortISBN.getIsbn().length() < 10 ? "PASS" : "FAIL"));

		// Test ISBN nulo
		Book bookNullISBN = new Book("Title", "Author", null, 19.99);
		System.out.println("Book con ISBN nulo: " + bookNullISBN.getIsbn());
		System.out.println("   Resultado: " + (bookNullISBN.getIsbn() == null ? "PASS" : "FAIL"));
	}

	public static void testBookBusinessRules() {
		System.out.println("\n--- Test: Book Business Rules ---");

		// Test: Los libros gratuitos deben tener autor publico
		Book freeBook = BookTestData.createFreeBook();
		boolean isFreeBookRule = freeBook.getPrice() == 0.0 && freeBook.getAuthor().contains("Público");
		System.out.println("Regla libro gratuito: " + (isFreeBookRule ? "PASS" : "FAIL"));

		// Test: Los libros caros deben tener autor exclusivo
		Book expensiveBook = BookTestData.createExpensiveBook();
		boolean isExpensiveBookRule = expensiveBook.getPrice() > 100.0
				&& expensiveBook.getAuthor().contains("Exclusivo");
		System.out.println("Regla libro caro: " + (isExpensiveBookRule ? "PASS" : "FAIL"));

		// Test: Los libros deben tener titulo y autor
		Book validBook = BookTestData.createValidBook();
		boolean hasRequiredFields = validBook.getTitle() != null && validBook.getAuthor() != null;
		System.out.println("Regla campos requeridos: " + (hasRequiredFields ? "PASS" : "FAIL"));
	}

}
