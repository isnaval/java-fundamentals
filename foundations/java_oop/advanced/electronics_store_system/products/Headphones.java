package java_oop.advanced.electronics_store_system.products;

public class Headphones extends Product {
	private String type;
	private boolean wireless;
	private int batteryLife;
	private boolean noiseCanceling;
	private String connectivity;
	private int driverSize;
	private boolean hasMicrophone;

	public Headphones(String brand, String model, double price, String color, int warranty, int stockQuantity,
			String type, boolean wireless, int batteryLife, boolean noiseCanceling, String connectivity, int driverSize,
			boolean hasMicrophone) {
		super(brand, model, price, color, warranty, stockQuantity);
		this.type = type;
		this.wireless = wireless;
		this.batteryLife = batteryLife;
		this.noiseCanceling = noiseCanceling;
		this.connectivity = connectivity;
		this.driverSize = driverSize;
		this.hasMicrophone = hasMicrophone;
	}

	@Override
	public void showSpecifications() {
		System.out.println("🎧 ESPECIFICACIONES DE LOS AURICULARES:");
		System.out.println("======================================");
		System.out.println("Marca: " + brand);
		System.out.println("Modelo: " + model);
		System.out.println("Tipo: " + type);
		System.out.println("Conectividad: " + connectivity);
		System.out.println("Inalámbricos: " + (wireless ? "Sí" : "No"));
		if (wireless) {
			System.out.println("Batería: " + batteryLife + " horas");
		}
		System.out.println("Cancelación de Ruido: " + (noiseCanceling ? "Sí" : "No"));
		System.out.println("Tamaño del Driver: " + driverSize + " mm");
		System.out.println("Micrófono: " + (hasMicrophone ? "Sí" : "No"));
		System.out.println("Color: " + color);
		System.out.println("Precio: €" + price);
		System.out.println("Garantía: " + warranty + " meses");
	}

	@Override
	public String getProductType() {
		return "Auriculares";
	}

	public boolean isGamingHeadphones() {
		return hasMicrophone && (type.equals("Over-ear") || type.equals("On-ear"));
	}

	public boolean isProfessionalAudio() {
		return driverSize >= 40 && !wireless;
	}

	public String getType() {
		return type;
	}

	public boolean isWireless() {
		return wireless;
	}

	public int getBatteryLife() {
		return batteryLife;
	}

	public boolean isNoiseCanceling() {
		return noiseCanceling;
	}

	public String getConnectivity() {
		return connectivity;
	}

	public int getDriverSize() {
		return driverSize;
	}

	public boolean isHasMicrophone() {
		return hasMicrophone;
	}
}