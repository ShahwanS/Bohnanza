package org.bohnanza;

import java.util.List;

public class AppAnalytics {
    private static AppAnalytics instance;
    private int playerCount;
    private int totalCards;

    private AppAnalytics() {
    }

    public static synchronized AppAnalytics getInstance() {
        if (instance == null) {
            instance = new AppAnalytics();
        }
        return instance;
    }

    public void recordPlayerCount(int count) {
        this.playerCount = count;
    }

    public void recordTotalCards(int total) {
        this.totalCards = total;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public int getTotalCards() {
        return totalCards;
    }

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