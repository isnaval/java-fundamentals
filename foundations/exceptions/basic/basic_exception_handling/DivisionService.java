package exceptions.basic.basic_exception_handling;

import java.util.ArrayList;
import java.util.List;

public class DivisionService {

	private List<Division> history;

	public DivisionService() {
		this.history = new ArrayList<>();
	}

	// Realiza una división
	public Division performDivision(int numerator, int denominator)
			throws ArithmeticException, IllegalArgumentException {

		// Validaciones
		DivisionValidator.validateRange(numerator);
		DivisionValidator.validateRange(denominator);
		DivisionValidator.validateDenominator(denominator);
		DivisionValidator.validatePrecision(numerator, denominator);

		// Crear y calcular
		Division division = new Division(numerator, denominator, denominator);
		division.calculate();

		// Guardar en historial
		history.add(division);

		return division;
	}

	// Muestra el resultado de una división
	public void displayResult(Division division) {
		System.out.println("\n=== RESULTADO ===");
		System.out.println("División: " + division);
		System.out.println("Cociente entero: " + division.getQuotient());
		System.out.println("Resto: " + division.getRemainder());

		// Información adicional
		analyzeResult(division);
	}

	// Analiza el resultado
	private void analyzeResult(Division division) {
		double result = division.getResult();

		if (result == (int) result) {
			System.out.println("✓ División exacta");
		} else {
			System.out.println("✓ División con decimales");
		}

		if (result > 0) {
			System.out.println("✓ Resultado positivo");
		} else if (result < 0) {
			System.out.println("✓ Resultado negativo");
		}
	}

	// Muestra el historial
	public void displayHistory() {
		if (history.isEmpty()) {
			System.out.println("\n📋 No hay operaciones en el historial");
			return;
		}

		System.out.println("\n=== HISTORIAL DE DIVISIONES ===");
		for (int i = 0; i < history.size(); i++) {
			System.out.println((i + 1) + ". " + history.get(i));
		}
	}

	// Limpia el historial
	public void clearHistory() {
		history.clear();
		System.out.println("✅ Historial limpiado");
	}
}