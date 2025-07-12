package java_oop.advanced.electronics_store_system.categories;

import java.util.ArrayList;
import java.util.List;

public class Brand {
	private String name;
	private String country;
	private int foundedYear;
	private String description;
	private List<String> specialties;
	private double marketShare;
	private boolean isPremium;

	public Brand(String name, String country, int foundedYear, String description) {
		this.name = name;
		this.country = country;
		this.foundedYear = foundedYear;
		this.description = description;
		this.specialties = new ArrayList<>();
		this.marketShare = 0.0;
		this.isPremium = false;
	}

	public void addSpecialty(String specialty) {
		if (!specialties.contains(specialty)) {
			specialties.add(specialty);
		}
	}

	public void removeSpecialty(String specialty) {
		specialties.remove(specialty);
	}

	public boolean isSpecializedIn(String category) {
		return specialties.contains(category);
	}

	public int getAge() {
		return java.time.Year.now().getValue() - foundedYear;
	}

	public void showBrandInfo() {
		System.out.println("🏷️ INFORMACIÓN DE LA MARCA:");
		System.out.println("===========================");
		System.out.println("Nombre: " + name);
		System.out.println("País: " + country);
		System.out.println("Fundada: " + foundedYear + " (" + getAge() + " años)");
		System.out.println("Descripción: " + description);
		System.out.println("Especialidades: " + String.join(", ", specialties));
		System.out.println("Cuota de mercado: " + marketShare + "%");
		System.out.println("Premium: " + (isPremium ? "Sí" : "No"));
	}

	// Getters y Setters
	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public int getFoundedYear() {
		return foundedYear;
	}

	public String getDescription() {
		return description;
	}

	public List<String> getSpecialties() {
		return new ArrayList<>(specialties);
	}

	public double getMarketShare() {
		return marketShare;
	}

	public boolean isPremium() {
		return isPremium;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setMarketShare(double marketShare) {
		this.marketShare = marketShare;
	}

	public void setPremium(boolean premium) {
		isPremium = premium;
	}

	@Override
	public String toString() {
		return String.format("%s (%s) - %s", name, country, isPremium ? "Premium" : "Standard");
	}
}
