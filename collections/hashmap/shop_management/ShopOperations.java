package collections.hashmap.shop_management;

import java.util.Scanner;

public class ShopOperations {

	private Shop shop;

	// Constructor que recibe la tienda
	public ShopOperations(Shop shop) {
		this.shop = shop;
	}

	// Muestra todos los productos
	public void displayProducts() {
		System.out.println("\n=== PRODUCTOS EN " + shop.getShopName().toUpperCase() + " ===");
		System.out.println("─".repeat(60));

		for (Product product : shop.getInventory().values()) {
			System.out.println(product);
		}
		System.out.println("─".repeat(60));
	}

	// Vende un producto
	public void sellProduct(String productName, int quantity) {
		if (!shop.hasProduct(productName)) {
			System.out.println("❌ Producto no encontrado: " + productName);
			return;
		}

		Product product = shop.getProduct(productName);

		if (product.getQuantity() < quantity) {
			System.out.println("❌ Stock insuficiente");
			System.out.println("   Disponible: " + product.getQuantity());
			System.out.println("   Solicitado: " + quantity);
			return;
		}

		product.removeStock(quantity);
		double total = product.getPrice() * quantity;

		System.out.println("\n✅ VENTA EXITOSA");
		System.out.println("─".repeat(30));
		System.out.println("Producto: " + productName);
		System.out.println("Cantidad: " + quantity);
		System.out.println("Precio unitario: " + product.getPrice() + " €");
		System.out.println("─".repeat(30));
		System.out.println("TOTAL: " + String.format("%.2f", total) + " €");
	}

	// Agrega stock a un producto
	public void restockProduct(String productName, int quantity) {
		if (!shop.hasProduct(productName)) {
			System.out.println("❌ Producto no encontrado");
			return;
		}

		Product product = shop.getProduct(productName);
		int stockAnterior = product.getQuantity();
		product.addStock(quantity);

		System.out.println("\n✅ REABASTECIMIENTO EXITOSO");
		System.out.println("Producto: " + productName);
		System.out.println("Stock anterior: " + stockAnterior);
		System.out.println("Agregado: " + quantity);
		System.out.println("Stock actual: " + product.getQuantity());
	}

	// Crea un producto nuevo
	public void addNewProduct(Scanner scanner) {
		System.out.print("\nNombre del producto: ");
		String name = scanner.nextLine();

		if (shop.hasProduct(name)) {
			System.out.println("❌ El producto ya existe");
			return;
		}

		System.out.print("Cantidad inicial: ");
		int quantity = scanner.nextInt();

		System.out.print("Precio: \" €\"");
		double price = scanner.nextDouble();
		scanner.nextLine();

		Product newProduct = new Product(name, quantity, price);
		shop.addProduct(newProduct);

		System.out.println("✅ Producto agregado exitosamente");
	}

	// Muestra productos con poco stock
	public void showLowStock() {
		System.out.println("\n=== ALERTA: PRODUCTOS CON BAJO STOCK ===");
		boolean foundLowStock = false;

		for (Product product : shop.getInventory().values()) {
			if (product.isLowStock()) {
				System.out
						.println("⚠️  " + product.getName() + " - Quedan solo " + product.getQuantity() + " unidades");
				foundLowStock = true;
			}
		}

		if (!foundLowStock) {
			System.out.println("✅ Todos los productos tienen stock suficiente");
		}
	}

	// Calcula valor total del inventario
	public void showInventoryValue() {
		double totalValue = 0;
		int totalItems = 0;

		for (Product product : shop.getInventory().values()) {
			double productValue = product.getPrice() * product.getQuantity();
			totalValue += productValue;
			totalItems += product.getQuantity();
		}

		System.out.println("\n=== VALOR DEL INVENTARIO ===");
		System.out.println("Total de productos diferentes: " + shop.getInventory().size());
		System.out.println("Total de unidades: " + totalItems);
		System.out.println("Valor total del inventario: " + String.format("%.2f", totalValue) + " €");
	}
}