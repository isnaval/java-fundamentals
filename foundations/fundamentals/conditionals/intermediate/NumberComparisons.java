package fundamentals.conditionals.intermediate;

import java.util.Scanner;

public class NumberComparisons {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== EJERCICIOS DE COMPARACIÓN DE NÚMEROS ===");
		System.out.println("1. Comparar igualdad de dos números");
		System.out.println("2. Verificar si un número es positivo o negativo");
		System.out.println("3. Comprobar si un número es múltiplo de otro");
		System.out.println("4. Comparar dos números y mostrar el mayor");
		System.out.println("5. Ordenar dos números de mayor a menor");
		System.out.println("6. Ordenar tres números de menor a mayor");
		System.out.print("Seleccione un ejercicio: ");

		try {
			int option = Integer.parseInt(scanner.nextLine());

			switch (option) {
			case 1:
				checkEquality(scanner);
				break;
			case 2:
				checkSign(scanner);
				break;
			case 3:
				checkMultiples(scanner);
				break;
			case 4:
				compareTwoNumbers(scanner);
				break;
			case 5:
				orderTwoNumbers(scanner);
				break;
			case 6:
				orderThreeNumbers(scanner);
				break;
			default:
				System.out.println("Opción no válida. Por favor, seleccione un número del 1 al 6.");
			}
		} catch (NumberFormatException e) {
			System.out.println("Error: Debe introducir un número válido.");
			System.out.println("Por favor, reinicie el programa e introduzca un número del 1 al 6.");
		} finally {
			scanner.close();
		}
	}

	private static void orderThreeNumbers(Scanner scanner) {
		System.out.print("Primer número: ");
		int n1 = Integer.parseInt(scanner.nextLine());
		System.out.print("Segundo número: ");
		int n2 = Integer.parseInt(scanner.nextLine());
		System.out.print("Tercer número: ");
		int n3 = Integer.parseInt(scanner.nextLine());

		if (n1 <= n2 && n1 <= n3) {
			if (n2 <= n3) {
				System.out.println("El orden de menor a mayor es: " + n1 + ", " + n2 + ", " + n3);
			} else {
				System.out.println("El orden de menor a mayor es: " + n1 + ", " + n3 + ", " + n2);
			}
		} else if (n2 <= n1 && n2 <= n3) {
			if (n1 <= n3) {
				System.out.println("El orden de menor a mayor es: " + n2 + ", " + n1 + ", " + n3);
			} else {
				System.out.println("El orden de menor a mayor es: " + n2 + ", " + n3 + ", " + n1);
			}
		} else {
			if (n1 <= n2) {
				System.out.println("El orden de menor a mayor es: " + n3 + ", " + n1 + ", " + n2);
			} else {
				System.out.println("El orden de menor a mayor es: " + n3 + ", " + n2 + ", " + n1);
			}
		}

	}

	private static void orderTwoNumbers(Scanner scanner) {
		System.out.print("Primer número: ");
		int n1 = Integer.parseInt(scanner.nextLine());
		System.out.print("Segundo número: ");
		int n2 = Integer.parseInt(scanner.nextLine());

		if (n1 < n2) {
			System.out.println("El orden de mayor a menor es: " + n2 + ", " + n1);
		} else if (n1 > n2) {
			System.out.println("El orden de mayor a menor es: " + n1 + ", " + n2);
		} else {
			System.out.println("Los números son iguales: " + n1 + ", " + n2);
		}
	}

	private static void compareTwoNumbers(Scanner scanner) {
		System.out.print("Primer número: ");
		double number01 = Double.parseDouble(scanner.nextLine());
		System.out.print("Segundo número: ");
		double number02 = Double.parseDouble(scanner.nextLine());

		if (number01 == number02) {
			System.out.println("Los números son iguales");
		} else if (number01 < number02) {
			System.out.println(number02 + " es mayor que " + number01);
		} else {
			System.out.println(number01 + " es mayor que " + number02);
		}
	}

	private static void checkMultiples(Scanner scanner) {
		System.out.println("Pimer número");
		double number01 = Double.parseDouble(scanner.nextLine());
		System.out.println("Segundo número");
		double number02 = Double.parseDouble(scanner.nextLine());

		if (number01 % number02 == 0) {
			System.out.println("El primer número es múltiplo del segundo");
		} else {
			System.out.println("Los números no son múltiplos");
		}

	}

	private static void checkSign(Scanner scanner) {
		System.out.println("Introduce un número: ");
		int number = Integer.parseInt(scanner.nextLine());

		if (number < 0) {
			System.out.println("El número es negativo");
		} else if (number > 0) {
			System.out.println("El número es positivo");
		} else {
			System.out.println("El número es cero");
		}

	}

	private static void checkEquality(Scanner scanner) {
		System.out.println("Primer numero: ");
		double number01 = Double.parseDouble(scanner.nextLine());
		System.out.println("Segundo numero: ");
		double number02 = Double.parseDouble(scanner.nextLine());

		if (number01 == number02) {
			System.out.println("Los dos números son iguales");
		} else {
			System.out.println("Los dos números no son iguales");
		}
	}

}
