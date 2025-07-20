package java_advanced_testing.unit_tests.advanced;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import java_advanced_testing.model.Employee;
import java_advanced_testing.model.Project;
import java_advanced_testing.resources.test_data.EmployeeTestData;
import java_advanced_testing.resources.test_data.ProjectTestData;

public class ProjectEmployeePerformanceTest {
	public static void main(String[] args) {
		System.out.println("PROJECT EMPLOYEE PERFORMANCE ADVANCED TESTS");
		System.out.println("=============================================");

		testProjectTeamPerformance();
		testEmployeeProductivity();
		testProjectComplexityAnalysis();
		testTeamEfficiencyMetrics();
		testResourceOptimization();

		System.out.println("\nProject employee performance tests completados");
	}

	public static void testProjectTeamPerformance() {
		System.out.println("\n--- Test: Project Team Performance ---");

		// Crear proyecto con equipo diverso
		Project project = ProjectTestData.createValidProject();

		Employee[] teamMembers = { new Employee("Senior Developer", "IT", 75000.0, "senior@company.com"),
				new Employee("Junior Developer", "IT", 35000.0, "junior@company.com"),
				new Employee("Project Manager", "Management", 80000.0, "pm@company.com"),
				new Employee("QA Tester", "IT", 45000.0, "qa@company.com") };

		// Añadir empleados al proyecto
		for (Employee emp : teamMembers) {
			project.addTeamMember(emp);
		}

		// Calcular métricas del equipo
		double totalSalary = 0.0;
		double averageSalary = 0.0;
		int seniorMembers = 0;
		int juniorMembers = 0;

		for (Employee emp : project.getTeam()) {
			totalSalary += emp.getSalary();
			if (emp.getSalary() > 60000.0)
				seniorMembers++;
			else
				juniorMembers++;
		}

		averageSalary = totalSalary / project.getTeam().size();

		// Calcular duración del proyecto
		long projectDays = ChronoUnit.DAYS.between(project.getStartDate(), project.getEndDate());
		double costPerDay = totalSalary / 365.0 * (projectDays / 365.0);

		System.out.println("Proyecto: " + project.getName());
		System.out.println("   Tamaño equipo: " + project.getTeam().size());
		System.out.println("   Miembros senior: " + seniorMembers);
		System.out.println("   Miembros junior: " + juniorMembers);
		System.out.println("   Salario total anual: $" + totalSalary);
		System.out.println("   Salario promedio: $" + averageSalary);
		System.out.println("   Duración proyecto: " + projectDays + " días");
		System.out.println("   Costo estimado: $" + costPerDay);

		// Validaciones
		boolean balancedTeam = seniorMembers >= 1 && juniorMembers >= 1;
		boolean reasonableCost = costPerDay < totalSalary * 0.5;
		boolean adequateSize = project.getTeam().size() >= 3 && project.getTeam().size() <= 10;

		System.out.println("   Test equipo balanceado: " + (balancedTeam ? "PASS" : "FAIL"));
		System.out.println("   Test costo razonable: " + (reasonableCost ? "PASS" : "FAIL"));
		System.out.println("   Test tamaño adecuado: " + (adequateSize ? "PASS" : "FAIL"));
	}

	public static void testEmployeeProductivity() {
		System.out.println("\n--- Test: Employee Productivity ---");

		Employee[] employees = { new Employee("Alto Rendimiento", "IT", 70000.0, "high@company.com"),
				new Employee("Rendimiento Medio", "IT", 50000.0, "medium@company.com"),
				new Employee("Bajo Rendimiento", "IT", 40000.0, "low@company.com") };

		// Simular métricas de productividad
		int[] tasksCompleted = { 45, 32, 18 }; // Tareas completadas por mes
		double[] qualityScores = { 9.2, 7.8, 6.1 }; // Puntuación de calidad 1-10
		int[] projectsInvolved = { 3, 2, 1 }; // Número de proyectos

		for (int i = 0; i < employees.length; i++) {
			Employee emp = employees[i];
			int tasks = tasksCompleted[i];
			double quality = qualityScores[i];
			int projects = projectsInvolved[i];

			// Calcular índice de productividad
			double productivityIndex = calculateProductivityIndex(tasks, quality, projects);
			String performanceLevel = getPerformanceLevel(productivityIndex);

			// Analizar relación salario-productividad
			double salaryEfficiency = productivityIndex / (emp.getSalary() / 1000.0);

			System.out.println("Empleado: " + emp.getName());
			System.out.println("   Tareas/mes: " + tasks);
			System.out.println("   Calidad: " + quality + "/10");
			System.out.println("   Proyectos: " + projects);
			System.out.println("   Índice productividad: " + productivityIndex);
			System.out.println("   Nivel rendimiento: " + performanceLevel);
			System.out.println("   Eficiencia salarial: " + salaryEfficiency);

			boolean highPerformer = productivityIndex > 80.0;
			boolean costEffective = salaryEfficiency > 1.0;

			System.out.println("   Test alto rendimiento: " + (highPerformer ? "PASS" : "FAIL"));
			System.out.println("   Test costo-efectivo: " + (costEffective ? "PASS" : "FAIL"));
		}
	}

	private static double calculateProductivityIndex(int tasks, double quality, int projects) {
		// Fórmula: (tareas * calidad * proyectos) normalizada a 100
		return (tasks * quality * projects) / 10.0;
	}

	private static String getPerformanceLevel(double productivityIndex) {
		if (productivityIndex >= 90.0)
			return "EXCELENTE";
		else if (productivityIndex >= 70.0)
			return "ALTO";
		else if (productivityIndex >= 50.0)
			return "MEDIO";
		else if (productivityIndex >= 30.0)
			return "BAJO";
		else
			return "CRÍTICO";
	}

	public static void testProjectComplexityAnalysis() {
		System.out.println("\n--- Test: Project Complexity Analysis ---");

		Project[] projects = { ProjectTestData.createShortProject(), ProjectTestData.createValidProject(),
				ProjectTestData.createProjectWithTeam(), new Project("Proyecto Complejo",
						"Sistema empresarial completo", LocalDate.now(), LocalDate.now().plusYears(2)) };

		for (Project project : projects) {
			// Añadir equipo si no lo tiene
			if (project.getTeam().isEmpty()) {
				project.addTeamMember(EmployeeTestData.createValidEmployee());
				project.addTeamMember(EmployeeTestData.createHighSalaryEmployee());
			}

			int complexityScore = calculateProjectComplexity(project);
			String complexityLevel = getComplexityLevel(complexityScore);

			// Recomendaciones basadas en complejidad
			String[] recommendations = getProjectRecommendations(complexityScore);

			System.out.println("Proyecto: " + project.getName());
			System.out.println(
					"   Duración: " + ChronoUnit.DAYS.between(project.getStartDate(), project.getEndDate()) + " días");
			System.out.println("   Tamaño equipo: " + project.getTeam().size());
			System.out.println("   Puntuación complejidad: " + complexityScore);
			System.out.println("   Nivel complejidad: " + complexityLevel);
			System.out.println("   Recomendaciones:");
			for (String rec : recommendations) {
				System.out.println("     - " + rec);
			}

			boolean manageable = complexityScore <= 15;
			System.out.println("   Test proyecto manejable: " + (manageable ? "PASS" : "FAIL"));
		}
	}

	private static int calculateProjectComplexity(Project project) {
		int score = 0;

		// Complejidad por duración
		long days = ChronoUnit.DAYS.between(project.getStartDate(), project.getEndDate());
		if (days > 365)
			score += 5;
		else if (days > 180)
			score += 3;
		else if (days > 30)
			score += 1;

		// Complejidad por tamaño del equipo
		int teamSize = project.getTeam().size();
		if (teamSize > 10)
			score += 5;
		else if (teamSize > 5)
			score += 3;
		else if (teamSize > 2)
			score += 1;

		// Complejidad por diversidad de departamentos
		int departments = countUniqueDepartments(project);
		score += departments;

		// Complejidad por descripción
		if (project.getDescription().length() > 100)
			score += 2;
		else if (project.getDescription().length() > 50)
			score += 1;

		return score;
	}

	private static int countUniqueDepartments(Project project) {
		return (int) project.getTeam().stream().map(Employee::getDepartment).distinct().count();
	}

	private static String getComplexityLevel(int score) {
		if (score >= 15)
			return "MUY ALTA";
		else if (score >= 10)
			return "ALTA";
		else if (score >= 5)
			return "MEDIA";
		else
			return "BAJA";
	}

	private static String[] getProjectRecommendations(int complexityScore) {
		if (complexityScore >= 15) {
			return new String[] { "Dividir en fases más pequeñas", "Asignar project manager senior",
					"Implementar reuniones diarias", "Considerar metodología ágil" };
		} else if (complexityScore >= 10) {
			return new String[] { "Reuniones semanales de seguimiento", "Documentación detallada", "Testing continuo" };
		} else if (complexityScore >= 5) {
			return new String[] { "Reuniones quincenales", "Documentación básica" };
		} else {
			return new String[] { "Seguimiento mensual" };
		}
	}

	public static void testTeamEfficiencyMetrics() {
		System.out.println("\n--- Test: Team Efficiency Metrics ---");

		Project project = ProjectTestData.createValidProject();

		// Crear equipo con diferentes roles
		Employee[] team = { new Employee("Tech Lead", "IT", 85000.0, "lead@company.com"),
				new Employee("Senior Dev", "IT", 70000.0, "senior@company.com"),
				new Employee("Mid Dev", "IT", 55000.0, "mid@company.com"),
				new Employee("Junior Dev", "IT", 40000.0, "junior@company.com"),
				new Employee("Designer", "Design", 60000.0, "designer@company.com") };

		for (Employee emp : team) {
			project.addTeamMember(emp);
		}

		// Calcular métricas de eficiencia
		double totalCost = project.getTeam().stream().mapToDouble(Employee::getSalary).sum();
		double averageSalary = totalCost / project.getTeam().size();

		// Simular velocidad del equipo (story points por sprint)
		int[] sprintVelocities = { 23, 28, 31, 29, 33 }; // Últimos 5 sprints
		double averageVelocity = calculateAverage(sprintVelocities);
		double velocityTrend = calculateTrend(sprintVelocities);

		// Calcular eficiencia costo-velocidad
		double costPerStoryPoint = averageSalary / averageVelocity;

		System.out.println("Análisis de eficiencia del equipo:");
		System.out.println("   Costo total anual: $" + totalCost);
		System.out.println("   Salario promedio: $" + averageSalary);
		System.out.println("   Velocidad promedio: " + averageVelocity + " story points");
		System.out.println("   Tendencia velocidad: " + (velocityTrend > 0 ? "ASCENDENTE" : "DESCENDENTE"));
		System.out.println("   Costo por story point: $" + costPerStoryPoint);

		// Evaluaciones
		boolean efficientTeam = costPerStoryPoint < 3000.0;
		boolean improvingTeam = velocityTrend > 0;
		boolean balancedCost = averageSalary >= 40000.0 && averageSalary <= 80000.0;

		System.out.println("   Test equipo eficiente: " + (efficientTeam ? "PASS" : "FAIL"));
		System.out.println("   Test mejora continua: " + (improvingTeam ? "PASS" : "FAIL"));
		System.out.println("   Test costo balanceado: " + (balancedCost ? "PASS" : "FAIL"));
	}

	private static double calculateAverage(int[] values) {
		return (double) java.util.Arrays.stream(values).sum() / values.length;
	}

	private static double calculateTrend(int[] values) {
		if (values.length < 2)
			return 0;
		return values[values.length - 1] - values[0];
	}

	public static void testResourceOptimization() {
		System.out.println("\n--- Test: Resource Optimization ---");

		// Simular múltiples proyectos compitiendo por recursos
		Project[] projects = {
				new Project("Proyecto Crítico", "Alta prioridad", LocalDate.now(), LocalDate.now().plusMonths(3)),
				new Project("Proyecto Normal", "Prioridad media", LocalDate.now(), LocalDate.now().plusMonths(6)),
				new Project("Proyecto Futuro", "Baja prioridad", LocalDate.now().plusMonths(1),
						LocalDate.now().plusMonths(8)) };

		Employee[] availableEmployees = { new Employee("Expert 1", "IT", 80000.0, "expert1@company.com"),
				new Employee("Expert 2", "IT", 75000.0, "expert2@company.com"),
				new Employee("Developer 1", "IT", 55000.0, "dev1@company.com"),
				new Employee("Developer 2", "IT", 50000.0, "dev2@company.com"),
				new Employee("Junior 1", "IT", 35000.0, "junior1@company.com") };

		// Asignación optimizada de recursos
		for (int i = 0; i < projects.length; i++) {
			Project project = projects[i];
			int priority = 3 - i; // Prioridad decreciente

			// Asignar empleados según prioridad
			int employeesToAssign = Math.min(priority + 1, availableEmployees.length);

			for (int j = 0; j < employeesToAssign && j < availableEmployees.length; j++) {
				project.addTeamMember(availableEmployees[j]);
			}

			// Calcular métricas de asignación
			double teamCost = project.getTeam().stream().mapToDouble(Employee::getSalary).sum();
			double averageExperience = project.getTeam().stream().mapToDouble(Employee::getSalary).average().orElse(0);

			long projectDuration = ChronoUnit.DAYS.between(project.getStartDate(), project.getEndDate());
			double riskLevel = calculateProjectRisk(teamCost, averageExperience, projectDuration);

			System.out.println("Proyecto: " + project.getName());
			System.out.println("   Prioridad: " + priority);
			System.out.println("   Equipo asignado: " + project.getTeam().size() + " empleados");
			System.out.println("   Costo del equipo: $" + teamCost);
			System.out.println("   Experiencia promedio: $" + averageExperience);
			System.out.println("   Duración: " + projectDuration + " días");
			System.out.println("   Nivel de riesgo: " + riskLevel);

			boolean optimalAssignment = evaluateAssignment(priority, project.getTeam().size(), riskLevel);
			System.out.println("   Test asignación óptima: " + (optimalAssignment ? "PASS" : "FAIL"));
		}
	}

	private static double calculateProjectRisk(double teamCost, double averageExperience, long duration) {
		double riskScore = 0.0;

		// Riesgo por costo bajo (equipo sin experiencia)
		if (averageExperience < 50000.0)
			riskScore += 3.0;

		// Riesgo por duración larga
		if (duration > 180)
			riskScore += 2.0;

		// Riesgo por costo total alto
		if (teamCost > 300000.0)
			riskScore += 1.0;

		return riskScore;
	}

	private static boolean evaluateAssignment(int priority, int teamSize, double riskLevel) {
		if (priority == 3) { // Proyecto crítico
			return teamSize >= 2 && riskLevel <= 2.0;
		} else if (priority == 2) { // Proyecto normal
			return teamSize >= 1 && riskLevel <= 3.0;
		} else { // Proyecto futuro
			return riskLevel <= 4.0;
		}
	}
}
