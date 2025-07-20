package java_advanced_testing.resources.test_data;

import java_advanced_testing.model.Book;

public class BookTestData {

	public static Book createValidBook() {
		return new Book(TestDataConstants.BOOK_TITLE, TestDataConstants.BOOK_AUTHOR, TestDataConstants.BOOK_ISBN,
				TestDataConstants.BOOK_PRICE);
	}

	public static Book createBookWithoutTitle() {
		return new Book(null, TestDataConstants.BOOK_AUTHOR, TestDataConstants.BOOK_ISBN, TestDataConstants.BOOK_PRICE);
	}

	public static Book createExpensiveBook() {
		return new Book("Libro Premium", "Autor Exclusivo", "978-84-999-9999-9", 999.99);
	}

	public static Book createFreeBook() {
		return new Book("Libro Gratuito", "Autor Público", "978-84-000-0000-0", 0.0);
	}

	public static Book createBookWithNegativePrice() {
		return new Book("Precio erroneo del libro", null, null, 0);
	}

	public static Book createBookWithoutAuthor() {
		return new Book(null, "Libro sin autor", null, 0);
	}
}