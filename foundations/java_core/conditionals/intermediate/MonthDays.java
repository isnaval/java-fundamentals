package java_core.conditionals.intermediate;

import java.util.Scanner;

		
		/**
		 * Ejercicio: dime el mes y el año en el que estamos y te dire, los dias que hay en el año, si es visiesto y los dias que tiene ese mes. 
		 */
		

public class MonthDays {
	
	final static  String[] MONTH_NAMES = {"enero", "febrero", "marzo", "abril", "mayo", "junio", 
	        "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
	final static int[] MONTH_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


	public static void main (String[ ] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Dime en que mes y en que año estamos: ");
		String monthStr = scanner.nextLine().toLowerCase();
		int year = scanner.nextInt();
		int month = indiceMonth(monthStr,  MONTH_NAMES);
		boolean bisiesto = isBisiesto(year);
		
		result(month, year, bisiesto); 
		scanner.close();	
	}
	

	public static  boolean isBisiesto (int year ) {
		return  ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
	}
	
	public static int indiceMonth(String month, String[]  monthNames) {
		for (int i = 0; i < monthNames.length; i++) {
			if(monthNames[i].equals(month)) {
				return i; 
			}
		}
		return -1; 
	}
	
	public static void result (int month, int year, boolean isBisiesto) {
		if (month == -1) {
            System.out.println("Mes inválido");
            return;
        };
        
		int monthDays = MONTH_DAYS[month];
		if (monthDays == 1 && isBisiesto) {
			monthDays = 29; 
		}
		
		int yearDays = isBisiesto ? 366 : 365;
        System.out.println("El año " + year + (isBisiesto ? " es bisiesto" : " no es bisiesto") + " y tiene " + yearDays + " días.");
        System.out.println("El mes de " + MONTH_NAMES[month] + " tiene " + monthDays + " días.");
	}
	
}
