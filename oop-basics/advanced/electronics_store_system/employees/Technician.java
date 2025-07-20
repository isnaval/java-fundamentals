package java_oop.advanced.electronics_store_system.employees;

public class Technician extends Employee {
	private String specialization;
	private int repairsCompleted;
	private double repairBonus;
	private boolean certified;

	public Technician(String name, String employeeId, double baseSalary, int experienceYears, String specialization,
			boolean certified) {
		super(name, employeeId, baseSalary, "Soporte Técnico", experienceYears);
		this.specialization = specialization;
		this.repairsCompleted = 0;
		this.repairBonus = 25.0;
		this.certified = certified;
	}

	@Override
	public double calculateSalary() {
		double repairBonusTotal = repairsCompleted * repairBonus;
		double certificationBonus = certified ? 200.0 : 0.0;
		double experienceBonus = baseSalary * 0.025 * experienceYears;
		return baseSalary + repairBonusTotal + certificationBonus + experienceBonus;
	}

	@Override
	public void showResponsibilities() {
		System.out.println("📋 RESPONSABILIDADES DEL TÉCNICO:");
		System.out.println("- Especialización: " + specialization);
		System.out.println("- Reparar productos defectuosos");
		System.out.println("- Instalar equipos en domicilio");
		System.out.println("- Brindar soporte técnico");
		System.out.println("- Mantener herramientas y equipo");
		System.out.println("- Certificado: " + (certified ? "Sí" : "No"));
	}

	public void completeRepair() {
		repairsCompleted++;
		System.out.println("🔧 Reparación completada. Total: " + repairsCompleted);
	}

	public void resetMonthlyRepairs() {
		repairsCompleted = 0;
	}

	// Getters específicos
	public String getSpecialization() {
		return specialization;
	}

	public int getRepairsCompleted() {
		return repairsCompleted;
	}

	public double getRepairBonus() {
		return repairBonus;
	}

	public boolean isCertified() {
		return certified;
	}
}