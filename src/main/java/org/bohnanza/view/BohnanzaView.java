package org.bohnanza.view;

import org.bohnanza.repository.BohnanzaInteractorInterface;
import org.bohnanza.model.Card;
import org.bohnanza.model.Field;
import org.bohnanza.model.Player;

public class BohnanzaView implements BohnanzaViewInterface {
    private BohnanzaInteractorInterface interactor;

    // Sets the interactor for the view
    @Override
    public void setInteractor(BohnanzaInteractorInterface interactor) {
        this.interactor = interactor;
    }

    // Displays a welcome message
    @Override
    public void displayWelcome() {
        System.out.println("Welcome to Bohnanza!");
    }

    // Displays the player's hand
    @Override
    public void displayPlayerHand(Player player) {
        System.out.println(player.getName() + "'s hand:");
        for (Card card : player.getHand()) {
            System.out.println(" - " + card.getBeanType().getName());
        }
    }

    // Displays the beans in a field
    @Override
    public void displayField(Field field) {
        System.out.print("Field beans: ");
        field.getBeans().forEach(card ->
                System.out.print(card.getBeanType().getName() + " ")
        );
        System.out.println();
    }

    // Displays an error message
    @Override
    public void displayError(String message) {
        System.out.println("Error: " + message);
    }

    // Displays the current player's turn and executes their turn
    @Override
    public void displayTurn(Player player) {
        System.out.println("It's " + player.getName() + "'s turn.");
        interactor.executePlayerTurn(player);
    }

    // Plants a bean card in the specified field for the appropriate player
    public void plantBean(Card card, int fieldIndex) {
        interactor.getPlayers().stream()
                .filter(player -> player.getHand().contains(card))
                .findFirst()
                .ifPresent(player -> interactor.plantBean(card, fieldIndex));
    }
}
