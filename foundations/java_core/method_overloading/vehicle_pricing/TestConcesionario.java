package java_core.method_overloading.vehicle_pricing;

public class TestConcesionario {

	public static void main(String[] args) {
		System.out.println("=== SISTEMA DE CONCESIONARIO DE VEHÍCULOS ===\n");
		System.out.println("Demostración de sobrecarga de métodos para ofertas de compra\n");

		Vehiculo vehiculo1 = new Vehiculo("Ford", "Fiesta", 15900.0);
		Vehiculo vehiculo2 = new Vehiculo("Toyota", "Corolla", 22000.0, 2023, "Azul");
		Vehiculo vehiculo3 = new Vehiculo("BMW", "Serie 3", 35000.0, 2024, "Negro");

		Comprador comprador1 = new Comprador("Alfonso", 20000.0);
		Comprador comprador2 = new Comprador("María", 45000.0, 35, true, 4500.0);
		Comprador comprador3 = new Comprador("Carlos", 15000.0, 22, false, 2000.0);

		Vehiculo[] vehiculos = { vehiculo1, vehiculo2, vehiculo3 };
		Comprador[] compradores = { comprador1, comprador2, comprador3 };

		System.out.println("=== VEHÍCULOS DISPONIBLES ===");
		for (int i = 0; i < vehiculos.length; i++) {
			System.out.println((i + 1) + ". " + vehiculos[i]);
			mostrarPreciosVehiculo(vehiculos[i]);
			System.out.println();
		}

		System.out.println("=== COMPRADORES POTENCIALES ===");
		for (int i = 0; i < compradores.length; i++) {
			System.out.println((i + 1) + ". " + compradores[i]);
			System.out.println("   " + compradores[i].obtenerInformacionCompleta().split("\n")[5]); // Capacidad de
																									// financiación
			System.out.println();
		}

		System.out.println("=== SIMULACIÓN DE OFERTAS DE COMPRA ===");

		System.out.println("1. Alfonso vs Ford Fiesta:");
		evaluarTodasLasOfertas(comprador1, vehiculo1);

		System.out.println("\n2. María vs BMW Serie 3:");
		evaluarTodasLasOfertas(comprador2, vehiculo3);

		System.out.println("\n3. Carlos vs Toyota Corolla (sin licencia):");
		evaluarTodasLasOfertas(comprador3, vehiculo2);

		System.out.println("\n=== FIN DE LA SIMULACIÓN ===");
	}

	private static void mostrarPreciosVehiculo(Vehiculo vehiculo) {
		System.out.printf("   Precio base: €%.2f%n", vehiculo.getPrecio());
		System.out.printf("   Con recargo (15%%): €%.2f%n", vehiculo.calcularPrecioFinal());
		System.out.printf("   Con descuento €2000: €%.2f%n", vehiculo.calcularPrecioFinal(2000.0));
		System.out.printf("   Con desc. €1500 + IVA 10%%: €%.2f%n", vehiculo.calcularPrecioFinal(1500.0, 10.0));
		System.out.printf("   Financiado 36 meses (5%%): €%.2f%n", vehiculo.calcularPrecioFinanciado(36, 5.0));
		System.out.printf("   Descuento por antigüedad: %.1f%%%n", vehiculo.calcularDescuentoPorAntiguedad());
	}

	private static void evaluarTodasLasOfertas(Comprador comprador, Vehiculo vehiculo) {
		System.out.println("   Evaluando ofertas:");

		boolean contado = comprador.realizarOfertaCompra(vehiculo);
		System.out.println("   - Al contado: " + (contado ? "✓ APROBADA" : "✗ RECHAZADA"));

		boolean cuotas12 = comprador.realizarOfertaCompra(vehiculo, 12);
		System.out.println("   - 12 cuotas: " + (cuotas12 ? "✓ APROBADA" : "✗ RECHAZADA"));

		boolean financiada = comprador.realizarOfertaCompra(vehiculo, 36, 5.0);
		System.out.println("   - Financiada 36 meses (5%): " + (financiada ? "✓ APROBADA" : "✗ RECHAZADA"));

		boolean conEntrada = comprador.realizarOfertaCompra(vehiculo, 5000.0, 24);
		System.out.println("   - Con entrada €5000, 24 cuotas: " + (conEntrada ? "✓ APROBADA" : "✗ RECHAZADA"));

		System.out.printf("   - Capacidad máxima: €%.2f%n", comprador.calcularCapacidadCompra());
		System.out.printf("   - Cuota mensual máxima: €%.2f%n", comprador.calcularCapacidadFinanciacion());
	}
}
