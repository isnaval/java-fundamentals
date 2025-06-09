package exceptions.exception_chain_propagation;

public class File3 {
	public String method() throws Exception3, Exception4 {
		System.out.println("📁 Procesando File3...");

		File4 file4 = new File4();

		try {
			return file4.method();

		} catch (Exception4 e) {
			System.out.println("🔄 File3 capturó: " + e.getMessage());
			throw new Exception3("Error re-lanzado desde File3");
		}
	}
}
