package org.bohnanza;

import org.bohnanza.model.Card;
import org.bohnanza.model.Player;

public class Trade {
    private Player player;
    private Card card;

    public Trade(Player player, Card card) {
        this.player = player;
        this.card = card;
    }

    public Player getPlayer() {
        return player;
    }

    public Card getCard() {
        return card;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "player=" + player +
                ", card=" + card +
                '}';
    }
}
