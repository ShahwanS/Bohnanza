package org.bohnanza.phase;

import org.bohnanza.model.Deck;
import org.bohnanza.model.Player;

public class Phase4DrawCardsActivePlayer {
    private Player player;
    private Deck deck;

    public Phase4DrawCardsActivePlayer(Player player, Deck deck) {
        this.player = player;
        this.deck = deck;
    }

    public void execute() {
        System.out.println(player.getName() + " is drawing 3 cards.");
        player.drawCards(deck, 3);
    }
}
