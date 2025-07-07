package exceptions.basic.examples;

public class MultipleCatch {
	public static void main(String[] args) {
		String[] numbers = { "10", "20", "abc", "30" };
		int[] divisors = { 2, 0, 5, 2 };

		for (int i = 0; i < 5; i++) {
			System.out.print("- OPERACIÓN: ");
			try {
				int number = Integer.parseInt(numbers[i]);
				int result = number / divisors[i];
				System.out.println(numbers[i] + " / " + divisors[i] + " = " + result);
			} catch (NumberFormatException e) {
				System.out.println("Error: '" + numbers[i] + "' no es un número válido");
			} catch (ArithmeticException e) {
				System.out.println("Error: No se puede dividir por cero");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Error: Índice fuera de rango");
			}
		}
	}

}
