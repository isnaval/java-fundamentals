package java_core.arrays;

public class ArrayMaxMinFinder {
	public static void main(String[] args) {
		int[] numbers = { 12, 1, 89, 3, 90, 34, 89, 32, 12, 0, 8, 45, 22, 56 };
		System.out.println("=== BUSCADOR DE MÁXIMO Y MÍNIMO ===");
		System.out.println("Listado de arrays: ");
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}

		System.out.println("\n-------------------------------------");
		int maxNumber = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] > maxNumber) {
				maxNumber = numbers[i];
			}
		}
		System.out.println("El numero mas alto: " + maxNumber);

		int minNumber = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] < maxNumber) {
				minNumber = numbers[i];
			}
		}
		System.out.println("El numero mas bajo: " + minNumber);

	}

}
