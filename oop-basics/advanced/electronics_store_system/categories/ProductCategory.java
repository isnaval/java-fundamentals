package java_oop.advanced.electronics_store_system.categories;

public enum ProductCategory {
	// Categorías principales
	SMARTPHONES("Smartphones", "Teléfonos inteligentes", true), LAPTOPS("Laptops", "Computadoras portátiles", true),
	TELEVISIONS("Televisiones", "Televisores y monitores", true), AUDIO("Audio", "Equipos de audio y sonido", true),
	CAMERAS("Cámaras", "Equipos fotográficos", true), GAMING("Gaming", "Equipos para videojuegos", true),
	WEARABLES("Wearables", "Dispositivos vestibles", true),
	SMART_HOME("Casa Inteligente", "Dispositivos domóticos", true),
	ACCESSORIES("Accesorios", "Accesorios y complementos", true),

	// Subcategorías de Smartphones
	SMARTPHONES_ANDROID("Android", "Smartphones con Android", false), SMARTPHONES_IOS("iOS", "iPhones de Apple", false),
	SMARTPHONES_BUDGET("Gama Baja", "Smartphones económicos", false),
	SMARTPHONES_FLAGSHIP("Gama Alta", "Smartphones premium", false),

	// Subcategorías de Laptops
	LAPTOPS_GAMING("Gaming", "Laptops para videojuegos", false),
	LAPTOPS_BUSINESS("Empresariales", "Laptops para empresas", false),
	LAPTOPS_ULTRABOOK("Ultrabooks", "Laptops ultraligeras", false),
	LAPTOPS_WORKSTATION("Workstation", "Estaciones de trabajo", false),

	// Subcategorías de Audio
	AUDIO_HEADPHONES("Auriculares", "Auriculares y cascos", false),
	AUDIO_SPEAKERS("Altavoces", "Altavoces y sistemas de sonido", false),
	AUDIO_EARBUDS("Earbuds", "Auriculares inalámbricos", false),

	// Subcategorías de Gaming
	GAMING_CONSOLES("Consolas", "Consolas de videojuegos", false),
	GAMING_PC("PC Gaming", "Computadoras para gaming", false),
	GAMING_ACCESSORIES("Accesorios Gaming", "Periféricos gaming", false);

	private final String displayName;
	private final String description;
	private final boolean isMainCategory;

	ProductCategory(String displayName, String description, boolean isMainCategory) {
		this.displayName = displayName;
		this.description = description;
		this.isMainCategory = isMainCategory;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getDescription() {
		return description;
	}

	public boolean isMainCategory() {
		return isMainCategory;
	}

	public static ProductCategory[] getMainCategories() {
		return java.util.Arrays.stream(values()).filter(ProductCategory::isMainCategory)
				.toArray(ProductCategory[]::new);
	}

	public static ProductCategory[] getSubcategories() {
		return java.util.Arrays.stream(values()).filter(cat -> !cat.isMainCategory()).toArray(ProductCategory[]::new);
	}

	@Override
	public String toString() {
		return displayName;
	}
}
