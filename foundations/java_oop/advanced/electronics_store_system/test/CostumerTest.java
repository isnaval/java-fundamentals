package java_oop.advanced.electronics_store_system.test;

import java_oop.advanced.electronics_store_system.customers.BusinessCustomer;
import java_oop.advanced.electronics_store_system.customers.Customer;
import java_oop.advanced.electronics_store_system.customers.VIPCustomer;

public class CostumerTest {
	public static void runCustomerDemo() {
		System.out.println("🧪 DEMOSTRACIÓN DE HERENCIA EN CLIENTES:");
		System.out.println("=========================================");

		Customer regularCustomer = new Customer("Juan Pérez", "juan@email.com", "+34600111111", "Calle Mayor 1");

		VIPCustomer vipCustomer = new VIPCustomer("María García", "maria@email.com", "+34600222222", "Av. Libertad 15",
				"Gold");

		BusinessCustomer businessCustomer = new BusinessCustomer("Carlos López", "carlos@empresa.com", "+34600333333",
				"Pol. Industrial 5", "TechCorp S.L.", "B12345678", 10000.0);

		System.out.println("💰 SIMULACIÓN DE COMPRAS:");
		System.out.println("=========================");

		double purchaseAmount = 1000.0;

		System.out.println("\n👤 CLIENTE REGULAR:");
		regularCustomer.showCustomerInfo();
		System.out.printf("Descuento aplicable: %.1f%%%n", regularCustomer.getDiscount());
		regularCustomer.addPurchase("iPhone 15", purchaseAmount);

		System.out.println("\n💎 CLIENTE VIP:");
		vipCustomer.showCustomerInfo();
		System.out.printf("Descuento aplicable: %.1f%%%n", vipCustomer.getDiscount());
		vipCustomer.addPurchase("MacBook Pro", purchaseAmount);

		System.out.println("\n🏢 CLIENTE EMPRESARIAL:");
		businessCustomer.showCustomerInfo();
		System.out.printf("Descuento base: %.1f%%%n", businessCustomer.getDiscount());
		System.out.printf("Descuento por volumen (10 unidades): %.1f%%%n", businessCustomer.getBulkDiscount(10));
		businessCustomer.addPurchase("50x Laptops Dell", purchaseAmount * 50);

		System.out.println("\n📊 ESTADO DESPUÉS DE COMPRAS:");
		System.out.println("=============================");

		System.out.println("\n👤 Cliente Regular:");
		regularCustomer.showCustomerInfo();

		System.out.println("\n💎 Cliente VIP:");
		vipCustomer.showCustomerInfo();

		System.out.println("\n🏢 Cliente Empresarial:");
		businessCustomer.showCustomerInfo();

		System.out.println("\n✅ Demostración de clientes completada!");
	}

	public static void main(String[] args) {
		runCustomerDemo();
	}
}