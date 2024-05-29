package org.bohnanza.services;

import org.bohnanza.model.BeanType;
import org.bohnanza.model.Card;
import org.bohnanza.services.servicesInterfaces.DeckServiceInterface;

import java.util.Collections;
import java.util.Stack;

public class DeckService implements DeckServiceInterface {
    private Stack<Card> cards;

    // Constructor initializes the deck and shuffles the cards
    public DeckService() {
        this.cards = new Stack<>();
        initializeDeck();
        shuffle();
    }

    // Initializes the deck with the appropriate number of each type of bean card
    @Override
    public void initializeDeck() {
        for (BeanType type : BeanType.values()) {
            int count = getBeanCount(type);
            for (int i = 0; i < count; i++) {
                cards.push(new Card(type));
            }
        }
    }

    // Shuffles the deck of cards
    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Draws a card from the deck
    @Override
    public Card draw() {
        return cards.isEmpty() ? null : cards.pop();
    }

    // Determines the number of each type of bean card
    private int getBeanCount(BeanType type) {
        switch (type) {
            case GARDEN_BEAN: return 6;
            case RED_BEAN: return 8;
            case BLACK_EYED_BEAN: return 10;
            case SOY_BEAN: return 14;
            case GREEN_BEAN: return 12;
            case STINK_BEAN: return 14;
            case CHILI_BEAN: return 18;
            case BLUE_BEAN: return 20;
            case WAX_BEAN: return 22;
            case COFFEE_BEAN: return 24;
            default: return 0;
        }
    }
}