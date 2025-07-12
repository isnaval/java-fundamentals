package java_oop.advanced.battle_simulation_system.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java_oop.advanced.battle_simulation_system.battle.BattleEngine;
import java_oop.advanced.battle_simulation_system.battle.BattleResult;
import java_oop.advanced.battle_simulation_system.battle.Team;
import java_oop.advanced.battle_simulation_system.characters.Archer;
import java_oop.advanced.battle_simulation_system.characters.Character;
import java_oop.advanced.battle_simulation_system.characters.Healer;
import java_oop.advanced.battle_simulation_system.characters.Mage;
import java_oop.advanced.battle_simulation_system.characters.Warrior;

class BattleEngineTest {

	private BattleEngine battleEngine;
	private Warrior warrior;
	private Mage mage;

	@BeforeEach
	void setUp() {
		battleEngine = new BattleEngine();
		warrior = new Warrior("TestWarrior", 5);
		mage = new Mage("TestMage", 5);
	}

	@Test
	@DisplayName("Battle engine can simulate a duel")
	void testSimulateDuel() {
		BattleResult result = battleEngine.simulateBattle(warrior, mage);
		assertNotNull(result);
		assertNotNull(result.getWinner());
		assertNotNull(result.getLoser());
		assertTrue(result.getTotalTurns() > 0);
		assertTrue(result.getWinner().isAlive());
		assertFalse(result.getLoser().isAlive());
	}

	@Test
	@DisplayName("Battle result contains correct information")
	void testBattleResult() {
		BattleResult result = battleEngine.simulateBattle(warrior, mage);

		assertTrue(result.getWinner() == warrior || result.getWinner() == mage);
		if (result.getWinner() == warrior) {
			assertEquals(mage, result.getLoser());
		} else {
			assertEquals(warrior, result.getLoser());
		}

		assertTrue(result.getTotalTurns() <= 20);
	}

	@Test
	@DisplayName("Team battle works correctly")
	void testTeamBattle() {
		// Create teams
		Team team1 = new Team("Team1", 3);
		team1.addMember(new Warrior("Warrior1", 5));
		team1.addMember(new Mage("Mage1", 5));
		team1.addMember(new Archer("Archer1", 5));

		Team team2 = new Team("Team2", 3);
		team2.addMember(new Warrior("Warrior2", 5));
		team2.addMember(new Mage("Mage2", 5));
		team2.addMember(new Healer("Healer2", 5));

		BattleResult result = battleEngine.simulateTeamBattle(team1, team2);

		assertNotNull(result);
		assertNotNull(result.getWinner());
		assertNotNull(result.getLoser());
		assertTrue(result.getTotalTurns() > 0);
	}

	@Test
	@DisplayName("Characters at different levels have different outcomes")
	void testLevelDifference() {
		Warrior lowLevel = new Warrior("Weak", 1);
		Warrior highLevel = new Warrior("Strong", 10);
		int highLevelWins = 0;
		int totalBattles = 10;

		for (int i = 0; i < totalBattles; i++) {

			lowLevel.heal(lowLevel.getMaxHealth());
			highLevel.heal(highLevel.getMaxHealth());

			BattleResult result = battleEngine.simulateBattle(lowLevel, highLevel);
			if (result.getWinner() == highLevel) {
				highLevelWins++;
			}
		}
		assertTrue(highLevelWins > totalBattles / 2, "Higher level character should win more often");
	}

	@Test
	@DisplayName("Battle doesn't last forever")
	void testBattleLength() {
		Healer healer1 = new Healer("Healer1", 5);
		Healer healer2 = new Healer("Healer2", 5);

		BattleResult result = battleEngine.simulateBattle(healer1, healer2);
		assertTrue(result.getTotalTurns() <= 20, "Battle should not exceed maximum turn limit");
	}

	@Test
	@DisplayName("Same characters produce consistent results")
	void testConsistency() {
		Warrior warrior1 = new Warrior("Same", 5);
		Warrior warrior2 = new Warrior("Same", 5);
		assertEquals(warrior1.getMaxHealth(), warrior2.getMaxHealth());
		assertEquals(warrior1.getAttack(), warrior2.getAttack());
		assertEquals(warrior1.getDefense(), warrior2.getDefense());
		BattleResult result = battleEngine.simulateBattle(warrior1, warrior2);
		assertNotNull(result);
		assertTrue(result.getTotalTurns() > 0);
	}

	@Test
	@DisplayName("Team strategy affects fighter selection")
	void testTeamStrategy() {
		Team aggressiveTeam = new Team("Aggressive", 3);
		aggressiveTeam.addMember(new Warrior("StrongWarrior", 5));
		aggressiveTeam.addMember(new Mage("WeakMage", 3));
		aggressiveTeam.addMember(new Healer("Healer", 4));
		aggressiveTeam.setStrategy(Team.TeamStrategy.AGGRESSIVE);
		Character nextFighter = aggressiveTeam.getNextFighter();
		assertEquals("StrongWarrior", nextFighter.getName());

		// Test defensive strategy
		Team defensiveTeam = new Team("Defensive", 3);
		defensiveTeam.addMember(new Warrior("DefensiveWarrior", 5));
		defensiveTeam.addMember(new Mage("Mage", 3));
		defensiveTeam.addMember(new Healer("Healer", 4));

		defensiveTeam.setStrategy(Team.TeamStrategy.DEFENSIVE);

		Character defensiveFighter = defensiveTeam.getNextFighter();
		assertEquals("DefensiveWarrior", defensiveFighter.getName());
	}
}