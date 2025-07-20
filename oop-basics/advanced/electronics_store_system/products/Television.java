package java_oop.advanced.electronics_store_system.products;

public class Television extends Product {
	private int screenSize;
	private String resolution;
	private String technology;
	private boolean smartTV;
	private String operatingSystem;
	private int refreshRate;
	private boolean hasHDR;

	public Television(String brand, String model, double price, String color, int warranty, int stockQuantity,
			int screenSize, String resolution, String technology, boolean smartTV, String operatingSystem,
			int refreshRate, boolean hasHDR) {
		super(brand, model, price, color, warranty, stockQuantity);
		this.screenSize = screenSize;
		this.resolution = resolution;
		this.technology = technology;
		this.smartTV = smartTV;
		this.operatingSystem = operatingSystem;
		this.refreshRate = refreshRate;
		this.hasHDR = hasHDR;
	}

	@Override
	public void showSpecifications() {
		System.out.println("📺 ESPECIFICACIONES DE LA TELEVISIÓN:");
		System.out.println("====================================");
		System.out.println("Marca: " + brand);
		System.out.println("Modelo: " + model);
		System.out.println("Tamaño: " + screenSize + "\"");
		System.out.println("Resolución: " + resolution);
		System.out.println("Tecnología: " + technology);
		System.out.println("Smart TV: " + (smartTV ? "Sí (" + operatingSystem + ")" : "No"));
		System.out.println("Tasa de Refresco: " + refreshRate + " Hz");
		System.out.println("HDR: " + (hasHDR ? "Sí" : "No"));
		System.out.println("Color: " + color);
		System.out.println("Precio: €" + price);
		System.out.println("Garantía: " + warranty + " meses");
	}

	@Override
	public String getProductType() {
		return "Televisión";
	}

	public boolean isGamingTV() {
		return refreshRate >= 120 && hasHDR;
	}

	public boolean isPremiumTV() {
		return technology.equals("OLED") || technology.equals("QLED");
	}

	public int getScreenSize() {
		return screenSize;
	}

	public String getResolution() {
		return resolution;
	}

	public String getTechnology() {
		return technology;
	}

	public boolean isSmartTV() {
		return smartTV;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public int getRefreshRate() {
		return refreshRate;
	}

	public boolean isHasHDR() {
		return hasHDR;
	}
}