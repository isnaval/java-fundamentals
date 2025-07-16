package java_advanced_testing.unit_tests.basic;

import java_advanced_testing.model.Book;
import java_advanced_testing.resources.test_data.BookTestData;
import java_advanced_testing.resources.test_data.TestDataConstants;

public class BookTest {
	// Test del constructor
	public static void testBookConstructor() {
		System.out.println("=== Test: Book Constructor ===");

		Book book = new Book("Test Title", "Test Author", "123456789", 25.99);

		assert book.getTitle().equals("Test Title") : "Title should be 'Test Title'";
		assert book.getAuthor().equals("Test Author") : "Author should be 'Test Author'";
		assert book.getIsbn().equals("123456789") : "ISBN should be '123456789'";
		assert book.getPrice() == 25.99 : "Price should be 25.99";

		System.out.println("✅ Constructor test passed");
	}

	// Test de getters
	public static void testBookGetters() {
		System.out.println("=== Test: Book Getters ===");

		Book book = BookTestData.createValidBook();

		assert book.getTitle().equals(TestDataConstants.BOOK_TITLE) : "Title getter failed";
		assert book.getAuthor().equals(TestDataConstants.BOOK_AUTHOR) : "Author getter failed";
		assert book.getIsbn().equals(TestDataConstants.BOOK_ISBN) : "ISBN getter failed";
		assert book.getPrice() == TestDataConstants.BOOK_PRICE : "Price getter failed";

		System.out.println("✅ Getters test passed");
	}

	// Test de setters
	public static void testBookSetters() {
		System.out.println("=== Test: Book Setters ===");

		Book book = BookTestData.createValidBook();

		book.setTitle("New Title");
		book.setAuthor("New Author");
		book.setIsbn("987654321");
		book.setPrice(49.99);

		assert book.getTitle().equals("New Title") : "Title setter failed";
		assert book.getAuthor().equals("New Author") : "Author setter failed";
		assert book.getIsbn().equals("987654321") : "ISBN setter failed";
		assert book.getPrice() == 49.99 : "Price setter failed";

		System.out.println("✅ Setters test passed");
	}

	// Test de toString
	public static void testBookToString() {
		System.out.println("=== Test: Book toString ===");

		Book book = BookTestData.createValidBook();
		String result = book.toString();

		assert result.contains("Book{") : "toString should contain 'Book{'";
		assert result.contains(book.getTitle()) : "toString should contain title";
		assert result.contains(book.getAuthor()) : "toString should contain author";
		assert result.contains(String.valueOf(book.getPrice())) : "toString should contain price";

		System.out.println("✅ toString test passed");
	}

	// Test con datos nulos
	public static void testBookWithNullValues() {
		System.out.println("=== Test: Book with Null Values ===");

		Book book = BookTestData.createBookWithoutTitle();

		assert book.getTitle() == null : "Title should be null";
		assert book.getAuthor() != null : "Author should not be null";

		System.out.println("✅ Null values test passed");
	}

	// Test con precio límite
	public static void testBookPriceLimits() {
		System.out.println("=== Test: Book Price Limits ===");

		Book freeBook = BookTestData.createFreeBook();
		Book expensiveBook = BookTestData.createExpensiveBook();

		assert freeBook.getPrice() == 0.0 : "Free book price should be 0.0";
		assert expensiveBook.getPrice() > 100.0 : "Expensive book should cost more than 100";

		System.out.println("✅ Price limits test passed");
	}

	// Método para ejecutar todos los tests
	public static void runAllTests() {
		System.out.println("🚀 Running all Book tests...\n");

		try {
			testBookConstructor();
			testBookGetters();
			testBookSetters();
			testBookToString();
			testBookWithNullValues();
			testBookPriceLimits();

			System.out.println("\n🎉 All Book tests passed!");
		} catch (AssertionError e) {
			System.out.println("\n❌ Test failed: " + e.getMessage());
		}
	}

}
