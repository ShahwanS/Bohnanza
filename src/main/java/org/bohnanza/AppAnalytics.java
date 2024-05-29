package org.bohnanza;

import org.bohnanza.model.Player;

import java.util.List;

public class AppAnalytics {
    // Singleton instance of AppAnalytics
    private static AppAnalytics instance;
    // Number of players in the game
    private int playerCount;
    // Total number of cards in the game
    private int totalCards;

    // Private constructor to prevent instantiation
    private AppAnalytics() {
    }

    // Returns the singleton instance, creates it if it doesn't exist
    public static synchronized AppAnalytics getInstance() {
        if (instance == null) {
            instance = new AppAnalytics();
        }
        return instance;
    }

    // Records the number of players
    public void recordPlayerCount(int count) {
        this.playerCount = count;
    }

    // Records the total number of cards
    public void recordTotalCards(int total) {
        this.totalCards = total;
    }

    // Returns the number of players
    public int getPlayerCount() {
        return playerCount;
    }

    // Returns the total number of cards
    public int getTotalCards() {
        return totalCards;
    }

    // Determines the winner based on the maximum beans harvested
    public Player determineWinner(List<Player> players) {
        Player winner = null;
        int maxBeans = 0;

        for (Player player : players) {
            int beansHarvested = player.harvestAllFields();
            if (beansHarvested > maxBeans) {
                maxBeans = beansHarvested;
                winner = player;
            }
        }

        return winner;
    }
}
