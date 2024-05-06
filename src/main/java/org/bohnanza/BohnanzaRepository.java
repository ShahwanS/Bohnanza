package org.bohnanza;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BohnanzaRepository {
    private Deck deck;
    private List<Field> fields;
    private Scanner scanner;

    public BohnanzaRepository() {
        this.deck = new Deck();
        this.fields = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Method to get number of players from user
    public int getNumberOfPlayers() {
        System.out.print("Enter the number of players: ");
        return Integer.parseInt(scanner.nextLine());
    }

    // Method to generate initial game data
    public void generateInitialGameData(int numPlayers) {
        // Generate fields for each player
        for (int i = 1; i <= numPlayers; i++) {
            fields.add(new Field("Field " + i));
        }

        // Shuffle and distribute cards to players
        deck.shuffle();
        for (Field field : fields) {
            for (int i = 0; i < 5; i++) {
                Card card = deck.drawCard();
                field.addCard(card);
            }
        }
    }

    // Method to get the deck
    public Deck getDeck() {
        return deck;
    }

    // Method to get the fields
    public List<Field> getFields() {
        return fields;
    }

    // Method to save the deck
    public void saveDeck(Deck deck) {
        this.deck = deck;
    }

    // Method to save the fields
    public void saveFields(List<Field> fields) {
        this.fields = fields;
    }


    public Field getField(String fieldName) {
        for (Field field : fields) {
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }
        return null;
    }


}
