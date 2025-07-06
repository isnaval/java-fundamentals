package java_core_basic.generic_container;

public class LibroElectronico<T> {
	private String titulo;
	private String autor;
	private T precio;

	public LibroElectronico() {

	}

	public LibroElectronico(String titulo, String autor, T precio) {
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public T getPrecio() {
		return precio;
	}

	public void setPrecio(T precio) {
		this.precio = precio;
	}

	public void mostrarDetalles() {
		System.out.println("-".repeat(40));
		System.out.println("         INFORMACIÓN DEL LIBRO      ");
		System.out.println("-".repeat(40));
		System.out.println("Título: " + titulo);
		System.out.println("Autor: " + autor);
		System.out.println("Precio: " + precio);
		System.out.println("-".repeat(40));
	}

	@Override
	public String toString() {
		return "LibroElectronico [titulo=" + titulo + ", autor=" + autor + ", precio=" + precio + "]";
	}

}
