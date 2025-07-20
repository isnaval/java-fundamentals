package java_oop.advanced.cruise_reservation_system.cruise;

public enum CabinType {
	INTERIOR("Interior Cabin", 150.0), OCEAN_VIEW("Ocean View Cabin", 200.0), BALCONY("Balcony Cabin", 300.0),
	SUITE("Suite", 500.0);

	private final String description;
	private final double basePrice;

	CabinType(String description, double basePrice) {
		this.description = description;
		this.basePrice = basePrice;
	}

	public String getDescription() {
		return description;
	}

	public double getBasePrice() {
		return basePrice;
	}

	@Override
	public String toString() {
		return description;
	}

}
