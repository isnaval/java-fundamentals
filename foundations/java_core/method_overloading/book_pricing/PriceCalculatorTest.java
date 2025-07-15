package java_core.method_overloading.book_pricing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PriceCalculatorTest {

	private PriceCalculator calculator;

	@BeforeEach
	void setUp() {
		calculator = new PriceCalculator();
	}

	@Test
	void testApplyDiscountPercentage() {
		double result = calculator.applyDiscount(100.0, 10.0);
		assertEquals(90.0, result, 0.01);
	}

	@Test
	void testApplyDiscountFixed() {
		double result = calculator.applyDiscount(100.0, 15.0, "FIXED");
		assertEquals(85.0, result, 0.01);
	}

	@Test
	void testCalculateTotalArray() {
		double[] prices = { 10.0, 20.0, 30.0 };
		double result = calculator.calculateTotal(prices);
		assertEquals(60.0, result, 0.01);
	}

	@Test
	void testCalculateTotalWithTax() {
		double result = calculator.calculateTotal(100.0, 21.0);
		assertEquals(121.0, result, 0.01);
	}

	@Test
	void testApplyDiscountNegativePrice() {
		assertThrows(IllegalArgumentException.class, () -> {
			calculator.applyDiscount(-10.0, 5.0);
		});
	}
}
