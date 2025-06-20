package java_core_basic.string;

public class File_Processing {
	public static void main(String[] args) {
		System.out.println("=== Tag Processing ===");
		String[] tags = { "#arquitectura", "#cine", "#teatro" };

		// hacemos el recorrido con un for-each el recorrido del bucle
		// hacemos el operador condicional o ternario
		for (String tag : tags) {
			String cleanTag = (tag.startsWith("#")) ? tag.substring(1) : tag;
			System.out.println("Enviando al servidor: " + cleanTag);
		}

		System.out.println("\n=== File Name Processing ===");
		String fileName = "example.file.xml";

		//
		int lastDotIndex = fileName.lastIndexOf('.');
		String name = fileName.substring(0, lastDotIndex);
		String correctName = name.replace(".", " ");
		String extension = fileName.substring(lastDotIndex + 1);

		System.out.println("Tamaño del nombre archivo hasta el ultimo punto: " + lastDotIndex);
		System.out.println(name);
		System.out.println("Archivo original: " + fileName);
		System.out.println("Nombre limpio: " + correctName);
		System.out.println("Extensión: " + extension);
	}

}
