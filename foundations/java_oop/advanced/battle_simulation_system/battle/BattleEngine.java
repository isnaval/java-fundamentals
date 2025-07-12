package java_oop.advanced.battle_simulation_system.battle;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import java_oop.advanced.battle_simulation_system.characters.Character;

public class BattleEngine {
	private Random random;

	public BattleEngine() {
		this.random = new Random();
	}

	public BattleResult simulateBattle(Character char1, Character char2) {
		System.out.printf("\n=== BATTLE: %s vs %s ===\n", char1.getName(), char2.getName());

		List<Character> fighters = Arrays.asList(char1, char2);
		int turnCount = 0;

		while (char1.isAlive() && char2.isAlive() && turnCount < 20) {
			Character attacker = fighters.get(turnCount % 2);
			Character defender = (attacker == char1) ? char2 : char1;

			turnCount++;
			System.out.printf("\n--- Turn %d ---\n", turnCount);

			if (attacker.canUseSpecialAbility() && random.nextDouble() < 0.3) {
				attacker.useSpecialAbility(defender);
			} else {
				attacker.attack(defender);
			}

			System.out.printf("%s: HP %.0f/%.0f\n", char1.getName(), char1.getHealth(), char1.getMaxHealth());
			System.out.printf("%s: HP %.0f/%.0f\n", char2.getName(), char2.getHealth(), char2.getMaxHealth());
		}

		Character winner = char1.isAlive() ? char1 : char2;
		Character loser = char1.isAlive() ? char2 : char1;

		System.out.printf("\n🏆 WINNER: %s!\n", winner.getName());

		return new BattleResult(winner, loser, turnCount);
	}

	public BattleResult simulateTeamBattle(Team team1, Team team2) {
		System.out.printf("\n=== TEAM BATTLE: %s vs %s ===\n", team1.getTeamName(), team2.getTeamName());

		int team1Wins = 0;
		int team2Wins = 0;
		int round = 0;

		while (team1.hasActiveMembers() && team2.hasActiveMembers()) {
			round++;
			Character fighter1 = team1.getNextFighter();
			Character fighter2 = team2.getNextFighter();

			System.out.printf("\n--- Round %d ---\n", round);
			BattleResult result = simulateBattle(fighter1, fighter2);

			if (result.getWinner() == fighter1) {
				team1Wins++;
			} else {
				team2Wins++;
			}
		}

		Team winningTeam = team1Wins > team2Wins ? team1 : team2;
		System.out.printf("\n🏆 WINNING TEAM: %s! (%d-%d)\n", winningTeam.getTeamName(), Math.max(team1Wins, team2Wins),
				Math.min(team1Wins, team2Wins));

		return new BattleResult(winningTeam.getTeamLeader(), (winningTeam == team1 ? team2 : team1).getTeamLeader(),
				round);
	}
}