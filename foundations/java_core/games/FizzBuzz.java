package java_core.games;

public class FizzBuzz {
	public static void main(String[] args) {
		System.out.println("=== FIZZBUZZ (1-100) ===");

		for (int i = 1; i <= 100; i++) {
			if (i % 15 == 0) {
				System.out.println("Para el número " + i + " FizzBuzz");
			} else if (i % 3 == 0) {
				System.out.println("Para el número " + i + " Fizz");
			} else {
				System.out.println("Para el número " + i + " Buzz");
			}
		}
	}
}
