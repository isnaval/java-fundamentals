package java_oop.advanced.electronics_store_system.products;

public class Smartphone extends Product {
	private String operatingSystem;
	private int screenSize;
	private int storage;
	private int ram;
	private int batteryCapacity;
	private boolean has5G;

	public Smartphone(String brand, String model, double price, String color, int warranty, int stockQuantity,
			String operatingSystem, int screenSize, int storage, int ram, int batteryCapacity, boolean has5G) {
		super(brand, model, price, color, warranty, stockQuantity);
		this.operatingSystem = operatingSystem;
		this.screenSize = screenSize;
		this.storage = storage;
		this.ram = ram;
		this.batteryCapacity = batteryCapacity;
		this.has5G = has5G;
	}

	@Override
	public void showSpecifications() {
		System.out.println("📱 ESPECIFICACIONES DEL SMARTPHONE:");
		System.out.println("==================================");
		System.out.println("Marca: " + brand);
		System.out.println("Modelo: " + model);
		System.out.println("Sistema Operativo: " + operatingSystem);
		System.out.println("Pantalla: " + screenSize + "\"");
		System.out.println("Almacenamiento: " + storage + " GB");
		System.out.println("RAM: " + ram + " GB");
		System.out.println("Batería: " + batteryCapacity + " mAh");
		System.out.println("5G: " + (has5G ? "Sí" : "No"));
		System.out.println("Color: " + color);
		System.out.println("Precio: €" + price);
		System.out.println("Garantía: " + warranty + " meses");
	}

	@Override
	public String getProductType() {
		return "Smartphone";
	}

	public boolean isGamingCapable() {
		return ram >= 8 && storage >= 128;
	}

	// Getters específicos
	public String getOperatingSystem() {
		return operatingSystem;
	}

	public int getScreenSize() {
		return screenSize;
	}

	public int getStorage() {
		return storage;
	}

	public int getRam() {
		return ram;
	}

	public int getBatteryCapacity() {
		return batteryCapacity;
	}

	public boolean isHas5G() {
		return has5G;
	}
}
