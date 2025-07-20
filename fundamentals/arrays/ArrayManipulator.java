package fundamentals.arrays;

import java.util.Arrays;

public class ArrayManipulator {
	public static void main(String[] args) {
		String[] original = { "o", "d", "i", "u", "g", "e", "s", "n", "o", "c" };
		String[] reversed = reverseArray(original);
		System.out.println("Original: " + Arrays.toString(original));
		System.out.println("Reverse:  " + Arrays.toString(reversed));
		System.out.println("=======================================");

		String[] months = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre" };
		System.out.println("Original: " + Arrays.toString(months));
		String longest = findLongestString(months);
		System.out.println("Mes más largo: " + longest);
		System.out.println("=======================================");

		int[] numbers1 = { 45, 12, 78, 23, 56 };
		int[] numbers2 = { 12, 23, 45, 56, 78 };
		System.out.println("Original numbers1: " + Arrays.toString(numbers1));
		System.out.println("Original numbers2: " + Arrays.toString(numbers2));
		boolean areEqual = sortAndCompare(numbers1, numbers2);
		System.out.println("¿Son iguales? " + areEqual);
	}

	public static String[] reverseArray(String[] array) {
		String[] reversed = new String[array.length];
		for (int i = 0; i < array.length; i++) {
			reversed[i] = array[array.length - i - 1];
		}
		return reversed;
	}

	public static String findLongestString(String[] array) {
		String longest = array[0];
		for (String current : array) {
			if (current.length() > longest.length()) {
				longest = current;
			}
		}
		return longest;
	}

	public static boolean sortAndCompare(int[] array1, int[] array2) {
		int[] copy1 = Arrays.copyOf(array1, array1.length);
		int[] copy2 = Arrays.copyOf(array2, array2.length);
		Arrays.sort(copy1);
		Arrays.sort(copy2);
		return Arrays.equals(copy1, copy2);
	}

}
