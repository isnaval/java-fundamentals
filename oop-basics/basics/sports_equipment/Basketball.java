package java_oop.basics.sports_equipment;

public class Basketball extends Ball {

	private String color;
	private String usage;
	private static final double RECOMMENDED_PRESSURE = 8.5;

	public Basketball(int id, boolean isAdaptive, String color, String usage, double weight, String material) {
		super(id, "Baloncesto", weight, material);
		this.color = color;
		this.usage = usage;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	@Override
	public double getRecommendedPressure() {
		switch (usage.toLowerCase()) {
		case "profesional":
			return RECOMMENDED_PRESSURE;
		case "entrenamiento":
			return RECOMMENDED_PRESSURE - 0.5;
		case "recreativo":
			return RECOMMENDED_PRESSURE - 1.0;
		default:
			return RECOMMENDED_PRESSURE;
		}
	}

	public void performBounceTest() {
		if (isInflated()) {
			double bounceHeight = (getCurrentPressure() / getRecommendedPressure()) * 1.2; // metros
			System.out.printf("🏀 Test de rebote: %.1f metros de altura%n", bounceHeight);

			if (bounceHeight >= 1.1 && bounceHeight <= 1.3) {
				System.out.println("✅ Rebote óptimo para juego");
			} else if (bounceHeight < 1.1) {
				System.out.println("⚠️ Necesita más presión");
			} else {
				System.out.println("⚠️ Demasiada presión");
			}
		} else {
			System.out.println("❌ No se puede hacer test - pelota desinflada");
		}
	}

	public void displayInfo() {
		System.out.println("═══════════════════════════════════════");
		System.out.println("         PELOTA DE BALONCESTO");
		System.out.println("═══════════════════════════════════════");
		System.out.println(getBallInfo());
		System.out.println("Color: " + color);
		System.out.println("Uso: " + usage);
		System.out.printf("Presión recomendada: %.1f PSI%n", getRecommendedPressure());
		System.out.println("Estado: " + (isInflated() ? "Lista para driblar" : "Necesita inflado"));
		System.out.println("═══════════════════════════════════════");
	}

	@Override
	public String toString() {
		return String.format("Basketball[%s, Color: %s, Uso: %s]", getBallInfo(), color, usage);
	}
}