package exceptions.error_propagation;

public class File02 {
	public String method() {
		System.out.println("Fichero 2");
		File03 file03 = new File03();
		return file03.method();
	}

}
