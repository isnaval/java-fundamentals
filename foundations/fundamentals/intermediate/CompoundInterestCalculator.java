package fundamentals.intermediate;

import java.util.Locale;
import java.util.Scanner;

public class CompoundInterestCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// añadimos esto para poder usar , en lugar de . en decimales
		scanner.useLocale(Locale.US);
		System.out.println("=== CALCULADORA DE INTERÉS COMPUESTO ===\n");
		System.out.print("Ingrese la cantidad principal: ");
		double principal = scanner.nextDouble();
		System.out.print("Ingrese la tasa de interés anual (en %): ");
		double tasaInteres = scanner.nextDouble();
		double tasaDecimal = tasaInteres / 100;
		System.out.print("Ingrese el número de años: ");
		int años = scanner.nextInt();
		System.out.print("Ingrese la frecuencia de capitalización por año: ");
		System.out.println("(1=Anual, 2=Semestral, 4=Trimestral, 12=Mensual, 365=Diario)");
		int frecuencia = scanner.nextInt();

		double montoFinal = calcularInteresCompuesto(principal, tasaDecimal, frecuencia, años);
		double interesGanado = montoFinal - principal;

		System.out.println("\n=== RESULTADOS ===");
		System.out.printf("Capital inicial: %.2f €%n", principal);
		System.out.printf("Tasa de interés: %.2f%%%n", tasaInteres);
		System.out.println("Período: " + años + " años");
		System.out.println("Capitalización: " + obtenerFrecuenciaTexto(frecuencia));
		System.out.println("------------------------");
		System.out.printf("Capital inicial: %.2f €%n", principal);
		System.out.printf("Monto final: %.2f €%n", montoFinal);
		System.out.printf("Interés ganado: %.2f €%n", interesGanado);

		System.out.println("\n=== PROYECCIÓN ANUAL ===");
		mostrarProyeccionAnual(principal, tasaDecimal, frecuencia, años);

		scanner.close();

	}

	public static void mostrarProyeccionAnual(double principal, double tasa, int frecuencia, int años) {
		System.out.println("Año\tMonto\t\tInterés del año");
		System.out.println("---\t-----\t\t---------------");

		double montoAnterior = principal;

		for (int año = 1; año <= años; año++) {
			double montoActual = calcularInteresCompuesto(principal, tasa, frecuencia, año);
			double interesAnual = montoActual - montoAnterior;

			System.out.printf("%d\t€ %,.2f\t\t€ %,.2f%n", año, montoActual, interesAnual);
			montoAnterior = montoActual;
		}
	}

	private static String obtenerFrecuenciaTexto(int frecuencia) {
		switch (frecuencia) {
		case 1:
			return "Anual";
		case 2:
			return "Semestral";
		case 4:
			return "Trimestral";
		case 12:
			return "Mensual";
		case 365:
			return "Diaria";
		default:
			return frecuencia + " veces al año";
		}
	}

	public static double calcularInteresCompuesto(double principal, double tasa, int frecuencia, int años) {
		return principal * Math.pow(1 + tasa / frecuencia, frecuencia + años);
	}

}
