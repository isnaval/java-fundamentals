package java_oop.advanced.electronics_store_system.warranties;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java_oop.advanced.electronics_store_system.customers.Customer;
import java_oop.advanced.electronics_store_system.products.Product;

public class WarrantyService {
	private Map<String, Warranty> warranties;
	private List<WarrantyType> availableWarrantyTypes;
	private Map<String, List<Warranty.WarrantyClaim>> activeClaims;
	private double totalWarrantyRevenue;
	private int totalWarrantiesSold;

	public WarrantyService() {
		this.warranties = new HashMap<>();
		this.availableWarrantyTypes = new ArrayList<>();
		this.activeClaims = new HashMap<>();
		this.totalWarrantyRevenue = 0.0;
		this.totalWarrantiesSold = 0;
		initializeWarrantyTypes();
	}

	private void initializeWarrantyTypes() {
		availableWarrantyTypes.add(WarrantyType.createBasicWarranty());
		availableWarrantyTypes.add(WarrantyType.createExtendedWarranty());
		availableWarrantyTypes.add(WarrantyType.createPremiumWarranty());
		availableWarrantyTypes.add(WarrantyType.createMobileProtectionPlan());
	}

	public Warranty createWarranty(Product product, Customer customer, WarrantyType warrantyType,
			LocalDate purchaseDate, String serialNumber) {
		String warrantyId = generateWarrantyId();

		if (!warrantyType.isCompatibleWithProduct(product.getProductType())) {
			System.out.printf("❌ La garantía %s no es compatible con %s%n", warrantyType.getName(),
					product.getProductType());
			return null;
		}

		Warranty warranty = new Warranty(warrantyId, product, customer, warrantyType, purchaseDate, serialNumber);
		warranties.put(warrantyId, warranty);

		totalWarrantyRevenue += warranty.getWarrantyCost();
		totalWarrantiesSold++;

		System.out.printf("✅ Garantía creada: %s para %s %s%n", warrantyId, product.getBrand(), product.getModel());

		return warranty;
	}

	public List<WarrantyType> getCompatibleWarrantyTypes(Product product) {
		List<WarrantyType> compatible = new ArrayList<>();

		for (WarrantyType type : availableWarrantyTypes) {
			if (type.isCompatibleWithProduct(product.getProductType()) && type.isActive()) {
				compatible.add(type);
			}
		}

		return compatible;
	}

	public Warranty findWarranty(String warrantyId) {
		return warranties.get(warrantyId);
	}

	public List<Warranty> findWarrantiesByCustomer(Customer customer) {
		List<Warranty> customerWarranties = new ArrayList<>();

		for (Warranty warranty : warranties.values()) {
			if (warranty.getCustomer().equals(customer)) {
				customerWarranties.add(warranty);
			}
		}

		return customerWarranties;
	}

	public List<Warranty> findWarrantiesByProduct(Product product) {
		List<Warranty> productWarranties = new ArrayList<>();

		for (Warranty warranty : warranties.values()) {
			if (warranty.getProduct().equals(product)) {
				productWarranties.add(warranty);
			}
		}

		return productWarranties;
	}

	public List<Warranty> getExpiringWarranties(int daysFromNow) {
		List<Warranty> expiring = new ArrayList<>();
		LocalDate targetDate = LocalDate.now().plusDays(daysFromNow);

		for (Warranty warranty : warranties.values()) {
			if (warranty.getStatus() == Warranty.WarrantyStatus.ACTIVE
					&& warranty.getExpirationDate().isBefore(targetDate)) {
				expiring.add(warranty);
			}
		}

		return expiring;
	}

	public List<Warranty> getExpiredWarranties() {
		List<Warranty> expired = new ArrayList<>();

		for (Warranty warranty : warranties.values()) {
			if (warranty.isExpired() && warranty.getStatus() == Warranty.WarrantyStatus.ACTIVE) {
				expired.add(warranty);
			}
		}

		return expired;
	}

	public void processExpiredWarranties() {
		List<Warranty> expired = getExpiredWarranties();

		for (Warranty warranty : expired) {
			warranty.voidWarranty("Expirada por tiempo");
		}

		System.out.printf("🔄 Procesadas %d garantías expiradas%n", expired.size());
	}

	public Warranty.WarrantyClaim submitClaim(String warrantyId, String claimType, String description,
			double estimatedCost) {
		Warranty warranty = findWarranty(warrantyId);

		if (warranty == null) {
			System.out.println("❌ Garantía no encontrada: " + warrantyId);
			return null;
		}

		Warranty.WarrantyClaim claim = warranty.createClaim(claimType, description, estimatedCost);

		if (claim != null) {
			activeClaims.computeIfAbsent(claimType, k -> new ArrayList<>()).add(claim);
		}

		return claim;
	}

	public void generateWarrantyReport() {
		System.out.println("\n📊 REPORTE DE GARANTÍAS:");
		System.out.println("========================");
		System.out.printf("Total garantías vendidas: %d%n", totalWarrantiesSold);
		System.out.printf("Ingresos por garantías: €%.2f%n", totalWarrantyRevenue);

		Map<Warranty.WarrantyStatus, Integer> statusCount = new HashMap<>();
		for (Warranty warranty : warranties.values()) {
			statusCount.merge(warranty.getStatus(), 1, Integer::sum);
		}

		System.out.println("\n📈 GARANTÍAS POR ESTADO:");
		for (Map.Entry<Warranty.WarrantyStatus, Integer> entry : statusCount.entrySet()) {
			System.out.printf("  %s: %d%n", entry.getKey().getDescription(), entry.getValue());
		}

		List<Warranty> expiringSoon = getExpiringWarranties(30);
		if (!expiringSoon.isEmpty()) {
			System.out.println("\n⚠️ GARANTÍAS QUE EXPIRAN EN 30 DÍAS:");
			for (Warranty warranty : expiringSoon) {
				System.out.printf("  %s - %s (%d días restantes)%n", warranty.getWarrantyId(),
						warranty.getProduct().getModel(), warranty.getDaysRemaining());
			}
		}

		int totalClaims = activeClaims.values().stream().mapToInt(List::size).sum();

		System.out.printf("\n📋 Total de reclamaciones: %d%n", totalClaims);

		if (!activeClaims.isEmpty()) {
			System.out.println("Reclamaciones por tipo:");
			for (Map.Entry<String, List<Warranty.WarrantyClaim>> entry : activeClaims.entrySet()) {
				System.out.printf("  %s: %d%n", entry.getKey(), entry.getValue().size());
			}
		}
	}

	public void sendExpirationNotifications() {
		List<Warranty> expiringSoon = getExpiringWarranties(30);

		System.out.println("\n📧 ENVIANDO NOTIFICACIONES DE EXPIRACIÓN:");
		System.out.println("==========================================");

		for (Warranty warranty : expiringSoon) {
			System.out.printf("📧 Notificación enviada a %s para garantía %s%n", warranty.getCustomer().getEmail(),
					warranty.getWarrantyId());
			System.out.printf("   Producto: %s %s - Expira: %s (%d días)%n", warranty.getProduct().getBrand(),
					warranty.getProduct().getModel(), warranty.getExpirationDate(), warranty.getDaysRemaining());
		}

		if (expiringSoon.isEmpty()) {
			System.out.println("✅ No hay garantías próximas a expirar");
		}
	}

	public void showWarrantyTypesMenu() {
		System.out.println("\n🛡️ TIPOS DE GARANTÍA DISPONIBLES:");
		System.out.println("==================================");

		for (int i = 0; i < availableWarrantyTypes.size(); i++) {
			WarrantyType type = availableWarrantyTypes.get(i);
			System.out.printf("%d. %s%n", i + 1, type);
			System.out.printf("   %s%n", type.getDescription());
		}
	}

	private String generateWarrantyId() {
		return "WAR-" + System.currentTimeMillis() + "-" + String.format("%03d", warranties.size() + 1);
	}

	// Getters
	public Map<String, Warranty> getWarranties() {
		return new HashMap<>(warranties);
	}

	public List<WarrantyType> getAvailableWarrantyTypes() {
		return new ArrayList<>(availableWarrantyTypes);
	}

	public double getTotalWarrantyRevenue() {
		return totalWarrantyRevenue;
	}

	public int getTotalWarrantiesSold() {
		return totalWarrantiesSold;
	}

	public void addWarrantyType(WarrantyType warrantyType) {
		availableWarrantyTypes.add(warrantyType);
		System.out.printf("✅ Tipo de garantía agregado: %s%n", warrantyType.getName());
	}

	public void removeWarrantyType(String warrantyTypeId) {
		for (int i = 0; i < availableWarrantyTypes.size(); i++) {
			if (availableWarrantyTypes.get(i).getId().equals(warrantyTypeId)) {
				WarrantyType removed = availableWarrantyTypes.remove(i);
				System.out.printf("❌ Tipo de garantía eliminado: %s%n", removed.getName());
				return;
			}
		}
		System.out.println("❌ Tipo de garantía no encontrado: " + warrantyTypeId);

	}
}