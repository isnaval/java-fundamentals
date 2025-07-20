package exceptions.error_propagation;

public class File04 {

	public String method() {
		System.out.println("Fichero 4");
		File05 file05 = new File05();
		return file05.method();
	}

}
