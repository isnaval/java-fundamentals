package java_core.strings.basic;

public class PrintfFormatter {

	public static void main(String[] args) {
		System.out.println("=== GUÍA DE PRINTF EN JAVA ===\n");

		ejemplosBasicos();
		ejemplosNumericos();
		ejemplosConFormato();
		ejemplosDeTabla();
		ejercicioPractico();
	}

	public static void ejemplosBasicos() {
		System.out.println("1. EJEMPLOS BÁSICOS:");
		System.out.println("────────────────────\n");

		// Enteros
		int edad = 25;
		System.out.printf("Tengo %d años%n", edad);
		System.out.println("→ %d = entero decimal\n");

		// Strings
		String nombre = "Juan";
		System.out.printf("Me llamo %s%n", nombre);
		System.out.println("→ %s = string (texto)\n");

		// Decimales
		double precio = 19.99;
		System.out.printf("El precio es %.2f euros%n", precio);
		System.out.println("→ %.2f = float con 2 decimales\n");

		// Caracteres
		char inicial = 'J';
		System.out.printf("Mi inicial es %c%n", inicial);
		System.out.println("→ %c = un carácter\n");

		// Booleanos
		boolean esVerdad = true;
		System.out.printf("Es verdad: %b%n", esVerdad);
		System.out.println("→ %b = booleano\n");
	}

	public static void ejemplosNumericos() {
		System.out.println("\n2. FORMATOS NUMÉRICOS ESPECIALES:");
		System.out.println("─────────────────────────────────\n");

		double numero = 1234567.89;

		// Sin formato
		System.out.printf("Sin formato: %f%n", numero);

		// Con 2 decimales
		System.out.printf("Con 2 decimales: %.2f%n", numero);

		// Con separador de miles
		System.out.printf("Con separador de miles: %,.2f%n", numero);

		// Con ancho fijo
		System.out.printf("Ancho de 15 caracteres: [%15.2f]%n", numero);

		// Alineado a la izquierda
		System.out.printf("Alineado izquierda: [%-15.2f]%n", numero);

		// Con ceros a la izquierda
		System.out.printf("Con ceros: %015.2f%n", numero);

		// Con signo siempre
		System.out.printf("Con signo: %+.2f%n", numero);

		System.out.println();
	}

	public static void ejemplosConFormato() {
		System.out.println("\n3. COMBINANDO FORMATOS:");
		System.out.println("───────────────────────\n");

		String producto = "Laptop";
		double precio = 899.99;
		int cantidad = 3;
		double total = precio * cantidad;

		// Formato simple
		System.out.printf("Producto: %s, Precio: %.2f€%n", producto, precio);

		// Formato de factura
		System.out.printf("%-15s %10.2f€ x %2d = %,10.2f€%n", producto, precio, cantidad, total);

		System.out.println("\nExplicación del formato de factura:");
		System.out.println("%-15s = String alineado izquierda, 15 caracteres");
		System.out.println("%10.2f = Float alineado derecha, 10 caracteres, 2 decimales");
		System.out.println("%2d = Entero con ancho mínimo de 2");
		System.out.println("%,10.2f = Float con separador de miles\n");
	}

	public static void ejemplosDeTabla() {
		System.out.println("\n4. CREANDO TABLAS:");
		System.out.println("──────────────────\n");

		// Cabecera
		System.out.printf("%-10s %-20s %10s %10s%n", "ID", "Producto", "Precio", "Stock");
		System.out.println("─".repeat(54));

		// Datos
		System.out.printf("%-10d %-20s %,10.2f %10d%n", 1, "Mouse Gaming", 45.99, 150);
		System.out.printf("%-10d %-20s %,10.2f %10d%n", 2, "Teclado Mecánico", 129.99, 75);
		System.out.printf("%-10d %-20s %,10.2f %10d%n", 3, "Monitor 27\"", 299.99, 30);

		System.out.println("\nCaracteres especiales:");
		System.out.println("\\n = nueva línea");
		System.out.println("\\t = tabulador");
		System.out.println("%% = símbolo %");
		System.out.println("%n = nueva línea (mejor que \\n)");
	}

	public static void ejercicioPractico() {
		System.out.println("\n\n5. EJERCICIO PRÁCTICO - TICKET DE COMPRA:");
		System.out.println("─────────────────────────────────────────\n");

		String tienda = "SUPERMERCADO JAVA";
		String fecha = "25/12/2024";

		// Productos
		String[] productos = { "Leche", "Pan", "Huevos", "Queso" };
		double[] precios = { 1.20, 0.95, 2.50, 4.75 };
		int[] cantidades = { 2, 3, 1, 1 };

		// Encabezado
		System.out.printf("%n%35s%n", tienda);
		System.out.printf("%35s%n%n", fecha);

		// Línea de separación
		System.out.println("─".repeat(50));

		// Productos
		double subtotal = 0;
		for (int i = 0; i < productos.length; i++) {
			double totalLinea = precios[i] * cantidades[i];
			subtotal += totalLinea;

			System.out.printf("%-20s %2d x %6.2f€ = %8.2f€%n", productos[i], cantidades[i], precios[i], totalLinea);
		}

		// Totales
		System.out.println("─".repeat(50));
		double iva = subtotal * 0.21;
		double total = subtotal + iva;

		System.out.printf("%30s %8.2f€%n", "SUBTOTAL:", subtotal);
		System.out.printf("%30s %8.2f€%n", "IVA (21%):", iva);
		System.out.println("─".repeat(50));
		System.out.printf("%30s %8.2f€%n", "TOTAL:", total);

		System.out.println("\n\nRESUMEN DE ESPECIFICADORES:");
		System.out.println("───────────────────────────");
		System.out.println("%d    → entero");
		System.out.println("%f    → float/double");
		System.out.println("%s    → string");
		System.out.println("%c    → char");
		System.out.println("%b    → boolean");
		System.out.println("%.2f  → 2 decimales");
		System.out.println("%,f   → separador de miles");
		System.out.println("%10s  → ancho mínimo 10");
		System.out.println("%-10s → alineado izquierda");
		System.out.println("%n    → nueva línea");
	}
}