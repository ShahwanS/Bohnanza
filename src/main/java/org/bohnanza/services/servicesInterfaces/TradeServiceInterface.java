package org.bohnanza.services.servicesInterfaces;

import org.bohnanza.model.Player;

import java.util.List;

public interface TradeServiceInterface {
    void trade(Player activePlayer, List<Player> players);
}