package exceptions.basic.basic_exception_handling;

public class Division {
	private int numerator;
	private int denominator;
	private double result;

	public Division(int numerator, int denominator, double result) {
		super();
		this.numerator = numerator;
		this.denominator = denominator;
		this.result = result;
	}

	// Calcula el resultado
	public void calculate() throws ArithmeticException {
		if (denominator == 0) {
			throw new ArithmeticException("División por cero no permitida");
		}
		this.result = (double) numerator / denominator;
	}

	// Obtiene el cociente entero
	public int getQuotient() {
		return numerator / denominator;
	}

	// Obtiene el resto
	public int getRemainder() {
		return numerator % denominator;
	}

	// Getters
	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public double getResult() {
		return result;
	}

	@Override
	public String toString() {
		return String.format("%d ÷ %d = %.2f", numerator, denominator, result);
	}

}
