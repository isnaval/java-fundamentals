package fundamentals.method_overloading.book_pricing;

public class BookPricing {

	// 1. Precio básico - sin descuento
	public double calculatePrice(Book book) {
		if (book == null) {
			throw new IllegalArgumentException("El libro no puede ser null");
		}
		return book.getBasePrice();
	}

	// 2. Precio con descuento porcentual directo
	public double calculatePrice(Book book, double discountPercentage) {
		if (book == null) {
			throw new IllegalArgumentException("El libro no puede ser null");
		}
		if (discountPercentage < 0 || discountPercentage > 100) {
			throw new IllegalArgumentException("El descuento debe estar entre 0 y 100");
		}

		double basePrice = book.getBasePrice();
		return basePrice - (basePrice * discountPercentage / 100);
	}

	// 3. Precio con tipo de descuento (enum)
	public double calculatePrice(Book book, DiscountType discountType) {
		if (book == null) {
			throw new IllegalArgumentException("El libro no puede ser null");
		}
		if (discountType == null) {
			discountType = DiscountType.NONE;
		}

		double basePrice = book.getBasePrice();
		return basePrice - (basePrice * discountType.getPercentage() / 100);
	}

	// 4. Precio por cantidad (descuento automático por volumen)
	public double calculatePrice(Book book, int quantity) {
		if (book == null) {
			throw new IllegalArgumentException("El libro no puede ser null");
		}
		if (quantity <= 0) {
			throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
		}

		double unitPrice = book.getBasePrice();
		double subtotal = unitPrice * quantity;

		// Descuento automático por cantidad
		if (quantity >= 10) {
			subtotal = subtotal * 0.85;
		} else if (quantity >= 5) {
			subtotal = subtotal * 0.90;
		}

		return subtotal;
	}

	// 5. Precio con cantidad y descuento adicional
	public double calculatePrice(Book book, int quantity, double discountPercentage) {
		if (book == null) {
			throw new IllegalArgumentException("El libro no puede ser null");
		}
		if (quantity <= 0) {
			throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
		}
		if (discountPercentage < 0 || discountPercentage > 100) {
			throw new IllegalArgumentException("El descuento debe estar entre 0 y 100");
		}

		// Primero calcular precio por cantidad
		double priceWithQuantityDiscount = calculatePrice(book, quantity);

		// Luego aplicar descuento adicional
		return priceWithQuantityDiscount - (priceWithQuantityDiscount * discountPercentage / 100);
	}

	// 6. Precio para array de libros
	public double calculatePrice(Book[] books) {
		if (books == null) {
			throw new IllegalArgumentException("El array de libros no puede ser null");
		}

		double total = 0.0;
		for (Book book : books) {
			if (book != null) {
				total += book.getBasePrice();
			}
		}

		return total;
	}

	// 7. Precio con membresía (boolean)
	public double calculatePrice(Book book, boolean isMember) {
		if (book == null) {
			throw new IllegalArgumentException("El libro no puede ser null");
		}

		double basePrice = book.getBasePrice();

		if (isMember) {
			return basePrice * 0.90;
		} else {
			return basePrice;
		}
	}

	// 8. Precio con código de cupón
	public double calculatePrice(Book book, String couponCode) {
		if (book == null) {
			throw new IllegalArgumentException("El libro no puede ser null");
		}

		double basePrice = book.getBasePrice();

		if (couponCode == null || couponCode.trim().isEmpty()) {
			return basePrice;
		}

		// Cupones simples
		switch (couponCode.toUpperCase()) {
		case "SAVE10":
			return basePrice * 0.90;
		case "SAVE20":
			return basePrice * 0.80;
		case "WELCOME":
			return basePrice * 0.85;
		default:
			System.out.println("Cupón no válido: " + couponCode);
			return basePrice;
		}
	}

	public String getMethodsInfo() {
		return "Métodos de cálculo de precios disponibles:\n" + "- calculatePrice(Book book)\n"
				+ "- calculatePrice(Book book, double discountPercentage)\n"
				+ "- calculatePrice(Book book, DiscountType discountType)\n"
				+ "- calculatePrice(Book book, int quantity)\n"
				+ "- calculatePrice(Book book, int quantity, double discountPercentage)\n"
				+ "- calculatePrice(Book[] books)\n" + "- calculatePrice(Book book, boolean isMember)\n"
				+ "- calculatePrice(Book book, String couponCode)";
	}

}
