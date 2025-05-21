package java_oop.basics.student_system_2.management;

import java.util.Scanner;

import java_oop.basics.student_system_2.exceptions.PersonExist;
import java_oop.basics.student_system_2.people.Car;
import java_oop.basics.student_system_2.people.Student;

public class StudentMenuManagement {

	Scanner scanner = new Scanner(System.in);
	private static int option;

	public static void showMenu() {
		System.out.println("Men� de Opciones");
		System.out.println("--------------------------");
		System.out.println("1. Cargar Listado de Estudiantes");
		System.out.println("2. Guardar Listado de Estudiantes");
		System.out.println("3. Introducir Estudiante");
		System.out.println("4. Listar Estudiantes");
		System.out.println("5. Salir");
		System.out.println("--------------------------");
		System.out.println("Seleccione una opción:");
	}

	public void excuteOption() {

		switch (option) {
		case 1:
			option1();
			break;
		case 2:
			option2();
			break;
		case 3:
			option3();
			break;
		case 4:
			option4();
			break;
		case 5:
			System.out.println("Adios!");
			System.exit(0);
			scanner.close();
		}
	}

	public void readOption() {
		option = scanner.nextInt();

	}

	private void option1() {
		ListOfPeople.clearList();
		Student s1 = new Student("Ana", 20, new Car("Toyota", "Corolla", "Red"), 1001, "1st Year", null, null);
		Student s2 = new Student("Luis", 22, null, 1002, "2nd Year", null, null);
		try {
			s1.setGradesFromString("Math:8.5;Physics:7.0");
			ListOfPeople.addPerson(s1);
			s2.setGradesFromString("History:9.0;Chemistry:6.5");
			ListOfPeople.addPerson(s2);
			System.out.println("Listado de estudiantes cargado (simulación).");
		} catch (PersonExist e) {
			System.out.println("Error al cargar estudiantes: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error al cargar estudiantes: " + e.getMessage());
		}
	}

	private void option2() {
		System.out.println("Listado de estudiantes guardado (simulación):");
		System.out.println(ListOfPeople.getListAsString());
	}

	private void option3() {
		try {
			System.out.print("Introduce el nombre del estudiante: ");
			String name = scanner.nextLine();
			System.out.print("Introduce la edad del estudiante: ");
			int age = Integer.parseInt(scanner.nextLine());
			System.out.print("¿El estudiante tiene coche? (s/n): ");
			Car car = null;
			if (scanner.nextLine().trim().equalsIgnoreCase("s")) {
				System.out.print("Marca del coche: ");
				String trade = scanner.nextLine();
				System.out.print("Modelo del coche: ");
				String model = scanner.nextLine();
				System.out.print("Color del coche: ");
				String color = scanner.nextLine();
				car = new Car(trade, model, color);
			}
			System.out.print("Introduce el número de expediente: ");
			int recordNumber = Integer.parseInt(scanner.nextLine());
			System.out.print("Introduce el curso actual: ");
			String currentCourse = scanner.nextLine();
			System.out.print("Introduce las asignaturas y notas (formato: asignatura:nota;asignatura:nota; o vacío): ");
			String gradesString = scanner.nextLine();

			Student student = new Student(name, age, car, recordNumber, currentCourse, null, null);
			if (!gradesString.isEmpty()) {
				student.setGradesFromString(gradesString);
			}
			if (ListOfPeople.addPerson(student)) {
				System.out.println("Estudiante añadido correctamente.");
			}
		} catch (PersonExist e) {
			System.out.println("Error: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error al añadir estudiante: " + e.getMessage());
		}
	}

	private void option4() {
		ListOfPeople.listPeople();
	}

}
