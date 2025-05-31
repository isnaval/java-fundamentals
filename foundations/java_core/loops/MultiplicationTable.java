package java_core.loops;

import java.util.Scanner;

public class MultiplicationTable {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese un número. Le devolveré la tabla de multiplicar de ese número: ");
		int num = scanner.nextInt();

		System.out.println("La tabla de multiplicar de: " + num);

		for (int i = 0; i <= 10; i++) {
			System.out.println(num + " x " + i + " = " + (num * i));
		}

	}

}
