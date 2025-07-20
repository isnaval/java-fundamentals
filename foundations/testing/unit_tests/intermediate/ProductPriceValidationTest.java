package java_advanced_testing.unit_tests.intermediate;

import java_advanced_testing.model.Product;

public class ProductPriceValidationTest {

	public static void main(String[] args) {
		System.out.println("PRODUCT PRICE VALIDATION TESTS");
		System.out.println("================================");

		testPriceRanges();
		testPriceValidation();
		testPriceBusinessRules();
		testProductCategories();

		System.out.println("\nProduct price validation tests completados");
	}

	public static void testPriceRanges() {
		System.out.println("\n--- Test: Price Ranges ---");

		// Test producto gratis
		Product freeProduct = new Product("Muestra", "Producto gratis", 0.0, "FREE001");
		System.out.println("Producto gratis: " + freeProduct.getName() + " - $" + freeProduct.getPrice());
		System.out.println("   Es gratis: " + (freeProduct.getPrice() == 0.0 ? "PASS" : "FAIL"));

		// Test producto economico
		Product cheapProduct = new Product("Economico", "Producto barato", 9.99, "CHEAP001");
		System.out.println("Producto economico: " + cheapProduct.getName() + " - $" + cheapProduct.getPrice());
		System.out.println(
				"   Es economico: " + (cheapProduct.getPrice() > 0 && cheapProduct.getPrice() < 50 ? "PASS" : "FAIL"));

		// Test producto medio
		Product midProduct = new Product("Medio", "Producto precio medio", 149.99, "MID001");
		System.out.println("Producto precio medio: " + midProduct.getName() + " - $" + midProduct.getPrice());
		System.out.println("   Es precio medio: "
				+ (midProduct.getPrice() >= 50 && midProduct.getPrice() < 500 ? "PASS" : "FAIL"));

		// Test producto premium
		Product premiumProduct = new Product("Premium", "Producto premium", 1299.99, "PREM001");
		System.out.println("Producto premium: " + premiumProduct.getName() + " - $" + premiumProduct.getPrice());
		System.out.println("   Es premium: " + (premiumProduct.getPrice() >= 500 ? "PASS" : "FAIL"));
	}

	public static void testPriceValidation() {
		System.out.println("\n--- Test: Price Validation ---");

		// Test precio negativo
		Product negativePrice = new Product("Test", "Precio negativo", -10.0, "NEG001");
		System.out.println("Producto con precio negativo: $" + negativePrice.getPrice());
		System.out.println("   Precio negativo: " + (negativePrice.getPrice() < 0 ? "PASS" : "FAIL"));

		// Test precio con muchos decimales
		Product manyDecimals = new Product("Test", "Muchos decimales", 19.999999, "DEC001");
		System.out.println("Producto con muchos decimales: $" + manyDecimals.getPrice());
		System.out.println("   Muchos decimales: " + (manyDecimals.getPrice() == 19.999999 ? "PASS" : "FAIL"));

		// Test precio muy alto
		Product veryExpensive = new Product("Test", "Muy caro", 999999.99, "EXP001");
		System.out.println("Producto muy caro: $" + veryExpensive.getPrice());
		System.out.println("   Muy caro: " + (veryExpensive.getPrice() > 100000 ? "PASS" : "FAIL"));
	}

	public static void testPriceBusinessRules() {
		System.out.println("\n--- Test: Price Business Rules ---");

		// Test: Productos con SKU especial son mas caros
		Product specialSKU = new Product("Special", "Producto especial", 199.99, "SPECIAL001");
		boolean isSpecialExpensive = specialSKU.getSku().contains("SPECIAL") && specialSKU.getPrice() > 100;
		System.out.println("Producto especial es caro: " + (isSpecialExpensive ? "PASS" : "FAIL"));

		// Test: Productos con descripcion larga son premium
		String longDescription = "Este es un producto premium con una descripcion muy detallada y caracteristicas avanzadas";
		Product longDescProduct = new Product("Premium", longDescription, 299.99, "PREM001");
		boolean isPremiumWithLongDesc = longDescProduct.getDescription().length() > 50
				&& longDescProduct.getPrice() > 200;
		System.out.println("Producto con descripcion larga es premium: " + (isPremiumWithLongDesc ? "PASS" : "FAIL"));

		// Test: Productos gratuitos tienen SKU especial
		Product freeProduct = new Product("Free", "Producto gratis", 0.0, "FREE001");
		boolean freeHasSpecialSKU = freeProduct.getPrice() == 0.0 && freeProduct.getSku().contains("FREE");
		System.out.println("Producto gratis tiene SKU especial: " + (freeHasSpecialSKU ? "PASS" : "FAIL"));
	}

	public static void testProductCategories() {
		System.out.println("\n--- Test: Product Categories ---");

		Product[] products = { new Product("Laptop", "Laptop gaming", 1299.99, "TECH001"),
				new Product("Book", "Libro educativo", 29.99, "BOOK001"),
				new Product("Shirt", "Camisa casual", 39.99, "CLOTH001"),
				new Product("Phone", "Smartphone", 699.99, "TECH002"),
				new Product("Pen", "Boligrafo", 2.99, "OFFICE001") };

		for (Product product : products) {
			String category = categorizeProduct(product);
			System.out.println(product.getName() + " ($" + product.getPrice() + ") - Categoria: " + category);
		}
	}

	private static String categorizeProduct(Product product) {
		if (product.getPrice() == 0.0)
			return "GRATIS";
		else if (product.getPrice() < 10.0)
			return "ECONOMICO";
		else if (product.getPrice() < 100.0)
			return "MEDIO";
		else if (product.getPrice() < 500.0)
			return "CARO";
		else
			return "PREMIUM";
	}
}
