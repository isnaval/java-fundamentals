package java_oop.advanced.electronics_store_system.test;

import java_oop.advanced.electronics_store_system.products.Laptop;
import java_oop.advanced.electronics_store_system.products.Product;
import java_oop.advanced.electronics_store_system.products.Smartphone;
import java_oop.advanced.electronics_store_system.products.Television;

public class ProductTest {
	public static void runInheritanceDemo() {
		System.out.println("🧪 DEMOSTRACIÓN DE HERENCIA:");
		System.out.println("============================");

		Product[] products = {
				new Smartphone("Apple", "iPhone 15", 999.99, "Negro", 24, 10, "iOS", 6, 128, 8, 3274, true),
				new Laptop("Dell", "XPS 15", 1599.99, "Plata", 36, 5, "Intel i7", 16, 512, "SSD", 15, "RTX 4060", 1.8,
						false),
				new Television("Samsung", "QN85A", 1299.99, "Negro", 24, 3, 55, "4K", "QLED", true, "Tizen", 120,
						true) };

		System.out.println("📱 POLIMORFISMO EN ACCIÓN:");
		System.out.println("==========================");

		for (Product product : products) {
			System.out.println("\n" + "=".repeat(50));
			System.out.println("Tipo: " + product.getProductType());
			System.out.println("Precio original: €" + product.getPrice());
			System.out.println("Precio con descuento (10%): €" + String.format("%.2f", product.applyDiscount(10.0)));

			product.showSpecifications();

			if (product instanceof Smartphone) {
				Smartphone smartphone = (Smartphone) product;
				System.out.println("¿Es para gaming? " + smartphone.isGamingCapable());
			} else if (product instanceof Laptop) {
				Laptop laptop = (Laptop) product;
				System.out.println("¿Es laptop gaming? " + laptop.isGamingLaptop());
				System.out.println("¿Es ultrabook? " + laptop.isUltrabook());
			} else if (product instanceof Television) {
				Television tv = (Television) product;
				System.out.println("¿Es TV gaming? " + tv.isGamingTV());
				System.out.println("¿Es TV premium? " + tv.isPremiumTV());
			}
		}

		System.out.println("\n✅ Demostración de herencia completada!");
	}

	public static void main(String[] args) {
		runInheritanceDemo();
	}
}