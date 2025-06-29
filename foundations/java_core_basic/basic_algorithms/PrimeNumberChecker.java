package java_core_basic.basic_algorithms;

import java.util.Scanner;

public class PrimeNumberChecker {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=== VERIFICADOR DE NÚMEROS PRIMOS ===\n");
		System.out.println("1. Verificar un número");
		System.out.println("2. Mostrar primos en un rango");
		System.out.print("Seleccione una opción: ");
		int opcion = scanner.nextInt();
		int contador = 0;

		if (opcion == 1) {
			System.out.print("\nIngrese un número para verificar si es primo: ");
			int numero = scanner.nextInt();
			if (isPrimo(numero)) {
				System.out.println(numero + " es un número primo.");
			} else {
				System.out.println(numero + " no es un número primo.");
			}

		} else if (opcion == 2) {
			System.out.print("\nIngrese el número inicial: ");
			int inicio = scanner.nextInt();
			System.out.print("Ingrese el número final: ");
			int fin = scanner.nextInt();
			System.out.println("\nNúmeros primos entre " + inicio + " y " + fin + ":");
			for (int i = inicio; i <= fin; i++) {
				if (isPrimo(i)) {
					System.out.print(i + " - ");
					contador++;
				}
			}

		} else {
			System.out.print("\nIngrese una opción correcta, por favor. ");

		}
		System.out.println("\nTotal: " + contador + " números primos");
		scanner.close();
	}

	private static boolean isPrimo(int n) {
		if (n < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
