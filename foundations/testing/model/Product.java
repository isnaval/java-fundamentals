package java_advanced_testing.model;

public class Product {
	private String name;
	private String description;
	private double price;
	private String sku;

	public Product(String name, String description, double price, String sku) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.sku = sku;
	}

	// Getters
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public String getSku() {
		return sku;
	}

	// Setters (optional, included for flexibility)
	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

}
