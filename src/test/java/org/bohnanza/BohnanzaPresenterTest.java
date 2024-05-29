package org.bohnanza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//class BohnanzaPresenterTest {
//    private BohnanzaView view;
//    private BohnanzaPresenter presenter;
//
//    @BeforeEach
//    void setUp() {
//
//        view = new BohnanzaView();
//        presenter = new BohnanzaPresenter(view);
//    }
//
//    @Test
//    void presentCardDrawn() {
//        // Given
//        String cardInfo = "Soy Bean, 5 points";
//
//        // When
//        presenter.presentCardDrawn(cardInfo);
//
//        // Then
//        assertTrue(view.messages.contains("Card drawn: " + cardInfo));
//    }
//
//    @Test
//    void presentDeckShuffled() {
//        // When
//        presenter.presentDeckShuffled();
//
//        // Then
//        assertTrue(view.messages.contains("Deck shuffled."));
//    }
//
//    @Test
//    void presentCardAddedToField() {
//        // Given
//        Card card = new Card("Green Bean", BeanType.GREEN_BEAN, 3, "image_url", "Great for salads");
//        String fieldName = "Field 1";
//
//        // When
//        presenter.presentCardAddedToField(card, fieldName);
//
//        // Then
//        assertTrue(view.messages.contains("Card " + card.toString() + " added to field " + fieldName + "."));
//    }
//
//    @Test
//    void presentExchangeOffer() {
//        // Given
//        String offerInfo = "Trade 2 Soy Beans for 1 Coffee Bean";
//
//        // When
//        presenter.presentExchangeOffer(offerInfo);
//
//        // Then
//        assertTrue(view.messages.contains("Exchange offer: " + offerInfo));
//    }
//}
