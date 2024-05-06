package org.bohnanza;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Field {
    private String name;
    private List<Card> cards;

    public Field(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    // Method to add a card to the field
    public void addCard(Card card) {
        cards.add(card);
    }

    public String getName() {
        return name;
    }

    public Map<Object, Object> getCards() {
        return null;
    }


    // Other methods as needed
}

