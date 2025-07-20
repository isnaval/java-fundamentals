package fundamentals.method_overloading.book_pricing;

public enum DiscountType {
	STUDENT("Estudiante", 15.0), MEMBER("Miembro", 10.0), SENIOR("Tercera Edad", 20.0), BULK("Por Cantidad", 12.0),
	NONE("Sin Descuento", 0.0);

	private final String name;
	private final double percentage;

	DiscountType(String name, double percentage) {
		this.name = name;
		this.percentage = percentage;
	}

	public String getName() {
		return name;
	}

	public double getPercentage() {
		return percentage;
	}

	@Override
	public String toString() {
		return name + " (" + percentage + "%)";
	}

}