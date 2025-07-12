package java_oop.advanced.electronics_store_system.products;

public class Laptop extends Product {
	private String processor;
	private int ram;
	private int storage;
	private String storageType;
	private int screenSize;
	private String graphicsCard;
	private double weight;
	private boolean hasTouchscreen;

	public Laptop(String brand, String model, double price, String color, int warranty, int stockQuantity,
			String processor, int ram, int storage, String storageType, int screenSize, String graphicsCard,
			double weight, boolean hasTouchscreen) {
		super(brand, model, price, color, warranty, stockQuantity);
		this.processor = processor;
		this.ram = ram;
		this.storage = storage;
		this.storageType = storageType;
		this.screenSize = screenSize;
		this.graphicsCard = graphicsCard;
		this.weight = weight;
		this.hasTouchscreen = hasTouchscreen;
	}

	@Override
	public void showSpecifications() {
		System.out.println("💻 ESPECIFICACIONES DE LA LAPTOP:");
		System.out.println("=================================");
		System.out.println("Marca: " + brand);
		System.out.println("Modelo: " + model);
		System.out.println("Procesador: " + processor);
		System.out.println("RAM: " + ram + " GB");
		System.out.println("Almacenamiento: " + storage + " GB " + storageType);
		System.out.println("Pantalla: " + screenSize + "\"" + (hasTouchscreen ? " (Táctil)" : ""));
		System.out.println("Tarjeta Gráfica: " + graphicsCard);
		System.out.println("Peso: " + weight + " kg");
		System.out.println("Color: " + color);
		System.out.println("Precio: €" + price);
		System.out.println("Garantía: " + warranty + " meses");
	}

	@Override
	public String getProductType() {
		return "Laptop";
	}

	public boolean isGamingLaptop() {
		return graphicsCard.toLowerCase().contains("rtx") || graphicsCard.toLowerCase().contains("rx") || ram >= 16;
	}

	public boolean isUltrabook() {
		return weight <= 1.5 && storageType.equals("SSD");
	}

	public String getProcessor() {
		return processor;
	}

	public int getRam() {
		return ram;
	}

	public int getStorage() {
		return storage;
	}

	public String getStorageType() {
		return storageType;
	}

	public int getScreenSize() {
		return screenSize;
	}

	public String getGraphicsCard() {
		return graphicsCard;
	}

	public double getWeight() {
		return weight;
	}

	public boolean isHasTouchscreen() {
		return hasTouchscreen;
	}
}