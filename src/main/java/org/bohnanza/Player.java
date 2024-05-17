package org.bohnanza;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;
    private List<Field> fields;
    private int coins;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.fields = new ArrayList<>();
        this.fields.add(new Field("Field 1"));
        this.fields.add(new Field("Field 2"));
        this.coins = 0;
    }

    // Draw a card from the deck
    public void drawCard(Deck deck) {
        for (int i = 0; i <= 5; i++) {
            Card card = deck.drawCard();
            if (card != null) {
                hand.add(card);
            }
        }

    }

    // Plant a card in a specific field
    public boolean plantCard(Card card, int fieldIndex) {
        if (fieldIndex < fields.size()) {
            return fields.get(fieldIndex).plantCard(card);
        }
        return false;
    }

    // Buy a new field (costs 3 coins)
    public boolean buyField() {
        if (coins >= 3) {
            fields.add(new Field("Field " + (fields.size() + 1)));
            coins -= 3;
            return true;
        }
        return false;
    }

    // Harvest a field
    public int harvestField(int fieldIndex) {
        if (fieldIndex < fields.size()) {
            int earnedCoins = fields.get(fieldIndex).harvest();
            coins += earnedCoins;
            return earnedCoins;
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return new ArrayList<>(hand);
    }

    public List<Field> getFields() {
        return new ArrayList<>(fields);
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}
