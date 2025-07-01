package collections.hashmap.task_manager;

import java.time.LocalDateTime;

public class Task {

	private String name;
	private boolean completed;
	private LocalDateTime createdAt;
	private LocalDateTime completedAt;

	public Task(String name) {
		this.name = name;
		this.completed = false;
		this.createdAt = LocalDateTime.now();
		this.completedAt = null;
	}

	// Marca la tarea como completada
	public void complete() {
		if (!this.completed) {
			this.completed = true;
			this.completedAt = LocalDateTime.now();
		}
	}

	// Getters
	public String getName() {
		return name;
	}

	public boolean isCompleted() {
		return completed;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getCompletedAt() {
		return completedAt;
	}

	@Override
	public String toString() {
		String status = completed ? "✅ Completada" : "⏳ Pendiente";
		return name + " - " + status;
	}
}