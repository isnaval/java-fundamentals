package collections.hashmap.voting_system;

import java.util.Random;

public class Votation {
	public static VoteOption[] createRandom() {
		VoteOption[] votes = new VoteOption[1000];
		Random random = new Random();
		for (int i = 0; i < votes.length; i++) {
			int randomIndex = random.nextInt(VoteOption.values().length);
			votes[i] = VoteOption.values()[randomIndex];
		}
		return votes;
	}
};
