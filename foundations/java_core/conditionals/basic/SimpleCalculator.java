package java_core.conditionals.basic;

import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== CALCULADORA SIMPLE ===");
		System.out.println("Operaciones disponibles:");
		System.out.println("  + : Suma");
		System.out.println("  - : Resta");
		System.out.println("  * : Multiplicación");
		System.out.println("  / : División");
		System.out.println("  % : Módulo (resto)");
		System.out.println("  ^ : Potencia\n");

		System.out.print("Ingrese el primer número: ");
		double num1 = scanner.nextDouble();

		System.out.print("Ingrese el segundo número: ");
		double num2 = scanner.nextDouble();

		scanner.nextLine();

		System.out.print("Ingrese la operación (+, -, *, /, %, ^): ");
		String operation = scanner.nextLine().trim();

		double result = 0;
		boolean validOperation = true;
		String operationName = "";

		switch (operation) {
		case "+":
			result = num1 + num2;
			operationName = "Suma";
			break;

		case "-":
			result = num1 - num2;
			operationName = "Resta";
			break;

		case "*":
			result = num1 * num2;
			operationName = "Multiplicación";
			break;

		case "/":
			operationName = "División";
			if (num2 == 0) {
				System.out.println("\n❌ Error: No se puede dividir por cero");
				validOperation = false;
			} else {
				result = num1 / num2;
			}
			break;

		case "%":
			operationName = "Módulo";
			if (num2 == 0) {
				System.out.println("\n❌ Error: No se puede calcular módulo con divisor cero");
				validOperation = false;
			} else {
				result = num1 % num2;
			}
			break;

		case "^":
			result = Math.pow(num1, num2);
			operationName = "Potencia";
			break;

		default:
			System.out.println("\n❌ Error: Operación no válida");
			validOperation = false;
		}

		if (validOperation) {
			System.out.println("\n--- RESULTADO ---");
			System.out.println("Operación: " + operationName);
			System.out.println(num1 + " " + operation + " " + num2 + " = " + result);

			if (result > 0) {
				System.out.println("El resultado es positivo");
			} else if (result < 0) {
				System.out.println("El resultado es negativo");
			} else {
				System.out.println("El resultado es cero");
			}

			if (operation.equals("/") && num2 != 0) {
				if (num1 % num2 == 0) {
					System.out.println("La división es exacta");
				} else {
					System.out.println("La división no es exacta");
					System.out.println("Parte entera: " + (int) (num1 / num2));
					System.out.println("Resto: " + (num1 % num2));
				}
			}
		}

		System.out.print("\n¿Desea realizar otro cálculo? (s/n): ");
		String continuar = scanner.nextLine();

		if (continuar.equalsIgnoreCase("s")) {
			System.out.println("\nPor favor, ejecute el programa nuevamente.");
		} else {
			System.out.println("\n¡Gracias por usar la calculadora!");
		}

		scanner.close();
	}
}