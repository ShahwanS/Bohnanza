package org.bohnanza;

public class BohnanzaInteractor {
    private BohnanzaRepository repository;
    private BohnanzaPresenter presenter;

    public BohnanzaInteractor(BohnanzaRepository repository, BohnanzaPresenter presenter) {
        this.repository = repository;
        this.presenter = presenter;
    }

    // Method to draw a card
    public void drawCard() {
        String cardInfo = String.valueOf(repository.getDeck().drawCard());
        presenter.presentCardDrawn(cardInfo);
    }

    // Method to shuffle the deck
    public void shuffleDeck() {
        repository.getDeck().shuffle();
        presenter.presentDeckShuffled();
    }

    // Method to add a card to a field
    public void addCardToField(Card card, String fieldName) {
        repository.getField(fieldName).addCard(card);
        presenter.presentCardAddedToField(card, fieldName);
    }

    // Method to make an exchange offer
    public void makeExchangeOffer(String offerInfo) {
        presenter.presentExchangeOffer(offerInfo);
    }

    // Method to accept an exchange offer
    public void acceptExchangeOffer(String offerInfo) {
        // Implement logic to accept exchange offer
    }
}