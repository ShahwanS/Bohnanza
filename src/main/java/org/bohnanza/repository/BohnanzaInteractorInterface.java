package org.bohnanza.repository;

import org.bohnanza.model.Card;
import org.bohnanza.model.Player;
import org.bohnanza.services.servicesInterfaces.GameServiceInterface;
import org.bohnanza.view.BohnanzaPresenterInterface;

import java.util.List;

public interface BohnanzaInteractorInterface {
    // Sets the presenter for the interactor
    void setPresenter(BohnanzaPresenterInterface presenter);

    // Initializes the game with a list of players
    void initializeGame(List<Player> players);

    // Executes a turn for the specified player and returns success status
    boolean executePlayerTurn(Player player);

    // Updates the repository with the current list of players
    void updatePlayers(List<Player> players);

    // Retrieves the current list of players from the repository
    List<Player> getPlayers();

    // Returns the repository instance
    BohnanzaRepositoryInterface getRepository();

    // Returns the game service instance
    GameServiceInterface getGameService(); // Add this method

    // Plants a bean card in the specified field for the appropriate player
    void plantBean(Card card, int fieldIndex);
}
