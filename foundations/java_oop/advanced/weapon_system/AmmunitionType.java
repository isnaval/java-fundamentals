package java_oop.advanced.weapon_system;

public interface AmmunitionType {

	enum AmmoType {
		STANDARD("Munición estándar", 1.0), ARMOR_PIERCING("Perforante", 1.5), EXPLOSIVE("Explosiva", 2.0),
		INCENDIARY("Incendiaria", 1.3);

		private final String description;
		private final double damageMultiplier;

		AmmoType(String description, double damageMultiplier) {
			this.description = description;
			this.damageMultiplier = damageMultiplier;
		}

		public String getDescription() {
			return description;
		}

		public double getDamageMultiplier() {
			return damageMultiplier;
		}
	}

	AmmoType getAmmoType();

	int getAmmoCost();

	String getEffectDescription();
}
