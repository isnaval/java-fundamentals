package java_oop.advanced.battle_simulation_system.characters;

public class Mage extends Character {
	private boolean hasShield;
	private int shieldTurnsLeft;
	private double shieldStrength;

	public Mage(String name, int level) {
		super(name, level);
		this.hasShield = false;
		this.shieldTurnsLeft = 0;
		this.shieldStrength = 0;
	}

	@Override
	protected void initializeStats() {
		this.maxHealth = 80 + (level * 12);
		this.health = maxHealth;
		this.maxMana = 120 + (level * 15);
		this.mana = maxMana;
		this.attack = 35 + (level * 6);
		this.defense = 15 + (level * 2);
		this.speed = 20 + (level * 3);
	}

	@Override
	public void useSpecialAbility(Character target) {
		if (!canUseSpecialAbility()) {
			System.out.printf("%s doesn't have enough mana for Fireball!%n", name);
			return;
		}

		mana -= getSpecialAbilityCost();
		double damage = attack * 2.5;
		target.takeDamage(damage);
		System.out.printf("🔥 %s casts FIREBALL on %s for %.1f damage!%n", name, target.getName(), damage);
	}

	@Override
	public String getCharacterType() {
		return "Mage";
	}

	@Override
	public double getCriticalChance() {
		return 0.20;
	}

	@Override
	protected double getSpecialAbilityCost() {
		return 30.0;
	}

	public void castMagicShield() {
		if (mana >= 25) {
			mana -= 25;
			hasShield = true;
			shieldTurnsLeft = 4;
			shieldStrength = maxHealth * 0.3;
			System.out.printf("🛡️ %s casts MAGIC SHIELD! (%.0f absorption for 4 turns)%n", name, shieldStrength);
		} else {
			System.out.printf("%s doesn't have enough mana for Magic Shield!%n", name);
		}
	}

	public void healingSpell(Character target) {
		if (mana >= 20) {
			mana -= 20;
			double healAmount = attack * 0.8;
			target.heal(healAmount);
			System.out.printf("✨ %s casts HEALING SPELL on %s%n", name, target.getName());
		} else {
			System.out.printf("%s doesn't have enough mana for Healing Spell!%n", name);
		}
	}

	@Override
	public void takeDamage(double damage) {
		if (hasShield && shieldStrength > 0) {
			if (damage <= shieldStrength) {
				shieldStrength -= damage;
				System.out.printf("🛡️ %s's shield absorbs %.1f damage! (%.0f shield remaining)%n", name, damage,
						shieldStrength);
				return;
			} else {
				double remainingDamage = damage - shieldStrength;
				System.out.printf("🛡️ %s's shield absorbs %.1f damage and breaks!%n", name, shieldStrength);
				shieldStrength = 0;
				hasShield = false;
				super.takeDamage(remainingDamage);
			}
		} else {
			super.takeDamage(damage);
		}
	}

	public void updateShield() {
		if (hasShield) {
			shieldTurnsLeft--;
			if (shieldTurnsLeft <= 0) {
				hasShield = false;
				shieldStrength = 0;
				System.out.printf("🛡️ %s's magic shield expires%n", name);
			}
		}
	}

	public boolean hasShield() {
		return hasShield;
	}

	public double getShieldStrength() {
		return shieldStrength;
	}
}