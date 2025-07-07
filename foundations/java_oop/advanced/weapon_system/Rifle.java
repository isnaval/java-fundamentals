package java_oop.advanced.weapon_system;

public class Rifle extends Weapon implements PersonalUse, AmmunitionType {
	private double weight;
	private boolean shouldered;
	private AmmoType currentAmmoType;

	public Rifle(String name, int damage, int range, int ammoCapacity, double weight) {
		super(name, damage, range, ammoCapacity, WeaponType.PERSONAL);
		this.weight = weight;
		this.shouldered = false;
		this.currentAmmoType = AmmoType.STANDARD;
	}

	@Override
	public void fire() {
		if (!canFire()) {
			System.out.println("No hay munición en " + name);
			return;
		}

		if (!shouldered) {
			System.out.println("Debes apoyar el rifle antes de disparar");
			return;
		}

		currentAmmo--;
		double finalDamage = damage * currentAmmoType.getDamageMultiplier();
		System.out
				.println(name + " dispara! Daño: " + (int) finalDamage + " (" + currentAmmoType.getDescription() + ")");

		if (currentAmmo == 0) {
			System.out.println("Cargador vacío - necesita recarga");
		}
	}

	@Override
	public void reload() {
		currentAmmo = ammoCapacity;
		System.out.println(name + " recargado - Munición: " + currentAmmo + "/" + ammoCapacity);
	}

	@Override
	public void shoulder() {
		shouldered = true;
		System.out.println(name + " apoyado en el hombro - Listo para disparar");
	}

	@Override
	public void aim() {
		if (shouldered) {
			System.out.println("Apuntando con " + name + " - Alcance: " + range + "m");
		} else {
			System.out.println("Primero debes apoyar el rifle");
		}
	}

	@Override
	public boolean isPortable() {
		return weight <= 8.0; // Rifles portables hasta 8kg
	}

	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public AmmoType getAmmoType() {
		return currentAmmoType;
	}

	@Override
	public int getAmmoCost() {
		return switch (currentAmmoType) {
		case STANDARD -> 1;
		case ARMOR_PIERCING -> 2;
		case EXPLOSIVE -> 3;
		case INCENDIARY -> 2;
		};
	}

	@Override
	public String getEffectDescription() {
		return currentAmmoType.getDescription();
	}

	public void changeAmmoType(AmmoType newType) {
		this.currentAmmoType = newType;
		System.out.println("Munición cambiada a: " + newType.getDescription());
	}

	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Peso: " + weight + "kg");
		System.out.println("Portátil: " + (isPortable() ? "Sí" : "No"));
		System.out.println("Munición actual: " + currentAmmoType.getDescription());
		System.out.println("Estado: " + (shouldered ? "Apoyado" : "Sin apoyar"));
	}

}
