package java_core.arrays;

import java.util.List;
import java.util.Scanner;

public class AdvancedArrayUtils {
	private Scanner scanner = new Scanner(System.in);

	// FUNCIÓN: Crear array manual
	public int[] crearArray(String nombre, int tamaño) {
		int[] array = new int[tamaño];
		System.out.println("Ingresa " + tamaño + " números para array " + nombre + ":");

		for (int i = 0; i < tamaño; i++) {
			System.out.print("  [" + (i + 1) + "]: ");
			array[i] = scanner.nextInt();
		}

		return array;
	}

	// FUNCIÓN: Generar array aleatorio
	public int[] generarAleatorio(int tamaño, int max) {
		int[] array = new int[tamaño];
		for (int i = 0; i < tamaño; i++) {
			array[i] = (int) (Math.random() * max) + 1;
		}
		return array;
	}

	// FUNCIÓN: Mezclar dos arrays alternando
	public int[] mezclar(int[] arrayA, int[] arrayB) {
		int[] resultado = new int[arrayA.length + arrayB.length];
		int indice = 0;

		int maxTamaño = Math.max(arrayA.length, arrayB.length);

		for (int i = 0; i < maxTamaño; i++) {
			if (i < arrayA.length) {
				resultado[indice++] = arrayA[i];
			}
			if (i < arrayB.length) {
				resultado[indice++] = arrayB[i];
			}
		}

		return resultado;
	}

	// FUNCIÓN: Fusionar arrays de diferentes tipos
	public Object[] fusionar(String[] textos, int[] numeros) {
		Object[] fusion = new Object[textos.length + numeros.length];
		int indice = 0;

		// Alternar tipos
		int max = Math.max(textos.length, numeros.length);
		for (int i = 0; i < max; i++) {
			if (i < textos.length) {
				fusion[indice++] = textos[i];
			}
			if (i < numeros.length) {
				fusion[indice++] = numeros[i];
			}
		}

		return fusion;
	}

	// FUNCIÓN: Insertar en posición específica
	public void insertarEn(int[] array, int elemento, int posicion) {
		if (posicion < 0 || posicion >= array.length) {
			System.out.println("Posición inválida");
			return;
		}

		// Mover elementos hacia la derecha
		for (int i = array.length - 1; i > posicion; i--) {
			array[i] = array[i - 1];
		}

		array[posicion] = elemento;
	}

	// FUNCIÓN: Insertar en lista manteniendo orden
	public void insertarOrdenado(List<Integer> lista, int numero) {
		int posicion = 0;

		// Encontrar posición correcta
		while (posicion < lista.size() && lista.get(posicion) < numero) {
			posicion++;
		}

		lista.add(posicion, numero);
	}

	// FUNCIÓN: Mostrar array de objetos
	public void mostrarObjetos(Object[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length - 1)
				System.out.print(", ");
		}
		System.out.println("]");
	}

	// FUNCIÓN: Mostrar estadísticas básicas
	public void mostrarEstadisticas(int[] array) {
		int suma = 0;
		int max = array[0];
		int min = array[0];
		int pares = 0;

		for (int num : array) {
			suma += num;
			if (num > max)
				max = num;
			if (num < min)
				min = num;
			if (num % 2 == 0)
				pares++;
		}

		double promedio = (double) suma / array.length;
		int impares = array.length - pares;

		System.out.println("\nEstadísticas:");
		System.out.println("  Suma: " + suma);
		System.out.println("  Promedio: " + String.format("%.1f", promedio));
		System.out.println("  Máximo: " + max);
		System.out.println("  Mínimo: " + min);
		System.out.println("  Pares: " + pares);
		System.out.println("  Impares: " + impares);
	}
}