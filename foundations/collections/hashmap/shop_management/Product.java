package collections.hashmap.shop_management;

public class Product {
	private String name;
	private int quantity;
	private double price;

	public Product(String name, int quantity, double price) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void addStock(int amount) {
		this.quantity += amount;
	}

	public boolean removeStock(int amount) {
		if (amount <= quantity) {
			this.quantity -= amount;
			return true;
		}
		return false;
	}

	public boolean isLowStock() {
		return quantity <= 10;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}

}