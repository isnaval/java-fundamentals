package java_oop.advanced.employee_project_management.projects;

public enum ProjectStatus {
	PLANNING("Planificación"), IN_PROGRESS("En Progreso"), TESTING("En Pruebas"), COMPLETED("Completado"),
	CANCELLED("Cancelado"), ON_HOLD("En Pausa");

	private final String description;

	ProjectStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return description;
	}
}