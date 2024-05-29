package org.bohnanza.services;

import org.bohnanza.*;
import org.bohnanza.model.GameVersion;
import org.bohnanza.model.Player;
import org.bohnanza.services.servicesInterfaces.DeckServiceInterface;
import org.bohnanza.services.servicesInterfaces.GameServiceInterface;
import org.bohnanza.services.servicesInterfaces.PhaseServiceInterface;

import java.util.List;

public class GameService implements GameServiceInterface {
    private AppAnalytics appAnalytics = AppAnalytics.getInstance();

    // Initializes the game with the given players, deck, and game version
    @Override
    public void initializeGame(List<Player> players, DeckServiceInterface deckService, GameVersion version) {
        appAnalytics.recordPlayerCount(players.size());
        int totalCards = 0;
        for (Player player : players) {
            for (int i = 0; i < 5; i++) {
                player.addCardToHand(deckService.draw());
                totalCards++;
            }
        }
        appAnalytics.recordTotalCards(totalCards);
    }

    // Executes a player's turn using the phase service and updates all players
    @Override
    public void playTurn(Player activePlayer, PhaseServiceInterface phaseService, List<Player> players) {
        phaseService.executePlantPhase(activePlayer);
        phaseService.executeTradePhase(activePlayer, players);
        phaseService.executePlantAllPlayersPhase(players);
        phaseService.executeDrawPhase(activePlayer);
    }

    // Determines the winner based on the app analytics
    @Override
    public Player determineWinner(List<Player> players) {
        return appAnalytics.determineWinner(players);
    }
}
