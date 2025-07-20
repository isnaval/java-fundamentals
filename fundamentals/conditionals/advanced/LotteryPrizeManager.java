package fundamentals.conditionals.advanced;

import java.util.Scanner;

public class LotteryPrizeManager {

	private static final double TAX_FREE_LIMIT = 40000;
	private static final double TAX_RATE_LOW = 0.20;

	private static final int SMALL_PRIZE = 100;
	private static final int MEDIUM_PRIZE = 1000;
	private static final int LARGE_PRIZE = 10000;
	private static final int HUGE_PRIZE = 100000;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== GESTOR DE PREMIOS DE LOTERÍA ===");
		System.out.println("Analice y planifique el uso de su premio\n");

		System.out.print("Ingrese el importe del premio (€): ");
		double premioTotal = scanner.nextDouble();

		if (premioTotal <= 0) {
			System.out.println("No hay premio que gestionar. ¡Suerte la próxima vez!");
			scanner.close();
			return;
		}

		System.out.print("¿Cuántas personas comparten el premio? ");
		int participantes = scanner.nextInt();

		if (participantes <= 0) {
			System.out.println("Número de participantes no válido");
			scanner.close();
			return;
		}

		double premioPorPersona = premioTotal / participantes;

		System.out.println("\n=== ANÁLISIS DEL PREMIO ===");
		System.out.println("Premio total: " + formatMoney(premioTotal));
		System.out.println("Participantes: " + participantes);
		System.out.println("Premio por persona: " + formatMoney(premioPorPersona));

		double impuestos = calcularImpuestos(premioPorPersona);
		double netoIndividual = premioPorPersona - impuestos;

		System.out.println("\n--- IMPUESTOS ---");
		if (premioPorPersona <= TAX_FREE_LIMIT) {
			System.out.println("✓ Premio exento de impuestos");
			System.out.println("Importe neto: " + formatMoney(netoIndividual));
		} else {
			System.out.println("Base imponible: " + formatMoney(premioPorPersona - TAX_FREE_LIMIT));
			System.out.println("Impuestos (20%): " + formatMoney(impuestos));
			System.out.println("Importe neto: " + formatMoney(netoIndividual));

			double porcentajeNeto = (netoIndividual / premioPorPersona) * 100;
			System.out.println("Recibirás el " + String.format("%.1f%%", porcentajeNeto) + " del premio");
		}

		System.out.println("\n=== SUGERENCIAS DE USO ===");

		if (netoIndividual <= SMALL_PRIZE) {
			System.out.println("💰 Premio pequeño (" + formatMoney(netoIndividual) + ")");
			System.out.println("\nOpciones recomendadas:");
			System.out.println("• Una cena especial para celebrar");
			System.out.println("• Un pequeño capricho personal");
			System.out.println("• Añadirlo a tu hucha de ahorros");
			System.out.println("\nConsejo: Disfrútalo sin remordimientos");

		} else if (netoIndividual <= MEDIUM_PRIZE) {
			System.out.println("💰💰 Premio mediano (" + formatMoney(netoIndividual) + ")");
			System.out.println("\nDistribución sugerida:");
			double celebracion = netoIndividual * 0.2;
			double ahorro = netoIndividual * 0.5;
			double caprichos = netoIndividual * 0.3;

			System.out.println("• Celebración (20%): " + formatMoney(celebracion));
			System.out.println("• Ahorro (50%): " + formatMoney(ahorro));
			System.out.println("• Caprichos (30%): " + formatMoney(caprichos));
			System.out.println("\nIdeas:");
			System.out.println("- Un fin de semana de escapada");
			System.out.println("- Renovar algún electrodoméstico");
			System.out.println("- Iniciar un fondo de emergencia");

		} else if (netoIndividual <= LARGE_PRIZE) {
			System.out.println("💰💰💰 Premio considerable (" + formatMoney(netoIndividual) + ")");
			System.out.println("\nPlan financiero recomendado:");
			double deudas = netoIndividual * 0.3;
			double emergencia = netoIndividual * 0.3;
			double inversion = netoIndividual * 0.25;
			double disfrute = netoIndividual * 0.15;

			System.out.println("• Pagar deudas (30%): " + formatMoney(deudas));
			System.out.println("• Fondo emergencia (30%): " + formatMoney(emergencia));
			System.out.println("• Inversión (25%): " + formatMoney(inversion));
			System.out.println("• Disfrute (15%): " + formatMoney(disfrute));
			System.out.println("\nConsideraciones:");
			System.out.println("- Saldar tarjetas de crédito");
			System.out.println("- Crear fondo para 3-6 meses de gastos");
			System.out.println("- Consultar opciones de inversión");
			System.out.println("- Un viaje o experiencia memorable");

		} else if (netoIndividual <= HUGE_PRIZE) {
			System.out.println("💰💰💰💰 Premio importante (" + formatMoney(netoIndividual) + ")");
			System.out.println("\n⚠️ RECOMENDACIÓN: Consultar asesor financiero");
			System.out.println("\nEstrategia sugerida:");
			double hipoteca = netoIndividual * 0.4;
			double inversionDiversa = netoIndividual * 0.3;
			double fondoEmergencia = netoIndividual * 0.15;
			double mejoras = netoIndividual * 0.1;
			double celebrar = netoIndividual * 0.05;

			System.out.println("• Hipoteca/Vivienda (40%): " + formatMoney(hipoteca));
			System.out.println("• Inversión diversificada (30%): " + formatMoney(inversionDiversa));
			System.out.println("• Fondo emergencia (15%): " + formatMoney(fondoEmergencia));
			System.out.println("• Mejoras hogar/vida (10%): " + formatMoney(mejoras));
			System.out.println("• Celebración (5%): " + formatMoney(celebrar));

		} else {
			System.out.println("🎉💰🎉 ¡PREMIO EXTRAORDINARIO! (" + formatMoney(netoIndividual) + ")");
			System.out.println("\n⚠️ ACCIONES INMEDIATAS:");
			System.out.println("1. NO tomar decisiones precipitadas");
			System.out.println("2. Mantener MÁXIMA discreción");
			System.out.println("3. Contratar asesor financiero profesional");
			System.out.println("4. Consultar abogado especializado");
			System.out.println("5. Planificar estrategia fiscal");

			System.out.println("\nDistribución profesional sugerida:");
			System.out.println("• 5% - Fondo inmediato (gastos legales/asesoría)");
			System.out.println("• 25% - Inversión conservadora (renta fija)");
			System.out.println("• 25% - Inversión moderada (diversificada)");
			System.out.println("• 20% - Bienes raíces");
			System.out.println("• 15% - Fondo de emergencia líquido");
			System.out.println("• 10% - Proyectos personales/familiares");

			System.out.println("\nConsideraciones especiales:");
			System.out.println("- Posible cambio de residencia fiscal");
			System.out.println("- Creación de sociedad patrimonial");
			System.out.println("- Plan de sucesión familiar");
			System.out.println("- Protección de activos");
		}

		System.out.println("\n=== PROYECCIÓN TEMPORAL ===");
		scanner.nextLine();
		System.out.print("¿Desea ver proyecciones de inversión? (s/n): ");

		if (scanner.nextLine().equalsIgnoreCase("s")) {
			mostrarProyecciones(netoIndividual);
		}

		System.out.println("\n=== RECORDATORIOS IMPORTANTES ===");
		System.out.println("📌 Guardar comprobante del premio");
		System.out.println("📌 Declarar en la próxima declaración de renta");
		System.out.println("📌 No tomar decisiones bajo presión");
		System.out.println("📌 Cuidado con los 'nuevos amigos'");

		if (netoIndividual > LARGE_PRIZE) {
			System.out.println("📌 Considerar hacer testamento/actualizar");
			System.out.println("📌 Revisar seguros de vida y hogar");
		}

		scanner.close();
	}

	private static double calcularImpuestos(double premio) {
		if (premio <= TAX_FREE_LIMIT) {
			return 0;
		}
		return (premio - TAX_FREE_LIMIT) * TAX_RATE_LOW;
	}

	private static String formatMoney(double amount) {
		return String.format("%,.2f €", amount);
	}

	private static void mostrarProyecciones(double capital) {
		System.out.println("\nProyecciones con diferentes estrategias:");

		System.out.println("\n1. CONSERVADORA (2% anual):");
		for (int anos : new int[] { 1, 5, 10, 20 }) {
			double valor = capital * Math.pow(1.02, anos);
			System.out.println("   " + anos + " años: " + formatMoney(valor));
		}

		System.out.println("\n2. MODERADA (5% anual):");
		for (int anos : new int[] { 1, 5, 10, 20 }) {
			double valor = capital * Math.pow(1.05, anos);
			System.out.println("   " + anos + " años: " + formatMoney(valor));
		}

		System.out.println("\n3. AGRESIVA (8% anual):");
		for (int anos : new int[] { 1, 5, 10, 20 }) {
			double valor = capital * Math.pow(1.08, anos);
			System.out.println("   " + anos + " años: " + formatMoney(valor));
		}

		System.out.println("\n* Valores orientativos sin considerar inflación ni impuestos");
	}
}