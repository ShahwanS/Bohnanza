package org.bohnanza.services.servicesInterfaces;

import org.bohnanza.model.Player;

import java.util.List;

public interface PhaseServiceInterface {
    void executePlantPhase(Player player);
    void executeTradePhase(Player activePlayer, List<Player> players);
    void executePlantAllPlayersPhase(List<Player> players);
    void executeDrawPhase(Player player);
}