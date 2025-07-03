package java_core_basic.streams;

import java.util.Scanner;

/**
 * StreamController - Controlador principal para navegar entre todas las clases
 * de Streams
 */
public class StreamController {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		showMainStreamMenu();
	}

	public static void showMainStreamMenu() {
		while (true) {
			System.out.println("\n" + "=".repeat(50));
			System.out.println("            MENU PRINCIPAL DE STREAMS");
			System.out.println("=".repeat(50));
			System.out.println("1. Fundamentos de Streams");
			System.out.println("2. Streams con Numeros");
			System.out.println("3. Streams con Strings");
			System.out.println("4. Streams con Objetos");
			System.out.println("5. Streams con Colecciones");
			System.out.println("6. Rendimiento de Streams");
			System.out.println("7. Desafios y Ejercicios");
			System.out.println("8. Ayuda y Conceptos");
			System.out.println("0. Salir");
			System.out.println("=".repeat(50));
			System.out.print("Selecciona una opcion: ");

			int option = getValidOption(0, 8);

			switch (option) {
			case 1:
				System.out.println("\n>>> Abriendo Fundamentos de Streams...");
				StreamBasics.showStreamBasicsMenu();
				break;

			case 2:
				System.out.println("\n>>> Abriendo Streams con Numeros...");
				StreamNumbers.showStreamNumbersMenu();
				break;

			case 3:
				System.out.println("\n>>> Abriendo Streams con Strings...");
				StreamStrings.showStreamStringsMenu();
				break;

			case 4:
				System.out.println("\n>>> Abriendo Streams con Objetos...");
				StreamObjects.showStreamObjectsMenu();
				break;

			case 5:
				System.out.println("\n>>> Abriendo Streams con Colecciones...");
				StreamCollections.showStreamCollectionsMenu();
				break;

			case 6:
				System.out.println("\n>>> Abriendo Rendimiento de Streams...");
				StreamPerformance.showStreamPerformanceMenu();
				break;

			case 7:
				System.out.println("\n>>> Abriendo Desafios y Ejercicios...");
				StreamChallenges.showStreamChallengesMenu();
				break;

			case 8:
				showHelp();
				break;

			case 0:
				System.out.println("\nGracias por usar el sistema de Streams!");
				System.out.println("Sigue practicando con Streams - son muy utiles!");
				return;
			}
		}
	}

	private static void showHelp() {
		System.out.println("\n" + "=".repeat(50));
		System.out.println("                    AYUDA - CONCEPTOS CLAVE");
		System.out.println("=".repeat(50));

		System.out.println("\n--- QUE SON LOS STREAMS ---");
		System.out.println("Los Streams son una forma funcional de procesar colecciones");
		System.out.println("de datos en Java. Permiten escribir codigo mas legible y");
		System.out.println("expresivo para operaciones como filtrar, transformar y reducir.");

		System.out.println("\n--- OPERACIONES PRINCIPALES ---");
		System.out.println("INTERMEDIAS (devuelven Stream):");
		System.out.println("  • filter()   - Filtrar elementos que cumplan condicion");
		System.out.println("  • map()      - Transformar cada elemento");
		System.out.println("  • sorted()   - Ordenar elementos");
		System.out.println("  • distinct() - Eliminar duplicados");
		System.out.println("  • limit()    - Limitar cantidad de elementos");
		System.out.println("  • skip()     - Saltar primeros N elementos");

		System.out.println("\nTERMINALES (producen resultado):");
		System.out.println("  • collect()  - Recoger en coleccion");
		System.out.println("  • forEach()  - Ejecutar accion para cada elemento");
		System.out.println("  • reduce()   - Reducir a un solo valor");
		System.out.println("  • count()    - Contar elementos");
		System.out.println("  • anyMatch() - Verificar si alguno cumple condicion");
		System.out.println("  • allMatch() - Verificar si todos cumplen condicion");
		System.out.println("  • findFirst()- Encontrar primer elemento");

		System.out.println("\n--- FLUJO TIPICO ---");
		System.out.println("coleccion.stream()");
		System.out.println("  .operacion_intermedia_1()");
		System.out.println("  .operacion_intermedia_2()");
		System.out.println("  .operacion_terminal()");

		System.out.println("\n--- EJEMPLO PRACTICO ---");
		System.out.println("List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9,10);");
		System.out.println("");
		System.out.println("List<Integer> resultado = numeros.stream()");
		System.out.println("  .filter(n -> n % 2 == 0)    // Solo pares");
		System.out.println("  .map(n -> n * n)            // Elevar al cuadrado");
		System.out.println("  .sorted()                   // Ordenar");
		System.out.println("  .collect(Collectors.toList()); // Recoger resultado");
		System.out.println("");
		System.out.println("// Resultado: [4, 16, 36, 64, 100]");

		System.out.println("\n--- CUANDO USAR STREAMS ---");
		System.out.println("USAR cuando:");
		System.out.println("  • Necesitas filtrar/transformar colecciones");
		System.out.println("  • Quieres codigo mas legible");
		System.out.println("  • Operaciones complejas de datos");
		System.out.println("  • Procesamiento funcional");

		System.out.println("\nNO USAR cuando:");
		System.out.println("  • Operaciones muy simples");
		System.out.println("  • Necesitas modificar variables externas");
		System.out.println("  • Rendimiento critico con pocas operaciones");

		System.out.println("\n--- RECOMENDACIONES DE NAVEGACION ---");
		System.out.println("1. Empieza con 'Fundamentos' si eres nuevo");
		System.out.println("2. Practica con 'Numeros' y 'Strings' para familiarizarte");
		System.out.println("3. Avanza a 'Objetos' para casos mas reales");
		System.out.println("4. Explora 'Colecciones' para operaciones avanzadas");
		System.out.println("5. Revisa 'Rendimiento' para optimizaciones");
		System.out.println("6. Desafiate con 'Ejercicios' para practicar");

		pauseAndContinue();
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