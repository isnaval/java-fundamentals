package java_oop.medium.scientific_experiment_manager;

public class AnalisisAvanzado implements Analizable {
	public void analizarResultados(Experimento experimento) {
		System.out.println("Análisis avanzado para '" + experimento.getNombre() + "':");
		System.out.println("Descripción: " + experimento.getDescripcion());
		System.out.println("Resultados: Análisis estadístico y modelado predictivo aplicado.");
	}

}
