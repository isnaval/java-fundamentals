package java_oop.advanced.employee_project_management.management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java_oop.advanced.employee_project_management.employees.Employee;
import java_oop.advanced.employee_project_management.projects.Project;
import java_oop.advanced.employee_project_management.projects.Task;

public class ResourceAllocator {
	private List<Employee> availableEmployees;
	private List<Project> activeProjects;
	private Map<String, List<Employee>> projectTeams;

	public ResourceAllocator() {
		this.availableEmployees = new ArrayList<>();
		this.activeProjects = new ArrayList<>();
		this.projectTeams = new HashMap<>();
	}

	public void addEmployee(Employee employee) {
		if (employee.isAvailable()) {
			availableEmployees.add(employee);
			System.out.println("✅ Empleado disponible: " + employee.getName());
		}
	}

	public void addProject(Project project) {
		activeProjects.add(project);
		projectTeams.put(project.getId(), new ArrayList<>());
		System.out.println("📋 Proyecto agregado: " + project.getName());
	}

	public Employee findBestEmployeeForTask(Task task, String requiredRole) {
		for (Employee employee : availableEmployees) {
			if (employee.isAvailable() && employee.getRole().contains(requiredRole)) {
				return employee;
			}
		}
		return null;
	}

	public boolean allocateEmployeeToProject(Employee employee, Project project) {
		if (employee.isAvailable()) {
			List<Employee> team = projectTeams.get(project.getId());
			if (team != null && !team.contains(employee)) {
				team.add(employee);
				employee.setAvailable(false);
				availableEmployees.remove(employee);
				project.addTeamMember(employee);
				System.out.println("🎯 " + employee.getName() + " asignado al proyecto: " + project.getName());
				return true;
			}
		}
		return false;
	}

	public void releaseEmployee(Employee employee, Project project) {
		List<Employee> team = projectTeams.get(project.getId());
		if (team != null && team.remove(employee)) {
			employee.setAvailable(true);
			availableEmployees.add(employee);
			System.out.println("🔄 " + employee.getName() + " liberado del proyecto: " + project.getName());
		}
	}

	public void showResourceStatus() {
		System.out.println("📊 ESTADO DE RECURSOS:");
		System.out.println("======================");
		System.out.println("Empleados disponibles: " + availableEmployees.size());
		System.out.println("Proyectos activos: " + activeProjects.size());

		for (Project project : activeProjects) {
			List<Employee> team = projectTeams.get(project.getId());
			System.out.println("- " + project.getName() + ": " + team.size() + " empleados");
		}
	}

	// Getters simples
	public List<Employee> getAvailableEmployees() {
		return new ArrayList<>(availableEmployees);
	}

	public List<Project> getActiveProjects() {
		return new ArrayList<>(activeProjects);
	}

	public void generateWorkloadReport() {
		System.out.println("\n📊 REPORTE DE TRABAJO:");
		System.out.println("======================");
		int disponibles = availableEmployees.size();
		int asignados = 0;
		for (List<Employee> team : projectTeams.values()) {
			asignados += team.size();
		}
		int total = disponibles + asignados;
		System.out.println("Total empleados: " + total);
		System.out.println("Empleados trabajando: " + asignados);
		System.out.println("Empleados libres: " + disponibles);
		if (total > 0) {
			int porcentaje = (asignados * 100) / total;
			System.out.println("Porcentaje ocupado: " + porcentaje + "%");
		}

		System.out.println("\nProyectos:");
		for (Project project : activeProjects) {
			List<Employee> team = projectTeams.get(project.getId());
			System.out.println("- " + project.getName() + ": " + team.size() + " empleados");
		}
	}

	public List<String> getRecommendations() {
		List<String> recomendaciones = new ArrayList<>();
		if (availableEmployees.size() < 2) {
			recomendaciones.add("⚠️ Pocos empleados disponibles");
		}
		if (availableEmployees.size() > 5) {
			recomendaciones.add("💡 Muchos empleados libres, crear más proyectos");
		}
		for (Project project : activeProjects) {
			List<Employee> team = projectTeams.get(project.getId());
			if (team.size() == 0) {
				recomendaciones.add("📋 Proyecto " + project.getName() + " necesita empleados");
			}
		}

		boolean hayDeveloper = false;
		boolean hayTester = false;

		for (Employee emp : availableEmployees) {
			if (emp.getRole().contains("Developer")) {
				hayDeveloper = true;
			}
			if (emp.getRole().contains("Tester")) {
				hayTester = true;
			}
		}
		if (!hayDeveloper) {
			recomendaciones.add("💻 No hay programadores disponibles");
		}
		if (!hayTester) {
			recomendaciones.add("🧪 No hay testers disponibles");
		}

		if (recomendaciones.isEmpty()) {
			recomendaciones.add("✅ Todo está bien");
		}
		return recomendaciones;
	}
}
