package java_oop.advanced.battle_simulation_system.characters;

public class Archer extends Character {
	private int arrows;
	private boolean hasAimedShot;

	public Archer(String name, int level) {
		super(name, level);
		this.arrows = 30 + (level * 5);
		this.hasAimedShot = false;
	}

	@Override
	protected void initializeStats() {
		this.maxHealth = 90 + (level * 15);
		this.health = maxHealth;
		this.maxMana = 70 + (level * 8);
		this.mana = maxMana;
		this.attack = 28 + (level * 4);
		this.defense = 18 + (level * 3);
		this.speed = 30 + (level * 4);
	}

	@Override
	public void useSpecialAbility(Character target) {
		if (!canUseSpecialAbility()) {
			System.out.printf("%s doesn't have enough mana for Multi-Shot!%n", name);
			return;
		}

		if (arrows < 3) {
			System.out.printf("%s doesn't have enough arrows for Multi-Shot!%n", name);
			return;
		}

		mana -= getSpecialAbilityCost();
		arrows -= 3;

		for (int i = 0; i < 3; i++) {
			double damage = attack * 0.8;
			target.takeDamage(damage);
			System.out.printf("🏹 Arrow %d hits %s for %.1f damage!%n", i + 1, target.getName(), damage);
		}
		System.out.printf("🏹 %s fires MULTI-SHOT at %s!%n", name, target.getName());
	}

	@Override
	public void attack(Character target) {
		if (arrows <= 0) {
			System.out.printf("%s is out of arrows! Using melee attack...%n", name);
			double meleeDamage = attack * 0.5;
			target.takeDamage(meleeDamage);
			System.out.printf("%s strikes %s with bow for %.1f damage!%n", name, target.getName(), meleeDamage);
			return;
		}

		arrows--;
		super.attack(target);
	}

	@Override
	public String getCharacterType() {
		return "Archer";
	}

	@Override
	public double getCriticalChance() {
		return hasAimedShot ? 0.50 : 0.25;
	}

	@Override
	protected double getSpecialAbilityCost() {
		return 20.0;
	}

	public void aimShot() {
		if (mana >= 15) {
			mana -= 15;
			hasAimedShot = true;
			System.out.printf("🎯 %s takes careful aim! (Next shot has 50%% crit chance)%n", name);
		}
	}

	@Override
	protected double calculateDamage(Character target) {
		double damage = super.calculateDamage(target);
		if (hasAimedShot) {
			damage *= 1.3;
			hasAimedShot = false;
		}
		return damage;
	}

	public void restockArrows(int amount) {
		arrows += amount;
		System.out.printf("🏹 %s restocks %d arrows! (Total: %d)%n", name, amount, arrows);
	}

	public int getArrows() {
		return arrows;
	}

	public boolean hasAimedShot() {
		return hasAimedShot;
	}
}
