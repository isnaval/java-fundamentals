package validation_utils;

public class Utils {

	public static double divide(double numerator, double denominator) {
		
		if(denominator == 0) {
			throw new ArithmeticException("No se puede dividir entre 0");
		}
		return numerator/denominator;
	}
	
	public static int add (int value1, int value2) {
		long result = (long)value1 + (long)value2; 
		if (result > Integer.MAX_VALUE) {
			throw new ArithmeticException("La suma excede el valor máximo de un int");
		}
		return value1+ value2;
	}
	
	public static double squareRoot(double value) {
		if(value < 0) {
			throw new ArithmeticException("No se puede calcular la raíz cuadrada de un número negativo");
		}
		
		return Math.sqrt(value);
	}
	
	public static int calculateTextLength (String text) {
		if (text == null) {
			throw new NullPointerException("El texto no puede ser null");
		}
		return text.length();
	}
	
	public static String getWeekdayByIndex(int index) {
        String[] weekdays = {"", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        
        if (index <1 || index >= weekdays.length) {
        	throw new ArrayIndexOutOfBoundsException("El índide debe estar entre 1 y 7");
        }
        return weekdays[index];
	}
}
