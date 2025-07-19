package java_advanced_testing.mock_test;

import java_advanced_testing.resources.mock_responses.MockProductResponses;

public class ProductApiTest {
	public static void main(String[] args) {
		System.out.println("PRODUCT API MOCK TESTS");
		System.out.println("======================");

		testValidProduct();
		testExpensiveProduct();
		testOutOfStockProduct();

		System.out.println("\nProduct API tests completados");
	}

	public static void testValidProduct() {
		System.out.println("\n--- Test: Valid Product ---");

		String response = MockProductResponses.getValidProductResponse();
		System.out.println("Response: " + response);

		// Tests simples
		boolean hasId = response.contains("\"id\": 1");
		boolean hasName = response.contains("Producto Estándar");
		boolean hasSku = response.contains("SKU12345");
		boolean hasPrice = response.contains("49.99");

		System.out.println("Has ID: " + (hasId ? "PASS" : "FAIL"));
		System.out.println("Has name: " + (hasName ? "PASS" : "FAIL"));
		System.out.println("Has SKU: " + (hasSku ? "PASS" : "FAIL"));
		System.out.println("Has price: " + (hasPrice ? "PASS" : "FAIL"));

		boolean reasonablePrice = response.contains("49.99");
		System.out.println("Reasonable price: " + (reasonablePrice ? "PASS" : "FAIL"));
	}

	public static void testExpensiveProduct() {
		System.out.println("\n--- Test: Expensive Product ---");

		String response = MockProductResponses.getExpensiveProductResponse();
		System.out.println("Response: " + response);

		boolean hasId2 = response.contains("\"id\": 2");
		boolean isPremium = response.contains("Premium");
		boolean isExpensive = response.contains("999.99");
		boolean hasPremiumSku = response.contains("SKU99999");

		System.out.println("Has ID 2: " + (hasId2 ? "PASS" : "FAIL"));
		System.out.println("Is premium: " + (isPremium ? "PASS" : "FAIL"));
		System.out.println("Is expensive: " + (isExpensive ? "PASS" : "FAIL"));
		System.out.println("Has premium SKU: " + (hasPremiumSku ? "PASS" : "FAIL"));

		boolean needsApproval = response.contains("999.99");
		System.out.println("Needs approval: " + (needsApproval ? "YES" : "NO"));
	}

	public static void testOutOfStockProduct() {
		System.out.println("\n--- Test: Out of Stock Product ---");

		String response = MockProductResponses.getOutOfStockProductResponse();
		System.out.println("Response: " + response);

		boolean hasId3 = response.contains("\"id\": 3");
		boolean isOutOfStock = response.contains("Out of Stock");
		boolean hasAgotadoName = response.contains("Agotado");
		boolean hasStatus = response.contains("status");

		System.out.println("Has ID 3: " + (hasId3 ? "PASS" : "FAIL"));
		System.out.println("Is out of stock: " + (isOutOfStock ? "PASS" : "FAIL"));
		System.out.println("Has agotado name: " + (hasAgotadoName ? "PASS" : "FAIL"));
		System.out.println("Has status field: " + (hasStatus ? "PASS" : "FAIL"));

		boolean canPurchase = !isOutOfStock;
		boolean showWaitlist = isOutOfStock;

		System.out.println("Can purchase: " + (canPurchase ? "YES" : "NO"));
		System.out.println("Show waitlist: " + (showWaitlist ? "YES" : "NO"));
	}

}
