package java_oop.basics.sports_equipment;

public abstract class Equipment {
	protected int id;
	protected String sport;
	protected boolean isAdaptive;

	public Equipment() {
	}

	public Equipment(int id, String sport, boolean isAdaptive) {
		this.id = id;
		this.sport = sport;
		this.isAdaptive = isAdaptive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public boolean isAdaptive() {
		return isAdaptive;
	}

	public void setAdaptive(boolean isAdaptive) {
		this.isAdaptive = isAdaptive;
	}

	public abstract void displayInfo();

	public String getBasicInfo() {
		return String.format("ID: %d | Deporte: %s | Adaptivo: %s", id, sport, isAdaptive ? "Sí" : "No");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Equipment equipment = (Equipment) obj;
		return id == equipment.id;
	}

	@Override
	public String toString() {
		return getBasicInfo();
	}

}
