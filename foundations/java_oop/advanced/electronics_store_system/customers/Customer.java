package java_oop.advanced.electronics_store_system.customers;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	protected String name;
	protected String email;
	protected String phone;
	protected String address;
	protected List<String> purchaseHistory;
	protected double totalSpent;

	public Customer(String name, String email, String phone, String address) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.purchaseHistory = new ArrayList<>();
		this.totalSpent = 0.0;
	}

	public void addPurchase(String productInfo, double amount) {
		purchaseHistory.add(productInfo);
		totalSpent += amount;
	}

	public double getDiscount() {
		return 0.0;
	}

	public void showCustomerInfo() {
		System.out.println("👤 INFORMACIÓN DEL CLIENTE:");
		System.out.println("===========================");
		System.out.println("Nombre: " + name);
		System.out.println("Email: " + email);
		System.out.println("Teléfono: " + phone);
		System.out.println("Dirección: " + address);
		System.out.println("Total gastado: €" + String.format("%.2f", totalSpent));
		System.out.println("Compras realizadas: " + purchaseHistory.size());
	}

	// Getters y Setters
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public List<String> getPurchaseHistory() {
		return new ArrayList<>(purchaseHistory);
	}

	public double getTotalSpent() {
		return totalSpent;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
