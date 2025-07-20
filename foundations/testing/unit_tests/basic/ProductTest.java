package java_advanced_testing.unit_tests.basic;

import java_advanced_testing.model.Product;

public class ProductTest {

	// Test del constructor
	public static void testProductConstructor() {
		System.out.println("=== Test: Product Constructor ===");

		Product product = new Product("Laptop", "High-performance laptop", 999.99, "LAP001");

		assert product.getName().equals("Laptop") : "Name should be 'Laptop'";
		assert product.getDescription().equals("High-performance laptop") : "Description should match";
		assert product.getPrice() == 999.99 : "Price should be 999.99";
		assert product.getSku().equals("LAP001") : "SKU should be 'LAP001'";

		System.out.println("✅ Constructor test passed");
	}

	// Test de getters
	public static void testProductGetters() {
		System.out.println("=== Test: Product Getters ===");

		Product product = new Product("Mouse", "Wireless mouse", 29.99, "MOU001");

		assert product.getName().equals("Mouse") : "Name getter failed";
		assert product.getDescription().equals("Wireless mouse") : "Description getter failed";
		assert product.getPrice() == 29.99 : "Price getter failed";
		assert product.getSku().equals("MOU001") : "SKU getter failed";

		System.out.println("✅ Getters test passed");
	}

	// Test de setters
	public static void testProductSetters() {
		System.out.println("=== Test: Product Setters ===");

		Product product = new Product("Keyboard", "Mechanical keyboard", 79.99, "KEY001");

		product.setName("Gaming Keyboard");
		product.setDescription("RGB mechanical keyboard");
		product.setPrice(129.99);
		product.setSku("KEY002");

		assert product.getName().equals("Gaming Keyboard") : "Name setter failed";
		assert product.getDescription().equals("RGB mechanical keyboard") : "Description setter failed";
		assert product.getPrice() == 129.99 : "Price setter failed";
		assert product.getSku().equals("KEY002") : "SKU setter failed";

		System.out.println("✅ Setters test passed");
	}

	// Test con diferentes precios
	public static void testProductPriceRanges() {
		System.out.println("=== Test: Product Price Ranges ===");

		Product cheap = new Product("Pen", "Basic pen", 0.99, "PEN001");
		Product expensive = new Product("Server", "Enterprise server", 9999.99, "SRV001");
		Product free = new Product("Sample", "Free sample", 0.0, "FREE001");

		assert cheap.getPrice() < 10.0 : "Cheap product should be under 10";
		assert expensive.getPrice() > 1000.0 : "Expensive product should be over 1000";
		assert free.getPrice() == 0.0 : "Free product should be 0.0";

		System.out.println("✅ Price ranges test passed");
	}

	// Test con valores nulos
	public static void testProductWithNullValues() {
		System.out.println("=== Test: Product With Null Values ===");

		Product product = new Product("Test Product", null, 50.0, "TEST001");

		assert product.getName() != null : "Name should not be null";
		assert product.getDescription() == null : "Description should be null";
		assert product.getPrice() == 50.0 : "Price should be 50.0";
		assert product.getSku() != null : "SKU should not be null";

		System.out.println("✅ Null values test passed");
	}

	// Método para ejecutar todos los tests
	public static void runAllTests() {
		System.out.println("🚀 Running all Product tests...\n");

		try {
			testProductConstructor();
			testProductGetters();
			testProductSetters();
			testProductPriceRanges();
			testProductWithNullValues();

			System.out.println("\n🎉 All Product tests passed!");
		} catch (AssertionError e) {
			System.out.println("\n❌ Test failed: " + e.getMessage());
		}
	}
}