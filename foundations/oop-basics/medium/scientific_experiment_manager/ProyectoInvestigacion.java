package java_oop.medium.scientific_experiment_manager;

import java.util.ArrayList;
import java.util.List;

public class ProyectoInvestigacion {

	private final String nombre;
	private final List<Experimento> experimentos;

	public ProyectoInvestigacion(String nombre) {
		if (nombre == null || nombre.trim().isEmpty()) {
			throw new IllegalArgumentException("El nombre del proyecto no puede estar vacío.");
		}
		this.nombre = nombre;
		this.experimentos = new ArrayList<>();
	}

	public void agregarExperimento(Experimento experimento) {
		if (experimento == null) {
			throw new IllegalArgumentException("El experimento no puede ser nulo.");
		}
		experimentos.add(experimento);
	}

	public void ejecutarExperimentos() {
		System.out.println("Ejecutando experimentos del proyecto '" + nombre + "':");
		for (Experimento experimento : experimentos) {
			try {
				experimento.ejecutarExperimento();
			} catch (ExperimentoFallidoException e) {
				System.err.println("Error: " + e.getMessage());
			}
		}
	}

	public void analizarResultados() {
		System.out.println("\nAnalizando resultados del proyecto '" + nombre + "':");
		for (Experimento experimento : experimentos) {
			experimento.analizarResultados();
			System.out.println();
		}
	}

	public String getNombre() {
		return nombre;
	}
}
