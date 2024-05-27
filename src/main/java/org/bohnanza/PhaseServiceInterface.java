package org.bohnanza;

import java.util.List;

public interface PhaseServiceInterface {
    void executePlantPhase(Player player);
    void executeTradePhase(Player activePlayer, List<Player> players);
    void executePlantAllPlayersPhase(List<Player> players);
    void executeDrawPhase(Player player);
}