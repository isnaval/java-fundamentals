package java_oop.advanced.electronics_store_system.categories;

import java.util.ArrayList;
import java.util.List;

public class Category {
	private String name;
	private String description;
	private Category parentCategory;
	private List<Category> subcategories;
	private List<String> attributes;
	private boolean isActive;
	private int productCount;

	public Category(String name, String description) {
		this.name = name;
		this.description = description;
		this.subcategories = new ArrayList<>();
		this.attributes = new ArrayList<>();
		this.isActive = true;
		this.productCount = 0;
		this.parentCategory = null;
	}

	public Category(String name, String description, Category parentCategory) {
		this(name, description);
		this.parentCategory = parentCategory;
		if (parentCategory != null) {
			parentCategory.addSubcategory(this);
		}
	}

	public void addSubcategory(Category subcategory) {
		if (!subcategories.contains(subcategory)) {
			subcategories.add(subcategory);
			subcategory.parentCategory = this;
		}
	}

	public void removeSubcategory(Category subcategory) {
		subcategories.remove(subcategory);
		subcategory.parentCategory = null;
	}

	public void addAttribute(String attribute) {
		if (!attributes.contains(attribute)) {
			attributes.add(attribute);
		}
	}

	public boolean isRootCategory() {
		return parentCategory == null;
	}

	public boolean hasSubcategories() {
		return !subcategories.isEmpty();
	}

	public String getFullPath() {
		if (parentCategory == null) {
			return name;
		}
		return parentCategory.getFullPath() + " > " + name;
	}

	public void incrementProductCount() {
		productCount++;
		if (parentCategory != null) {
			parentCategory.incrementProductCount();
		}
	}

	public void decrementProductCount() {
		if (productCount > 0) {
			productCount--;
			if (parentCategory != null) {
				parentCategory.decrementProductCount();
			}
		}
	}

	public void showCategoryInfo() {
		System.out.println("📂 INFORMACIÓN DE CATEGORÍA:");
		System.out.println("============================");
		System.out.println("Nombre: " + name);
		System.out.println("Descripción: " + description);
		System.out.println("Ruta completa: " + getFullPath());
		System.out.println("Productos: " + productCount);
		System.out.println("Subcategorías: " + subcategories.size());
		System.out.println("Atributos: " + String.join(", ", attributes));
		System.out.println("Estado: " + (isActive ? "Activa" : "Inactiva"));

		if (hasSubcategories()) {
			System.out.println("\nSubcategorías:");
			for (Category sub : subcategories) {
				System.out.println("  - " + sub.getName() + " (" + sub.getProductCount() + " productos)");
			}
		}
	}

	// Getters y Setters
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public List<Category> getSubcategories() {
		return new ArrayList<>(subcategories);
	}

	public List<String> getAttributes() {
		return new ArrayList<>(attributes);
	}

	public boolean isActive() {
		return isActive;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setActive(boolean active) {
		isActive = active;
	}

	@Override
	public String toString() {
		return String.format("%s (%d productos)", name, productCount);
	}
}