package org.bohnanza.repository;

import org.bohnanza.model.Deck;
import org.bohnanza.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BohnanzaRepository implements BohnanzaRepositoryInterface {
    private Deck deck;
    private List<Player> players;
    private Scanner scanner;

    // Constructor initializes the deck, players list, and scanner
    public BohnanzaRepository() {
        this.deck = new Deck();
        this.players = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Prompts the user to enter the number of players and returns the value
    @Override
    public int getNumberOfPlayers() {
        System.out.print("Enter the number of players: ");
        return Integer.parseInt(scanner.nextLine());
    }

    // Generates initial game data, shuffles the deck, and deals cards to players
    @Override
    public void generateInitialGameData(int numPlayers) {
        deck.shuffle();
        for (int i = 0; i < numPlayers; i++) {
            Player player = new Player("Player " + (i + 1));
            for (int j = 0; j < 5; j++) {
                player.addCardToHand(deck.draw());
            }
            players.add(player);
        }
    }

    // Returns the deck
    @Override
    public Deck getDeck() {
        return deck;
    }

    // Returns the list of players
    @Override
    public List<Player> getPlayers() {
        return players;
    }

    // Saves the current state of the deck
    @Override
    public void saveDeck(Deck deck) {
        this.deck = deck;
    }

    // Saves the current list of players
    @Override
    public void savePlayers(List<Player> players) {
        this.players = players;
    }
}
