package org.bohnanza;

import java.util.List;

public interface BohnanzaInteractorInterface {
    void setPresenter(BohnanzaPresenterInterface presenter);
    void initializeGame(List<Player> players);
    boolean executePlayerTurn(Player player);
    void updatePlayers(List<Player> players);
    List<Player> getPlayers();
    BohnanzaRepositoryInterface getRepository();
    GameServiceInterface getGameService(); // Add this method
    void plantBean(Card card, int fieldIndex);
}