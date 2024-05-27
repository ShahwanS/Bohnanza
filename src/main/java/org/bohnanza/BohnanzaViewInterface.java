package org.bohnanza;

public interface BohnanzaViewInterface {
    void setInteractor(BohnanzaInteractorInterface interactor);
    void displayWelcome();
    void displayPlayerHand(Player player);
    void displayField(Field field);
    void displayError(String message);
    void displayTurn(Player player);
}