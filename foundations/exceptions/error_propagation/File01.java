package error_propagation;

public class File01 {
	
	public String method() {
		System.out.println("Fichero 1");
		File02 file02 = new File02();
		return file02.method();
	}
}
