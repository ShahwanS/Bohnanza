package org.bohnanza;

public class BohnanzaView implements BohnanzaViewInterface {
    private BohnanzaInteractorInterface interactor;

    @Override
    public void setInteractor(BohnanzaInteractorInterface interactor) {
        this.interactor = interactor;
    }

    @Override
    public void displayWelcome() {
        System.out.println("Welcome to Bohnanza!");
    }

    @Override
    public void displayPlayerHand(Player player) {
        System.out.println(player.getName() + "'s hand:");
        for (Card card : player.getHand()) {
            System.out.println(" - " + card.getBeanType().getName());
        }
    }

    @Override
    public void displayField(Field field) {
        System.out.print("Field beans: ");
        for (Card card : field.getBeans()) {
            System.out.print(card.getBeanType().getName() + " ");
        }
        System.out.println();
    }

    @Override
    public void displayError(String message) {
        System.out.println("Error: " + message);
    }

    @Override
    public void displayTurn(Player player) {
        System.out.println("It's " + player.getName() + "'s turn.");
        interactor.executePlayerTurn(player);
    }

    public void plantBean(Card card, int fieldIndex) {
        interactor.getPlayers().stream()
                .filter(player -> player.getHand().contains(card))
                .findFirst()
                .ifPresent(player -> interactor.plantBean(card, fieldIndex));
    }
}