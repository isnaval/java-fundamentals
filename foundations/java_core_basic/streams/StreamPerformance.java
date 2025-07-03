package java_core_basic.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StreamPerformance {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		showStreamPerformanceMenu();
	}

	public static void showStreamPerformanceMenu() {
		while (true) {
			System.out.println("\n" + "=".repeat(40));
			System.out.println("      📈 RENDIMIENTO DE STREAMS");
			System.out.println("=".repeat(40));
			System.out.println("1. Stream vs Loop tradicional");
			System.out.println("2. Stream paralelo vs secuencial");
			System.out.println("3. Comparación con diferentes tamaños");
			System.out.println("4. Operaciones complejas");
			System.out.println("5. Mejores prácticas");
			System.out.println("0. Volver");
			System.out.println("=".repeat(40));
			System.out.print("Opción: ");

			int option = getValidOption(0, 5);

			switch (option) {
			case 1:
				streamVsTraditional();
				break;
			case 2:
				parallelVsSequential();
				break;
			case 3:
				differentSizes();
				break;
			case 4:
				complexOperations();
				break;
			case 5:
				bestPractices();
				break;
			case 0:
				return;
			}
			pauseAndContinue();
		}
	}

	/**
	 * 1. Stream vs Loop tradicional
	 */
	private static void streamVsTraditional() {
		System.out.println("\n⚡ STREAM VS LOOP TRADICIONAL");

		List<Integer> numeros = generateNumbers(1_000_000); // 1 millón de números
		System.out.println("🎯 Probando con " + numeros.size() + " números");

		System.out.println("\n🧪 TEST 1: Filtrar números pares");

		// Método tradicional
		long startTime = System.currentTimeMillis();
		List<Integer> paresTradicional = new ArrayList<>();
		for (Integer num : numeros) {
			if (num % 2 == 0) {
				paresTradicional.add(num);
			}
		}
		long tiempoTradicional = System.currentTimeMillis() - startTime;

		// Con Streams
		startTime = System.currentTimeMillis();
		List<Integer> paresStream = numeros.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		long tiempoStream = System.currentTimeMillis() - startTime;

		System.out
				.println("✅ Método tradicional: " + tiempoTradicional + " ms (" + paresTradicional.size() + " pares)");
		System.out.println("✅ Con Streams: " + tiempoStream + " ms (" + paresStream.size() + " pares)");
		System.out.println("📊 Diferencia: " + Math.abs(tiempoTradicional - tiempoStream) + " ms");

		if (tiempoStream < tiempoTradicional) {
			System.out.println("🏆 Streams fue más rápido!");
		} else if (tiempoTradicional < tiempoStream) {
			System.out.println("🏆 Método tradicional fue más rápido!");
		} else {
			System.out.println("🤝 Empate técnico!");
		}

		System.out.println("\n🧪 TEST 2: Sumar números mayores que 500,000");

		// Tradicional
		startTime = System.currentTimeMillis();
		long sumaTradicional = 0;
		for (Integer num : numeros) {
			if (num > 500_000) {
				sumaTradicional += num;
			}
		}
		tiempoTradicional = System.currentTimeMillis() - startTime;

		// Stream
		startTime = System.currentTimeMillis();
		long sumaStream = numeros.stream().filter(n -> n > 500_000).mapToLong(Integer::longValue).sum();
		tiempoStream = System.currentTimeMillis() - startTime;

		System.out.println("✅ Tradicional: " + tiempoTradicional + " ms (suma: " + sumaTradicional + ")");
		System.out.println("✅ Stream: " + tiempoStream + " ms (suma: " + sumaStream + ")");

		System.out.println("\n💡 CONCLUSIÓN:");
		System.out.println("   • Streams: Más legible y expresivo");
		System.out.println("   • Tradicional: A veces más rápido en operaciones simples");
		System.out.println("   • La diferencia suele ser mínima para la mayoría de casos");
	}

	/**
	 * 2. Stream paralelo vs secuencial
	 */
	private static void parallelVsSequential() {
		System.out.println("\n🔄 STREAM PARALELO VS SECUENCIAL");

		List<Integer> numeros = generateNumbers(5_000_000); // 5 millones
		System.out.println("🎯 Probando con " + numeros.size() + " números");

		System.out.println("\n🧪 TEST: Operación costosa (calcular si es primo)");

		// Sequential Stream
		long startTime = System.currentTimeMillis();
		long primosSequential = numeros.stream().limit(10_000) // Solo primeros 10k para que no sea muy lento
				.filter(StreamPerformance::isPrime).count();
		long tiempoSequential = System.currentTimeMillis() - startTime;

		// Parallel Stream
		startTime = System.currentTimeMillis();
		long primosParallel = numeros.parallelStream().limit(10_000).filter(StreamPerformance::isPrime).count();
		long tiempoParallel = System.currentTimeMillis() - startTime;

		System.out.println("✅ Stream secuencial: " + tiempoSequential + " ms (" + primosSequential + " primos)");
		System.out.println("✅ Stream paralelo: " + tiempoParallel + " ms (" + primosParallel + " primos)");

		double speedup = (double) tiempoSequential / tiempoParallel;
		System.out.println("📊 Speedup: " + String.format("%.2fx", speedup));

		System.out.println("🖥️  Núcleos disponibles: " + Runtime.getRuntime().availableProcessors());

		if (speedup > 1.5) {
			System.out.println("🚀 ¡Paralelización muy efectiva!");
		} else if (speedup > 1.1) {
			System.out.println("👍 Paralelización moderadamente efectiva");
		} else {
			System.out.println("⚠️  Paralelización poco efectiva para esta operación");
		}

		System.out.println("\n💡 CUÁNDO USAR PARALELO:");
		System.out.println("   ✅ Colecciones grandes (>10,000 elementos)");
		System.out.println("   ✅ Operaciones computacionalmente costosas");
		System.out.println("   ✅ Múltiples núcleos disponibles");
		System.out.println("   ❌ Operaciones muy rápidas");
		System.out.println("   ❌ Colecciones pequeñas");
		System.out.println("   ❌ Operaciones con efectos secundarios");
	}

	/**
	 * 3. Comparación con diferentes tamaños
	 */
	private static void differentSizes() {
		System.out.println("\n📏 RENDIMIENTO CON DIFERENTES TAMAÑOS");

		int[] tamaños = { 1_000, 10_000, 100_000, 1_000_000 };

		System.out.println("🧪 TEST: Filtrar pares y elevar al cuadrado");
		System.out.println("Tamaño\t\tTradicional\tStream\t\tParalelo");
		System.out.println("-".repeat(60));

		for (int tamaño : tamaños) {
			List<Integer> numeros = generateNumbers(tamaño);

			// Tradicional
			long start = System.currentTimeMillis();
			List<Integer> resultTradicional = new ArrayList<>();
			for (Integer num : numeros) {
				if (num % 2 == 0) {
					resultTradicional.add(num * num);
				}
			}
			long tiempoTradicional = System.currentTimeMillis() - start;

			// Stream
			start = System.currentTimeMillis();
			List<Integer> resultStream = numeros.stream().filter(n -> n % 2 == 0).map(n -> n * n)
					.collect(Collectors.toList());
			long tiempoStream = System.currentTimeMillis() - start;

			// Parallel Stream
			start = System.currentTimeMillis();
			List<Integer> resultParallel = numeros.parallelStream().filter(n -> n % 2 == 0).map(n -> n * n)
					.collect(Collectors.toList());
			long tiempoParallel = System.currentTimeMillis() - start;

			System.out.printf("%-12s\t%d ms\t\t%d ms\t\t%d ms%n", formatNumber(tamaño), tiempoTradicional, tiempoStream,
					tiempoParallel);
		}

		System.out.println("\n💡 OBSERVACIONES:");
		System.out.println("   • Colecciones pequeñas: Tradicional suele ser más rápido");
		System.out.println("   • Colecciones medianas: Stream competitivo");
		System.out.println("   • Colecciones grandes: Parallel Stream puede ganar");
		System.out.println("   • El overhead de paralelización se nota en datos pequeños");
	}

	/**
	 * 4. Operaciones complejas
	 */
	private static void complexOperations() {
		System.out.println("\n🔧 OPERACIONES COMPLEJAS");

		List<Integer> numeros = generateNumbers(100_000);
		System.out.println("🎯 Operación: Filtrar pares > 50k, elevar al cubo, sumar todo");

		// Tradicional
		long start = System.currentTimeMillis();
		long sumaTradicional = 0;
		for (Integer num : numeros) {
			if (num % 2 == 0 && num > 50_000) {
				long cubo = (long) num * num * num;
				sumaTradicional += cubo;
			}
		}
		long tiempoTradicional = System.currentTimeMillis() - start;

		// Stream
		start = System.currentTimeMillis();
		long sumaStream = numeros.stream().filter(n -> n % 2 == 0).filter(n -> n > 50_000)
				.mapToLong(n -> (long) n * n * n).sum();
		long tiempoStream = System.currentTimeMillis() - start;

		// Parallel Stream
		start = System.currentTimeMillis();
		long sumaParallel = numeros.parallelStream().filter(n -> n % 2 == 0).filter(n -> n > 50_000)
				.mapToLong(n -> (long) n * n * n).sum();
		long tiempoParallel = System.currentTimeMillis() - start;

		System.out.println("✅ Tradicional: " + tiempoTradicional + " ms (suma: " + sumaTradicional + ")");
		System.out.println("✅ Stream: " + tiempoStream + " ms (suma: " + sumaStream + ")");
		System.out.println("✅ Parallel: " + tiempoParallel + " ms (suma: " + sumaParallel + ")");

		System.out.println("\n🎯 EJEMPLO DE CÓDIGO STREAM:");
		System.out.println("numeros.stream()");
		System.out.println("  .filter(n -> n % 2 == 0)");
		System.out.println("  .filter(n -> n > 50_000)");
		System.out.println("  .mapToLong(n -> (long) n * n * n)");
		System.out.println("  .sum();");

		System.out.println("\n💡 VENTAJAS DE STREAMS:");
		System.out.println("   ✅ Código más legible y mantenible");
		System.out.println("   ✅ Menos propenso a errores");
		System.out.println("   ✅ Fácil paralelización");
		System.out.println("   ✅ Operaciones funcionales componibles");
	}

	/**
	 * 5. Mejores prácticas
	 */
	private static void bestPractices() {
		System.out.println("\n💎 MEJORES PRÁCTICAS");

		System.out.println("🚀 CUÁNDO USAR STREAMS:");
		System.out.println("   ✅ Transformaciones de datos complejas");
		System.out.println("   ✅ Operaciones de filtrado múltiples");
		System.out.println("   ✅ Cuando la legibilidad es importante");
		System.out.println("   ✅ Procesamiento de colecciones medianas/grandes");

		System.out.println("\n⚠️  CUÁNDO NO USAR STREAMS:");
		System.out.println("   ❌ Loops simples con pocas operaciones");
		System.out.println("   ❌ Modificación de variables externas");
		System.out.println("   ❌ Operaciones con efectos secundarios");
		System.out.println("   ❌ Colecciones muy pequeñas (<100 elementos)");

		System.out.println("\n🔧 OPTIMIZACIONES:");
		System.out.println("   • Usa 'filter' antes que 'map' para reducir elementos");
		System.out.println("   • Prefiere 'anyMatch/allMatch' sobre 'filter().count()'");
		System.out.println("   • Usa streams especializados (IntStream, LongStream)");
		System.out.println("   • Evita crear streams innecesarios");

		System.out.println("\n⚡ EJEMPLO OPTIMIZADO vs NO OPTIMIZADO:");

		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		System.out.println("\n❌ NO OPTIMIZADO:");
		System.out.println("numeros.stream()");
		System.out.println("  .map(n -> n * n)        // Procesa TODOS");
		System.out.println("  .filter(n -> n > 20)    // Luego filtra");
		System.out.println("  .findFirst();");

		System.out.println("\n✅ OPTIMIZADO:");
		System.out.println("numeros.stream()");
		System.out.println("  .filter(n -> n * n > 20) // Filtra PRIMERO");
		System.out.println("  .map(n -> n * n)         // Solo procesa necesarios");
		System.out.println("  .findFirst();");

		// Demostrar la diferencia
		System.out.println("\n🧪 COMPARACIÓN PRÁCTICA:");

		long start = System.currentTimeMillis();
		Optional<Integer> result1 = numeros.stream().map(n -> n * n).filter(n -> n > 20).findFirst();
		long tiempo1 = System.currentTimeMillis() - start;

		start = System.currentTimeMillis();
		Optional<Integer> result2 = numeros.stream().filter(n -> n * n > 20).map(n -> n * n).findFirst();
		long tiempo2 = System.currentTimeMillis() - start;

		System.out.println("No optimizado: " + result1.orElse(-1) + " (" + tiempo1 + " ms)");
		System.out.println("Optimizado: " + result2.orElse(-1) + " (" + tiempo2 + " ms)");

		System.out.println("\n🎯 REGLA DE ORO:");
		System.out.println("'Usa Streams para claridad, loops para velocidad crítica'");
	}

	// Métodos auxiliares
	private static List<Integer> generateNumbers(int count) {
		Random random = new Random(42); // Seed fijo para resultados consistentes
		return random.ints(count, 1, 1_000_000).boxed().collect(Collectors.toList());
	}

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

	private static String formatNumber(int number) {
		if (number >= 1_000_000) {
			return (number / 1_000_000) + "M";
		} else if (number >= 1_000) {
			return (number / 1_000) + "K";
		}
		return String.valueOf(number);
	}

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

	private static void pauseAndContinue() {
		System.out.print("\nPresiona Enter para continuar...");
		scanner.nextLine();
	}
}