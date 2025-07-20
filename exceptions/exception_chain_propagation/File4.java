package exceptions.exception_chain_propagation;

public class File4 {
	public String method() throws Exception4 {
		System.out.println("📁 Procesando File4...");

		File5 file5 = new File5();

		try {
			return file5.method();

		} catch (NullPointerException e) {
			System.out.println("🔄 File4 capturó: " + e.getMessage());
			throw new Exception4("Error re-lanzado desde File4");
		}
	}

}
