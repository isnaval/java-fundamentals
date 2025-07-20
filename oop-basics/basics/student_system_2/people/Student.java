package java_oop.basics.student_system_2.people;

import java.util.StringTokenizer;

public class Student extends Person {

	private int recordNumber;
	private String currentCourse;
	private String subjects[];
	private float grades[];

	public Student(String name, int age, Car car, int recordNumber, String currentCourse, String[] subjects,
			float[] grades) {
		super(name, age, car);
		this.recordNumber = recordNumber;
		this.currentCourse = currentCourse;
		this.subjects = subjects;
		this.grades = grades;
	}

	public int getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(int recordNumber) {
		this.recordNumber = recordNumber;
	}

	public String getCurrentCourse() {
		return currentCourse;
	}

	public void setCurrentCourse(String currentCourse) {
		this.currentCourse = currentCourse;
	}

	public String[] getSubjects() {
		return subjects;
	}

	public void setSubjects(String[] subjects) {
		this.subjects = subjects;
	}

	public float[] getGrades() {
		return grades;
	}

	public void setGrades(float[] grades) {
		this.grades = grades;
	}

	// 1. metodo para obetener las asignaturas de una persona

	public void setGradesFromString(String cadena) {
		try {
			StringTokenizer st = new StringTokenizer(cadena, ";");
			int numGrades = st.countTokens();
			this.grades = new float[numGrades];
			this.subjects = new String[numGrades];
			for (int i = 0; i < numGrades; i++) {
				StringTokenizer tokens = new StringTokenizer(st.nextToken(), ":");
				this.subjects[i] = tokens.nextToken().trim();
				this.grades[i] = Float.parseFloat(tokens.nextToken().trim());
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Formato de notas inválido: " + e.getMessage());
		}
	}

	// 2. metodo para obtener las notas de las asignaturaslas asignaturas de una
	// persona

	public String getFormattedGrades() {
		String formattedNotes = "";
		for (int i = 0; i < grades.length; i++) {
			formattedNotes += subjects[i] + ": " + grades[i] + "; ";

		}
		return formattedNotes;
	}

	// 3- metodo para sacar la nota media de cada persona

	public float getMediumGrade() {
		if (grades != null) {
			float sum = 0;
			for (int i = 0; i < grades.length; i++) {
				sum += grades[i];
			}
			return sum / grades.length;
		} else
			return 0;
	}

}
