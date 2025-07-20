package java_oop.basics.tienda_productos_system.productos.joyas;

import java_oop.basics.tienda_productos_system.interfaces.Joya;

public class CollarConPerlas implements Joya {
	private String nombre;
	private int numeroPerlas;
	private int calidad;
	private double longitud;

	public CollarConPerlas(String nombre, int numeroPerlas, int calidad, double longitud) {
		this.nombre = nombre;
		this.numeroPerlas = numeroPerlas;
		this.calidad = calidad;
		this.longitud = longitud;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroPerlas() {
		return numeroPerlas;
	}

	public void setNumeroPerlas(int numeroPerlas) {
		this.numeroPerlas = numeroPerlas;
	}

	public int getCalidad() {
		return calidad;
	}

	public void setCalidad(int calidad) {
		this.calidad = calidad;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	@Override
	public String obtenerInformacion() {
		return "📿 " + nombre + " - " + numeroPerlas + " perlas, calidad " + calidad + "/5, " + longitud + "cm";
	}

	@Override
	public double calcularPrecio() {
		double precio = 100;
		precio += numeroPerlas * calidad * 10;
		if (longitud > 50)
			precio += 50;

		return precio;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public String getMaterial() {
		return "Perlas";
	}

	@Override
	public double calcularValorCalidad() {
		return numeroPerlas * calidad * 10;
	}

}
