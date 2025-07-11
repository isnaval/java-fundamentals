package java_core.method_overloading.vehicle_pricing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompradorTest {

	private Comprador comprador;
	private Vehiculo vehiculo;

	@BeforeEach
	void setUp() {
		comprador = new Comprador("Alfonso", 20000.0, 30, true, 3000.0);
		vehiculo = new Vehiculo("Ford", "Fiesta", 15900.0);
	}

	@Test
	@DisplayName("Constructor básico crea comprador correctamente")
	void testConstructorBasico() {
		Comprador comp = new Comprador("Juan", 15000.0);
		assertEquals("Juan", comp.getNombre());
		assertEquals(15000.0, comp.getPresupuesto());
	}

	@Test
	@DisplayName("Puede realizar oferta de compra al contado")
	void testRealizarOfertaCompraContado() {
		boolean resultado = comprador.realizarOfertaCompra(vehiculo);
		assertTrue(resultado);
	}

	@Test
	@DisplayName("Puede realizar oferta de compra a plazos")
	void testRealizarOfertaCompraPlazos() {
		boolean resultado = comprador.realizarOfertaCompra(vehiculo, 12);
		assertTrue(resultado);
	}

	@Test
	@DisplayName("Capacidad de financiación mensual")
	void testCalcularCapacidadFinanciacion() {
		double capacidad = comprador.calcularCapacidadFinanciacion();
		assertEquals(900.0, capacidad, 0.01);
	}

	@Test
	@DisplayName("Comprador sin licencia no puede comprar")
	void testCompradorSinLicencia() {
		Comprador sinLicencia = new Comprador("Pedro", 25000.0, 25, false, 4000.0);
		boolean resultado = sinLicencia.realizarOfertaCompra(vehiculo);
		assertFalse(resultado);
	}
}
