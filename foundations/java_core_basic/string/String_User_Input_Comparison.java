package java_core_basic.string;

import java.util.Scanner;

public class String_User_Input_Comparison {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Dime la primera cadena: ");
		String chain01 = scanner.nextLine();
		System.out.println("Dime la segunda cadena: ");
		String chain02 = scanner.nextLine();
		scanner.close();

		boolean chainComparison = (chain01 == chain02);
		System.out.println("Las dos cadena son iguales: (==) " + chainComparison);

		boolean chainComparison2 = chain01.equals(chain02);
		System.out.println("Las dos cadenas son iguales (equals): " + chainComparison2);

		boolean chainComparison3 = chain01.equalsIgnoreCase(chain02);
		System.out.println("Las dos cadenas son iguales (ignoreCase): " + chainComparison3);

	}

}
