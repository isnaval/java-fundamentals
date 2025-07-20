package fundamentals.arrays;

import java.util.Scanner;

public class RangeProcessor {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Dime el primer número de un rango: ");
		int number01 = scanner.nextInt();
		System.out.println("Dime el segundo número de un rango: ");
		int number02 = scanner.nextInt();
		scanner.close();

		if (number01 > number02) {
			System.out.println(
					"El primer numero debe ser menor que el segundo para un rango correcto. Vuelve a introducirlos.");
			return;
		}

		System.out.println(" === Voy a generar un array e imprimir todos los numeros en el rango que me has dado ===");
		int[] numbers = new int[number02 - number01 + 1];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = number01 + i;
			System.out.print(numbers[i] + " ");
		}

		System.out.println(" \n === Voy a generar un nuevo array con el cuadrado de los pares del array anterior === ");

		// necesito contar los numeros pares que hay en el array numbers
		int countEvenNumbers = 0;
		for (int num : numbers) {
			if (num % 2 == 0) {
				countEvenNumbers++;
			}
		}

		int[] evenSquareNumbers = new int[countEvenNumbers];
		int index = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] % 2 == 0) {
				evenSquareNumbers[index] = numbers[i] * numbers[i];
				System.out.print(evenSquareNumbers[index] + " ");
				index++;
			}

		}

		System.out.println(
				" \n === Voy a generar un nuevo array con el cuadrado de los numeros impares del array numbers ==");

		int countOddNumbers = 0;
		for (int num : numbers) {
			if (num % 2 != 0) {
				countOddNumbers++;
			}
		}

		int[] oddSquareNumbers = new int[countOddNumbers];
		int index2 = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] % 2 != 0) {
				oddSquareNumbers[index2] = numbers[i] * numbers[i];
				System.out.print(oddSquareNumbers[index2] + " ");
				index2++;

			}
		}

	}
}
