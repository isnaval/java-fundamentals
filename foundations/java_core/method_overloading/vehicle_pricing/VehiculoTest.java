package java_core.method_overloading.vehicle_pricing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VehiculoTest {

	private Vehiculo vehiculo;

	@BeforeEach
	void setUp() {
		vehiculo = new Vehiculo("Ford", "Fiesta", 15900.0);
	}

	@Test
	@DisplayName("Constructor básico crea vehículo correctamente")
	void testConstructorBasico() {
		assertEquals("Ford", vehiculo.getMarca());
		assertEquals("Fiesta", vehiculo.getModelo());
		assertEquals(15900.0, vehiculo.getPrecio());
	}

	@Test
	@DisplayName("Precio final con recargo estándar")
	void testCalcularPrecioFinalConRecargo() {
		double resultado = vehiculo.calcularPrecioFinal();
		assertEquals(18285.0, resultado, 0.01); // 15900 * 1.15
	}

	@Test
	@DisplayName("Precio final con descuento")
	void testCalcularPrecioFinalConDescuento() {
		double resultado = vehiculo.calcularPrecioFinal(2000.0);
		assertEquals(13900.0, resultado, 0.01); // 15900 - 2000
	}

	@Test
	@DisplayName("Precio final con descuento e impuesto")
	void testCalcularPrecioFinalConDescuentoEImpuesto() {
		double resultado = vehiculo.calcularPrecioFinal(1500.0, 10.0);
		assertEquals(15990.0, resultado, 0.01);
	}

	@Test
	@DisplayName("Descuento mayor al precio lanza excepción")
	void testDescuentoMayorAlPrecio() {
		assertThrows(IllegalArgumentException.class, () -> {
			vehiculo.calcularPrecioFinal(20000.0);
		});
	}

	@Test
	@DisplayName("Calcular precio financiado")
	void testCalcularPrecioFinanciado() {
		double resultado = vehiculo.calcularPrecioFinanciado(24, 5.0);
		assertEquals(17490.0, resultado, 1.0);
	}
}