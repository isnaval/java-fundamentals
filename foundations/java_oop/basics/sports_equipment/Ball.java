package java_oop.basics.sports_equipment;

public abstract class Ball extends Equipment implements Inflatable {
	protected double weight;
	protected String material;
	protected double currentPressure;
	protected boolean inflated;

	public Ball(int id, String sport, double weight, String material) {
		super(id, sport, false);
		this.weight = weight;
		this.material = material;
		this.currentPressure = 0.0;
		this.inflated = false;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getCurrentPressure() {
		return currentPressure;
	}

	public void setCurrentPressure(double currentPressure) {
		this.currentPressure = currentPressure;
	}

	public void setInflated(boolean inflated) {
		this.inflated = inflated;
	}

	public void inflate(double pressure) {
		if (pressure > 0 && pressure <= getRecommendedPressure() * 1.2) {
			this.currentPressure = pressure;
			this.inflated = true;
			System.out.printf("Pelota inflada a %.1f PSI%n", pressure);
		} else {
			System.out.println("Presión inválida. Rango permitido: 0.1 - " + (getRecommendedPressure() * 1.2) + " PSI");
		}
	}

	public void deflate() {
		this.currentPressure = 0.0;
		this.inflated = false;
		System.out.println("Pelota desinflada completamente");
	}

	public boolean isInflated() {
		return inflated && currentPressure > 0;
	}

	public String getBallInfo() {
		return String.format("%s | Peso: %.0fg | Material: %s | Presión: %.1f PSI %s", getBasicInfo(), weight, material,
				currentPressure, isInflated() ? "✓" : "✗");
	}

	public abstract double getRecommendedPressure();

	public void displayInfo() {
		System.out.println("═══════════════════════════════════════");
		System.out.println("           INFORMACIÓN DE PELOTA");
		System.out.println("═══════════════════════════════════════");
		System.out.println(getBallInfo());
		System.out.printf("Presión recomendada: %.1f PSI%n", getRecommendedPressure());
		System.out.println("Estado: " + (isInflated() ? "Lista para usar" : "Necesita inflado"));
		System.out.println("═══════════════════════════════════════");
	}

}
