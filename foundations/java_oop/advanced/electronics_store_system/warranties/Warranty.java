package java_oop.advanced.electronics_store_system.warranties;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java_oop.advanced.electronics_store_system.customers.Customer;
import java_oop.advanced.electronics_store_system.products.Product;

public class Warranty {
	private String warrantyId;
	private Product product;
	private Customer customer;
	private WarrantyType warrantyType;
	private LocalDate purchaseDate;
	private LocalDate startDate;
	private LocalDate expirationDate;
	private String serialNumber;
	private double warrantyCost;
	private WarrantyStatus status;
	private List<WarrantyClaim> claims;
	private String notes;
	private boolean isTransferable;
	private int claimsUsed;
	private int maxClaims;

	public enum WarrantyStatus {
		ACTIVE("Activa"), EXPIRED("Expirada"), VOID("Anulada"), TRANSFERRED("Transferida"), CLAIMED("Reclamada");

		private final String description;

		WarrantyStatus(String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}
	}

	public Warranty(String warrantyId, Product product, Customer customer, WarrantyType warrantyType,
			LocalDate purchaseDate, String serialNumber) {
		this.warrantyId = warrantyId;
		this.product = product;
		this.customer = customer;
		this.warrantyType = warrantyType;
		this.purchaseDate = purchaseDate;
		this.startDate = purchaseDate;
		this.serialNumber = serialNumber;
		this.warrantyCost = warrantyType.calculateCostForProduct(product.getPrice());
		this.status = WarrantyStatus.ACTIVE;
		this.claims = new ArrayList<>();
		this.notes = "";
		this.isTransferable = true;
		this.claimsUsed = 0;
		this.maxClaims = warrantyType.isIncludesReplacement() ? 2 : 5;

		this.expirationDate = startDate.plusMonths(warrantyType.getDurationMonths());
	}

	public boolean isValid() {
		return status == WarrantyStatus.ACTIVE && LocalDate.now().isBefore(expirationDate) && claimsUsed < maxClaims;
	}

	public boolean isExpired() {
		return LocalDate.now().isAfter(expirationDate);
	}

	public long getDaysRemaining() {
		if (isExpired())
			return 0;
		return LocalDate.now().until(expirationDate).getDays();
	}

	public boolean canMakeClaim(String claimType) {
		if (!isValid())
			return false;

		return switch (claimType.toLowerCase()) {
		case "accidental" -> warrantyType.isIncludesAccidentalDamage();
		case "theft" -> warrantyType.isIncludesTheft();
		case "liquid" -> warrantyType.isIncludesLiquidDamage();
		case "screen" -> warrantyType.isIncludesScreenProtection();
		case "defect", "malfunction" -> true;
		default -> false;
		};
	}

	public WarrantyClaim createClaim(String claimType, String description, double estimatedCost) {
		if (!canMakeClaim(claimType)) {
			System.out.println("❌ No se puede crear la reclamación: " + claimType);
			return null;
		}

		String claimId = "CLAIM-" + warrantyId + "-" + String.format("%03d", claims.size() + 1);
		WarrantyClaim claim = new WarrantyClaim(claimId, this, claimType, description, estimatedCost);

		claims.add(claim);
		claimsUsed++;

		if (claimsUsed >= maxClaims) {
			status = WarrantyStatus.CLAIMED;
		}

		System.out.printf("✅ Reclamación creada: %s para garantía %s%n", claimId, warrantyId);
		return claim;
	}

	public void transferWarranty(Customer newCustomer, String reason) {
		if (!isTransferable || !isValid()) {
			System.out.println("❌ La garantía no es transferible o no está válida");
			return;
		}

		Customer oldCustomer = this.customer;
		this.customer = newCustomer;
		this.status = WarrantyStatus.TRANSFERRED;
		this.notes += String.format("Transferida de %s a %s. Razón: %s. ", oldCustomer.getName(), newCustomer.getName(),
				reason);

		System.out.printf("✅ Garantía transferida de %s a %s%n", oldCustomer.getName(), newCustomer.getName());
	}

	public void voidWarranty(String reason) {
		this.status = WarrantyStatus.VOID;
		this.notes += "Anulada: " + reason + ". ";

		System.out.printf("❌ Garantía anulada: %s - Razón: %s%n", warrantyId, reason);
	}

	public void extendWarranty(int additionalMonths, double additionalCost) {
		if (status != WarrantyStatus.ACTIVE) {
			System.out.println("❌ No se puede extender una garantía no activa");
			return;
		}

		this.expirationDate = expirationDate.plusMonths(additionalMonths);
		this.warrantyCost += additionalCost;
		this.notes += String.format("Extendida %d meses por €%.2f. ", additionalMonths, additionalCost);

		System.out.printf("✅ Garantía extendida hasta %s por €%.2f%n", expirationDate, additionalCost);
	}

	public void showWarrantyInfo() {
		System.out.println("🛡️ INFORMACIÓN DE LA GARANTÍA:");
		System.out.println("==============================");
		System.out.println("ID: " + warrantyId);
		System.out.println("Producto: " + product.getBrand() + " " + product.getModel());
		System.out.println("Número de serie: " + serialNumber);
		System.out.println("Cliente: " + customer.getName());
		System.out.println("Tipo: " + warrantyType.getName());
		System.out.println("Fecha de compra: " + purchaseDate);
		System.out.println("Fecha de inicio: " + startDate);
		System.out.println("Fecha de expiración: " + expirationDate);
		System.out.println("Estado: " + status.getDescription());
		System.out.printf("Costo: €%.2f%n", warrantyCost);
		System.out.println("Días restantes: " + getDaysRemaining());
		System.out.printf("Reclamaciones usadas: %d/%d%n", claimsUsed, maxClaims);
		System.out.println("Transferible: " + (isTransferable ? "Sí" : "No"));

		if (!notes.isEmpty()) {
			System.out.println("Notas: " + notes);
		}

		if (!claims.isEmpty()) {
			System.out.println("\n📋 HISTORIAL DE RECLAMACIONES:");
			for (WarrantyClaim claim : claims) {
				System.out.printf("  - %s: %s (%s)%n", claim.getClaimId(), claim.getDescription(), claim.getStatus());
			}
		}
	}

	// Getters
	public String getWarrantyId() {
		return warrantyId;
	}

	public Product getProduct() {
		return product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public WarrantyType getWarrantyType() {
		return warrantyType;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public double getWarrantyCost() {
		return warrantyCost;
	}

	public WarrantyStatus getStatus() {
		return status;
	}

	public List<WarrantyClaim> getClaims() {
		return new ArrayList<>(claims);
	}

	public String getNotes() {
		return notes;
	}

	public boolean isTransferable() {
		return isTransferable;
	}

	public int getClaimsUsed() {
		return claimsUsed;
	}

	public int getMaxClaims() {
		return maxClaims;
	}

	// Setters
	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setTransferable(boolean transferable) {
		isTransferable = transferable;
	}

	public static class WarrantyClaim {
		private String claimId;
		private Warranty warranty;
		private String claimType;
		private String description;
		private double estimatedCost;
		private LocalDate claimDate;
		private ClaimStatus status;
		private String resolution;
		private double actualCost;
		private LocalDate resolutionDate;

		public enum ClaimStatus {
			SUBMITTED("Enviada"), IN_REVIEW("En revisión"), APPROVED("Aprobada"), REJECTED("Rechazada"),
			COMPLETED("Completada");

			private final String description;

			ClaimStatus(String description) {
				this.description = description;
			}

			public String getDescription() {
				return description;
			}
		}

		public WarrantyClaim(String claimId, Warranty warranty, String claimType, String description,
				double estimatedCost) {
			this.claimId = claimId;
			this.warranty = warranty;
			this.claimType = claimType;
			this.description = description;
			this.estimatedCost = estimatedCost;
			this.claimDate = LocalDate.now();
			this.status = ClaimStatus.SUBMITTED;
			this.resolution = "";
			this.actualCost = 0.0;
		}

		public void approve(String resolution) {
			this.status = ClaimStatus.APPROVED;
			this.resolution = resolution;
			System.out.printf("✅ Reclamación aprobada: %s%n", claimId);
		}

		public void reject(String reason) {
			this.status = ClaimStatus.REJECTED;
			this.resolution = reason;
			System.out.printf("❌ Reclamación rechazada: %s - %s%n", claimId, reason);
		}

		public void complete(double actualCost) {
			this.status = ClaimStatus.COMPLETED;
			this.actualCost = actualCost;
			this.resolutionDate = LocalDate.now();
			System.out.printf("✅ Reclamación completada: %s - Costo: €%.2f%n", claimId, actualCost);
		}

		// Getters
		public String getClaimId() {
			return claimId;
		}

		public Warranty getWarranty() {
			return warranty;
		}

		public String getClaimType() {
			return claimType;
		}

		public String getDescription() {
			return description;
		}

		public double getEstimatedCost() {
			return estimatedCost;
		}

		public LocalDate getClaimDate() {
			return claimDate;
		}

		public ClaimStatus getStatus() {
			return status;
		}

		public String getResolution() {
			return resolution;
		}

		public double getActualCost() {
			return actualCost;
		}

		public LocalDate getResolutionDate() {
			return resolutionDate;
		}
	}
}