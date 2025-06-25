package java_core_basic.practical_applications;

public class SalaryCalculator {
	public static void main(String[] args) {
		final int TOTAL_WORKERS = 150;
		final int TOTAL_SUPERVISORS = 10;
		final int MATCH_DURATION_HOURS = 2;
		final int EXTRA_TIME_HOURS = 2;
		final int WORKER_SALARY_PER_HOUR = 2;
		final int SUPERVISOR_SALARY_PER_HOUR = 12;

		System.out.println("=== CONFIGURACIÓN INICIAL ===");
		System.out.println("Trabajadores: " + TOTAL_WORKERS);
		System.out.println("Supervisores: " + TOTAL_SUPERVISORS);
		System.out.println("Duración partido: " + MATCH_DURATION_HOURS + "h");
		System.out.println("Tiempo extra: " + EXTRA_TIME_HOURS + "h");
		System.out.println("Salario trabajador: " + WORKER_SALARY_PER_HOUR + "€/h");
		System.out.println("Salario supervisor: " + SUPERVISOR_SALARY_PER_HOUR + "€/h");
		System.out.println("Tiempo total evento: " + (MATCH_DURATION_HOURS + EXTRA_TIME_HOURS) + "h");

		double normalMatchCost = calculateEventCost(TOTAL_WORKERS, TOTAL_SUPERVISORS, MATCH_DURATION_HOURS,
				EXTRA_TIME_HOURS, WORKER_SALARY_PER_HOUR, SUPERVISOR_SALARY_PER_HOUR);

		double championsMatchCost = calculateChampionsEventCost(TOTAL_WORKERS, TOTAL_SUPERVISORS, MATCH_DURATION_HOURS,
				EXTRA_TIME_HOURS, WORKER_SALARY_PER_HOUR, SUPERVISOR_SALARY_PER_HOUR);

		double difference = championsMatchCost - normalMatchCost;
		double percentageIncrease = (difference / normalMatchCost) * 100;

		System.out.println("\n=== COSTO PARTIDO NORMAL ===");
		System.out.println("Costo salarial: " + normalMatchCost + " €");
		System.out.println("\n=== COSTO PARTIDO CHAMPIONS ===");
		System.out.println("Costo salarial: " + championsMatchCost + " €");
		System.out.println("\n=== COMPARACIÓN ===");

		System.out.println("Diferencia absoluta: " + String.format("%.2f", difference) + " €");
		System.out.println("Aumento porcentual: " + String.format("%.1f", percentageIncrease) + "%");
		System.out.println("Trabajadores extra: " + ((TOTAL_WORKERS * 1.5) - TOTAL_WORKERS));
		System.out.println("Supervisores extra: " + ((TOTAL_SUPERVISORS * 1.02) - TOTAL_SUPERVISORS));
	}

	public static double calculateEventCost(int workers, int supervisors, int matchHours, int extraHours,
			int workerSalary, int supervisorSalary) {
		int totalHours = matchHours + extraHours;
		double workersCost = workers * workerSalary * totalHours;
		double supervisorCost = supervisors * supervisorSalary * totalHours;
		return workersCost + supervisorCost;
	}

	public static double calculateChampionsEventCost(int workers, int supervisors, int matchHours, int extraHours,
			int workerSalary, int supervisorSalary) {
		double adjustedWorkerSalary = workerSalary * 1.1;
		double adjustedSuperSalary = supervisorSalary * 1.2;
		int adjustedWorkers = (int) (workers * 1.5);
		int adjustedSupervisor = (int) (supervisors * 1.02);
		int totalHours = matchHours + extraHours;
		double workersCost = adjustedWorkers * adjustedWorkerSalary * totalHours;
		double supervisorsCost = adjustedSupervisor * adjustedSuperSalary * totalHours;

		return workersCost + supervisorsCost;
	}
}
