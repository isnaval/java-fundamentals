package java_core_basic.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamNumbers {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		showStreamNumbersMenu();
	}

	static void showStreamNumbersMenu() {
		while (true) {
			System.out.println("\n" + "=".repeat(40));
			System.out.println("       🔢 STREAMS CON NÚMEROS");
			System.out.println("=".repeat(40));
			System.out.println("1. Filtros básicos (pares, impares, etc.)");
			System.out.println("2. Transformaciones (cuadrado, doble, etc.)");
			System.out.println("3. Estadísticas (suma, promedio, max, min)");
			System.out.println("4. Rangos y límites");
			System.out.println("5. Laboratorio con tu lista");
			System.out.println("0. Volver");
			System.out.println("=".repeat(40));
			System.out.print("Opción: ");

			int option = getValidOption(0, 5);

			switch (option) {
			case 1:
				basicFilters();
				break;
			case 2:
				transformations();
				break;
			case 3:
				statistics();
				break;
			case 4:
				rangesAndLimits();
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
	 * CLASES AUXILIARES
	 */
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

	/**
	 * 1. Filtros básicos
	 */
	private static void basicFilters() {
		System.out.println("\n🔍 FILTROS BÁSICOS");

		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 20, 25);
		System.out.println("Lista: " + numeros);

		// Pares
		List<Integer> pares = numeros.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println("\n✅ Números pares: " + pares);

		// Impares
		List<Integer> impares = numeros.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
		System.out.println("✅ Números impares: " + impares);

		// Mayores que 5
		List<Integer> mayores5 = numeros.stream().filter(n -> n > 5).collect(Collectors.toList());
		System.out.println("✅ Mayores que 5: " + mayores5);

		// Entre 3 y 8
		List<Integer> entre3y8 = numeros.stream().filter(n -> n >= 3 && n <= 8).collect(Collectors.toList());
		System.out.println("✅ Entre 3 y 8: " + entre3y8);

		// Múltiplos de 5
		List<Integer> multiplos5 = numeros.stream().filter(n -> n % 5 == 0).collect(Collectors.toList());
		System.out.println("✅ Múltiplos de 5: " + multiplos5);
	}

	/**
	 * 2. Transformaciones
	 */
	private static void transformations() {
		System.out.println("\n🔧 TRANSFORMACIONES");

		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println("Lista original: " + numeros);

		// Doble de cada número
		List<Integer> dobles = numeros.stream().map(n -> n * 2).collect(Collectors.toList());
		System.out.println("\n✅ Dobles: " + dobles);

		// Cuadrados
		List<Integer> cuadrados = numeros.stream().map(n -> n * n).collect(Collectors.toList());
		System.out.println("✅ Cuadrados: " + cuadrados);

		// Sumar 10 a cada uno
		List<Integer> mas10 = numeros.stream().map(n -> n + 10).collect(Collectors.toList());
		System.out.println("✅ +10 a cada uno: " + mas10);

		// Combinado: solo pares y luego cuadrado
		List<Integer> paresCuadrados = numeros.stream().filter(n -> n % 2 == 0) // Solo pares
				.map(n -> n * n) // Al cuadrado
				.collect(Collectors.toList());
		System.out.println("✅ Pares al cuadrado: " + paresCuadrados);

		// Números negativos
		List<Integer> negativos = numeros.stream().map(n -> -n).collect(Collectors.toList());
		System.out.println("✅ Negativos: " + negativos);
	}

	/**
	 * 3. Estadísticas
	 */
	private static void statistics() {
		System.out.println("\n📊 ESTADÍSTICAS");

		List<Integer> numeros = Arrays.asList(3, 7, 1, 9, 4, 6, 2, 8, 5);
		System.out.println("Lista: " + numeros);

		// Suma total
		int suma = numeros.stream().mapToInt(Integer::intValue).sum();
		System.out.println("\n✅ Suma total: " + suma);

		// Promedio
		double promedio = numeros.stream().mapToInt(Integer::intValue).average().orElse(0.0);
		System.out.println("✅ Promedio: " + String.format("%.2f", promedio));

		// Máximo
		int maximo = numeros.stream().mapToInt(Integer::intValue).max().orElse(0);
		System.out.println("✅ Máximo: " + maximo);

		// Mínimo
		int minimo = numeros.stream().mapToInt(Integer::intValue).min().orElse(0);
		System.out.println("✅ Mínimo: " + minimo);

		// Contar elementos
		long cantidad = numeros.stream().count();
		System.out.println("✅ Cantidad: " + cantidad);

		// Contar pares
		long pares = numeros.stream().filter(n -> n % 2 == 0).count();
		System.out.println("✅ Cantidad de pares: " + pares);

		// ¿Hay algún número mayor que 8?
		boolean hayMayor8 = numeros.stream().anyMatch(n -> n > 8);
		System.out.println("✅ ¿Hay algún número > 8?: " + hayMayor8);

		// ¿Todos son positivos?
		boolean todosPositivos = numeros.stream().allMatch(n -> n > 0);
		System.out.println("✅ ¿Todos positivos?: " + todosPositivos);
	}

	/**
	 * 4. Rangos y límites
	 */
	private static void rangesAndLimits() {
		System.out.println("\n📏 RANGOS Y LÍMITES");

		// Crear rango del 1 al 20
		System.out.println("Rango del 1 al 20:");
		List<Integer> rango = IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toList());
		System.out.println(rango);

		// Solo los primeros 5
		System.out.println("\n✅ Primeros 5:");
		List<Integer> primeros5 = IntStream.rangeClosed(1, 20).limit(5).boxed().collect(Collectors.toList());
		System.out.println(primeros5);

		// Saltar los primeros 10
		System.out.println("✅ Saltar primeros 10:");
		List<Integer> saltar10 = IntStream.rangeClosed(1, 20).skip(10).boxed().collect(Collectors.toList());
		System.out.println(saltar10);

		// Solo números pares del 1 al 20
		System.out.println("✅ Solo pares del 1 al 20:");
		List<Integer> paresDel1al20 = IntStream.rangeClosed(1, 20).filter(n -> n % 2 == 0).boxed()
				.collect(Collectors.toList());
		System.out.println(paresDel1al20);

		// Primeros 3 múltiplos de 3
		System.out.println("✅ Primeros 3 múltiplos de 3:");
		List<Integer> multiplos3 = IntStream.rangeClosed(1, 100).filter(n -> n % 3 == 0).limit(3).boxed()
				.collect(Collectors.toList());
		System.out.println(multiplos3);
	}

	/**
	 * 5. Laboratorio interactivo
	 */
	private static void interactiveLab() {
		System.out.println("\n🧪 LABORATORIO CON TU LISTA");

		// Crear lista personalizada
		System.out.print("¿Cuántos números quieres? (1-10): ");
		int cantidad = getValidOption(1, 10);

		List<Integer> numeros = new ArrayList<>();
		for (int i = 1; i <= cantidad; i++) {
			System.out.print("Número " + i + ": ");
			numeros.add(readNumber());
		}

		System.out.println("\n🎯 Tu lista: " + numeros);

		// Menú de operaciones
		while (true) {
			System.out.println("\n¿Qué quieres hacer?");
			System.out.println("1. Ver solo pares    2. Ver solo impares");
			System.out.println("3. Dobles            4. Cuadrados");
			System.out.println("5. Estadísticas      6. Mayores que X");
			System.out.println("0. Salir");

			int op = getValidOption(0, 6);
			if (op == 0)
				break;

			switch (op) {
			case 1:
				List<Integer> pares = numeros.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
				System.out.println("🎯 Pares: " + pares);
				break;

			case 2:
				List<Integer> impares = numeros.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
				System.out.println("🎯 Impares: " + impares);
				break;

			case 3:
				List<Integer> dobles = numeros.stream().map(n -> n * 2).collect(Collectors.toList());
				System.out.println("🎯 Dobles: " + dobles);
				break;

			case 4:
				List<Integer> cuadrados = numeros.stream().map(n -> n * n).collect(Collectors.toList());
				System.out.println("🎯 Cuadrados: " + cuadrados);
				break;

			case 5:
				System.out.println("📊 ESTADÍSTICAS:");
				System.out.println("   Suma: " + numeros.stream().mapToInt(Integer::intValue).sum());
				System.out.println("   Promedio: "
						+ String.format("%.2f", numeros.stream().mapToInt(Integer::intValue).average().orElse(0.0)));
				System.out.println("   Máximo: " + numeros.stream().mapToInt(Integer::intValue).max().orElse(0));
				System.out.println("   Mínimo: " + numeros.stream().mapToInt(Integer::intValue).min().orElse(0));
				break;

			case 6:
				System.out.print("¿Mayores que cuánto? ");
				int limite = readNumber();
				List<Integer> mayores = numeros.stream().filter(n -> n > limite).collect(Collectors.toList());
				System.out.println("🎯 Mayores que " + limite + ": " + mayores);
				break;
			}
		}
	}

}
