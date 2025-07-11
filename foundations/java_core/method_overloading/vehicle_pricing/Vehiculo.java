package java_core.method_overloading.vehicle_pricing;

public class Vehiculo {

	private String marca;
	private String modelo;
	private double precio;
	private int año;
	private String color;

	public Vehiculo(String marca, String modelo, double precio) {
		if (marca == null || marca.trim().isEmpty()) {
			throw new IllegalArgumentException("La marca no puede estar vacía");
		}
		if (modelo == null || modelo.trim().isEmpty()) {
			throw new IllegalArgumentException("El modelo no puede estar vacío");
		}
		if (precio < 0) {
			throw new IllegalArgumentException("El precio no puede ser negativo");
		}

		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.año = 2024;
		this.color = "Blanco";
	}

	public Vehiculo(String marca, String modelo, double precio, int año, String color) {
		this(marca, modelo, precio); // Llamar al constructor principal
		this.año = año;
		this.color = color != null ? color : "Blanco";
	}

	public double calcularPrecioFinal() {
		return precio * 1.15;
	}

	public double calcularPrecioFinal(double descuento) {
		if (descuento < 0) {
			throw new IllegalArgumentException("El descuento no puede ser negativo");
		}
		if (descuento > precio) {
			throw new IllegalArgumentException("El descuento no puede ser mayor al precio del vehículo");
		}

		return precio - descuento;
	}

	public double calcularPrecioFinal(double descuento, double impuesto) {
		if (descuento < 0) {
			throw new IllegalArgumentException("El descuento no puede ser negativo");
		}
		if (impuesto < 0) {
			throw new IllegalArgumentException("El impuesto no puede ser negativo");
		}

		return (precio * (1 + impuesto / 100)) - descuento;
	}

	public double calcularPrecioFinanciado(int meses, double tasaInteres) {
		if (meses <= 0) {
			throw new IllegalArgumentException("El número de meses debe ser positivo");
		}
		if (tasaInteres < 0) {
			throw new IllegalArgumentException("La tasa de interés no puede ser negativa");
		}

		double tasaMensual = tasaInteres / 12 / 100;
		return precio * (1 + tasaMensual * meses);
	}

	public double calcularDescuentoPorAntiguedad() {
		int añoActual = java.time.Year.now().getValue();
		int antiguedad = añoActual - año;

		if (antiguedad <= 1)
			return 0.0;
		if (antiguedad <= 3)
			return 5.0;
		if (antiguedad <= 5)
			return 10.0;
		if (antiguedad <= 10)
			return 15.0;
		return 20.0; // Más de 10 años
	}

	public String obtenerInformacionCompleta() {
		return String.format(
				"=== INFORMACIÓN DEL VEHÍCULO ===\n" + "Marca: %s\n" + "Modelo: %s\n" + "Año: %d\n" + "Color: %s\n"
						+ "Precio base: €%.2f\n" + "Precio con recargo (15%%): €%.2f\n" + "Con descuento €2000: €%.2f\n"
						+ "Con descuento €1500 e IVA 10%%: €%.2f\n" + "Descuento por antigüedad: %.1f%%",
				marca, modelo, año, color, precio, calcularPrecioFinal(), calcularPrecioFinal(2000.0),
				calcularPrecioFinal(1500.0, 10.0), calcularDescuentoPorAntiguedad());
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public double getPrecio() {
		return precio;
	}

	public int getAño() {
		return año;
	}

	public String getColor() {
		return color;
	}

	public void setPrecio(double precio) {
		if (precio < 0) {
			throw new IllegalArgumentException("El precio no puede ser negativo");
		}
		this.precio = precio;
	}

	public void setColor(String color) {
		this.color = color != null ? color : "Blanco";
	}

	@Override
	public String toString() {
		return String.format("%s %s (%d) - €%.2f [%s]", marca, modelo, año, precio, color);
	}
}
