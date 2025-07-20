package java_oop.medium.scientific_experiment_manager;

public class ExperimentoBiologico extends ExperimentoConOrganismo {
	public ExperimentoBiologico(String nombre, String descripcion, String organismo, int nivelAmenaza,
			Analizable estrategiaAnalisis) {
		super(nombre, descripcion, organismo, nivelAmenaza, estrategiaAnalisis);
	}

	@Override
	public void analizarResultados() {
		System.out.println("Análisis específico para experimento biológico '" + getNombre() + "':");
		System.out.println("Organismo: " + getOrganismo() + ", Nivel de amenaza: " + getNivelAmenaza());
		super.analizarResultados();
	}

}
