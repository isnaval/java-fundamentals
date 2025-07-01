package collections.hashmap.task_manager;

import java.util.List;

public class TaskService {
	private TaskRepository repository;

	public TaskService(TaskRepository repository) {
		this.repository = repository;
	}

	// Crea una nueva tarea
	public void createTask(String name) {
		Task task = new Task(name);
		if (repository.addTask(task)) {
			System.out.println("✅ Tarea agregada: " + name);
		} else {
			System.out.println("❌ La tarea ya existe");
		}
	}

	// Completa una tarea
	public void completeTask(String name) {
		Task task = repository.getTask(name);
		if (task == null) {
			System.out.println("❌ Tarea no encontrada");
			return;
		}

		if (task.isCompleted()) {
			System.out.println("ℹ️  La tarea ya estaba completada");
			return;
		}

		task.complete();
		System.out.println("✅ Tarea completada: " + name);
	}

	// Elimina una tarea
	public void deleteTask(String name) {
		if (repository.deleteTask(name)) {
			System.out.println("🗑️  Tarea eliminada: " + name);
		} else {
			System.out.println("❌ Tarea no encontrada");
		}
	}

	// Muestra todas las tareas
	public void displayAllTasks() {
		List<Task> tasks = repository.getAllTasks();

		if (tasks.isEmpty()) {
			System.out.println("\n📋 No hay tareas registradas");
			return;
		}

		System.out.println("\n=== LISTA DE TAREAS ===");
		System.out.println("─".repeat(40));

		int index = 1;
		for (Task task : tasks) {
			System.out.println(index + ". " + task);
			index++;
		}
		System.out.println("─".repeat(40));
	}

	// Muestra estadísticas
	public void displayStatistics() {
		int total = repository.getTotalTasks();

		if (total == 0) {
			System.out.println("\n📊 No hay tareas para analizar");
			return;
		}

		int completed = repository.getCompletedTasks().size();
		int pending = repository.getPendingTasks().size();

		System.out.println("\n=== ESTADÍSTICAS ===");
		System.out.println("Total de tareas: " + total);
		System.out.println("Completadas: " + completed);
		System.out.println("Pendientes: " + pending);

		double percentage = (completed * 100.0) / total;
		System.out.println("Progreso: " + String.format("%.1f", percentage) + "%");

		drawProgressBar(percentage);
	}

	// Dibuja una barra de progreso
	private void drawProgressBar(double percentage) {
		int barLength = 20;
		int filled = (int) (barLength * percentage / 100);

		System.out.print("\n[");
		for (int i = 0; i < barLength; i++) {
			if (i < filled) {
				System.out.print("█");
			} else {
				System.out.print("░");
			}
		}
		System.out.println("]");
	}

}
