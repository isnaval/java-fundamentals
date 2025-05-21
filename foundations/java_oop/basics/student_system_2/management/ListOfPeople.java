package java_oop.basics.student_system_2.management;

import java_oop.basics.student_system_2.exceptions.PersonExist;
import java_oop.basics.student_system_2.people.Person;
import java_oop.basics.student_system_2.people.Student;

public class ListOfPeople {

	static private Person listOfPeople[] = new Person[100];
	static private int size = 0;

	public static Person[] getListOfPeople() {
		return listOfPeople;
	}

	public static void setListOfPeople(Person listOfPeople[]) {
		ListOfPeople.listOfPeople = listOfPeople;
	}

	public static int getSize() {
		return size;
	}

	public static void setSize(int size) {
		ListOfPeople.size = size;
	}

	// Añadir una persona al arreglo
	public static boolean addPerson(Person person) throws PersonExist {
		if (size < listOfPeople.length) {
			listOfPeople[size] = person;
			size++;
			return true;
		} else {
			System.out.println("Error: No hay espacio para añadir más personas.");
			return false;
		}
	}

	// Listar todas las personas
	public static void listPeople() {
		if (size == 0) {
			System.out.println("No hay personas en el listado.");
		} else {
			System.out.println("\nListado de Personas:");
			System.out.println("--------------------------");
			for (int i = 0; i < size; i++) {
				Person p = listOfPeople[i];
				System.out.printf("Persona %d:%n", i + 1);
				System.out.printf("Nombre: %s%n", p.getName());
				System.out.printf("Edad: %d%n", p.getAge());
				if (p instanceof Student) {
					Student s = (Student) p;
					System.out.printf("Expediente: %d%n", s.getRecordNumber());
					System.out.printf("Curso: %s%n", s.getCurrentCourse());
					System.out.printf("Asignaturas y notas: %s%n", s.getFormattedGrades());
					System.out.printf("Nota media: %.2f%n", s.getMediumGrade());
				}
				System.out.println("--------------------------");
			}
		}
	}

	// Limpiar la lista (simulación de "cargar")
	public static void clearList() {
		for (int i = 0; i < size; i++) {
			listOfPeople[i] = null;
		}
		size = 0;
		System.out.println("Listado limpiado (simulación de carga).");
	}

	// Obtener la lista como cadena (simulación de "guardar")
	public static String getListAsString() {
		if (size == 0) {
			return "No hay personas en el listado.";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			Person p = listOfPeople[i];
			sb.append(p.getName()).append(",").append(p.getAge());
			if (p instanceof Student) {
				Student s = (Student) p;
				sb.append(",").append(s.getRecordNumber()).append(",").append(s.getCurrentCourse()).append(",")
						.append(s.getFormattedGrades());
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
