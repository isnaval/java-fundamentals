package java_advanced_testing.resources.mock_responses;

import java_advanced_testing.model.Product;

public class MockProductResponses {
	public static String getValidProductResponse() {
		Product product = new Product("Producto Estándar", "Producto de prueba", 49.99, "SKU12345");
		return String.format("{\"id\": 1, \"name\": \"%s\", \"description\": \"%s\", \"price\": %.2f, \"sku\": \"%s\"}",
				product.getName(), product.getDescription(), product.getPrice(), product.getSku());
	}

	public static String getExpensiveProductResponse() {
		Product product = new Product("Producto Premium", "Producto de alta gama", 999.99, "SKU99999");
		return String.format("{\"id\": 2, \"name\": \"%s\", \"description\": \"%s\", \"price\": %.2f, \"sku\": \"%s\"}",
				product.getName(), product.getDescription(), product.getPrice(), product.getSku());
	}

	public static String getOutOfStockProductResponse() {
		Product product = new Product("Producto Agotado", "Sin existencias", 29.99, "SKU54321");
		return String.format(
				"{\"id\": 3, \"name\": \"%s\", \"description\": \"%s\", \"price\": %.2f, \"sku\": \"%s\", \"status\": \"Out of Stock\"}",
				product.getName(), product.getDescription(), product.getPrice(), product.getSku());
	}
}
