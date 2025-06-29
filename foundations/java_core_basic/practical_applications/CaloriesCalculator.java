package java_core_basic.practical_applications;

import java.util.Scanner;

public class CaloriesCalculator {

	private static final double CALORIES_PER_GRAM_FAT = 9.0;
	private static final double CALORIES_PER_GRAM_PROTEIN = 4.0;
	private static final double CALORIES_PER_GRAM_CARBS = 4.0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=== CALCULADORA DE CALORÍAS ===\n");
		System.out.println("1. Calcular calorías de un alimento");
		System.out.println("2. Ejemplo: Arroz a la cubana");
		System.out.print("Seleccione una opción: ");
		int opcion = scanner.nextInt();
		if (opcion == 1) {
			calcularCaloriasPersonalizado(scanner);
		} else if (opcion == 2) {
			ejemploArrozCubana();
		} else {
			System.out.println("Opción no válida.");
		}
		scanner.close();
	}

	public static void calcularCaloriasPersonalizado(Scanner scanner) {
		System.out.println("\nIngrese los gramos por cada 100g del alimento:");

		System.out.print("Grasas (g): ");
		double grasas = scanner.nextDouble();

		System.out.print("Proteínas (g): ");
		double proteinas = scanner.nextDouble();

		System.out.print("Carbohidratos (g): ");
		double carbohidratos = scanner.nextDouble();

		double caloriasGrasas = grasas * CALORIES_PER_GRAM_FAT;
		double caloriasProteinas = proteinas * CALORIES_PER_GRAM_PROTEIN;
		double caloriasCarbohidratos = carbohidratos * CALORIES_PER_GRAM_CARBS;
		double totalCalorias = caloriasGrasas + caloriasProteinas + caloriasCarbohidratos;

		mostrarResultados(caloriasGrasas, caloriasProteinas, caloriasCarbohidratos, totalCalorias);
	}

	public static void ejemploArrozCubana() {
		double[] grasas = { 0.1, 2.5, 0.3 };
		double[] proteinas = { 0.9, 2.0, 4.0 };
		double[] carbohidratos = { 19.8, 2.0, 47.5 };

		double caloriasGrasas = calcularCalorias(grasas, CALORIES_PER_GRAM_FAT);
		double caloriasProteinas = calcularCalorias(proteinas, CALORIES_PER_GRAM_PROTEIN);
		double caloriasCarbohidratos = calcularCalorias(carbohidratos, CALORIES_PER_GRAM_CARBS);
		double totalCalorias = caloriasGrasas + caloriasProteinas + caloriasCarbohidratos;

		System.out.println("\nPor 100 gramos de arroz a la cubana");
		mostrarResultados(caloriasGrasas, caloriasProteinas, caloriasCarbohidratos, totalCalorias);
	}

	public static double calcularCalorias(double[] gramos, double caloriasPorGramo) {
		double total = 0;
		for (double g : gramos) {
			total += g;
		}
		return total * caloriasPorGramo;
	}

	public static void mostrarResultados(double caloriasGrasas, double caloriasProteinas, double caloriasCarbohidratos,
			double totalCalorias) {
		System.out.println("==========================");
		System.out.println("Grasas: " + caloriasGrasas + " Kcal");
		System.out.println("Proteínas: " + caloriasProteinas + " Kcal");
		System.out.println("Carbohidratos: " + caloriasCarbohidratos + " Kcal");
		System.out.println("==========================");
		System.out.println("Calorías Totales: " + totalCalorias + " Kcal");
	}

}
