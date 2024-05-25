package org.bohnanza;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BohnanzaRepository implements BohnanzaRepositoryInterface {
    private Deck deck;
    private List<Player> players;
    private Scanner scanner;

    public BohnanzaRepository() {
        this.deck = new Deck();
        this.players = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int getNumberOfPlayers() {
        System.out.print("Enter the number of players: ");
        return Integer.parseInt(scanner.nextLine());
    }

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

    @Override
    public Deck getDeck() {
        return deck;
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public void saveDeck(Deck deck) {
        this.deck = deck;
    }

    @Override
    public void savePlayers(List<Player> players) {
        this.players = players;
    }
}