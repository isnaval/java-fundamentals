package basic.basic_operations;

import java.util.Scanner;

public class StatisticsCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=== CALCULAR DE ESTADISTICA ===");
		System.out.println("Introduce el número de valores: ");
		int numValues = scanner.nextInt();
		if (numValues <= 0) {
			System.out.println("El numero de valores debe ser mayor que cero.");
			scanner.close();
			return;
		}

		double suma = 0;
		double maximo = Double.MIN_NORMAL;
		double minimo = Double.MAX_VALUE;
		System.out.println("\nIngres los valores: ");

		for (int i = 0; i < numValues; i++) {
			System.out.print("Valor " + (i + 1) + ": ");
			double numero = scanner.nextDouble();
			suma += numero;
			if (numero > maximo) {
				maximo = numero;
			}
			if (numero < minimo) {
				minimo = numero;
			}
		}

		double media = suma / numValues;
		System.out.println("\n=== RESULTADOS ===");
		System.out.println("Suma: " + suma);
		System.out.println("Máximo: " + maximo);
		System.out.println("Mínimo: " + minimo);
		System.out.println("Media: " + String.format("%.2f", media));
		scanner.close();

	}

}
