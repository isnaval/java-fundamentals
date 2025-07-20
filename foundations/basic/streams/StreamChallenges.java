package basic.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamChallenges {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		showStreamChallengesMenu();
	}

	public static void showStreamChallengesMenu() {
		while (true) {
			System.out.println("\n" + "=".repeat(40));
			System.out.println("      DESAFIOS CON STREAMS");
			System.out.println("=".repeat(40));
			System.out.println("1. Desafios basicos");
			System.out.println("2. Desafios intermedios");
			System.out.println("3. Desafios avanzados");
			System.out.println("4. Ejercicios del mundo real");
			System.out.println("5. Quiz interactivo");
			System.out.println("0. Volver");
			System.out.println("=".repeat(40));
			System.out.print("Opcion: ");

			int option = getValidOption(0, 5);

			switch (option) {
			case 1:
				desafiosBasicos();
				break;
			case 2:
				desafiosIntermedios();
				break;
			case 3:
				desafiosAvanzados();
				break;
			case 4:
				ejerciciosMundoReal();
				break;
			case 5:
				quizInteractivo();
				break;
			case 0:
				return;
			}
			pauseAndContinue();
		}
	}

	private static void desafiosBasicos() {
		System.out.println("\n--- DESAFIOS BASICOS ---");

		System.out.println("\nDESAFIO 1: Numeros primos menores que 50");
		List<Integer> primos = IntStream.range(2, 50).filter(StreamChallenges::isPrime).boxed()
				.collect(Collectors.toList());
		System.out.println("Solucion: " + primos);

		System.out.println("\nDESAFIO 2: Palabras que empiezan y terminan con la misma letra");
		List<String> palabras = Arrays.asList("ana", "radar", "casa", "level", "java", "oro", "python");
		List<String> mismaLetra = palabras.stream()
				.filter(palabra -> palabra.charAt(0) == palabra.charAt(palabra.length() - 1))
				.collect(Collectors.toList());
		System.out.println("Palabras: " + palabras);
		System.out.println("Solucion: " + mismaLetra);

		System.out.println("\nDESAFIO 3: Suma de cuadrados de numeros impares");
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		int suma = numeros.stream().filter(n -> n % 2 != 0).mapToInt(n -> n * n).sum();
		System.out.println("Numeros: " + numeros);
		System.out.println("Suma de cuadrados de impares: " + suma);

		System.out.println("\nDESAFIO 4: Segunda palabra mas larga");
		List<String> texto = Arrays.asList("java", "stream", "api", "programacion", "funcional", "codigo");
		Optional<String> segundaMasLarga = texto.stream().sorted(Comparator.comparing(String::length).reversed())
				.skip(1).findFirst();
		System.out.println("Palabras: " + texto);
		System.out.println("Segunda mas larga: " + segundaMasLarga.orElse("No encontrada"));

		System.out.println("\nDESAFIO 5: Numeros que aparecen mas de una vez");
		List<Integer> conDuplicados = Arrays.asList(1, 2, 3, 2, 4, 5, 3, 6, 1, 7);
		Set<Integer> duplicados = conDuplicados.stream().filter(n -> Collections.frequency(conDuplicados, n) > 1)
				.collect(Collectors.toSet());
		System.out.println("Lista: " + conDuplicados);
		System.out.println("Duplicados: " + duplicados);
	}

	private static void desafiosIntermedios() {
		System.out.println("\n--- DESAFIOS INTERMEDIOS ---");

		System.out.println("\nDESAFIO 1: Agrupar numeros por cantidad de digitos");
		List<Integer> numeros = Arrays.asList(1, 12, 123, 45, 6789, 0, 999, 10000);
		Map<Integer, List<Integer>> porDigitos = numeros.stream()
				.collect(Collectors.groupingBy(n -> String.valueOf(n).length()));
		System.out.println("Numeros: " + numeros);
		System.out.println("Agrupados por digitos:");
		porDigitos.forEach((digitos, lista) -> System.out.println("  " + digitos + " digitos: " + lista));

		System.out.println("\nDESAFIO 2: Encontrar anagramas");
		List<String> palabras = Arrays.asList("listen", "silent", "elbow", "below", "study", "dusty");
		Map<String, List<String>> anagramas = palabras.stream().collect(Collectors.groupingBy(palabra -> {
			char[] chars = palabra.toCharArray();
			Arrays.sort(chars);
			return new String(chars);
		}));

		System.out.println("Palabras: " + palabras);
		System.out.println("Grupos de anagramas:");
		anagramas.entrySet().stream().filter(entry -> entry.getValue().size() > 1)
				.forEach(entry -> System.out.println("  " + entry.getValue()));

		System.out.println("\nDESAFIO 3: Top 3 caracteres mas frecuentes");
		String texto = "programming with java streams is very powerful";
		Map<Character, Long> frecuenciaChars = texto.chars().filter(c -> c != ' ').mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));

		List<Map.Entry<Character, Long>> top3 = frecuenciaChars.entrySet().stream()
				.sorted(Map.Entry.<Character, Long>comparingByValue().reversed()).limit(3).collect(Collectors.toList());

		System.out.println("Texto: \"" + texto + "\"");
		System.out.println("Top 3 caracteres:");
		top3.forEach(entry -> System.out.println("  '" + entry.getKey() + "': " + entry.getValue() + " veces"));

		System.out.println("\nDESAFIO 4: Generar secuencia de Fibonacci con Streams");
		List<Integer> fibonacci = Stream.iterate(new int[] { 0, 1 }, f -> new int[] { f[1], f[0] + f[1] }).limit(10)
				.map(f -> f[0]).collect(Collectors.toList());
		System.out.println("Primeros 10 Fibonacci: " + fibonacci);

		System.out.println("\nDESAFIO 5: Palabra con mayor diversidad de caracteres");
		List<String> textos = Arrays.asList("java", "programming", "stream", "functional", "code");
		Optional<String> mayorDiversidad = textos.stream()
				.max(Comparator.comparing(palabra -> palabra.chars().boxed().collect(Collectors.toSet()).size()));
		System.out.println("Palabras: " + textos);
		System.out.println("Mayor diversidad: " + mayorDiversidad.orElse("Ninguna"));
	}

	private static void desafiosAvanzados() {
		System.out.println("\n--- DESAFIOS AVANZADOS ---");

		System.out.println("\nDESAFIO 1: Cadena de transformaciones");
		List<Integer> resultado = IntStream.range(1, 21).filter(n -> n % 2 == 0).map(n -> n * 3).filter(n -> n > 20)
				.map(n -> n - 5).sorted().boxed().collect(Collectors.toList());
		System.out.println("Proceso: 1-20 -> pares -> *3 -> >20 -> -5 -> ordenar");
		System.out.println("Resultado: " + resultado);

		System.out.println("\nDESAFIO 2: Analisis de texto complejo");
		String textoComplejo = "Java 8 Stream API makes functional programming easier and more readable";

		// Estadisticas por tipo de caracter
		Map<String, Long> tiposChar = textoComplejo.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> {
			if (Character.isLetter(c))
				return "Letras";
			if (Character.isDigit(c))
				return "Digitos";
			if (Character.isWhitespace(c))
				return "Espacios";
			return "Simbolos";
		}, Collectors.counting()));

		System.out.println("Texto: \"" + textoComplejo + "\"");
		System.out.println("Analisis por tipo:");
		tiposChar.forEach((tipo, cantidad) -> System.out.println("  " + tipo + ": " + cantidad));

		// Palabras ordenadas por longitud y alfabeticamente
		List<String> palabrasOrdenadas = Arrays.stream(textoComplejo.split("\\s+"))
				.map(p -> p.replaceAll("[^a-zA-Z]", "")).filter(p -> !p.isEmpty())
				.sorted(Comparator.comparing(String::length).thenComparing(String::toString))
				.collect(Collectors.toList());
		System.out.println("Palabras ordenadas: " + palabrasOrdenadas);

		System.out.println("\nDESAFIO 3: Operaciones matriciales");
		List<List<Integer>> matriz = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6),
				Arrays.asList(7, 8, 9));

		// Suma de diagonales
		int sumaDiagPrincipal = IntStream.range(0, matriz.size()).map(i -> matriz.get(i).get(i)).sum();

		int sumaDiagSecundaria = IntStream.range(0, matriz.size()).map(i -> matriz.get(i).get(matriz.size() - 1 - i))
				.sum();

		System.out.println("Matriz: " + matriz);
		System.out.println("Diagonal principal: " + sumaDiagPrincipal);
		System.out.println("Diagonal secundaria: " + sumaDiagSecundaria);

		// Transpuesta
		List<List<Integer>> transpuesta = IntStream.range(0, matriz.get(0).size()).mapToObj(
				j -> IntStream.range(0, matriz.size()).mapToObj(i -> matriz.get(i).get(j)).collect(Collectors.toList()))
				.collect(Collectors.toList());
		System.out.println("Transpuesta: " + transpuesta);
	}

	private static void ejerciciosMundoReal() {
		System.out.println("\n--- EJERCICIOS DEL MUNDO REAL ---");

		// Simulacion de datos de ventas
		List<Venta> ventas = Arrays.asList(new Venta("Laptop", 1200.00, "Electronica", "Enero"),
				new Venta("Mouse", 25.50, "Electronica", "Enero"), new Venta("Libro", 45.00, "Libros", "Febrero"),
				new Venta("Telefono", 800.00, "Electronica", "Febrero"), new Venta("Silla", 150.00, "Muebles", "Marzo"),
				new Venta("Tablet", 400.00, "Electronica", "Marzo"));

		System.out.println("EJERCICIO 1: Analisis de ventas");

		// Ventas totales por categoria
		Map<String, Double> ventasPorCategoria = ventas.stream()
				.collect(Collectors.groupingBy(Venta::getCategoria, Collectors.summingDouble(Venta::getPrecio)));

		System.out.println("Ventas por categoria:");
		ventasPorCategoria
				.forEach((cat, total) -> System.out.println("  " + cat + ": $" + String.format("%.2f", total)));

		// Producto mas caro por mes
		Map<String, Optional<Venta>> masCaro = ventas.stream().collect(
				Collectors.groupingBy(Venta::getMes, Collectors.maxBy(Comparator.comparing(Venta::getPrecio))));

		System.out.println("\nProducto mas caro por mes:");
		masCaro.forEach(
				(mes, venta) -> System.out.println("  " + mes + ": " + venta.map(Venta::getProducto).orElse("N/A")));

		// Categoria con mayor volumen de ventas
		String categoriaTop = ventasPorCategoria.entrySet().stream().max(Map.Entry.comparingByValue())
				.map(Map.Entry::getKey).orElse("Ninguna");

		System.out.println("\nCategoria con mayores ventas: " + categoriaTop);

		System.out.println("\nEJERCICIO 2: Procesamiento de logs");
		List<String> logs = Arrays.asList("2023-01-01 10:30:25 ERROR Usuario no encontrado",
				"2023-01-01 10:31:12 INFO Sesion iniciada", "2023-01-01 10:32:45 WARN Memoria baja",
				"2023-01-01 10:33:15 ERROR Conexion perdida", "2023-01-01 10:34:20 INFO Datos guardados");

		// Contar por tipo de log
		Map<String, Long> tiposLog = logs.stream().map(log -> log.split(" ")[2])
				.collect(Collectors.groupingBy(tipo -> tipo, Collectors.counting()));

		System.out.println("Conteo de logs por tipo:");
		tiposLog.forEach((tipo, count) -> System.out.println("  " + tipo + ": " + count));

		// Solo errores
		List<String> errores = logs.stream().filter(log -> log.contains("ERROR")).collect(Collectors.toList());

		System.out.println("\nSolo errores:");
		errores.forEach(System.out::println);
	}

	private static void quizInteractivo() {
		System.out.println("\n--- QUIZ INTERACTIVO ---");

		String[] preguntas = { "¿Cual es la operacion terminal que cuenta elementos?",
				"¿Que operacion se usa para transformar cada elemento?",
				"¿Como se llama la operacion que aplana estructuras anidadas?",
				"¿Que metodo agrupa elementos por una clave?",
				"¿Cual operacion filtra elementos que cumplen una condicion?" };

		String[] respuestas = { "count", "map", "flatmap", "groupingby", "filter" };
		String[] opciones = { "a)count b)size c)length", "a)transform b)map c)change", "a)flat b)flatmap c)flatten",
				"a)groupby b)groupingby c)group", "a)where b)filter c)select" };

		int correctas = 0;

		for (int i = 0; i < preguntas.length; i++) {
			System.out.println("\nPregunta " + (i + 1) + ": " + preguntas[i]);
			System.out.println(opciones[i]);
			System.out.print("Tu respuesta: ");
			String respuesta = scanner.nextLine().toLowerCase();

			if (respuesta.equals(respuestas[i]) || respuesta.equals(respuestas[i].substring(0, 1))) {
				System.out.println("¡Correcto!");
				correctas++;
			} else {
				System.out.println("Incorrecto. La respuesta era: " + respuestas[i]);
			}
		}

		System.out.println("\n--- RESULTADO FINAL ---");
		System.out.println("\n--- RESULTADO FINAL ---");
		System.out.println("Respuestas correctas: " + correctas + "/" + preguntas.length);

		if (correctas == preguntas.length) {
			System.out.println("¡Perfecto! Dominas los Streams completamente.");
		} else if (correctas >= 3) {
			System.out.println("¡Muy bien! Tienes buen conocimiento de Streams.");
		} else if (correctas >= 2) {
			System.out.println("Bien, pero necesitas practicar mas.");
		} else {
			System.out.println("Necesitas repasar los conceptos basicos.");
		}
	}

	// Clase auxiliar para ejercicios del mundo real
	static class Venta {
		private String producto;
		private double precio;
		private String categoria;
		private String mes;

		public Venta(String producto, double precio, String categoria, String mes) {
			this.producto = producto;
			this.precio = precio;
			this.categoria = categoria;
			this.mes = mes;
		}

		public String getProducto() {
			return producto;
		}

		public double getPrecio() {
			return precio;
		}

		public String getCategoria() {
			return categoria;
		}

		public String getMes() {
			return mes;
		}
	}

	// Metodos auxiliares
	private static boolean isPrime(int number) {
		if (number < 2)
			return false;
		if (number == 2)
			return true;
		if (number % 2 == 0)
			return false;

		for (int i = 3; i * i <= number; i += 2) {
			if (number % i == 0)
				return false;
		}
		return true;
	}

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