package org.bohnanza.view;

import org.bohnanza.model.Field;
import org.bohnanza.model.Player;

public class BohnanzaPresenter implements BohnanzaPresenterInterface {
    // Reference to the view interface
    private BohnanzaViewInterface view;

    // Constructor to initialize the presenter with a view
    public BohnanzaPresenter(BohnanzaViewInterface view) {
        this.view = view;
    }

    // Sets the view for the presenter
    @Override
    public void setView(BohnanzaViewInterface view) {
        this.view = view;
    }

    // Starts the game by displaying a welcome message
    @Override
    public void startGame() {
        if (view != null) {
            view.displayWelcome();
        }
    }

    // Presents updated data for a player, including their hand and fields
    @Override
    public void presentUpdatedData(Player player) {
        if (view != null) {
            view.displayPlayerHand(player);
            for (Field field : player.getFields()) {
                view.displayField(field);
            }
        }
    }

    // Presents an error message on the view
    @Override
    public void presentError(String message) {
        if (view != null) {
            view.displayError(message);
        }
    }
}
