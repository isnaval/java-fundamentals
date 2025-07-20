package java_oop.advanced.employee_project_management.test;

import java_oop.advanced.employee_project_management.employees.Designer;
import java_oop.advanced.employee_project_management.employees.Developer;
import java_oop.advanced.employee_project_management.employees.Employee;
import java_oop.advanced.employee_project_management.employees.Tester;
import java_oop.advanced.employee_project_management.management.PerformanceTracker;
import java_oop.advanced.employee_project_management.management.ResourceAllocator;
import java_oop.advanced.employee_project_management.projects.Project;

public class ManagementSystemTest {

	public static void testPerformanceTracker() {
		System.out.println("🧪 TESTING PERFORMANCE TRACKER:");
		System.out.println("================================");

		PerformanceTracker tracker = new PerformanceTracker();

		// Crear empleados
		Developer dev = new Developer("DEV001", "Luis García", "luis@test.com", 3000, "Java");
		Designer designer = new Designer("DES001", "Sofia López", "sofia@test.com", 2800, "Figma");

		// Agregar al tracker
		tracker.addEmployee(dev);
		tracker.addEmployee(designer);

		// Registrar rendimiento
		tracker.recordTaskCompletion("DEV001", 8);
		tracker.recordTaskCompletion("DEV001", 6);
		tracker.setRating("DEV001", 9.0);

		tracker.recordTaskCompletion("DES001", 5);
		tracker.setRating("DES001", 8.5);

		// Mostrar reportes
		tracker.showPerformanceReport("DEV001");

		Employee best = tracker.getBestPerformer();
		System.out.println("🏆 Mejor empleado: " + (best != null ? best.getName() : "Ninguno"));

		System.out.println("✅ Test de performance tracker completado");
	}

	public static void testResourceAllocator() {
		System.out.println("\n🧪 TESTING RESOURCE ALLOCATOR:");
		System.out.println("===============================");

		ResourceAllocator allocator = new ResourceAllocator();

		// Crear empleados
		Developer dev = new Developer("DEV001", "Miguel Ángel", "miguel@test.com", 3000, "Python");
		Tester tester = new Tester("QA001", "Carmen Ruiz", "carmen@test.com", 2500, "Selenium");

		// Crear proyecto
		Project project = new Project("PROJ001", "E-commerce", "Tienda online", 40000, "Cliente ABC");

		// Agregar recursos
		allocator.addEmployee(dev);
		allocator.addEmployee(tester);
		allocator.addProject(project);

		// Asignar empleados
		boolean assigned1 = allocator.allocateEmployeeToProject(dev, project);
		boolean assigned2 = allocator.allocateEmployeeToProject(tester, project);

		System.out.println("Asignación dev: " + (assigned1 ? "✅" : "❌"));
		System.out.println("Asignación tester: " + (assigned2 ? "✅" : "❌"));

		allocator.showResourceStatus();

		// Liberar empleado
		allocator.releaseEmployee(dev, project);

		System.out.println("✅ Test de resource allocator completado");
	}

	public static void runAllTests() {
		testPerformanceTracker();
		testResourceAllocator();
	}

	public static void main(String[] args) {
		runAllTests();
	}
}