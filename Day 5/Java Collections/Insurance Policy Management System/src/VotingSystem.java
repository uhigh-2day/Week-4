import java.util.*;

public class VotingSystem {
    private HashMap<String, Integer> voteCounts = new HashMap<>();
    private LinkedHashMap<Integer, String> voteOrder = new LinkedHashMap<>();
    private int voteId = 1; // Incremental ID to preserve vote casting order

    // Cast a vote
    public void castVote(String candidateName) {
        voteCounts.put(candidateName, voteCounts.getOrDefault(candidateName, 0) + 1);
        voteOrder.put(voteId++, candidateName);
    }

    // Display vote counts (unordered)
    public void displayVoteCounts() {
        System.out.println("Vote Counts:");
        for (Map.Entry<String, Integer> entry : voteCounts.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue() + " votes");
        }
    }

    // Display vote counts sorted by candidate name
    public void displaySortedResults() {
        System.out.println("\nSorted Results (by candidate name):");
        TreeMap<String, Integer> sorted = new TreeMap<>(voteCounts);
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue() + " votes");
        }
    }

    // Display order in which votes were cast
    public void displayVoteOrder() {
        System.out.println("\nOrder of Votes Cast:");
        for (Map.Entry<Integer, String> entry : voteOrder.entrySet()) {
            System.out.println("Vote #" + entry.getKey() + ": " + entry.getValue());
        }
    }
}
class VotingSystemMain {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        // Cast some votes
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");

        // Display outputs
        votingSystem.displayVoteCounts();
        votingSystem.displaySortedResults();
        votingSystem.displayVoteOrder();
    }
}
