package collections.hashmap.task_manager;

import java.util.Scanner;

public class TaskManagerMain {

	public static void main(String[] args) {
		TaskRepository repository = new TaskRepository();
		TaskService service = new TaskService(repository);
		Scanner scanner = new Scanner(System.in);

		System.out.println("📝 Bienvenido al Gestor de Tareas");

		while (true) {
			showMenu();

			int option = scanner.nextInt();
			scanner.nextLine(); // Limpiar buffer

			switch (option) {
			case 1:
				service.displayAllTasks();
				break;

			case 2:
				System.out.print("\nIngrese la nueva tarea: ");
				String newTask = scanner.nextLine();
				service.createTask(newTask);
				break;

			case 3:
				System.out.print("\nIngrese la tarea a completar: ");
				String taskToComplete = scanner.nextLine();
				service.completeTask(taskToComplete);
				break;

			case 4:
				System.out.print("\nIngrese la tarea a eliminar: ");
				String taskToDelete = scanner.nextLine();
				service.deleteTask(taskToDelete);
				break;

			case 5:
				service.displayStatistics();
				break;

			case 6:
				System.out.println("\n👋 ¡Hasta luego!");
				scanner.close();
				return;

			default:
				System.out.println("❌ Opción no válida");
			}

			System.out.print("\nPresione Enter para continuar...");
			scanner.nextLine();
		}
	}

	private static void showMenu() {
		System.out.println("\n╔═══════════════════════════╗");
		System.out.println("║     GESTOR DE TAREAS      ║");
		System.out.println("╠═══════════════════════════╣");
		System.out.println("║ 1. Ver tareas             ║");
		System.out.println("║ 2. Agregar tarea          ║");
		System.out.println("║ 3. Completar tarea        ║");
		System.out.println("║ 4. Eliminar tarea         ║");
		System.out.println("║ 5. Ver estadísticas       ║");
		System.out.println("║ 6. Salir                  ║");
		System.out.println("╚═══════════════════════════╝");
		System.out.print("Seleccione opción: ");
	}
}