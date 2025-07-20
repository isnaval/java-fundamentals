package java_oop.advanced.employee_project_management.test;

import java.time.LocalDate;

import java_oop.advanced.employee_project_management.employees.Developer;
import java_oop.advanced.employee_project_management.employees.ProjectManager;
import java_oop.advanced.employee_project_management.projects.Project;
import java_oop.advanced.employee_project_management.projects.Task;
import java_oop.advanced.employee_project_management.projects.TaskPriority;

public class ProjectTest {

	public static void testProjectCreation() {
		System.out.println("🧪 TESTING CREACIÓN DE PROYECTOS:");
		System.out.println("==================================");

		// Crear proyecto
		Project project = new Project("PROJ001", "App Móvil", "Desarrollo de app para iOS/Android", 50000,
				"Cliente ABC");

		// Crear empleados
		ProjectManager pm = new ProjectManager("PM001", "Ana García", "ana@test.com", 4000);
		Developer dev = new Developer("DEV001", "Carlos López", "carlos@test.com", 3000, "Java");

		// Asignar al proyecto
		project.assignManager(pm);
		project.addTeamMember(dev);

		project.showProjectInfo();
		System.out.println("✅ Test de proyecto completado");
	}

	public static void testTaskManagement() {
		System.out.println("\n🧪 TESTING GESTIÓN DE TAREAS:");
		System.out.println("==============================");

		// Crear tarea
		Task task = new Task("TASK001", "Implementar login", "Crear sistema de autenticación", TaskPriority.HIGH);

		// Crear empleado y asignar
		Developer dev = new Developer("DEV001", "Pedro Martín", "pedro@test.com", 3000, "Java");
		task.assignTo(dev);
		task.setDates(LocalDate.now(), LocalDate.now().plusDays(3));

		// Trabajar en la tarea
		task.addWorkHours(4);
		task.addWorkHours(6);

		task.showTaskInfo();

		// Completar tarea
		task.completeTask();

		System.out.println("✅ Test de tareas completado");
	}

	public static void testProjectProgress() {
		System.out.println("\n🧪 TESTING PROGRESO DE PROYECTO:");
		System.out.println("=================================");

		Project project = new Project("PROJ002", "Web App", "Aplicación web corporativa", 30000, "Empresa XYZ");

		// Agregar tareas
		Task task1 = new Task("TASK001", "Frontend", "Desarrollo del frontend", TaskPriority.HIGH);
		Task task2 = new Task("TASK002", "Backend", "Desarrollo del backend", TaskPriority.MEDIUM);
		Task task3 = new Task("TASK003", "Testing", "Pruebas del sistema", TaskPriority.LOW);

		project.addTask(task1);
		project.addTask(task2);
		project.addTask(task3);

		// Completar algunas tareas
		task1.completeTask();
		task2.completeTask();

		project.startProject();
		project.spendBudget(15000, "Desarrollo inicial");

		project.showProjectInfo();
		System.out.println("✅ Test de progreso completado");
	}

	public static void runAllTests() {
		testProjectCreation();
		testTaskManagement();
		testProjectProgress();
	}

	public static void main(String[] args) {
		runAllTests();
	}
}