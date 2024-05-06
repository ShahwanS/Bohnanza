package org.bohnanza;

public class BohnanzaPresenter {
    private BohnanzaView view;

    public BohnanzaPresenter(BohnanzaView view) {
        this.view = view;
    }

    // Method to present a drawn card
    public void presentCardDrawn(String cardInfo) {
        view.displayCardDrawn(cardInfo);
    }

    // Method to present a shuffled deck
    public void presentDeckShuffled() {
        view.displayDeckShuffled();
    }

    // Method to present a card added to a field
    public void presentCardAddedToField(Card card, String fieldName) {
        String cardInfo = card.toString(); // Custom method to get card information
        view.displayCardAddedToField(cardInfo, fieldName);
    }

    // Method to present an exchange offer
    public void presentExchangeOffer(String offerInfo) {
        view.displayExchangeOffer(offerInfo);
    }
}
