package java_oop.basics.bar_order_system;

import java.util.Arrays;

public class Order {
	
	private Client client; 
	private Drink[] drinks;
	private int numberOfDrinks; 
	private int maxDrinks;
	
	
	public Order() {
	}
	
	public Order(Client cliente, Drink[] bebidas, int numberOfDrinks, int total, int maxDrinks) {
		super();
		this.client = cliente;
		this.drinks = bebidas;
		this.numberOfDrinks = numberOfDrinks;
		this.numberOfDrinks = total;
        this.maxDrinks = maxDrinks;

	}



	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Drink[] getDrinks() {
		return drinks;
	}

	public void setDrinks(Drink[] drinks) {
		this.drinks = drinks;
	}

	public int getNumberOfDrinks() {
		return numberOfDrinks;
	}

	public void setNumberOfDrinks(int numberOfDrinks) {
		this.numberOfDrinks = numberOfDrinks;
	}

	public void setMaxDrinks(int maxDrinks) {
		this.maxDrinks = maxDrinks;
	}

	public int getMaxDrinks() {
		return 3;
	} 
	
	@Override
	public String toString() {
		return "Order [client=" + client + ", drinks=" + Arrays.toString(drinks) + ", numberOfDrinks=" + numberOfDrinks
				+ ", maxDrinks=" + maxDrinks + "]";
	}



}
