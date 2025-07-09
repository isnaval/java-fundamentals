package java_oop.medium.scientific_experiment_manager;

public abstract class Experimento {
	private final String nombre;
	private final String descripcion;
	protected final Analizable estrategiaAnalisis;

	public Experimento(String nombre, String descripcion, Analizable estrategiaAnalisis) {
		if (nombre == null || nombre.trim().isEmpty()) {
			throw new IllegalArgumentException("El nombre no puede estar vacío.");
		}
		if (descripcion == null || descripcion.trim().isEmpty()) {
			throw new IllegalArgumentException("La descripción no puede estar vacía.");
		}
		if (estrategiaAnalisis == null) {
			throw new IllegalArgumentException("La estrategia de análisis no puede ser nula.");
		}
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estrategiaAnalisis = estrategiaAnalisis;
	}

	public abstract void ejecutarExperimento() throws ExperimentoFallidoException;

	public abstract boolean esExitoso();

	public void analizarResultados() {
		estrategiaAnalisis.analizarResultados(this);
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
