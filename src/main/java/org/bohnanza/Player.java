package org.bohnanza;

import java.util.ArrayList;
import java.util.List;

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

    public void plantBeanFromHand(int fieldIndex) {
        if (fieldIndex < fields.size() && fields.get(fieldIndex).isCompatible(hand.get(0))) {
            fields.get(fieldIndex).plantBean(hand.remove(0));
        } else {
            // Handle incompatible planting
        }
    }

    public void harvestField(int fieldIndex) {
        if (fieldIndex < fields.size()) {
            List<Card> harvested = fields.get(fieldIndex).harvest();
            // Handle harvested beans, e.g., convert to bean dollars
        }
    }
}