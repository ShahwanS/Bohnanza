package org.bohnanza;

import java.util.LinkedList;
import java.util.List;


public class PlayerHand {
    private LinkedList<Card> cards;
    private Player player;

    public PlayerHand(Player player) {
        this.player = player;
        this.cards = new LinkedList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
        player.addCardToHand(card);
    }

    public void plantBean(Card card, int fieldIndex) {
        if (cards.contains(card)) {
            player.plantBean(card, fieldIndex);
            cards.remove(card);
        } else {
            // Handle case where the card is not in the hand
            System.out.println("Card not found in hand.");
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "PlayerHand{" +
                "cards=" + cards +
                '}';
    }
}