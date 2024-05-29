package org.bohnanza;

import org.bohnanza.model.Deck;
import org.bohnanza.model.GameVersion;
import org.bohnanza.model.Player;

import java.util.List;

public class Game {
    private List<Player> players;
    private Deck deck;
    private GameVersion version;

    public Game(List<Player> players, Deck deck, GameVersion version) {
        this.players = players;
        this.deck = deck;
        this.version = version;
    }

    public void start() {
        // Logic to start the game
    }

    public void playTurn(Player activePlayer) {
        // Logic for a player's turn
    }

    public Player determineWinner() {
        // Logic to determine the winner
        return null;
    }
}
