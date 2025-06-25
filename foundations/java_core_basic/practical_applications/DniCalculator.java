package java_core_basic.practical_applications;

import java.util.Scanner;

public class DniCalculator {

	final static char[] DNI_LETTER = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S',
			'Q', 'V', 'H', 'L', 'C', 'K', 'E' };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Ingrese el número de DNI (sin letra): ");
		int dniNumber = scanner.nextInt();
		scanner.close();

		char dniLetter = calculateDniLetter(dniNumber);
		System.out.println("La letra del DNI es: " + dniLetter);
		System.out.println("DNI completo es: " + dniNumber + dniLetter);

	}

	private static char calculateDniLetter(int dniNumber) {
		int remainder = dniNumber % 23;
		return DNI_LETTER[remainder];
	}

}
