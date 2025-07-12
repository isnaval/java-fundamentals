package java_oop.advanced.employee_project_management.projects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java_oop.advanced.employee_project_management.employees.Employee;
import java_oop.advanced.employee_project_management.employees.ProjectManager;

public class Project {
	private String id;
	private String name;
	private String description;
	private ProjectManager manager;
	private List<Employee> team;
	private List<Task> tasks;
	private ProjectStatus status;
	private LocalDate startDate;
	private LocalDate endDate;
	private double budget;
	private double spentBudget;
	private String client;

	public Project(String id, String name, String description, double budget, String client) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.budget = budget;
		this.client = client;
		this.team = new ArrayList<>();
		this.tasks = new ArrayList<>();
		this.status = ProjectStatus.PLANNING;
		this.spentBudget = 0.0;
	}

	public void assignManager(ProjectManager manager) {
		this.manager = manager;
		manager.assignProject(name, budget);
		System.out.println("👨‍💼 " + manager.getName() + " asignado como manager del proyecto: " + name);
	}

	public void addTeamMember(Employee employee) {
		if (!team.contains(employee)) {
			team.add(employee);
			if (manager != null) {
				manager.manageTeam(team.size());
			}
			System.out.println("👥 " + employee.getName() + " agregado al equipo del proyecto: " + name);
		}
	}

	public void addTask(Task task) {
		tasks.add(task);
		System.out.println("📝 Tarea agregada al proyecto " + name + ": " + task.getTitle());
	}

	public void startProject() {
		this.status = ProjectStatus.IN_PROGRESS;
		this.startDate = LocalDate.now();
		System.out.println("🚀 Proyecto iniciado: " + name);
	}

	public void completeProject() {
		this.status = ProjectStatus.COMPLETED;
		this.endDate = LocalDate.now();
		if (manager != null) {
			manager.completeProject(name);
		}
		System.out.println("🎉 Proyecto completado: " + name);
	}

	public void spendBudget(double amount, String reason) {
		if (spentBudget + amount <= budget) {
			spentBudget += amount;
			System.out.println("💰 Gasto registrado: €" + amount + " - " + reason);
		} else {
			System.out.println("❌ Presupuesto insuficiente para el gasto de €" + amount);
		}
	}

	public double getRemainingBudget() {
		return budget - spentBudget;
	}

	public int getCompletedTasksCount() {
		return (int) tasks.stream().filter(Task::isCompleted).count();
	}

	public double getProgressPercentage() {
		if (tasks.isEmpty())
			return 0.0;
		return (double) getCompletedTasksCount() / tasks.size() * 100;
	}

	public void showProjectInfo() {
		System.out.println("🚀 PROYECTO: " + name);
		System.out.println("ID: " + id);
		System.out.println("Descripción: " + description);
		System.out.println("Cliente: " + client);
		System.out.println("Manager: " + (manager != null ? manager.getName() : "Sin asignar"));
		System.out.println("Estado: " + status);
		System.out.println("Equipo: " + team.size() + " miembros");
		System.out.println("Tareas: " + getCompletedTasksCount() + "/" + tasks.size() + " completadas");
		System.out.println("Progreso: " + String.format("%.1f", getProgressPercentage()) + "%");
		System.out
				.println("Presupuesto: €" + String.format("%.2f", spentBudget) + "/€" + String.format("%.2f", budget));
		System.out.println("Fecha inicio: " + startDate);
		if (endDate != null) {
			System.out.println("Fecha fin: " + endDate);
		}
	}

	// Getters básicos
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public ProjectManager getManager() {
		return manager;
	}

	public List<Employee> getTeam() {
		return new ArrayList<>(team);
	}

	public List<Task> getTasks() {
		return new ArrayList<>(tasks);
	}

	public ProjectStatus getStatus() {
		return status;
	}

	public double getBudget() {
		return budget;
	}

	public double getSpentBudget() {
		return spentBudget;
	}

	public String getClient() {
		return client;
	}

	// Setters básicos
	public void setStatus(ProjectStatus status) {
		this.status = status;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}
}