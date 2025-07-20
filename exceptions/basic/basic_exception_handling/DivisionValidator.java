package exceptions.basic.basic_exception_handling;

public class DivisionValidator {

	// Valida que el denominador no sea cero
	public static void validateDenominator(int denominator) throws ArithmeticException {
		if (denominator == 0) {
			throw new ArithmeticException("El denominador no puede ser cero");
		}
	}

	// Valida el rango de números
	public static void validateRange(int number) throws IllegalArgumentException {
		int MAX_VALUE = 1000000;
		int MIN_VALUE = -1000000;

		if (number > MAX_VALUE || number < MIN_VALUE) {
			throw new IllegalArgumentException("El número debe estar entre " + MIN_VALUE + " y " + MAX_VALUE);
		}
	}

	// Valida si los números producirán un resultado muy pequeño
	public static void validatePrecision(int numerator, int denominator) {
		if (Math.abs(numerator) < Math.abs(denominator) / 1000) {
			System.out.println("⚠️  Advertencia: El resultado será muy pequeño");
		}
	}
}
