package org.bohnanza;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private String name;
    private List<Card> cards;

    public Field(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    // plant a card if the field is empty or if the card matches the type
    public boolean plantCard(Card card) {
        if (canPlant(card)) {
            cards.add(card);
            return true;
        } else {
            return false;
        }
    }

    // Harvest the field and calculate the number of coins earned
    public int harvest() {
        if (cards.isEmpty()) {
            return 0;
        }

        BeanType type = cards.get(0).getBeanType();
        int size = cards.size();
        int coins = type.getPayout(size);

        cards.clear(); // Remove all cards from the field after harvesting
        return coins;
    }

    // Check if the field can plant this type of card
    public boolean canPlant(Card card) {
        return cards.isEmpty() || cards.get(0).getBeanType() == card.getBeanType();
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

}
