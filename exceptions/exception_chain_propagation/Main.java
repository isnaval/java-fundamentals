package exceptions.exception_chain_propagation;

/**
 * Clase principal que demuestra la propagación en cadena de excepciones
 * 
 * Flujo de ejecución: Main → File1 → File2 → File3 → File4 → File5 (lanza
 * NullPointerException) Main ← Exception1 ← Exception2 ← Exception3 ←
 * Exception4 (propagación hacia arriba)
 */

public class Main {

	public static void main(String[] args) {
		System.out.println("🔗 ===== DEMO: Exception Chain Propagation =====");
		System.out.println("📋 Iniciando cadena de llamadas...\n");

		File1 file1 = new File1();

		try {
			String result = file1.method();
			System.out.println("✅ Resultado: " + result);

		} catch (Exception1 e) {
			System.out.println("🎯 Capturada Exception1: " + e.getMessage());

		} catch (Exception2 e) {
			System.out.println("🎯 Capturada Exception2: " + e.getMessage());

		} catch (Exception3 e) {
			System.out.println("🎯 Capturada Exception3: " + e.getMessage());

		} catch (Exception4 e) {
			System.out.println("🎯 Capturada Exception4: " + e.getMessage());
		}

		System.out.println("\n🏁 Fin del programa.");
	}

}
