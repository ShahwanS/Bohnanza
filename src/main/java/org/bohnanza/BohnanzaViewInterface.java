package org.bohnanza;

import java.util.List;

public interface BohnanzaViewInterface {
    void setInteractor(BohnanzaInteractorInterface interactor);
    void displayWelcome();
    void displayPlayerHand(Player player);
    void displayField(Field field);
    void displayError(String message);
}