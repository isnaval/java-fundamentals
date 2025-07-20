package basic.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * StreamCollections - Operaciones avanzadas con colecciones usando Streams
 */
public class StreamCollections {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		showStreamCollectionsMenu();
	}

	public static void showStreamCollectionsMenu() {
		while (true) {
			System.out.println("\n" + "=".repeat(40));
			System.out.println("     STREAMS CON COLECCIONES");
			System.out.println("=".repeat(40));
			System.out.println("1. Operaciones entre listas");
			System.out.println("2. Agrupaciones y particiones");
			System.out.println("3. Collectors avanzados");
			System.out.println("4. FlatMap y estructuras anidadas");
			System.out.println("5. Operaciones de conjunto");
			System.out.println("0. Volver");
			System.out.println("=".repeat(40));
			System.out.print("Opcion: ");

			int option = getValidOption(0, 5);

			switch (option) {
			case 1:
				operacionesEntreListas();
				break;
			case 2:
				agrupacionesYParticiones();
				break;
			case 3:
				collectorsAvanzados();
				break;
			case 4:
				flatMapEstructuras();
				break;
			case 5:
				operacionesConjunto();
				break;
			case 0:
				return;
			}
			pauseAndContinue();
		}
	}

	private static void operacionesEntreListas() {
		System.out.println("\n--- OPERACIONES ENTRE LISTAS ---");

		List<Integer> lista1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		List<Integer> lista2 = Arrays.asList(4, 5, 6, 7, 8, 9, 10);

		System.out.println("Lista 1: " + lista1);
		System.out.println("Lista 2: " + lista2);

		// Union (elementos de ambas listas)
		List<Integer> union = Stream.concat(lista1.stream(), lista2.stream()).distinct().sorted()
				.collect(Collectors.toList());
		System.out.println("\n[UNION] Elementos de ambas listas: " + union);

		// Interseccion (elementos comunes)
		List<Integer> interseccion = lista1.stream().filter(lista2::contains).collect(Collectors.toList());
		System.out.println("[INTERSECCION] Elementos comunes: " + interseccion);

		// Diferencia (elementos que estan en lista1 pero no en lista2)
		List<Integer> diferencia = lista1.stream().filter(x -> !lista2.contains(x)).collect(Collectors.toList());
		System.out.println("[DIFERENCIA] Solo en lista1: " + diferencia);

		// Combinar y procesar
		System.out.println("\n--- COMBINACION Y PROCESAMIENTO ---");

		// Sumar elementos de la misma posicion
		List<Integer> sumaPosiciones = new ArrayList<>();
		int minSize = Math.min(lista1.size(), lista2.size());
		for (int i = 0; i < minSize; i++) {
			sumaPosiciones.add(lista1.get(i) + lista2.get(i));
		}
		System.out.println("Suma por posiciones: " + sumaPosiciones);

		// Crear pares ordenados
		List<String> pares = IntStream.range(0, minSize).mapToObj(i -> "(" + lista1.get(i) + "," + lista2.get(i) + ")")
				.collect(Collectors.toList());
		System.out.println("Pares ordenados: " + pares);

		// Producto cartesiano (limitado)
		List<String> producto = lista1.stream().limit(3) // Limitar para evitar muchos resultados
				.flatMap(x -> lista2.stream().limit(3).map(y -> x + "x" + y)).collect(Collectors.toList());
		System.out.println("Producto cartesiano (limitado): " + producto);
	}

	private static void agrupacionesYParticiones() {
		System.out.println("\n--- AGRUPACIONES Y PARTICIONES ---");

		List<String> palabras = Arrays.asList("casa", "auto", "gato", "perro", "elefante", "sol", "luna", "estrella",
				"planeta", "cometa");

		System.out.println("Palabras: " + palabras);

		// Agrupar por longitud
		Map<Integer, List<String>> porLongitud = palabras.stream().collect(Collectors.groupingBy(String::length));
		System.out.println("\n[AGRUPACION] Por longitud:");
		porLongitud.forEach((longitud, lista) -> System.out.println("  " + longitud + " letras: " + lista));

		// Agrupar por primera letra
		Map<Character, List<String>> porPrimeraLetra = palabras.stream()
				.collect(Collectors.groupingBy(palabra -> palabra.charAt(0)));
		System.out.println("\n[AGRUPACION] Por primera letra:");
		porPrimeraLetra.forEach((letra, lista) -> System.out.println("  '" + letra + "': " + lista));

		// Particion: palabras largas vs cortas
		Map<Boolean, List<String>> particion = palabras.stream()
				.collect(Collectors.partitioningBy(palabra -> palabra.length() > 4));
		System.out.println("\n[PARTICION] Largas vs Cortas:");
		System.out.println("  Largas (>4): " + particion.get(true));
		System.out.println("  Cortas (<=4): " + particion.get(false));

		// Contar elementos por grupo
		Map<Integer, Long> conteoLongitud = palabras.stream()
				.collect(Collectors.groupingBy(String::length, Collectors.counting()));
		System.out.println("\n[CONTEO] Cantidad por longitud:");
		conteoLongitud.forEach(
				(longitud, cantidad) -> System.out.println("  " + longitud + " letras: " + cantidad + " palabras"));

		// Agrupar y transformar
		Map<Integer, String> unirPorLongitud = palabras.stream()
				.collect(Collectors.groupingBy(String::length, Collectors.joining(", ")));
		System.out.println("\n[TRANSFORMACION] Unidas por longitud:");
		unirPorLongitud.forEach((longitud, unidas) -> System.out.println("  " + longitud + ": " + unidas));
	}

	private static void collectorsAvanzados() {
		System.out.println("\n--- COLLECTORS AVANZADOS ---");

		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 20);
		System.out.println("Numeros: " + numeros);

		// Estadisticas resumidas
		IntSummaryStatistics stats = numeros.stream().mapToInt(Integer::intValue).summaryStatistics();
		System.out.println("\n[ESTADISTICAS]:");
		System.out.println("  Minimo: " + stats.getMin());
		System.out.println("  Maximo: " + stats.getMax());
		System.out.println("  Promedio: " + String.format("%.2f", stats.getAverage()));
		System.out.println("  Suma: " + stats.getSum());
		System.out.println("  Cantidad: " + stats.getCount());

		// Joining con diferentes separadores
		List<String> palabras = Arrays.asList("Java", "Stream", "API", "Collectors");
		String unidas = palabras.stream().collect(Collectors.joining());
		String conEspacios = palabras.stream().collect(Collectors.joining(" "));
		String conSeparador = palabras.stream().collect(Collectors.joining(" | "));
		String conPrefijo = palabras.stream().collect(Collectors.joining(", ", "[", "]"));

		System.out.println("\n[JOINING]:");
		System.out.println("  Sin separador: " + unidas);
		System.out.println("  Con espacios: " + conEspacios);
		System.out.println("  Con separador: " + conSeparador);
		System.out.println("  Con prefijo/sufijo: " + conPrefijo);

		// Colectar en diferentes tipos
		Set<Integer> conjunto = numeros.stream().filter(n -> n % 2 == 0).collect(Collectors.toSet());
		System.out.println("\n[TIPOS] Conjunto de pares: " + conjunto);

		TreeSet<Integer> conjuntoOrdenado = numeros.stream().collect(Collectors.toCollection(TreeSet::new));
		System.out.println("[TIPOS] TreeSet ordenado: " + conjuntoOrdenado);

		// Mapas personalizados
		Map<Integer, String> mapaPersonalizado = numeros.stream()
				.collect(Collectors.toMap(n -> n, n -> n % 2 == 0 ? "par" : "impar"));
		System.out.println("\n[MAPA] Numero -> tipo:");
		mapaPersonalizado.entrySet().stream().limit(5)
				.forEach(entry -> System.out.println("  " + entry.getKey() + " -> " + entry.getValue()));
	}

	private static void flatMapEstructuras() {
		System.out.println("\n--- FLATMAP Y ESTRUCTURAS ANIDADAS ---");

		// Lista de listas
		List<List<Integer>> listaAnidada = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6),
				Arrays.asList(7, 8, 9), Arrays.asList(10, 11, 12));

		System.out.println("Lista anidada: " + listaAnidada);

		// Aplanar con flatMap
		List<Integer> aplanada = listaAnidada.stream().flatMap(List::stream).collect(Collectors.toList());
		System.out.println("\n[FLATMAP] Lista aplanada: " + aplanada);

		// Procesar elementos anidados
		List<Integer> paresAplanados = listaAnidada.stream().flatMap(List::stream).filter(n -> n % 2 == 0)
				.collect(Collectors.toList());
		System.out.println("[FLATMAP] Solo pares: " + paresAplanados);

		// Suma total de elementos anidados
		int sumaTotal = listaAnidada.stream().flatMap(List::stream).mapToInt(Integer::intValue).sum();
		System.out.println("[FLATMAP] Suma total: " + sumaTotal);

		// Trabajar con strings anidados
		List<String> frases = Arrays.asList("Java es genial", "Stream API funcional", "Programacion moderna");

		System.out.println("\nFrases: " + frases);

		// Extraer todas las palabras
		List<String> todasPalabras = frases.stream().flatMap(frase -> Arrays.stream(frase.split(" ")))
				.collect(Collectors.toList());
		System.out.println("[FLATMAP] Todas las palabras: " + todasPalabras);

		// Palabras unicas en mayusculas
		List<String> palabrasUnicas = frases.stream().flatMap(frase -> Arrays.stream(frase.split(" ")))
				.map(String::toUpperCase).distinct().sorted().collect(Collectors.toList());
		System.out.println("[FLATMAP] Palabras unicas: " + palabrasUnicas);

		// Contar caracteres totales
		long totalCaracteres = frases.stream().flatMap(frase -> frase.chars().boxed()).filter(ch -> ch != ' ').count();
		System.out.println("[FLATMAP] Total caracteres (sin espacios): " + totalCaracteres);
	}

	private static void operacionesConjunto() {
		System.out.println("\n--- OPERACIONES DE CONJUNTO ---");

		List<String> programadores = Arrays.asList("Ana", "Carlos", "Elena", "David", "Sofia");
		List<String> disenadores = Arrays.asList("Elena", "Miguel", "Sofia", "Laura", "Pedro");
		List<String> testers = Arrays.asList("Carlos", "Laura", "Juan", "Sofia", "Maria");

		System.out.println("Programadores: " + programadores);
		System.out.println("Disenadores: " + disenadores);
		System.out.println("Testers: " + testers);

		// Personas en todos los equipos
		Set<String> todosLosEquipos = Stream.of(programadores, disenadores, testers).flatMap(List::stream)
				.collect(Collectors.toSet());
		System.out.println("\n[UNION] Todas las personas: " + todosLosEquipos);

		// Personas que programan Y disenan
		Set<String> progYDise = programadores.stream().filter(disenadores::contains).collect(Collectors.toSet());
		System.out.println("[INTERSECCION] Programan Y disenan: " + progYDise);

		// Personas que estan en al menos 2 equipos
		List<String> todasPersonas = Stream.of(programadores, disenadores, testers).flatMap(List::stream)
				.collect(Collectors.toList());

		Map<String, Long> frecuencia = todasPersonas.stream()
				.collect(Collectors.groupingBy(persona -> persona, Collectors.counting()));

		Set<String> enVariosEquipos = frecuencia.entrySet().stream().filter(entry -> entry.getValue() >= 2)
				.map(Map.Entry::getKey).collect(Collectors.toSet());

		System.out.println("[MULTI-EQUIPO] En 2+ equipos: " + enVariosEquipos);

		// Solo programadores (que no disenan ni testean)
		Set<String> soloProgramadores = programadores.stream().filter(p -> !disenadores.contains(p))
				.filter(p -> !testers.contains(p)).collect(Collectors.toSet());
		System.out.println("[DIFERENCIA] Solo programadores: " + soloProgramadores);

		// Analisis completo
		System.out.println("\n[ANALISIS COMPLETO]:");
		System.out.println("  Total personas distintas: " + todosLosEquipos.size());
		System.out.println("  Programadores exclusivos: " + soloProgramadores.size());
		System.out.println("  En multiples equipos: " + enVariosEquipos.size());

		// Top personas por equipos
		String topPersona = frecuencia.entrySet().stream().max(Map.Entry.comparingByValue())
				.map(entry -> entry.getKey() + " (" + entry.getValue() + " equipos)").orElse("Ninguna");
		System.out.println("  Persona en mas equipos: " + topPersona);
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

	private static void pauseAndContinue() {
		System.out.print("\nPresiona Enter para continuar...");
		scanner.nextLine();
	}
}