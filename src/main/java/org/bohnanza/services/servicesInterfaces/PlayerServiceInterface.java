package org.bohnanza.services.servicesInterfaces;

import org.bohnanza.model.Card;
import org.bohnanza.model.Player;

import java.util.List;

public interface PlayerServiceInterface {
    void plantInitialBeans(Player player);
    void drawCards(Player player, DeckServiceInterface deckService, int numberOfCards);
    void executeTrade(Player activePlayer, List<Player> players, TradeServiceInterface tradeService);
    void plantBean(Player player, Card card, int fieldIndex);  // Added method
}