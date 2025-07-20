package java_oop.basics.student_system_2.exceptions;

@SuppressWarnings("serial")
public class PersonExist extends Exception {

	public PersonExist(String nombre) {
		super("La Persona " + nombre + " ya existe");
	}

}
