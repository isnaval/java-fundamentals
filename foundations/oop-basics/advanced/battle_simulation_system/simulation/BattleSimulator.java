package java_oop.advanced.battle_simulation_system.simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import java_oop.advanced.battle_simulation_system.battle.BattleEngine;
import java_oop.advanced.battle_simulation_system.battle.BattleResult;
import java_oop.advanced.battle_simulation_system.characters.Archer;
import java_oop.advanced.battle_simulation_system.characters.Character;
import java_oop.advanced.battle_simulation_system.characters.Healer;
import java_oop.advanced.battle_simulation_system.characters.Mage;
import java_oop.advanced.battle_simulation_system.characters.Warrior;

public class BattleSimulator {
	private BattleEngine battleEngine;
	private List<Character> characters;
	private SimulationStats stats;

	public BattleSimulator() {
		this.battleEngine = new BattleEngine();
		this.characters = new ArrayList<>();
		this.stats = new SimulationStats();

		createTestCharacters();
	}

	private void createTestCharacters() {
		characters.add(new Warrior("Thorin", 5));
		characters.add(new Mage("Gandalf", 5));
		characters.add(new Archer("Legolas", 5));
		characters.add(new Healer("Elrond", 5));

		characters.add(new Warrior("Conan", 7));
		characters.add(new Mage("Merlin", 7));
		characters.add(new Archer("Robin", 7));
		characters.add(new Healer("Priest", 7));
	}

	public void runRandomBattles(int numberOfBattles) {
		System.out.printf("🚀 Running %d random battles...\n", numberOfBattles);

		stats.reset();
		Random random = new Random();

		for (int i = 0; i < numberOfBattles; i++) {
			Character char1 = characters.get(random.nextInt(characters.size()));
			Character char2 = characters.get(random.nextInt(characters.size()));

			while (char1 == char2) {
				char2 = characters.get(random.nextInt(characters.size()));
			}

			char1.heal(char1.getMaxHealth());
			char2.heal(char2.getMaxHealth());

			// Fight!
			BattleResult result = battleEngine.simulateBattle(char1, char2);
			stats.addBattleResult(result);

			if ((i + 1) % 10 == 0) {
				System.out.printf("✅ Completed %d battles\n", i + 1);
			}
		}

		System.out.println("\n📊 SIMULATION COMPLETE!");
		stats.printSummary();
	}

	public void runClassAnalysis() {
		System.out.println("🔍 Running class vs class analysis...");

		stats.reset();
		String[] classes = { "Warrior", "Mage", "Archer", "Healer" };

		for (String class1 : classes) {
			for (String class2 : classes) {
				if (!class1.equals(class2)) {
					Character fighter1 = getCharacterByClass(class1);
					Character fighter2 = getCharacterByClass(class2);

					System.out.printf("\n🥊 %s vs %s\n", class1, class2);

					for (int i = 0; i < 5; i++) {
						fighter1.heal(fighter1.getMaxHealth());
						fighter2.heal(fighter2.getMaxHealth());

						BattleResult result = battleEngine.simulateBattle(fighter1, fighter2);
						stats.addBattleResult(result);
					}
				}
			}
		}

		stats.printClassAnalysis();
	}

	private Character getCharacterByClass(String className) {
		return characters.stream().filter(c -> c.getCharacterType().equals(className)).findFirst()
				.orElse(characters.get(0));
	}

	public void runTournament() {
		System.out.println("🏆 Running tournament...");

		List<Character> participants = new ArrayList<>(characters);
		Collections.shuffle(participants);

		System.out.printf("Tournament with %d participants!\n", participants.size());

		while (participants.size() > 1) {
			List<Character> nextRound = new ArrayList<>();

			for (int i = 0; i < participants.size(); i += 2) {
				if (i + 1 < participants.size()) {
					Character fighter1 = participants.get(i);
					Character fighter2 = participants.get(i + 1);

					fighter1.heal(fighter1.getMaxHealth());
					fighter2.heal(fighter2.getMaxHealth());

					BattleResult result = battleEngine.simulateBattle(fighter1, fighter2);
					nextRound.add(result.getWinner());
				} else {
					nextRound.add(participants.get(i));
					System.out.printf("%s gets a bye to the next round!\n", participants.get(i).getName());
				}
			}

			participants = nextRound;
			System.out.printf("Round complete! %d fighters advance.\n", participants.size());
		}

		if (!participants.isEmpty()) {
			System.out.printf("\n🏆 TOURNAMENT CHAMPION: %s!\n", participants.get(0).getName());
		}
	}

	public SimulationStats getStats() {
		return stats;
	}

	public List<Character> getCharacters() {
		return new ArrayList<>(characters);
	}
}