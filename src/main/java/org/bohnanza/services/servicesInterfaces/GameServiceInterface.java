package org.bohnanza.services.servicesInterfaces;

import org.bohnanza.model.GameVersion;
import org.bohnanza.model.Player;

import java.util.List;

public interface GameServiceInterface {
    void initializeGame(List<Player> players, DeckServiceInterface deckService, GameVersion version);
    void playTurn(Player activePlayer, PhaseServiceInterface phaseService, List<Player> players);
    Player determineWinner(List<Player> players);
}