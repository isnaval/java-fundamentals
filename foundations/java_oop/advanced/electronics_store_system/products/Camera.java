package java_oop.advanced.electronics_store_system.products;

public class Camera extends Product {
	private String type;
	private int megapixels;
	private String sensorSize;
	private boolean hasWifi;
	private boolean canRecordVideo;
	private String maxVideoResolution;
	private int batteryLife;
	private boolean hasImageStabilization;

	public Camera(String brand, String model, double price, String color, int warranty, int stockQuantity, String type,
			int megapixels, String sensorSize, boolean hasWifi, boolean canRecordVideo, String maxVideoResolution,
			int batteryLife, boolean hasImageStabilization) {
		super(brand, model, price, color, warranty, stockQuantity);
		this.type = type;
		this.megapixels = megapixels;
		this.sensorSize = sensorSize;
		this.hasWifi = hasWifi;
		this.canRecordVideo = canRecordVideo;
		this.maxVideoResolution = maxVideoResolution;
		this.batteryLife = batteryLife;
		this.hasImageStabilization = hasImageStabilization;
	}

	@Override
	public void showSpecifications() {
		System.out.println("📷 ESPECIFICACIONES DE LA CÁMARA:");
		System.out.println("=================================");
		System.out.println("Marca: " + brand);
		System.out.println("Modelo: " + model);
		System.out.println("Tipo: " + type);
		System.out.println("Megapíxeles: " + megapixels + " MP");
		System.out.println("Sensor: " + sensorSize);
		System.out.println("WiFi: " + (hasWifi ? "Sí" : "No"));
		System.out.println("Video: " + (canRecordVideo ? maxVideoResolution : "No"));
		System.out.println("Duración Batería: " + batteryLife + " disparos");
		System.out.println("Estabilización: " + (hasImageStabilization ? "Sí" : "No"));
		System.out.println("Color: " + color);
		System.out.println("Precio: €" + price);
		System.out.println("Garantía: " + warranty + " meses");
	}

	@Override
	public String getProductType() {
		return "Cámara";
	}

	public boolean isProfessionalCamera() {
		return sensorSize.equals("Full Frame") && megapixels >= 24;
	}

	public boolean isContentCreatorCamera() {
		return canRecordVideo && maxVideoResolution.equals("4K") && hasWifi;
	}

	// Getters específicos
	public String getType() {
		return type;
	}

	public int getMegapixels() {
		return megapixels;
	}

	public String getSensorSize() {
		return sensorSize;
	}

	public boolean isHasWifi() {
		return hasWifi;
	}

	public boolean isCanRecordVideo() {
		return canRecordVideo;
	}

	public String getMaxVideoResolution() {
		return maxVideoResolution;
	}

	public int getBatteryLife() {
		return batteryLife;
	}

	public boolean isHasImageStabilization() {
		return hasImageStabilization;
	}
}