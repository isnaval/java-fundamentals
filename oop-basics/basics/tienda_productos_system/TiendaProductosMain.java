package java_oop.basics.tienda_productos_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java_oop.basics.tienda_productos_system.interfaces.Joya;
import java_oop.basics.tienda_productos_system.interfaces.Juguete;
import java_oop.basics.tienda_productos_system.interfaces.Producto;
import java_oop.basics.tienda_productos_system.productos.joyas.AnilloConDiamantes;
import java_oop.basics.tienda_productos_system.productos.joyas.CollarConPerlas;
import java_oop.basics.tienda_productos_system.productos.juguetes.JugeteElectronico;
import java_oop.basics.tienda_productos_system.productos.juguetes.JuguetePeluche;
import java_oop.basics.tienda_productos_system.productos.tecnologias.ProductoTecnologia;

/**
 * TiendaProductosMain - Sistema simple de tienda (versión corregida)
 */
public class TiendaProductosMain {
	private static Scanner scanner = new Scanner(System.in);
	private static List<Producto> productos = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println("🏪 ¡Bienvenido a la Tienda! 🏪");

		cargarProductos();
		mostrarMenu();
	}

	// Cargar productos iniciales
	private static void cargarProductos() {
		System.out.println("📦 Cargando productos...");

		// Joyas
		productos.add(new AnilloConDiamantes("Anillo Elegante", 3, 4, "Oro"));
		productos.add(new CollarConPerlas("Collar Clásico", 15, 3, 45));

		// Juguetes
		productos.add(new JugeteElectronico("Robot", 45.99, true, 6));
		productos.add(new JuguetePeluche("Oso Teddy", 25.00, true, "Algodón"));

		// Tecnología
		productos.add(new ProductoTecnologia("Smartphone", 299.99, 24, "Samsung"));

		System.out.println("✅ " + productos.size() + " productos cargados");
	}

	private static void mostrarMenu() {
		while (true) {
			System.out.println("\n=== MENÚ PRINCIPAL ===");
			System.out.println("1. Ver todos los productos");
			System.out.println("2. Ver solo joyas");
			System.out.println("3. Ver solo juguetes");
			System.out.println("4. Agregar producto");
			System.out.println("0. Salir");
			System.out.print("Opción: ");

			int opcion = getOpcion(0, 4);

			switch (opcion) {
			case 1:
				mostrarTodos();
				break;
			case 2:
				mostrarJoyas();
				break;
			case 3:
				mostrarJuguetes();
				break;
			case 4:
				agregarProducto();
				break;
			case 0:
				System.out.println("¡Adiós!");
				return;
			}

			pausa();
		}
	}

	private static void mostrarTodos() {
		System.out.println("\n📋 TODOS LOS PRODUCTOS:");
		for (int i = 0; i < productos.size(); i++) {
			Producto p = productos.get(i);
			System.out.println((i + 1) + ". " + p.obtenerInformacion());
			System.out.println("   💰 " + String.format("%.2f€", p.calcularPrecio()));
		}
	}

	private static void mostrarJoyas() {
		System.out.println("\n💎 SOLO JOYAS:");
		for (Producto p : productos) {
			if (p instanceof Joya) {
				System.out.println("• " + p.obtenerInformacion());
				System.out.println("  💰 " + String.format("%.2f€", p.calcularPrecio()));
			}
		}
	}

	private static void mostrarJuguetes() {
		System.out.println("\n🧸 SOLO JUGUETES:");
		for (Producto p : productos) {
			if (p instanceof Juguete) {
				System.out.println("• " + p.obtenerInformacion());
				System.out.println("  💰 " + String.format("%.2f€", p.calcularPrecio()));
			}
		}
	}

	private static void agregarProducto() {
		System.out.println("\n➕ AGREGAR PRODUCTO:");
		System.out.println("1. Anillo con diamantes");
		System.out.println("2. Juguete electrónico");
		System.out.print("Tipo: ");

		int tipo = getOpcion(1, 2);
		scanner.nextLine();

		if (tipo == 1) {
			System.out.print("Nombre: ");
			String nombre = scanner.nextLine();

			int diamantes = getNumeroEntero("Diamantes: ");
			int calidad = getNumeroEntero("Calidad (1-5): ");

			System.out.print("Material: ");
			String material = scanner.nextLine();

			productos.add(new AnilloConDiamantes(nombre, diamantes, calidad, material));
			System.out.println("✅ Anillo agregado");
		} else {
			System.out.print("Nombre: ");
			String nombre = scanner.nextLine();

			double precio = getNumeroDecimal("Precio: ");
			boolean pilas = getBooleano("¿Con pilas? (true/false): ");
			int edad = getNumeroEntero("Edad mínima: ");

			productos.add(new JugeteElectronico(nombre, precio, pilas, edad));
			System.out.println("✅ Juguete agregado");
		}
	}

	private static int getNumeroEntero(String mensaje) {
		while (true) {
			try {
				System.out.print(mensaje);
				int numero = scanner.nextInt();
				scanner.nextLine();
				return numero;
			} catch (Exception e) {
				scanner.nextLine();
				System.out.println("❌ Por favor, ingresa un número entero válido");
			}
		}
	}

	private static double getNumeroDecimal(String mensaje) {
		while (true) {
			try {
				System.out.print(mensaje);
				double numero = scanner.nextDouble();
				scanner.nextLine();
				return numero;
			} catch (Exception e) {
				scanner.nextLine();
				System.out.println("❌ Por favor, ingresa un número decimal válido (ej: 25.99)");
			}
		}
	}

	private static boolean getBooleano(String mensaje) {
		while (true) {
			try {
				System.out.print(mensaje);
				boolean valor = scanner.nextBoolean();
				scanner.nextLine();
				return valor;
			} catch (Exception e) {
				scanner.nextLine();
				System.out.println("❌ Por favor, ingresa 'true' o 'false'");
			}
		}
	}

	private static int getOpcion(int min, int max) {
		while (true) {
			try {
				int opcion = scanner.nextInt();
				if (opcion >= min && opcion <= max) {
					return opcion;
				}
				System.out.print("❌ Opción inválida (" + min + "-" + max + "): ");
			} catch (Exception e) {
				scanner.nextLine();
				System.out.print("❌ Entrada inválida: ");
			}
		}
	}

	private static void pausa() {
		System.out.print("\nPresiona ENTER para continuar...");
		scanner.nextLine();
		try {
			scanner.nextLine();
		} catch (Exception e) {
		}
	}
}