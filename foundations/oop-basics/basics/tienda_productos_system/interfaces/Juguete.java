package java_oop.basics.tienda_productos_system.interfaces;

public interface Juguete extends Producto {
	int getEdadMinima();

	boolean esSeguroParaEdad(int edad);

}
