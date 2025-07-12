package java_oop.advanced.cruise_reservation_system.test;

import java_oop.advanced.cruise_reservation_system.cruise.CabinType;
import java_oop.advanced.cruise_reservation_system.cruise.CruiseShip;

public class CruiseShipTest {
	public static void runTests() {
		System.out.println("🧪 EJECUTANDO PRUEBAS DE CRUCERO");
		System.out.println("===============================");

		// Test 1: Crear crucero
		CruiseShip ship = new CruiseShip("Test Ship", 100);
		assert ship.getName().equals("Test Ship") : "Nombre del crucero incorrecto";
		assert ship.getCapacity() == 100 : "Capacidad del crucero incorrecta";

		// Test 2: Verificar cabinas
		assert ship.getTotalCabins() > 0 : "No se crearon cabinas";

		// Test 3: Buscar cabinas por tipo
		assert !ship.getCabinsByType(CabinType.INTERIOR).isEmpty() : "No hay cabinas interiores";

		System.out.println("✅ Todas las pruebas de crucero pasaron");
	}
}