package exceptions.basic_exception_handling;

public class Utils {

	public static double divide(double numerator, double denominador) {
		if (denominador == 0) {
			throw new ArithmeticException("Cannot divide by zero");
		}
		return numerator / denominador;
	}

	public static int add(int value1, int value2) {
		long result = (long) value1 + value2;

		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			throw new ArithmeticException("Integer overflow detected in addition");
		}
		return (int) result;
	}

	public static double squareRoot(double value) {
		if (value < 0) {
			throw new ArithmeticException("Cannot calculate square root of negative number: " + value);
		}
		return Math.sqrt(value);
	};

	public static String getWeekdayByIndex(int index) {
		final String[] weekdays = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
		if (index < 0 || index >= weekdays.length) {
			throw new ArrayIndexOutOfBoundsException("Invalid weekday index: " + index + ". Must be between 0-6");
		}
		return weekdays[index];
	}

	public static long factorial(int n) {
		if (n < 0) {
			throw new ArithmeticException("Factorial is not defined for negative numbers: " + n);
		}
		if (n > 20) {
			throw new ArithmeticException("Factorial too large for long data type: " + n);
		}
		long result = 1;
		for (int i = 2; i <= n; i++) {
			result *= i;
		}
		return result;
	}

	public static int parseInteger(String str) {
		if (str == null) {
			throw new NullPointerException("Cannot parse null string");
		}
		try {
			return Integer.parseInt(str.trim());
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Invalid integer format: '" + str + "'");
		}
	}
}
