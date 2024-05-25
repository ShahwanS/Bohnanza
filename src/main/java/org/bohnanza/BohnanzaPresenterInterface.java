package org.bohnanza;

public interface BohnanzaPresenterInterface {
    void setView(BohnanzaViewInterface view);
    void startGame();
    void presentUpdatedData(Player player);
    void presentError(String message);
}