package java_opp.basics.bar_order_system;

public class Drink {
	private String name; 
	private double price;
	
	public Drink () {
	}
	
	public Drink(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Drink [name=" + name + ", price=" + price + "]";
	} 
	
}
