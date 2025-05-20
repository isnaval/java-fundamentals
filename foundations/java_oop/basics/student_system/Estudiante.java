package java_oop.basics.student_system;

public class Estudiante extends MiembroUPV implements Printable {

	private int expediente;
	private String cursoActual;
	private String asignaturas[];
	private float notas[];

	public Estudiante(String nombre, int edad, String carnet) {
		super(nombre, edad, carnet);
	}

	public int getExpediente() {
		return expediente;
	}

	public void setExpediente(int expediente) {
		this.expediente = expediente;
	}

	public String getCursoActual() {
		return cursoActual;
	}

	public void setCursoActual(String cursoActual) {
		this.cursoActual = cursoActual;
	}

	public String[] getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(String[] asignaturas) {
		this.asignaturas = asignaturas;
	}

	public float[] getNotas() {
		return notas;
	}

	public void setNotas(float[] notas) {
		this.notas = notas;
	}

	@Override
	public void menuIntranet() {

		System.out.println("Intranet Estudiante");
		System.out.println("---------------------------------");
		System.out.println("1. Ver Expediente");
		System.out.println("2. Inscripcion Actividades Deportivas");
		System.out.println("---------------------------------\n");

	}

	@Override
	public String getTitulo() {
		return "FICHA DE ESTUDIANTE";
	}

	@Override
	public String getResumen() {
		return "Nombre: " + this.getNombre() + "\n" + "Edad: " + this.getEdad() + "\n" + "Carnet: " + this.getCarnet()
				+ "\n" + "Curso: " + this.getCursoActual();
	}

}
