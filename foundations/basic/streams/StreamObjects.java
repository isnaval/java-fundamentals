package basic.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * StreamObjects - Trabajando con objetos personalizados usando Streams
 */
public class StreamObjects {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		showStreamObjectsMenu();
	}

	public static void showStreamObjectsMenu() {
		while (true) {
			System.out.println("\n" + "=".repeat(40));
			System.out.println("       STREAMS CON OBJETOS");
			System.out.println("=".repeat(40));
			System.out.println("1. Trabajar con Personas");
			System.out.println("2. Trabajar con Productos");
			System.out.println("3. Trabajar con Estudiantes");
			System.out.println("4. Operaciones avanzadas");
			System.out.println("5. Crear tus propios objetos");
			System.out.println("0. Volver");
			System.out.println("=".repeat(40));
			System.out.print("Opcion: ");

			int option = getValidOption(0, 5);

			switch (option) {
			case 1:
				trabajarConPersonas();
				break;
			case 2:
				trabajarConProductos();
				break;
			case 3:
				trabajarConEstudiantes();
				break;
			case 4:
				operacionesAvanzadas();
				break;
			case 5:
				crearPropiosObjetos();
				break;
			case 0:
				return;
			}
			pauseAndContinue();
		}
	}

	// Clases internas para los ejemplos
	static class Persona {
		private String nombre;
		private int edad;
		private String ciudad;

		public Persona(String nombre, int edad, String ciudad) {
			this.nombre = nombre;
			this.edad = edad;
			this.ciudad = ciudad;
		}

		public String getNombre() {
			return nombre;
		}

		public int getEdad() {
			return edad;
		}

		public String getCiudad() {
			return ciudad;
		}

		@Override
		public String toString() {
			return nombre + " (" + edad + " años, " + ciudad + ")";
		}
	}

	static class Producto {
		private String nombre;
		private double precio;
		private String categoria;
		private int stock;

		public Producto(String nombre, double precio, String categoria, int stock) {
			this.nombre = nombre;
			this.precio = precio;
			this.categoria = categoria;
			this.stock = stock;
		}

		public String getNombre() {
			return nombre;
		}

		public double getPrecio() {
			return precio;
		}

		public String getCategoria() {
			return categoria;
		}

		public int getStock() {
			return stock;
		}

		@Override
		public String toString() {
			return nombre + " ($" + precio + ", " + categoria + ", stock: " + stock + ")";
		}
	}

	static class Estudiante {
		private String nombre;
		private double nota;
		private String materia;

		public Estudiante(String nombre, double nota, String materia) {
			this.nombre = nombre;
			this.nota = nota;
			this.materia = materia;
		}

		public String getNombre() {
			return nombre;
		}

		public double getNota() {
			return nota;
		}

		public String getMateria() {
			return materia;
		}

		@Override
		public String toString() {
			return nombre + " (nota: " + nota + ", " + materia + ")";
		}
	}

	private static void trabajarConPersonas() {
		System.out.println("\n--- TRABAJAR CON PERSONAS ---");

		List<Persona> personas = Arrays.asList(new Persona("Ana", 25, "Madrid"), new Persona("Carlos", 30, "Barcelona"),
				new Persona("Elena", 22, "Madrid"), new Persona("David", 35, "Valencia"),
				new Persona("Sofia", 28, "Barcelona"), new Persona("Miguel", 40, "Madrid"));

		System.out.println("Lista de personas:");
		personas.forEach(System.out::println);

		// Filtrar por edad
		System.out.println("\n[FILTRO] Personas mayores de 25:");
		personas.stream().filter(p -> p.getEdad() > 25).forEach(System.out::println);

		// Filtrar por ciudad
		System.out.println("\n[FILTRO] Personas de Madrid:");
		personas.stream().filter(p -> p.getCiudad().equals("Madrid")).forEach(System.out::println);

		// Obtener solo nombres
		System.out.println("\n[MAP] Solo nombres:");
		List<String> nombres = personas.stream().map(Persona::getNombre).collect(Collectors.toList());
		System.out.println(nombres);

		// Edad promedio
		double edadPromedio = personas.stream().mapToInt(Persona::getEdad).average().orElse(0.0);
		System.out.println("\n[ESTADISTICA] Edad promedio: " + String.format("%.1f", edadPromedio));

		// Persona mayor
		Optional<Persona> mayor = personas.stream().max(Comparator.comparing(Persona::getEdad));
		System.out.println("[ESTADISTICA] Persona mayor: " + mayor.orElse(null));

		// Agrupar por ciudad
		Map<String, List<Persona>> porCiudad = personas.stream().collect(Collectors.groupingBy(Persona::getCiudad));
		System.out.println("\n[AGRUPACION] Por ciudad:");
		porCiudad.forEach((ciudad, lista) -> System.out.println("  " + ciudad + ": " + lista.size() + " personas"));
	}

	private static void trabajarConProductos() {
		System.out.println("\n--- TRABAJAR CON PRODUCTOS ---");

		List<Producto> productos = Arrays.asList(new Producto("Laptop", 999.99, "Electronica", 10),
				new Producto("Mouse", 25.50, "Electronica", 50), new Producto("Libro Java", 45.00, "Libros", 20),
				new Producto("Telefono", 699.99, "Electronica", 5), new Producto("Silla", 150.00, "Muebles", 8),
				new Producto("Mesa", 300.00, "Muebles", 3));

		System.out.println("Inventario de productos:");
		productos.forEach(System.out::println);

		// Productos caros
		System.out.println("\n[FILTRO] Productos mayores a $100:");
		productos.stream().filter(p -> p.getPrecio() > 100).forEach(System.out::println);

		// Productos de electronica
		System.out.println("\n[FILTRO] Categoria Electronica:");
		productos.stream().filter(p -> p.getCategoria().equals("Electronica")).forEach(System.out::println);

		// Productos con poco stock
		System.out.println("\n[FILTRO] Stock menor a 10:");
		productos.stream().filter(p -> p.getStock() < 10).forEach(System.out::println);

		// Valor total del inventario
		double valorTotal = productos.stream().mapToDouble(p -> p.getPrecio() * p.getStock()).sum();
		System.out.println("\n[CALCULO] Valor total inventario: $" + String.format("%.2f", valorTotal));

		// Producto más caro
		Optional<Producto> masCaro = productos.stream().max(Comparator.comparing(Producto::getPrecio));
		System.out.println("[ESTADISTICA] Producto más caro: " + masCaro.orElse(null));

		// Agrupar por categoria
		Map<String, List<Producto>> porCategoria = productos.stream()
				.collect(Collectors.groupingBy(Producto::getCategoria));
		System.out.println("\n[AGRUPACION] Por categoria:");
		porCategoria.forEach((cat, lista) -> System.out.println("  " + cat + ": " + lista.size() + " productos"));
	}

	private static void trabajarConEstudiantes() {
		System.out.println("\n--- TRABAJAR CON ESTUDIANTES ---");

		List<Estudiante> estudiantes = Arrays.asList(new Estudiante("Pedro", 8.5, "Matematicas"),
				new Estudiante("Laura", 9.2, "Fisica"), new Estudiante("Juan", 7.8, "Matematicas"),
				new Estudiante("Maria", 9.5, "Quimica"), new Estudiante("Jose", 6.5, "Fisica"),
				new Estudiante("Carmen", 8.9, "Quimica"));

		System.out.println("Lista de estudiantes:");
		estudiantes.forEach(System.out::println);

		// Estudiantes aprobados
		System.out.println("\n[FILTRO] Estudiantes aprobados (nota >= 7):");
		estudiantes.stream().filter(e -> e.getNota() >= 7.0).forEach(System.out::println);

		// Nota promedio general
		double notaPromedio = estudiantes.stream().mapToDouble(Estudiante::getNota).average().orElse(0.0);
		System.out.println("\n[ESTADISTICA] Nota promedio: " + String.format("%.2f", notaPromedio));

		// Mejor estudiante
		Optional<Estudiante> mejor = estudiantes.stream().max(Comparator.comparing(Estudiante::getNota));
		System.out.println("[ESTADISTICA] Mejor estudiante: " + mejor.orElse(null));

		// Promedio por materia
		Map<String, Double> promedioPorMateria = estudiantes.stream().collect(
				Collectors.groupingBy(Estudiante::getMateria, Collectors.averagingDouble(Estudiante::getNota)));
		System.out.println("\n[ANALISIS] Promedio por materia:");
		promedioPorMateria.forEach(
				(materia, promedio) -> System.out.println("  " + materia + ": " + String.format("%.2f", promedio)));

		// Contar aprobados por materia
		Map<String, Long> aprobadosPorMateria = estudiantes.stream().filter(e -> e.getNota() >= 7.0)
				.collect(Collectors.groupingBy(Estudiante::getMateria, Collectors.counting()));
		System.out.println("\n[ANALISIS] Aprobados por materia:");
		aprobadosPorMateria
				.forEach((materia, cantidad) -> System.out.println("  " + materia + ": " + cantidad + " estudiantes"));
	}

	private static void operacionesAvanzadas() {
		System.out.println("\n--- OPERACIONES AVANZADAS ---");

		List<Persona> personas = Arrays.asList(new Persona("Ana", 25, "Madrid"), new Persona("Carlos", 30, "Barcelona"),
				new Persona("Elena", 22, "Madrid"), new Persona("David", 35, "Valencia"));

		// Operacion compleja: Obtener nombres de personas mayores de 23 en mayusculas,
		// ordenados
		List<String> resultado = personas.stream().filter(p -> p.getEdad() > 23).map(Persona::getNombre)
				.map(String::toUpperCase).sorted().collect(Collectors.toList());

		System.out.println("Nombres en mayusculas, mayores de 23, ordenados:");
		System.out.println(resultado);

		// Particion: Dividir en menores y mayores de 30
		Map<Boolean, List<Persona>> particion = personas.stream()
				.collect(Collectors.partitioningBy(p -> p.getEdad() >= 30));

		System.out.println("\n[PARTICION] Mayores de 30:");
		particion.get(true).forEach(System.out::println);
		System.out.println("[PARTICION] Menores de 30:");
		particion.get(false).forEach(System.out::println);

		// Estadisticas de edad
		IntSummaryStatistics stats = personas.stream().mapToInt(Persona::getEdad).summaryStatistics();

		System.out.println("\n[ESTADISTICAS COMPLETAS]:");
		System.out.println("  Minima: " + stats.getMin());
		System.out.println("  Maxima: " + stats.getMax());
		System.out.println("  Promedio: " + String.format("%.1f", stats.getAverage()));
		System.out.println("  Total: " + stats.getCount());
		System.out.println("  Suma: " + stats.getSum());
	}

	private static void crearPropiosObjetos() {
		System.out.println("\n--- CREAR TUS PROPIOS OBJETOS ---");

		List<Persona> misPersonas = new ArrayList<>();

		System.out.print("¿Cuantas personas quieres crear? (1-5): ");
		int cantidad = getValidOption(1, 5);

		for (int i = 1; i <= cantidad; i++) {
			System.out.println("\nPersona " + i + ":");
			System.out.print("  Nombre: ");
			String nombre = scanner.nextLine();
			System.out.print("  Edad: ");
			int edad = readNumber();
			System.out.print("  Ciudad: ");
			String ciudad = scanner.nextLine();

			misPersonas.add(new Persona(nombre, edad, ciudad));
		}

		System.out.println("\nTus personas creadas:");
		misPersonas.forEach(System.out::println);

		// Menu de operaciones
		while (true) {
			System.out.println("\n¿Que quieres hacer?");
			System.out.println("1. Filtrar por edad minima");
			System.out.println("2. Filtrar por ciudad");
			System.out.println("3. Ver estadisticas");
			System.out.println("4. Ordenar por edad");
			System.out.println("0. Salir");

			int op = getValidOption(0, 4);
			if (op == 0)
				break;

			switch (op) {
			case 1:
				System.out.print("Edad minima: ");
				int edadMin = readNumber();
				System.out.println("Resultado:");
				misPersonas.stream().filter(p -> p.getEdad() >= edadMin).forEach(System.out::println);
				break;

			case 2:
				System.out.print("Ciudad: ");
				String ciudad = scanner.nextLine();
				System.out.println("Resultado:");
				misPersonas.stream().filter(p -> p.getCiudad().equalsIgnoreCase(ciudad)).forEach(System.out::println);
				break;

			case 3:
				double promedio = misPersonas.stream().mapToInt(Persona::getEdad).average().orElse(0.0);
				Optional<Persona> mayor = misPersonas.stream().max(Comparator.comparing(Persona::getEdad));
				System.out.println("Edad promedio: " + String.format("%.1f", promedio));
				System.out.println("Persona mayor: " + mayor.orElse(null));
				break;

			case 4:
				System.out.println("Ordenadas por edad:");
				misPersonas.stream().sorted(Comparator.comparing(Persona::getEdad)).forEach(System.out::println);
				break;
			}
		}
	}

	// Metodos auxiliares
	private static int getValidOption(int min, int max) {
		while (true) {
			try {
				int option = scanner.nextInt();
				scanner.nextLine();
				if (option >= min && option <= max) {
					return option;
				}
				System.out.print("Opcion invalida (" + min + "-" + max + "): ");
			} catch (Exception e) {
				scanner.nextLine();
				System.out.print("Entrada invalida: ");
			}
		}
	}

	private static int readNumber() {
		int num = scanner.nextInt();
		scanner.nextLine();
		return num;
	}

	private static void pauseAndContinue() {
		System.out.print("\nPresiona Enter para continuar...");
		scanner.nextLine();
	}
}