package org.bohnanza.phase;

import org.bohnanza.model.Player;

import java.util.List;

public class Phase2Trades {
    private Player activePlayer;
    private List<Player> players;

    public Phase2Trades(Player activePlayer, List<Player> players) {
        this.activePlayer = activePlayer;
        this.players = players;
    }

    public void execute() {
        System.out.println(activePlayer.getName() + " is trading.");
        // Logic for trading cards
    }
}
