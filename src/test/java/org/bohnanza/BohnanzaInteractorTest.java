package org.bohnanza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BohnanzaInteractorTest {
    private BohnanzaRepository repository;
    private BohnanzaPresenter presenter;
    private BohnanzaInteractor interactor;

    @BeforeEach
    void setUp() {
        repository = new BohnanzaRepository() {
            final Deck deck = new Deck() {
                private final java.util.List<Card> cards = new java.util.ArrayList<>();

                @Override
                public Card drawCard() {
                    return cards.isEmpty() ? null : cards.removeFirst();
                }

                @Override
                public void shuffle() {
                    java.util.Collections.shuffle(cards);
                }

                {
                    // Populate the deck with multiple cards for meaningful shuffle
                    cards.add(new Card("Test Card 1", BeanType.SOY_BEAN, 1, "image_url", "description"));
                    cards.add(new Card("Test Card 2", BeanType.RED_BEAN, 2, "another_image_url", "another_description"));
                }
            };

            @Override
            public Deck getDeck() {
                return deck;
            }
        };

        presenter = new BohnanzaPresenter(new BohnanzaView());
        interactor = new BohnanzaInteractor(repository, presenter);
    }

    @Test
    void drawCard() {
        // Get the initial number of cards in the deck
        int initialCardCount = ((Deck) repository.getDeck()).cards.size();

        // Draw a card
        interactor.drawCard();

        // Get the number of cards after drawing one card
        int afterDrawCardCount = ((Deck) repository.getDeck()).cards.size();

        // Check that the number of cards decreased by 1
        assertEquals(initialCardCount - 1, afterDrawCardCount, "The number of cards should decrease by 1 after drawing a card");
    }

    @Test
    void shuffleDeck() {
        Deck originalDeck = repository.getDeck();

        // Shuffle the deck
        interactor.shuffleDeck();

        assertSame(originalDeck, repository.getDeck(), "The deck should be the same reference after shuffling");
    }

    @Test
    void addCardToField() {
        // Create a new card and specify the field name
        Card testCard = new Card("Test Card", BeanType.GREEN_BEAN, 5, "test_image", "Test Description");
        String fieldName = "Field 1";
        interactor.addCardToField(testCard, fieldName);
        //assert if card has been added to the field
        Field field = repository.getField(fieldName);
        assertEquals(1, field.getCards().size(), "Field should contain exactly one card");
        assertEquals(testCard, field.getCards().get(0), "The card in the field should be the one that was added");
    }

    @Test
    void makeExchangeOffer() {
        String offerInfo = "Offer 5 beans for 3 coins";
        interactor.makeExchangeOffer(offerInfo);

    }

    @Test
    void acceptExchangeOffer() {
        String offerInfo = "Accepting 5 beans for 3 coins";
        interactor.acceptExchangeOffer(offerInfo);

    }
}
