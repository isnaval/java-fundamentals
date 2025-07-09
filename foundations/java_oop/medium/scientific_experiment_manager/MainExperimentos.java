package java_oop.medium.scientific_experiment_manager;

public class MainExperimentos {
	public static void main(String[] args) {
		try {
			Analizable analisisEstandar = new AnalisisEstandar();
			Analizable analisisAvanzado = new AnalisisAvanzado();

			ExperimentoFisico expFisico = new ExperimentoFisico("ExpFisico1", "Estudio de partículas", "Partícula X", 1,
					analisisEstandar);
			ExperimentoBiologico expBio = new ExperimentoBiologico("ExpBio1", "Análisis celular", "Bacteria Y", 3,
					analisisAvanzado);

			ProyectoInvestigacion proyecto = new ProyectoInvestigacion("Proyecto Alfa");
			proyecto.agregarExperimento(expFisico);
			proyecto.agregarExperimento(expBio);

			proyecto.ejecutarExperimentos();
			proyecto.analizarResultados();
		} catch (IllegalArgumentException e) {
			System.err.println("Error de configuración: " + e.getMessage());
		}
	}

}
