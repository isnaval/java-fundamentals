package java_oop.advanced.electronics_store_system.products;

public abstract class Product {
	protected String brand;
	protected String model;
	protected double price;
	protected String color;
	protected int warranty;
	protected boolean inStock;
	protected int stockQuantity;

	public Product(String brand, String model, double price, String color, int warranty, int stockQuantity) {
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.color = color;
		this.warranty = warranty;
		this.stockQuantity = stockQuantity;
		this.inStock = stockQuantity > 0;
	}

	public abstract void showSpecifications();

	public abstract String getProductType();

	public double applyDiscount(double discountPercentage) {
		return price * (1 - discountPercentage / 100);
	}

	// Método para reducir stock
	public boolean reduceStock(int quantity) {
		if (stockQuantity >= quantity) {
			stockQuantity -= quantity;
			inStock = stockQuantity > 0;
			return true;
		}
		return false;
	}

	// Getters y Setters
	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public double getPrice() {
		return price;
	}

	public String getColor() {
		return color;
	}

	public int getWarranty() {
		return warranty;
	}

	public boolean isInStock() {
		return inStock;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
		this.inStock = stockQuantity > 0;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s - €%.2f (%s) - Stock: %d", getProductType(), brand, model, price,
				inStock ? "Disponible" : "Agotado", stockQuantity);
	}
}