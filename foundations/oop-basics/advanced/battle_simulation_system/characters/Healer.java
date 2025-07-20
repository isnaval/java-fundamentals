package java_oop.advanced.battle_simulation_system.characters;

public class Healer extends Character {
	private boolean hasBless;
	private Character blessedTarget;
	private int blessTurnsLeft;

	public Healer(String name, int level) {
		super(name, level);
		this.hasBless = false;
		this.blessedTarget = null;
		this.blessTurnsLeft = 0;
	}

	@Override
	protected void initializeStats() {
		this.maxHealth = 75 + (level * 10);
		this.health = maxHealth;
		this.maxMana = 150 + (level * 20);
		this.mana = maxMana;
		this.attack = 20 + (level * 3);
		this.defense = 20 + (level * 3);
		this.speed = 25 + (level * 3);
	}

	@Override
	public void useSpecialAbility(Character target) {
		if (!canUseSpecialAbility()) {
			System.out.printf("%s doesn't have enough mana for Divine Heal!%n", name);
			return;
		}

		mana -= getSpecialAbilityCost();
		double healAmount = maxMana * 0.4;
		target.heal(healAmount);
		System.out.printf("✨ %s casts DIVINE HEAL on %s!%n", name, target.getName());
	}

	@Override
	public String getCharacterType() {
		return "Healer";
	}

	@Override
	public double getCriticalChance() {
		return 0.10;
	}

	@Override
	protected double getSpecialAbilityCost() {
		return 35.0;
	}

	public void bless(Character target) {
		if (mana >= 25) {
			mana -= 25;
			hasBless = true;
			blessedTarget = target;
			blessTurnsLeft = 5;
			System.out.printf("🙏 %s blesses %s! (+20%% all stats for 5 turns)%n", name, target.getName());

			if (target instanceof Warrior) {
				((Warrior) target).attack *= 1.2;
				((Warrior) target).defense *= 1.2;
			} else if (target instanceof Mage) {
				((Mage) target).attack *= 1.2;
				((Mage) target).defense *= 1.2;
			} else if (target instanceof Archer) {
				((Archer) target).attack *= 1.2;
				((Archer) target).speed *= 1.2;
			}
		}
	}

	public void quickHeal(Character target) {
		if (mana >= 15) {
			mana -= 15;
			double healAmount = attack * 1.5;
			target.heal(healAmount);
			System.out.printf("💚 %s casts QUICK HEAL on %s%n", name, target.getName());
		}
	}

	public void groupHeal(java.util.List<Character> allies) {
		if (mana >= 40) {
			mana -= 40;
			double healAmount = attack;
			System.out.printf("🌟 %s casts GROUP HEAL!%n", name);
			for (Character ally : allies) {
				if (ally.isAlive()) {
					ally.heal(healAmount);
				}
			}
		}
	}

	public void updateBless() {
		if (hasBless && blessedTarget != null) {
			blessTurnsLeft--;
			if (blessTurnsLeft <= 0) {
				removeBless();
			}
		}
	}

	private void removeBless() {
		if (blessedTarget != null) {
			System.out.printf("🙏 Blessing on %s expires%n", blessedTarget.getName());

			// Remove blessing effects
			if (blessedTarget instanceof Warrior) {
				((Warrior) blessedTarget).attack /= 1.2;
				((Warrior) blessedTarget).defense /= 1.2;
			} else if (blessedTarget instanceof Mage) {
				((Mage) blessedTarget).attack /= 1.2;
				((Mage) blessedTarget).defense /= 1.2;
			} else if (blessedTarget instanceof Archer) {
				((Archer) blessedTarget).attack /= 1.2;
				((Archer) blessedTarget).speed /= 1.2;
			}
		}

		hasBless = false;
		blessedTarget = null;
	}

	public boolean hasBless() {
		return hasBless;
	}

	public Character getBlessedTarget() {
		return blessedTarget;
	}
}