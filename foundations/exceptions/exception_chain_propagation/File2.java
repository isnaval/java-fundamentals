package exceptions.exception_chain_propagation;

public class File2 {
	public String method() throws Exception2, Exception3, Exception4 {
		System.out.println("📁 Procesando File2...");

		File3 file3 = new File3();

		try {
			return file3.method();

		} catch (Exception3 e) {
			System.out.println("🔄 File2 capturó: " + e.getMessage());
			throw new Exception2("Error re-lanzado desde File2");
		}
	}

}
