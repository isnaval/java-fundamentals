package java_oop.advanced.battle_simulation_system.characters;

public class Warrior extends Character {
	private boolean isRaging; // furioso
	private int rageTurnsLeft; // ira a la izquierda

	public Warrior(String name, int level) {
		super(name, level);
		this.isRaging = false;
		this.rageTurnsLeft = 0;
	}

	@Override
	protected void initializeStats() {
		this.maxHealth = 120 + (level * 20);
		this.health = maxHealth;
		this.maxMana = 50 + (level * 5);
		this.mana = maxMana;
		this.attack = 30 + (level * 5);
		this.defense = 25 + (level * 4);
		this.speed = 15 + (level * 2);
	}

	@Override
	public void useSpecialAbility(Character target) {
		if (!canUseSpecialAbility()) {
			System.out.printf("%s doesn't have enough mana for Berserker Strike!%n", name);
			return;
		}

		mana -= getSpecialAbilityCost();
		double damage = attack * 2.2; // Powerful strike
		target.takeDamage(damage);
		System.out.printf("⚔️ %s uses BERSERKER STRIKE on %s for %.1f damage!%n", name, target.getName(), damage);
	}

	@Override
	public String getCharacterType() {
		return "Warrior";
	}

	@Override
	public double getCriticalChance() {
		return isRaging ? 0.25 : 0.15;
	}

	@Override
	protected double getSpecialAbilityCost() {
		return 25.0;
	}

	public void rage() {
		if (mana >= 30) {
			mana -= 30;
			isRaging = true;
			rageTurnsLeft = 3;
			attack *= 1.5;
			defense *= 0.7;
			System.out.printf("🔥 %s enters RAGE MODE! (+50%% attack, -30%% defense for 3 turns)%n", name);
		} else {
			System.out.printf("%s doesn't have enough mana to rage!%n", name);
		}
	}

	public void updateRage() {
		if (isRaging) {
			rageTurnsLeft--;
			if (rageTurnsLeft <= 0) {
				endRage();
			}
		}
	}

	private void endRage() {
		attack /= 1.5;
		defense /= 0.7;
		isRaging = false;
		System.out.printf("😤 %s's rage subsides...%n", name);
	}

	public boolean isRaging() {
		return isRaging;
	}

	public int getRageTurnsLeft() {
		return rageTurnsLeft;
	}
}
