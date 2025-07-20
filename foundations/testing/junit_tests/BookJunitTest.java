package java_advanced_testing.junit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java_advanced_testing.model.Book;
import java_advanced_testing.resources.test_data.BookTestData;

public class BookJunitTest {
	private Book book;

	@BeforeEach
	public void setUp() {
		book = new Book("Test Title", "Test Author", "123456789", 25.99);
	}

	@Test
	public void testBookConstructor() {
		assertEquals("Test Title", book.getTitle());
		assertEquals("Test Author", book.getAuthor());
		assertEquals("123456789", book.getIsbn());
		assertEquals(25.99, book.getPrice());
	}

	@Test
	public void testBookGetters() {
		Book testBook = BookTestData.createValidBook();

		assertNotNull(testBook.getTitle());
		assertNotNull(testBook.getAuthor());
		assertTrue(testBook.getPrice() > 0);
	}

	@Test
	public void testBookSetters() {
		book.setTitle("New Title");
		book.setPrice(49.99);

		assertEquals("New Title", book.getTitle());
		assertEquals(49.99, book.getPrice());
	}

	@Test
	public void testBookPriceValidation() {
		Book freeBook = BookTestData.createFreeBook();
		Book expensiveBook = BookTestData.createExpensiveBook();

		assertEquals(0.0, freeBook.getPrice());
		assertTrue(expensiveBook.getPrice() > 100.0);
	}

	@Test
	public void testBookToString() {
		String result = book.toString();

		assertNotNull(result);
		assertTrue(result.contains("Book"));
		assertTrue(result.contains(book.getTitle()));
	}

}
