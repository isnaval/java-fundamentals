package java_oop.basics.student_system;

/**
 * los principales conceptos que hemos analizado son los siguientes: - Herencia:
 * Se establece una jerarquía de clases donde Estudiante hereda de MiembroUPV. -
 * Clases abstractas: MiembroUPV es una clase abstracta, lo que significa que no
 * se puede instanciar directamente, sino que sirve como plantilla para sus
 * clases hijas. - Interfaces: Se define la interfaz Printable con los métodos
 * getTitulo() y getResumen(), que luego son implementados por diferentes clases
 * como Estudiante y Coche. - Polimorfismo: Se utiliza el polimorfismo cuando se
 * crea un array de tipo Printable[] que puede contener tanto objetos Estudiante
 * como Coche, y cuando se llama al método Printer.print() que acepta cualquier
 * objeto que implemente la interfaz Printable. - Encapsulamiento: Se utilizan
 * modificadores de acceso (private, protected) y métodos getter/setter para
 * controlar el acceso a los atributos de las clases. - Sobrescritura de
 * métodos: Se sobrescribe el método menuIntranet() en la clase Estudiante para
 * proporcionar una implementación específica. - Composición y agregación: Se
 * manejan relaciones entre objetos, como un estudiante que tiene asignaturas y
 * notas. - Principio de sustitución de Liskov: Se aplica al poder usar objetos
 * de subclases (como Estudiante) en lugar de objetos de superclases (como
 * Persona) o interfaces (Printable).
 */

public class Main {

	public static void main(String[] args) {
		Estudiante est1 = new Estudiante("Ana García", 21, "CARNET12345");
		est1.setAsignaturas(new String[] { "Programación", "Bases de Datos", "Matemáticas" });
		est1.setNotas(new float[] { 8.5f, 9.0f, 7.5f });
		est1.setCursoActual("Ingenieria Informatica");

		Estudiante est2 = new Estudiante("Carlos López", 28, "CARNET67890");

		Coche coche1 = new Coche("Toyota", "Corolla", "Azul");

		// Mostrar menú de intranet
		System.out.println("Acceso a intranet:");
		est1.menuIntranet();

		// Imprimir información usando la clase Printer
		System.out.println("Información de entidades:");
		Printer.print(est1);
		Printer.print(est2);
		Printer.print(coche1);

		System.out.println("Demostración de polimorfismo:");
		Printable[] imprimibles = { est1, est2, coche1 };
		for (Printable p : imprimibles) {
			Printer.print(p);
		}

	}

}
