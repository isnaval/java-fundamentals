package collections.hashmap.shop_management;

import java.util.HashMap;
import java.util.Map;

public class Shop {
	private Map<String, Product> inventory;

	private String shopName;

	public Shop(String shopName) {
		this.shopName = shopName;
		this.inventory = new HashMap<>();
		initializeProducts();
	}

	private void initializeProducts() {
		addProduct(new Product("Camiseta", 50, 19.99));
		addProduct(new Product("Pantalón", 30, 39.99));
		addProduct(new Product("Zapatos", 20, 59.99));
		addProduct(new Product("Gorra", 100, 9.99));
	}

	public void addProduct(Product product) {
		inventory.put(product.getName(), product);
	}

	public Product getProduct(String name) {
		return inventory.get(name);
	}

	public boolean hasProduct(String name) {
		return inventory.containsKey(name);
	}

	public Map<String, Product> getInventory() {
		return inventory;
	}

	public String getShopName() {
		return shopName;
	}

}
