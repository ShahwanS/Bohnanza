package org.bohnanza;

public class BohnanzaPresenter implements BohnanzaPresenterInterface {
    private BohnanzaViewInterface view;

    public BohnanzaPresenter(BohnanzaViewInterface view) {
        this.view = view;
    }

    @Override
    public void setView(BohnanzaViewInterface view) {
        this.view = view;
    }

    @Override
    public void startGame() {
        if (view != null) {
            view.displayWelcome();
        }
    }

    @Override
    public void presentUpdatedData(Player player) {
        if (view != null) {
            view.displayPlayerHand(player);
            for (Field field : player.getFields()) {
                view.displayField(field);
            }
        }
    }

    @Override
    public void presentError(String message) {
        if (view != null) {
            view.displayError(message);
        }
    }
}