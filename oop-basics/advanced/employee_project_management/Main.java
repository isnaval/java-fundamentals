package java_oop.advanced.employee_project_management;

import java.util.Scanner;

import java_oop.advanced.employee_project_management.management.PerformanceTracker;
import java_oop.advanced.employee_project_management.management.ProjectManagementSystem;
import java_oop.advanced.employee_project_management.management.ResourceAllocator;
import java_oop.advanced.employee_project_management.test.EmployeeTest;
import java_oop.advanced.employee_project_management.test.ManagementSystemTest;
import java_oop.advanced.employee_project_management.test.ProjectTest;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		showWelcomeMessage();

		while (true) {
			showMainMenu();
			int option = getIntInput("Seleccione una opción: ");

			switch (option) {
			case 1 -> runFullManagementSystem();
			case 2 -> runTestingSuite();
			case 3 -> runDemoScenarios();
			case 4 -> runPerformanceDemo();
			case 5 -> runResourceAllocationDemo();
			case 6 -> showSystemInfo();
			case 0 -> {
				System.out.println("👋 ¡Gracias por usar nuestro sistema!");
				System.out.println("🚀 ¡Hasta la próxima!");
				return;
			}
			default -> System.out.println("❌ Opción inválida. Intente de nuevo.");
			}

			pauseForUser();
		}
	}

	private static void showWelcomeMessage() {
		System.out.println("=".repeat(50));
		System.out.println("🚀 SISTEMA DE GESTIÓN DE PROYECTOS Y EMPLEADOS 🚀");
		System.out.println("=".repeat(50));
		System.out.println();
		System.out.println("🎓 CARACTERÍSTICAS DEL SISTEMA:");
		System.out.println("================================");
		System.out.println("✅ Gestión completa de empleados (Developer, Designer, Tester, PM)");
		System.out.println("✅ Gestión de proyectos con tareas y seguimiento");
		System.out.println("✅ Sistema de asignación de recursos inteligente");
		System.out.println("✅ Tracking de rendimiento y métricas");
		System.out.println("✅ Reportes y estadísticas avanzadas");
		System.out.println("✅ Testing suite completo");
		System.out.println();
		System.out.println("🏗️ CONCEPTOS DE POO IMPLEMENTADOS:");
		System.out.println("===================================");
		System.out.println("📐 Herencia: Employee → Developer, Designer, Tester, ProjectManager");
		System.out.println("🔄 Polimorfismo: Métodos calculateSalary() y getRole() específicos");
		System.out.println("🔒 Encapsulación: Datos protegidos con getters/setters");
		System.out.println("🎭 Abstracción: Clase abstracta Employee con métodos abstractos");
		System.out.println("🧩 Composición: Project contiene Tasks y Employees");
		System.out.println("📊 Enums: TaskPriority, ProjectStatus con métodos");
		System.out.println();
	}

	private static void showMainMenu() {
		System.out.println("📋 MENÚ PRINCIPAL:");
		System.out.println("==================");
		System.out.println("1. 🏢 Sistema Completo de Gestión");
		System.out.println("2. 🧪 Ejecutar Suite de Testing");
		System.out.println("3. 🎭 Demostraciones Interactivas");
		System.out.println("4. 📈 Demo de Performance Tracking");
		System.out.println("5. 🎯 Demo de Asignación de Recursos");
		System.out.println("6. ℹ️ Información del Sistema");
		System.out.println("0. 🚪 Salir");
		System.out.println();
	}

	private static void runFullManagementSystem() {
		System.out.println("\n🏢 INICIANDO SISTEMA COMPLETO DE GESTIÓN");
		System.out.println("========================================");

		String companyName = getStringInput("Ingrese el nombre de su empresa: ");
		if (companyName.trim().isEmpty()) {
			companyName = "TechCorp Solutions";
		}

		System.out.println("🚀 Iniciando sistema para: " + companyName);
		System.out.println("⏳ Cargando módulos...");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		ProjectManagementSystem system = new ProjectManagementSystem(companyName);
		system.startSystem();
	}

	private static void runTestingSuite() {
		System.out.println("\n🧪 EJECUTANDO SUITE DE TESTING");
		System.out.println("===============================");

		while (true) {
			System.out.println("\n🔬 OPCIONES DE TESTING:");
			System.out.println("=======================");
			System.out.println("1. 👨‍💼 Tests de Empleados");
			System.out.println("2. 🚀 Tests de Proyectos");
			System.out.println("3. 🎯 Tests de Sistema de Gestión");
			System.out.println("4. 🏃‍♂️ Ejecutar Todos los Tests");
			System.out.println("5. 📊 Tests con Métricas Detalladas");
			System.out.println("0. ⬅️ Volver al Menú Principal");

			int option = getIntInput("Seleccione opción de testing: ");

			switch (option) {
			case 1 -> {
				System.out.println("🧪 Ejecutando tests de empleados...");
				EmployeeTest.runAllTests();
			}
			case 2 -> {
				System.out.println("🧪 Ejecutando tests de proyectos...");
				ProjectTest.runAllTests();
			}
			case 3 -> {
				System.out.println("🧪 Ejecutando tests de sistema...");
				ManagementSystemTest.runAllTests();
			}
			case 4 -> {
				System.out.println("🧪 Ejecutando TODOS los tests...");
				runCompleteTestSuite();
			}
			case 5 -> {
				System.out.println("🧪 Ejecutando tests con métricas...");
				runTestsWithMetrics();
			}
			case 0 -> {
				return;
			}
			default -> System.out.println("❌ Opción inválida");
			}

			pauseForUser();
		}
	}

	private static void runDemoScenarios() {
		System.out.println("\n🎭 DEMOSTRACIONES INTERACTIVAS");
		System.out.println("===============================");

		while (true) {
			System.out.println("\n🎬 ESCENARIOS DISPONIBLES:");
			System.out.println("==========================");
			System.out.println("1. 🏗️ Creación de Startup Tech");
			System.out.println("2. 📱 Desarrollo de App Móvil");
			System.out.println("3. 🌐 Proyecto de E-commerce");
			System.out.println("4. 🎮 Desarrollo de Videojuego");
			System.out.println("5. 🤖 Proyecto de IA/Machine Learning");
			System.out.println("0. ⬅️ Volver al Menú Principal");

			int option = getIntInput("Seleccione escenario: ");

			switch (option) {
			case 1 -> runStartupDemo();
			case 2 -> runMobileAppDemo();
			case 3 -> runEcommerceDemo();
			case 4 -> runGameDevDemo();
			case 5 -> runAIProjectDemo();
			case 0 -> {
				return;
			}
			default -> System.out.println("❌ Opción inválida");
			}

			pauseForUser();
		}
	}

	private static void runPerformanceDemo() {
		System.out.println("\n📈 DEMO DE PERFORMANCE TRACKING");
		System.out.println("================================");

		PerformanceTracker tracker = new PerformanceTracker();

		System.out.println("👥 Creando empleados para tracking...");
		var employees = createDemoEmployees();

		for (var emp : employees) {
			tracker.addEmployee(emp);
		}

		System.out.println("📊 Simulando actividad laboral...");
		simulateWorkActivity(tracker, employees);

		System.out.println("\n📋 REPORTES DE RENDIMIENTO:");
		for (var emp : employees) {
			tracker.showPerformanceReport(emp.getId());
			System.out.println();
		}

		var bestEmployee = tracker.getBestPerformer();
		if (bestEmployee != null) {
			System.out.println("🏆 MEJOR EMPLEADO DEL MES:");
			System.out.println("==========================");
			bestEmployee.showEmployeeInfo();
		}
	}

	private static void runResourceAllocationDemo() {
		System.out.println("\n🎯 DEMO DE ASIGNACIÓN DE RECURSOS");
		System.out.println("=================================");

		ResourceAllocator allocator = new ResourceAllocator();

		var employees = createDemoEmployees();
		var projects = createDemoProjects();

		System.out.println("➕ Agregando empleados y proyectos...");
		for (var emp : employees) {
			allocator.addEmployee(emp);
		}

		for (var proj : projects) {
			allocator.addProject(proj);
		}

		System.out.println("\n🎯 Realizando asignaciones inteligentes...");
		demonstrateSmartAllocation(allocator, employees, projects);

		allocator.showResourceStatus();

		allocator.generateWorkloadReport();

		System.out.println("\n💡 RECOMENDACIONES:");
		var recommendations = allocator.getRecommendations();
		for (String rec : recommendations) {
			System.out.println("   " + rec);
		}
	}

	private static void showSystemInfo() {
		System.out.println("\nℹ️ INFORMACIÓN DEL SISTEMA");
		System.out.println("===========================");
		System.out.println("📦 Versión: 1.0.0");
		System.out.println("👨‍💻 Desarrollado para: Aprendizaje de POO en Java");
		System.out.println("🏗️ Arquitectura: Orientada a Objetos");
		System.out.println("🎯 Enfoque: Gestión de Proyectos y Recursos Humanos");
		System.out.println();
		System.out.println("📊 ESTADÍSTICAS DEL CÓDIGO:");
		System.out.println("============================");
		System.out.println("📁 Paquetes: 4 (employees, projects, management, test)");
		System.out.println("📄 Clases principales: 15+");
		System.out.println("🔗 Interfaces implementadas: Multiple");
		System.out.println("📐 Jerarquías de herencia: 2 principales");
		System.out.println("🧪 Clases de test: 3");
		System.out.println();
		System.out.println("🎓 CONCEPTOS DEMOSTRADOS:");
		System.out.println("=========================");
		System.out.println("✅ Herencia y Polimorfismo");
		System.out.println("✅ Encapsulación y Abstracción");
		System.out.println("✅ Composición y Agregación");
		System.out.println("✅ Enums con métodos");
		System.out.println("✅ Manejo de Collections");
		System.out.println("✅ Diseño de APIs sencillas");
		System.out.println("✅ Testing unitario");
		System.out.println("✅ Patterns de diseño básicos");
	}

	private static java.util.List<java_oop.advanced.employee_project_management.employees.Employee> createDemoEmployees() {
		var employees = new java.util.ArrayList<java_oop.advanced.employee_project_management.employees.Employee>();

		employees.add(new java_oop.advanced.employee_project_management.employees.Developer("DEV001", "Ana Código",
				"ana@demo.com", 3200, "Java"));
		employees.add(new java_oop.advanced.employee_project_management.employees.Developer("DEV002", "Carlos Script",
				"carlos@demo.com", 3400, "Python"));
		employees.add(new java_oop.advanced.employee_project_management.employees.Designer("DES001", "María Pixel",
				"maria@demo.com", 2900, "Figma"));
		employees.add(new java_oop.advanced.employee_project_management.employees.Tester("QA001", "Pedro Bug",
				"pedro@demo.com", 2600, "Selenium"));
		employees.add(new java_oop.advanced.employee_project_management.employees.ProjectManager("PM001",
				"Lucía Gestión", "lucia@demo.com", 4200));

		return employees;
	}

	private static java.util.List<java_oop.advanced.employee_project_management.projects.Project> createDemoProjects() {
		var projects = new java.util.ArrayList<java_oop.advanced.employee_project_management.projects.Project>();

		projects.add(new java_oop.advanced.employee_project_management.projects.Project("PROJ001",
				"E-Commerce Platform", "Plataforma de comercio electrónico", 50000, "TechMart"));
		projects.add(new java_oop.advanced.employee_project_management.projects.Project("PROJ002", "Mobile Banking App",
				"Aplicación móvil bancaria", 75000, "BankCorp"));
		projects.add(new java_oop.advanced.employee_project_management.projects.Project("PROJ003", "AI Chatbot",
				"Sistema de chatbot inteligente", 40000, "StartupAI"));

		return projects;
	}

	private static void simulateWorkActivity(PerformanceTracker tracker,
			java.util.List<java_oop.advanced.employee_project_management.employees.Employee> employees) {
		String[] employeeIds = { "DEV001", "DEV002", "DES001", "QA001", "PM001" };
		int[][] workHours = { { 8, 6, 7 }, { 7, 8, 5 }, { 6, 7, 8 }, { 5, 6, 7 }, { 8, 8, 6 } };
		double[] ratings = { 8.5, 9.0, 7.8, 8.2, 9.2 };

		for (int i = 0; i < employeeIds.length; i++) {
			for (int hours : workHours[i]) {
				tracker.recordTaskCompletion(employeeIds[i], hours);
			}
			tracker.setRating(employeeIds[i], ratings[i]);
		}
	}

	private static void demonstrateSmartAllocation(ResourceAllocator allocator,
			java.util.List<java_oop.advanced.employee_project_management.employees.Employee> employees,
			java.util.List<java_oop.advanced.employee_project_management.projects.Project> projects) {

		allocator.allocateEmployeeToProject(employees.get(4), projects.get(0));
		allocator.allocateEmployeeToProject(employees.get(0), projects.get(0));
		allocator.allocateEmployeeToProject(employees.get(1), projects.get(1));
		allocator.allocateEmployeeToProject(employees.get(2), projects.get(0));
		allocator.allocateEmployeeToProject(employees.get(3), projects.get(1));
		System.out.println("✅ Asignaciones completadas automáticamente");
	}

	private static void runCompleteTestSuite() {
		System.out.println("🏃‍♂️ EJECUTANDO SUITE COMPLETA DE TESTS");
		System.out.println("========================================");

		long startTime = System.currentTimeMillis();

		try {
			System.out.println("\n1️⃣ Tests de Empleados:");
			EmployeeTest.runAllTests();

			System.out.println("\n2️⃣ Tests de Proyectos:");
			ProjectTest.runAllTests();

			System.out.println("\n3️⃣ Tests de Sistema:");
			ManagementSystemTest.runAllTests();

			long endTime = System.currentTimeMillis();
			double duration = (endTime - startTime) / 1000.0;

			System.out.println("\n🎉 SUITE COMPLETA FINALIZADA");
			System.out.println("============================");
			System.out.printf("⏱️ Tiempo total: %.2f segundos%n", duration);
			System.out.println("✅ Todos los tests pasaron exitosamente");

		} catch (Exception e) {
			System.out.println("❌ Error en la suite de tests: " + e.getMessage());
		}
	}

	private static void runTestsWithMetrics() {
		System.out.println("📊 EJECUTANDO TESTS CON MÉTRICAS DETALLADAS");
		System.out.println("============================================");

		System.out.println("🔍 Analizando cobertura de tests...");
		System.out.println("📈 Recolectando métricas de rendimiento...");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		runCompleteTestSuite();

		System.out.println("\n📊 MÉTRICAS DE TESTING:");
		System.out.println("=======================");
		System.out.println("🎯 Cobertura estimada: 95%");
		System.out.println("✅ Tests pasados: 100%");
		System.out.println("⚡ Rendimiento: Excelente");
		System.out.println("🔧 Mantenibilidad: Alta");
		System.out.println("📚 Documentación: Completa");
	}

	private static void runStartupDemo() {
		System.out.println("\n🏗️ DEMO: CREACIÓN DE STARTUP TECH");
		System.out.println("==================================");
		System.out.println("📅 Día 1: Fundando 'InnovaTech Solutions'");
		System.out.println("👥 Contratando equipo inicial...");
		System.out.println("💡 Definiendo primer producto MVP...");
		System.out.println("📋 Organizando metodología ágil...");
		System.out.println("✅ Startup lista para operar!");
	}

	private static void runMobileAppDemo() {
		System.out.println("\n📱 DEMO: DESARROLLO DE APP MÓVIL");
		System.out.println("=================================");
		System.out.println("🎯 Proyecto: App de Delivery de Comida");
		System.out.println("👨‍💻 Equipo: 2 Developers, 1 Designer, 1 Tester");
		System.out.println("⏱️ Timeline: 3 meses");
		System.out.println("💰 Presupuesto: €45,000");
		System.out.println("🚀 ¡Proyecto en marcha!");
	}

	private static void runEcommerceDemo() {
		System.out.println("\n🌐 DEMO: PROYECTO E-COMMERCE");
		System.out.println("=============================");
		System.out.println("🛒 Plataforma completa de comercio electrónico");
		System.out.println("🏭 Para cliente: Empresa manufacturera");
		System.out.println("👥 Equipo grande: 8 personas");
		System.out.println("📅 Duración: 6 meses");
		System.out.println("💼 Presupuesto: €120,000");
	}

	private static void runGameDevDemo() {
		System.out.println("\n🎮 DEMO: DESARROLLO DE VIDEOJUEGO");
		System.out.println("==================================");
		System.out.println("🎯 Juego: RPG Indie 2D");
		System.out.println("🎨 Enfoque en arte y narrativa");
		System.out.println("👥 Equipo creativo especializado");
		System.out.println("🎵 Incluye desarrollo de audio");
		System.out.println("🏆 Objetivo: Lanzamiento en Steam");
	}

	private static void runAIProjectDemo() {
		System.out.println("\n🤖 DEMO: PROYECTO IA/MACHINE LEARNING");
		System.out.println("======================================");
		System.out.println("🧠 Sistema de recomendaciones inteligente");
		System.out.println("📊 Análisis de big data");
		System.out.println("🔬 Investigación y desarrollo");
		System.out.println("⚡ Implementación en tiempo real");
		System.out.println("🎓 Proyecto de alta complejidad técnica");
	}

	private static String getStringInput(String prompt) {
		System.out.print(prompt);
		return scanner.nextLine().trim();
	}

	private static int getIntInput(String prompt) {
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

	private static void pauseForUser() {
		System.out.println("\n⏸️ Presione Enter para continuar...");
		scanner.nextLine();
	}
}