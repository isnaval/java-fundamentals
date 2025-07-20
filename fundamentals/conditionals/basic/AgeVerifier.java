package fundamentals.conditionals.basic;

import java.util.Scanner;

public class AgeVerifier {

	private static final int CHILD_MAX_AGE = 12;
	private static final int TEEN_MAX_AGE = 17;
	private static final int ADULT_MIN_AGE = 18;
	private static final int SENIOR_MIN_AGE = 65;
	private static final int MAX_VALID_AGE = 120;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== VERIFICADOR DE EDAD ===");
		System.out.println("Este programa determina tu categoría de edad\n");

		System.out.print("Por favor, ingrese su edad: ");
		int age = scanner.nextInt();

		if (age < 0) {
			System.out.println("\nError: La edad no puede ser negativa");
		} else if (age > MAX_VALID_AGE) {
			System.out.println("\nError: La edad ingresada no es válida");
		} else {
			System.out.println("\n--- RESULTADO ---");
			System.out.println("Edad: " + age + " años");

			if (age <= CHILD_MAX_AGE) {
				System.out.println("Categoría: NIÑO/A");
				System.out.println("✓ Acceso a área infantil");
				System.out.println("✓ Descuento en entradas: 50%");
				System.out.println("✗ No puede ver películas PG-13");
			} else if (age <= TEEN_MAX_AGE) {
				System.out.println("Categoría: ADOLESCENTE");
				System.out.println("✓ Acceso a área juvenil");
				System.out.println("✓ Descuento en entradas: 25%");
				System.out.println("✓ Puede ver películas PG-13");
				System.out.println("✗ No puede ver películas R");

				int yearsToAdult = ADULT_MIN_AGE - age;
				System.out.println("\nSerás mayor de edad en " + yearsToAdult + " año(s)");
			} else if (age < SENIOR_MIN_AGE) {
				System.out.println("Categoría: ADULTO");
				System.out.println("✓ Acceso completo");
				System.out.println("✓ Puede ver todas las películas");
				System.out.println("✓ Puede votar y conducir");

				if (age >= 21) {
					System.out.println("✓ Edad legal en todos los países");
				}
			} else {
				System.out.println("Categoría: ADULTO MAYOR");
				System.out.println("✓ Acceso completo");
				System.out.println("✓ Descuento tercera edad: 30%");
				System.out.println("✓ Acceso prioritario");
				System.out.println("✓ Beneficios especiales");
			}

			System.out.println("\n--- MAYORÍA DE EDAD ---");
			if (age >= ADULT_MIN_AGE) {
				System.out.println("✓ Es mayor de edad");
				System.out.println("Años siendo mayor de edad: " + (age - ADULT_MIN_AGE));
			} else {
				System.out.println("✗ Es menor de edad");
				System.out.println("Años para la mayoría de edad: " + (ADULT_MIN_AGE - age));
			}
		}

		scanner.close();
	}
}