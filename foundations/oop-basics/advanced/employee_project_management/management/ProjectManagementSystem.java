package java_oop.advanced.employee_project_management.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java_oop.advanced.employee_project_management.employees.Designer;
import java_oop.advanced.employee_project_management.employees.Developer;
import java_oop.advanced.employee_project_management.employees.Employee;
import java_oop.advanced.employee_project_management.employees.ProjectManager;
import java_oop.advanced.employee_project_management.employees.Tester;
import java_oop.advanced.employee_project_management.projects.Project;
import java_oop.advanced.employee_project_management.projects.ProjectStatus;
import java_oop.advanced.employee_project_management.projects.Task;
import java_oop.advanced.employee_project_management.projects.TaskPriority;

public class ProjectManagementSystem {

	private List<Employee> employees;
	private List<Project> projects;
	private List<Task> allTasks;
	private String companyName;
	private Scanner scanner;

	public ProjectManagementSystem(String companyName) {
		this.companyName = companyName;
		this.employees = new ArrayList<>();
		this.projects = new ArrayList<>();
		this.allTasks = new ArrayList<>();
		this.scanner = new Scanner(System.in);
		initializeSystem();
	}

	private void initializeSystem() {
		employees.add(new Developer("DEV001", "Ana García", "ana@company.com", 3000, "Java"));
		employees.add(new Developer("DEV002", "Carlos López", "carlos@company.com", 3200, "Python"));
		employees.add(new Designer("DES001", "María Rodríguez", "maria@company.com", 2800, "Figma"));
		employees.add(new Tester("QA001", "Pedro Martín", "pedro@company.com", 2500, "Selenium"));
		employees.add(new ProjectManager("PM001", "Lucía Fernández", "lucia@company.com", 4000));

		System.out.println("✅ Sistema inicializado con " + employees.size() + " empleados");
	}

	public void startSystem() {
		System.out.println("🏢 BIENVENIDO AL SISTEMA DE GESTIÓN DE " + companyName.toUpperCase());
		System.out.println("=".repeat(60));

		while (true) {
			showMainMenu();
			int option = getIntInput("Seleccione una opción: ");

			switch (option) {
			case 1 -> employeeManagement();
			case 2 -> projectManagement();
			case 3 -> taskManagement();
			case 4 -> showReports();
			case 5 -> showStatistics();
			case 0 -> {
				System.out.println("👋 ¡Hasta luego!");
				return;
			}
			default -> System.out.println("❌ Opción inválida");
			}
		}
	}

	private void showMainMenu() {
		System.out.println("\n📋 MENÚ PRINCIPAL:");
		System.out.println("==================");
		System.out.println("1. 👥 Gestión de Empleados");
		System.out.println("2. 🚀 Gestión de Proyectos");
		System.out.println("3. 📝 Gestión de Tareas");
		System.out.println("4. 📊 Reportes");
		System.out.println("5. 📈 Estadísticas");
		System.out.println("0. 🚪 Salir");
	}

	private void employeeManagement() {
		while (true) {
			System.out.println("\n👥 GESTIÓN DE EMPLEADOS:");
			System.out.println("========================");
			System.out.println("1. Ver Todos los Empleados");
			System.out.println("2. Agregar Nuevo Empleado");
			System.out.println("3. Buscar Empleado");
			System.out.println("4. Actualizar Salario");
			System.out.println("5. Agregar Habilidad");
			System.out.println("6. Cambiar Disponibilidad");
			System.out.println("0. Volver al Menú Principal");

			int option = getIntInput("Seleccione una opción: ");

			switch (option) {
			case 1 -> showAllEmployees();
			case 2 -> addNewEmployee();
			case 3 -> searchEmployee();
			case 4 -> updateSalary();
			case 5 -> addSkillToEmployee();
			case 6 -> changeAvailability();
			case 0 -> {
				return;
			}
			default -> System.out.println("❌ Opción inválida");
			}
		}
	}

	private void projectManagement() {
		while (true) {
			System.out.println("\n🚀 GESTIÓN DE PROYECTOS:");
			System.out.println("========================");
			System.out.println("1. Ver Todos los Proyectos");
			System.out.println("2. Crear Nuevo Proyecto");
			System.out.println("3. Asignar Manager a Proyecto");
			System.out.println("4. Agregar Empleado a Proyecto");
			System.out.println("5. Ver Detalles de Proyecto");
			System.out.println("6. Iniciar Proyecto");
			System.out.println("7. Completar Proyecto");
			System.out.println("0. Volver al Menú Principal");

			int option = getIntInput("Seleccione una opción: ");

			switch (option) {
			case 1 -> showAllProjects();
			case 2 -> createNewProject();
			case 3 -> assignManagerToProject();
			case 4 -> addEmployeeToProject();
			case 5 -> showProjectDetails();
			case 6 -> startProject();
			case 7 -> completeProject();
			case 0 -> {
				return;
			}
			default -> System.out.println("❌ Opción inválida");
			}
		}
	}

	private void taskManagement() {
		while (true) {
			System.out.println("\n📝 GESTIÓN DE TAREAS:");
			System.out.println("=====================");
			System.out.println("1. Ver Todas las Tareas");
			System.out.println("2. Crear Nueva Tarea");
			System.out.println("3. Asignar Tarea a Empleado");
			System.out.println("4. Completar Tarea");
			System.out.println("5. Agregar Horas de Trabajo");
			System.out.println("6. Ver Tareas Atrasadas");
			System.out.println("0. Volver al Menú Principal");

			int option = getIntInput("Seleccione una opción: ");

			switch (option) {
			case 1 -> showAllTasks();
			case 2 -> createNewTask();
			case 3 -> assignTaskToEmployee();
			case 4 -> completeTask();
			case 5 -> addWorkHours();
			case 6 -> showOverdueTasks();
			case 0 -> {
				return;
			}
			default -> System.out.println("❌ Opción inválida");
			}
		}
	}

	private void showAllEmployees() {
		System.out.println("\n👥 LISTA DE EMPLEADOS:");
		System.out.println("=====================");
		for (int i = 0; i < employees.size(); i++) {
			Employee emp = employees.get(i);
			System.out.printf("%d. %s - %s (%s) - %s%n", i + 1, emp.getName(), emp.getRole(), emp.getDepartment(),
					emp.isAvailable() ? "Disponible" : "Ocupado");
		}
	}

	private void addNewEmployee() {
		System.out.println("\n➕ AGREGAR NUEVO EMPLEADO:");
		System.out.println("==========================");
		System.out.println("1. Developer");
		System.out.println("2. Designer");
		System.out.println("3. Tester");
		System.out.println("4. Project Manager");

		int type = getIntInput("Tipo de empleado: ");
		String id = getStringInput("ID del empleado: ");
		String name = getStringInput("Nombre: ");
		String email = getStringInput("Email: ");
		double salary = getDoubleInput("Salario base: ");

		Employee newEmployee = null;

		switch (type) {
		case 1 -> {
			String language = getStringInput("Lenguaje de programación: ");
			newEmployee = new Developer(id, name, email, salary, language);
		}
		case 2 -> {
			String tool = getStringInput("Herramienta de diseño: ");
			newEmployee = new Designer(id, name, email, salary, tool);
		}
		case 3 -> {
			String testTool = getStringInput("Herramienta de testing: ");
			newEmployee = new Tester(id, name, email, salary, testTool);
		}
		case 4 -> {
			newEmployee = new ProjectManager(id, name, email, salary);
		}
		default -> {
			System.out.println("❌ Tipo inválido");
			return;
		}
		}

		employees.add(newEmployee);
		System.out.println("✅ Empleado agregado exitosamente!");
		newEmployee.showEmployeeInfo();
	}

	private void searchEmployee() {
		String name = getStringInput("Nombre del empleado a buscar: ");
		for (Employee emp : employees) {
			if (emp.getName().toLowerCase().contains(name.toLowerCase())) {
				emp.showEmployeeInfo();
				return;
			}
		}
		System.out.println("❌ Empleado no encontrado");
	}

	private void updateSalary() {
		showAllEmployees();
		int index = getIntInput("Seleccione empleado: ") - 1;

		if (index >= 0 && index < employees.size()) {
			Employee emp = employees.get(index);
			double newSalary = getDoubleInput("Nuevo salario base: ");
			emp.setBaseSalary(newSalary);
			System.out.println("✅ Salario actualizado para " + emp.getName());
		}
	}

	private void addSkillToEmployee() {
		showAllEmployees();
		int index = getIntInput("Seleccione empleado: ") - 1;

		if (index >= 0 && index < employees.size()) {
			Employee emp = employees.get(index);
			String skill = getStringInput("Nueva habilidad: ");
			emp.addSkill(skill);
		}
	}

	private void changeAvailability() {
		showAllEmployees();
		int index = getIntInput("Seleccione empleado: ") - 1;

		if (index >= 0 && index < employees.size()) {
			Employee emp = employees.get(index);
			boolean available = getStringInput("¿Disponible? (s/n): ").toLowerCase().startsWith("s");
			emp.setAvailable(available);
		}
	}

	private void showAllProjects() {
		System.out.println("\n🚀 LISTA DE PROYECTOS:");
		System.out.println("======================");
		for (int i = 0; i < projects.size(); i++) {
			Project proj = projects.get(i);
			System.out.printf("%d. %s - %s - Progreso: %.1f%%%n", i + 1, proj.getName(), proj.getStatus(),
					proj.getProgressPercentage());
		}
	}

	private void createNewProject() {
		System.out.println("\n➕ CREAR NUEVO PROYECTO:");
		System.out.println("========================");

		String id = getStringInput("ID del proyecto: ");
		String name = getStringInput("Nombre del proyecto: ");
		String description = getStringInput("Descripción: ");
		double budget = getDoubleInput("Presupuesto: ");
		String client = getStringInput("Cliente: ");

		Project newProject = new Project(id, name, description, budget, client);
		projects.add(newProject);

		System.out.println("✅ Proyecto creado exitosamente!");
		newProject.showProjectInfo();
	}

	private void assignManagerToProject() {
		showAllProjects();
		int projIndex = getIntInput("Seleccione proyecto: ") - 1;

		if (projIndex >= 0 && projIndex < projects.size()) {
			Project project = projects.get(projIndex);

			System.out.println("\nProject Managers disponibles:");
			List<ProjectManager> managers = new ArrayList<>();
			for (Employee emp : employees) {
				if (emp instanceof ProjectManager && emp.isAvailable()) {
					managers.add((ProjectManager) emp);
					System.out.printf("%d. %s%n", managers.size(), emp.getName());
				}
			}

			if (!managers.isEmpty()) {
				int managerIndex = getIntInput("Seleccione manager: ") - 1;
				if (managerIndex >= 0 && managerIndex < managers.size()) {
					project.assignManager(managers.get(managerIndex));
				}
			} else {
				System.out.println("❌ No hay managers disponibles");
			}
		}
	}

	private void addEmployeeToProject() {
		showAllProjects();
		int projIndex = getIntInput("Seleccione proyecto: ") - 1;

		if (projIndex >= 0 && projIndex < projects.size()) {
			Project project = projects.get(projIndex);

			System.out.println("\nEmpleados disponibles:");
			List<Employee> available = new ArrayList<>();
			for (Employee emp : employees) {
				if (emp.isAvailable() && !(emp instanceof ProjectManager)) {
					available.add(emp);
					System.out.printf("%d. %s - %s%n", available.size(), emp.getName(), emp.getRole());
				}
			}

			if (!available.isEmpty()) {
				int empIndex = getIntInput("Seleccione empleado: ") - 1;
				if (empIndex >= 0 && empIndex < available.size()) {
					project.addTeamMember(available.get(empIndex));
				}
			} else {
				System.out.println("❌ No hay empleados disponibles");
			}
		}
	}

	private void showProjectDetails() {
		showAllProjects();
		int index = getIntInput("Seleccione proyecto: ") - 1;

		if (index >= 0 && index < projects.size()) {
			projects.get(index).showProjectInfo();
		}
	}

	private void startProject() {
		showAllProjects();
		int index = getIntInput("Seleccione proyecto para iniciar: ") - 1;

		if (index >= 0 && index < projects.size()) {
			projects.get(index).startProject();
		}
	}

	private void completeProject() {
		showAllProjects();
		int index = getIntInput("Seleccione proyecto para completar: ") - 1;

		if (index >= 0 && index < projects.size()) {
			projects.get(index).completeProject();
		}
	}

	private void showAllTasks() {
		System.out.println("\n📝 LISTA DE TAREAS:");
		System.out.println("===================");
		for (int i = 0; i < allTasks.size(); i++) {
			Task task = allTasks.get(i);
			System.out.printf("%d. %s - %s - %s%n", i + 1, task.getTitle(), task.getPriority(),
					task.isCompleted() ? "Completada" : "Pendiente");
		}
	}

	private void createNewTask() {
		System.out.println("\n➕ CREAR NUEVA TAREA:");
		System.out.println("=====================");

		String id = getStringInput("ID de la tarea: ");
		String title = getStringInput("Título: ");
		String description = getStringInput("Descripción: ");

		System.out.println("Prioridades: 1-Baja, 2-Media, 3-Alta, 4-Urgente, 5-Crítica");
		int priorityLevel = getIntInput("Prioridad (1-5): ");

		TaskPriority priority = TaskPriority.LOW;
		switch (priorityLevel) {
		case 2 -> priority = TaskPriority.MEDIUM;
		case 3 -> priority = TaskPriority.HIGH;
		case 4 -> priority = TaskPriority.URGENT;
		case 5 -> priority = TaskPriority.CRITICAL;
		}

		Task newTask = new Task(id, title, description, priority);

		if (!projects.isEmpty()) {
			showAllProjects();
			int projIndex = getIntInput("Asignar a proyecto (0 para ninguno): ") - 1;
			if (projIndex >= 0 && projIndex < projects.size()) {
				projects.get(projIndex).addTask(newTask);
			}
		}

		allTasks.add(newTask);
		System.out.println("✅ Tarea creada exitosamente!");
	}

	private void assignTaskToEmployee() {
		showAllTasks();
		int taskIndex = getIntInput("Seleccione tarea: ") - 1;

		if (taskIndex >= 0 && taskIndex < allTasks.size()) {
			Task task = allTasks.get(taskIndex);

			System.out.println("\nEmpleados disponibles:");
			List<Employee> available = new ArrayList<>();
			for (Employee emp : employees) {
				if (emp.isAvailable()) {
					available.add(emp);
					System.out.printf("%d. %s - %s%n", available.size(), emp.getName(), emp.getRole());
				}
			}

			if (!available.isEmpty()) {
				int empIndex = getIntInput("Seleccione empleado: ") - 1;
				if (empIndex >= 0 && empIndex < available.size()) {
					task.assignTo(available.get(empIndex));
				}
			} else {
				System.out.println("❌ No hay empleados disponibles");
			}
		}
	}

	private void completeTask() {
		showAllTasks();
		int index = getIntInput("Seleccione tarea para completar: ") - 1;

		if (index >= 0 && index < allTasks.size()) {
			allTasks.get(index).completeTask();
		}
	}

	private void addWorkHours() {
		showAllTasks();
		int index = getIntInput("Seleccione tarea: ") - 1;

		if (index >= 0 && index < allTasks.size()) {
			int hours = getIntInput("Horas trabajadas: ");
			allTasks.get(index).addWorkHours(hours);
		}
	}

	private void showOverdueTasks() {
		System.out.println("\n⚠️ TAREAS ATRASADAS:");
		System.out.println("====================");
		boolean found = false;

		for (Task task : allTasks) {
			if (task.isOverdue()) {
				System.out.println("- " + task.getTitle() + " (Vence: " + task.getDueDate() + ")");
				found = true;
			}
		}

		if (!found) {
			System.out.println("✅ No hay tareas atrasadas");
		}
	}

	private void showReports() {
		System.out.println("\n📊 REPORTES:");
		System.out.println("=============");
		System.out.println("1. Reporte de Empleados");
		System.out.println("2. Reporte de Proyectos");
		System.out.println("3. Reporte de Productividad");

		int option = getIntInput("Seleccione reporte: ");

		switch (option) {
		case 1 -> generateEmployeeReport();
		case 2 -> generateProjectReport();
		case 3 -> generateProductivityReport();
		}
	}

	private void generateEmployeeReport() {
		System.out.println("\n👥 REPORTE DE EMPLEADOS:");
		System.out.println("========================");

		int developers = 0, designers = 0, testers = 0, managers = 0;
		double totalSalary = 0.0;

		for (Employee emp : employees) {
			totalSalary += emp.calculateSalary();

			if (emp instanceof Developer)
				developers++;
			else if (emp instanceof Designer)
				designers++;
			else if (emp instanceof Tester)
				testers++;
			else if (emp instanceof ProjectManager)
				managers++;
		}

		System.out.println("Total empleados: " + employees.size());
		System.out.println("Developers: " + developers);
		System.out.println("Designers: " + designers);
		System.out.println("Testers: " + testers);
		System.out.println("Project Managers: " + managers);
		System.out.printf("Nómina total: €%.2f%n", totalSalary);
	}

	private void generateProjectReport() {
		System.out.println("\n🚀 REPORTE DE PROYECTOS:");
		System.out.println("========================");

		double totalBudget = 0.0;
		double totalSpent = 0.0;
		int completed = 0;

		for (Project proj : projects) {
			totalBudget += proj.getBudget();
			totalSpent += proj.getSpentBudget();
			if (proj.getStatus() == ProjectStatus.COMPLETED) {
				completed++;
			}
		}

		System.out.println("Total proyectos: " + projects.size());
		System.out.println("Proyectos completados: " + completed);
		System.out.printf("Presupuesto total: €%.2f%n", totalBudget);
		System.out.printf("Gastado total: €%.2f%n", totalSpent);
	}

	private void generateProductivityReport() {
		System.out.println("\n📈 REPORTE DE PRODUCTIVIDAD:");
		System.out.println("============================");

		int totalTasks = allTasks.size();
		int completedTasks = 0;
		int totalHours = 0;

		for (Task task : allTasks) {
			if (task.isCompleted()) {
				completedTasks++;
			}
			totalHours += task.getActualHours();
		}

		System.out.println("Total tareas: " + totalTasks);
		System.out.println("Tareas completadas: " + completedTasks);
		System.out.println("Horas trabajadas: " + totalHours);

		if (totalTasks > 0) {
			double productivity = (double) completedTasks / totalTasks * 100;
			System.out.printf("Productividad: %.1f%%%n", productivity);
		}
	}

	private void showStatistics() {
		System.out.println("\n📈 ESTADÍSTICAS GENERALES:");
		System.out.println("===========================");

		System.out.println("🏢 " + companyName);
		System.out.println("👥 Empleados: " + employees.size());
		System.out.println("🚀 Proyectos: " + projects.size());
		System.out.println("📝 Tareas: " + allTasks.size());

		int availableEmployees = 0;
		for (Employee emp : employees) {
			if (emp.isAvailable())
				availableEmployees++;
		}

		System.out.println("✅ Empleados disponibles: " + availableEmployees);
		System.out.println("🔄 Empleados ocupados: " + (employees.size() - availableEmployees));
	}

	private String getStringInput(String prompt) {
		System.out.print(prompt);
		return scanner.nextLine().trim();
	}

	private int getIntInput(String prompt) {
		while (true) {
			try {
				System.out.print(prompt);
				int value = Integer.parseInt(scanner.nextLine().trim());
				return value;
			} catch (NumberFormatException e) {
				System.out.println("❌ Por favor, ingrese un número válido.");
			}
		}
	}

	private double getDoubleInput(String prompt) {
		while (true) {
			try {
				System.out.print(prompt);
				double value = Double.parseDouble(scanner.nextLine().trim());
				return value;
			} catch (NumberFormatException e) {
				System.out.println("❌ Por favor, ingrese un número válido.");
			}
		}
	}

	public static void main(String[] args) {
		ProjectManagementSystem system = new ProjectManagementSystem("TechCorp Solutions");
		system.startSystem();
	}
}
