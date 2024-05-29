package org.bohnanza.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;
    private List<Field> fields;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.fields = new ArrayList<>();
        this.fields.add(new Field());
        this.fields.add(new Field()); // Assuming each player starts with two fields
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public void plantBean(Card card, int fieldIndex) {
        if (hand.contains(card) && fieldIndex < fields.size() && fields.get(fieldIndex).isCompatible(card)) {
            fields.get(fieldIndex).plantBean(card);
            hand.remove(card);
        } else {
            // Handle incompatible planting, e.g., notify player
            System.out.println("Incompatible bean type. Cannot plant in this field or card not in hand.");
        }
    }

    public void harvestField(int fieldIndex) {
        if (fieldIndex < fields.size()) {
            List<Card> harvested = fields.get(fieldIndex).harvest();
            // Handle harvested beans, e.g., convert to bean dollars
        }
    }

    public void plantInitialBeans() {
        if (!hand.isEmpty()) {
            plantBean(hand.get(0), 0);
        }
        if (!hand.isEmpty()) {
            plantBean(hand.get(0), 0);
        }
    }

    public void drawCards(Deck deck, int numberOfCards) {
        for (int i = 0; i < numberOfCards; i++) {
            addCardToHand(deck.draw());
        }
    }

    public int harvestAllFields() {
        int totalBeans = 0;
        for (Field field : fields) {
            totalBeans += field.getBeanCount();
            field.harvest();
        }
        return totalBeans;
    }
}