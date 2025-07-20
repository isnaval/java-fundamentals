package java_oop.basics.tienda_productos_system.productos.juguetes;

import java_oop.basics.tienda_productos_system.interfaces.Juguete;

public class JugeteElectronico implements Juguete {
	private String nombre;
	private double precio;
	private boolean incluyePilas;
	private int edadMinima;

	public JugeteElectronico(String nombre, double precio, boolean incluyePilas, int edadMinima) {
		this.nombre = nombre;
		this.precio = precio;
		this.incluyePilas = incluyePilas;
		this.edadMinima = edadMinima;
	}

	@Override
	public String obtenerInformacion() {
		String pilas = incluyePilas ? "con pilas" : "sin pilas";
		return "🤖 " + nombre + " (" + pilas + ") - Edad: " + edadMinima + "+ años";
	}

	@Override
	public double calcularPrecio() {
		double precioFinal = precio;
		if (incluyePilas) {
			precioFinal *= 1.15;
		}
		return precioFinal;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public int getEdadMinima() {
		return edadMinima;
	}

	public boolean esSeguroParaEdad(int edad) {
		return edad >= edadMinima;
	}

}
