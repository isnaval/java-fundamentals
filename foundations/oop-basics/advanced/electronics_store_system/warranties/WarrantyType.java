package java_oop.advanced.electronics_store_system.warranties;

public class WarrantyType {
	private String id;
	private String name;
	private String description;
	private int durationMonths;
	private boolean includesAccidentalDamage;
	private boolean includesTheft;
	private boolean includesLiquidDamage;
	private boolean includesScreenProtection;
	private boolean includesOnSiteService;
	private boolean includesReplacement;
	private double cost;
	private boolean isActive;

	public WarrantyType(String id, String name, String description, int durationMonths) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.durationMonths = durationMonths;
		this.includesAccidentalDamage = false;
		this.includesTheft = false;
		this.includesLiquidDamage = false;
		this.includesScreenProtection = false;
		this.includesOnSiteService = false;
		this.includesReplacement = false;
		this.cost = 0.0;
		this.isActive = true;
	}

	public static WarrantyType createBasicWarranty() {
		WarrantyType warranty = new WarrantyType("BASIC", "Garantía Básica", "Garantía estándar del fabricante", 12);
		warranty.setCost(0.0);
		return warranty;
	}

	public static WarrantyType createExtendedWarranty() {
		WarrantyType warranty = new WarrantyType("EXTENDED", "Garantía Extendida",
				"Garantía extendida con cobertura adicional", 24);
		warranty.setCost(99.99);
		warranty.setIncludesOnSiteService(true);
		return warranty;
	}

	public static WarrantyType createPremiumWarranty() {
		WarrantyType warranty = new WarrantyType("PREMIUM", "Garantía Premium",
				"Garantía completa con máxima cobertura", 36);
		warranty.setCost(199.99);
		warranty.setIncludesAccidentalDamage(true);
		warranty.setIncludesTheft(true);
		warranty.setIncludesLiquidDamage(true);
		warranty.setIncludesScreenProtection(true);
		warranty.setIncludesOnSiteService(true);
		warranty.setIncludesReplacement(true);
		return warranty;
	}

	public static WarrantyType createMobileProtectionPlan() {
		WarrantyType warranty = new WarrantyType("MOBILE_PROTECTION", "Plan de Protección Móvil",
				"Protección específica para dispositivos móviles", 24);
		warranty.setCost(149.99);
		warranty.setIncludesAccidentalDamage(true);
		warranty.setIncludesLiquidDamage(true);
		warranty.setIncludesScreenProtection(true);
		warranty.setIncludesReplacement(true);
		return warranty;
	}

	public double calculateCostForProduct(double productPrice) {
		if (cost > 0) {
			return cost;
		}

		double percentage = switch (id) {
		case "BASIC" -> 0.0;
		case "EXTENDED" -> 0.08;
		case "PREMIUM" -> 0.15;
		case "MOBILE_PROTECTION" -> 0.12;
		default -> 0.05;
		};

		return productPrice * percentage;
	}

	public boolean isCompatibleWithProduct(String productType) {
		return switch (id) {
		case "MOBILE_PROTECTION" -> productType.equals("Smartphone");
		case "BASIC", "EXTENDED", "PREMIUM" -> true;
		default -> true;
		};
	}

	public void showWarrantyDetails() {
		System.out.println("🛡️ DETALLES DE LA GARANTÍA:");
		System.out.println("===========================");
		System.out.println("Tipo: " + name);
		System.out.println("Descripción: " + description);
		System.out.println("Duración: " + durationMonths + " meses");
		System.out.printf("Costo: €%.2f%n", cost);

		System.out.println("\n📋 COBERTURA:");
		System.out.println("Daño accidental: " + (includesAccidentalDamage ? "✅ Sí" : "❌ No"));
		System.out.println("Robo: " + (includesTheft ? "✅ Sí" : "❌ No"));
		System.out.println("Daño por líquidos: " + (includesLiquidDamage ? "✅ Sí" : "❌ No"));
		System.out.println("Protección de pantalla: " + (includesScreenProtection ? "✅ Sí" : "❌ No"));
		System.out.println("Servicio a domicilio: " + (includesOnSiteService ? "✅ Sí" : "❌ No"));
		System.out.println("Reemplazo inmediato: " + (includesReplacement ? "✅ Sí" : "❌ No"));
		System.out.println("Estado: " + (isActive ? "Activa" : "Inactiva"));
	}

	// Getters y Setters
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getDurationMonths() {
		return durationMonths;
	}

	public boolean isIncludesAccidentalDamage() {
		return includesAccidentalDamage;
	}

	public boolean isIncludesTheft() {
		return includesTheft;
	}

	public boolean isIncludesLiquidDamage() {
		return includesLiquidDamage;
	}

	public boolean isIncludesScreenProtection() {
		return includesScreenProtection;
	}

	public boolean isIncludesOnSiteService() {
		return includesOnSiteService;
	}

	public boolean isIncludesReplacement() {
		return includesReplacement;
	}

	public double getCost() {
		return cost;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDurationMonths(int durationMonths) {
		this.durationMonths = durationMonths;
	}

	public void setIncludesAccidentalDamage(boolean includesAccidentalDamage) {
		this.includesAccidentalDamage = includesAccidentalDamage;
	}

	public void setIncludesTheft(boolean includesTheft) {
		this.includesTheft = includesTheft;
	}

	public void setIncludesLiquidDamage(boolean includesLiquidDamage) {
		this.includesLiquidDamage = includesLiquidDamage;
	}

	public void setIncludesScreenProtection(boolean includesScreenProtection) {
		this.includesScreenProtection = includesScreenProtection;
	}

	public void setIncludesOnSiteService(boolean includesOnSiteService) {
		this.includesOnSiteService = includesOnSiteService;
	}

	public void setIncludesReplacement(boolean includesReplacement) {
		this.includesReplacement = includesReplacement;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setActive(boolean active) {
		isActive = active;
	}

	@Override
	public String toString() {
		return String.format("%s (%d meses) - €%.2f", name, durationMonths, cost);
	}
}