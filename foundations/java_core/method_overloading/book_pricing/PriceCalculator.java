package java_core.method_overloading.book_pricing;

public class PriceCalculator {
	// Aplicar descuento simple
	public double applyDiscount(double price, double percentage) {
		if (price < 0) {
			throw new IllegalArgumentException("El precio no puede ser negativo");
		}
		if (percentage < 0 || percentage > 100) {
			throw new IllegalArgumentException("El porcentaje debe estar entre 0 y 100");
		}

		return price - (price * percentage / 100);
	}

	// Aplicar descuento con monto fijo
	public double applyDiscount(double price, double amount, String type) {
		if (price < 0) {
			throw new IllegalArgumentException("El precio no puede ser negativo");
		}
		if (amount < 0) {
			throw new IllegalArgumentException("El monto no puede ser negativo");
		}

		if ("FIXED".equalsIgnoreCase(type)) {
			return Math.max(0, price - amount);
		} else {
			return applyDiscount(price, amount);
		}
	}

	// Calcular precio total para array
	public double calculateTotal(double[] prices) {
		if (prices == null) {
			throw new IllegalArgumentException("El array de precios no puede ser null");
		}

		double total = 0.0;
		for (double price : prices) {
			total += price;
		}

		return total;
	}

	public double calculateTotal(double price, double taxRate) {
		if (price < 0) {
			throw new IllegalArgumentException("El precio no puede ser negativo");
		}
		if (taxRate < 0) {
			throw new IllegalArgumentException("La tasa de impuesto no puede ser negativa");
		}
		return price + (price * taxRate / 100);
	}

}
