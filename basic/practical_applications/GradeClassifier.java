package basic.practical_applications;

import java.util.Scanner;

public class GradeClassifier {
	static final String[] QUALIFICATIONS = { "Suspenso", "Aprobado", "Bien", "Notable", "Sobresaliente",
			"Matrícula de Honor" };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=== CLASIFICADOR DE NOTAS ===\n");
		System.out.println("1. Clasificar notas predefinidas");
		System.out.println("2. Ingresar notas manualmente");
		System.out.print("Seleccione una opción: ");
		int opcion = scanner.nextInt();
		if (opcion == 1) {
			clasificarNotasPredefinidas();
		} else if (opcion == 2) {
			clasificarNotasManual(scanner);
		} else {
			System.out.println("Opción no válida.");
		}
		scanner.close();
	}

	public static void clasificarNotasPredefinidas() {
		double[] notas = { 4.5, 1.0, 5.0, 7.3, 6.8, 9.0, 9.5, 5.8, 7.4, 3.4, 7.8, 8.2, 3.4, 9.2 };
		System.out.println("\nNotas a clasificar:");
		for (double nota : notas) {
			System.out.print(nota + " ");
		}
		System.out.println("\n");
		procesarNotas(notas);
	}

	public static void clasificarNotasManual(Scanner scanner) {
		System.out.print("\n¿Cuántas notas desea ingresar? ");
		int cantidad = scanner.nextInt();
		double[] notas = new double[cantidad];
		System.out.println("Ingrese las notas (0.0 - 10.0):");
		for (int i = 0; i < cantidad; i++) {
			System.out.print("Nota " + (i + 1) + ": ");
			notas[i] = scanner.nextDouble();
		}
		System.out.println();
		procesarNotas(notas);
	}

	public static void procesarNotas(double[] notas) {
		int[] contadores = new int[QUALIFICATIONS.length];
		System.out.println("CLASIFICACIÓN DETALLADA:");
		System.out.println("------------------------");
		for (double nota : notas) {
			String clasificacion = clasificar(nota);
			int indice = obtenerIndice(clasificacion);
			contadores[indice]++;
			System.out.printf("%.1f → %s%n", nota, clasificacion);
		}
		System.out.println("\nRESUMEN:");
		System.out.println("------------------------");
		for (int i = 0; i < QUALIFICATIONS.length; i++) {
			if (contadores[i] > 0) {
				System.out.println(QUALIFICATIONS[i] + ": " + contadores[i]);
			}
		}
		mostrarEstadisticas(notas, contadores);
	}

	public static String clasificar(double nota) {
		if (nota >= 9.0) {
			return QUALIFICATIONS[5];
		} else if (nota >= 8.0) {
			return QUALIFICATIONS[4];
		} else if (nota >= 7.0) {
			return QUALIFICATIONS[3];
		} else if (nota >= 6.0) {
			return QUALIFICATIONS[2];
		} else if (nota >= 5.0) {
			return QUALIFICATIONS[1];
		} else {
			return QUALIFICATIONS[0];
		}
	}

	public static int obtenerIndice(String calificacion) {
		for (int i = 0; i < QUALIFICATIONS.length; i++) {
			if (calificacion.equals(QUALIFICATIONS[i])) {
				return i;
			}
		}
		return 0;
	}

	public static void mostrarEstadisticas(double[] notas, int[] contadores) {
		System.out.println("\nESTADÍSTICAS:");
		System.out.println("------------------------");
		int totalAprobados = 0;
		int totalSuspensos = contadores[0];
		double sumaNotas = 0;
		double notaMaxima = notas[0];
		double notaMinima = notas[0];
		for (int i = 1; i < contadores.length; i++) {
			totalAprobados += contadores[i];
		}
		for (double nota : notas) {
			sumaNotas += nota;
			if (nota > notaMaxima)
				notaMaxima = nota;
			if (nota < notaMinima)
				notaMinima = nota;
		}
		double promedio = sumaNotas / notas.length;
		double porcentajeAprobados = (double) totalAprobados / notas.length * 100;
		System.out.printf("Total de alumnos: %d%n", notas.length);
		System.out.printf("Aprobados: %d (%.1f%%)%n", totalAprobados, porcentajeAprobados);
		System.out.printf("Suspensos: %d (%.1f%%)%n", totalSuspensos, 100 - porcentajeAprobados);
		System.out.printf("Nota promedio: %.2f%n", promedio);
		System.out.printf("Nota máxima: %.1f%n", notaMaxima);
		System.out.printf("Nota mínima: %.1f%n", notaMinima);
	}

}
