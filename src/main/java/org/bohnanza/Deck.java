package org.bohnanza;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        for (BeanType beanType : BeanType.values()) {
            for (int i = 0; i < beanType.getCardCount(); i++) {
                String imageName = beanType.name().toLowerCase() + ".png"; // Placeholder image name
                String description = "Description for " + beanType.getDisplayName(); // Placeholder description
                cards.add(
                        new Card(beanType.getDisplayName(), beanType, beanType.getCardCount(), imageName, description));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        }
        return null;
    }
}
