package fundamentals.arrays;

import java.util.Random;
import java.util.Scanner;

public class ConditionalArrayFilter {

	public static final int MIN_VALUE = 1;
	public static final int MAX_VALUE = 50;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese el tamaño del array: ");
		int arraySize = scanner.nextInt();
		scanner.close();

		if (arraySize < 1 || arraySize > 50) {
			System.out.println("Los numeros deben estar comprendidos entre 1 y 50");
			return;
		}

		int[] numbers = generateRandomNumbers(arraySize);
		System.out.println("\nListado de numeros creado");

		int eventCount = 0;
		int oddCount = 0;
		int[] evenNumbers = new int[arraySize];
		int[] oddNumbers = new int[arraySize];

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] % 2 == 0) {
				evenNumbers[eventCount] = numbers[i];
				eventCount++;
			}

			if (numbers[i] % 2 != 0) {
				oddNumbers[oddCount] = numbers[i];
				oddCount++;
			}
		}
		System.out.println("\n=== RESULTADOS DEL FILTRADO ===");
		System.out.print("Listado números pares: ");
		displayArray(evenNumbers, eventCount);
		System.out.println();
		System.out.print("Listado números impares: ");
		displayArray(oddNumbers, oddCount);
		System.out.println();
		printStatistics(arraySize, eventCount, oddCount);
		System.out.println();

	}

	private static int[] generateRandomNumbers(int size) {
		Random random = new Random();
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;

		}
		return array;
	}

	private static void displayArray(int[] array, int count) {
		System.out.print("[");
		for (int i = 0; i < count; i++) {
			System.out.print(array[i]);
			if (i < count - 1) {
				System.out.print(", ");
			}

		}
		System.out.print("]");
	}

	private static void printStatistics(int totalNumbers, int evenCount, int oddCount) {
		System.out.println("\n=== ESTADÍSTICAS ===");
		System.out.println("Total de números: " + totalNumbers);
		System.out.println("Números pares: " + evenCount);
		System.out.println("Números impares: " + oddCount);
	}

}
