package java_core_basic.basic_algorithms.armstrong_numbers;

public class Armstrong {

	public static boolean check(int number) {
		if (number < 0)
			return false;
		int original = number;
		int digits = String.valueOf(number).length();
		int sum = 0;
		while (number > 0) {
			int digit = number % 10;
			sum += Math.pow(digit, digits);
			number /= 10;
		}
		return sum == original;
	}

	public static void showRange(int start, int end) {
		System.out.println("Números Armstrong entre " + start + " y " + end + ": ");
		for (int i = start; i <= end; i++) {
			if (check(i)) {
				System.out.println(i);
			}
		}
	}

}
