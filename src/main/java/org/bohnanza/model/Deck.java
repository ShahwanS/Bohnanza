package org.bohnanza.model;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    private Stack<Card> cards;

    public Deck() {
        cards = new Stack<>();
        initializeDeck();
        shuffle();
    }

    private void initializeDeck() {
        // Initialize the deck with the appropriate number of each type of bean card
        for (BeanType type : BeanType.values()) {
            int count = getBeanCount(type);
            for (int i = 0; i < count; i++) {
                cards.push(new Card(type));
            }
        }
    }

    // Shuffle the deck of cards
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Draw a card from the deck
    public Card draw() {
        return cards.isEmpty() ? null : cards.pop();
    }

    // Helper method to determine the number of each type of bean card
    private int getBeanCount(BeanType type) {
        // Example counts based on hypothetical game rules
        switch (type) {
            case GARDEN_BEAN:
                return 6;
            case RED_BEAN:
                return 8;
            case BLACK_EYED_BEAN:
                return 10;
            case SOY_BEAN:
                return 14;
            case GREEN_BEAN:
                return 12;
            case STINK_BEAN:
                return 14;
            case CHILI_BEAN:
                return 18;
            case BLUE_BEAN:
                return 20;
            case WAX_BEAN:
                return 22;
            case COFFEE_BEAN:
                return 24;
            default:
                return 0;
        }
    }

    // Check if the deck is empty
    public boolean isEmpty() {
        return cards.isEmpty();
    }
}