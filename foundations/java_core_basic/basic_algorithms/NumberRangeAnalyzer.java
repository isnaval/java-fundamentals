package java_core_basic.basic_algorithms;

import java.util.Scanner;

public class NumberRangeAnalyzer {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=== ANALIZADOR DE RANGO DE NÚMEROS ===\n");
		System.out.print("Dime el valor inicial: ");
		int numberInicial = scanner.nextInt();
		System.out.print("Dime el valor final: ");
		int numberFinal = scanner.nextInt();
		if (numberInicial > numberFinal) {
			System.out.println("\nError: El número inicial debe ser menor o igual al número final.");
			scanner.close();
			return;
		}
		calcularSumas(numberInicial, numberFinal);
		scanner.close();
	}

	public static void calcularSumas(int inicio, int fin) {
		int sumaPares = 0;
		int sumaImpares = 0;
		int contadorPares = 0;
		int contadorImpares = 0;

		System.out.println("\nAnalizando números del " + inicio + " al " + fin + "...\n");

		System.out.print("Números pares: ");
		for (int i = inicio; i <= fin; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
				sumaPares += i;
				contadorPares++;
			}
		}

		System.out.print("\nNúmeros impares: ");
		for (int i = inicio; i <= fin; i++) {
			if (i % 2 != 0) {
				System.out.print(i + " ");
				sumaImpares += i;
				contadorImpares++;
			}
		}

		System.out.println("\n\n=== RESULTADOS ===");
		System.out.println("Suma de números pares: " + sumaPares);
		System.out.println("Suma de números impares: " + sumaImpares);
		System.out.println("\nCantidad de números pares: " + contadorPares);
		System.out.println("Cantidad de números impares: " + contadorImpares);

		if (contadorPares > 0) {
			double promedioPares = (double) sumaPares / contadorPares;
			System.out.println("\nPromedio de pares: " + String.format("%.2f", promedioPares));
		}

		if (contadorImpares > 0) {
			double promedioImpares = (double) sumaImpares / contadorImpares;
			System.out.println("Promedio de impares: " + String.format("%.2f", promedioImpares));
		}

		System.out.println("\nSuma total: " + (sumaPares + sumaImpares));
	}
}
