package org.bohnanza.services;

import org.bohnanza.model.Card;
import org.bohnanza.model.Player;
import org.bohnanza.services.servicesInterfaces.DeckServiceInterface;
import org.bohnanza.services.servicesInterfaces.PlayerServiceInterface;
import org.bohnanza.services.servicesInterfaces.TradeServiceInterface;

import java.util.List;

public class PlayerService implements PlayerServiceInterface {

    // Plants initial beans for the player
    @Override
    public void plantInitialBeans(Player player) {
        if (!player.getHand().isEmpty()) {
            player.plantBean(player.getHand().get(0), 0);
        }
        if (!player.getHand().isEmpty()) {
            player.plantBean(player.getHand().get(0), 0);
        }
    }

    // Draws a specified number of cards for the player from the deck
    @Override
    public void drawCards(Player player, DeckServiceInterface deckService, int numberOfCards) {
        for (int i = 0; i < numberOfCards; i++) {
            Card card = deckService.draw();
            if (card != null) {
                player.addCardToHand(card);
            }
        }
    }

    // Executes a trade phase for the active player with other players
    @Override
    public void executeTrade(Player activePlayer, List<Player> players, TradeServiceInterface tradeService) {
        tradeService.trade(activePlayer, players);
    }

    // Plants a bean card in the specified field for the player
    @Override
    public void plantBean(Player player, Card card, int fieldIndex) {
        player.plantBean(card, fieldIndex);
    }
}