package java_oop.advanced.employee_project_management.employees;

public class Designer extends Employee {
	private String designTool;
	private int projectsDesigned;
	private String designType;
	private double creativityRating;

	public Designer(String id, String name, String email, double baseSalary, String designTool) {
		super(id, name, email, baseSalary, "Diseño");
		this.designTool = designTool;
		this.projectsDesigned = 0;
		this.designType = "UI/UX";
		this.creativityRating = 7.0;
	}

	@Override
	public double calculateSalary() {
		double bonus = 0.0;
		bonus += baseSalary * 0.04 * experienceYears;
		bonus += creativityRating * 50;
		bonus += projectsDesigned * 100;

		return baseSalary + bonus;
	}

	@Override
	public String getRole() {
		return "Diseñador " + designType;
	}

	public void completeDesign() {
		projectsDesigned++;
		System.out.println(name + " completó un diseño! Total: " + projectsDesigned);
	}

	public void updateCreativityRating(double rating) {
		if (rating >= 1.0 && rating <= 10.0) {
			this.creativityRating = rating;
			System.out.println("Rating de creatividad actualizado: " + rating);
		}
	}

	// Getters específicos
	public String getDesignTool() {
		return designTool;
	}

	public int getProjectsDesigned() {
		return projectsDesigned;
	}

	public String getDesignType() {
		return designType;
	}

	public double getCreativityRating() {
		return creativityRating;
	}

	public void setDesignType(String designType) {
		this.designType = designType;
	}
}