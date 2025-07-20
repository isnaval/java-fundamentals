package java_oop.basics.tienda_productos_system.productos.joyas;

import java_oop.basics.tienda_productos_system.interfaces.Joya;

public class AnilloConDiamantes implements Joya {
	private String nombre;
	private int numeroDiamantes;
	private int calidad;
	private String material;

	public AnilloConDiamantes(String nombre, int numberoDiamantes, int calidad, String material) {
		this.nombre = nombre;
		this.numeroDiamantes = numberoDiamantes;
		this.calidad = calidad;
		this.material = material;
	}

	@Override
	public String obtenerInformacion() {
		return "💎 " + nombre + " (" + material + ") - " + numeroDiamantes + " diamantes, calidad " + calidad + "/5";
	}

	@Override
	public double calcularPrecio() {
		double precio = 200;
		precio += numeroDiamantes * calidad * 50;

		if (material.equals("Oro"))
			precio *= 1.2;
		if (material.equals("Platino"))
			precio *= 1.5;

		return precio;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public String getMaterial() {
		return material;
	}

	@Override
	public double calcularValorCalidad() {
		return numeroDiamantes * calidad * 50;
	}
}
