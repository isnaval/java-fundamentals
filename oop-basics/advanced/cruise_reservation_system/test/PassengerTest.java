package java_oop.advanced.cruise_reservation_system.test;

import java_oop.advanced.cruise_reservation_system.passengers.GroupPassenger;
import java_oop.advanced.cruise_reservation_system.passengers.Passenger;
import java_oop.advanced.cruise_reservation_system.passengers.VIPPassenger;

public class PassengerTest {
	public static void runTests() {
		System.out.println("🧪 EJECUTANDO PRUEBAS DE PASAJEROS");
		System.out.println("=================================");

		// Test 1: Crear pasajero normal
		Passenger passenger = new Passenger("Test User", "test@email.com", "12345678", 30, "+34600000000");
		assert passenger.getName().equals("Test User") : "Nombre del pasajero incorrecto";
		assert passenger.getAge() == 30 : "Edad del pasajero incorrecta";

		// Test 2: Crear pasajero VIP
		VIPPassenger vip = new VIPPassenger("VIP User", "vip@email.com", "87654321", 40, "+34600111111", "Gold", 20.0);
		assert vip.getMembershipLevel().equals("Gold") : "Nivel de membresía incorrecto";
		assert vip.getDiscountPercentage() == 20.0 : "Descuento VIP incorrecto";

		// Test 3: Crear grupo
		GroupPassenger group = new GroupPassenger("Test Group", passenger);
		assert group.getGroupSize() == 1 : "Tamaño inicial del grupo incorrecto";

		group.addMember(vip);
		assert group.getGroupSize() == 2 : "Tamaño del grupo después de agregar miembro incorrecto";

		System.out.println("✅ Todas las pruebas de pasajeros pasaron");
	}
}