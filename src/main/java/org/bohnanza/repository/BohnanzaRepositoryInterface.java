package org.bohnanza.repository;

import org.bohnanza.model.Deck;
import org.bohnanza.model.Player;

import java.util.List;

public interface BohnanzaRepositoryInterface {
    int getNumberOfPlayers();
    void generateInitialGameData(int numPlayers);
    Deck getDeck();
    List<Player> getPlayers();
    void saveDeck(Deck deck);
    void savePlayers(List<Player> players);
}