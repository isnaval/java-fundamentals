package fundamentals.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AdvancedArrayOperations {
	private Scanner scanner = new Scanner(System.in);
	private AdvancedArrayUtils utils = new AdvancedArrayUtils();

	// MÉTODO 1: Mezclar arrays
	public void mezclarArrays() {
		System.out.println("\n--- MEZCLAR ARRAYS ---");

		int[] arrayA = utils.crearArray("A", 5);
		int[] arrayB = utils.crearArray("B", 5);

		int[] mezclado = utils.mezclar(arrayA, arrayB);

		System.out.println("Array A: " + Arrays.toString(arrayA));
		System.out.println("Array B: " + Arrays.toString(arrayB));
		System.out.println("Mezclado: " + Arrays.toString(mezclado));
	}

	// MÉTODO 2: Fusionar tipos diferentes
	public void fusionarTipos() {
		System.out.println("\n--- FUSIONAR TIPOS ---");

		String[] textos = { "Java", "Code", "Array" };
		int[] numeros = { 10, 20, 30 };

		Object[] fusion = utils.fusionar(textos, numeros);

		System.out.println("Textos: " + Arrays.toString(textos));
		System.out.println("Números: " + Arrays.toString(numeros));
		System.out.print("Fusión: ");
		utils.mostrarObjetos(fusion);
	}

	// MÉTODO 3: Insertar en posiciones
	public void insertarPosiciones() {
		System.out.println("\n--- INSERTAR EN POSICIONES ---");

		int[] array = new int[8];

		// Llenar primeras 5 posiciones
		for (int i = 0; i < 5; i++) {
			System.out.print("Elemento " + (i + 1) + ": ");
			array[i] = scanner.nextInt();
		}

		System.out.println("Array: " + Arrays.toString(array));

		// Insertar 2 elementos más
		for (int i = 0; i < 2; i++) {
			System.out.print("Número a insertar: ");
			int numero = scanner.nextInt();

			System.out.print("Posición (1-8): ");
			int pos = getNumero(1, 8) - 1;

			utils.insertarEn(array, numero, pos);
			System.out.println("Resultado: " + Arrays.toString(array));
		}
	}

	// MÉTODO 4: Inserción ordenada
	public void insercionOrdenada() {
		System.out.println("\n--- INSERCIÓN ORDENADA ---");

		List<Integer> lista = new ArrayList<>();

		// Agregar números iniciales
		for (int i = 0; i < 3; i++) {
			int num = (int) (Math.random() * 50) + 1;
			lista.add(num);
		}

		Collections.sort(lista);
		System.out.println("Lista inicial: " + lista);

		// Insertar manteniendo orden
		for (int i = 0; i < 3; i++) {
			System.out.print("Número a insertar: ");
			int numero = scanner.nextInt();

			utils.insertarOrdenado(lista, numero);
			System.out.println("Lista: " + lista);
		}
	}

	// MÉTODO 5: Análisis de array
	public void analizarArray() {
		System.out.println("\n--- ANÁLISIS DE ARRAY ---");

		int[] datos = utils.generarAleatorio(10, 50);
		System.out.println("Array: " + Arrays.toString(datos));

		utils.mostrarEstadisticas(datos);
	}

	private int getNumero(int min, int max) {
		while (true) {
			try {
				int num = scanner.nextInt();
				if (num >= min && num <= max)
					return num;
				System.out.print("Número inválido (" + min + "-" + max + "): ");
			} catch (Exception e) {
				scanner.nextLine();
				System.out.print("Entrada inválida: ");
			}
		}
	}
}