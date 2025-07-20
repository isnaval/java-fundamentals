package java_oop.advanced.employee_project_management.projects;

public enum TaskPriority {
	LOW("Baja", 1), MEDIUM("Media", 2), HIGH("Alta", 3), URGENT("Urgente", 4), CRITICAL("Crítica", 5);

	private final String description;
	private final int level;

	TaskPriority(String description, int level) {
		this.description = description;
		this.level = level;
	}

	public String getDescription() {
		return description;
	}

	public int getLevel() {
		return level;
	}

	@Override
	public String toString() {
		return description + " (" + level + ")";
	}
}