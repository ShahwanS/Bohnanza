package org.bohnanza;

import java.util.Collections;
import java.util.Stack;

public class DeckService implements DeckServiceInterface {
    private Stack<Card> cards;

    public DeckService() {
        this.cards = new Stack<>();
        initializeDeck();
        shuffle();
    }

    @Override
    public void initializeDeck() {
        for (BeanType type : BeanType.values()) {
            int count = getBeanCount(type);
            for (int i = 0; i < count; i++) {
                cards.push(new Card(type));
            }
        }
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public Card draw() {
        return cards.isEmpty() ? null : cards.pop();
    }

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