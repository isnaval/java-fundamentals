package java_oop.medium.scientific_experiment_manager;

public class AnalisisEstandar implements Analizable {
	public void analizarResultados(Experimento experimento) {
		System.out.println("Análisis estándar para '" + experimento.getNombre() + "':");
		System.out.println("Descripción: " + experimento.getDescripcion());
		System.out.println("Resultados: Datos recopilados según protocolo estándar.");
	}

}
