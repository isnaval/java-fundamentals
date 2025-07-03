package java_core_basic.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StreamStrings {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		showStreamStringsMenu();
	}

	public static void showStreamStringsMenu() {
		while (true) {
			System.out.println("\n" + "=".repeat(40));
			System.out.println("       📝 STREAMS CON STRINGS");
			System.out.println("=".repeat(40));
			System.out.println("1. Transformaciones básicas");
			System.out.println("2. Filtros de texto");
			System.out.println("3. Análisis de palabras");
			System.out.println("4. Operaciones avanzadas");
			System.out.println("5. Laboratorio con tus palabras");
			System.out.println("0. Volver");
			System.out.println("=".repeat(40));
			System.out.print("Opción: ");

			int option = getValidOption(0, 5);

			switch (option) {
			case 1:
				basicTransformations();
				break;
			case 2:
				textFilters();
				break;
			case 3:
				wordAnalysis();
				break;
			case 4:
				advancedOperations();
				break;
			case 5:
				interactiveLab();
				break;
			case 0:
				return;
			}
			pauseAndContinue();
		}
	}

	/**
	 * 1. Transformaciones básicas
	 */
	private static void basicTransformations() {
		System.out.println("\n🔧 TRANSFORMACIONES BÁSICAS");

		List<String> palabras = Arrays.asList("hola", "mundo", "java", "stream", "programacion");
		System.out.println("Lista original: " + palabras);

		// A mayúsculas
		List<String> mayusculas = palabras.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println("\n✅ Mayúsculas: " + mayusculas);

		// A minúsculas
		List<String> minusculas = Arrays.asList("HOLA", "MUNDO", "JAVA").stream().map(String::toLowerCase)
				.collect(Collectors.toList());
		System.out.println("✅ Minúsculas: " + minusculas);

		// Primera letra mayúscula
		List<String> capitalizadas = palabras.stream()
				.map(palabra -> palabra.substring(0, 1).toUpperCase() + palabra.substring(1))
				.collect(Collectors.toList());
		System.out.println("✅ Capitalizadas: " + capitalizadas);

		// Agregar prefijo
		List<String> conPrefijo = palabras.stream().map(palabra -> "-> " + palabra).collect(Collectors.toList());
		System.out.println("✅ Con prefijo: " + conPrefijo);

		// Longitud de cada palabra
		List<Integer> longitudes = palabras.stream().map(String::length).collect(Collectors.toList());
		System.out.println("✅ Longitudes: " + longitudes);
	}

	/**
	 * 2. Filtros de texto
	 */
	private static void textFilters() {
		System.out.println("\n🔍 FILTROS DE TEXTO");

		List<String> palabras = Arrays.asList("casa", "automóvil", "gato", "elefante", "perro", "bicicleta", "sol");
		System.out.println("Lista: " + palabras);

		// Palabras largas (más de 5 letras)
		List<String> largas = palabras.stream().filter(palabra -> palabra.length() > 5).collect(Collectors.toList());
		System.out.println("\n✅ Más de 5 letras: " + largas);

		// Palabras cortas (4 letras o menos)
		List<String> cortas = palabras.stream().filter(palabra -> palabra.length() <= 4).collect(Collectors.toList());
		System.out.println("✅ 4 letras o menos: " + cortas);

		// Empiezan con 'a'
		List<String> empiezanA = palabras.stream().filter(palabra -> palabra.startsWith("a"))
				.collect(Collectors.toList());
		System.out.println("✅ Empiezan con 'a': " + empiezanA);

		// Contienen 'e'
		List<String> contienenE = palabras.stream().filter(palabra -> palabra.contains("e"))
				.collect(Collectors.toList());
		System.out.println("✅ Contienen 'e': " + contienenE);

		// Terminan en 'o'
		List<String> terminanO = palabras.stream().filter(palabra -> palabra.endsWith("o"))
				.collect(Collectors.toList());
		System.out.println("✅ Terminan en 'o': " + terminanO);
	}

	/**
	 * 3. Análisis de palabras
	 */
	private static void wordAnalysis() {
		System.out.println("\n📊 ANÁLISIS DE PALABRAS");

		List<String> texto = Arrays.asList("el", "gato", "subió", "al", "tejado", "el", "perro", "ladró", "fuerte");
		System.out.println("Texto: " + texto);

		// Contar palabras
		long totalPalabras = texto.stream().count();
		System.out.println("\n✅ Total palabras: " + totalPalabras);

		// Palabra más larga
		String masLarga = texto.stream().max(Comparator.comparing(String::length)).orElse("");
		System.out.println("✅ Palabra más larga: " + masLarga);

		// Palabra más corta
		String masCorta = texto.stream().min(Comparator.comparing(String::length)).orElse("");
		System.out.println("✅ Palabra más corta: " + masCorta);

		// Promedio de longitud
		double promedioLongitud = texto.stream().mapToInt(String::length).average().orElse(0.0);
		System.out.println("✅ Promedio longitud: " + String.format("%.2f", promedioLongitud));

		// Total de caracteres
		int totalCaracteres = texto.stream().mapToInt(String::length).sum();
		System.out.println("✅ Total caracteres: " + totalCaracteres);

		// ¿Todas tienen más de 2 letras?
		boolean todasMayorQue2 = texto.stream().allMatch(palabra -> palabra.length() > 2);
		System.out.println("✅ ¿Todas > 2 letras?: " + todasMayorQue2);

		// ¿Hay alguna que empiece con vocal?
		boolean hayVocal = texto.stream().anyMatch(palabra -> "aeiouAEIOU".contains(palabra.substring(0, 1)));
		System.out.println("✅ ¿Alguna empieza con vocal?: " + hayVocal);
	}

	/**
	 * 4. Operaciones avanzadas
	 */
	private static void advancedOperations() {
		System.out.println("\n🚀 OPERACIONES AVANZADAS");

		List<String> frases = Arrays.asList("Hola mundo", "Java es genial", "Stream API", "Programación funcional");
		System.out.println("Frases: " + frases);

		// Unir todas las palabras
		String textoCompleto = frases.stream().collect(Collectors.joining(" "));
		System.out.println("\n✅ Texto completo: " + textoCompleto);

		// Unir con separador personalizado
		String conGuiones = frases.stream().collect(Collectors.joining(" | "));
		System.out.println("✅ Con separador: " + conGuiones);

		// Dividir frases en palabras individuales
		List<String> todasLasPalabras = frases.stream().flatMap(frase -> Arrays.stream(frase.split(" ")))
				.collect(Collectors.toList());
		System.out.println("✅ Todas las palabras: " + todasLasPalabras);

		// Palabras únicas (sin repetir)
		List<String> palabrasUnicas = frases.stream().flatMap(frase -> Arrays.stream(frase.split(" ")))
				.map(String::toLowerCase).distinct().collect(Collectors.toList());
		System.out.println("✅ Palabras únicas: " + palabrasUnicas);

		// Ordenar por longitud
		List<String> ordenadas = frases.stream().sorted(Comparator.comparing(String::length))
				.collect(Collectors.toList());
		System.out.println("✅ Ordenadas por longitud: " + ordenadas);

		// Agrupar por longitud
		Map<Integer, List<String>> porLongitud = frases.stream().collect(Collectors.groupingBy(String::length));
		System.out.println("✅ Agrupadas por longitud: " + porLongitud);

		// Primeras 2 palabras de cada frase
		List<String> primeras2 = frases.stream()
				.map(frase -> Arrays.stream(frase.split(" ")).limit(2).collect(Collectors.joining(" ")))
				.collect(Collectors.toList());
		System.out.println("✅ Primeras 2 palabras: " + primeras2);
	}

	/**
	 * 5. Laboratorio interactivo
	 */
	private static void interactiveLab() {
		System.out.println("\n🧪 LABORATORIO CON TUS PALABRAS");

		// Crear lista de palabras
		System.out.print("¿Cuántas palabras quieres ingresar? (1-10): ");
		int cantidad = getValidOption(1, 10);

		List<String> palabras = new ArrayList<>();
		System.out.println("Ingresa las palabras:");
		for (int i = 1; i <= cantidad; i++) {
			System.out.print("Palabra " + i + ": ");
			palabras.add(scanner.nextLine());
		}

		System.out.println("\n🎯 Tus palabras: " + palabras);

		// Menú de operaciones
		while (true) {
			System.out.println("\n¿Qué quieres hacer?");
			System.out.println("1. A mayúsculas      2. A minúsculas");
			System.out.println("3. Palabras largas   4. Ordenar alfabético");
			System.out.println("5. Análisis completo 6. Filtrar por letra");
			System.out.println("7. Unir todas        0. Salir");

			int op = getValidOption(0, 7);
			if (op == 0)
				break;

			switch (op) {
			case 1:
				List<String> mayus = palabras.stream().map(String::toUpperCase).collect(Collectors.toList());
				System.out.println("🎯 Mayúsculas: " + mayus);
				break;

			case 2:
				List<String> minus = palabras.stream().map(String::toLowerCase).collect(Collectors.toList());
				System.out.println("🎯 Minúsculas: " + minus);
				break;

			case 3:
				System.out.print("¿Más de cuántas letras? ");
				int minLetras = readNumber();
				List<String> largas = palabras.stream().filter(p -> p.length() > minLetras)
						.collect(Collectors.toList());
				System.out.println("🎯 Más de " + minLetras + " letras: " + largas);
				break;

			case 4:
				List<String> ordenadas = palabras.stream().sorted().collect(Collectors.toList());
				System.out.println("🎯 Orden alfabético: " + ordenadas);
				break;

			case 5:
				System.out.println("📊 ANÁLISIS COMPLETO:");
				System.out.println("   Total palabras: " + palabras.size());
				System.out.println(
						"   Más larga: " + palabras.stream().max(Comparator.comparing(String::length)).orElse(""));
				System.out.println(
						"   Más corta: " + palabras.stream().min(Comparator.comparing(String::length)).orElse(""));
				System.out.println("   Promedio letras: "
						+ String.format("%.2f", palabras.stream().mapToInt(String::length).average().orElse(0.0)));
				break;

			case 6:
				System.out.print("¿Filtrar por qué letra? ");
				String letra = scanner.nextLine().toLowerCase();
				if (letra.length() > 0) {
					List<String> filtradas = palabras.stream().filter(p -> p.toLowerCase().contains(letra))
							.collect(Collectors.toList());
					System.out.println("🎯 Contienen '" + letra + "': " + filtradas);
				}
				break;

			case 7:
				String unidas = palabras.stream().collect(Collectors.joining(" "));
				System.out.println("🎯 Todas unidas: " + unidas);
				break;
			}
		}
	}

	// Métodos auxiliares
	private static int getValidOption(int min, int max) {
		while (true) {
			try {
				int option = scanner.nextInt();
				scanner.nextLine();
				if (option >= min && option <= max) {
					return option;
				}
				System.out.print("Opción inválida (" + min + "-" + max + "): ");
			} catch (Exception e) {
				scanner.nextLine();
				System.out.print("Entrada inválida: ");
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