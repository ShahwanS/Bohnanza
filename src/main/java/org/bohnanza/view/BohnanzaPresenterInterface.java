package org.bohnanza.view;

import org.bohnanza.model.Player;

public interface BohnanzaPresenterInterface {
    // Sets the view for the presenter
    void setView(BohnanzaViewInterface view);

    // Starts the game by displaying a welcome message
    void startGame();

    // Updates the view with the player's hand and fields
    void presentUpdatedData(Player player);

    // Displays an error message on the view
    void presentError(String message);
}
