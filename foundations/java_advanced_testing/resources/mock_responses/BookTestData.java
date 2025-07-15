package java_advanced_testing.resources.mock_responses;

import java_advanced_testing.model.Book;

public class BookTestData {
	public static String createValidBookResponse() {
		Book book = new Book(TestDataConstants.BOOK_TITLE, TestDataConstants.BOOK_AUTHOR, TestDataConstants.BOOK_ISBN,
				TestDataConstants.BOOK_PRICE);
		return String.format("{\"id\": 1, \"title\": \"%s\", \"author\": \"%s\", \"isbn\": \"%s\", \"price\": %.2f}",
				book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPrice());
	}

	public static String createFreeBookResponse() {
		Book book = new Book("Libro Gratuito", "Autor Público", "978-84-000-0000-0", 0.0);
		return String.format("{\"id\": 2, \"title\": \"%s\", \"author\": \"%s\", \"isbn\": \"%s\", \"price\": %.2f}",
				book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPrice());
	}
}
