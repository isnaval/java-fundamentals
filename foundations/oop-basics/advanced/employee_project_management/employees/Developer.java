package java_oop.advanced.employee_project_management.employees;

public class Developer extends Employee {
	private String programmingLanguage;
	private int linesOfCodeWritten;
	private int bugsFixed;
	private String specialization;

	public Developer(String id, String name, String email, double baseSalary, String programmingLanguage) {
		super(id, name, email, baseSalary, "Desarrollo");
		this.programmingLanguage = programmingLanguage;
		this.linesOfCodeWritten = 0;
		this.bugsFixed = 0;
		this.specialization = "FullStack";
	}

	@Override
	public double calculateSalary() {
		double bonus = 0.0;
		bonus += baseSalary * 0.05 * experienceYears;
		if (linesOfCodeWritten > 10000)
			bonus += 500;
		if (bugsFixed > 50)
			bonus += 300;
		return baseSalary + bonus;
	}

	@Override
	public String getRole() {
		return "Desarrollador " + specialization;
	}

	public void writeCode(int lines) {
		linesOfCodeWritten += lines;
		System.out.println(name + " escribió " + lines + " líneas de código");
	}

	public void fixBug() {
		bugsFixed++;
		System.out.println(name + " arregló un bug! Total: " + bugsFixed);
	}

	public String getProgrammingLanguage() {
		return programmingLanguage;
	}

	public int getLinesOfCodeWritten() {
		return linesOfCodeWritten;
	}

	public int getBugsFixed() {
		return bugsFixed;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
}