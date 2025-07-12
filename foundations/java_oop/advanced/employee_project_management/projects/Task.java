package java_oop.advanced.employee_project_management.projects;

import java.time.LocalDate;

import java_oop.advanced.employee_project_management.employees.Employee;

public class Task {
	private String id;
	private String title;
	private String description;
	private TaskPriority priority;
	private Employee assignedEmployee;
	private LocalDate startDate;
	private LocalDate dueDate;
	private LocalDate completedDate;
	private boolean isCompleted;
	private int estimatedHours;
	private int actualHours;
	private String notes;

	public Task(String id, String title, String description, TaskPriority priority) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.priority = priority;
		this.isCompleted = false;
		this.estimatedHours = 8;
		this.actualHours = 0;
		this.notes = "";
	}

	public void assignTo(Employee employee) {
		this.assignedEmployee = employee;
		employee.setAvailable(false);
		System.out.println("✅ Tarea '" + title + "' asignada a " + employee.getName());
	}

	public void setDates(LocalDate startDate, LocalDate dueDate) {
		this.startDate = startDate;
		this.dueDate = dueDate;
	}

	public void completeTask() {
		this.isCompleted = true;
		this.completedDate = LocalDate.now();
		if (assignedEmployee != null) {
			assignedEmployee.setAvailable(true);
		}
		System.out.println("🎉 Tarea completada: " + title);
	}

	public void addWorkHours(int hours) {
		actualHours += hours;
		System.out.println("⏰ " + hours + " horas agregadas a la tarea: " + title);
	}

	public boolean isOverdue() {
		return !isCompleted && dueDate != null && LocalDate.now().isAfter(dueDate);
	}

	public void showTaskInfo() {
		System.out.println("📋 TAREA: " + title);
		System.out.println("ID: " + id);
		System.out.println("Descripción: " + description);
		System.out.println("Prioridad: " + priority);
		System.out.println("Asignada a: " + (assignedEmployee != null ? assignedEmployee.getName() : "Sin asignar"));
		System.out.println("Fecha inicio: " + startDate);
		System.out.println("Fecha límite: " + dueDate);
		System.out.println("Estado: " + (isCompleted ? "Completada" : "Pendiente"));
		System.out.println("Horas estimadas: " + estimatedHours);
		System.out.println("Horas trabajadas: " + actualHours);
		if (isOverdue()) {
			System.out.println("⚠️ TAREA ATRASADA");
		}
	}

	// Getters básicos
	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public TaskPriority getPriority() {
		return priority;
	}

	public Employee getAssignedEmployee() {
		return assignedEmployee;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public int getEstimatedHours() {
		return estimatedHours;
	}

	public int getActualHours() {
		return actualHours;
	}

	// Setters básicos
	public void setPriority(TaskPriority priority) {
		this.priority = priority;
	}

	public void setEstimatedHours(int hours) {
		this.estimatedHours = hours;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}