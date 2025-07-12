package java_oop.advanced.employee_project_management.reporting;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PerformanceTracker {
	private Map<String, ProjectMetrics> projectMetrics;
	private Map<String, TeamMetrics> teamMetrics;

	public PerformanceTracker() {
		this.projectMetrics = new HashMap<>();
		this.teamMetrics = new HashMap<>();
	}

	public void trackProject(String projectId, String projectName) {
		projectMetrics.put(projectId, new ProjectMetrics(projectName));
		System.out.println("📈 Tracking iniciado para proyecto: " + projectName);
	}

	public void updateProjectProgress(String projectId, double progress) {
		ProjectMetrics metrics = projectMetrics.get(projectId);
		if (metrics != null) {
			metrics.updateProgress(progress);
		}
	}

	public void recordBudgetSpent(String projectId, double amount) {
		ProjectMetrics metrics = projectMetrics.get(projectId);
		if (metrics != null) {
			metrics.addBudgetSpent(amount);
		}
	}

	public void generateProjectReport(String projectId) {
		ProjectMetrics metrics = projectMetrics.get(projectId);
		if (metrics != null) {
			metrics.generateReport();
		}
	}

	public void generateSummaryReport() {
		System.out.println("📊 REPORTE RESUMEN DE PROYECTOS:");
		System.out.println("=================================");

		for (ProjectMetrics metrics : projectMetrics.values()) {
			System.out.println(
					"- " + metrics.projectName + ": " + String.format("%.1f", metrics.progress) + "% completado");
		}
	}

	private static class ProjectMetrics {
		private String projectName;
		private double progress;
		private double budgetSpent;
		private int tasksCompleted;
		private Date lastUpdate;

		public ProjectMetrics(String projectName) {
			this.projectName = projectName;
			this.progress = 0.0;
			this.budgetSpent = 0.0;
			this.tasksCompleted = 0;
			this.lastUpdate = new Date();
		}

		public void updateProgress(double progress) {
			this.progress = progress;
			this.lastUpdate = new Date();
		}

		public void addBudgetSpent(double amount) {
			this.budgetSpent += amount;
			this.lastUpdate = new Date();
		}

		public void generateReport() {
			System.out.println("📋 REPORTE DEL PROYECTO: " + projectName);
			System.out.println("Progreso: " + String.format("%.1f", progress) + "%");
			System.out.println("Presupuesto gastado: €" + String.format("%.2f", budgetSpent));
			System.out.println("Última actualización: " + lastUpdate);
		}
	}

	private static class TeamMetrics {
		private int teamSize;
		private double productivity;

		public TeamMetrics(int teamSize) {
			this.teamSize = teamSize;
			this.productivity = 0.0;
		}
	}
}
