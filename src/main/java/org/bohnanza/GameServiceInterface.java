package org.bohnanza;

import java.util.List;

public interface GameServiceInterface {
    void initializeGame(List<Player> players, DeckServiceInterface deckService, GameVersion version);
    void playTurn(Player activePlayer, PhaseServiceInterface phaseService, List<Player> players);
    Player determineWinner(List<Player> players);
}