package org.bohnanza.view;

import org.bohnanza.repository.BohnanzaInteractorInterface;
import org.bohnanza.model.Field;
import org.bohnanza.model.Player;

public interface BohnanzaViewInterface {
    void setInteractor(BohnanzaInteractorInterface interactor);
    void displayWelcome();
    void displayPlayerHand(Player player);
    void displayField(Field field);
    void displayError(String message);
    void displayTurn(Player player);
}