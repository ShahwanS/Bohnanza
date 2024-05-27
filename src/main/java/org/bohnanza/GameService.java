package org.bohnanza;

import java.util.List;

public class GameService implements GameServiceInterface {
    private AppAnalytics appAnalytics = AppAnalytics.getInstance();

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

    @Override
    public void playTurn(Player activePlayer, PhaseServiceInterface phaseService, List<Player> players) {
        phaseService.executePlantPhase(activePlayer);
        phaseService.executeTradePhase(activePlayer, players);
        phaseService.executePlantAllPlayersPhase(players);
        phaseService.executeDrawPhase(activePlayer);
    }

    @Override
    public Player determineWinner(List<Player> players) {
        return appAnalytics.determineWinner(players);
    }
}