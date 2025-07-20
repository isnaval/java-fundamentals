package fundamentals.loops;

import java.util.Scanner;

public class SumaMethodsDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ejericio de sumas con metodo while, do-while, for");
		System.out.println("Dime un número");
		int number1 = scanner.nextInt();
		System.out.println("Dime otro número");
		int number2 = scanner.nextInt();

		System.out.println("\n=== RESULTADOS ===");
		verificacionNumbers(number1, number2);
		whileMethod(number1, number2);
		doWhileMethod(number1, number2);
		forMethdo(number1, number2);

		scanner.close();

	}

	public static void verificacionNumbers(int number1, int number2) {
		if (number2 > number1) {
			System.out.println("El segundo número debe ser menor o igual al primero ");
			System.out.println("Proceso a cambiar el orden de los números");
			int temp = number1;
			number1 = number2;
			number2 = temp;
		}

	};

	public static void whileMethod(int number1, int number2) {
		int suma = 0;
		int i = number1;
		while (i <= number2) {
			suma += i;
			i++;
		}

		System.out.println("- Suma con método while: " + suma);

	};

	public static void doWhileMethod(int number1, int number2) {
		int suma = 0;
		int i = number1;

		do {
			suma += i;
			i++;
		} while (i <= number2);

		System.out.println("- Suma con método do-while: " + suma);

	};

	public static void forMethdo(int number1, int number2) {
		int suma = 0;
		for (int i = number1; i <= number2; i++) {
			suma += i;
		}

		System.out.println("- Suma con método for: " + suma);

	};

}
