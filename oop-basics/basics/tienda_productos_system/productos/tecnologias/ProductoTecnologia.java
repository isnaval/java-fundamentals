package java_oop.basics.tienda_productos_system.productos.tecnologias;

import java_oop.basics.tienda_productos_system.interfaces.Producto;

public class ProductoTecnologia implements Producto {
	private String nombre;
	private double precio;
	private int garantiaMeses;
	private String marca;

	public ProductoTecnologia(String nombre, double precio, int garantiaMeses, String marca) {
		this.nombre = nombre;
		this.precio = precio;
		this.garantiaMeses = garantiaMeses;
		this.marca = marca;
	}

	@Override
	public String obtenerInformacion() {
		return "📱 " + nombre + " (" + marca + ") - Garantía: " + garantiaMeses + " meses";
	}

	@Override
	public double calcularPrecio() {
		double precioFinal = precio;
		if (garantiaMeses >= 24) {
			precioFinal *= 1.1;
		}
		if (marca.equals("Apple") || marca.equals("Samsung")) {
			precioFinal *= 1.15;
		}

		return precioFinal;
	}

	@Override
	public String getNombre() {
		return nombre;
	}
}