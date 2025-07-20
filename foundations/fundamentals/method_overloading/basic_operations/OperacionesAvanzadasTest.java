package fundamentals.method_overloading.basic_operations;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperacionesAvanzadasTest {

	private OperacionesAvanzadas operaciones;

	@BeforeEach
	void setUp() {
		operaciones = new OperacionesAvanzadas();
	}

	@Test
	@DisplayName("Suma de dos números enteros positivos")
	void testSumarDosEnterosPositivos() {
		int resultado = operaciones.sumar(5, 7);
		assertEquals(12, resultado);
	}

	@Test
	@DisplayName("Suma con números negativos")
	void testSumarConNumerosNegativos() {
		int resultado = operaciones.sumar(-3, 8);
		assertEquals(5, resultado);
	}

	@Test
	@DisplayName("Suma con cero")
	void testSumarConCero() {
		int resultado = operaciones.sumar(0, 15);
		assertEquals(15, resultado);
	}

	@Test
	@DisplayName("Suma de tres números enteros")
	void testSumarTresEnteros() {
		int resultado = operaciones.sumar(5, 7, 2);
		assertEquals(14, resultado);
	}

	@Test
	@DisplayName("Suma de tres números con negativos")
	void testSumarTresEnterosConNegativos() {
		int resultado = operaciones.sumar(-2, 5, -1);
		assertEquals(2, resultado);
	}

	@Test
	@DisplayName("Suma de array de enteros")
	void testSumarArrayEnteros() {
		int[] numeros = { 1, 2, 3, 4, 5 };
		int resultado = operaciones.sumar(numeros);
		assertEquals(15, resultado);
	}

	@Test
	@DisplayName("Suma de array vacío")
	void testSumarArrayVacio() {
		int[] numeros = {};
		int resultado = operaciones.sumar(numeros);
		assertEquals(0, resultado);
	}

	@Test
	@DisplayName("Suma de array null lanza excepción")
	void testSumarArrayNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			operaciones.sumar((int[]) null);
		});
	}

	@Test
	@DisplayName("Suma de dos números decimales")
	void testSumarDosDecimales() {
		double resultado = operaciones.sumar(2.5, 5.1);
		assertEquals(7.6, resultado, 0.001);
	}

	// ===== TESTS PARA SUMA DE ARRAY DE DECIMALES =====

	@Test
	@DisplayName("Suma de array de decimales")
	void testSumarArrayDecimales() {
		double[] numeros = { 1.5, 2.0, 3.3, 4.7, 8.2 };
		double resultado = operaciones.sumar(numeros);
		assertEquals(19.7, resultado, 0.001);
	}

	@Test
	@DisplayName("Operación personalizada - multiplicar")
	void testOperacionPersonalizadaMultiplicar() {
		int resultado = operaciones.operacionPersonalizada(3, 4, 4, "multiplicar");
		assertEquals(16, resultado);
	}

	@Test
	@DisplayName("Operación personalizada - restar")
	void testOperacionPersonalizadaRestar() {
		int resultado = operaciones.operacionPersonalizada(10, 3, 2, "restar");
		assertEquals(5, resultado);
	}

	@Test
	@DisplayName("Operación personalizada - operación no válida")
	void testOperacionPersonalizadaNoValida() {
		int resultado = operaciones.operacionPersonalizada(5, 3, 2, "dividir");
		assertEquals(0, resultado);
	}
}
