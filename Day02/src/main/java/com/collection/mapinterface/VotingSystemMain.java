package com.collection.mapinterface;

import java.util.*;

class VotingSystem {
    // Stores votes for candidates
    private Map<String, Integer> voteMap = new HashMap<>();
    // Maintains voting order
    private LinkedHashMap<String, Integer> votingOrder = new LinkedHashMap<>();
    // Sorted results
    private TreeMap<String, Integer> sortedResults = new TreeMap<>();

    // Method to cast a vote
    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        votingOrder.put(candidate, voteMap.get(candidate));
        sortedResults.put(candidate, voteMap.get(candidate));
    }

    // Display votes in the order they were cast
    public void displayVotingOrder() {
        System.out.println("\nVoting Order:");
        for (Map.Entry<String, Integer> entry : votingOrder.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }

    // Display results sorted by candidate name
    public void displaySortedResults() {
        System.out.println("\nSorted Results (by Candidate Name):");
        for (Map.Entry<String, Integer> entry : sortedResults.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }

    // Display results sorted by number of votes (descending order)
    public void displayResultsByVotes() {
        System.out.println("\nFinal Election Results (by Votes - Descending):");
        voteMap.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue())) // Sort by votes descending
                .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes"));
    }
}

public class VotingSystemMain {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        // Cast votes
        votingSystem.castVote("Raj");
        votingSystem.castVote("Ram");
        votingSystem.castVote("Raj");
        votingSystem.castVote("Harsh");
        votingSystem.castVote("Ram");
        votingSystem.castVote("Raj");

        // Display voting order
        votingSystem.displayVotingOrder();

        // Display sorted results by candidate name
        votingSystem.displaySortedResults();

        // Display final election results sorted by number of votes
        votingSystem.displayResultsByVotes();
    }
}