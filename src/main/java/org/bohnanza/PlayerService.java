package org.bohnanza;

import java.util.List;

public class PlayerService implements PlayerServiceInterface {
    @Override
    public void plantInitialBeans(Player player) {
        if (!player.getHand().isEmpty()) {
            player.plantBean(player.getHand().get(0), 0);
        }
        if (!player.getHand().isEmpty()) {
            player.plantBean(player.getHand().get(0), 0);
        }
    }

    @Override
    public void drawCards(Player player, DeckServiceInterface deckService, int numberOfCards) {
        for (int i = 0; i < numberOfCards; i++) {
            Card card = deckService.draw();
            if (card != null) {
                player.addCardToHand(card);
            }
        }
    }

    @Override
    public void executeTrade(Player activePlayer, List<Player> players, TradeServiceInterface tradeService) {
        tradeService.trade(activePlayer, players);
    }

    @Override
    public void plantBean(Player player, Card card, int fieldIndex) {
        player.plantBean(card, fieldIndex);
    }
}