package java_core.method_overloading.book_pricing;

public class Main {
	public static void main(String[] args) {
		BookPricing pricing = new BookPricing();

		System.out.println("=== DEMOSTRACIÓN DE SOBRECARGA DE MÉTODOS - BOOK PRICING ===\n");
		System.out.println("Clase: BookPricing");
		System.out.println("Concepto: Method Overloading (Sobrecarga de Métodos)\n");

		// Crear libros de ejemplo
		Book libro1 = new Book("El Quijote", "Cervantes", 25.99, "Clásico");
		Book libro2 = new Book("Cien Años de Soledad", "García Márquez", 18.50, "Literatura");
		Book libro3 = new Book("Java Programming", "Oracle", 45.00, "Técnico");

		System.out.println("📚 LIBROS DE EJEMPLO:");
		System.out.println("1. " + libro1);
		System.out.println("2. " + libro2);
		System.out.println("3. " + libro3);
		System.out.println();

		// Demostrar cada método sobrecargado
		System.out.println("1. PRECIO BÁSICO:");
		double precio1 = pricing.calculatePrice(libro1);
		System.out.printf("   calculatePrice(libro1) = €%.2f%n%n", precio1);

		System.out.println("2. PRECIO CON DESCUENTO PORCENTUAL:");
		double precio2 = pricing.calculatePrice(libro1, 15.0);
		System.out.printf("   calculatePrice(libro1, 15.0) = €%.2f%n%n", precio2);

		System.out.println("3. PRECIO CON TIPO DE DESCUENTO:");
		double precio3 = pricing.calculatePrice(libro1, DiscountType.STUDENT);
		System.out.printf("   calculatePrice(libro1, STUDENT) = €%.2f%n%n", precio3);

		System.out.println("4. PRECIO POR CANTIDAD:");
		double precio4 = pricing.calculatePrice(libro2, 6);
		System.out.printf("   calculatePrice(libro2, 6 unidades) = €%.2f%n%n", precio4);

		System.out.println("5. PRECIO CON CANTIDAD Y DESCUENTO:");
		double precio5 = pricing.calculatePrice(libro2, 6, 5.0);
		System.out.printf("   calculatePrice(libro2, 6, 5%%) = €%.2f%n%n", precio5);

		System.out.println("6. PRECIO PARA ARRAY DE LIBROS:");
		Book[] libros = { libro1, libro2, libro3 };
		double precio6 = pricing.calculatePrice(libros);
		System.out.printf("   calculatePrice([3 libros]) = €%.2f%n%n", precio6);

		System.out.println("7. PRECIO CON MEMBRESÍA:");
		double precio7 = pricing.calculatePrice(libro3, true);
		System.out.printf("   calculatePrice(libro3, isMember=true) = €%.2f%n%n", precio7);

		System.out.println("8. PRECIO CON CUPÓN:");
		double precio8 = pricing.calculatePrice(libro3, "SAVE20");
		System.out.printf("   calculatePrice(libro3, \"SAVE20\") = €%.2f%n%n", precio8);

		System.out.println("9. INFORMACIÓN DE MÉTODOS:");
		System.out.println(pricing.getMethodsInfo());

		System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
	}

}
