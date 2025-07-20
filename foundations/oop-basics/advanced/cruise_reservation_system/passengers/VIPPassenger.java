package java_oop.advanced.cruise_reservation_system.passengers;

public class VIPPassenger extends Passenger {
	private String membershipLevel;
	private double discountPercentage;
	private boolean priorityBoarding;

	public VIPPassenger(String name, String email, String passportNumber, int age, String phoneNumber,
			String membershipLevel, double discountPercentage) {
		super(name, email, passportNumber, age, phoneNumber);
		this.membershipLevel = membershipLevel;
		this.discountPercentage = discountPercentage;
		this.priorityBoarding = true;
	}

	public String getMembershipLevel() {
		return membershipLevel;
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}

	public boolean hasPriorityBoarding() {
		return priorityBoarding;
	}

	@Override
	public String toString() {
		return String.format("VIP Passenger: %s (%s Member, %.1f%% discount)", getName(), membershipLevel,
				discountPercentage);
	}
}