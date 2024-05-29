package org.bohnanza.model;

import java.util.LinkedList;
import java.util.List;

public class PlayerHand {
    private LinkedList<Card> cards;
    private Player player;

    // Constructor initializes the player's hand and links it to the player
    public PlayerHand(Player player) {
        this.player = player;
        this.cards = new LinkedList<>();
    }

    // Adds a card to the hand and the player's hand
    public void addCard(Card card) {
        cards.add(card);
        player.addCardToHand(card);
    }

    // Plants a bean card in the specified field if the card is in the hand
    public void plantBean(Card card, int fieldIndex) {
        if (cards.contains(card)) {
            player.plantBean(card, fieldIndex);
            cards.remove(card);
        } else {
            // Handle case where the card is not in the hand
            System.out.println("Card not found in hand.");
        }
    }

    // Returns the list of cards in the hand
    public List<Card> getCards() {
        return cards;
    }

    // Provides a string representation of the player's hand
    @Override
    public String toString() {
        return "PlayerHand{" +
                "cards=" + cards +
                '}';
    }
}