package java_oop.advanced.weapon_system;

public class Weapon {

	protected String name;
	protected int damage;
	protected int range;
	protected int ammoCapacity;
	protected int currentAmmo;
	protected WeaponType type;

	public enum WeaponType {
		PERSONAL, VEHICLE, HEAVY
	}

	public Weapon(String name, int damage, int range, int ammoCapacity, WeaponType type) {
		this.name = name;
		this.damage = damage;
		this.range = range;
		this.ammoCapacity = ammoCapacity;
		this.currentAmmo = ammoCapacity;
		this.type = type;
	}

	public void fire() {
	}

	public void reload() {
	}

	public boolean canFire() {
		return currentAmmo > 0;
	}

	public void displayInfo() {
		System.out.println("===============================================");
		System.out.println("Arma: " + name);
		System.out.println("Tipo: " + type);
		System.out.println("Daño: " + damage);
		System.out.println("Alcance: " + range + "m");
		System.out.println("Municion: " + currentAmmo + "/" + ammoCapacity);
		System.out.println("===============================================");
	}

	// Getters
	public String getName() {
		return name;
	}

	public int getDamage() {
		return damage;
	}

	public int getRange() {
		return range;
	}

	public int getCurrentAmmo() {
		return currentAmmo;
	}

	public int getAmmoCapacity() {
		return ammoCapacity;
	}

	public WeaponType getType() {
		return type;
	}

}
