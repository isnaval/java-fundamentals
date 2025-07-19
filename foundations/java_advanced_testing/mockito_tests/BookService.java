package java_advanced_testing.mockito_tests;

import java_advanced_testing.model.Book;

public class BookService {
	private BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public Book getBookByIsbn(String isbn) {
		return bookRepository.findByIsbn(isbn);
	}

	public boolean createBook(Book book) {
		if (book.getPrice() < 0) {
			return false;
		}
		return bookRepository.save(book);
	}
}
