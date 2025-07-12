package java_oop.advanced.employee_project_management.management;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import java_oop.advanced.employee_project_management.employees.Employee;

public class PerformanceTracker {
	private Map<String, EmployeePerformance> performanceData;

	public PerformanceTracker() {
		this.performanceData = new HashMap<>();
	}

	public void addEmployee(Employee employee) {
		performanceData.put(employee.getId(), new EmployeePerformance(employee));
		System.out.println("✅ Empleado agregado al tracker: " + employee.getName());
	}

	public void recordTaskCompletion(String employeeId, int hours) {
		EmployeePerformance performance = performanceData.get(employeeId);
		if (performance != null) {
			performance.addCompletedTask(hours);
			System.out.println("📊 Tarea registrada para " + performance.getEmployee().getName());
		}
	}

	public void setRating(String employeeId, double rating) {
		EmployeePerformance performance = performanceData.get(employeeId);
		if (performance != null && rating >= 1.0 && rating <= 10.0) {
			performance.setRating(rating);
			System.out.println("⭐ Rating actualizado: " + rating + " para " + performance.getEmployee().getName());
		}
	}

	public void showPerformanceReport(String employeeId) {
		EmployeePerformance performance = performanceData.get(employeeId);
		if (performance != null) {
			performance.showReport();
		} else {
			System.out.println("❌ Empleado no encontrado");
		}
	}

	public Employee getBestPerformer() {
		EmployeePerformance best = null;
		double bestScore = 0.0;

		for (EmployeePerformance performance : performanceData.values()) {
			double score = performance.getPerformanceScore();
			if (score > bestScore) {
				bestScore = score;
				best = performance;
			}
		}

		return best != null ? best.getEmployee() : null;
	}

	private static class EmployeePerformance {
		private Employee employee;
		private int tasksCompleted;
		private int totalHours;
		private double rating;
		private Date lastUpdate;

		public EmployeePerformance(Employee employee) {
			this.employee = employee;
			this.tasksCompleted = 0;
			this.totalHours = 0;
			this.rating = 5.0;
			this.lastUpdate = new Date();
		}

		public void addCompletedTask(int hours) {
			tasksCompleted++;
			totalHours += hours;
			lastUpdate = new Date();
		}

		public void setRating(double rating) {
			this.rating = rating;
			lastUpdate = new Date();
		}

		public double getPerformanceScore() {
			return (tasksCompleted * 10) + (rating * 5) + (totalHours * 0.1);
		}

		public void showReport() {
			System.out.println("📊 REPORTE DE RENDIMIENTO:");
			System.out.println("==========================");
			System.out.println("Empleado: " + employee.getName());
			System.out.println("Tareas completadas: " + tasksCompleted);
			System.out.println("Horas trabajadas: " + totalHours);
			System.out.println("Rating: " + rating + "/10");
			System.out.println("Score total: " + String.format("%.2f", getPerformanceScore()));
		}

		public Employee getEmployee() {
			return employee;
		}
	}
}
