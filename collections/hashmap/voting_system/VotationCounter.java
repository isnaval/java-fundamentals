package collections.hashmap.voting_system;

import java.util.HashMap;
import java.util.Map;

public class VotationCounter {
	
	public static Map<VoteOption, Integer> countVotes(VoteOption[] votes) {
		Map <VoteOption, Integer> voteCounts = new HashMap<>();
		if(votes == null || votes.length == 0) {
			return voteCounts;
		}
		
		for (VoteOption vote: votes) {
			if(vote != null ) {
				voteCounts.put(vote,  voteCounts.getOrDefault(vote, 0) + 1);
			}
		}
		return voteCounts; 
	}	
};