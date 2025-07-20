package java_oop.medium.hotel_reservation_system.models.enums;

public enum RoomType {
	SINGLE("Individual", 50.0, 1), DOUBLE("Doble", 80.0, 2), TWIN("Twin", 85.0, 2), SUITE("Suite", 150.0, 2),
	JUNIOR_SUITE("Junior Suite", 120.0, 2), PRESIDENTIAL_SUITE("Suite Presidencial", 300.0, 4),
	FAMILY("Familiar", 100.0, 4);

	private final String displayName;
	private final double basePrice;
	private final int maxOccupancy;

	RoomType(String displayName, double basePrice, int maxOccupancy) {
		this.displayName = displayName;
		this.basePrice = basePrice;
		this.maxOccupancy = maxOccupancy;
	}

	public String getDisplayName() {
		return displayName;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public int getMaxOccupancy() {
		return maxOccupancy;
	}

}
