package java_oop.basics.student_system_1;

public class Printer {

	public static void print(Printable p) {
		System.out.println("-----------------------------");
		System.out.println(p.getTitulo());
		System.out.println("-----------------------------");
		System.out.println(p.getResumen());
		System.out.println("-----------------------------\n");
	}

}
