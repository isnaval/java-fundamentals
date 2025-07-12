package java_oop.advanced.electronics_store_system.inventory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java_oop.advanced.electronics_store_system.products.Product;

public class Inventory {
	private Map<String, Stock> stockMap;
	private List<Supplier> suppliers;
	private int lowStockThreshold;
	private int criticalStockThreshold;
	private LocalDateTime lastUpdate;

	public Inventory() {
		this.stockMap = new HashMap<>();
		this.suppliers = new ArrayList<>();
		this.lowStockThreshold = 10;
		this.criticalStockThreshold = 5;
		this.lastUpdate = LocalDateTime.now();
	}

	public void addProduct(Product product, int initialQuantity, Supplier supplier) {
		String productId = generateProductId(product);
		Stock stock = new Stock(product, initialQuantity, supplier);
		stockMap.put(productId, stock);

		System.out.printf("📦 Producto agregado al inventario: %s (Stock: %d)%n", product.getModel(), initialQuantity);
		updateLastModified();
	}

	public boolean removeStock(String productId, int quantity, String reason) {
		Stock stock = stockMap.get(productId);
		if (stock != null && stock.reduceQuantity(quantity)) {
			stock.addMovement("SALIDA", quantity, reason);
			updateLastModified();

			// Verificar alertas de stock
			checkStockAlerts(stock);
			return true;
		}
		return false;
	}

	public boolean addStock(String productId, int quantity, String reason) {
		Stock stock = stockMap.get(productId);
		if (stock != null) {
			stock.addQuantity(quantity);
			stock.addMovement("ENTRADA", quantity, reason);
			updateLastModified();

			System.out.printf("✅ Stock actualizado: %s (+%d) = %d%n", stock.getProduct().getModel(), quantity,
					stock.getCurrentQuantity());
			return true;
		}
		return false;
	}

	public Stock getStock(String productId) {
		return stockMap.get(productId);
	}

	public List<Stock> getAllStock() {
		return new ArrayList<>(stockMap.values());
	}

	public List<Stock> getLowStockProducts() {
		List<Stock> lowStock = new ArrayList<>();
		for (Stock stock : stockMap.values()) {
			if (stock.getCurrentQuantity() <= lowStockThreshold
					&& stock.getCurrentQuantity() > criticalStockThreshold) {
				lowStock.add(stock);
			}
		}
		return lowStock;
	}

	public List<Stock> getCriticalStockProducts() {
		List<Stock> criticalStock = new ArrayList<>();
		for (Stock stock : stockMap.values()) {
			if (stock.getCurrentQuantity() <= criticalStockThreshold) {
				criticalStock.add(stock);
			}
		}
		return criticalStock;
	}

	public void generateStockReport() {
		System.out.println("\n📊 REPORTE DE INVENTARIO:");
		System.out.println("=========================");
		System.out.println("Última actualización: " + lastUpdate);
		System.out.println("Total de productos: " + stockMap.size());

		int totalStock = stockMap.values().stream().mapToInt(Stock::getCurrentQuantity).sum();
		System.out.println("Stock total: " + totalStock + " unidades");

		double totalValue = stockMap.values().stream()
				.mapToDouble(stock -> stock.getCurrentQuantity() * stock.getProduct().getPrice()).sum();
		System.out.printf("Valor total del inventario: €%.2f%n", totalValue);

		// Alertas
		List<Stock> lowStock = getLowStockProducts();
		List<Stock> criticalStock = getCriticalStockProducts();

		if (!criticalStock.isEmpty()) {
			System.out.println("\n🚨 STOCK CRÍTICO:");
			for (Stock stock : criticalStock) {
				System.out.printf("   %s: %d unidades%n", stock.getProduct().getModel(), stock.getCurrentQuantity());
			}
		}

		if (!lowStock.isEmpty()) {
			System.out.println("\n⚠️ STOCK BAJO:");
			for (Stock stock : lowStock) {
				System.out.printf("   %s: %d unidades%n", stock.getProduct().getModel(), stock.getCurrentQuantity());
			}
		}
	}

	private void checkStockAlerts(Stock stock) {
		int quantity = stock.getCurrentQuantity();
		String productName = stock.getProduct().getModel();

		if (quantity <= criticalStockThreshold) {
			System.out.printf("🚨 ALERTA CRÍTICA: %s tiene solo %d unidades%n", productName, quantity);
		} else if (quantity <= lowStockThreshold) {
			System.out.printf("⚠️ ALERTA: %s tiene poco stock (%d unidades)%n", productName, quantity);
		}
	}

	private String generateProductId(Product product) {
		return product.getBrand().toUpperCase().substring(0, 3) + "_"
				+ product.getModel().replaceAll("\\s+", "_").toUpperCase();
	}

	private void updateLastModified() {
		lastUpdate = LocalDateTime.now();
	}

	// Getters y Setters
	public int getLowStockThreshold() {
		return lowStockThreshold;
	}

	public int getCriticalStockThreshold() {
		return criticalStockThreshold;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLowStockThreshold(int threshold) {
		this.lowStockThreshold = threshold;
	}

	public void setCriticalStockThreshold(int threshold) {
		this.criticalStockThreshold = threshold;
	}
}
