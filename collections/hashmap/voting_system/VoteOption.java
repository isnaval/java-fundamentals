package collections.hashmap.voting_system;

public enum VoteOption {
	
    G1("Grupo 1", "Propuesta de mejora ambiental"),
    G2("Grupo 2", "Propuesta de infraestructura urbana"),
    G3("Grupo 3", "Propuesta de desarrollo educativo"),
    G4("Grupo 4", "Propuesta de innovación tecnológica");
    
    
    private final String name; 
    private final String description;
    
	private VoteOption(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	};
	
	@Override
	public String toString() {
		return "VoteOption [name = " + name + ", description = " + description + "]";
	}
};
