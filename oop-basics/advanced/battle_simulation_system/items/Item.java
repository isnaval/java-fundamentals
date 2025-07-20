package java_oop.advanced.battle_simulation_system.items;

public interface Item {
	String getName();

	String getDescription();

	int getValue();

	String getRarity();

	void use(Object target);

	boolean isConsumable();

}
