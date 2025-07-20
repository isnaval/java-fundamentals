package fundamentals.arrays;

import java.util.ArrayList;

public class ArrayListBasics {
	public static void main(String[] args) {
		weekDaysDemo();
	}

	public static void weekDaysDemo() {
		ArrayList<String> weekDays = new ArrayList<>();
		weekDays.add("Lunes");
		weekDays.add("Martes");
		weekDays.add("Miércoles");
		weekDays.add("Jueves");
		weekDays.add("Viernes");
		weekDays.add("Sábado");
		weekDays.add("Domingo");
		weekDays.add("Día extra");

		System.out.println("Lista original: " + weekDays);

		weekDays.remove(7);
		System.out.println("Lista corregida: " + weekDays);

		System.out.println("Total días: " + weekDays.size());
		System.out.println("Primer día: " + weekDays.get(0));
		System.out.println("Último día: " + weekDays.get(weekDays.size() - 1));
	}

}
