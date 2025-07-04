package java_core.strings.advanced;

import java.util.HashMap;
import java.util.Map;

public class MorseDictionary {

	public static final Map<String, String> TEXT_TO_MORSE = new HashMap<>();
	public static final Map<String, String> MORSE_TO_TEXT = new HashMap<>();

	// inicializador estatica y me sirve para llenar los dos dicconarios
	// anteriores...
	// de esta forma relleno al diccionario cada vez que se inicia este codigo
	// en el primer diccionario sera completo y el segundo se hace ala inversa y de
	// ahi la busqueda

	static {
		TEXT_TO_MORSE.put("A", ".-");
		TEXT_TO_MORSE.put("B", "-...");
		TEXT_TO_MORSE.put("C", "-.-.");
		TEXT_TO_MORSE.put("D", "-..");
		TEXT_TO_MORSE.put("E", ".");
		TEXT_TO_MORSE.put("F", "..-.");
		TEXT_TO_MORSE.put("G", "--.");
		TEXT_TO_MORSE.put("H", "....");
		TEXT_TO_MORSE.put("I", "..");
		TEXT_TO_MORSE.put("J", ".---");
		TEXT_TO_MORSE.put("K", "-.-");
		TEXT_TO_MORSE.put("L", ".-..");
		TEXT_TO_MORSE.put("M", "--");
		TEXT_TO_MORSE.put("N", "-.");
		TEXT_TO_MORSE.put("O", "---");
		TEXT_TO_MORSE.put("P", ".--.");
		TEXT_TO_MORSE.put("Q", "--.-");
		TEXT_TO_MORSE.put("R", ".-.");
		TEXT_TO_MORSE.put("S", "...");
		TEXT_TO_MORSE.put("T", "-");
		TEXT_TO_MORSE.put("U", "..-");
		TEXT_TO_MORSE.put("V", "...-");
		TEXT_TO_MORSE.put("W", ".--");
		TEXT_TO_MORSE.put("X", "-..-");
		TEXT_TO_MORSE.put("Y", "-.--");
		TEXT_TO_MORSE.put("Z", "--..");
		TEXT_TO_MORSE.put("0", "-----");
		TEXT_TO_MORSE.put("1", ".----");
		TEXT_TO_MORSE.put("2", "..---");
		TEXT_TO_MORSE.put("3", "...--");
		TEXT_TO_MORSE.put("4", "....-");
		TEXT_TO_MORSE.put("5", ".....");
		TEXT_TO_MORSE.put("6", "-....");
		TEXT_TO_MORSE.put("7", "--...");
		TEXT_TO_MORSE.put("8", "---..");
		TEXT_TO_MORSE.put("9", "----.");

		// diccionario inverso
		for (String letra : TEXT_TO_MORSE.keySet()) {
			String codigoMorse = TEXT_TO_MORSE.get(letra);
			MORSE_TO_TEXT.put(codigoMorse, letra);
		}
	}

}
