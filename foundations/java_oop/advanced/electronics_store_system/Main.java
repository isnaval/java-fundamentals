package java_oop.advanced.electronics_store_system;

import java_oop.advanced.electronics_store_system.store.ElectronicsStore;

public class Main {
	public static void main(String[] args) {
		ElectronicsStore store = new ElectronicsStore("TechWorld Electronics");

		System.out.println("🌟 SISTEMA DE GESTIÓN DE TIENDA DE ELECTRÓNICOS 🌟");
		System.out.println("=================================================");
		System.out.println();
		System.out.println("🎯 CARACTERÍSTICAS DEL SISTEMA:");
		System.out.println("• Herencia: Product → Smartphone, Laptop, TV, etc.");
		System.out.println("• Polimorfismo: Métodos específicos por tipo de producto");
		System.out.println("• Encapsulación: Datos protegidos con getters/setters");
		System.out.println("• Abstracción: Clases abstractas Employee y Product");
		System.out.println("• Composición: Store contiene Products, Customers, Employees");
		System.out.println();
		System.out.println("🚀 FUNCIONALIDADES:");
		System.out.println("• Gestión completa de productos con especificaciones");
		System.out.println("• Sistema de clientes (Normal, VIP, Empresarial)");
		System.out.println("• Gestión de empleados con cálculo de salarios");
		System.out.println("• Sistema de ventas con descuentos automáticos");
		System.out.println("• Control de inventario y estadísticas");
		System.out.println();

		store.startInteractiveSystem();
	}
}