package java_core_basic;

import java.util.Arrays;
import java.util.Scanner;

public class Basic_Scanner {

	public static void main(String[] args) {

		Ejercicio01();
		Ejercicio02();
	}

	/**
	 * Ejercicio: Escribe un programa en Java que solicite al usuario tres números
	 * enteros y que calcule la media de los tres números y cual de ellos es el
	 * mayor imprimiendo el resultado de las operaciones por pantalla.instanciar la
	 * clase scanner para solicitar la entrada de datos al usuario
	 */

	@SuppressWarnings("resource")
	public static void Ejercicio01() {
		System.out.println("=== EJERCICIO 1 ===");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingreses tres numeros para calcular la media");
		double numero1 = scanner.nextInt();
		double numero2 = scanner.nextInt();
		double numero3 = scanner.nextInt();
		double media = (numero1 + numero2 + numero3) / 3;

		System.out.println("La media de los tres numeros es: " + media);

	}

	/**
	 * Ejercicio: ordena los tres numeros y sacalo por consola
	 */

	@SuppressWarnings({ "resource", "unused" })
	public static void Ejercicio02() {
		System.out.println("=== EJERCICIO 2 ===");
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ingresa 5 numeros para ordenarlos de menor a mayor");
		double[] numeros = new double[5];
		for (int i = 0; i < 5; i++) {
			System.out.println("Número " + (i + 1) + ": ");
			numeros[i] = scanner.nextDouble();
		}

		Arrays.sort(numeros);

		System.out.println("Los números ordenados de menor a mayor son: ");
		System.out.println(Arrays.toString(numeros));
	}

}
