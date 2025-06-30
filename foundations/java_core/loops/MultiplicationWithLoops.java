package java_core.loops;

import java.util.Scanner;

public class MultiplicationWithLoops {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== MULTIPLICACIÓN USANDO BUCLES ===\n");

		System.out.println("1. Multiplicar dos números");
		System.out.println("2. Ejemplo: 1298 x 678");
		System.out.println("3. Tabla de multiplicar");
		System.out.print("Seleccione una opción: ");

		int opcion = scanner.nextInt();

		switch (opcion) {
		case 1:
			multiplicarPersonalizado(scanner);
			break;
		case 2:
			ejemploMultiplicacion();
			break;
		case 3:
			tablaMultiplicar(scanner);
			break;
		default:
			System.out.println("Opción no válida");
		}

		scanner.close();
	}

	public static void multiplicarPersonalizado(Scanner scanner) {
		System.out.print("\nIngrese el primer número: ");
		int numero1 = scanner.nextInt();
		System.out.print("Ingrese el segundo número: ");
		int numero2 = scanner.nextInt();
		int resultado = multiplicar(numero1, numero2);
		System.out.println("\nResultado: " + numero1 + " x " + numero2 + " = " + resultado);
		System.out.println("\nProceso paso a paso:");
		mostrarProceso(numero1, numero2);
	}

	private static void mostrarProceso(int a, int b) {
		int suma = 0;
		for (int i = 1; i <= Math.min(5, Math.abs(a)); i++) {
			suma += b;
			System.out.println("Paso " + i + ": " + suma + " (sumando " + b + ")");
		}
		if (Math.abs(a) > 5) {
			System.out.println("... (" + (Math.abs(a) - 5) + " pasos más)");
		}
	}

	public static void ejemploMultiplicacion() {
		int numero1 = 1298;
		int numero2 = 678;
		System.out.println("\nCalculando " + numero1 + " x " + numero2);
		int resultado = 0;
		int i = 0;
		while (i < numero1) {
			resultado += numero2;
			i++;
		}
		System.out.println("Resultado: " + resultado);
		System.out.println("Verificación: " + (numero1 * numero2));
	}

	public static int multiplicar(int a, int b) {
		int resultado = 0;
		int contador = 0;
		while (contador < Math.abs(a)) {
			resultado += Math.abs(b);
			contador++;
		}
		if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
			resultado = -resultado;
		}
		return resultado;
	}

	private static void tablaMultiplicar(Scanner scanner) {
		System.out.print("\nIngrese un número para su tabla: ");
		int numero = scanner.nextInt();

		System.out.println("\nTabla del " + numero + ":");
		for (int i = 1; i <= 10; i++) {
			int resultado = 0;
			for (int j = 0; j < i; j++) {
				resultado += numero;
			}
			System.out.printf("%d x %2d = %3d%n", numero, i, resultado);
		}
	}

}
