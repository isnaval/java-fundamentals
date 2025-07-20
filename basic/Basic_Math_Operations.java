package basic;

import java.util.Scanner;

/**
 * Colección de ejercicios relacionados con operaciones matemáticas. Incluye
 * cálculos de área, ecuaciones y otras operaciones matemáticas.
 */

public class Basic_Math_Operations {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== EJERCICIOS DE OPERACIONES MATEMÁTICAS ===");
		System.out.println("1. Calcular el área de un círculo");
		System.out.println("2. Obtener coeficientes de una ecuación");
		System.out.print("Seleccione un ejercicio: ");

		int option = Integer.parseInt(scanner.nextLine());

		switch (option) {
		case 1:
			calculateCircleArea(scanner);
			break;
		case 2:
			getEquationCoefficients(scanner);
			break;
		default:
			System.out.println("Opción no válida");
		}

		scanner.close();
	}

	/**
	 * Calcula el área de un círculo dado su radio (Boletin02)
	 */
	public static void calculateCircleArea(Scanner scanner) {
		System.out.print("Introduzca el radio del círculo: ");
		double radius = Double.parseDouble(scanner.nextLine());

		double area = Math.PI * Math.pow(radius, 2);
		System.out.printf("El área del círculo es: %.2f\n", area);
	}

	/**
	 * Obtiene los coeficientes a, b, c de una ecuación (Boletin01)
	 */
	public static void getEquationCoefficients(Scanner scanner) {
		System.out.print("Introduzca el valor de a: ");
		double a = Double.parseDouble(scanner.nextLine());

		System.out.print("Introduzca el valor de b: ");
		double b = Double.parseDouble(scanner.nextLine());

		System.out.print("Introduzca el valor de c: ");
		double c = Double.parseDouble(scanner.nextLine());

		System.out.println("Los coeficientes de la ecuación son:");
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);

		if (a != 0) {
			double discriminant = b * b - 4 * a * c;
			if (discriminant >= 0) {
				double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
				double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
				System.out.println("Las soluciones de la ecuación cuadrática son:");
				System.out.println("x1 = " + x1);
				System.out.println("x2 = " + x2);
			} else {
				System.out.println("La ecuación no tiene soluciones reales");
			}
		}
	}
}
