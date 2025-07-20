package exceptions.exception_chain_propagation;

public class File1 {

	public String method() throws Exception1, Exception2, Exception3, Exception4 {
		System.out.println("📁 Procesando File1...");

		File2 file2 = new File2();

		try {
			return file2.method();

		} catch (Exception2 e) {
			System.out.println("🔄 File1 capturó: " + e.getMessage());
			throw new Exception1("Error re-lanzado desde File1");
		}
	}

}
