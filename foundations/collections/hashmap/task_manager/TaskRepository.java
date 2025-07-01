package collections.hashmap.task_manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskRepository {
	private Map<String, Task> tasks;

	public TaskRepository() {
		this.tasks = new HashMap();
	}

	// Agrega una tarea
	public boolean addTask(Task task) {
		if (tasks.containsKey(task.getName())) {
			return false;
		}
		tasks.put(task.getName(), task);
		return true;
	}

	// Obtiene una tarea por nombre
	public Task getTask(String name) {
		return tasks.get(name);
	}

	// Verifica si existe una tarea
	public boolean exists(String name) {
		return tasks.containsKey(name);
	}

	// Elimina una tarea
	public boolean deleteTask(String name) {
		return tasks.remove(name) != null;
	}

	// Obtiene todas las tareas
	public List<Task> getAllTasks() {
		return new ArrayList<>(tasks.values());
	}

	// Obtiene tareas completadas
	public List<Task> getCompletedTasks() {
		List<Task> completed = new ArrayList<>();
		for (Task task : tasks.values()) {
			if (task.isCompleted()) {
				completed.add(task);
			}
		}
		return completed;
	}

	// Obtiene tareas pendientes
	public List<Task> getPendingTasks() {
		List<Task> pending = new ArrayList<>();
		for (Task task : tasks.values()) {
			if (!task.isCompleted()) {
				pending.add(task);
			}
		}
		return pending;
	}

	// Obtiene el número total de tareas
	public int getTotalTasks() {
		return tasks.size();
	}
}
