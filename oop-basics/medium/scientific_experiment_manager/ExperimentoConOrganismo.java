package java_oop.medium.scientific_experiment_manager;

import java.util.Scanner;

public class ExperimentoConOrganismo extends Experimento {
	private final String organismo;
	private final int nivelAmenaza;

	public ExperimentoConOrganismo(String nombre, String descripcion, String organismo, int nivelAmenaza,
			Analizable estrategiaAnalisis) {
		super(nombre, descripcion, estrategiaAnalisis);
		if (organismo == null || organismo.trim().isEmpty()) {
			throw new IllegalArgumentException("El organismo no puede estar vacío.");
		}
		if (nivelAmenaza < 0 || nivelAmenaza > 5) {
			throw new IllegalArgumentException("El nivel de amenaza debe estar entre 0 y 5.");
		}
		this.organismo = organismo;
		this.nivelAmenaza = nivelAmenaza;
	}

	@Override
	public void ejecutarExperimento() throws ExperimentoFallidoException {
		System.out.println("Ejecutando experimento '" + getNombre() + "' con organismo: " + organismo);
		if (!esExitoso()) {
			throw new ExperimentoFallidoException("El experimento '" + getNombre() + "' ha fallado.");
		}
	}

	@Override
	public boolean esExitoso() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("¿El experimento '" + getNombre() + "' ha tenido éxito? (si/no)");
		String respuesta;
		do {
			respuesta = scanner.nextLine().trim().toLowerCase();
			if (!respuesta.equals("si") && !respuesta.equals("no")) {
				System.out.println("Respuesta inválida. Ingrese 'si' o 'no'.");
			}
		} while (!respuesta.equals("si") && !respuesta.equals("no"));
		return respuesta.equals("si");
	}

	public String getOrganismo() {
		return organismo;
	}

	public int getNivelAmenaza() {
		return nivelAmenaza;
	}

}
