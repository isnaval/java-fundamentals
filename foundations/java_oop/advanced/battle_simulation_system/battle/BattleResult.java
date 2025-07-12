package java_oop.advanced.battle_simulation_system.battle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import java_oop.advanced.battle_simulation_system.characters.Character;

public class BattleResult {

	private Character winner;
	private Character loser;
	private int totalTurns;
	private LocalDateTime battleTime;
	private double battleDuration; // in seconds
	private List<String> battleLog;
	private Map<String, Integer> damageDealt;
	private Map<String, Integer> damageReceived;
	private Map<String, Integer> abilitiesUsed;
	private BattleType battleType;
	private String battleLocation;

	public enum BattleType {
		DUEL("1v1 Duel"), TEAM_BATTLE("Team Battle"), TOURNAMENT("Tournament Match"), TRAINING("Training Session"),
		ARENA("Arena Combat");

		private final String description;

		BattleType(String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}
	}

	public BattleResult(Character winner, Character loser, int totalTurns) {
		this.winner = winner;
		this.loser = loser;
		this.totalTurns = totalTurns;
		this.battleTime = LocalDateTime.now();
		this.battleLog = new ArrayList<>();
		this.damageDealt = new HashMap<>();
		this.damageReceived = new HashMap<>();
		this.abilitiesUsed = new HashMap<>();
		this.battleType = BattleType.DUEL;
		this.battleLocation = "Unknown Arena";

		calculateBattleStats();
	}

	public BattleResult(Character winner, Character loser, int totalTurns, BattleType battleType,
			String battleLocation) {
		this(winner, loser, totalTurns);
		this.battleType = battleType;
		this.battleLocation = battleLocation;
	}

	private void calculateBattleStats() {
		damageDealt.put(winner.getName(), 0);
		damageDealt.put(loser.getName(), 0);
		damageReceived.put(winner.getName(), 0);
		damageReceived.put(loser.getName(), 0);
		abilitiesUsed.put(winner.getName(), 0);
		abilitiesUsed.put(loser.getName(), 0);

		this.battleDuration = totalTurns * (1.5 + Math.random());

		double winnerDamage = estimateDamageDealt(winner, loser);
		double loserDamage = estimateDamageDealt(loser, winner);

		damageDealt.put(winner.getName(), (int) winnerDamage);
		damageDealt.put(loser.getName(), (int) loserDamage);

		damageReceived.put(winner.getName(), (int) (loserDamage * 0.7));
		damageReceived.put(loser.getName(), (int) winnerDamage);

		abilitiesUsed.put(winner.getName(), Math.max(1, totalTurns / 4));
		abilitiesUsed.put(loser.getName(), Math.max(1, totalTurns / 4));
	}

	private double estimateDamageDealt(Character attacker, Character defender) {
		double attackPower = attacker.getAttack();
		double defenderDefense = defender.getDefense();
		int estimatedAttacks = totalTurns / 2;

		return Math.max(estimatedAttacks * 10, estimatedAttacks * (attackPower - defenderDefense * 0.5));
	}

	public void addLogEntry(String entry) {
		battleLog.add(String.format("[Turn %d] %s", battleLog.size() + 1, entry));
	}

	public void recordDamage(String attacker, String defender, int damage) {
		damageDealt.merge(attacker, damage, Integer::sum);
		damageReceived.merge(defender, damage, Integer::sum);
	}

	public void recordAbilityUse(String character) {
		abilitiesUsed.merge(character, 1, Integer::sum);
	}

	public double getWinnerHealthPercentage() {
		return winner.getHealthPercentage();
	}

	public String getWinMargin() {
		double healthPercent = getWinnerHealthPercentage();
		if (healthPercent > 80)
			return "Decisive Victory";
		if (healthPercent > 60)
			return "Clear Victory";
		if (healthPercent > 40)
			return "Close Victory";
		if (healthPercent > 20)
			return "Narrow Victory";
		return "Pyrrhic Victory";
	}

	public String getBattleRating() {
		double healthPercent = getWinnerHealthPercentage();
		int turnRating = Math.min(10, totalTurns / 3);
		int closenesRating = (int) ((100 - healthPercent) / 10);

		int totalRating = Math.min(10, (turnRating + closenesRating) / 2);

		switch (totalRating) {
		case 10:
		case 9:
			return "⭐⭐⭐⭐⭐ Epic Battle!";
		case 8:
		case 7:
			return "⭐⭐⭐⭐ Great Fight!";
		case 6:
		case 5:
			return "⭐⭐⭐ Good Battle";
		case 4:
		case 3:
			return "⭐⭐ Average Fight";
		default:
			return "⭐ Quick Skirmish";
		}
	}

	public Map<String, Object> getStatsSummary() {
		Map<String, Object> stats = new HashMap<>();
		stats.put("winner", winner.getName());
		stats.put("loser", loser.getName());
		stats.put("totalTurns", totalTurns);
		stats.put("battleDuration", String.format("%.1f seconds", battleDuration));
		stats.put("winMargin", getWinMargin());
		stats.put("battleRating", getBattleRating());
		stats.put("winnerHealthRemaining", String.format("%.1f%%", getWinnerHealthPercentage()));

		return stats;
	}

	public String generateDetailedReport() {
		StringBuilder report = new StringBuilder();

		// Header
		report.append("═══════════════════════════════════════════════════════════════\n");
		report.append("                        BATTLE REPORT                           \n");
		report.append("═══════════════════════════════════════════════════════════════\n");

		// Basic Info
		report.append(String.format("Battle Type: %s\n", battleType.getDescription()));
		report.append(String.format("Location: %s\n", battleLocation));
		report.append(
				String.format("Date: %s\n", battleTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
		report.append(String.format("Duration: %.1f seconds (%d turns)\n", battleDuration, totalTurns));
		report.append("\n");

		// Result
		report.append("🏆 BATTLE RESULT 🏆\n");
		report.append("───────────────────────────────────────────────────────────────\n");
		report.append(
				String.format("WINNER: %s (%s) - %s\n", winner.getName(), winner.getCharacterType(), getWinMargin()));
		report.append(String.format("LOSER:  %s (%s)\n", loser.getName(), loser.getCharacterType()));
		report.append(String.format("Rating: %s\n", getBattleRating()));
		report.append("\n");

		// Character Stats
		report.append("📊 FINAL STATISTICS\n");
		report.append("───────────────────────────────────────────────────────────────\n");
		report.append(String.format("%-20s | %-15s | %-15s\n", "Statistic", winner.getName(), loser.getName()));
		report.append("─────────────────────┼─────────────────┼─────────────────\n");
		report.append(String.format("%-20s | %-15.0f | %-15.0f\n", "Health Remaining", winner.getHealth(),
				loser.getHealth()));
		report.append(
				String.format("%-20s | %-15.0f | %-15.0f\n", "Mana Remaining", winner.getMana(), loser.getMana()));
		report.append(String.format("%-20s | %-15d | %-15d\n", "Damage Dealt", damageDealt.get(winner.getName()),
				damageDealt.get(loser.getName())));
		report.append(String.format("%-20s | %-15d | %-15d\n", "Damage Received", damageReceived.get(winner.getName()),
				damageReceived.get(loser.getName())));
		report.append(String.format("%-20s | %-15d | %-15d\n", "Abilities Used", abilitiesUsed.get(winner.getName()),
				abilitiesUsed.get(loser.getName())));
		report.append("\n");

		// Experience and Rewards
		report.append("🎖️ EXPERIENCE & REWARDS\n");
		report.append("───────────────────────────────────────────────────────────────\n");
		int winnerExp = calculateExperienceGain(winner, loser, true);
		int loserExp = calculateExperienceGain(loser, winner, false);
		report.append(String.format("%s gains %d experience points!\n", winner.getName(), winnerExp));
		report.append(String.format("%s gains %d experience points.\n", loser.getName(), loserExp));
		report.append("\n");

		// Battle Log (last 5 entries if available)
		if (!battleLog.isEmpty()) {
			report.append("📜 BATTLE HIGHLIGHTS\n");
			report.append("───────────────────────────────────────────────────────────────\n");
			int startIndex = Math.max(0, battleLog.size() - 5);
			for (int i = startIndex; i < battleLog.size(); i++) {
				report.append(battleLog.get(i)).append("\n");
			}
			report.append("\n");
		}

		report.append("═══════════════════════════════════════════════════════════════\n");

		return report.toString();
	}

	private int calculateExperienceGain(Character character, Character opponent, boolean isWinner) {
		int baseExp = 50;
		int levelDifference = opponent.getLevel() - character.getLevel();

		int levelBonus = Math.max(0, levelDifference * 10);

		int winBonus = isWinner ? 25 : 0;

		int durationBonus = Math.min(25, totalTurns * 2);

		return baseExp + levelBonus + winBonus + durationBonus;
	}

	public Character getWinner() {
		return winner;
	}

	public Character getLoser() {
		return loser;
	}

	public int getTotalTurns() {
		return totalTurns;
	}

	public LocalDateTime getBattleTime() {
		return battleTime;
	}

	public double getBattleDuration() {
		return battleDuration;
	}

	public List<String> getBattleLog() {
		return new ArrayList<>(battleLog);
	}

	public Map<String, Integer> getDamageDealt() {
		return new HashMap<>(damageDealt);
	}

	public Map<String, Integer> getDamageReceived() {
		return new HashMap<>(damageReceived);
	}

	public Map<String, Integer> getAbilitiesUsed() {
		return new HashMap<>(abilitiesUsed);
	}

	public BattleType getBattleType() {
		return battleType;
	}

	public String getBattleLocation() {
		return battleLocation;
	}

	// Setters
	public void setBattleDuration(double battleDuration) {
		this.battleDuration = battleDuration;
	}

	public void setBattleType(BattleType battleType) {
		this.battleType = battleType;
	}

	public void setBattleLocation(String battleLocation) {
		this.battleLocation = battleLocation;
	}

	@Override
	public String toString() {
		return String.format("%s: %s defeated %s in %d turns (%s)", battleType.getDescription(), winner.getName(),
				loser.getName(), totalTurns, getWinMargin());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		BattleResult that = (BattleResult) obj;
		return totalTurns == that.totalTurns && Objects.equals(winner, that.winner) && Objects.equals(loser, that.loser)
				&& Objects.equals(battleTime, that.battleTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(winner, loser, totalTurns, battleTime);
	}
}