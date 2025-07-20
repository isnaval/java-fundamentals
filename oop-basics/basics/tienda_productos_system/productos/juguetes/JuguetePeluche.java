package java_oop.basics.tienda_productos_system.productos.juguetes;

import java_oop.basics.tienda_productos_system.interfaces.Juguete;

public class JuguetePeluche implements Juguete {
	private String nombre;
	private double precio;
	private boolean esLavable;
	private String material;

	public JuguetePeluche(String nombre, double precio, boolean esLavable, String material) {
		this.nombre = nombre;
		this.precio = precio;
		this.esLavable = esLavable;
		this.material = material;
	}

	@Override
	public double calcularPrecio() {
		double precioFinal = precio;
		if (esLavable) {
			precioFinal += 8;
		}
		if (material.equals("Algodón")) {
			precioFinal *= 1.2;
		}
		return precioFinal;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public int getEdadMinima() {
		return 0;
	}

	@Override
	public boolean esSeguroParaEdad(int edad) {
		return true;
	}

	@Override
	public String obtenerInformacion() {
		String lavable = esLavable ? "lavable" : "no lavable";
		return nombre + " de " + material + " (" + lavable + ")";
	}

}
