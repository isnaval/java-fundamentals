package java_oop.advanced.electronics_store_system.inventory;

import java.util.ArrayList;
import java.util.List;

public class Supplier {
	private String id;
	private String name;
	private String contactPerson;
	private String email;
	private String phone;
	private String address;
	private String country;
	private List<String> productCategories;
	private double rating;
	private boolean isActive;
	private int deliveryTimeDays;
	private double minimumOrderAmount;
	private boolean offersCredit;
	private int creditDays;

	public Supplier(String id, String name, String contactPerson, String email, String phone, String address) {
		this.id = id;
		this.name = name;
		this.contactPerson = contactPerson;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.productCategories = new ArrayList<>();
		this.rating = 0.0;
		this.isActive = true;
		this.deliveryTimeDays = 7;
		this.minimumOrderAmount = 0.0;
		this.offersCredit = false;
		this.creditDays = 0;
	}

	public void addProductCategory(String category) {
		if (!productCategories.contains(category)) {
			productCategories.add(category);
		}
	}

	public void removeProductCategory(String category) {
		productCategories.remove(category);
	}

	public boolean suppliesCategory(String category) {
		return productCategories.contains(category);
	}

	public void updateRating(double newRating) {
		if (newRating >= 1.0 && newRating <= 5.0) {
			this.rating = newRating;
		}
	}

	public String getDeliveryEstimate() {
		if (deliveryTimeDays <= 1) {
			return "24 horas";
		} else if (deliveryTimeDays <= 7) {
			return deliveryTimeDays + " días";
		} else {
			return (deliveryTimeDays / 7) + " semanas";
		}
	}

	public boolean canFulfillOrder(double orderAmount) {
		return isActive && orderAmount >= minimumOrderAmount;
	}

	public void showSupplierInfo() {
		System.out.println("🏭 INFORMACIÓN DEL PROVEEDOR:");
		System.out.println("=============================");
		System.out.println("ID: " + id);
		System.out.println("Nombre: " + name);
		System.out.println("Contacto: " + contactPerson);
		System.out.println("Email: " + email);
		System.out.println("Teléfono: " + phone);
		System.out.println("Dirección: " + address);
		System.out.println("País: " + country);
		System.out.println("Categorías: " + String.join(", ", productCategories));
		System.out.println("Rating: " + String.format("%.1f", rating) + "/5.0 ⭐");
		System.out.println("Tiempo de entrega: " + getDeliveryEstimate());
		System.out.println("Pedido mínimo: €" + String.format("%.2f", minimumOrderAmount));
		System.out.println("Crédito: " + (offersCredit ? creditDays + " días" : "No disponible"));
		System.out.println("Estado: " + (isActive ? "Activo" : "Inactivo"));
	}

	// Getters y Setters
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getContactPerson() {
		return contactPerson;
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

	public String getCountry() {
		return country;
	}

	public List<String> getProductCategories() {
		return new ArrayList<>(productCategories);
	}

	public double getRating() {
		return rating;
	}

	public boolean isActive() {
		return isActive;
	}

	public int getDeliveryTimeDays() {
		return deliveryTimeDays;
	}

	public double getMinimumOrderAmount() {
		return minimumOrderAmount;
	}

	public boolean isOffersCredit() {
		return offersCredit;
	}

	public int getCreditDays() {
		return creditDays;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
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

	public void setCountry(String country) {
		this.country = country;
	}

	public void setActive(boolean active) {
		isActive = active;
	}

	public void setDeliveryTimeDays(int deliveryTimeDays) {
		this.deliveryTimeDays = deliveryTimeDays;
	}

	public void setMinimumOrderAmount(double minimumOrderAmount) {
		this.minimumOrderAmount = minimumOrderAmount;
	}

	public void setOffersCredit(boolean offersCredit) {
		this.offersCredit = offersCredit;
	}

	public void setCreditDays(int creditDays) {
		this.creditDays = creditDays;
	}

	@Override
	public String toString() {
		return String.format("%s (%s) - Rating: %.1f⭐", name, country, rating);
	}
}