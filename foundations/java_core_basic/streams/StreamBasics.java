package java_core_basic.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamBasics {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("INICIANDO PROGRAMA...");
		showStreamBasicsMenu();
		System.out.println("Fin del programa");
	}

	public static void showStreamBasicsMenu() {
		while (true) {
			System.out.println("\n" + "=".repeat(40));
			System.out.println("     🌊 FUNDAMENTOS DE STREAMS");
			System.out.println("=".repeat(40));
			System.out.println("1. ¿Qué son los Streams?");
			System.out.println("2. Crear Streams");
			System.out.println("3. Operaciones básicas");
			System.out.println("4. Ejemplo práctico");
			System.out.println("5. Laboratorio interactivo");
			System.out.println("0. Volver");
			System.out.println("=".repeat(40));
			System.out.print("Opción: ");

			int option = getValidOption(0, 5);

			switch (option) {
			case 1:
				streamTheory();
				break;
			case 2:
				streamCreation();
				break;
			case 3:
				basicOperations();
				break;
			case 4:
				practicalExample();
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
	 * METODOS AUXILIARES - CORREGIDOS
	 */
	private static void pauseAndContinue() {
		System.out.print("\nPresiona Enter para continuar...");
		scanner.nextLine();
	}

	private static int getValidOption(int min, int max) {
		while (true) {
			try {
				int option = scanner.nextInt();
				scanner.nextLine();
				if (option >= min && option <= max) {
					return option;
				}
				System.out.print("Opción inválida. Ingresa entre " + min + " y " + max + ": ");
			} catch (Exception e) {
				scanner.nextLine();
				System.out.print("Entrada inválida. Ingresa un número: ");
			}
		}
	}

	private static int readNumber() {
		int num = scanner.nextInt();
		scanner.nextLine();
		return num;
	}

	/**
	 * 1. Explicación básica de Streams
	 */
	private static void streamTheory() {
		System.out.println("\n📚 ¿QUÉ SON LOS STREAMS?");
		System.out.println("Los Streams procesan colecciones de manera funcional y declarativa.");

		System.out.println("\n💡 CARACTERÍSTICAS:");
		System.out.println("✅ NO modifican la fuente original");
		System.out.println("✅ Evaluación perezosa (lazy)");
		System.out.println("✅ Operaciones encadenables");
		System.out.println("✅ Más legible que loops tradicionales");

		System.out.println("\n🆚 COMPARACIÓN:");
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		System.out.println("❌ MÉTODO TRADICIONAL:");
		System.out.println("List<Integer> pares = new ArrayList<>();");
		System.out.println("for (Integer n : numeros) {");
		System.out.println("    if (n % 2 == 0) pares.add(n * n);");
		System.out.println("}");

		System.out.println("\n✅ CON STREAMS:");
		System.out.println("List<Integer> pares = numeros.stream()");
		System.out.println("    .filter(n -> n % 2 == 0)");
		System.out.println("    .map(n -> n * n)");
		System.out.println("    .collect(Collectors.toList());");

		List<Integer> pares = numeros.stream().filter(n -> n % 2 == 0).map(n -> n * n).collect(Collectors.toList());

		System.out.println("\n🎯 Resultado: " + pares);
	}

	/**
	 * 2. Formas de crear Streams
	 */
	private static void streamCreation() {
		System.out.println("\n🔧 CREAR STREAMS:");

		System.out.println("\n1. Desde una Lista:");
		List<String> frutas = Arrays.asList("manzana", "banana", "cereza");
		System.out.println("frutas.stream()");
		frutas.stream().forEach(f -> System.out.print(f + " "));

		System.out.println("\n\n2. Con Stream.of():");
		System.out.println("Stream.of(1, 2, 3, 4, 5)");
		Stream.of(1, 2, 3, 4, 5).forEach(n -> System.out.print(n + " "));

		System.out.println("\n\n3. Rangos numéricos:");
		System.out.println("IntStream.range(1, 6)");
		IntStream.range(1, 6).forEach(n -> System.out.print(n + " "));

		System.out.println("\n\n4. Stream infinito:");
		System.out.println("Stream.iterate(0, n -> n + 2).limit(5)");
		Stream.iterate(0, n -> n + 2).limit(5).forEach(n -> System.out.print(n + " "));
		System.out.println();
	}

	/**
	 * 3. Operaciones básicas
	 */
	private static void basicOperations() {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println("\n⚙️  OPERACIONES BÁSICAS:");
		System.out.println("Lista: " + numeros);

		System.out.println("\n🔄 OPERACIONES INTERMEDIAS (devuelven Stream):");

		System.out.println("filter() - Filtrar:");
		List<Integer> pares = numeros.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println("  Pares: " + pares);

		System.out.println("map() - Transformar:");
		List<Integer> cuadrados = numeros.stream().map(n -> n * n).collect(Collectors.toList());
		System.out.println("  Cuadrados: " + cuadrados);

		System.out.println("sorted() - Ordenar:");
		List<Integer> desc = numeros.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println("  Descendente: " + desc);

		System.out.println("limit() - Limitar:");
		List<Integer> primeros = numeros.stream().limit(5).collect(Collectors.toList());
		System.out.println("  Primeros 5: " + primeros);

		System.out.println("\n🏁 OPERACIONES TERMINALES (producen resultado):");

		System.out.println("collect() - Recolectar:");
		System.out.println("  Ya visto arriba");

		System.out.println("count() - Contar:");
		long mayores5 = numeros.stream().filter(n -> n > 5).count();
		System.out.println("  Mayores que 5: " + mayores5);

		System.out.println("reduce() - Reducir:");
		int suma = numeros.stream().reduce(0, Integer::sum);
		System.out.println("  Suma total: " + suma);

		System.out.println("findFirst() - Encontrar primero:");
		Optional<Integer> primero = numeros.stream().filter(n -> n > 7).findFirst();
		System.out.println("  Primero > 7: " + primero.orElse(-1));

		System.out.println("anyMatch() - Verificar:");
		boolean hayPares = numeros.stream().anyMatch(n -> n % 2 == 0);
		System.out.println("  ¿Hay pares?: " + hayPares);
	}

	/**
	 * 4. Ejemplo práctico completo
	 */
	private static void practicalExample() {
		System.out.println("\n🎯 EJEMPLO PRÁCTICO:");
		System.out.println("Lista de estudiantes → Filtrar → Transformar → Resultado");

		List<String> estudiantes = Arrays.asList("Ana", "Roberto", "Maria", "Luis", "Carmen", "Pedro", "Isabella");

		System.out.println("\nDatos: " + estudiantes);
		System.out.println("\nObjetivo: Nombres con +4 letras, en mayúsculas, ordenados, primeros 3, unidos por comas");

		String resultado = estudiantes.stream().filter(nombre -> nombre.length() > 4).map(String::toUpperCase).sorted()
				.limit(3).collect(Collectors.joining(", "));

		System.out.println("\nCódigo:");
		System.out.println("estudiantes.stream()");
		System.out.println("  .filter(nombre -> nombre.length() > 4)");
		System.out.println("  .map(String::toUpperCase)");
		System.out.println("  .sorted()");
		System.out.println("  .limit(3)");
		System.out.println("  .collect(Collectors.joining(\", \"));");

		System.out.println("\n🏆 Resultado: \"" + resultado + "\"");
	}

	/**
	 * 5. Laboratorio interactivo - CORREGIDO
	 */
	private static void interactiveLab() {
		System.out.println("\n🧪 LABORATORIO INTERACTIVO");

		System.out.print("¿Cuántos números? (1-10): ");
		int cantidad = getValidOption(1, 10);

		List<Integer> numeros = new ArrayList<>();
		for (int i = 1; i <= cantidad; i++) {
			System.out.print("Número " + i + ": ");
			numeros.add(readNumber()); // ✅ USAR método que limpia buffer
		}

		System.out.println("Tu lista: " + numeros);

		while (true) {
			System.out.println("\n🔧 Operaciones:");
			System.out.println("1. Filtrar pares    2. Elevar al cuadrado");
			System.out.println("3. Ordenar desc.    4. Sumar todos");
			System.out.println("5. Encontrar máximo 0. Salir");

			int op = getValidOption(0, 5);
			if (op == 0)
				break;

			switch (op) {
			case 1:
				List<Integer> pares = numeros.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
				System.out.println("Pares: " + pares);
				break;
			case 2:
				List<Integer> cuadrados = numeros.stream().map(n -> n * n).collect(Collectors.toList());
				System.out.println("Cuadrados: " + cuadrados);
				break;
			case 3:
				List<Integer> desc = numeros.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
				System.out.println("Descendente: " + desc);
				break;
			case 4:
				int suma = numeros.stream().mapToInt(Integer::intValue).sum();
				System.out.println("Suma: " + suma);
				break;
			case 5:
				int max = numeros.stream().mapToInt(Integer::intValue).max().orElse(0);
				System.out.println("Máximo: " + max);
				break;
			}
		}
	}
}