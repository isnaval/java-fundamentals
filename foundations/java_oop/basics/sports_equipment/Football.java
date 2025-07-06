package java_oop.basics.sports_equipment;

public class Football extends Ball {

	private String type;
	private int panelCount;
	private static final double RECOMMENDED_PRESSURE = 12.0;

	public Football(int id, String type) {
		super(id, "Fútbol", 420, "Cuero sintético");
		this.type = type;
		this.panelCount = setPanelsByType(type);
	}

	private int setPanelsByType(String type) {
		switch (type.toLowerCase()) {
		case "fifa":
		case "profesional":
			return 6;
		case "entrenamiento":
			return 32;
		case "playa":
			return 18;
		case "sala":
			return 32;
		default:
			return 32;
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
		this.panelCount = setPanelsByType(type);
	}

	public int getPanelCount() {
		return panelCount;
	}

	public void setPanelCount(int panelCount) {
		this.panelCount = panelCount;
	}

	@Override
	public double getRecommendedPressure() {
		switch (type.toLowerCase()) {
		case "fifa":
		case "profesional":
			return RECOMMENDED_PRESSURE;
		case "entrenamiento":
			return RECOMMENDED_PRESSURE - 1.0;
		case "playa":
			return RECOMMENDED_PRESSURE - 2.0;
		case "sala":
			return RECOMMENDED_PRESSURE - 1.5;
		default:
			return RECOMMENDED_PRESSURE;
		}
	}

	public void performKickTest() {
		if (isInflated()) {
			double kickDistance = (getCurrentPressure() / getRecommendedPressure()) * 25;
			System.out.printf("⚽ Test de patada: %.1f metros de distancia%n", kickDistance);

			if (kickDistance >= 20 && kickDistance <= 30) {
				System.out.println("✅ Distancia óptima para juego");
			} else if (kickDistance < 20) {
				System.out.println("⚠️ Necesita más presión para mejor rendimiento");
			} else {
				System.out.println("⚠️ Demasiada presión - puede ser peligroso");
			}
		} else {
			System.out.println("❌ No se puede hacer test - pelota desinflada");
		}
	}

	public boolean isFIFACompliant() {
		if (!type.equalsIgnoreCase("FIFA") && !type.equalsIgnoreCase("profesional")) {
			return false;
		}

		boolean weightOK = weight >= 410 && weight <= 450;
		boolean pressureOK = getCurrentPressure() >= 8.7 && getCurrentPressure() <= 15.6;

		return weightOK && pressureOK && isInflated();
	}

	@Override
	public void displayInfo() {
		System.out.println("═══════════════════════════════════════");
		System.out.println("           PELOTA DE FÚTBOL");
		System.out.println("═══════════════════════════════════════");
		System.out.println(getBallInfo());
		System.out.println("Tipo: " + type);
		System.out.println("Paneles: " + panelCount);
		System.out.printf("Presión recomendada: %.1f PSI%n", getRecommendedPressure());
		System.out.println("Cumple FIFA: " + (isFIFACompliant() ? "✅ Sí" : "❌ No"));
		System.out.println("Estado: " + (isInflated() ? "Lista para patear" : "Necesita inflado"));
		System.out.println("═══════════════════════════════════════");
	}

	@Override
	public String toString() {
		return String.format("Football[%s, Tipo: %s, Paneles: %d]", getBallInfo(), type, panelCount);
	}
}