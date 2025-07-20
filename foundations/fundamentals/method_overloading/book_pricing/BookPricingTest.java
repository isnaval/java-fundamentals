package fundamentals.method_overloading.book_pricing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookPricingTest {

	private BookPricing pricing;
	private Book testBook;

	@BeforeEach
	void setUp() {
		pricing = new BookPricing();
		testBook = new Book("Test Book", "Test Author", 20.0, "Test");
	}

	@Test
	void testCalculatePriceBasic() {
		double result = pricing.calculatePrice(testBook);
		assertEquals(20.0, result, 0.01);
	}

	@Test
	void testCalculatePriceWithPercentage() {
		double result = pricing.calculatePrice(testBook, 10.0);
		assertEquals(18.0, result, 0.01);
	}

	@Test
	void testCalculatePriceWithDiscountType() {
		double result = pricing.calculatePrice(testBook, DiscountType.STUDENT);
		assertEquals(17.0, result, 0.01);
	}

	@Test
	void testCalculatePriceWithQuantity() {
		double result = pricing.calculatePrice(testBook, 5);
		assertEquals(90.0, result, 0.01);
	}

	@Test
	void testCalculatePriceWithArray() {
		Book[] books = { testBook, testBook, testBook };
		double result = pricing.calculatePrice(books);
		assertEquals(60.0, result, 0.01);
	}

	@Test
	void testCalculatePriceWithMembership() {
		double result = pricing.calculatePrice(testBook, true);
		assertEquals(18.0, result, 0.01);
	}

	@Test
	void testCalculatePriceWithCoupon() {
		double result = pricing.calculatePrice(testBook, "SAVE10");
		assertEquals(18.0, result, 0.01);
	}

//	@Test
	// void testCalculatePriceWithNullBook() {
	// assertThrows(IllegalArgumentException.class, () -> {
	// pricing.calculatePrice(null);
	// });
//	}

	@Test
	void testCalculatePriceWithNullBook() {
		Book nullBook = null;
		assertThrows(IllegalArgumentException.class, () -> {
			pricing.calculatePrice(nullBook);
		});
	}

	@Test
	void testCalculatePriceWithInvalidDiscount() {
		assertThrows(IllegalArgumentException.class, () -> {
			pricing.calculatePrice(testBook, -5.0);
		});
	}
}
