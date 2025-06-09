package exceptions.exception_chain_propagation;

public class File5 {
	public String method() {
		System.out.println("📁 Procesando File5...");
		System.out.println("💥 ¡Lanzando NullPointerException!");

		throw new NullPointerException("Error crítico en File5");
	}

}
