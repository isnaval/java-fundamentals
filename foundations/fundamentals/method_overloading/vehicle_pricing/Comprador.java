package fundamentals.method_overloading.vehicle_pricing;

public class Comprador {

	private String nombre;
	private double presupuesto;
	private int edad;
	private boolean tieneLicencia;
	private double ingresosMensuales;

	public Comprador(String nombre, double presupuesto) {
		if (nombre == null || nombre.trim().isEmpty()) {
			throw new IllegalArgumentException("El nombre no puede estar vacío");
		}
		if (presupuesto < 0) {
			throw new IllegalArgumentException("El presupuesto no puede ser negativo");
		}

		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.edad = 25;
		this.tieneLicencia = true;
		this.ingresosMensuales = presupuesto / 12;
	}

	public Comprador(String nombre, double presupuesto, int edad, boolean tieneLicencia, double ingresosMensuales) {
		this(nombre, presupuesto);
		this.edad = edad;
		this.tieneLicencia = tieneLicencia;
		this.ingresosMensuales = ingresosMensuales;
	}

	public boolean realizarOfertaCompra(Vehiculo vehiculo) {
		if (!tieneLicencia) {
			System.out.println("No se puede realizar la compra: el comprador no tiene licencia");
			return false;
		}

		double precioFinal = vehiculo.calcularPrecioFinal();
		return presupuesto >= precioFinal;
	}

	public boolean realizarOfertaCompra(Vehiculo vehiculo, int cuotas) {
		if (!tieneLicencia) {
			System.out.println("No se puede realizar la compra: el comprador no tiene licencia");
			return false;
		}

		if (cuotas <= 0) {
			throw new IllegalArgumentException("El número de cuotas debe ser positivo");
		}

		double costeTotal = vehiculo.calcularPrecioFinal() + (cuotas * 15);
		return presupuesto >= costeTotal;
	}

	public boolean realizarOfertaCompra(Vehiculo vehiculo, int meses, double tasaInteres) {
		if (!tieneLicencia) {
			System.out.println("No se puede realizar la compra: el comprador no tiene licencia");
			return false;
		}

		double precioFinanciado = vehiculo.calcularPrecioFinanciado(meses, tasaInteres);
		double cuotaMensual = precioFinanciado / meses;

		// La cuota mensual no debe exceder el 30% de los ingresos
		double limiteEndeudamiento = ingresosMensuales * 0.30;
		return cuotaMensual <= limiteEndeudamiento;
	}

	public boolean realizarOfertaCompra(Vehiculo vehiculo, double entrada, int cuotas) {
		if (!tieneLicencia) {
			System.out.println("No se puede realizar la compra: el comprador no tiene licencia");
			return false;
		}

		if (entrada < 0 || cuotas <= 0) {
			throw new IllegalArgumentException("Entrada y cuotas deben ser valores positivos");
		}

		if (entrada > presupuesto) {
			return false;
		}

		double resto = vehiculo.calcularPrecioFinal() - entrada;
		double cuotaMensual = resto / cuotas;
		double limiteEndeudamiento = ingresosMensuales * 0.30;

		return cuotaMensual <= limiteEndeudamiento;
	}

	public double calcularCapacidadCompra() {
		return presupuesto;
	}

	public double calcularCapacidadFinanciacion() {
		return ingresosMensuales * 0.30;
	}

	public String obtenerInformacionCompleta() {
		return String.format(
				"=== INFORMACIÓN DEL COMPRADOR ===\n" + "Nombre: %s\n" + "Edad: %d años\n" + "Presupuesto: €%.2f\n"
						+ "Ingresos mensuales: €%.2f\n" + "Tiene licencia: %s\n"
						+ "Capacidad de financiación mensual: €%.2f",
				nombre, edad, presupuesto, ingresosMensuales, tieneLicencia ? "Sí" : "No",
				calcularCapacidadFinanciacion());
	}

	public String getNombre() {
		return nombre;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public int getEdad() {
		return edad;
	}

	public boolean isTieneLicencia() {
		return tieneLicencia;
	}

	public double getIngresosMensuales() {
		return ingresosMensuales;
	}

	public void setPresupuesto(double presupuesto) {
		if (presupuesto < 0) {
			throw new IllegalArgumentException("El presupuesto no puede ser negativo");
		}
		this.presupuesto = presupuesto;
	}

	public void setIngresosMensuales(double ingresosMensuales) {
		if (ingresosMensuales < 0) {
			throw new IllegalArgumentException("Los ingresos no pueden ser negativos");
		}
		this.ingresosMensuales = ingresosMensuales;
	}

	@Override
	public String toString() {
		return String.format("%s (Presupuesto: €%.2f, Ingresos: €%.2f/mes)", nombre, presupuesto, ingresosMensuales);
	}
}
