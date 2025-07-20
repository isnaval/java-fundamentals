package java_oop.advanced.electronics_store_system.customers;

public class VIPCustomer extends Customer {
	private String membershipLevel;
	private double discountPercentage;
	private int loyaltyPoints;
	private boolean hasPersonalShopper;

	public VIPCustomer(String name, String email, String phone, String address, String membershipLevel) {
		super(name, email, phone, address);
		this.membershipLevel = membershipLevel;
		this.loyaltyPoints = 0;
		setMembershipBenefits();
	}

	private void setMembershipBenefits() {
		switch (membershipLevel.toLowerCase()) {
		case "bronze":
			discountPercentage = 5.0;
			hasPersonalShopper = false;
			break;
		case "silver":
			discountPercentage = 10.0;
			hasPersonalShopper = false;
			break;
		case "gold":
			discountPercentage = 15.0;
			hasPersonalShopper = true;
			break;
		case "platinum":
			discountPercentage = 20.0;
			hasPersonalShopper = true;
			break;
		default:
			discountPercentage = 5.0;
			hasPersonalShopper = false;
		}
	}

	@Override
	public double getDiscount() {
		return discountPercentage;
	}

	@Override
	public void addPurchase(String productInfo, double amount) {
		super.addPurchase(productInfo, amount);
		loyaltyPoints += (int) (amount / 10);
		checkLevelUpgrade();
	}

	private void checkLevelUpgrade() {
		String newLevel = membershipLevel;

		if (totalSpent >= 5000 && !membershipLevel.equals("platinum")) {
			newLevel = "platinum";
		} else if (totalSpent >= 2000 && membershipLevel.equals("bronze")) {
			newLevel = "silver";
		} else if (totalSpent >= 1000 && membershipLevel.equals("bronze")) {
			newLevel = "gold";
		}

		if (!newLevel.equals(membershipLevel)) {
			System.out.println("🎉 ¡Felicidades! Has sido ascendido a nivel " + newLevel.toUpperCase());
			membershipLevel = newLevel;
			setMembershipBenefits();
		}
	}

	@Override
	public void showCustomerInfo() {
		super.showCustomerInfo();
		System.out.println("💎 MEMBRESÍA VIP:");
		System.out.println("Nivel: " + membershipLevel.toUpperCase());
		System.out.println("Descuento: " + discountPercentage + "%");
		System.out.println("Puntos de lealtad: " + loyaltyPoints);
		System.out.println("Personal Shopper: " + (hasPersonalShopper ? "Sí" : "No"));
	}

	// Getters específicos
	public String getMembershipLevel() {
		return membershipLevel;
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}

	public int getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public boolean isHasPersonalShopper() {
		return hasPersonalShopper;
	}
}